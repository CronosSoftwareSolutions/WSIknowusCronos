package com.iknowus.entity;

import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.KeyField;

public class UsuarioPublicacion  extends Entity{
	
	@KeyField
	private Long id;
	private Long id_usuario;
	private Long id_publicacion;
	private String participacion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Long getId_publicacion() {
		return id_publicacion;
	}
	public void setId_publicacion(Long id_publicacion) {
		this.id_publicacion = id_publicacion;
	}
	public String getParticipacion() {
		return participacion;
	}
	public void setParticipacion(String participacion) {
		this.participacion = participacion;
	}
	
	
}
