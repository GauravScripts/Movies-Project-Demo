import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import {AdminService} from "../admin.service";
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService:AuthService, private _router: Router) {}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):boolean {
  if(this.authService.isAuthenticated()){
    return true;
  }
  else{
    this._router.navigate(['login']);
    return false;
  }
  }
}
