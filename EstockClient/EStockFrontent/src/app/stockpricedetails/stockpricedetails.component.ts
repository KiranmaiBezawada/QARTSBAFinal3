import { Component, OnInit } from '@angular/core';
import{Company} from '../company'

@Component({
  selector: 'app-stockpricedetails',
  templateUrl: './stockpricedetails.component.html',
  styleUrls: ['./stockpricedetails.component.css']
})
export class StockpricedetailsComponent implements OnInit {
stockpricedetails:Company[] | undefined; 
  constructor() { }

  ngOnInit(): void {
  }

}
