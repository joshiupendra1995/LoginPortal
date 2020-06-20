import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserListService {

  private baseUrl = "http://localhost:8088/user";

  constructor(private http:HttpClient) { }

  
  getUserList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }

  deleteUser(emailId:string):void{
    this.http.delete(`${this.baseUrl}/delete/`+emailId);
  }


}
