import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Customer } from '../model/customer';

@Injectable({
    providedIn: 'root'
  })

export class RegisterationService {

    constructor(private http: HttpClient) { }

    register(customer){
        const url="http://localhost:8080/register";
        const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8', 'Accept': 'application/json'});
        return this.http.post<Customer>(url, customer, {headers: headers});
    }
}
