import { LoginService } from './../login/login.service';

import { Router } from '@angular/router';
import { Vehicle } from './../entity/vehicle';

import { BuyInsuranceService } from './../buy-insurance.service';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'buy-insurance',
  templateUrl: './buy-insurance.component.html',
  styleUrls: ['./buy-insurance.component.css']
})

export class BuyInsuranceComponent implements OnInit {

  vehicle: Vehicle = new Vehicle();

  constructor(private service: BuyInsuranceService, private router: Router, private loginService: LoginService) { }

  buyInsurance(){
    this.service.buyInsurance(this.setVehicleDto(this.vehicle)).subscribe(data =>{
      alert(JSON.stringify(data));
    })
    this.router.navigate(['payment']);
}

  setVehicleDto(vehicle){
    vehicle.customerId = sessionStorage.getItem('id')

    return vehicle;
  }

  ngOnInit(): void {
  }

}