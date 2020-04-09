package co.edu.unbosque.controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DAO DAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		DAO = new DAO();
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// TODO Auto-generated method stub4
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
				try {
					Connection miConexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/KEnYASeHJe", "KEnYASeHJe", "j9ff5yEYdI");
					Statement stament = miConexion.createStatement();
					ResultSet miresult = stament.executeQuery("SELECT * FROM datos");
					int i=0;
					while(miresult.next()) {
						i+=1;
						String nombre = miresult.getString("nombre");
						String apellido = miresult.getString("apellido");
						String edad = miresult.getString("edad");
						String genero = miresult.getString("genero");
						String pais = miresult.getString("pais");
						String ciudad = miresult.getString("ciudad");					
						System.out.println(i);
						DAO.agregarUsuario(nombre, apellido, edad, genero, pais, ciudad);
						DAO.agregarNombre(nombre);
						DAO.agregarApellido(apellido);
						DAO.agregarEdad(edad);
						DAO.agregarGenero(genero);
						DAO.agregarPais(pais);
						DAO.agregarCiudad(ciudad);
					}

					request.setAttribute("Nombre_usuario", DAO.noRepetidosYOrdenados(DAO.getNombres()));
					request.setAttribute("Apellido_usuario", DAO.noRepetidosYOrdenados(DAO.getApellidos()));
					request.setAttribute("Edad_usuario", DAO.noRepetidosYOrdenados(DAO.getEdades()));
					request.setAttribute("Genero_usuario", DAO.noRepetidosYOrdenados(DAO.getGeneros()));
					request.setAttribute("Pais_usuario", DAO.noRepetidosYOrdenados(DAO.getPaises()));
					request.setAttribute("Ciudad_usuario", DAO.noRepetidosYOrdenados(DAO.getCiudades()));
					request.setAttribute("numeroresultado", i);
					RequestDispatcher miDis = request.getRequestDispatcher("/sofia.jsp");
					miDis.forward(request, response);


				} catch (Exception e) {
					
				}
				p.print("<!DOCTYPE html>     ");
				p.print("<html>     ");
				p.print("<head>     ");
				p.print("<meta charset=\"UTF-8\">     ");
				p.print("<title>Resultado</title>     ");
				p.print("<h1>Resultado</h1>     ");
				p.print("</head>     ");
				p.print("<body>     ");
				p.print("<link type=\"text/css\" rel=\"stylesheet\" href=\"Filo.css\" />");
				p.print("<table>     ");
				for (int j = 0; j < DAO.getUsuarios().size(); j++) {
					p.print("<tr>     ");
					p.print("<td>"+DAO.getUsuarios().get(j).getNombre()+"</td>");
					p.print("<td>"+DAO.getUsuarios().get(j).getApellido()+"</td>");
					p.print("<td>"+DAO.getUsuarios().get(j).getEdad()+"</td>");
					p.print("<td>"+DAO.getUsuarios().get(j).getGenero()+"</td>");
					p.print("<td>"+DAO.getUsuarios().get(j).getPais()+"</td>");
					p.print("<td>"+DAO.getUsuarios().get(j).getCiudad()+"</td>");
					p.print("</tr>     ");
				}
				p.print("</c:forEach>     ");
				p.print("</table>     ");
				p.print("</body>     ");
				p.print("</html>     ");
	}
}