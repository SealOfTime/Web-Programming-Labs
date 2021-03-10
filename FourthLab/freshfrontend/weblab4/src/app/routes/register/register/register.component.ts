import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  username = new FormControl('', Validators.required);
  password = new FormControl('', Validators.required);

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    if(this.authService.isAuthenticated())
      this.router.navigateByUrl("/");
  }

  register(){
      if (this.username.value && this.password.value) {
          console.debug("Submitting a form");
          this.authService.doRegister(this.username.value, this.password.value).subscribe(
            ()=>{
              this.router.navigateByUrl('/');
            }
          );
      }
      console.log(`${this.username.value} ${this.password.value}`);
  }

}