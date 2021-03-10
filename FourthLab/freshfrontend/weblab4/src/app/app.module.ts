import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PointCanvasComponent } from './components/point-canvas/point-canvas.component';
import { TaskbarComponent } from './components/taskbar/taskbar.component';
import { WindowComponent } from './components/window/window.component';
import { AuthComponent } from './routes/auth/auth.component';
import { MainComponent } from './routes/main/main.component';
import { PointFormComponent } from './components/point-form/point-form.component';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';

import { AngularDraggableModule } from 'angular2-draggable'
import { PointTableComponent } from './components/point-table/point-table.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RegisterComponent } from './routes/register/register/register.component';
import { AuthInterceptor } from 'src/app/auth/auth-interceptor.service';
import { ErrorComponent } from './components/error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    WindowComponent,
    AuthComponent,
    MainComponent,
    TaskbarComponent,
    PointCanvasComponent,
    PointFormComponent,
    PointTableComponent,
    RegisterComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule, 
    HttpClientModule,
    AngularDraggableModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
