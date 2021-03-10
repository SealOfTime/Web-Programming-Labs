import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {
  constructor(public auth: AuthService, public router: Router) {}
  
  canActivate(): boolean {
    if (!this.auth.isAuthenticated()) {
      console.log("no");
      this.router.navigate(['login']);
      return false;
    }
    console.log('yes');
    return true;
  }
}
