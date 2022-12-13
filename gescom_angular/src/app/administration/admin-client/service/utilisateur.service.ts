import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {ApiResponse} from "../../../models/apiResponse";
import {Produit} from "../../../produits/produit";
import {API_URL} from "../../../api_params";
import {Client} from "../../models/Client";
import {Role, Utilisateur} from "../../../models/utilisateur";

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http: HttpClient) { }

  getClientsByKeyWordPagination(param: { size?: number; page?: number; keyword?:string }) :Observable<ApiResponse<Client>>{
    console.log('getClientsByKeyWord');
    return this.http.get<ApiResponse<Client>>(API_URL + 'utilisateurs?page=' + param.page + '&size=' + param.size + '&keyword=' + param.keyword )
      .pipe(
        tap((response:ApiResponse<Client>) => {
          console.log(response);
        }),
        catchError(err => of(err)));
  }

  getClientById(clientId: number) :Observable<Client>{
    return this.http.get<Client>(API_URL + 'clients/'+ clientId)
      .pipe(
        tap((response:Client) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }

  updateAddClient(client: Utilisateur) :Observable<Utilisateur>{
    return this.http.post<Utilisateur>(API_URL + 'utilisateurs/add-update', client)
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }

  deleteClient(clientId: number) :Observable<Client>{
    return this.http.delete<boolean>(API_URL + 'utilisateurs/' + clientId)
      .pipe(
        tap((response:boolean) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }

  getRoles(){
    return this.http.get<ApiResponse<Role>>(API_URL + 'roles')
      .pipe(
        tap((response:ApiResponse<Role>) => {
          console.log(response);
        }),
        catchError(err => of(err)));
  }


  updateProfile(fieldName: string, value: string) :any{
    console.log(fieldName, value);
    return this.http.post(API_URL + 'utilisateurs/update-profile', {"fieldName": fieldName, "value": value})
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err)));
  }
}
