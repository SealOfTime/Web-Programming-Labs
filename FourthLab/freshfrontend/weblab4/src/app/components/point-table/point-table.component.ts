import { Component, Input, OnInit } from '@angular/core';
import { Point } from 'src/app/models/point';

@Component({
  selector: 'app-point-table',
  templateUrl: './point-table.component.html',
  styleUrls: ['./point-table.component.scss']
})
export class PointTableComponent implements OnInit {
  @Input() pointList!: Point[];
  
  constructor() { }

  ngOnInit(): void {
  }

}
