package com.orbis.ventas.domain;

public class Editorial {
private int idEditorial;
private String nombre;
private String direccion;
private String telefono; 

public Editorial() {
}

public Editorial(int idEditorial, String nombre, String direccion, String telefono) {
	super();
	this.idEditorial = idEditorial;
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
}

public int getIdEditorial() {
	return idEditorial;
}

public void setIdEditorial(int idEditorial) {
	this.idEditorial = idEditorial;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}


}//
