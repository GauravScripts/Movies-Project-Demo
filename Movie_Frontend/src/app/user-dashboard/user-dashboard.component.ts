import { Component } from '@angular/core';
import {UserService} from "../user.service";
import {AdminService} from "../admin.service";

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {
  getUserDetails(){
    this.userService.getUserDetails().subscribe(
      response=>{
        console.log("User Details");
        console.log(response);
        this.userDetails=response;
      } )
  }

  constructor(private userService:UserService, private adminService:AdminService) {
    this.getUserDetails();
    this.getAllMovies();
  }
  userDetails:any;
  addMovieToCart(movieObj:any){
    this.userService.addMovieToUserCart(movieObj).subscribe(
      response=>{
        this.getUserDetails();
      } )

  }
  allMovies:any;
  getAllMovies(){
    this.adminService.getAllMovies().subscribe(
      response=>{
        this.allMovies=response;
      })
  }
}
