import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import {TodoService} from '../service/todo.service';
import {Router} from '@angular/router';
import {Todo} from '../model/todo';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  pageTodos: any;
  motCle: string = '';
  currentPage: number = 0;
  size: number = 5;
  pages: Array<number>;

  constructor(public http: Http, public todoservice: TodoService, public router:Router) {
  }

  ngOnInit() {

    this.onGetTodos();
  }

  doSearch() {
    this.todoservice.getTodos(this.motCle, this.currentPage, this.size)
      .subscribe(data => {
        this.pageTodos= data;
        this.pages = new Array(data.totalPage);
      }, err => {
        console.log(err);
      });
  }
 onGetTodos(){
   this.todoservice.gett()
     .subscribe(data => {
       this.pageTodos= data;
       this.pages = new Array(data.totalPage);
     }, err => {
       console.log(err);
     });
 }
  search() {

    this.doSearch();

  }

  gotoPage(i: number) {
    this.currentPage = i;
    this.doSearch();
  }


  onDeleteTodo(c:Todo){
    let confirm=window.confirm("Est vous sure ?")
    if(confirm==true){
      this.todoservice.deleteTodo(c.id)
        .subscribe(data => {
          this.pageTodos.content.splice(
            this.pageTodos.content.indexOf(c),1
          );
          this.pages = new Array(data.totalPages);
        }, err => {
          console.log(err);
        });
    }
    this.onGetTodos();
  }

}
