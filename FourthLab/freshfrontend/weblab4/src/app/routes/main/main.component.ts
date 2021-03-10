import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { Point } from 'src/app/models/point';
import { PointService } from 'src/app/services/point.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  points!: Point[];
  r!: number;

  constructor(private authService: AuthService, private pointServices: PointService, private router: Router) { }

  ngOnInit(): void {
    this.points = this.pointServices.points;
  }

  logout(){
    this.authService.logout();
    console.log("BYE");
    this.router.navigateByUrl("/login");
  }

}
