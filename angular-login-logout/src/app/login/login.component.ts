import { Router } from '@angular/router';
import { User } from './../user';
import { LoginService } from './../login.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User=new User();
  loginForm:FormGroup;

  constructor(private loginService:LoginService,private router:Router,private formBuilder:FormBuilder) { }

 
  
  ngOnInit() {
    this.user=new User();
    this.validateLoginForm();
  }

  validateLoginForm(){
      this.loginForm=this.formBuilder.group({
        email:['',Validators.required],
        password:['',Validators.required]

      });
  }

  get f(){
    return this.loginForm.controls;
  }




  // login(){
  //     this.loginService.login(this.user.emailId,this.user.password).subscribe(
  //       data=>{
  //         alert("logged in successfully")
  //         this.router.navigate(['/users']);
          
  //       },
  //        ()=>{
  //          alert("Invalid Username and Password")
  //          this.router.navigate(['']);
  //          this.user=new User();
  //        }
  //       );


  login(){
       this.router.navigate(['/users']);
  }
        
       
        
  
  

}
