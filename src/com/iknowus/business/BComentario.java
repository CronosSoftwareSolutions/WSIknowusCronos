package com.iknowus.business;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.iknowus.dataapp.DComentario;
import com.iknowus.dataapp.DPublicacion;
import com.iknowus.dataapp.DUsuario;
import com.iknowus.entity.Comentario;
import com.iknowus.entity.Publicacion;
import com.iknowus.entity.Usuario;
import com.iknowus.entity.Usuario_Publicacion;

public class BComentario extends Business {

	public BComentario() throws Exception {
		super();
	}

	public BComentario(Connection conection) throws Exception {
		super(conection);
	}

	public Comentario searchById(Long Id) {
		DComentario<Comentario> dal = null; 
		try {
			dal = new DComentario<Comentario>(Comentario.class, connection);
			return dal.buscar(Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Comentario> listarPorPublicacion(Long id_publicacion) {
		List<Comentario> result = new ArrayList<Comentario>();
		DComentario<Comentario> dal = null; 
		try {
			dal = new DComentario<Comentario>(Comentario.class, connection);
			result = dal.listar(id_publicacion);
			if(result!=null && !result.isEmpty()){
				BUsuario bu = new BUsuario();
				for(Comentario cm:result){
					cm.setUsuario(bu.searchById(cm.getId_usuario())); 
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Comentario> listarSubComentario(Long id_comentario) {
		DComentario<Comentario> dal = null; 
		try {
			dal = new DComentario<Comentario>(Comentario.class, connection);
			return dal.listarSubComentarios(id_comentario); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean save(Comentario obj) {
		DComentario<Comentario> dal = null;
		try {
			dal = new DComentario<Comentario>(Comentario.class, connection);
			return dal.guardar(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
