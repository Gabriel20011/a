package co.edu.unbosque.controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.Usuario;

public class DTO {
	
	public DTO(){	
	}
	
	public void cargarUsuarios(ArrayList<Usuario> us)  {
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String coneccion = "jdbc:mysql://remotemysql.com:3306/KEnYASeHJe?user=KEnYASeHJe&password=j9ff5yEYdI";
			con = DriverManager.getConnection(coneccion);
			
			statement = con.createStatement();
			
			resultSet = statement.executeQuery("SELECT * FROM datos");
			
			
			while(resultSet.next()) {
				String nombre = resultSet.getString("nombre") ;
				String apellido = resultSet.getString("apellido");;
				String edad = resultSet.getString("edad");
				String genero = resultSet.getString("genero");
				String pais = resultSet.getString("pais");
				String ciudad =  resultSet.getString("ciudad");
				us.add(new Usuario(nombre, apellido, edad, genero, pais, ciudad));
			}
			
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ah listo");
	}
	public ArrayList<String> noRepetidosYOrdenadosNombre(ArrayList<Usuario> usu) {
		ArrayList<String> nomb = new ArrayList<String>();
		for (Usuario i : usu) {
			nomb.add(i.getNombre());
		}
		ArrayList<Integer> rep = new ArrayList<Integer>();
		for (int i = 0 ; i < nomb.size() ; i++) {
			for (int j = i ; j < nomb.size() ; j++) {
				if (nomb.get(i).equals(nomb.get(j)) && i != j) {
					rep.add(j);
				}
			}
			for (int j = 0 ; j < rep.size() ; j++) {
				nomb.remove(rep.get(j) - j);
			}
			rep = new ArrayList<Integer>();
		}
		ordenarAlfabeticamente(nomb);
		return nomb;
	}
	public ArrayList<String> noRepetidosYOrdenadosApellido(ArrayList<Usuario> usu) {
		ArrayList<String> nomb = new ArrayList<String>();
		for (Usuario i : usu) {
			nomb.add(i.getApellido());
		}
		ArrayList<Integer> rep = new ArrayList<Integer>();
		for (int i = 0 ; i < nomb.size() ; i++) {
			for (int j = i ; j < nomb.size() ; j++) {
				if (nomb.get(i).equals(nomb.get(j)) && i != j) {
					rep.add(j);
				}
			}
			for (int j = 0 ; j < rep.size() ; j++) {
				nomb.remove(rep.get(j) - j);
			}
			rep = new ArrayList<Integer>();
		}
		ordenarAlfabeticamente(nomb);
		return nomb;
	}
	public ArrayList<String> noRepetidosYOrdenadosEdad(ArrayList<Usuario> usu) {
		ArrayList<String> nomb = new ArrayList<String>();
		for (Usuario i : usu) {
			nomb.add(i.getEdad());
		}
		ArrayList<Integer> rep = new ArrayList<Integer>();
		for (int i = 0 ; i < nomb.size() ; i++) {
			for (int j = i ; j < nomb.size() ; j++) {
				if (nomb.get(i).equals(nomb.get(j)) && i != j) {
					rep.add(j);
				}
			}
			for (int j = 0 ; j < rep.size() ; j++) {
				nomb.remove(rep.get(j) - j);
			}
			rep = new ArrayList<Integer>();
		}
		ordenarAlfabeticamente(nomb);
		return nomb;
	}
	public ArrayList<String> noRepetidosYOrdenadosGenero(ArrayList<Usuario> usu) {
		ArrayList<String> nomb = new ArrayList<String>();
		for (Usuario i : usu) {
			nomb.add(i.getGenero());
		}
		ArrayList<Integer> rep = new ArrayList<Integer>();
		for (int i = 0 ; i < nomb.size() ; i++) {
			for (int j = i ; j < nomb.size() ; j++) {
				if (nomb.get(i).equals(nomb.get(j)) && i != j) {
					rep.add(j);
				}
			}
			for (int j = 0 ; j < rep.size() ; j++) {
				nomb.remove(rep.get(j) - j);
			}
			rep = new ArrayList<Integer>();
		}
		ordenarAlfabeticamente(nomb);
		return nomb;
	}
	public ArrayList<String> noRepetidosYOrdenadosPais(ArrayList<Usuario> usu) {
		ArrayList<String> nomb = new ArrayList<String>();
		for (Usuario i : usu) {
			nomb.add(i.getPais());
		}
		ArrayList<Integer> rep = new ArrayList<Integer>();
		for (int i = 0 ; i < nomb.size() ; i++) {
			for (int j = i ; j < nomb.size() ; j++) {
				if (nomb.get(i).equals(nomb.get(j)) && i != j) {
					rep.add(j);
				}
			}
			for (int j = 0 ; j < rep.size() ; j++) {
				nomb.remove(rep.get(j) - j);
			}
			rep = new ArrayList<Integer>();
		}
		ordenarAlfabeticamente(nomb);
		return nomb;
	}
	public ArrayList<String> noRepetidosYOrdenadosCiudad(ArrayList<Usuario> usu) {
		ArrayList<String> nomb = new ArrayList<String>();
		for (Usuario i : usu) {
			nomb.add(i.getCiudad());
		}
		ArrayList<Integer> rep = new ArrayList<Integer>();
		for (int i = 0 ; i < nomb.size() ; i++) {
			for (int j = i ; j < nomb.size() ; j++) {
				if (nomb.get(i).equals(nomb.get(j)) && i != j) {
					rep.add(j);
				}
			}
			for (int j = 0 ; j < rep.size() ; j++) {
				nomb.remove(rep.get(j) - j);
			}
			rep = new ArrayList<Integer>();
		}
		
		ordenarAlfabeticamente(nomb);
		return nomb;
	}
	
	private void ordenarAlfabeticamente(ArrayList<String> arreglo) {
		String auxIn;
        for (int i = 0; i < arreglo.size(); i++) {
            auxIn = arreglo.get(i);
            for (int j = 0 ; j < i ; j++) {
                if (arreglo.get(j).compareTo(auxIn) >  0 ) {
                	arreglo.set(i, arreglo.get(j));
                	arreglo.set(j, auxIn);
                	auxIn = arreglo.get(i);
                }
            }
        }
    }
}
