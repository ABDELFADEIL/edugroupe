import {Component, OnInit} from '@angular/core';
import {ProduitService} from "../../produits/produit.service";
import {Produit} from "../../produits/produit";

@Component({
  selector: 'app-admin-produit',
  templateUrl: './admin-produit.component.html',
  styleUrls: ['./admin-produit.component.css']
})
export class AdminProduitComponent implements OnInit{

  produits?: Produit [];
  constructor(private produitService: ProduitService) {
  }

  ngOnInit(): void {
    this.getProduits();
  }

  getProduits(){
    this.produitService.getProduits().subscribe(
      response => {
        this.produits = response.content;
        console.log(this.produits);
      }
    )
  }
}
