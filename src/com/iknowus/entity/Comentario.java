package com.iknowus.entity;

import java.util.List;

import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.Ignored;
import com.iknowus.entities.annotations.KeyField;

@SuppressWarnings("serial")
public class Comentario  extends Entity{
	@KeyField
	private Long id;
	private Long id_usuario;
	private Long id_publicacion;
	private Long id_respuesta;
	private String titulo;
	private String descripcion;
	private String imagen;
	private Integer tipo;
	private Integer estado;
	private Long fecha;
	
	public Long getFecha() {
		return fecha;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	@Ignored
	private Usuario usuario;
	@Ignored
	private List<Valoracion> lstValoraciones;
	@Ignored
	private List<Comentario> lstComentarios;
	
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
	public Long getId_respuesta() {
		return id_respuesta;
	}
	public void setId_respuesta(Long id_respuesta) {
		this.id_respuesta = id_respuesta;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Valoracion> getLstValoraciones() {
		return lstValoraciones;
	}
	public void setLstValoraciones(List<Valoracion> lstValoraciones) {
		this.lstValoraciones = lstValoraciones;
	}
	public List<Comentario> getLstComentarios() {
		return lstComentarios;
	}
	public void setLstComentarios(List<Comentario> lstComentarios) {
		this.lstComentarios = lstComentarios;
	}
	
	
}
