import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {API_URL} from "../api_params";
import {catchError, Observable, of, tap} from "rxjs";
import {Produit} from "./produit";
import {AuthService} from "../authentication/auth.service";
import {AdminDashboardModule} from "../administration/admin-dashboard.module";
import {ApiResponse} from "../models/apiResponse";

@Injectable()
export class ProduitService implements OnInit{

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  getProductsByKeyWordPagination(param: { size?: number; page?: number; keyword?:string }, categoryId?: number) :Observable<ApiResponse<Produit>>{
    console.log('getProduitsByKeyWord');
    if (!!categoryId){
      return this.http.get<any>(API_URL + 'produits/category?categoryId=' + categoryId+ '&page=' + param.page + '&size=' + param.size + '&keyword=' + param.keyword )
        .pipe(
          tap((response:any) => {
            console.log(response);
          }),
          catchError(err => of(err)));
    }else {
      return this.http.get<any>(API_URL + 'produits?page=' + param.page + '&size=' + param.size + '&keyword=' + param.keyword )
        .pipe(
          tap((response:any) => {
            console.log(response);
          }),
          catchError(err => of(err)));
    }
  }

  getProduitById(idProduit: number) :Observable<Produit>{
    return this.http.get<Produit[]>(API_URL + 'produits/'+ idProduit)
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }

  updateAddProduit(produit: Produit) :Observable<Produit>{
    return this.http.post<Produit[]>(API_URL + 'produits', produit)
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }

  deleteProduct(productId: number) :Observable<Produit>{
    return this.http.delete<Produit[]>(API_URL + 'produits/' + productId)
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }

}
