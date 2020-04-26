package co.edu.unbosque.modelo;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class ClienteBean {

	String nombre,apellido,documento,usuario,contraseña, reContraseña;

	int numlibros;
	ArrayList<Reserva> reservas;
	ArrayList<ClienteBean> listaClientes;

	public ClienteBean() {

	}

	public ClienteBean(String nombre, String apellido, String documento, String usuario, String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.usuario = usuario;
		this.contraseña = contraseña;
		reservas  = new ArrayList<Reserva>();
		this.numlibros = 0;

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



	@Override
	public String toString() {
		return "ClienteBean [nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", usuario="
				+ usuario + ", contraseña=" + contraseña + "]";
	}

	public String doGuardar() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		listaClientes= (ArrayList<ClienteBean>) session.getAttribute("listaClientes");
		if (listaClientes == null) {
			listaClientes= new ArrayList<ClienteBean>();
			session.setAttribute("listaClientes",listaClientes);

		}
		System.out.println(contraseña.isEmpty());
		if (contraseña.equals(reContraseña)) {
			listaClientes.add(this);
			DAO.guardar(this);
			return "Login";

		}
		return null;

	}

}
