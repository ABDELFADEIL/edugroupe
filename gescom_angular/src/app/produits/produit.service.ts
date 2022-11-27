import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {API_URL} from "../api_params";
import {catchError, Observable, of, tap} from "rxjs";
import {Produit} from "./produit";
import {AuthService} from "../authentication/auth.service";
import {AdminDashboardModule} from "../administration/admin-dashboard.module";

@Injectable()
export class ProduitService implements OnInit{

  constructor(private http: HttpClient) { }

  getProduits({page = 0, size = 1000000} = {}) :Observable<any>{
    return this.http.get<any>(API_URL + 'produits?page=' + page + '&size=' + size )
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }

  ngOnInit(): void {
  }

  getProduitById(idProduit: number) :Observable<Produit>{
    return this.http.get<Produit[]>(API_URL + 'produits/'+ idProduit)
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }
}
