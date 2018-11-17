import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { TodoComponent } from './todo/todo.component';
import { NewTodoComponent } from './new-todo/new-todo.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {TodoService} from './service/todo.service';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  {path: 'todo' , component: TodoComponent},
  {path: 'new-todo' , component: NewTodoComponent},
  {path: 'login' , component: LoginComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}
];
@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    NewTodoComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes), HttpModule, FormsModule
  ],
  providers: [TodoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
