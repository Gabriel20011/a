package co.edu.unbosque.controlador;

import java.util.ArrayList;

public class DAO {

	private ArrayList<String> nombres;
	private ArrayList<String> apellidos;
	private ArrayList<String> edades;
	private ArrayList<String> generos;
	private ArrayList<String> paises;
	private ArrayList<String> ciudades;

	public DAO() {
		nombres = new ArrayList<String>();
		apellidos = new ArrayList<String>();
		edades = new ArrayList<String>();
		generos = new ArrayList<String>();
		paises = new ArrayList<String>();
		ciudades = new ArrayList<String>();

	}

	public void agregarNombre(String nombre) {
		nombres.add(nombre);
	}

	public void agregarApellido(String apellido) {
		apellidos.add(apellido);
	}

	public void agregarEdad(String apellido) {
		edades.add(apellido);
	}

	public void agregarGenero(String genero) {
		generos.add(genero);
	}

	public void agregarPais(String pais) {
		paises.add(pais);
	}

	public void agregarCiudad(String ciudad) {
		ciudades.add(ciudad);
	}

	public ArrayList<String> noRepetidosYOrdenados(ArrayList<String> parametro) {
		ArrayList<String> nomb = new ArrayList<String>();
		boolean noRepetido = false;
		int j = 0;
		nomb.add(parametro.get(0));
		for (int i = 0; i < parametro.size() ; i++) {
			while (noRepetido == false || j < parametro.size()) {
				if (!nomb.get(i).equals(parametro.get(j))) {
					noRepetido = true;
				}
				j++;	
			}
			if(noRepetido) {
				nomb.add(parametro.get(j-1));
			}
			j=0;
			noRepetido = false;
		}
		ordenarAlfabeticamente(nomb);
		for (String i : nomb) {
		}
		return nomb;

	}

	private void ordenarAlfabeticamente(ArrayList<String> arreglo) {
		String auxIn;
		for (int i = 0; i < arreglo.size(); i++) {
			auxIn = arreglo.get(i);
			for (int j = 0 ; j < i ; j++) {
				if (arreglo.get(j).compareTo(auxIn) <  0 ) {
					arreglo.set(i, arreglo.get(j));
					arreglo.set(j, auxIn);
					auxIn = arreglo.get(i);
				}
			}
		}
	}


	public ArrayList<String> getNombres() {
		return nombres;
	}

	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}

	public ArrayList<String> getApellidos() {
		return apellidos;
	}

	public void setApellidos(ArrayList<String> apellidos) {
		this.apellidos = apellidos;
	}

	public ArrayList<String> getEdades() {
		return edades;
	}

	public void setEdades(ArrayList<String> edades) {
		this.edades = edades;
	}

	public ArrayList<String> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<String> generos) {
		this.generos = generos;
	}

	public ArrayList<String> getPaises() {
		return paises;
	}

	public void setPaises(ArrayList<String> paises) {
		this.paises = paises;
	}

	public ArrayList<String> getCiudades() {
		return ciudades;
	}

	public void setCiudades(ArrayList<String> ciudades) {
		this.ciudades = ciudades;
	}



}