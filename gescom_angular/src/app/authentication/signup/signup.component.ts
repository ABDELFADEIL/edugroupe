import { Component } from '@angular/core';
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";
import {User} from "../user";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  errors: string | undefined;
  user: User = new User(0, '',
    '', null, '',
    '', '', 'USER');
  created: boolean = false;
  constructor(private authService: AuthService, private router: Router) {
  }

  onSubmit(formValue: any) {
    console.log(formValue);
    console.log(this.user);
    if (formValue.password != formValue.rePassword){
      this.errors = 'Mot de passe n\'est pas confirmé';
      return;
    }
    this.authService.signup(this.user).subscribe(
      (response)=> {
        console.log(response);
        // Redirige l'utilisateur
        // this.router.navigate(['/login']);
        this.created = true;
      }
    )

  }
}
