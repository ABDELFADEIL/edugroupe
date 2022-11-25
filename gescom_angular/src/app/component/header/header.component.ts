import {Component, OnInit} from '@angular/core';
import { faApple } from '@fortawesome/free-brands-svg-icons';
import { faUserCircle, faSignOutAlt } from '@fortawesome/free-solid-svg-icons';

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
  ngOnInit(): void {
  }

  login() {
  }

  logout() {
  }
}
