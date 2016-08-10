package com.ncubo.contactos;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RegistroPadron 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	private String cedula;
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	private int id_empresa;
	private int id_persona;
	private String creado_por;
	private String modificado_por;
	private Date fecha_creacion;
	private Date fecha_modificacion;
	private int registro_borrado;
	private Date fecha_borrado;
	private String usuario_skype;
	private String celular;
	private String direccion_entrega;
	private double latitud;
	private double longitud;
	
	public RegistroPadron()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public String getCreado_por() {
		return creado_por;
	}
	public void setCreado_por(String creado_por) {
		this.creado_por = creado_por;
	}
	public String getModificado_por() {
		return modificado_por;
	}
	public void setModificado_por(String modificado_por) {
		this.modificado_por = modificado_por;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public int getRegistro_borrado() {
		return registro_borrado;
	}
	public void setRegistro_borrado(int registro_borrado) {
		this.registro_borrado = registro_borrado;
	}
	public Date getFecha_borrado() {
		return fecha_borrado;
	}
	public void setFecha_borrado(Date fecha_borrado) {
		this.fecha_borrado = fecha_borrado;
	}
	public String getUsuario_skype() {
		return usuario_skype;
	}
	public void setUsuario_skype(String usuario_skype) {
		this.usuario_skype = usuario_skype;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDireccion_entrega() {
		return direccion_entrega;
	}
	public void setDireccion_entrega(String direccion_entrega) {
		this.direccion_entrega = direccion_entrega;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}	
}
