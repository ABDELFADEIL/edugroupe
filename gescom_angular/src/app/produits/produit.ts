import {Categorie} from "./categorie";

export class Produit {
  id: number = 0;
  nom: string | undefined;
  designation: string | undefined;
  prix: number | undefined;
  stock: number | undefined;
  imageUrl: string | undefined;
  categorie: Categorie | undefined;


}
