package com.francis.metier;

public class Jeton {
	public Couleur couleur;
	
	public Jeton(Couleur couleur) {
		this.couleur = couleur;
	}
	/**
	 * 
	 * @return
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}
	/**
	 * Cette 
	 */
	public String toString() {
		return "Jeton{ couleur = " + this.couleur + "}"; 
	}

}
