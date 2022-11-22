package tableauxUneDim.heritage;

import tableauxUneDim.Personne;

public class Etudiant extends Personne{
	
	private double moyenne;
	
	public void etudier() {
		System.out.println("Nom " + this.nom);
		System.out.println("Nom " + this.prenom);
	}

	@Override
	public void presentation() {
		System.out.println("Je suis un étudiant");
	}

}
