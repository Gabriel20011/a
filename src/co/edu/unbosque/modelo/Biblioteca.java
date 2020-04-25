package co.edu.unbosque.modelo;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Biblioteca {
	ArrayList<Libro> libros  = new ArrayList<Libro>();

	public Biblioteca() {
		libros.add(new Libro("Luna de Plutón", "Terror"));
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
}
