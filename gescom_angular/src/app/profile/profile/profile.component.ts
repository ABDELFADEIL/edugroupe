import {Component, OnInit} from '@angular/core';
import { faUserCircle, faPencilAlt, faList } from '@fortawesome/free-solid-svg-icons';
import {AuthService} from "../../authentication/auth.service";
import {User} from "../../authentication/user";


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
  constructor(private authService: AuthService) {
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

  sendUpdateAddress(){}

  sendUpdateEmail(){}
}
