import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {API_URL} from "../api_params";
import {Categorie} from "./categorie";

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(private http: HttpClient) { }

  getCategories() :Observable<Categorie[]>{
    return this.http.get<any>(API_URL + 'categories')
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err)))
  }
}
