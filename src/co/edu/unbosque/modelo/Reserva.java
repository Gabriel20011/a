package co.edu.unbosque.modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Reserva {
	private String titulo, tema, reserva, devolucion;

	public Reserva(String titulo, String tema, String reserva, String devolucion) {
		this.titulo = titulo;
		this.tema = tema;
		this.reserva = reserva;
		this.devolucion = devolucion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getReserva() {
		return reserva;
	}

	public void setReserva(String reserva) {
		this.reserva = reserva;
	}

	public String getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(String devolucion) {
		this.devolucion = devolucion;
	}
	
}
