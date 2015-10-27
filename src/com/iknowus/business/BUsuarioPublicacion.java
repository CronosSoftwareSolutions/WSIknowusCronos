package com.iknowus.business;

import java.sql.Connection;
import java.util.List;

import com.iknowus.dataapp.DUsuario;
import com.iknowus.dataapp.DUsuarioPublicacion;
import com.iknowus.entity.Usuario;
import com.iknowus.entity.UsuarioPublicacion;

public class BUsuarioPublicacion extends Business {

	public BUsuarioPublicacion() throws Exception {
		super();
	}

	public BUsuarioPublicacion(Connection conection) throws Exception {
		super(conection);
	}

	
	public List<UsuarioPublicacion> buscarPorPublicacion(Long id_publicacion) {
		DUsuarioPublicacion<UsuarioPublicacion> dal = null;
		try {
			dal = new DUsuarioPublicacion<UsuarioPublicacion>(UsuarioPublicacion.class, connection);
			return dal.listar(id_publicacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
