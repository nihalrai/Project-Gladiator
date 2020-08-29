import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })

export class OtpService {
    otpDto = new OtpDto()
    constructor(private http: HttpClient) { }
    
    verifyOtp(otp){   
        this.otpDto.otp = otp
        const url="http://localhost:8080/verifyOtp";
        const headers = new HttpHeaders({'Content-Type': 'application/json', 'Accept': 'application/json', 'Access-Control-Allow-Origin':'*'});
        return this.http.post(url, this.otpDto, {headers: headers});
    }

    }
export class OtpDto{
  otp:string
}