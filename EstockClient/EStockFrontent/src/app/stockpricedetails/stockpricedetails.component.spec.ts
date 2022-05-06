import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockpricedetailsComponent } from './stockpricedetails.component';

describe('StockpricedetailsComponent', () => {
  let component: StockpricedetailsComponent;
  let fixture: ComponentFixture<StockpricedetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockpricedetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockpricedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
