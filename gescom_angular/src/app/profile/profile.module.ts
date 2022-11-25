import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from "@angular/router";
import {ProfileComponent} from "./profile/profile.component";
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {AuthService} from "../authentication/auth.service";



const profileRoutes: Routes = [
  {path: 'profile', component: ProfileComponent}
]
@NgModule({
  declarations: [
    ProfileComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(profileRoutes),
    FontAwesomeModule
  ],
  providers: [AuthService]
})
export class ProfileModule { }
