import {Produit} from "../produits/produit";
import {Categorie} from "../produits/categorie";

export class ApiResponse<T>{

  content: any[] | T[] | undefined;
  pageable?: any;
  totalPages: number = 0;
  totalElements: number = 0;
  last: boolean = false;
  first: boolean = false;
  number: number = 0;
  sort?: any;
  size: number = 0;
  empty: boolean = false;

}
