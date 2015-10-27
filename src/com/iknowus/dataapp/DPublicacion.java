package com.iknowus.dataapp;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.iknowus.App;
import com.iknowus.Constantes;
import com.iknowus.data.Data;


public class DPublicacion<T> extends Data<T> {

	public DPublicacion(Class<T> type, Connection connection) {
		super(type, connection);
	}

	public T buscar(Long id) {
		return super.buscar(id);
	}

	public List<T> listar() {	
		String query = String.format("SELECT * FROM %s order by fecha_publicacion desc limit 30", this.tableName);
		return this.list(query);
	}
	
	public List<T> listar(int tipo, String filter) {
		String query = "";
		if(filter.length()<3){
			query = String.format("SELECT * FROM %s where tipo=%d order by fecha_publicacion desc limit 30", this.tableName, tipo);
		}else{
			query = "SELECT * FROM " + tableName +" where tipo=" + tipo +" and titulo like '%" + filter+ "%' order by fecha_publicacion desc limit 30";
		}		
		List<T> lista = this.list(query);
		return lista;
	}	
}
