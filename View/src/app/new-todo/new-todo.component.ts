import { Component, OnInit } from '@angular/core';
import {Todo} from '../model/todo';
import {TodoService} from '../service/todo.service';

@Component({
  selector: 'app-new-todo',
  templateUrl: './new-todo.component.html',
  styleUrls: ['./new-todo.component.css']
})
export class NewTodoComponent implements OnInit {

  todo:Todo = new Todo;
  mode:number=1;
  constructor(public todoservice:TodoService) { }

  ngOnInit() {
  }

  saveContact(){

    this.todoservice.saveTodo(this.todo)
      .subscribe(data => {
        this.todo=data;
        this.mode=2;
      },err =>{
        console.log(err)
      })

  }
}
