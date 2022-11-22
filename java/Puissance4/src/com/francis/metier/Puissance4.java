package com.francis.metier;

public class Puissance4 {
	private Partie partie;
	
	public Puissance4() {
		this.partie = new Partie();
	}
	
	public Puissance4(Partie partie) {
		this.partie = partie;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	/**
	 * 
	 * @return
	 */
	public boolean gameIsOver() {
		boolean isOver = false;	
		/*
		 * if(this.partie.getGrille().isFullGrille()) { isOver = true; }else
		 * if(this.partie.isParAbandon()==true) { isOver = true; }else
		 * if(this.partie.isPartieFinie()==true) { isOver = true; }
		 */
		if(this.partie.getGrille().isFullGrille() || this.partie.isParAbandon() 
				|| this.partie.isPartieFinie()==true) {
			isOver = true;
		} 
		return isOver;	
	}
	public void jouer(int numColonne) throws Puissance4Exception {		
		
		if(numColonne<0 || numColonne>=Config.NB_COLONNES)
			throw new Puissance4Exception("Colonne invalide");
		
		if(!this.gameIsOver()) {			
			//1-	Création du jeton avec le jour courant
			Jeton jeton = new Jeton(this.partie.getJoueurCourant().getNom());
			//2-	Inserer le jeton
					int ligne = this.partie.getGrille().insererJeton(jeton, numColonne);
			//3-	tester l'alignement
					//3-1	Création d'une position avec la ligne et la colonne
					Position pos = new Position(ligne, numColonne);
					//3-2	Appel de la méthode Alignement Réalisé
					if(this.partie.getGrille().alignementRealise(pos)){
						// On définit le gagnant
						this.partie.setGagnant(this.partie.getJoueurCourant());
						// On arrête le jeu
						this.partie.setPartieFinie(true);		
					}else {
						
						//Changer le joueur courant
						if(jeton.getCouleur()==this.partie.getJoueur()[0].getNom()) {							
							//this.partie.setJoueurCourant(new Joueur(Couleur.ROUGE));
							this.partie.setJoueurCourant(this.partie.getJoueur()[1]);
						}else {
							//this.partie.setJoueurCourant(new Joueur(Couleur.JAUNE));
							this.partie.setJoueurCourant(this.partie.getJoueur()[0]);
						}						
					}
		}
	}
	/**
	 * 
	 */
	public void abandonner() {
		//parAbandon = true
		this.partie.setParAbandon(true);
		this.partie.setPartieFinie(true);
		//test le joueur courant	
		if (this.partie.getJoueurCourant().getNom()== this.partie.getJoueur()[0].getNom()) {
			this.partie.setGagnant(this.partie.getJoueur()[1]);
		}else {
			this.partie.setGagnant(this.partie.getJoueur()[0]);
		}
	}
}
