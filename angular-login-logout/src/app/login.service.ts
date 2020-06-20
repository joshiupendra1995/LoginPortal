import { User } from './user';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { observable, Observable } from 'rxjs';
@Injectable(
    {
        providedIn:'root'
    }
)

export class LoginService{

    private baseUrl="http://localhost:8088/user";

    constructor(private httpClient:HttpClient){

    }

    login(emailId:string,password:string):Observable<Object>{

        return this.httpClient.put(`${this.baseUrl}/login/username/${emailId}/password/${password}`,{ responseType:'text'});

    }
}


