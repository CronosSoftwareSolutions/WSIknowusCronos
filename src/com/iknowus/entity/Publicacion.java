package com.iknowus.entity;

import java.util.ArrayList;
import java.util.List;

import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.Ignored;
import com.iknowus.entities.annotations.KeyField;

@SuppressWarnings("serial")
public class Publicacion  extends Entity{
	
	@KeyField
	private Long id;
	private String titulo;
	private String descripcion;
	private String imagen;
	private Long fecha_publicacion;
	private Long fecha_referencia;
	private Long fecha_modificacion;
	private Integer estado;
	private Integer aprobado;
	private Integer tipo;
	@Ignored
	private List<Comentario> lstComentarios = new ArrayList<Comentario>();
	@Ignored
	private List<Asistencia> lstAsistentes = new ArrayList<Asistencia>();
	@Ignored
	private List<Valoracion> lstValoraciones = new ArrayList<Valoracion>();
	@Ignored
	private List<Usuario> lstAutores = new ArrayList<Usuario>();
	@Ignored
	private List<DetallePublicacion> lstDetallePublicacion = new ArrayList<DetallePublicacion>();
	@Ignored
	private Area area;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getFecha_publicacion() {
		return fecha_publicacion;
	}
	public void setFecha_publicacion(Long fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	public Long getFecha_referencia() {
		return fecha_referencia;
	}
	public void setFecha_referencia(Long fecha_referencia) {
		this.fecha_referencia = fecha_referencia;
	}
	public Long getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(Long fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getAprobado() {
		return aprobado;
	}
	public void setAprobado(Integer aprobado) {
		this.aprobado = aprobado;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public List<Comentario> getLstComentarios() {
		return lstComentarios;
	}
	public void setLstComentarios(List<Comentario> lstComentarios) {
		this.lstComentarios = lstComentarios;
	}
	public List<Asistencia> getLstAsistentes() {
		return lstAsistentes;
	}
	public void setLstAsistentes(List<Asistencia> lstAsistentes) {
		this.lstAsistentes = lstAsistentes;
	}
	public List<Valoracion> getLstValoraciones() {
		return lstValoraciones;
	}
	public void setLstValoraciones(List<Valoracion> lstValoraciones) {
		this.lstValoraciones = lstValoraciones;
	}
	public List<Usuario> getLstAutores() {
		return lstAutores;
	}
	public void setLstAutores(List<Usuario> lstAutores) {
		this.lstAutores = lstAutores;
	}
	public List<DetallePublicacion> getLstDetallePublicacion() {
		return lstDetallePublicacion;
	}
	public void setLstDetallePublicacion(List<DetallePublicacion> lstDetallePublicacion) {
		this.lstDetallePublicacion = lstDetallePublicacion;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
	
}
