import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserToken } from '../models/user';
import { shareReplay, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {}
  
  doLogin(user: String, pass: String){
    const l = this.login(user, pass);
    l.subscribe(
        (data)=>this.setSession(data), 
        console.error, 
        console.log);
    return l;
  }
  doRegister(user: String, pass: String){
    const obs = this.register(user, pass);
    obs.subscribe(
      this.setSession, 
      console.error, 
      console.log);
    return obs;
  }

  register(username: String, password: String){
    return this.http.post<UserToken>('http://127.0.0.1:8080/auth/register', {username, password}).pipe( shareReplay() );
  }

  login(username: String, password: String) {
    return this.http.post<UserToken>('http://127.0.0.1:8080/auth/login', {username, password});
  }

  logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("expiresIn");
  }

  setSession(token: UserToken){
    localStorage.setItem('token', token.token);
    console.log(token.token);
  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return token != undefined;
  }
}


