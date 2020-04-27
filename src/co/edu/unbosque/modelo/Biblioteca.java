package co.edu.unbosque.modelo;

import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Biblioteca {
	
	
	static ArrayList<Libro> libros = DAO.getLibros();
	ArrayList<String> seleccionados = new ArrayList<String>();
	ArrayList<Libro> filtroS = new ArrayList<Libro>();
	

	ArrayList<String> temas = new ArrayList<String>();
	public Biblioteca() {
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
	
	public String filtro(){
		
		for (int i = 0; i < seleccionados.size(); i++) {
			for (int j = 0; j < libros.size(); j++) {
				if(libros.get(j).getTema().equals(seleccionados.get(i))) {
					filtroS.add(libros.get(j));
				}
			}
		}
		return "Reserva";
	}

	public ArrayList<Libro> getFiltroS() {
		return filtroS;
	}

	public void setFiltroS(ArrayList<Libro> filtroS) {
		this.filtroS = filtroS;
	}
	
	public ArrayList<String> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<String> temas) {
		this.temas = temas;
	}


	public ArrayList<Libro> getFiltro() {
		return filtroS;
	}

	public void setFiltro(ArrayList<Libro> filtroS) {
		this.filtroS = filtroS;
	}

	public static ArrayList<Libro> getLibros() {
		return libros;
	}

	public static void setLibros(ArrayList<Libro> libros) {
		Biblioteca.libros = libros;
	}

	public ArrayList<String> getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(ArrayList<String> seleccionados) {
		this.seleccionados = seleccionados;
	}

}
