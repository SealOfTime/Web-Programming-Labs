import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PointFormComponent } from './point-form.component';

describe('PointFormComponent', () => {
  let component: PointFormComponent;
  let fixture: ComponentFixture<PointFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PointFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PointFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
