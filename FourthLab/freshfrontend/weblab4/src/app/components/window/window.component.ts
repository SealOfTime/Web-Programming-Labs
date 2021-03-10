import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-window',
  templateUrl: './window.component.html',
  styleUrls: ['./window.component.scss']
})
export class WindowComponent implements OnInit {
  @Input() title:  String = "New Window";
  @Input() icon:   String = "/assets/icons/default.png"
  @Input() width:  String = "auto";
  @Input() height: String = "auto";

  constructor() { }

  ngOnInit(): void {
  }

}
