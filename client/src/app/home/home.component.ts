import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  checkSessionBuy(){
    if(sessionStorage.getItem('id')==null){
      alert("Please login first.");
    }
    else 
    this.router.navigate(['buyInsurance']);
  }
  checkSessionClaim(){
    if(sessionStorage.getItem('id')==null){
      alert("Please login first.");
    }
    else 
    this.router.navigate(['claimInsurance']);
  }
  checkSessionRenew(){
    if(sessionStorage.getItem('id')==null){
      alert("Please login first.");
    }
    else 
    this.router.navigate(['renew']);
  }

}
