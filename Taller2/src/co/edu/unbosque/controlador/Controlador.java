package co.edu.unbosque.controlador;
import java.io.IOException;
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
		// TODO Auto-generated method stub4
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/KEnYASeHJe", "KEnYASeHJe", "j9ff5yEYdI");
			Statement stament = miConexion.createStatement();
			ResultSet miresult = stament.executeQuery("SELECT * FROM datos");
			int i=0;
			while(miresult.next()) {
				i+=1;
				System.out.println(i);
				DAO.agregarNombre(miresult.getString("nombre"));
				DAO.agregarApellido(miresult.getString("apellido"));
				DAO.agregarEdad(miresult.getString("edad"));
				DAO.agregarGenero(miresult.getString("genero"));
				DAO.agregarPais(miresult.getString("pais"));
				DAO.agregarCiudad(miresult.getString("ciudad"));
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
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}