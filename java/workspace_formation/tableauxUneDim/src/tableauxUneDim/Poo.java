package tableauxUneDim;

import java.util.ArrayList;
import java.util.List;

import tableauxUneDim.heritage.Etudiant;

public class Poo {

	public static void main(String[] args) {
		/**
		 * 	1-	Classe
		 *  2-	Objet
		 *  3-	propriétes
		 *  	3-1	les types primitifs comme attributs
		 *  	3-2	les objects comme attributs
		 *  	3-3	les tableaux comme attributs
		 *  4-	méthodes de classes (getteurs et setteurs ou accesseurs et mutateurs)
		 *  5-	constructeurs
		 *  6-	les visibilités ==> encapsulation
		 *  7-	la surchage
		 *  8-	Héritage
		 *  	7-1 la réécriture
		 *  	7-2 classe fille ou sous classe
		 * 	9- polymorphisme
		 * 
		 * 	Exemple : Personne (id,nom, prenom, email)
		 */
		
		// Test
		Personne pers1 = new Personne();
		Personne pers2 = new Personne(1);
		Personne pers3 = new Personne(2, "Lisa");
		// Affichage des objets
		System.out.println(pers1.toString());
		System.out.println(pers2.toString());
		System.out.println(pers3.toString());
		
		pers1 = pers2;
		
		// comparer deux objets
		System.out.println(pers1 == pers2); // vérification des adresses mémoires
		
		System.out.println("pers1 == pers2 ? " +  pers1.equals(pers2));
		
		// comparer que deux objets sont dans le même état on utilise la méthode equals
		
		
		PersonneNew p1 = new PersonneNew();
		PersonneNew p2 = new PersonneNew();
					p2.setId(2);
					p2.setNom("Farncis");
		PersonneNew p3 = new PersonneNew();
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
			p2.setId(-100);
		System.out.println(p3.toString());
		
		Voiture v = new Voiture();
		
		// variable static
		/*
		 * System.out.println("Valeur du compteur = " + pers1.compteur);
		 * System.out.println("Valeur du compteur = " + pers2.compteur);
		 */
		System.out.println("Valeur du compteur = " + Personne.getCompteur());
		
		pers1.increment();
		
		System.out.println("Valeur du compteur = " + pers1.getCompteur());
		System.out.println("Valeur du compteur = " + pers2.getCompteur());
		System.out.println("Valeur du compteur = " + pers3.getCompteur());
		
		pers2.increment();
		
		System.out.println("Valeur du compteur = " + pers1.getCompteur());
		System.out.println("Valeur du compteur = " + pers2.getCompteur());
		System.out.println("Valeur du compteur = " + pers3.getCompteur());
		
		pers3.increment();
		
		System.out.println("Valeur du compteur = " + pers1.getCompteur());
		System.out.println("Valeur du compteur = " + pers2.getCompteur());
		System.out.println("Valeur du compteur = " + pers3.getCompteur());
		
		
		Personne pers4 = new Personne(12, "Simpson","Lisa","lisa@yahoo.fr", new Adresse());
			
			pers4.getAdresse().setRue("Rue de Picpus");
			pers4.getAdresse().setNumero("112 B");
			pers4.getAdresse().setCode(75012);
			pers4.getAdresse().setVille("Paris");
			
			System.out.println("Pers4 "  + pers4.getAdresse().toString());
			
			pers4.getCompetences().add("Java 8");
			pers4.getCompetences().add("SQL");
			
			System.out.println("Pers4 "  + pers4.getCompetences());
			
			Etudiant  etud1 = new Etudiant();
			Etudiant  etud2 = new Etudiant();
			
			
			List<Personne> listeP = new ArrayList();
					listeP.add(etud2);	
					listeP.add(etud1);	
					listeP.add(pers4);
					listeP.add(pers2);
					
			for(Personne p : listeP) {
				p.presentation();
			}
	}
}
