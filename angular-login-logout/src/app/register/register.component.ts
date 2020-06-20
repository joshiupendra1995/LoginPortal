import { Router } from '@angular/router';
import { RegisterService } from './../register.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private registerService:RegisterService,private router:Router) { }

  user:User=new User();

  ngOnInit() {
  }

  register(){
      this.registerService.register(this.user).subscribe(
        data=>console.log("logged in successfully"));
        this.router.navigate(['']);

  }



}
