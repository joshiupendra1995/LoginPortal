import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private baseUrl="http://localhost:8088/user/register";

  constructor(private httpClient:HttpClient) { 

  }


  register(user:User):Observable<Object>{
      return this.httpClient.post(`${this.baseUrl}`,user);  
}
}
