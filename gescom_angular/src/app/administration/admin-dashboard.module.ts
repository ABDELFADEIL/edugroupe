import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {AdminDashboardComponent} from "./admin-dashboard/admin-dashboard.component";
import {AdminDashboardService} from "./admin-dashboard.service";
import {ProduitService} from "../produits/produit.service";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';


const adminRoutes: Routes = [
  { path: 'admin', component: AdminDashboardComponent }
]
@NgModule({
  declarations: [
    AdminDashboardComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(adminRoutes),
    FontAwesomeModule,
  ],
  providers: [AdminDashboardService, ProduitService]
})
export class AdminDashboardModule { }
