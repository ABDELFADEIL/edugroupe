import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {AdminDashboardComponent} from "./admin-dashboard/admin-dashboard.component";
import {AdminDashboardService} from "./admin-dashboard.service";
import {ProduitService} from "../produits/produit.service";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AdminProduitComponent } from './admin-produit/admin-produit.component';
import { AdminClientComponent } from './admin-client/admin-client.component';
import { AdminCommandeComponent } from './admin-commande/admin-commande.component';
import { AdminMenuComponent } from './component/admin-menu/admin-menu.component';


const adminRoutes: Routes = [
  { path: 'admin', component: AdminDashboardComponent },
  { path: 'admin/produits', component: AdminProduitComponent },
  { path: 'admin/clients', component: AdminClientComponent },
  { path: 'admin/commandes', component: AdminCommandeComponent },
]
@NgModule({
  declarations: [
    AdminDashboardComponent,
    AdminProduitComponent,
    AdminClientComponent,
    AdminCommandeComponent,
    AdminMenuComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(adminRoutes),
    FontAwesomeModule,
  ],
  providers: [AdminDashboardService, ProduitService]
})
export class AdminDashboardModule { }
