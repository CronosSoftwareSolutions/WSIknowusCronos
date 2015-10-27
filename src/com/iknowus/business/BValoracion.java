package com.iknowus.business;

import java.sql.Connection;
import java.util.List;

import org.jboss.net.protocol.http.DavURLLister;

import com.iknowus.dataapp.DAsistencia;
import com.iknowus.dataapp.DComentario;
import com.iknowus.dataapp.DPublicacion;
import com.iknowus.dataapp.DUsuario;
import com.iknowus.dataapp.DValoracion;
import com.iknowus.entity.Asistencia;
import com.iknowus.entity.Comentario;
import com.iknowus.entity.Publicacion;
import com.iknowus.entity.Usuario;
import com.iknowus.entity.UsuarioPublicacion;
import com.iknowus.entity.Valoracion;

public class BValoracion extends Business {

	public BValoracion() throws Exception {
		super();
	}

	public BValoracion(Connection conection) throws Exception {
		super(conection);
	}

	public Valoracion searchById(Long Id) {
		DValoracion<Valoracion> dal = null; 
		try {
			dal = new DValoracion<Valoracion>(Valoracion.class, connection);
			return dal.buscar(Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Valoracion> listarPorPublicacion(Long id_publicacion) {
		DValoracion<Valoracion> dal = null; 
		try {
			dal = new DValoracion<Valoracion>(Valoracion.class, connection);
			return dal.listar(id_publicacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	

}
