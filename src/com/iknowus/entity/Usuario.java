package com.iknowus.entity;

import com.iknowus.entities.Entity;
import com.iknowus.entities.annotations.KeyField;

@SuppressWarnings("serial")
public class Usuario  extends Entity{
	
	@KeyField
	private Long id;
	private Long id_area;
	private String correo_usuario;
	private String contrasena_usuario;
	private String nombre;
	private String apellido;
	private String imagen;
	private String genero;
	private Long fecha_nacimiento;
	private Integer tipo;
	private Integer estado;
	private String cargo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_area() {
		return id_area;
	}
	public void setId_area(Long id_area) {
		this.id_area = id_area;
	}
	public String getCorreo_usuario() {
		return correo_usuario;
	}
	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}
	public String getContrasena_usuario() {
		return contrasena_usuario;
	}
	public void setContrasena_usuario(String contrasena_usuario) {
		this.contrasena_usuario = contrasena_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Long fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
