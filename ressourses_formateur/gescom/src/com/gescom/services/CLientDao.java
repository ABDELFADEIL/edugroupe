package com.gescom.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gescom.metier.Client;

public class CLientDao  implements InterfaceDao<Client>{
	
	private Connection conn;
	private Statement stm;
	private PreparedStatement ps;
	ResultSet rs;
	
	public CLientDao(){
		
		try {
			this.conn = ConnexionDB.getConnexion();
			this.stm = this.conn.createStatement();
			
		}catch (Exception e) {
		}
	}

	@Override
	public void insert(Client t) throws Exception{	
		this.ps = this.conn.prepareStatement("INSERT INTO client VALUES(default,?,?,?)");	
		
		this.ps.setString(1, t.getNom());
		this.ps.setString(2, t.getPrenom());
		this.ps.setString(3, t.getAdresse());
		this.ps.executeUpdate();
		
	}

	@Override
	public void update(Client t)  throws Exception{
		
		this.ps = this.conn.prepareStatement("UPDATE client SET  nom =?,prenom=?,adresse=? WHERE id=?");
		
		this.ps.setString(1, t.getNom());
		this.ps.setString(2, t.getPrenom());
		this.ps.setString(3, t.getAdresse());
		this.ps.setInt(4, t.getId());	
		
		this.ps.executeUpdate();
	}

	@Override
	public void delete(Client t) throws Exception{
		this.ps = this.conn.prepareStatement("DELETE FROM client WHERE id=?");
		this.ps.setInt(1, t.getId());	
		this.ps.executeUpdate();	
	}

	@Override
	public List<Client> findAll() throws Exception{	
		
			List<Client> listeClient = new ArrayList<>();
			
			rs = stm.executeQuery("SELECT * FROM client");
					
			while (rs.next()) {
				Client clt = new Client(rs.getInt("id") , rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"));
				listeClient.add(clt);
				
			}	
		return listeClient;
	}

	@Override
	public Client findOneByID(int id) throws Exception{
			Client clt = null ;
			  this.ps = this.conn.prepareStatement("SELECT * FROM client WHERE id=?");
			  		this.ps.setInt(1, id);
			  		this.rs  = this.ps.executeQuery();
			  		
			  		if(this.rs.next()) {
			  			clt = new Client(rs.getInt("id") , rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"));
			  		}
			  					  		
			  return clt;		 
		//return null;
	}
}
