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
	ArrayList<String> titulos = new ArrayList<String>();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	ArrayList<Libro> libros  = new ArrayList<Libro>();
	static ArrayList<Libro> librosBBDD = DAO.getLibros();
	static ArrayList<ClienteBean> listaClientes = DAO.getClientes();

	public ClienteBean() {
			agregarReservas();
	}

	public ClienteBean(String nombre, String apellido, String documento, String usuario, String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.numlibros = 0;

	}
	public ClienteBean(String nombre, String apellido, String documento, String usuario, String contraseña, String libros) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.reservas = new ArrayList<Reserva>();
		this.libros = new ArrayList<Libro>();
		if (libros.contains(",")) {
			String[] str = libros.split(",");
			for (int i = 0 ; i < str.length ; i++) {
				this.libros.add(buscarLibro(Integer.parseInt(str[i])));
			}
		} else if (!libros.equals("0")) {
			this.libros.add(buscarLibro(Integer.parseInt(libros)));
		}
		
		this.numlibros = this.libros.size()-1;
	}
	 

	public String getReContraseña() {
		return reContraseña;
	}

	public void setReContraseña(String reContraseña) {
		this.reContraseña = reContraseña;
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public int getNumlibros() {
		return numlibros;
	}
	public void setNumlibros(int numlibros) {
		this.numlibros = numlibros;
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
	public void contabilizarReserva(Reserva nueva) {
		reservas.add(nueva);
		numlibros++;
		
	}

	public ArrayList<String> getTitulos() {
		return titulos;
	}

	public void setTitulos(ArrayList<String> titulos) {
		this.titulos = titulos;
	}

	public static ArrayList<Libro> getLibrosBBDD() {
		return librosBBDD;
	}

	public static void setLibrosBBDD(ArrayList<Libro> librosBBDD) {
		ClienteBean.librosBBDD = librosBBDD;
	}

	public static ArrayList<ClienteBean> getListaClientes() {
		return listaClientes;
	}

	public static void setListaClientes(ArrayList<ClienteBean> listaClientes) {
		ClienteBean.listaClientes = listaClientes;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public Libro buscarLibro(int nReserva) {
		for (Libro i : librosBBDD) {
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
//		FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
//		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//		Biblioteca nB =(Biblioteca) session.getAttribute("biblioteca.filtroS");
//		for (int i = 0; i < nB.getFiltroS().size(); i++) {
//			titulos.add(nB.getFiltroS().get(i).getTitulo());
//		}
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Agregado");
		Date hoy = new Date();
		int vencim = hoy.getDay()+3;
		Date ven = new Date(hoy.getYear(), hoy.getMonth(), vencim);
		for (int i = 0; i < 4; i++) {
//			reservas.add(new Reserva(titulos.get(i), buscarLibro(titulos.get(i)).getTema(), f.format(hoy), f.format(ven)));
			reservas.add(new Reserva("abcd", "abcd",f.format(hoy),f.format(ven)));
			System.out.println("Agregado "+reservas.get(i).getTitulo());
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

}
