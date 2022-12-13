import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from "@angular/router";
import {ProfileComponent} from "./profile/profile.component";
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {AuthService} from "../authentication/auth.service";
import {AuthGuard} from "../authentication/guard/auth.guard";



const profileRoutes: Routes = [
  {path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] }
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
