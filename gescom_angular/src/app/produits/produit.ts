import {Categorie} from "./categorie";

export class Produit {
  id: number | undefined;
  nom: string | undefined;
  designation: string | undefined;
  prix: number | undefined;
  stock: number | undefined;
  imageUrl: string | undefined;
  categorie: Categorie | undefined;


}
