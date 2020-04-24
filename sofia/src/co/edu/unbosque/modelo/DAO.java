package co.edu.unbosque.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DAO {
	static Connection conexion=null;
    static Statement sentencia;
    public static void conectar(){
        String ruta="jdbc:mysql://localhost/";
        String user="";
        String pass="";
        try {
            conexion=DriverManager.getConnection(ruta,user,pass); 
            sentencia= conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
    }
    public static void guardar(String x){
//        String q = "INSERT INTO Datos VALUES('"+x.getNombre()+"','"+x.getApellido()+"')";
//        ejecutar(q);
    }
    
    public static void ejecutar(String q){
        try {
            sentencia.executeUpdate(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
  

}
