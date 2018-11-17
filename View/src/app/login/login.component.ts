import { Component, OnInit } from '@angular/core';
import {UserService} from '../service/user.service';
import {Todo} from '../model/todo';
import {User} from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User = new User;
  constructor(public userservice:UserService) { }

  ngOnInit() {
  }

  saveUser(){
    this.userservice.saveUser(this.user)
      .subscribe(data => {
        this.user=data;

      },err =>{
        console.log(err)
      })
  }

}
