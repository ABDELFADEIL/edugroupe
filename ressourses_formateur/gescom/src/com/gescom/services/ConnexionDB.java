package com.gescom.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
	
	private static final String URL_CONNEXION ="jdbc:mysql://localhost:3306/ges";
	private static final String USER ="root";
	private static final String PASSWORD ="";
	
	private static Connection objConn;
	
	/**
	 * 
	 */
	private ConnexionDB() {	
		try {
			//1-	Chargement du driver
				Class.forName("com.mysql.cj.jdbc.Driver");	
			//2-	Etablir la connexion à la base de données;
				objConn  = DriverManager.getConnection(URL_CONNEXION,USER,PASSWORD);				
		}catch (Exception e) {
			
		}		
	}
	/**
	 * 
	 * @return
	 */
	public static Connection getConnexion() {		
		if(objConn ==null) {
			new ConnexionDB();
		}
		return objConn;
	}
}
