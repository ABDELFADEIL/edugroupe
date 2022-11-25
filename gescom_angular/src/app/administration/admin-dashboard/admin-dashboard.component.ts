import { Component } from '@angular/core';
import { faHome, faClipboardList, faUserCircle } from "@fortawesome/free-solid-svg-icons";
import { faShopify } from "@fortawesome/free-brands-svg-icons";

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  faHome = faHome;
  faShopify = faShopify;
  faClipboardList = faClipboardList;
  faUserCircle = faUserCircle;

}
