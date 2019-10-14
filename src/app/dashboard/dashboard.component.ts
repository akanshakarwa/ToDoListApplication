import { Component, OnInit } from '@angular/core';
import { TodoService } from '../todo.service';
import { User } from '../user';
import { Userdata } from '../userdata.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  tasklist: Userdata[] = [];
  newtaskDesc: string;
  userName: String;
  constructor(private route: Router, private service: TodoService) { }

  ngOnInit() {

    this.tasklist = this.service.userdata;
    this.userName = (this.service.userName);

  }

  /**
   * This function used when delete task button is pressed.
   * @param id 
   */
  deleteTask(id: string) {
    this.service.delete(id).subscribe(result => {
      console.log(result);
      alert("Task Deleted from List");
      this.service.findAllTask(this.tasklist[0].id).subscribe(data => {
        this.tasklist = data;
      });
    });

  }

  /**
   * This finction is used to add task
   * @param id
   */
  addTask() {
    let newUserdata = new Userdata();
    newUserdata.taskDescription = this.newtaskDesc;
    newUserdata.id = this.tasklist[0].id;
    this.service.save(newUserdata).subscribe(result => {
      console.log(result);
      if (result != null) {
        alert("Task Added To List");
        this.service.findAllTask(this.tasklist[0].id).subscribe(data => {
          this.tasklist = data;
          this.newtaskDesc = '';

        })
      }
    })
  }

  /**
   * This function is called when user wants to logout
   */
  logout() {
    this.route.navigate(['/login']);
  }



}
