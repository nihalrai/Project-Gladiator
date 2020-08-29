import { Router } from '@angular/router';
import { ApproveClaim } from './../entity/approveClaim';
import { Claim } from './../entity/claim';
import { AdminDashboardService } from './admin-dashboard.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  data: any;
  customerCount: any;
  renewCount: any;
  claimCount: any;

  constructor(private service: AdminDashboardService, private router: Router) { }

  fetchCustomerCount(){
    this.service.fetchCustomerCount().subscribe(data=>{
      alert(JSON.stringify(data));
    })
  }

  fetchClaimCount(){
    this.service.fetchClaimCount().subscribe(data=>{
      alert(JSON.stringify(data));
    })
  }

  fetchPolicyCount(){
    this.service.fetchPolicyCount().subscribe(data=>{
      alert(JSON.stringify(data));
    })
  }

  fetchRenewCount(){
    this.service.fetchRenewCount().subscribe(data=>{
      alert(JSON.stringify(data));
    })
  }

  statusUpdate(id, status){
    let data = new ApproveClaim()
    
    data.claimId = id
    data.status = status

    this.service.updateStatus(data).subscribe(data =>{
      window.location.reload();
    })
  }

  ngOnInit(): void {
      this.service.fetchClaimData('PENDING').subscribe(data=>{
      this.data = data;
      console.log(JSON.stringify(this.data))
    })
    
    this.service.fetchCustomerCount().subscribe(data=>{
      //alert(JSON.stringify(data));
      this.customerCount = data;
    })

    this.service.fetchClaimCount().subscribe(data=>{
      //alert(JSON.stringify(data));
      this.claimCount = data;
    })

    this.service.fetchRenewCount().subscribe(data=>{
      //alert(JSON.stringify(data));
      this.renewCount = data;
    })
  }
}
