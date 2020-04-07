package co.edu.unbosque.model;

public class Usuario {
	private String usuario;
	private String nombre;
	private String apellido;
	private String edad;
	private String genero;
	private String pais;
	private String ciudad;

	public Usuario(String nombre, String apellido, String edad, String genero, String pais, String ciudad) {
		super();
		this.setUsuario(usuario);
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.pais = pais;
		this.ciudad = ciudad;
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
	} String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String toString() {
		String res = "";
		res = " "+apellido.toUpperCase()+" "+nombre.toUpperCase()+ ", "+edad+", "+genero+", "+pais.toUpperCase()+", "+ciudad.toUpperCase()+"\n";
		return res;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}