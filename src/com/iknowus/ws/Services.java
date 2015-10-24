package com.iknowus.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iknowus.App;
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
	
	@GET()
	@Path("/GetArticulos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticulos() {
		Log.info("Articulos");				
		try {			
			return Helper.response("respuesta"); 
		} catch (Exception e) {
			Log.error(e.getMessage(), e);
		} finally {
//			if (bc != null) {
//				try {
//					bc.destroy();
//				} catch (Exception e) {
//					Log.error(e.getMessage(), e);
//				}
//			}
		}
		return Helper.noResponse();
	}


}
