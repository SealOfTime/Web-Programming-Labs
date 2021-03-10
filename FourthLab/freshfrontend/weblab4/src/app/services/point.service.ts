import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Point } from '../models/point';

@Injectable({
  providedIn: 'root'
})
export class PointService{
  points: Point[] = [];

  constructor(private http: HttpClient) { 
    this.fetchPoints();
  }


  fetchPoints(){
    console.log("fetching points...");
    this.http.get<Point[]>('http://localhost:8080/points').subscribe(
      this.addPoints.bind(this),
      console.error,
      console.log
    );
  }

  postPoint(x: number, y: number, r: number){
    this.http.post<Point>('http://localhost:8080/points', {x, y, r}).subscribe(
      this.addPoint.bind(this),
      console.error,
      console.log
    );
  }

  addPoint(p: Point){
    this.points.push(p);
    console.log(p);
  }

  addPoints(ps: Point[]){
    console.log(ps);
    console.log(this);
    if(ps)
      ps.forEach((p)=>this.addPoint(p));
  }
}
