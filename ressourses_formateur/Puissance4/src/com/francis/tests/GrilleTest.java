package com.francis.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.francis.metier.Couleur;
import com.francis.metier.Grille;
import com.francis.metier.Jeton;
import com.francis.metier.Position;

class GrilleTest {
	
	Grille grille = new Grille();
	
	@Test
	void testAlignementHorizontal() {
		// Bien regardé les notions de BDD et de TDD 
		
		int valeurAttendue = 2,numColonne = 2,ligne ;
		
		//insérer un jeton et création d'une position
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),numColonne);
		numColonne--;
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),numColonne);
		
		Position pos = new Position(ligne,numColonne);
		
		assertEquals(valeurAttendue, this.grille.alignementHorizontal(pos));
		
	}
	@Test
	void testAlignementVertical() {
		// Bien regardé les notions de BDD et de TDD 
		
		int valeurAttendue = 4, numColonne = 3,ligne ;
		
		//insérer un jeton et création d'une position
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),numColonne);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),numColonne);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),numColonne);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),numColonne);
		
		Position pos = new Position(ligne,numColonne);
		
		assertEquals(valeurAttendue, this.grille.alignementVertical(pos));
	}
	
	@Test
	void testAlignementDiagonal1() {
		// Bien regardé les notions de BDD et de TDD 
		this.grille = new Grille();
		
		int valeurAttendue = 3,ligne ;
		
		//insérer un jeton et création d'une position
		/*
		 * ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),2); ligne =
		 * this.grille.insererJeton(new Jeton(Couleur.JAUNE),3); ligne =
		 * this.grille.insererJeton(new Jeton(Couleur.JAUNE),2);
		 * 
		 * ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),1); ligne =
		 * this.grille.insererJeton(new Jeton(Couleur.JAUNE),1); ligne =
		 * this.grille.insererJeton(new Jeton(Couleur.JAUNE),1);
		 */
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),2);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),3);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),2);
		
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),1);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),1);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),1);
		
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),3);
		
		
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),4);
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),4);
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),4);
		
		//ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),numColonne);
		Position pos = new Position(3,1);
		
		assertEquals(valeurAttendue, this.grille.alignementDiagonal1(pos));
	}
	@Test
	void testAlignementDiagonal2() {
		// Bien regardé les notions de BDD et de TDD 
		this.grille = new Grille();
		
		int valeurAttendue = 3,ligne ;
		
		//insérer un jeton et création d'une position
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),2);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),3);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),2);
		
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),1);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),1);
		ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),1);
		
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),3);
		
		
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),4);
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),4);
		ligne = this.grille.insererJeton(new Jeton(Couleur.ROUGE),4);
		
		//ligne = this.grille.insererJeton(new Jeton(Couleur.JAUNE),numColonne);
		
		System.out.println(this.grille.toString());
		
		Position pos = new Position(ligne,4);	
		assertEquals(valeurAttendue, this.grille.alignementDiagonal2(pos));
	}
}
