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
	private ArrayList<Usuario> filtrados;
	private DTO DTO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		filtrados = new ArrayList<Usuario>();
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
		PrintWriter p = response.getWriter();

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

		PrintWriter p = response.getWriter();
		String respuesta = "";
		String nombre = request.getParameter("Nombre_usuario");
		String apellido = request.getParameter("Apellido_usuario");
		String edad = request.getParameter("Edad_usuario");
		String genero = request.getParameter("Genero_usuario");
		String pais = request.getParameter("Pais_usuario");
		String ciudad = request.getParameter("Ciudad_usuario");
		
		respuesta = "Filtrado para:"+" "+nombre+" "+apellido+" "+edad+" "+genero+" "+pais+" "+ciudad; 
		filtrados = filtrar(nombre, apellido, edad, genero, pais, ciudad);
			for (int i = 0; i < filtrados.size(); i++) {
				System.out.println(filtrados.get(i));
			}
		p.print("<!DOCTYPE html>     ");
		p.print("<html>     ");
		p.print("<head>     ");
		p.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		p.print("<title>Resultado</title>     ");
		p.print("<h1>"+respuesta+"</h1>     ");
		p.print("</head>     ");
		p.print("<body>     ");
		p.print("<link type=\"text/css\" rel=\"stylesheet\" href=\"Filo.css\" />");
		p.print("<table>     ");
		if (filtrados.size()==0) {
			for (Usuario i : usuarios) {
				p.print("<tr>     ");
				p.print("<td>"+i.getNombre()+"</td>");
				p.print("<td>"+i.getApellido()+"</td>");
				p.print("<td>"+i.getEdad()+"</td>");
				p.print("<td>"+i.getGenero()+"</td>");
				p.print("<td>"+i.getPais()+"</td>");
				p.print("<td>"+i.getCiudad()+"</td>");
				p.print("</tr>     ");
			}
		}
		else {
			for (Usuario i : filtrados) {
				p.print("<tr>     ");
				p.print("<td>"+i.getNombre()+"</td>");
				p.print("<td>"+i.getApellido()+"</td>");
				p.print("<td>"+i.getEdad()+"</td>");
				p.print("<td>"+i.getGenero()+"</td>");
				p.print("<td>"+i.getPais()+"</td>");
				p.print("<td>"+i.getCiudad()+"</td>");
				p.print("</tr>     ");
			}
		}

		p.print("</c:forEach>     ");
		p.print("</table>     ");
		p.print("</body>     ");
		p.print("</html>     ");
	}

	public ArrayList<Usuario> filtrar(String nombre, String apellido, 
			String edad, String genero, String pais, String ciudad) {
		ArrayList<Usuario> ahPerro = new ArrayList<Usuario>();
		for (Usuario i : usuarios) {
			if (i.getNombre().equals(nombre) || nombre.equals("-Nombres-")) {
				if (i.getApellido().equals(apellido) || apellido.equals("-Apellidos-")) {
					if (i.getEdad().equals(edad) || edad.equals("-Edades-")) {
						if (i.getGenero().equals(genero) || genero.equals("-Generos-")) {
							if (i.getPais().equals(pais) || pais.equals("-Paises-")) {
								if (i.getCiudad().equals(ciudad) || ciudad.equals("-Ciudades-")) {
									ahPerro.add(i);
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Filtrado para:"+" "+nombre+" "+apellido+" "+edad+" "+genero+" "+pais+" "+ciudad);
		return ahPerro;
	}
}