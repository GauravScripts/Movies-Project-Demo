import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {AdminDashboardComponent} from "./admin-dashboard/admin-dashboard.component";
import {UserDashboardComponent} from "./user-dashboard/user-dashboard.component";
import {AuthGuard} from "./auth/auth.guard";

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"signupView",component:SignupComponent},
  {path:"loginView",component:LoginComponent},
  {path:"adminView",canActivate:[AuthGuard],component:AdminDashboardComponent},
  {path:"userView",canActivate:[AuthGuard],component:UserDashboardComponent},
  {path:"**",component:SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
