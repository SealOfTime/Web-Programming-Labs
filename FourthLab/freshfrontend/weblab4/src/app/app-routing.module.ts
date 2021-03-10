import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './auth/auth-guard.service';
import { AuthComponent } from './routes/auth/auth.component';
import { MainComponent } from './routes/main/main.component';
import { RegisterComponent } from './routes/register/register/register.component';

const routes: Routes = [
  { path: '', component: MainComponent,
    canActivate: [AuthGuardService]  },
  { 
    path: 'login',
    component: AuthComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
