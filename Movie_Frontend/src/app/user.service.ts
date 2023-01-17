import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }
  authAppBeBaseUrl = "http://localhost:4445/auth-app-v1";
  // authAppBeBaseUrl = "http://localhost:9999/auth-app-v1";
  movieAppBeBaseUrl = "http://localhost:8080/movie"
  // movieAppBeBaseUrl = "http://localhost:9999/movie"
  registerUser(signupdata:any){
    return this.httpClient.post(this.authAppBeBaseUrl+"/register-user1",signupdata);
  }
  loginCheck(logindata:any){
    return this.httpClient.post(this.authAppBeBaseUrl+"/login-check",logindata);
  }
  getUserDetails(){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.get(this.movieAppBeBaseUrl+"/get-user-details",requestOptions);
  }
  addMovieToUserCart(movieObj:any){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.post(this.movieAppBeBaseUrl+"/add-movie-to-user",movieObj,requestOptions);
  }
}
