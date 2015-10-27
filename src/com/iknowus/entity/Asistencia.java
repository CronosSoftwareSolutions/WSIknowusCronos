package com.iknowus.entity;

import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.Ignored;
import com.iknowus.entities.annotations.KeyField;

@SuppressWarnings("serial")
public class Asistencia  extends Entity{
	@KeyField
	private Long id;
	private Long id_usuario;
	private Long id_publicacion;
	private String detalle_asistencia;
	@Ignored
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
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
	public String getDetalle_asistencia() {
		return detalle_asistencia;
	}
	public void setDetalle_asistencia(String detalle_asistencia) {
		this.detalle_asistencia = detalle_asistencia;
	}
	
	
}
