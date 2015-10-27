package com.iknowus.dataapp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.http.util.TextUtils;

import com.iknowus.App;
import com.iknowus.Constantes;
import com.iknowus.data.Data;
import com.iknowus.entity.Usuario_Publicacion;


public class DUsuario<T> extends Data<T> {

	public DUsuario(Class<T> type, Connection connection) {
		super(type, connection);
	}

	public T buscar(Long id) {
		return super.buscar(id);
	}
	
	public T searchByUser(String email) {
		return super.buscar("select * from " + this.tableName + " where correo_usuario = '" + email + "'");
	}
	
	public List<T> listarAutores(List<Usuario_Publicacion> list) {
		String ids = "(";
		for(Usuario_Publicacion up:list){
			ids += up.getId_usuario() + ",";
		}
		ids += "0)";
		String query = String.format("SELECT * FROM %s where id IN %s order by id desc", this.tableName, ids);
		List<T> lista = this.list(query);
		return lista;
	}	
}
