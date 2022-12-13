import {Component, OnInit} from '@angular/core';
import { faApple } from '@fortawesome/free-brands-svg-icons';
import { faUserCircle, faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import {AuthService} from "../../authentication/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{

  faApple = faApple;
  faUserCircle = faUserCircle;
  faSignOutAlt = faSignOutAlt;
  token: string | undefined;

  constructor(public authService: AuthService) {
  }
  ngOnInit(): void {
  }

  login() {
  }

  logout() {
  }
}
