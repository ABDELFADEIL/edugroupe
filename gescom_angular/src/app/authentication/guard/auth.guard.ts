import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from "../auth.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const decodeToken: any = this.authService.decodeToken();
    const url = route.url;
    console.log(url);
    if (url[0].path === 'profile' && decodeToken.roles.find((role: any)=> role.authority == "USER")){
      return true;
    }
    if (url[0].path === 'admin' && decodeToken.roles.find((role: any)=> role.authority == "ADMIN")){
      return true;
    }
    console.log(decodeToken);
    if (!decodeToken){
      return false;
    }
    return false;
  }

}
