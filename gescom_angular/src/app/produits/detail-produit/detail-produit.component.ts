import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Produit} from "../produit";
import {ProduitService} from "../produit.service";
import { faCartPlus } from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-detail-produit',
  templateUrl: './detail-produit.component.html',
  styleUrls: ['./detail-produit.component.css']
})
export class DetailProduitComponent {

  produit: Produit | undefined;
  faCartPlus = faCartPlus;
  constructor(private route: ActivatedRoute, private router: Router, private produitService: ProduitService) {
    let idProduit: string | null = this.route.snapshot.paramMap.get('id');
    if(idProduit){
      this.getProduitById(+idProduit);
    }
  }

  private getProduitById(idProduit: number) {
    this.produitService.getProduitById(idProduit)?.subscribe((produit: Produit) => {
      this.produit = produit;
    });
  }
}
