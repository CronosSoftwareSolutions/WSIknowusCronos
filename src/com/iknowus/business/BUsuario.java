package com.iknowus.business;

import java.sql.Connection;
import java.util.List;

import com.iknowus.dataapp.DUsuario;
import com.iknowus.entity.Usuario;
import com.iknowus.entity.UsuarioPublicacion;

public class BUsuario extends Business {

	public BUsuario() throws Exception {
		super();
	}

	public BUsuario(Connection conection) throws Exception {
		super(conection);
	}

	public Usuario searchById(Long userId) {
		DUsuario<Usuario> dal = null; 
		try {
			dal = new DUsuario<Usuario>(Usuario.class, connection);
			return dal.buscar(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public Usuario buscar(String email) {
		DUsuario<Usuario> dal = null;
		try {
			dal = new DUsuario<Usuario>(Usuario.class, connection);
			return dal.searchByUser(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> buscar(List<UsuarioPublicacion> lista) {
		DUsuario<Usuario> dal = null;
		try {
			dal = new DUsuario<Usuario>(Usuario.class, connection);
			return dal.listarAutores(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
