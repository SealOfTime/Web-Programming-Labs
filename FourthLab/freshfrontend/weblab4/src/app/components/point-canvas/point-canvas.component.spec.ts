import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PointCanvasComponent } from './point-canvas.component';

describe('PointCanvasComponent', () => {
  let component: PointCanvasComponent;
  let fixture: ComponentFixture<PointCanvasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PointCanvasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PointCanvasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
