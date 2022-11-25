import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {ProduitComponent} from "./produit/produit.component";
import {ProduitService} from "./produit.service";
import { DetailProduitComponent } from './detail-produit/detail-produit.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';


const produitRoutes: Routes = [
  { path: 'produits', component: ProduitComponent},
  { path: 'produits/:id', component: DetailProduitComponent},
];

@NgModule({
  declarations: [
    ProduitComponent,
    DetailProduitComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(produitRoutes),
    FontAwesomeModule
  ],
  providers: [ProduitService]
})
export class ProduitModule { }
