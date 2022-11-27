import { Component } from '@angular/core';
import { faHome, faClipboardList, faUserCircle } from "@fortawesome/free-solid-svg-icons";
import { faShopify } from "@fortawesome/free-brands-svg-icons";


@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent {
  faHome = faHome;
  faShopify = faShopify;
  faClipboardList = faClipboardList;
  faUserCircle = faUserCircle;
}
