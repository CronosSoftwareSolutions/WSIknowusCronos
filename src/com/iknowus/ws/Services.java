package com.iknowus.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iknowus.App;
import com.iknowus.business.BAsistencia;
import com.iknowus.business.BComentario;
import com.iknowus.business.BPublicacion;
import com.iknowus.business.BUsuario;
import com.iknowus.entities.Action;
import com.iknowus.entity.Asistencia;
import com.iknowus.entity.Comentario;
import com.iknowus.entity.Publicacion;
import com.iknowus.entity.Usuario;
import com.iknowus.util.Log;

@Path("/Services")
public class Services {

	private static Gson getGson() {
		return new GsonBuilder().setDateFormat("MMM dd,yyyy").create();
	}

	@GET()
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response services() {
		Log.info("Services");
		return Helper.response("hello " + App.name + " " + App.version);
	}

	@POST()
	@Path("/StartSession")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response startSession(@FormParam("user") String user, @FormParam("password") String password) {
		Log.info("startSession");
		BUsuario bc = null;
		try {
			bc = new BUsuario();
			Usuario usuario = bc.buscar(user);
			if (usuario != null) {
				if (usuario.getContrasena_usuario().equals(password)) {
					return Helper.response(usuario);
				}
			} else {
				return Helper.noResponse();
			}
		} catch (Exception e) {
			Log.error(e.getMessage(), e);
		} finally {
			if (bc != null) {
				try {
					bc.destroy();
				} catch (Exception e) {
					Log.error(e.getMessage(), e);
				}
			}
		}
		return Helper.noResponse();
	}

	@GET()
	@Path("/GetLastPublications/{tipo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticulos(@PathParam("tipo") Long tipo) {
		Log.info("GetLastPublications");
		BPublicacion bp = null;
		try {
			bp = new BPublicacion();
			int t = Integer.valueOf("" + tipo);
			if (t == 0) {
				return Helper.response(bp.listar());
			} else {
				return Helper.response(bp.listarTipo(t));
			}
		} catch (Exception e) {
			Log.error(e.getMessage(), e);
		} finally {
			if (bp != null) {
				try {
					bp.destroy();
				} catch (Exception e) {
					Log.error(e.getMessage(), e);
				}
			}
		}
		return Helper.noResponse();
	}
	
	@POST()
	@Path("/saveComment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response saveComment(@FormParam("comentario") String comentario, @FormParam("id_publicacion") Long id_publicacion, @FormParam("id_usuario") Long id_usuario) {
		Log.info("saveComment");
		BComentario bc = null;
		try {
			bc = new BComentario();
			BPublicacion bp = new BPublicacion(bc.getConexion());
			Comentario cm = new Comentario();
			cm.setAction(Action.Insert);
			cm.setTitulo(comentario);
			cm.setId_publicacion(id_publicacion);
			cm.setId_usuario(id_usuario); 
			cm.setFecha(App.getCurrentTime()); 
			if (bc.save(cm)) { 				
				return Helper.response(bp.searchById(id_publicacion));
			}
		} catch (Exception e) {
			Log.error(e.getMessage(), e);
		} finally {
			if (bc != null) {
				try {
					bc.destroy();
				} catch (Exception e) {
					Log.error(e.getMessage(), e);
				}
			}
		}
		return Helper.noResponse();
	}
	
	@POST()
	@Path("/saveAsistencia")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response saveAsistencia(@FormParam("detalle") String detalle, @FormParam("id_publicacion") Long id_publicacion, @FormParam("id_usuario") Long id_usuario) {
		Log.info("saveAsistencia");
		BAsistencia bc = null;
		try {
			bc = new BAsistencia();
			BPublicacion bp = new BPublicacion(bc.getConexion()); 
			Asistencia as = new Asistencia();
			as.setAction(Action.Insert);
			as.setDetalle_asistencia(detalle); 
			as.setId_publicacion(id_publicacion);
			as.setId_usuario(id_usuario); 			
			if (bc.save(as)) { 				
				return Helper.response(bp.searchById(id_publicacion)); 
			}
		} catch (Exception e) {
			Log.error(e.getMessage(), e);
		} finally {
			if (bc != null) {
				try {
					bc.destroy();
				} catch (Exception e) {
					Log.error(e.getMessage(), e);
				}
			}
		}
		return Helper.noResponse();
	}


}
