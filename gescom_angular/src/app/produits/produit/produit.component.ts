import {Component, OnInit} from '@angular/core';
import {ProduitService} from "../produit.service";
import { faCartPlus } from '@fortawesome/free-solid-svg-icons';
import {Produit} from "../produit";
import {Router} from "@angular/router";

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit{

  faCartPlus = faCartPlus;
  produits: Produit [] | undefined;
  months = ["1", "2", "3", "4"]
  constructor(private produitService: ProduitService, private router: Router) {
  }

  ngOnInit(): void {
    console.log(this.months[Math.floor(Math.random() * this.months.length)]);
    this.getProduct();
  }

  getProduct(){
    this.produitService.getProduits().subscribe( // {page:0, size:10}
      (response)=> {
        this.produits = response.content;
        console.log(this.produits)
      }
    )
  }

  detailProduit(id:number) {
    this.router.navigate(['/produits', id])
  }
}
