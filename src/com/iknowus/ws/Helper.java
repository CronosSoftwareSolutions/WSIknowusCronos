package com.iknowus.ws;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

public class Helper {

	public static Response noResponse() {
		return Response.noContent().build();
	}

	public static Response response(Object o) {
		return Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=UTF-8").entity(new Gson().toJson(o)).build();
	}
}
