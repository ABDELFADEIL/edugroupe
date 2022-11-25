import {Categorie} from "./categorie";

export class Produit {
  id: number;
  nom: string;
  designation: string;
  prix: number;
  stock: number;
  imageUrl: string;
  categorie: Categorie;



  constructor(id: number, nom: string, designation: string,
              prix: number, stock: number, imageUrl: string, categorie: Categorie) {
    this.id = id;
    this.nom = nom;
    this.designation = designation;
    this.prix = prix;
    this.stock = stock;
    this.imageUrl = imageUrl;
    this.categorie = categorie;
  }
}
