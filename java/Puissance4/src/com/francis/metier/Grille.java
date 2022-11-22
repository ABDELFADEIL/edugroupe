package com.francis.metier;


public class Grille {
	
	public static final int NB_LIGNES = Config.NB_LIGNES;
	public static final int NB_COLONNES = Config.NB_COLONNES;
	
	private Jeton[][] plateauJetons;

	public Grille() {
		this.plateauJetons = new Jeton[NB_LIGNES][NB_COLONNES];
	}
	/**
	 * 
	 * @param plateauJetons
	 */
	public Grille(Jeton[][] plateauJetons) {
		this.plateauJetons = plateauJetons;
	}
	/**
	 * 
	 * @return
	 */
	public Jeton[][] getPlateauJetons() {
		return plateauJetons;
	}
	/**
	 * Cette M�thode permet d'ins�rer un jeton et retourne la ligne 
	 * � laquelle le jeton a �t� ins�r�.
	 * @param jeton
	 * @param numColonne
	 * @return
	 */
	public int insererJeton(Jeton jeton,int numColonne) {
		// On initialise ligne � -1 pour rentrer dans la boucle
		int indice_ligne = -1;	
		int i = NB_LIGNES -1;		
		while(indice_ligne == -1) {			
			//2-	On v�rifie l'existence d'un jeton � cette position ou non			
				if(this.plateauJetons[i][numColonne] == null) {					
					// Sauvegarde l'indice de ligne
						indice_ligne =i;
					// Ins�rer jeton
						this.plateauJetons[i][numColonne]= jeton;			
				}				
			i--;		
		}		
		return indice_ligne;
	}
	
	public String toString() {
		String chaine ="";	
		for(int i =0; i<this.plateauJetons.length;i++) {			
			for(int j=0;j<this.plateauJetons[i].length;j++) {				
				if(this.plateauJetons[i][j] == null) {
					chaine += "|    ";
				}else if(this.plateauJetons[i][j].getCouleur() == Couleur.JAUNE) {
					chaine += "|  J ";
				}else {
					chaine += "|  R ";
				}	
			}
			chaine +="\n";
		}
		return chaine;
	}
	/**
	 * 
	 * @param numColonne
	 * @return
	 */
	public boolean isFullColonne(int numColonne) {
		// on v�rifie l'existence d'un jeton � la derni�re ligne ( indice 0)	
			return this.plateauJetons[0][numColonne] != null;
	}
	public boolean isFullGrille() {
		int numColonne =0 ;
		boolean isFull = true;

		while(numColonne <NB_COLONNES && isFull) {		
			if(isFullColonne(numColonne)) {
				numColonne++;
			}else {
				isFull = false;
			}
		}	
		return isFull;
	}
	/**
	 * 
	 * @param position
	 * @return
	 */
	public boolean alignementRealise(Position position) {
		
		return alignementVertical(position) >=4 
				|| alignementHorizontal(position) >=4 
				|| alignementDiagonal1(position) >=4 
				|| alignementDiagonal2(position) >=4 ;
	}
	
	/**
	 * 
	 * @param position
	 * @return
	 */
	public int alignementHorizontal(Position position) {
		
		//1-	D�clartion des variables
			Couleur couleurDuJetonInsere;
			int ligne,colonne, compteurDeJetonDeMemeCouleur;
			boolean memeCouleur;
		//2-	Initialisation
			couleurDuJetonInsere = this.plateauJetons[position.getLigne()][position.getColonne()].getCouleur();
			ligne = position.getLigne();
			colonne = position.getColonne()-1;
			compteurDeJetonDeMemeCouleur = 1;
			memeCouleur = true;
			
		//3-	Regardons � la gauche du jeton ins�r�
			
			while(colonne >=0  && memeCouleur) {
				if(this.plateauJetons[ligne][colonne] != null &&
						this.plateauJetons[ligne][colonne].getCouleur() == couleurDuJetonInsere)  {
					//if(this.plateauJetons[ligne][colonne].getCouleur() == couleurDuJetonInsere) {
						compteurDeJetonDeMemeCouleur++;
						colonne--;
					}else {
						memeCouleur = false;
					}
				//}else {
				//	memeCouleur = false;
				//}		
			}
		//4-	Regardons � la droite du jeton � partir du jeton ins�r�
			ligne = position.getLigne();
			colonne = position.getColonne()+1;
			memeCouleur = true;
			
			while(colonne < NB_COLONNES  && memeCouleur) {
				if(this.plateauJetons[ligne][colonne] != null &&
						this.plateauJetons[ligne][colonne].getCouleur() == couleurDuJetonInsere)  {
					
						compteurDeJetonDeMemeCouleur++;
						colonne++;
					}else {
						memeCouleur = false;
					}
			}
		
		return compteurDeJetonDeMemeCouleur;
	}
	/**
	 * 
	 * @param position
	 * @return
	 */
	public int alignementVertical(Position position) {
	
		//1-	D�clartion des variables
			Couleur couleurDuJetonInsere;
			int ligne,colonne, compteurDeJetonDeMemeCouleur;
			boolean memeCouleur;
		//2-	Initialisation
			couleurDuJetonInsere = this.plateauJetons[position.getLigne()][position.getColonne()].getCouleur();
			ligne = position.getLigne() - 1;
			colonne = position.getColonne();
			compteurDeJetonDeMemeCouleur = 1;
			memeCouleur = true;
			
		//3-	Regardons en haut  du jeton ins�r�
			
			while(ligne >=0  && memeCouleur) {
				
				//position.setLigne(ligne);
				Position pos = new Position(ligne, colonne);
				
				if(this.getJeton(pos) != null &&
						this.getJeton(pos).getCouleur() == couleurDuJetonInsere)  {
						compteurDeJetonDeMemeCouleur++;
						ligne--;
						
					}else {
						memeCouleur = false;
					}	
			}
		//4-	Regardons en bas  du jeton � partir du jeton ins�r�
			ligne = position.getLigne() + 1;
			colonne = position.getColonne();
			memeCouleur = true;		
			while(ligne < NB_LIGNES  && memeCouleur) {
				Position pos = new Position(ligne, colonne);
				if(this.getJeton(pos) != null &&
						this.getJeton(pos).getCouleur() == couleurDuJetonInsere)  {
					
						compteurDeJetonDeMemeCouleur++;
						ligne++;
						
					}else {
						memeCouleur = false;
					}
			}	
		return compteurDeJetonDeMemeCouleur;
	}
	/**
	 * 
	 * @param position
	 * @return
	 */
	public int alignementDiagonal1(Position position) {

		
		//1-	D�clartion des variables
			Couleur couleurDuJetonInsere;
			int ligne,colonne, compteurDeJetonDeMemeCouleur;
			boolean memeCouleur;
		//2-	Initialisation
			couleurDuJetonInsere = this.plateauJetons[position.getLigne()][position.getColonne()].getCouleur();
			ligne = position.getLigne() - 1;
			colonne = position.getColonne()-1;
			compteurDeJetonDeMemeCouleur = 1;
			memeCouleur = true;
			
		//3-	Regardons en haut � la gauche du jeton  ins�r�
		/*
		 * position.setLigne(ligne); position.setColonne(colonne);
		 */
			while(ligne >=0 && colonne >=0 && memeCouleur) {
				Position pos = new Position(ligne, colonne);
				if(this.getJeton(pos) != null &&
						this.getJeton(pos).getCouleur() == couleurDuJetonInsere)  {
						compteurDeJetonDeMemeCouleur++;
						ligne--;
						colonne--;
					}else {
						memeCouleur = false;
					}	
			}
		//4-	Regardons en bas  du jeton � partir du jeton ins�r�
			ligne = position.getLigne()+ 1;
			colonne = position.getColonne()+1;
			memeCouleur = true;
			/*
			 * position.setLigne(ligne); position.setColonne(colonne);
			 */
			while(ligne < NB_LIGNES &&colonne<NB_COLONNES && memeCouleur) {
				Position pos = new Position(ligne, colonne);
				if(this.getJeton(pos) != null &&
						this.getJeton(pos).getCouleur() == couleurDuJetonInsere)  {
					
						compteurDeJetonDeMemeCouleur++;
						ligne++;
						colonne++;
						
					}else {
						memeCouleur = false;
					}
			}	
		return compteurDeJetonDeMemeCouleur;
	}
	/**
	 * 
	 * @param position
	 * @return
	 */
	public int alignementDiagonal2(Position position) {
		
		//1-	D�clartion des variables
			Couleur couleurDuJetonInsere;
			int ligne,colonne, compteurDeJetonDeMemeCouleur;
			boolean memeCouleur;
		//2-	Initialisation
			couleurDuJetonInsere = this.plateauJetons[position.getLigne()][position.getColonne()].getCouleur();
			ligne = position.getLigne() + 1;
			colonne = position.getColonne()-1;
			compteurDeJetonDeMemeCouleur = 1;
			memeCouleur = true;
			
		//3-	Regardons � gauche et en bas du jeton  ins�r�
		/*
		 * position.setLigne(ligne); position.setColonne(colonne);
		 */
			while(ligne < NB_LIGNES && colonne >=0 && memeCouleur) {
				Position pos = new Position(ligne, colonne);
				if(this.getJeton(pos) != null &&
						this.getJeton(pos).getCouleur() == couleurDuJetonInsere)  {
						compteurDeJetonDeMemeCouleur++;
						ligne++;
						colonne--;
					}else {
						memeCouleur = false;
					}	
			}
		//4-	Regardons � droite et en haut  du jeton  ins�r�
			ligne = position.getLigne()- 1;
			colonne = position.getColonne()+1;
			memeCouleur = true;
			/*
			 * position.setLigne(ligne); position.setColonne(colonne);
			 */
			while(ligne >=0 && colonne< NB_COLONNES && memeCouleur) {
				Position pos = new Position(ligne, colonne);
				if(this.getJeton(pos) != null &&
						this.getJeton(pos).getCouleur() == couleurDuJetonInsere)  {				
						compteurDeJetonDeMemeCouleur++;
						ligne--;
						colonne++;
						
					}else {
						memeCouleur = false;
					}
			}	
		return compteurDeJetonDeMemeCouleur;
	}
	/**
	 * Cette M�thode permet de retourner un Jeton � la position
	 * pass�e � param�tre.
	 * @param pos
	 * @return
	 */
	public Jeton getJeton(Position pos) {
		return this.plateauJetons[pos.getLigne()][pos.getColonne()];
	}
	
}
