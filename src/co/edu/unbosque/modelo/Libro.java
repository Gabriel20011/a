package co.edu.unbosque.modelo;

public class Libro {
	private String titulo, tema;

	public Libro(String titulo, String tema) {
		super();
		this.titulo = titulo;
		this.tema = tema;
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
	
	
}
