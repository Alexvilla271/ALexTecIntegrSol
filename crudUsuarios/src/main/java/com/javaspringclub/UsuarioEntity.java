package com.javaspringclub;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class UsuarioEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long usuarioId;
	private String nombre;
	private String tipo;
	
	public UsuarioEntity() {
		
	}
	
	public UsuarioEntity(String nombre, String tipo) {
		this.nombre= nombre;
		this.tipo = tipo;
	}
	
	public long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategory() {
		return tipo;
	}
	public void setCategory(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "UsuarioEntity [usuarioId=" + usuarioId + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

	
}
