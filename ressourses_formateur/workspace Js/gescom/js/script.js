 var prompt = require("prompt-sync")();
// 1- commentaires
// Commentaire monoligne
/* commentaire multi ligne   */

//2-    Variables et constantes 
    let  a = 15;

    var b = "Bonjour";
    let c = false;
//2-1 différence entre let et var
 let age =18;
function letFunction(){
    //  let age =19;
    if(age >=18)
    {
        let prenom ="Simpson";
        console.log("Dans le if let age = ", prenom);
    }
    // console.log("Dans le if let age = ", prenom);
}
letFunction();
console.log("hors de  la fonction let age = ", age);
// 2-2 type de variables
console.log("Type a ", typeof(a));
console.log("Type b ", typeof(b));
console.log("Type c ", typeof(c));
    a="Bonjour";
    b=true;
    c=25;
    
    console.log("Type a ", typeof(a));
    console.log("Type b ", typeof(b));
    console.log("Type c ", typeof(c));

//3- lire et écrire en js
/* -    ecrire
        -   console.log()
        -   alert()
        -   document.write()
    -  lire 
        -   prompt()
*/
// console.log("Bonjour");
    // document.write("<h2> Bonjour à Tous </h2>");
    let valeur= prompt('Entrez une valeur');

    /* 3-1 Etapes d'exécution du prompt dans le terminal
        -   Installation du module  : prompt-sync
                npm install prompt-sync --save
        -   importortation et l'auto-exécution de module dans le fichier js
                var prompt = require("prompt-sync")();
        -   configurer vs code pour l'exécution dans le terminal
            /fichier/préférences/paramètres/ ==> rechercher code runner
            On active  l'option :  run in terminal
    */
    console.log(valeur);

//4-    les chaines de caractères:
    //4-1 concaténation
        let nom = " Jean Francis",
            bonjour = "Bonjour",
            conca = bonjour + " " + nom;

            let x = 8+2+'15';  //   8215   1015
            let y = '15'+(8+2);   //  1582   1510
            let z = 8+'15'+2    //  8152   8152

            console.log(x);
            console.log(y);
            console.log(z);
    //4-2   interpolation ou echappement (\)
        let w ='je vais à l\'ecole';

    //4-3   Quelques fonctions de manipulation des String
        //4-3-1  length : donne le nombre de caractère de la chaine
            console.log("taille = " + nom.length);
        //4-3-2 concat : concatène deux chaine
            conca = nom.concat(bonjour);
            console.log(conca);
        //4-3-3 toLowerCase :  transforme tous les caractère en minuscule
            console.log(nom.toLocaleLowerCase());
        //4-3-3 toupperrCase :  transforme tous les caractère en majuscule
           console.log(nom.toLocaleLowerCase());
        /*4 -3-4 trim : supprime les espace en début et fin d'une chaine
                    trimEnd et trimStrat
        */
        /* 4-3-5 autres fonction
                -   valueOf
                -   indexof

        */
    /*
        4-4   conversion de type
            number ==> String   :  toString();
            String ==> numbre   :  parseInt() 
    */
        let p = 25;
        let p2 = toString(p),
            p3 = "15";
        let p4 = parseInt(p3);

        console.log("type p2 : " + typeof p2 + " p4 : " + typeof p4);

        //petite calculette
        let m,n;
            m=parseInt( prompt("Valeur 1 : "));
            n= parseInt( prompt("Valeur 2 : "));
            console.log("Somme m + n = ", (m+n));
/*  5-  les conditions 
        - if(condition) ou if(condition)  else ou if(condition) else if(condition)
*/
    let ageP = prompt("Vôtre âge s'il vout plait");
    if(ageP <18 && ageP >0)
        console.log("Vous êtes Mineur");
     else   
     console.log("Vous êtes Majeur"); 
     
    //5-1  Même exemple avec la condition ternaire
        let rep = (ageP < 18 && ageP >0) ? "Vous êtes Mineur " : "Vous êtes Majeur"
    // 5-2 exemple avec if   elese if   else
        if(ageP<0)
            console.log("Mauvaise valeur");
        else if(ageP >= 18)
            console.log("Vous êtes Majeur");
        else    
            console.log("Vous êtes Mineur");

    // 5-3  Exemple avec le switch case

         let jour = prompt("Entrer un nombre entre 1 -7 s'il vous plait ");

         switch(jour){
            case '1':
                console.log("LUNDI")
                break;
            case '2':
                console.log("MARDI")
                break;
            case '3':
                console.log("MERCREDI")
                break;
            case '4':
                console.log("JEUDI")
                break;
            case '5':
                console.log("VENDREDI")
                break;
            case '6':
                console.log("SAMEDI")
                break;
            case '7':
                console.log("DIMANCHE")
                break;
            default :
                console.log("Mauvaise valeur")
         }
        
/*  6-   les boucles :
         - for
         - while
         - do while

         PB : afficher la table de multiplication d'un 
         nombre rensegné par l'utilisateur
*/
let nombre =parseInt(prompt("Entrer un nombre vous plait "));

        //6-1   for
            for(let i =0;i<=12;i++)
                console.log(nombre + ' * ' + i + " = " +(nombre *i));

        //6-2   while :
            let j=0;
            while(j<=12){
                console.log(nombre + ' * ' + j + " = " +(nombre *j));
                j++;
            }
        //6-3   do while()

            let k=0;
            do{
                console.log(nombre + ' * ' + k + " = " +(nombre *k));
                k++;
            }while(k<=12);
//  7-  les tableaux

    //7-1   Déclaration et initialisation
            let myArray = new Array('Lisa','Bart','Omer','Maggie');
            let tabEnt = [1,2,2,2,3,8,6,-1,-2,-4,12];
            let tabEmpty = [];
    //7-2   Taille d'un tableau : length
            console.log("Taille : " + tabEnt.length);
    //7-3   Accès à un élément du tableau  nomTab[indice]
            console.log("indice 2 : " + tabEnt[2]);
    // 7-4  Ajout d'un élément : push()  - unshift()
            //7-4-1 push : à la fin du tableau
                tabEnt.push(15);
                tabEnt.push(21,-35);
                console.log("tabEnt : " + tabEnt);
            //7-4-2 unshift() : au début du tableau
                tabEnt.unshift(0);
                tabEnt.push(14,55);
                console.log("tabEnt : " + tabEnt);
    //  7-5 Parcours d'un tableau (for , while for in,forEach)
        //7-5-1 for
            for(let i =0;i<myArray.length;i++){
                console.log(myArray[i]);
            }
        //7-5-2 For in
        for(let val in myArray){
            console.log(val);
        }
        
        //7-5-3 ForEach
        myArray.forEach(elt =>{
            console.log(elt);
        })
    //  7-6 Suppression d'un élément dans un tableau : splice(1,nombreElementASup)
        console.log(myArray);
             myArray.splice(1,1);
        console.log(myArray);

        console.log(myArray);
        // supprime l'élément à l'indice 1 et le remplace par la valeur Simpson
            myArray.splice(1,1,"Simpson");
        console.log(myArray);
    
    //  7-7 slice() : renvoie une partie du tableau dans un nouveau tableau  
        console.log(myArray);
        console.log(myArray.slice(1,3));
   
    //  7-8 find () : renvoie la première occurence dans le tableau
        let valeurNegative = tabEnt.find(elt => elt < 0);
        console.log("Valeur négative : " + valeurNegative);

    //  7-9 autres Fonctions  : map , filter , reduce
        //7-9-1 : map   
            tabEnt.map(element => element * 2).forEach(elt=>console.log(elt));
        //7-9-2 : filter
            tabEnt.filter(elt => elt % 2 == 0).forEach(element=>console.log(element));

            tabEnt.map(element => element * 2).filter(e => e < 0).forEach(elt=>console.log(elt));
        //7-9-3 : reduce ==> (accumulateur,valeurCourante, index, array),

            // la fonction reduce utilise un accumulateur pour effectuer un traitement 
            // sur tous les éléments du tableau afin de le réduire à une seule valeur

            let somme = tabEnt.reduce((accumulateur,valeurCourante,index,arr)=>{
                return accumulateur + valeurCourante;
            },0);

            // Autres exemples : somme des éléments paires ou impaires du tableau tabEnt 

            let somme_paires = tabEnt.filter(elt=> elt%2===0).reduce((accumulateur,valeurCourante)=>
            {
                return accumulateur + valeurCourante
            },0);
        /* 8- les fonctions:

        */
       //8-1    déclaration de fonction
            //Première méthode
            function somme(a,b){
                    console.log(a+b);
            }
            //Dexième méthode
            const somme2 = function(a,b){
                return a+b;
            }
            //Troisième méthode
            const somme3 = (a,b)=>{console.log(a+b)}
      //8-2 utilisation de fonction
            somme(15,5);
            somme2(12,4);
            somme3(-15,25);
      //8-3 auto-exécution de fonction ou fonction auto invoquée
      
            ((a,b)=>{
                console.log('Je suis une fonction qui s\'auto exécute'+ (a+b));
            })(12,4);
    /*
            les modules en JS
            -   export / import
    */
    import * as math from "./maths";
    // import {add,sous,multi,initialisation} from "./maths";
    // import {add as addition ,sous,multi,initialisation} from "./maths"; 
    
    //Appel de la méthode d'un module
    console.log(math.add(14,4));
    
    let tab = [];
    //Test de la méthode d'initialisation d'un tableau      
    math.initialisation(tab).forEach(elt=>console.log(elt))
/*
   9- la POO en JS
    - classe
    - les objets
    - les attributs
    - les méthodes
            -getteurs et setteurs
    - les autres 
        - equals
        - toString
    -  l'héritage 
*/
//9-1 Différentes méthodes de céation d'objet
    //9-1-1 Objet litéral ==> format JSON
    var personne = {
        // "key" : "valeur"
        "nom":"Simpson",
        "prenom":"Bart",
        "age": 15
    }

    var personne2 = {
        // "key" : "valeur"
        "nom":"Simpson",
        "prenom":"Lisa",
        "age": 15,
        "adresse":{
            "rue":"Rue de Picpus",
            "numero":112,
            "code": 75012,
            "ville":"Paris"
        },
        "competences":["Java 8","HTML5 & CSS3","Javascript"],
        presentation : function(){
            return "{nom :"  + this.nom +" prenom :" + this.prenom +"}";
        },
        presentation2 : ()=>{
            return "{nom :"  + this.nom +" prenom :" + this.prenom +"}";
        }
    }
    //Utilisation d'un objet litéral
    personne2.presentation();

    //9-1-2 Deuxième méthode : Factory function

    function Personne3(nom,prenom,age,adresse,competences){
        return {
            "nom" : nom,
            "prenom":prenom,
            "age":age,
            "adresse":adresse,
            "competences":competences,
            presentation : function(){
                return "{nom :"  + this.nom +" prenom :" + this.prenom +"}";
            },
        }
    }
    
    let adresse= {
        "rue":"Rue de Picpus",
        "numero":112,
        "code": 75012,
        "ville":"Paris"
    }
     p3 = Personne3("Simpson","Bart",15,adresse,["Java 8","SQL"]);

    p2 =Personne3("Simpson","Lisa",10,adresse,["HTML","CSS"]);
   
    // afficher les objet
    console.log("p = " + p.presentation());
    console.log("p2 = " + p2.presentation());
   //  Modifier l'état de p2 et observer
   p2.nom = "Omer";
   console.log("p après modif = " + p.presentation());
   console.log("p2 après modif = " + p2.presentation());

   //9-1-3 Troisième méthode : Object()
    let maggie = new Object();
    //Ajout des attributs et méthodes
        maggie.nom ="Simpson";
        maggie.prenom ="Maggie";
        maggie.age =45;
        maggie.presentation = ()=>{
            return "{nom :"  + this.nom +" prenom :" + this.prenom +"}";
        }
    //Utilisation
    console.log(maggie.presentation());

// 9-1-4    Quatrième méthode : la classe

    class Personne5{
        //1-Attributs
        #nom;
        #prenom;
        #age;
        #adresse;
        //2- le constructeur de classe en js
        constructor(nom,prenom,age,adresse){
                this.#nom = nom;
                this.#prenom = prenom;
                this.#age = age;
                this.#adresse = adresse;
        }
        
    }
    // Deuxième méthode 
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
        
    }
    // 9-1-4 Héritage
    class Stagiaire extends Personne5{

    }