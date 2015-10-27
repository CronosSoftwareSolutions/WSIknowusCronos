package com.iknowus.entity;

import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.KeyField;

@SuppressWarnings("serial")
public class Area extends Entity{
	
	@KeyField
	private Long id;
	private Long id_area_padre;
	private String nombre;
	private String descripcion;
	private String imagen;
	private String color;
	private String estado;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_area_padre() {
		return id_area_padre;
	}
	public void setId_area_padre(Long id_area_padre) {
		this.id_area_padre = id_area_padre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
