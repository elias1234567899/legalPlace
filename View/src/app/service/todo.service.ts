import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Todo} from '../model/todo';
import "rxjs/add/operator/map";

@Injectable()
export class TodoService {

  constructor(public http:Http) { }

  getTodos(motCle:string,page:number,size:number ){
    return this.http.get("http://localhost:8080/contacts/search?mc="+motCle+"&size="+size+"&page="+page)
      .map(resp => resp.json());
  }

  gett(){
    return this.http.get("http://localhost:8080/todos/list")
      .map(resp => resp.json());
  }

  saveTodo(todo:Todo){
    return this.http.post("http://localhost:8080/todos/save",todo)
      .map(resp => resp.json());
  }

  getTodo(id:number){
    return this.http.get("http://localhost:8080/todos/"+id)
      .map(resp => resp.json());
  }

  deleteTodo(id:number){
    return this.http.delete("http://localhost:8080/todos/delete/"+id)
      .map(resp => resp.json());
  }

}
