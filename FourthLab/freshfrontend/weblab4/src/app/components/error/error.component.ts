import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.scss']
})
export class ErrorComponent implements OnInit {
  @Input() message: string="no error";
  
  constructor() { }

  ngOnInit(): void {
    new Audio("/assets/erro.mp3").play();
  }

}
