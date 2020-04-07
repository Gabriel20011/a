package co.edu.unbosque.controlador;
import java.io.IOException;
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

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub4
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection miConexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/KEnYASeHJe", "KEnYASeHJe", "j9ff5yEYdI");
			Statement stament = miConexion.createStatement();
			ResultSet miresult = stament.executeQuery("SELECT * FROM datos");
			int i=0;
			ArrayList<String> nombres = new ArrayList<String>();
			ArrayList<String> apellidos = new ArrayList<String>();
			ArrayList<String> edades = new ArrayList<String>();
			ArrayList<String> generos = new ArrayList<String>();
			ArrayList<String> paises = new ArrayList<String>();
			ArrayList<String> ciudades = new ArrayList<String>();
			while(miresult.next()) {
				i+=1;
				nombres.add(miresult.getString("nombre"));
				apellidos.add(miresult.getString("apellido"));
				edades.add(miresult.getString("edad"));
				generos.add(miresult.getString("genero"));
				paises.add(miresult.getString("pais"));
				ciudades.add(miresult.getString("ciudad"));
			}

			request.setAttribute("Nombre_usuario", apellidos);
			request.setAttribute("Apellido_usuario", apellidos);
			request.setAttribute("Edad_usuario", edades);
			request.setAttribute("Genero_usuario", generos);
			request.setAttribute("Pais_usuario", paises);
			request.setAttribute("Ciudad_usuario", ciudades);
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