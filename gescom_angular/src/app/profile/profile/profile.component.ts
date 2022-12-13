import {Component, OnInit} from '@angular/core';
import { faUserCircle, faPencilAlt, faList } from '@fortawesome/free-solid-svg-icons';
import {AuthService} from "../../authentication/auth.service";
import {User} from "../../authentication/user";
import {UtilisateurService} from "../../administration/admin-client/service/utilisateur.service";


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{

  faUserCircle = faUserCircle;
  faPencilRuler = faPencilAlt;
  faList = faList;
  user: User | undefined;
  displayEmail: boolean = true;
  displayAddress: boolean = true;

  constructor(private authService: AuthService, private utilisateurService: UtilisateurService) {
  }

  ngOnInit(): void {
   this.getUser()
  }

  getUser() {
    if (AuthService.getToken() != undefined) {
      this.authService.getCurrentUser()?.subscribe(
        (response) => {
          console.log(response);
          this.user = response;
        });
    } else {
      console.log('error token');
    }
  }

   updateEmail(){
    this.displayEmail = !this.displayEmail;
     this.displayAddress = true;

  }
  updateAddress() {
    this.displayAddress =!this.displayAddress;
    this.displayEmail = true;
  }
  sendUpdateAddress(address: string){
    this.utilisateurService.updateProfile("address", address).subscribe(
      (response: any)=> {
        console.log(response);
        this.displayAddress = true;
      }
    )
  }

  sendUpdateEmail(email: string){
    this.utilisateurService.updateProfile("email", email).subscribe(
      (response: any)=> {
        console.log(response);
        this.displayEmail = true;
      }
    )
  }
}
