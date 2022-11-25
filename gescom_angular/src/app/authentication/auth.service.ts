import {Injectable, OnInit} from '@angular/core';
import {API_URL} from "../api_params";
import {catchError, Observable, of, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import { User } from "./user";

@Injectable()
export class AuthService implements OnInit{
  token: string | undefined;
  private currentUser: any;
  isLoggedIn: boolean = false;
  redirectUrl: string  | undefined;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getCurrentUser();

  }

  login(email: string | undefined, password: string | undefined):Observable<any>{
    return this.http.post(API_URL + 'auth/login', {"email": email, "password": password})
      .pipe(
        tap((response:any) => {
          this.saveToken(response.accessToken);
        }),
        catchError(err => of(err))
      );
  }
  signup(user: User){
    return this.http.post(API_URL + 'auth/register', user)
      .pipe(
        tap((response:any) => {
          console.log(response);
        }),
        catchError(err => of(err))
      );
  }
   getCurrentUser = () => {
     return this.http.get(API_URL + 'auth/current-user')
       .pipe(
         tap((response:any) => {
           console.log(response);
         }),
         catchError(err => of(err))
       );
  };

  updateEmail = ()=> {
    const email = document.getElementById('updateEmail');
    const adresse = document.getElementById('updateAddress');
    console.log(this.currentUser)

  }
   updateAddress = ()=> {
    const adresse = document.getElementById('updateAddress');
    const email = document.getElementById('updateEmail');

  }

   saveToken = (token: string) => { window.localStorage.setItem('token', token); }
   static getToken = () => {
    const token = window.localStorage.getItem('token');
    if(!token){
      return null;
    }
    return "Bearer " + token;
  }

  logout(){
    this.isLoggedIn = false;
  }


}
