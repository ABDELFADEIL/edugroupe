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

  constructor(private produitService: ProduitService) {
  }

  ngOnInit(): void {
    this.getProduct();
  }

  getProduct(){
    this.produitService.getProduits().subscribe(
      (response)=> {
        this.produits = response;
        this.sliderProduits = this.produits.slice(0, 4);
        this.newProduits = this.produits.slice(4, 7);
        console.log(this.sliderProduits);
        console.log(this.newProduits);
        let p: Produit  = new Produit(1, "Java testing",
          "", 100, 0, "", new Categorie(0, "cat"));
        //console.log(this.produits.filter(p=> p.nom.match('Java')));
      }
    );

  }


}
