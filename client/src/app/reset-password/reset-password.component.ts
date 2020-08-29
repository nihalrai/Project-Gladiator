import { Component, OnInit } from '@angular/core';
import { ResetPasswordService } from './reset-password.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  oldPassword:string;
  newPassword:string;

  reset = new ResetDto();

  constructor(private service: ResetPasswordService, private router:Router) { }

  ngOnInit(): void {
  }

  resetPassword(){
    this.reset.email = sessionStorage.getItem('email')
    this.reset.oldPassword = this.oldPassword
    this.reset.newPassword = this.newPassword
    
    this.service.resetPassword(this.reset).subscribe(dataDto =>{
        let data:any;
        data = dataDto
        if(data.status == 'SUCCESS'){ 
          this.router.navigate(['login']);
      }
      else{
        this.router.navigate(['home']);
      }
    })

  }

}

export class ResetDto{
  email:string;
  oldPassword:string;
  newPassword:string;
}
