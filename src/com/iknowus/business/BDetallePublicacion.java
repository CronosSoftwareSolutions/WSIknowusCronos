package com.iknowus.business;

import java.sql.Connection;
import java.util.List;

import com.iknowus.dataapp.DDetallePublicacion;
import com.iknowus.dataapp.DPublicacion;
import com.iknowus.dataapp.DUsuario;
import com.iknowus.entity.Detalle_Publicacion;
import com.iknowus.entity.Publicacion;
import com.iknowus.entity.Usuario;
import com.iknowus.entity.Usuario_Publicacion;

public class BDetallePublicacion extends Business {

	public BDetallePublicacion() throws Exception {
		super();
	}

	public BDetallePublicacion(Connection conection) throws Exception {
		super(conection);
	}

	public Detalle_Publicacion searchById(Long Id) {
		DDetallePublicacion<Detalle_Publicacion> dal = null; 
		try {
			dal = new DDetallePublicacion<Detalle_Publicacion>(Detalle_Publicacion.class, connection);
			return dal.buscar(Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Detalle_Publicacion> listarTipo(Long id_publicacion) {
		DDetallePublicacion<Detalle_Publicacion> dal = null; 
		try {
			dal = new DDetallePublicacion<Detalle_Publicacion>(Detalle_Publicacion.class, connection);			
			return dal.listar(id_publicacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
