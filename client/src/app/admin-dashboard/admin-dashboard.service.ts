import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminDashboardService {

constructor(private http: HttpClient) { }

updateStatus(data){
  return this.http.post('http://localhost:8080/updateClaimStatus', data);
}

fetchClaimData(status: String){
 return this.http.get('http://localhost:8080/getByClaimStatus/'+status);
}

fetchCustomerCount(){
  return this.http.get('http://localhost:8080/getCustomerCount');
}

fetchClaimCount(){
  return this.http.get('http://localhost:8080/getClaimCount');
}

fetchPolicyCount(){
  return this.http.get('http://localhost:8080/getPolicyCount');
}

fetchRenewCount(){
  return this.http.get('http://localhost:8080/getRenewCount');
}

}
