package com.iknowus.business;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.iknowus.dataapp.DAsistencia;
import com.iknowus.dataapp.DComentario;
import com.iknowus.dataapp.DPublicacion;
import com.iknowus.dataapp.DUsuario;
import com.iknowus.entity.Asistencia;
import com.iknowus.entity.Comentario;
import com.iknowus.entity.Publicacion;
import com.iknowus.entity.Usuario;
import com.iknowus.entity.UsuarioPublicacion;

public class BAsistencia extends Business {

	public BAsistencia() throws Exception {
		super();
	}

	public BAsistencia(Connection conection) throws Exception {
		super(conection);
	}

	public Asistencia searchById(Long Id) {
		DAsistencia<Asistencia> dal = null; 
		try {
			dal = new DAsistencia<Asistencia>(Asistencia.class, connection);
			return dal.buscar(Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Asistencia> listarPorPublicacion(Long id_publicacion) {
		List<Asistencia> result = new ArrayList<Asistencia>();
		DAsistencia<Asistencia> dal = null; 
		try {
			dal = new DAsistencia<Asistencia>(Asistencia.class, connection);
			result = dal.listar(id_publicacion);
			if(result!=null && !result.isEmpty()){
				BUsuario bu = new BUsuario();
				for(Asistencia as:result){
					as.setUsuario(bu.searchById(as.getId_usuario())); 
				}
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	public boolean save(Asistencia obj) {
		DAsistencia<Asistencia> dal = null; 
		try {
			dal = new DAsistencia<Asistencia>(Asistencia.class, connection);
			return dal.guardar(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
