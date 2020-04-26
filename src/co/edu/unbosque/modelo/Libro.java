package co.edu.unbosque.modelo;

public class Libro {
	
	private int nLibro;
	private String titulo, tema;

	public Libro(String titulo, String tema, int nLibro) {
		super();
		this.titulo = titulo;
		this.tema = tema;
		this.nLibro = nLibro;
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

	public int getnLibro() {
		return nLibro;
	}

	public void setnnLibro(int nLibro) {
		this.nLibro = nLibro;
	}
	
	
}
