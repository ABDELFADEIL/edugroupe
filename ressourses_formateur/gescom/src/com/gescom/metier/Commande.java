package com.gescom.metier;

import java.sql.Date;

public class Commande {
	private int idCmd;
	private Date dateCmd;
	
	private Client client;
	
	public Commande() {
		this.client = new Client();
	}
	

	public Commande(int idCmd, Date dateCmd, Client client) {
		super();
		this.idCmd = idCmd;
		this.dateCmd = dateCmd;
		this.client = client;
	}


	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Commande [idCmd=" + idCmd + ", dateCmd=" + dateCmd + ", client=" + client + "]";
	}
	
	
	

}
