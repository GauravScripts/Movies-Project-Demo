import { Component } from '@angular/core';
import {AdminService} from "../admin.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  getAllProducts(){
    this.adminService.getAllMovies().subscribe(
      response=>{
        this.allMovies=response;
      })
  }
  constructor(private adminService:AdminService) {
    this.getAllProducts();

  }
  movieForm=new FormGroup({
    'movieId':new FormControl(),
    'movieName':new FormControl(),
    'movieDesc':new FormControl(),
    'movieRating':new FormControl()
  });
  sendMovieData(){
    console.log(this.movieForm.value);
    this.adminService.addNewMovie(this.movieForm.value).subscribe(

      response=>{
        console.log(response);
        this.getAllProducts();
        alert("Movie Added Successfully");
      })
   }
  allMovies:any;
deleteMovie(movieid:string){
    console.log(movieid);
    this.adminService.deleteMovie(movieid).subscribe(
      response=>{
        this.getAllProducts();
      })

}
editMovieForm=new FormGroup({
    'movieId':new FormControl(),
    'movieName':new FormControl(),
    'movieDesc':new FormControl(),
    'movieRating':new FormControl()
  });
getEditableMovie(movie:any){
    console.log(movie);
    this.editMovieForm.setValue(movie);

}
updateMovie(){
    this.adminService.updateMovie(this.editMovieForm.value).subscribe(
      response=>{
        this.getAllProducts();
      })
}
}
