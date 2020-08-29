import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })

export class ResetPasswordService {

    constructor(private http: HttpClient) { }
    
    resetPassword(resetDto){    
        const url="http://localhost:8080/updatePassword";
        const headers = new HttpHeaders({'Content-Type': 'application/json', 'Accept': 'application/json'});
        return this.http.post<ResetDto>(url, resetDto, {headers: headers});
    }

    }
    export class ResetDto{
      email:string;
      oldPassword:string;
      newPassword:string;
    }
    