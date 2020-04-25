package co.edu.unbosque.modelo;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class ClienteBean {
	
	String nombre,apellido,documento,usuario,contraseña;
	int numlibros;
	ArrayList<Reserva> reservas  = new ArrayList<Reserva>();
	ArrayList<ClienteBean> listaClientes;
	HttpSession session;
	public ClienteBean() {
		
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



public String doGuardar() {
	FacesContext context = FacesContext.getCurrentInstance();
	session = (HttpSession) context.getExternalContext().getSession(true);
	listaClientes= (ArrayList<ClienteBean>) session.getAttribute("listaClientes");
	if (listaClientes == null) {
		listaClientes= new ArrayList<ClienteBean>();
		session.setAttribute("listaClientes",listaClientes);
		
	}
	listaClientes.add(this);
	return null;
}

}
