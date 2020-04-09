package co.edu.unbosque.controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.model.Usuario;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> usuarios;
	private DTO DTO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		usuarios = new ArrayList<Usuario>();
		DTO = new DTO();
		DTO.cargarUsuarios(usuarios);



		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		request.setAttribute("Nombre_usuario", DTO.noRepetidosYOrdenadosNombre(usuarios));
		request.setAttribute("Apellido_usuario", DTO.noRepetidosYOrdenadosApellido(usuarios));
		request.setAttribute("Edad_usuario", DTO.noRepetidosYOrdenadosEdad(usuarios));
		request.setAttribute("Genero_usuario", DTO.noRepetidosYOrdenadosGenero(usuarios));
		request.setAttribute("Pais_usuario", DTO.noRepetidosYOrdenadosPais(usuarios));
		request.setAttribute("Ciudad_usuario", DTO.noRepetidosYOrdenadosCiudad(usuarios));
		request.setAttribute("numeroresultado", usuarios.size());
		RequestDispatcher miDis = request.getRequestDispatcher("/sofia.jsp");

		miDis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String nombre = request.getParameter("Nombre_usuario");
		String apellido = request.getParameter("Apellido_usuario");
		String edad = request.getParameter("Edad_usuario");
		String genero = request.getParameter("Genero_usuario");
		String pais = request.getParameter("Pais_usuario");
		String ciudad = request.getParameter("Ciudad_usuario");

		ArrayList<Usuario> filtro = filtrar(nombre, apellido, edad, genero, pais, ciudad);

		String respuesta = "Filtrado para:"+" "+nombre+" "+apellido+" "+edad
				+" "+genero+" "+pais+" "+ciudad;

		int nPaginas = 1;
		for (int i = 0 ; i < filtro.size() ; i++) {
			if (i % 50 == 0) {
				nPaginas ++;
			}
		}

		System.out.println(nPaginas);
		request.setAttribute("nPaginas", nPaginas );
		request.setAttribute("respuesta", respuesta);
		request.setAttribute("Filtrados", filtro);

		RequestDispatcher rd = request.getRequestDispatcher("gabox.jsp");
		rd.forward(request, response);


	}

	public ArrayList<Usuario> filtrar(String nombre, String apellido, 
			String edad, String genero, String pais, String ciudad) {
		ArrayList<Usuario> ahPerro = new ArrayList<Usuario>();
		for (Usuario i : usuarios) {
			if (i.getNombre().equals(nombre) || nombre.equals("-Nombres-")) {
				if (i.getApellido().equals(apellido) || apellido.equals("-Apellidos-")) {
					if (i.getEdad().equals(edad) || edad.equals("-Edades-")) {
						if (i.getGenero().equals(genero) || genero.equals("-Generos-")) {
							if (i.getPais().equals(pais) || pais.equals("-Paises-") ) {
								if (i.getCiudad().equals(ciudad) || ciudad.equals("-Ciudades-")) {
									ahPerro.add(i);
								}
							}
						}
					}
				}
			}
		}
		return ahPerro;
	}
}