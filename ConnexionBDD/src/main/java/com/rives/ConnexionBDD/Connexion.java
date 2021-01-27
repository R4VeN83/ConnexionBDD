package com.rives.ConnexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe connexion
 * @author Alexandre
 *
 */
public class Connexion {

	private Connection con = null;
	private PreparedStatement prepareStat = null;

	/**
	 * Constructeur par défaut.
	 */
	public Connexion() {

	}

	/**
	 * Méthode qui permet de se connecter à la base de données.
	 */
	public void seConnecter() {

		/**
		 * Connexion à la base de données.
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite?serverTimezone=UTC", "root", "");
			if (con != null) {
				System.out.println("Connexion réussie");
			} else {
				System.out.println("Connexion échouée");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	/**
//	 * Fonction qui insère des données dans la BDD.
//	 */
//	public void insererDonnees() {
//		String insertQueryStatement = "INSERT INTO etudiant VALUES (?,?,?,?,?,?,?)";
//		try {
//			prepareStat = con.prepareStatement(insertQueryStatement);
//			prepareStat.setInt(1, 128);
//			prepareStat.setString(2, "Paulolol");
//			prepareStat.setString(3, "Pierre");
//			prepareStat.setString(4, "1995-02-12");
//			prepareStat.setString(5, "15 rue de Marseille");
//			prepareStat.setString(6, "13000");
//			prepareStat.setString(7, "Marseille");
//			prepareStat.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Méhode permettant de récupérer toutes les données de la table
	 */
	public void selectData() {
		String getQueryStatement = "SELECT * FROM etudiant";
		try {
			prepareStat = con.prepareStatement(getQueryStatement);
			ResultSet rs = prepareStat.executeQuery();
			while (rs.next()) {
				int numetu = rs.getInt("numetu");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				System.out.println("numetu : " + numetu + ", nom : " + nom + ", prénom : " + prenom);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
