import { Injectable } from '@angular/core';
import {Todo} from '../model/todo';
import {Http} from '@angular/http';
import {User} from '../model/user';

@Injectable()
export class UserService {

  constructor(public http:Http) { }

  getUsers(motCle:string,page:number,size:number ){
    return this.http.get("http://localhost:8080/users/list/search?mc="+motCle+"&size="+size+"&page="+page)
      .map(resp => resp.json());
  }

  saveUser(user:User){
    return this.http.post("http://localhost:8080/users/save",user)
      .map(resp => resp.json());
  }

  getUser(id:number){
    return this.http.get("http://localhost:8080/users/"+id)
      .map(resp => resp.json());
  }

  deleteUser(id:number){
    return this.http.delete("http://localhost:8080/users/delete/"+id)
      .map(resp => resp.json());
  }

}
