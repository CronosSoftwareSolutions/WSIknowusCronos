package com.iknowus.entity;

import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.Ignored;
import com.iknowus.entities.annotations.KeyField;

public class Valoracion  extends Entity{
	
	@KeyField
	private Long id;
	private Long id_usuario;
	private Long id_publicacion;
	private Long id_comentario;
	private Long fecha;
	private Integer puntos;
	@Ignored
	private Usuario usuario;
	
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
	public Long getId_comentario() {
		return id_comentario;
	}
	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}
	public Long getFecha() {
		return fecha;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
