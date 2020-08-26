import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { LoginDto } from './login.dto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDto: LoginDto = new LoginDto();

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }
  login(){
    this.loginService.login(this.loginDto).subscribe(data =>{
      alert(JSON.stringify(this.data));

      if(data.status == 'SUCCESS'){
        let id = data.customerId;
        let name = data.customerName;
        let role = data.role;

        sessionStorage.setItem('customerId', id);
        sessionStorage.setItem('customerName', name);
        sessionStorage.setItem('role', role);

        this.router.navigate(['user-dashboard']);
      }
      else{
        //show error on login page fronted part
        this.router.navigate(['login']);
      }
    })
  }

}
