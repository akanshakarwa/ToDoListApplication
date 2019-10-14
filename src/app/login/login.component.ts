import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoService } from '../todo.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route: Router, private service: TodoService) { }

  user: User;
  username: string;
  password: string;
  errorMessage: string;
  errorOccured: boolean;

  ngOnInit() {
    this.user = new User();
    this.errorOccured = false;
  }

  /**
   * This function is used to redirected dashboard on login
   */
  redirectToDashboard() {
    this.errorOccured = false;
    console.log(this.username);
    console.log(this.password);
    this.service.findAll(this.username, this.password).subscribe(result => {
      if (result.length > 0 || result.length == 0) {
        this.service.userdata = result;
        this.route.navigate(['/dashboard']);
      }
      else {
        alert('error');
      }
    },
      (error) => {

        this.errorOccured = true;
        this.errorMessage = "Something Went Wrong";
        this.username = '';
        this.password = '';
      }

    )
  }

}
