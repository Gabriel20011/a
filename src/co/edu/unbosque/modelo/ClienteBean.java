package co.edu.unbosque.modelo;

import java.io.IOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class ClienteBean {

	String nombre,apellido,documento,usuario,contrase�a, reContrase�a;

	int numlibros;
	ArrayList<Reserva> reservas;
	ArrayList<Libro> libros ;
	static ArrayList<Libro> librosBBDD = DAO.getLibros();
	static ArrayList<ClienteBean> listaClientes = DAO.getClientes();

	public ClienteBean() {

	}

	public ClienteBean(String nombre, String apellido, String documento, String usuario, String contrase�a) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		reservas  = new ArrayList<Reserva>();
		libros = new ArrayList<Libro>();
		this.numlibros = 0;

	}
	public ClienteBean(String nombre, String apellido, String documento, String usuario, String contrase�a, String libros) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
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
	public Libro buscarLibro(int nReserva) {
		for (Libro i : librosBBDD) {
			if (i.getnLibro() == nReserva) {
				return i;
			}
		}
		return null;
	}

	public String getReContrase�a() {
		return reContrase�a;
	}

	public void setReContrase�a(String reContrase�a) {
		this.reContrase�a = reContrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public void contabilizarReserva(Reserva nueva) {
		reservas.add(nueva);
		numlibros++;
		
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public String doGuardar() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		listaClientes= (ArrayList<ClienteBean>) session.getAttribute("listaClientes");
		if (listaClientes == null) {
			listaClientes= new ArrayList<ClienteBean>();
			session.setAttribute("listaClientes",listaClientes);

		}
		if (contrase�a.equals(reContrase�a)) {
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
			if (i.getUsuario().equals(usuario) && i.getContrase�a().equals(contrase�a)) {
				sofia = i;
			}
		}
		if (sofia == null) {
			nombre = "Clave o Usuario incorrecta Papu :v";
			return "Login";
		}
		else {
			nombre = sofia.getNombre();
			return "Principal";
		}
	}

}
