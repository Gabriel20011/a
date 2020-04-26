package co.edu.unbosque.modelo;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class DAO {

	static Connection conexion=null;
	static Statement sentencia;
	
	
	public static void conectar(){
		String ruta="jdbc:mysql://remotemysql.com:3306/EuXwn9Coxe";
		String User="EuXwn9Coxe";
		String password="kxL3kNcQTN";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(ruta,User,password);
			System.out.println("Conectado");
			sentencia= conexion.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No conectado");
		}
	}

	public static void guardar(ClienteBean x){
		conectar();
		PreparedStatement ps;
		String ruta="jdbc:mysql://remotemysql.com:3306/EuXwn9Coxe";
		String User="EuXwn9Coxe";
		String password="kxL3kNcQTN";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(ruta,User,password);
			ps = conexion.prepareStatement("INSERT INTO tabla VALUES (?, ? ,? ,? , ?,?)");
			ps.setString(1, x.getNombre());
			ps.setString(2, x.getApellido());
			ps.setString(3, x.getDocumento());
			ps.setString(4, x.getUsuario());
			ps.setString(5, x.getContraseña());
			ps.setInt(6,x.getNumlibros() );
			ps.executeUpdate();  
			System.out.println("Se insertaron los valores");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public  void guardarlibro(Libro x){
		conectar();
		PreparedStatement ps;
		String ruta="jdbc:mysql://remotemysql.com:3306/EuXwn9Coxe";
		String User="EuXwn9Coxe";
		String password="kxL3kNcQTN";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(ruta,User,password);
			ps = conexion.prepareStatement("INSERT INTO tablalibros VALUES (?, ? )");
			ps.setString(1, x.getTitulo() );
			ps.setString(2, x.getTema());
			ps.executeUpdate();  
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public  void actualizarReserva (ClienteBean cliente) {
		conectar();
		PreparedStatement ps;
		String ruta="jdbc:mysql://remotemysql.com:3306/EuXwn9Coxe";
		String User="EuXwn9Coxe";
		String password="kxL3kNcQTN";
		String libros = String.join(",", (CharSequence[]) cliente.getLibros().toArray());
		System.out.println(libros);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(ruta,User,password);
			ps = conexion.prepareStatement("UPDATE tabla SET RESERVAS ="+ libros+ " WHERE USUARIO = "+ cliente.getUsuario());
			ps.executeUpdate();  
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<ClienteBean> getClientes() {
		conectar();
		ArrayList<ClienteBean> clientes = new ArrayList<ClienteBean>();
		String q = "SELECT * FROM tabla";
		ResultSet  resultado;
		try {
			resultado = sentencia.executeQuery(q);
			while(resultado.next()){
				clientes.add(new ClienteBean(resultado.getString("NOMBRE"), resultado.getString("APELLIDO")
						, resultado.getString("DOCUMENTO"), resultado.getString("USUARIO"),
						resultado.getString("CONTRASEÑA"), resultado.getString("RESERVAS")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public static ArrayList<Libro> getLibros() {
		conectar();
		ArrayList<Libro> lista = new ArrayList<Libro>();
		String q = "SELECT * FROM tablalibros";
		ResultSet  resultado;
		try {
			resultado = sentencia.executeQuery(q);
			while(resultado.next()){
				lista.add(new Libro(resultado.getString("TITULO"), resultado.getString("TEMA")
						, Integer.parseInt(resultado.getString("NUMERO RESERVA"))));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
