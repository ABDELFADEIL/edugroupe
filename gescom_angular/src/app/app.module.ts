import {NgModule, OnInit} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {AuthModule} from "./authentication/auth.module";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AuthInterceptor} from "./authInterceptor";
import { HomeComponent } from './home/home.component';
import {ProduitModule} from "./produits/produit.module";
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {ProfileModule} from "./profile/profile.module";
import { registerLocaleData } from "@angular/common";
import localFr from "@angular/common/locales/fr";
import {AdminDashboardModule} from "./administration/admin-dashboard.module";

registerLocaleData(localFr, 'fr');


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FontAwesomeModule,
    AuthModule,
    ProduitModule,
    ProfileModule,
    AdminDashboardModule,
    AppRoutingModule,
  ],
  providers: [
    {
      provide : HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi   : true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule implements OnInit{

  ngOnInit(): void {
  }

}
