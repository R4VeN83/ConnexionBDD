package com.rives.ConnexionBDD;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		
		Connexion con = new Connexion();
		con.seConnecter();
//		con.insererDonnees();
		con.selectData();
	}
	
	
}
