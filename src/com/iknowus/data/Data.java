package com.iknowus.data;

import static ch.lambdaj.Lambda.join;
import static ch.lambdaj.Lambda.selectDistinct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iknowus.entities.Enumerators.Status;
import com.iknowus.util.Log;

abstract public class Data<T> extends Wrapper<T> {

	protected Connection connection;
	private Statement statement = null;
	private ResultSet result = null;

	public Data(Class<T> type, Connection connection) {
		super(type, connection);
		this.connection = connection;
	}

	protected Integer count(String strQuery) {
		ResultSet result = null;		
		try {
			Log.debug(strQuery);
			result = getList(strQuery);
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (Exception e) {
			Log.error("No se pudo ejecutrar la consulta : " + strQuery + "-->" + e, e);
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					Log.error("No se pudo cerrar conexion ResultSet:" + e, e);
				}
			}

		}
		return -1;
	}
	
	protected T search(String strQuery) {
		ResultSet result = null;
		T entity = null;
		try {
			Log.debug(strQuery);
			result = getList(strQuery);
			while (result.next()) {
				entity = (T) this.loadEntity(result);
			}
		} catch (Exception e) {
			Log.error("No se pudo ejecutrar la consulta : " + strQuery + "-->" + e, e);
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					Log.error("No se pudo cerrar conexion ResultSet:" + e, e);
				}
			}

		}
		return entity;
	}

	private ResultSet getList(String query) throws SQLException {
		statement = connection.createStatement();
		try {
			result = statement.executeQuery(query);
		} catch (Exception e) {
			Log.error("No se pudo ejecutrar la consulta : " + query + "-->" + e, e);
		}
		return result;
	}

	protected List<T> list(String query) {
		List<T> Col = new ArrayList<T>();
		ResultSet result = null;
		try {
			result = getList(query);
			Log.debug(query);
			while (result.next()) {
				Col.add((T) this.loadEntity(result));
			}
		} catch (Exception e) {
			Log.error("No se pudo ejecutar la consulta : " + query + "-->" + e, e);
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					Log.error("No se pudo cerrar conexion ResultSet:" + e, e);
				}
			}
		}
		return Col;
	}
	
	protected List<Long> listKeys(String query) {
		List<Long> keys = new ArrayList<Long>();
		ResultSet result = null;
		try {
			result = getList(query);
			Log.debug(query);
			while (result.next()) {
				keys.add(result.getLong("id")); 
			}
		} catch (Exception e) {
			Log.error("No se pudo ejecutar la consulta : " + query + "-->" + e, e);
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					Log.error("No se pudo cerrar conexion ResultSet:" + e, e);
				}
			}
		}
		return keys;
	}

	protected <E extends Object> String concatenaLlaves(List<E> llaves) {
		return ((!llaves.isEmpty()) ? "(" + join(selectDistinct(llaves).toArray(), ", ") + ")" : "(0)");
	}

	public <O extends Object> List<T> listarLlave(List<O> llaves) {
		if (llaves == null || llaves.isEmpty()) {
			return new ArrayList<T>();
		}

		String query = String.format("SELECT * FROM %s WHERE id in %s", getTableNameT(type), concatenaLlaves(llaves));
		List<T> lista = this.list(query);
		return lista;
	}

	public <O extends Object> List<T> listarLlave(List<O> llaves, String field) {

		String query = String.format("SELECT * FROM %s WHERE %s in %s", getTableNameT(type), field, concatenaLlaves(llaves));
		List<T> lista = this.list(query);
		return lista;
	}
	
	public <O extends Object> List<T> listarLlaveEnable(List<O> llaves, String field) {

		String query = String.format("SELECT * FROM %s WHERE %s in %s and status = %d", getTableNameT(type), field, concatenaLlaves(llaves), Status.Enable);
		List<T> lista = this.list(query);
		return lista;
	}

	public <O extends Object> List<T> listarLlave(List<O> llaves, String field, String order) {

		String query = String.format("SELECT * FROM %s WHERE %s in %s order by %s", getTableNameT(type), field, concatenaLlaves(llaves), order);
		List<T> lista = this.list(query);
		return lista;
	}

	public List<T> listar() {
		String query = String.format("SELECT * FROM %s ", this.tableName);
		List<T> lista = this.list(query);
		return lista;
	}

	protected T buscar(long id) {
		String query = String.format("SELECT * FROM %s WHERE id = %d", this.tableName, id);
		T lista = this.search(query);
		return lista;
	}

	protected T buscar(String query) {
		T lista = this.search(query);
		return lista;
	}

	public Date toDate(Timestamp timestamp) {
		if (timestamp == null) {
			return null;
		}

		return new Date(timestamp.getTime());
	}

	@SuppressWarnings("deprecation")
	public Timestamp getSqlDAte(Date date) {
		Timestamp t = new Timestamp(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds(), 0);
		return t;
	}

}