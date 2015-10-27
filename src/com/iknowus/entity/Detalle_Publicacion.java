package com.iknowus.entity;

import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.KeyField;

public class Detalle_Publicacion  extends Entity{
	@KeyField
	private Long id;	
	private Long id_publicacion;
	private String titulo;
	private String texto;
	private String imagen;
	private String video;
	private Integer orden;
	private Integer estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_publicacion() {
		return id_publicacion;
	}
	public void setId_publicacion(Long id_publicacion) {
		this.id_publicacion = id_publicacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
}
