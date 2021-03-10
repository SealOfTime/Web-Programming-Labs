import { AfterViewInit, Component, ElementRef, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { ErrorService } from 'src/app/services/error.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss'],
  providers: [ErrorService]
})
export class AuthComponent implements OnInit, AfterViewInit {
  @ViewChild('error', {read: ViewContainerRef})
    error!: ViewContainerRef;

  username = new FormControl('', Validators.required);
  password = new FormControl('', Validators.required);

  constructor(private authService: AuthService, 
             private router: Router, 
             private errorService: ErrorService) { }
  ngAfterViewInit(): void {
    this.errorService.setRootViewContainerRef(this.error);
  }

  ngOnInit(): void {
    if(this.authService.isAuthenticated())
      this.router.navigateByUrl("/");
  }

  login(){
      if (this.username.value && this.password.value) {
          console.debug("Submitting a form");
          this.authService.doLogin(this.username.value, this.password.value)
                          .subscribe(()=>this.router.navigateByUrl("/"), (err)=>{
                            if(err.status == 444)
                              this.errorService.addError("Wrong password");
                          });
      }
      console.log(`${this.username.value} ${this.password.value}`);
  }

}
