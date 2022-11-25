import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {AuthService} from "./auth.service";
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {FormsModule} from "@angular/forms";

const authRoutes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'signup', component: SignupComponent},
];

@NgModule({
  declarations: [
    LoginComponent,
    SignupComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(authRoutes),
    FormsModule
  ],
  providers: [AuthService]
})
export class AuthModule { }
