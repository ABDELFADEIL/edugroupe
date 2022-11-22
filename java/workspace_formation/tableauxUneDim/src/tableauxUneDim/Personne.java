package tableauxUneDim;

import java.util.ArrayList;
import java.util.List;

public class Personne {
	//1	Attributs
	private int id;
	protected String nom;
	protected String prenom;
	protected String email;
	protected static int compteur =0;
	
	protected Adresse adresse;
	
	protected List<String> competences;
	

	//2-	Constructeurs
	public Personne() {
		this.adresse = new Adresse();
		this.competences = new ArrayList<>();
		
	}
	public Personne(int idPers) {
		this.id = idPers;
		this.adresse = new Adresse();
		this.competences = new ArrayList<>();
	}
	public Personne(int idPers,String nomPers) {
		this.id = idPers;
		this.nom =nomPers;
		this.adresse = new Adresse();
		this.competences = new ArrayList<>();
	}
	
	
	public Personne(int id, String nom, String prenom, String email, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.competences = new ArrayList<>();
	}
	//3-	Getteurs ou accesseurs
	public int getId() {
		return this.id;
	}
	public String getNom() {
		return this.nom;
	}
	//4-	Setteurs
	public void setId(int idP) {
		if(idP > 0)
			this.id = idP;
	}
	public void setNom(String nomP) {
		this.nom = nomP;
	}
	//4-	toStrin();
	public String toString() {
		return "Personne : { " + this.id + ","  + this.nom +", "+ this.prenom+ ", "+ this.email +"}";
	}
	//5-	equals()
	
	
	public boolean equal(Personne pers) {	
		return this.id == pers.id && this.nom==pers.nom && this.prenom==pers.prenom && this.email == pers.email;	
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Personne))
			return false;
		
		Personne pers = (Personne)obj;
		
		return this.id == pers.id && this.nom==pers.nom && this.prenom==pers.prenom && this.email == pers.email;	
	}
	
	public static void increment() {
		compteur++;
	}
	public static int getCompteur() {
		return compteur;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<String> getCompetences() {
		return competences;
	}
	public void setCompetences(List<String> competences) {
		this.competences = competences;
	}
	
	public void presentation() {
		System.out.println("Je suis une Personne");
	}
	
	
}
