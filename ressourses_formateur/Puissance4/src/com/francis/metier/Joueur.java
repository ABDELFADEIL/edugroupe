package com.francis.metier;

public class Joueur {
	private Couleur nom;

	public Joueur(Couleur nom) {
		this.nom = nom;
	}
	public Couleur getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Joueur {nom=" + nom + "}";
	}
	

}
