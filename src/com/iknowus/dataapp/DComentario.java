package com.iknowus.dataapp;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.iknowus.App;
import com.iknowus.Constantes;
import com.iknowus.data.Data;


public class DComentario<T> extends Data<T> {

	public DComentario(Class<T> type, Connection connection) {
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
	
	public List<T> listarSubComentarios(Long id_comentario) {
		String query = String.format("SELECT * FROM %s where id_respuesta=%d order by id desc", this.tableName, id_comentario);
		List<T> lista = this.list(query);
		return lista;
	}	
}
