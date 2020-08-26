import { Component, OnInit } from '@angular/core';
import { RegisterationService } from './registration.service';
import { Router } from '@angular/router';
import { FormsModule, Validators } from '@angular/forms';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-register',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {

  customer: Customer = new Customer();

  constructor(
      private customerService: RegisterationService,
      private router: Router
  ) { }

  ngOnInit(): void {
    /* if time left
    this.registerForm = this.formBuilder.group({
          name: ['', Validators.required],
          lastName: ['', Validators.required],
          username: ['', Validators.required],
          password: ['', [Validators.required, Validators.minLength(6)]]
      });
    */
  }

  register(){
    //console.log(this.customer);
    alert(JSON.stringify(this.customer))
    this.customerService.register(this.customer).subscribe(data =>{
      alert(JSON.stringify(data));
      if (data.status == 'SUCCESS'){
        // Verify your email address and re-login
        // Show registration successfull

        //this.router.navigate(['login']);
        this.router.navigate(['home']);
      }
      else{
        //error show and re register
        this.router.navigate(['register']);
      }
    })
  }
}
