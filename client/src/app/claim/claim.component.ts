import { ClaimInsuranceService } from './../claim-insurance.service';

import { ApproveClaim } from './../entity/approveClaim';
import { Claim } from './../entity/claim';

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'claim-insurance',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css']
})
export class ClaimComponent implements OnInit {

  claim: Claim = new Claim();
  approveClaim: ApproveClaim = new ApproveClaim();

  constructor(private service: ClaimInsuranceService, private router: Router) { }

  claimInsurance(){
    this.service.claimInsurance(this.claimCustomerId(this.claim)).subscribe(data =>{
      alert(JSON.stringify(data));
    })

    this.router.navigate(['claimStatus']);
  }

  updateStatus(){
    this.service.updateStatus(this.approveClaimCustomerId(this.approveClaim)).subscribe(data =>{
      alert(JSON.stringify(data));
    })
  }

  claimCustomerId(claim){
    claim.customerId = sessionStorage.getItem('id');
    return claim;
  }

  approveClaimCustomerId(approveClaim){
    approveClaim.customerId = sessionStorage.getItem('id');
    return approveClaim;
  }

  ngOnInit(): void {
  }

}
