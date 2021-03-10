import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-taskbar',
  templateUrl: './taskbar.component.html',
  styleUrls: ['./taskbar.component.scss']
})
export class TaskbarComponent implements OnInit {
  @Output() startMenu = new EventEmitter<Event>();

  public now: Date = new Date();

  constructor(private authService: AuthService){}
  ngOnInit(): void {
    setInterval(() => {
      this.now = new Date();
    }, 60000);
  }
  clickOnStartMenu(e: Event){
    console.log(e);
    this.startMenu.emit(e);
  }
}
