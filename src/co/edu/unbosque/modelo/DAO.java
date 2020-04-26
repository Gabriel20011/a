package co.edu.unbosque.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	
	static Connection conexion=null;
    static Statement sentencia;
    public void conectar(){
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
    
    public ArrayList<ClienteBean> getCliente() {
    	ArrayList<ClienteBean> clientes = null;
    	
    	return clientes;
    }
    
    public ArrayList<Libro> getLibros() {
		ArrayList<Libro> lista = new ArrayList<Libro>();
		String q = "SELECT * FROM tablalibros";
		ResultSet  resultado;
        try {
            resultado = sentencia.executeQuery(q);
            while(resultado.next()){
                lista.add(new Libro(resultado.getString("TITULO"), resultado.getString("TEMA")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
	}
}
