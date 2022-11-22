package com.gescom.vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gescom.metier.Client;
import com.gescom.services.CLientDao;
import com.gescom.services.ConnexionDB;

public class Principale {

	public static void main(String[] args) {
		
		//1-	Test de ClientDAO
			CLientDao cltDao = new CLientDao();
			
				
			try {
				//1-1	FindAll();
					//System.out.println(cltDao.findAll());
					
				//1-2	FindOneById	
					System.out.println(cltDao.findOneByID(5));
					
				//1-2	Insert
					cltDao.insert(new Client(0,"Pierre","Dupond","45 Rue de Paris, 75009 Paris"));
					
					//System.out.println(cltDao.findAll());
					
				//1-3 	DELETE
					
				//1-4	UPDATE
					
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		
		
		
		
		
		
		/*	*//**
				 * API JDBC
				 *//*
					 * String URL_CONNEXION ="jdbc:mysql://localhost:3306/ges"; String USER ="root";
					 * String PASSWORD="";
					 * 
					 * try { //1- Chargement du driver //Class.forName("com.mysql.cj.jdbc.Driver");
					 * 
					 * // System.out.println("Driver chargé"); //2- Etablir la connexion à la base
					 * de données; //Connection objetConn =
					 * DriverManager.getConnection(URL_CONNEXION,USER,PASSWORD);
					 * //System.out.println("Connexion établie");
					 * 
					 * //3- Exécution des requêtes //3-1 requêtes simples : Statement (SELECT)
					 * 
					 * 
					 * Connection objetConn = ConnexionDB.getConnexion();
					 * 
					 * Statement stm = objetConn.createStatement(); String req =
					 * "SELECT * FROM client";
					 * 
					 * ResultSet rs = stm.executeQuery(req);
					 * 
					 * while (rs.next()) {
					 * 
					 * System.out.println("ID :" + rs.getInt("id") + "NOM : "+ rs.getString("nom"));
					 * } //3-2 DELETE int idClient = 3; String requeteDelte =
					 * "DELETE FROM client WHERE id ="+idClient;
					 * 
					 * //int retour = stm.executeUpdate(requeteDelte);
					 * //System.out.println("Valeur de retour : "+ retour);
					 * 
					 * //3-3 Requêtes paramétrées : PrepareStatement //- INSERT PreparedStatement ps
					 * = objetConn.prepareStatement("INSERT INTO client values(default,?,?,?)");
					 * 
					 * ps.setString(1, "Simpson"); ps.setString(2, "Lisa");
					 * ps.setString(3,"112 Rue de picpus, 75012 Paris");
					 * 
					 * 
					 * ps.executeUpdate(); //3-4 Update ps =objetConn.
					 * prepareStatement("UPDATE client SET nom= ?, prenom=?,adresse=?  WHERE id = ?"
					 * );
					 * 
					 * ps.setString(1, "Simpson"); ps.setString(2, "Bart");
					 * ps.setString(3,"112 Rue de picpus, 75012 Paris"); ps.setInt(4, idClient);
					 * 
					 * ps.executeUpdate();
					 * 
					 * 
					 * //
					 * 
					 * 
					 * }catch (Exception e ) { System.out.println("Error : " + e.getMessage());
					 * //e.getStackTrace(); }
					 */
	}

}
