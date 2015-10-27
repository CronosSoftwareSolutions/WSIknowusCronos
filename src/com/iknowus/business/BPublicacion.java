package com.iknowus.business;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.iknowus.dataapp.DPublicacion;
import com.iknowus.dataapp.DUsuario;
import com.iknowus.entity.Publicacion;
import com.iknowus.entity.Usuario;
import com.iknowus.entity.UsuarioPublicacion;

public class BPublicacion extends Business {

	public BPublicacion() throws Exception {
		super();
	}

	public BPublicacion(Connection conection) throws Exception {
		super(conection);
	}

	public Publicacion searchById(Long Id) {
		DPublicacion<Publicacion> dal = null; 
		try {
			dal = new DPublicacion<Publicacion>(Publicacion.class, connection);
			Publicacion pub = dal.buscar(Id);
			List<Publicacion> lst = new ArrayList<Publicacion>();
			lst.add(pub);
			loadRelations(lst); 
			return pub;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Publicacion> listarTipo(int tipo) {		
		List<Publicacion> result = new ArrayList<Publicacion>();
		DPublicacion<Publicacion> dal = null; 
		try {
			dal = new DPublicacion<Publicacion>(Publicacion.class, connection);
			result= dal.listar(tipo);
			loadRelations(result); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Publicacion> listar() {
		List<Publicacion> result = new ArrayList<Publicacion>();
		DPublicacion<Publicacion> dal = null; 
		try {
			dal = new DPublicacion<Publicacion>(Publicacion.class, connection);
			result = dal.listar();
			loadRelations(result); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private void loadRelations(List<Publicacion> result) throws Exception{
		if(result!=null && !result.isEmpty()){
			BDetallePublicacion bdp = new BDetallePublicacion();
			BComentario bc = new BComentario(bdp.getConexion());
			BUsuario bu = new BUsuario(bdp.getConexion());
			BUsuarioPublicacion bup = new BUsuarioPublicacion(bdp.getConexion());
			BAsistencia ba = new BAsistencia(bdp.getConexion());
			BValoracion bv = new BValoracion(bdp.getConexion());
			for(Publicacion pubs: result){
				pubs.setLstAsistentes(ba.listarPorPublicacion(pubs.getId())); 
				pubs.setLstAutores(bu.buscar(bup.buscarPorPublicacion(pubs.getId()))); 
				pubs.setLstComentarios(bc.listarPorPublicacion(pubs.getId())); 
				pubs.setLstDetallePublicacion(bdp.listarTipo(pubs.getId())); 
				pubs.setLstValoraciones(bv.listarPorPublicacion(pubs.getId())); 
			}
		}			
	}

}
