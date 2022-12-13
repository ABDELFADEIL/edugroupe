import {Injectable, OnInit} from '@angular/core';
import {API_URL} from "../api_params";
import {catchError, Observable, of, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import { User } from "./user";
import * as jwt_decode from "jwt-decode";
import { JwtHelperService } from '@auth0/angular-jwt';
import {Role} from "../models/utilisateur";

@Injectable()
export class AuthService implements OnInit{
  token: string | undefined;
  private currentUser: any;
  isLoggedIn: boolean = false;
  redirectUrl: string  | undefined;
  private helper: JwtHelperService = new JwtHelperService();

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

  decodeToken(): string | null{
    const token = window.localStorage.getItem('token');
    let jwtToken = null;
    if (!!token){
      jwtToken = this.helper.decodeToken(token);
    }
    //console.log(jwtToken);
    return jwtToken;
  }

  isAdmin(){
    const decodedToken: any = this.decodeToken();
    const roles = decodedToken.roles;
    //console.log('isAdmin: ', roles.find((role: any)=> role.authority === "ADMIN"))
    return roles.find((role: any)=> role.authority === "ADMIN");
  }

  isUser(){
    const decodedToken: any = this.decodeToken();
    const roles = decodedToken.roles;
    //console.log('isUser: ', roles.find((role: any)=> role.authority === "USER"))
    return roles.find((role: any)=> role.authority === "USER");
  }
}
