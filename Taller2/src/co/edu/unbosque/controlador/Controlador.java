package co.edu.unbosque.controlador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			java.sql.Statement stament = miConexion.createStatement();
			ResultSet miresult = stament.executeQuery("SELECT * FROM datos");
			int i=0;
			ArrayList<String> usu = new ArrayList<String>();
			while(miresult.next()) {
				i+=1;
//				String nombre= miresult.getString("nombre");
//				String apellido= miresult.getString("apellido");
//				String edad= miresult.getString("edad");
//				String genero= miresult.getString("genero");
//				String pais= miresult.getString("pais");
//				String ciudad= miresult.getString("ciudad");
//				Usuario almacen = new Usuario(nombre, apellido, edad, genero, pais, ciudad);
				usu.add(miresult.getString("nombre"));
			}
			request.setAttribute("lista_usuario", usu);
			request.setAttribute("numero_resultado", i);
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
