package com.francis.metier;

public class Partie {
	//1-	Attributs
		private Grille grille;
		private Joueur[] joueur;
		private Joueur joueurCourant;
		private boolean partieFinie;
		private Joueur gagnant;
		private boolean parAbandon;
	//2-	Constructeur
		public Partie() {
			this.grille = new Grille();		
			/*
			 * this.joueur = new Joueur[2];
			 * 
			 * this.joueur[0] = new Joueur(Couleur.JAUNE); this.joueur[1] = new
			 * Joueur(Couleur.ROUGE);
			 */
			this.joueur = new Joueur[] {new Joueur(Couleur.JAUNE),
										new Joueur(Couleur.ROUGE)
										
									   };
			//	initialisation du joueur courant
			this.joueurCourant = this.joueur[(int)((Math.random()*2)%2)]; // utilisez ramdon de la classe Math
			//	initialisation du gagnant
			this.gagnant = null;
			//	
			this.partieFinie = false;
			//
			this.parAbandon = false;
		}
	//3-	getteurs
		public Grille getGrille() {
			return grille;
		}
		public Joueur[] getJoueur() {
			return joueur;
		}
		public Joueur getJoueurCourant() {
			return joueurCourant;
		}
		public boolean isPartieFinie() {
			return partieFinie;
		}
		public Joueur getGagnant() {
			return gagnant;
		}
		public boolean isParAbandon() {
			return parAbandon;
		}
		public void setGrille(Grille grille) {
			this.grille = grille;
		}
		public void setJoueur(Joueur[] joueur) {
			this.joueur = joueur;
		}
		public void setJoueurCourant(Joueur joueurCourant) {
			this.joueurCourant = joueurCourant;
		}
		public void setPartieFinie(boolean partieFinie) {
			this.partieFinie = partieFinie;
		}
		public void setGagnant(Joueur gagnant) {
			this.gagnant = gagnant;
		}
		public void setParAbandon(boolean parAbandon) {
			this.parAbandon = parAbandon;
		}
		
		
}
