import { NgModule } from '@angular/core';
import { RouterModule,Routes} from '@angular/router';
import {DashboardComponent} from './dashboard/dashboard.component'
import {LoginComponent} from './login/login.component';

const approutes : Routes = [

  {path:'login',  component:LoginComponent},
{path:'dashboard',  component:DashboardComponent}

]
;

@NgModule({
  imports: [
    
    RouterModule.forRoot(approutes)
    
  ],
  exports:[RouterModule]


 
})
export class AppRoutingModule { }
