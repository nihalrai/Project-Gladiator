import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PremiumEstimateComponent } from './premium-estimate.component';

describe('PremiumEstimateComponent', () => {
  let component: PremiumEstimateComponent;
  let fixture: ComponentFixture<PremiumEstimateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PremiumEstimateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PremiumEstimateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
