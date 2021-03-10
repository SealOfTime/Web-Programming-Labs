import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { PointService } from 'src/app/services/point.service';

@Component({
  selector: 'app-point-form',
  templateUrl: './point-form.component.html',
  styleUrls: ['./point-form.component.scss']
})
export class PointFormComponent {
  readonly xPossible = [-2.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5, 2.0];
  readonly rPossible = [-2.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5, 2.0];

  x = new FormControl();
  y = new FormControl('', Validators.compose([    
    Validators.min(-5),
    Validators.max(5)
  ]));
  _r = new FormControl();


  @Input() 
  set r(value: number){
    this._r.setValue(value);
    console.log(`tried to set ${value}`);
    this.rChange.emit(this._r.value);
  }

  @Output() rChange = new EventEmitter<number>();
  
  constructor(private pointService: PointService) {
    this._r.valueChanges.subscribe((value)=>{
      this.rChange.emit(value);
    });
   }
  
   submit(){
     this.pointService.postPoint(this.x.value, this.y.value, this._r.value);
   }

   reset(){
     this.x.reset();
     this.y.reset();
     this._r.reset();
   }

}
