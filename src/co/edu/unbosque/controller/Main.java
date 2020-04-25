package co.edu.unbosque.controller;

import co.edu.unbosque.modelo.ClienteBean;
import co.edu.unbosque.modelo.DAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Este sera una nueva rama en la repo de github (remoto)
		DAO d = new DAO();
		d.conectar();
//		ClienteBean x = new ClienteBean();
//		x.setNombre("Gabo");
//		x.setApellido("Venequeishon");
//		x.setDocumento("1231231233");
//		x.setUsuario("sofiaLover23");
//		x.setContraseña("XXX");
//		x.setNumlibros(x.getReservas().size());
//		d.guardar(x);
		for (int i = 0; i < d.getLibros().size(); i++) {
			System.out.println(d.getLibros().get(i).getTitulo());
		}
		
		
	}

}
