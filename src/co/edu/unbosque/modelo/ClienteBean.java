package co.edu.unbosque.modelo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class ClienteBean {

	String nombre,apellido,documento,usuario,contraseña, reContraseña;
	int numlibros;
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	static ArrayList<Libro> libros = DAO.getLibros();
	static ArrayList<ClienteBean> listaClientes = DAO.getClientes();
	ArrayList<String> seleccionados = new ArrayList<String>();
	ArrayList<Libro> filtroS = new ArrayList<Libro>();
	ArrayList<String> temas = new ArrayList<String>();
	
	public ClienteBean() {
			temas();
	}

	public ClienteBean(String nombre, String apellido, String documento, String usuario, String contraseña) {
		temas();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.numlibros = 0;

	}
	public ClienteBean(String nombre, String apellido, String documento, String usuario, String contraseña, String libros) {
		temas();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.usuario = usuario;
		this.contraseña = contraseña;
//		this.reservas = new ArrayList<Reserva>();
//		this.libros = new ArrayList<Libro>();
//		if (libros.contains(",")) {
//			String[] str = libros.split(",");
//			for (int i = 0 ; i < str.length ; i++) {
//				this.libros.add(buscarLibro(Integer.parseInt(str[i])));
//			}
//		} else if (!libros.equals("0")) {
//			this.libros.add(buscarLibro(Integer.parseInt(libros)));
//		}
//		
//		this.numlibros = this.libros.size()-1;
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
	
	public void  temas(){
		String tema = "";
		for (int i = 0; i < libros.size() - 1; i++) {
			tema = libros.get(i).getTema();
			
			if (!tema.equals(libros.get(i+1).getTema())) {
				temas.add(tema);
			}
		}
	}
	public Libro buscarLibro(int nReserva) {
		for (Libro i : libros) {
			if (i.getnLibro() == nReserva) {
				return i;
			}
		}
		return null;
	}
	
	public Libro buscarLibro(String titulo) {
		Libro lib = null;
		for (int i = 0; i < libros.size(); i++) {
			if (titulo.equals(libros.get(i).getTitulo())) {
				lib = libros.get(i);
			}
		}
		return lib;
	}
	
	public void agregarReservas() {
		filtro();
		System.out.println(filtroS.size());
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date hoy = new Date();
		int vencim = hoy.getDay()+3;
		Date ven = new Date(hoy.getYear(), hoy.getMonth(), vencim);
		for (int i = 0; i <10; i++) {
//			reservas.add(new Reserva(filtroS.get(i).getTitulo(), filtroS.get(i).getTema(), f.format(hoy), f.format(ven)));
			reservas.add(new Reserva("abcd", "abcd",f.format(hoy),f.format(ven)));
			System.out.println("Agregado "+reservas.get(i).getTitulo());
		}
		for (int i = 0; i < reservas.size(); i++) {
			System.out.println(reservas.get(i).getTitulo());
		}
	}
	
	public String doGuardar() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		listaClientes= (ArrayList<ClienteBean>) session.getAttribute("listaClientes");
		if (listaClientes == null) {
			listaClientes= new ArrayList<ClienteBean>();
			session.setAttribute("listaClientes",listaClientes);

		}
		if (contraseña.equals(reContraseña)) {
			listaClientes.add(this);
			DAO.guardar(this);
			return "Login";

		}
		return null;

	}
	public String doLogin() {
		ClienteBean sofia = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		for (ClienteBean i : listaClientes) {
			if (i.getUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
				sofia = i;
			}
		}
		if (sofia == null) {
			usuario = "Clave o Usuario incorrecta";
			return "Login";
		}
		else {
			usuario = sofia.getNombre();
			return "Principal";
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getReContraseña() {
		return reContraseña;
	}

	public void setReContraseña(String reContraseña) {
		this.reContraseña = reContraseña;
	}

	public int getNumlibros() {
		return numlibros;
	}

	public void setNumlibros(int numlibros) {
		this.numlibros = numlibros;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public static ArrayList<ClienteBean> getListaClientes() {
		return listaClientes;
	}

	public static void setListaClientes(ArrayList<ClienteBean> listaClientes) {
		ClienteBean.listaClientes = listaClientes;
	}

	public ArrayList<String> getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(ArrayList<String> seleccionados) {
		this.seleccionados = seleccionados;
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

}
