package com.gescom.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gescom.metier.Commande;

public class CommandeDao implements InterfaceDao<Commande> {
	private Connection conn;
	private Statement stm;
	private PreparedStatement ps;
	ResultSet rs;
	
	

	public CommandeDao() {
		try {
			this.conn = ConnexionDB.getConnexion();
			this.stm = this.conn.createStatement();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void insert(Commande t) throws Exception {
		this.ps = this.conn.prepareStatement("INSERT INTO commande VALUES(default,?,?)");	
		
		this.ps.setInt(1, t.getClient().getId());
		this.ps.setDate(2, t.getDateCmd());
		this.ps.executeUpdate();
	}

	@Override
	public void update(Commande t) throws Exception {
	this.ps = this.conn.prepareStatement("UPDATE commande SET  id_client =?,date_cmd=? WHERE id=?");	
		this.ps.setInt(1, t.getClient().getId());
		this.ps.setDate(2, t.getDateCmd());
		this.ps.setInt(3, t.getIdCmd());
		
		this.ps.executeUpdate();
		
	}

	@Override
	public void delete(Commande t) throws Exception {
		this.ps = this.conn.prepareStatement("DELETE FROM commande WHERE id=?");	
		this.ps.setInt(1, t.getIdCmd());
		
		this.ps.executeUpdate();
	}

	@Override
	public List<Commande> findAll() throws Exception {
		List<Commande> listeCommande = new ArrayList<>();
		
		rs = stm.executeQuery("SELECT * FROM commande");
				
		while (rs.next()) {
			//Commande cmd = new Commande(rs.getInt("id"),rs.getDate("date_cmd"), new Client(rs.getInt("id_client")));
			Commande cmd = new Commande(rs.getInt("id"),rs.getDate("date_cmd"),new CLientDao().findOneByID(rs.getInt("id_client")));
			listeCommande.add(cmd);
			
		}	
	return listeCommande;
	}

	@Override
	public Commande findOneByID(int id) throws Exception {
		Commande cmd = null ;
		  this.ps = this.conn.prepareStatement("SELECT * FROM commande WHERE id=?");
		  		this.ps.setInt(1, id);
		  		this.rs  = this.ps.executeQuery();
		  		
		  		if(this.rs.next()) {
		  			cmd = new Commande(rs.getInt("id"),rs.getDate("date_cmd"),new CLientDao().findOneByID(rs.getInt("id_client")));
		  		}
		  					  		
		  return cmd;	
	}

}
