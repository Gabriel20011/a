package co.edu.unbosque.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.bean.ViewScoped;

@ManagedBean
@RequestScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	String nombre,apellido,documento,usuario,contraseña;
	
	public ClienteBean() {
		nombre = "holi";
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
	HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	ArrayList<ClienteBean> listaClientes;
	listaClientes= (ArrayList<ClienteBean>) session.getAttribute("listaClientes");
	if (listaClientes == null) {
		listaClientes= new ArrayList<ClienteBean>();
		session.setAttribute("listaClientes",listaClientes);
		
	}
	listaClientes.add(this);
	return null;
}
}
