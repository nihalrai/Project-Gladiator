import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })

export class UserDashboardService {

    constructor(private http: HttpClient) { }


    // Common utility
    isUserLoggedIn(id) {
      let user = sessionStorage.getItem(id)
      if (user === null) {
          return false
      }
      else{
        return true
      }
    }

    getLoggedInId() {
      let user = sessionStorage.getItem('id')
      if (user === null) {
        return ''
      }
      else{
        return user
      }
    }

    getLoggedInRole() {
      let role = sessionStorage.getItem('role')
      if (role === null) {
          return ''
      }
      else{
        return role
      }
    }
}
