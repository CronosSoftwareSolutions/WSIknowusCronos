package com.iknowus.data;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.joinFrom;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iknowus.entities.Action;
import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.Ignored;
import com.iknowus.entities.annotations.KeyField;
import com.iknowus.entities.annotations.Queried;
import com.iknowus.util.Log;

abstract public class Wrapper<T> {
	protected Class<T> type;
	Connection connection = null;
	public String tableName;

	public Wrapper(Class<T> type, Connection connection) {
		this.connection = connection;
		this.type = type;
//		this.tableName = this.getTableName(type);
		this.tableName = this.getTableNameT(type);
	}

	private String getQuery(String nombre, List<Column> columns, Action action) {
		StringBuilder sb = new StringBuilder();
		if (action == Action.Insert) {
			sb.append("INSERT ");
			sb.append(nombre);
			sb.append(" (");
			sb.append(joinFrom(columns).getKey());
			sb.append(") VALUES (");
			sb.append(getSimple(columns));
			sb.append(")");
		}
		if (action == Action.Update) {
			List<Column> listKey = select(columns, having(on(Column.class).getAnnotation(), instanceOf(KeyField.class)));
			List<Column> listValue = select(columns, having(on(Column.class).getAnnotation(), is(nullValue())));
			sb.append("UPDATE ");
			sb.append(nombre);
			sb.append(" SET ");
			sb.append(joinFrom(listValue, Column.class, "=?,").getKey() + "=?");
			sb.append(" WHERE " + joinFrom(listKey, Column.class, "=?,").getKey() + "=?");
		}
		if (action == Action.Delete) {
			List<Column> listKey = select(columns, having(on(Column.class).getAnnotation(), instanceOf(KeyField.class)));
			sb.append("DELETE FROM ");
			sb.append(nombre);
			sb.append(" WHERE  ");
			sb.append(joinFrom(listKey, "=?,").getKey() + "=?");

		}
		return sb.toString();
	}

	private String getSimple(List<Column> columns) {
		StringBuilder sb = new StringBuilder();
		if (columns.isEmpty()) {
			return "";
		}
		sb.append("?");
		for (int i = 1; i < columns.size(); i++) {
			sb.append(",?");
		}
		return sb.toString();

	}

	public boolean guardar(Entity entity) {
		try {
			if (entity == null) {
				Log.warn("No se ejecutar la entidad es null", null);
				return false;
			}
			List<Column> columns = new ArrayList<Column>();
			String fieldAutoIncremental = "";

			for (Field field : entity.getClass().getDeclaredFields()) {
				Annotation autoIncremental = field.getAnnotation(KeyField.class);
				if (entity.getAction() == Action.Insert && autoIncremental != null) {
					fieldAutoIncremental = field.getName();
					continue;
				}
				if (field.getAnnotation(Ignored.class) == null) {

					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), entity.getClass());
					Method method = propertyDescriptor.getReadMethod();

					Object value = method.invoke(entity);
					if (value != null) {
						Annotation a = field.getAnnotation(KeyField.class);
						columns.add(new Column(field.getName(), value, a));
					}
				}
			}

			if (columns.isEmpty()) {
				Log.warn("No se puede " + entity.getAction().name() + " la entidad " + entity, null);
				return false;
			}
			if (entity.getAction() == Action.Insert)
				return insert(entity, columns, fieldAutoIncremental);

			if (entity.getAction() == Action.Update)
				return update(entity, columns);

			if (entity.getAction() == Action.Delete)
				return delete(entity, columns);

			Log.error("No e pudo ejecutar la accion, entidad=" + entity, null);

		} catch (IntrospectionException e) {
			Log.error("No e pudo update, entidad=" + entity, e);
		} catch (IllegalArgumentException e) {
			Log.error("No e pudo update, entidad=" + entity, e);
		} catch (IllegalAccessException e) {
			Log.error("No e pudo update, entidad=" + entity, e);
		} catch (InvocationTargetException e) {
			Log.error("No e pudo update, entidad=" + entity, e);
		} finally {

		}
		return false;
	}

	private boolean insert(Entity entity, List<Column> columns, String fieldAutoIncremental) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = getQuery(this.tableName, columns, Action.Insert);
			Log.debug("SQL:" + query);
			if (query.isEmpty()) {
				return false;
			}
			if (fieldAutoIncremental.isEmpty()) {
				preparedStatement = connection.prepareStatement(query);
				int i = 0;
				for (Column column : columns) {
					preparedStatement.setObject(++i, column.getValue());
				}
				preparedStatement.execute();
			} else {
				preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				int i = 0;
				for (Column column : columns) {
					preparedStatement.setObject(++i, column.getValue());
				}
				preparedStatement.execute();
				rs = preparedStatement.getGeneratedKeys();
				if (rs != null && rs.next()) {
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldAutoIncremental, type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(entity, rs.getLong(1));
				}

			}

			return true;
		} catch (SQLException e) {
			Log.error("No se pudo ejecutar la consulta: " + query, e);
		} catch (IntrospectionException e) {
			Log.error("No se pudo ejecutar la consulta: " + query, e);
		} catch (IllegalArgumentException e) {
			Log.error("No se pudo ejecutar la consulta: " + query, e);
		} catch (IllegalAccessException e) {
			Log.error("No se pudo ejecutar la consulta: " + query, e);
		} catch (InvocationTargetException e) {
			Log.error("No se pudo ejecutar la consulta: " + query, e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				Log.error("Cerrar la conexion base de datos", e);
			}
		}
		return false;
	}

	public PreparedStatement getPrepareStatement(String strQuery) throws SQLException {
		return this.connection.prepareStatement(strQuery, Statement.RETURN_GENERATED_KEYS);
	}

	private boolean update(Entity entity, List<Column> columns) {
		List<Column> listKey = select(columns, having(on(Column.class).getAnnotation(), instanceOf(KeyField.class)));
		List<Column> listValue = select(columns, having(on(Column.class).getAnnotation(), is(nullValue())));
		if (listKey == null || listKey.isEmpty()) {
			return false;
		}
		String query = getQuery(this.tableName, columns, Action.Update);
		Log.debug("SQL:" + query);
		if (query.isEmpty()) {
			return false;
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			int i = 0;
			for (Column column : listValue) {
				preparedStatement.setObject(++i, column.getValue());
			}
			for (Column column : listKey) {
				preparedStatement.setObject(++i, column.getValue());
			}
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean execute(String query) {
		PreparedStatement preparedStatement = null;
		try {
			Log.debug("SQL:" + query);
			if (query.isEmpty()) {
				return false;
			}
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			Log.error("Error al ejecutar la consulta, query: " + query, e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				Log.error("Error al cerrar prepares statement", e);
			}
		}
		return false;
	}

	private boolean delete(Entity entity, List<Column> columns) {
		List<Column> listKey = select(columns, having(on(Column.class).getAnnotation(), instanceOf(KeyField.class)));
		if (listKey == null || listKey.isEmpty()) {
			return false;
		}
		PreparedStatement preparedStatement = null;
		String query = "";
		try {
			query = getQuery(this.tableName, listKey, Action.Delete);
			Log.debug("SQL:" + query);
			if (query.isEmpty()) {
				return false;
			}
			preparedStatement = connection.prepareStatement(query);
			int i = 0;
			for (Column column : listKey) {
				preparedStatement.setObject(++i, column.getValue());
			}
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			Log.error("Error al ejecutar la consulta, query: " + query, e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				Log.error("Error al cerrar prepares statement", e);
			}
		}
		return false;
	}

	public String getTableName(Class<T> cl){
		String[] buf = cl.getClass().getName().split("\\.");  
		return (buf[buf.length-2] + "_" + buf[buf.length-1]).toLowerCase();
	}

	public String getTableNameT(Class<T> cl) {
		String name = cl.getPackage().getName();
		int lastIndexOf = name.lastIndexOf(".");
		String substring = name.substring(lastIndexOf + 1, name.length());
		substring = substring + "_" + cl.getSimpleName();
		substring = substring.toLowerCase();
		return substring;
	}

	public T loadEntity(ResultSet result) {
		T instance = null;
		try {
			instance = type.newInstance();
			for (Field field : type.getDeclaredFields()) {
				if (field.getAnnotation(Ignored.class) == null) {
					Object value = result.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				} else if (field.getAnnotation(Queried.class) != null) {
					try {
						Object value = result.getObject(field.getName());
						PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
						Method method = propertyDescriptor.getWriteMethod();
						method.invoke(instance, value);
					} catch (Exception e) {

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}
}
