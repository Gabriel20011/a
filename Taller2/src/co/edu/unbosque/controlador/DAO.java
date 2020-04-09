package co.edu.unbosque.controlador;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;


public class DAO {
	private ArrayList<Usuario> usuarios;
	private ArrayList<String> nombres;
	private ArrayList<String> apellidos;
	private ArrayList<String> edades;
	private ArrayList<String> generos;
	private ArrayList<String> paises;
	private ArrayList<String> ciudades;

	public DAO() {
		usuarios = new ArrayList<Usuario>();
		nombres = new ArrayList<String>();
		apellidos = new ArrayList<String>();
		edades = new ArrayList<String>();
		generos = new ArrayList<String>();
		paises = new ArrayList<String>();
		ciudades = new ArrayList<String>();
		usuariosDePrueba();
	}
	public void agregarUsuario(String nombre, String apellido, String edad, String genero, String pais, String ciudad) {
		usuarios.add(new Usuario(nombre, apellido, edad, genero, pais, ciudad));
	}
	public void agregarNombre(String nombre) {
		nombres.add(nombre);
	}

	public void agregarApellido(String apellido) {
		apellidos.add(apellido);
	}

	public void agregarEdad(String edad) {
		edades.add(edad);
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
	
	public void usuariosDePrueba(){
		usuarios.add(new Usuario("Juanito","Alimaña","20", "Masculino", "Colombia", "Bogota"));
		usuarios.add(new Usuario("Sofia","De Alimaña","18", "Fememino", "Japon", "Tokio"));
		usuarios.add(new Usuario("Gabriel","Oterga","19", "Masculino", "Polonia", "Helsinski"));
		usuarios.add(new Usuario("Juanito","Flowers","19", "Masculino", "Inglaterra", "Londres"));
	}

	public ArrayList<String> noRepetidosYOrdenados(ArrayList<String> parametro) {
		ArrayList<String> nomb = new ArrayList<String>();
		for (String i : parametro) {
			nomb.add(i);
		}
		ArrayList<Integer> rep = new ArrayList<Integer>();
		for (int i = 0 ; i < nomb.size() ; i++) {
			for (int j = i ; j < nomb.size() ; j++) {
				if (nomb.get(i).equals(nomb.get(j)) && i != j) {
					rep.add(j);
				}
			}
			for (int j = 0 ; j < rep.size() ; j++) {
				nomb.remove(rep.get(j) - j);
			}
			rep = new ArrayList<Integer>();
		}
		
		ordenarAlfabeticamente(nomb);
		return nomb;
	}
	private void ordenarAlfabeticamente(ArrayList<String> arreglo) {
		String auxIn;
		for (int i = 0; i < arreglo.size(); i++) {
			auxIn = arreglo.get(i);
			for (int j = 0 ; j < i ; j++) {
				if (arreglo.get(j).compareTo(auxIn) >  0 ) {
					arreglo.set(i, arreglo.get(j));
					arreglo.set(j, auxIn);
					auxIn = arreglo.get(i);
				}
			}
		}
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
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
