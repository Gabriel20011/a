package co.edu.unbosque.modelo;

import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Biblioteca {
	
	
	static ArrayList<Libro> libros = DAO.getLibros();
	String[] seleccionados = {};
	ArrayList<Libro> filtro;
	ArrayList<String> temas = new ArrayList<String>();
	public Biblioteca() {
		temas();
		filtro();
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
		System.out.println(Arrays.toString(seleccionados));
		filtro = new ArrayList<Libro> ();
		for (int i = 0; i < temas.size(); i++) {
			for (int j = 0; j < libros.size(); j++) {
				if(libros.get(j).getTema().equals(temas.get(i))) {
					filtro.add(libros.get(j));
				}
			}
		}
		return "Reserva";
	}

	public ArrayList<String> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<String> temas) {
		this.temas = temas;
	}


	public ArrayList<Libro> getFiltro() {
		return filtro;
	}

	public void setFiltro(ArrayList<Libro> filtro) {
		this.filtro = filtro;
	}
	public String[] getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(String[] seleccionados) {
		this.seleccionados = seleccionados;
	}
	
}
