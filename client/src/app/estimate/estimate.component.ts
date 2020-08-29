import { Component, OnInit } from '@angular/core';
import { Premium } from './premium';
import { EstimateService } from './estimate.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
@Component({
  selector: 'app-estimate',
  templateUrl: './estimate.component.html',
  styleUrls: ['./estimate.component.css']
})
export class EstimateComponent {

  premium: Premium = new Premium();
 
  constructor(private estimateService: EstimateService) { }

  calculateClaim(){
    alert(JSON.stringify(this.premium));
    this.estimateService.estimate(this.premium).subscribe(data =>{
      alert(JSON.stringify(data));
    })
  }

}
