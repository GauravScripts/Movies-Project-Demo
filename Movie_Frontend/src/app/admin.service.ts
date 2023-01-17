import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient:HttpClient) { }
  // movieAppBeBaseUrl = "http://localhost:9999/movie";
  movieAppBeBaseUrl = "http://localhost:8080/movie";
  getAllMovies() {
    return this.httpClient.get(this.movieAppBeBaseUrl+"/get-all-movies");
  }

  addNewMovie(movieObj:any){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.post(this.movieAppBeBaseUrl+"/admin/add-new-movie",movieObj,requestOptions);
  }
  deleteMovie(movieId:string){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.delete(this.movieAppBeBaseUrl+"/admin/delete-movie/" + movieId);
  }
  updateMovie(movieObj:any){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.put(this.movieAppBeBaseUrl+"/admin/update-movie",movieObj,requestOptions);
  }


}
