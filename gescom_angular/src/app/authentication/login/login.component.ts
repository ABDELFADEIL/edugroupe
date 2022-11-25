import {Component, OnInit} from '@angular/core';
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  email: string | undefined;
  password: string | undefined;
  auth: AuthService | undefined;

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
    this.auth = this.authService;
  }

  login(){
    this.authService.login(this.email, this.password)?.subscribe(
      (response)=> {
        if (AuthService.getToken() != undefined) {
          console.log(response);
          // Récupère l'URL de redirection depuis le service d'authentification
          // Si aucune redirection n'a été définis, redirige l'utilisateur vers la liste des pokemons.
          let redirect = this.authService.redirectUrl ? this.authService.redirectUrl : '/home';
          // Redirige l'utilisateur
          this.router.navigate([redirect]);
        } else {
          this.password = '';
        }
      }
    )
  }

}
