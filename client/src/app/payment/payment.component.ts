import { Component, OnInit } from '@angular/core';
import { PaymentDto } from './payment.dto';
import { PaymentService } from './payment.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {

paymentDto: PaymentDto = new PaymentDto;

  constructor(private paymentService : PaymentService, private router: Router) { }

  pay(){
    //alert(JSON.stringify(this.policy));
    this.paymentService.payNow(this.paymentDto).subscribe(data => {
      alert(JSON.stringify(data));
      })
      alert("Click 'OK' to confirm payment");
       
      this.router.navigate(['congratulations']);
    }
  }
