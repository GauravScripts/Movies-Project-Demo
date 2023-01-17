import {Component, OnInit} from '@angular/core';
import {UserService} from "../user.service";
import { FormControl, FormGroup } from '@angular/forms';
import {Router} from "@angular/router";
import {AuthService} from "../auth/auth.service";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
constructor(private  userService:UserService, private router:Router, private auth:AuthService) {}
  ngOnInit(): void {  }
  loginForm = new FormGroup({
    'emailId':new FormControl(),
    'password':new FormControl()
  });
reponseData:any;
sendLoginData(){
  console.log(this.loginForm.value);
  this.userService.loginCheck(this.loginForm.value).subscribe(
    response=>{
      console.log(response);
      this.reponseData=response;
      localStorage.setItem("jwt",this.reponseData.token);
      localStorage.setItem("role",this.reponseData.role);
      if(this.reponseData.role=='ROLE_ADMIN'){
        this.router.navigateByUrl("/adminView");
      }
      else{
        this.router.navigateByUrl("/userView");
      }
    }
  )
}
  valicheck:any;
  validate()
  {
    this.userService.loginCheck(this.loginForm.value).subscribe
    (
      data=>
      {
        this.valicheck=data;
        console.log(this.valicheck+"this is the data");
        console.log(this.valicheck.role);
        // console.log(this.valicheck.password);
        if(this.valicheck.role=="ROLE_ADMIN"|| this.valicheck.role=="ROLE_USER")
        {
          this.auth.login();
          //  this.route.navigateByUrl("details");

        }
      }
    )
  }
}
