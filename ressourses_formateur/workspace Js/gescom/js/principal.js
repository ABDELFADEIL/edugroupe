class Personne5{
    //2- le constructeur de classe en js
    constructor(nom,prenom,age,adresse){
            this.nom = nom;
            this.prenom = prenom;
            this.age = age;
            this.adresse = adresse;
    }
    //3-    Méthodes
    presentation(){
        return "{nom :"  + this.nom +" prenom :" + this.prenom +"}";
    }
    afficher(){
        console.log('Je suis une Personne');
    }
    //4-    getteurs:
    getNom(){
        return this.nom;
    }
    set prenom(prenom){
        
    }
    //toString()
    //equals()
    equals(pers){
        if(!(pers instanceof Personne5)){
            return false;
        }else{
            return this.nom == pers.nom && this.prenom == pers.prenom 
                    && this.age == pers.age && this.adresse===pers.adresse;
        }
    }
    // Héritage 
}
// Classe Stagiaire
class Stagiaire extends Personne5{
    constructor(nom,prenom,age,adresse,moyenne){
        super(nom,prenom,age,adresse);
        this.moyenne = moyenne;
    }
    //réécritue 
    afficher(){
        console.log('Je suis un stagiaire');
    }
 
}

// création d'un objet
let lisa = new Personne5("Simpson","Lisa",10,"Rue de Picpus 112, 75012 Paris")
let lisa2 = new Personne5("Simpson","Lisa",15,"Rue de Picpus 112, 75012 Paris")
//  Afficher le nom avec getNom()
console.log('nom lisa :' + lisa.getNom());
// afficher le prenom avec get prenom()
 console.log('Prenom : '+ lisa.prenom);
 // Test du equals()
 console.log(lisa.equals(lisa2));
// création d'objet de type Stagiaire
let s1 = new Stagiaire();
s1.afficher();