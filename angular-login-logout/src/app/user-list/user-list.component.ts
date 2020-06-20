import { UserListService } from './../user-list.service';
import { User } from './../user';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users:Observable<User[]>;

  constructor(private userListService:UserListService) { }

  ngOnInit() {
    this.displayUsers();
  }

  displayUsers(){
     this.users=this.userListService.getUserList();
  }

  deleteUser(emailId:string){

    this.userListService.deleteUser(emailId);
     
  }
}
