package com.iknowus.business;

import java.sql.Connection;
import java.util.List;

import com.iknowus.dataapp.DDetallePublicacion;
import com.iknowus.dataapp.DPublicacion;
import com.iknowus.dataapp.DUsuario;
import com.iknowus.entity.DetallePublicacion;
import com.iknowus.entity.Publicacion;
import com.iknowus.entity.Usuario;
import com.iknowus.entity.UsuarioPublicacion;

public class BDetallePublicacion extends Business {

	public BDetallePublicacion() throws Exception {
		super();
	}

	public BDetallePublicacion(Connection conection) throws Exception {
		super(conection);
	}

	public DetallePublicacion searchById(Long Id) {
		DDetallePublicacion<DetallePublicacion> dal = null; 
		try {
			dal = new DDetallePublicacion<DetallePublicacion>(DetallePublicacion.class, connection);
			return dal.buscar(Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<DetallePublicacion> listarTipo(Long id_publicacion) {
		DDetallePublicacion<DetallePublicacion> dal = null; 
		try {
			dal = new DDetallePublicacion<DetallePublicacion>(DetallePublicacion.class, connection);			
			return dal.listar(id_publicacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
