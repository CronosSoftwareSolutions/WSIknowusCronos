package com.iknowus.dataapp;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.iknowus.App;
import com.iknowus.Constantes;
import com.iknowus.data.Data;


public class DAsistencia<T> extends Data<T> {

	public DAsistencia(Class<T> type, Connection connection) {
		super(type, connection);
	}

	public T buscar(Long id) {
		return super.buscar(id);
	}	

	public List<T> listar(Long publication_id) {
		String query = String.format("SELECT * FROM %s where id_publicacion=%d order by id desc", this.tableName, publication_id);
		List<T> lista = this.list(query);
		return lista;
	}	
}
