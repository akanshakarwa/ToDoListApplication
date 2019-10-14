import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import { Userdata } from './userdata.model';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private userUrl = '/api';

   userdata : Userdata[] = [];

   userName:String;
 
  constructor(private http: HttpClient) {
    //this.usersUrl = 'http://localhost:8081/todoList/login';
  }
 
  public findAll(username:String,password:String): Observable<Userdata[]> {
    this.userName = username;
    return this.http.get<Userdata[]>(this.userUrl+'/login/'+username+'/'+password);
  }
 
  public save(user: Userdata) {
    return this.http.post<Userdata>(this.userUrl+'/addToList/', user);
  }

  public delete(id: string){
    return this.http.delete(this.userUrl+'/deleteTask/' + id);

  }

  public findAllTask(id:string)
  {
    return this.http.get<Userdata[]>(this.userUrl+'/fetchTask/'+id);
  }
}
