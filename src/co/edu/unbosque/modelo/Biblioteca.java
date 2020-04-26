package co.edu.unbosque.modelo;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Biblioteca {
	DAO dao = new DAO();
	ArrayList<Libro> libros;
	ArrayList<String> temas = new ArrayList<String>();
	public Biblioteca() {
		dao.conectar();
		libros  =  dao.getLibros();
		temas();
	}

	public void  temas(){
		String tema = "";
		for (int i = 0; i < libros.size() - 1; i++) {
			tema = libros.get(i).getTema();
			
			if (!tema.equals(libros.get(i+1).getTema())) {
				temas.add(tema);
			}
		}
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public ArrayList<String> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<String> temas) {
		this.temas = temas;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
}
