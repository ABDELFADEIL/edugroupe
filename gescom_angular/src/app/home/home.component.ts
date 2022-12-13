import {Component, OnInit} from '@angular/core';
import {ProduitService} from "../produits/produit.service";
import {Produit} from "../produits/produit";
import {Categorie} from "../produits/categorie";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  private produits: Produit[] | undefined;
  sliderProduits: Produit[] | undefined;
  newProduits: Produit[] | undefined;
  private currentPage: number = 0;
  private size: number = 100;
  private keyword: string = '';

  constructor(private produitService: ProduitService) {
  }

  ngOnInit(): void {
    this.getProduct();
  }

  getProduct(){
    this.produitService.getProductsByKeyWordPagination({page: this.currentPage, size: this.size, keyword: this.keyword}).subscribe(
      (response)=> {
        this.produits = response.content;
        this.sliderProduits = this.produits?.slice(0, 4);
        this.newProduits = this.produits?.slice(4, 7);
        console.log(this.sliderProduits);
        console.log(this.newProduits);
        let p: Produit  = new Produit();
        //console.log(this.produits.filter(p=> p.nom.match('Java')));
      }
    );

  }


}
