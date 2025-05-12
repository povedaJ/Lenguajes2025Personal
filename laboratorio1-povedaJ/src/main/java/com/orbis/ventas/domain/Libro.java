package com.orbis.ventas.domain;

import java.util.LinkedList;
import java.util.List;


public class Libro {
private int idLibro;
private String titulo;
private int ano;
private float precio;
private Editorial editorial;
private List<Autor> autores;

public Libro() {
	
	editorial= new Editorial();
	autores=new LinkedList<>();
}

public Libro(int idLibro, String titulo, int ano, float precio, Editorial editorial, List<Autor> autores) {
	//super();
	this.idLibro = idLibro;
	this.titulo = titulo;
	this.ano = ano;
	this.precio = precio;
	this.editorial = editorial;
	this.autores = autores;
}

public int getIdLibro() {
	return idLibro;
}

public void setIdLibro(int idLibro) {
	this.idLibro = idLibro;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public int getAno() {
	return ano;
}

public void setAno(int ano) {
	this.ano = ano;
}

public float getPrecio() {
	return precio;
}

public void setPrecio(float precio) {
	this.precio = precio;
}

public Editorial getEditorial() {
	return editorial;
}

public void setEditorial(Editorial editorial) {
	this.editorial = editorial;
}

public List<Autor> getAutores() {
	return autores;
}

public void setAutores(List<Autor> autores) {
	this.autores = autores;
}


}
