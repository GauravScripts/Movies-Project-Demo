import {Component, OnInit} from '@angular/core';
import {UserService} from "../user.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {}
signupForm = new FormGroup({
    'emailId':new FormControl(),
    'password': new FormControl(),
    'userName':new FormControl(),
    'mobileNo':new FormControl(),
    "address":new FormControl()
});
sendSignupData(){
  prompt("Signup Successfull");
  console.log(this.signupForm.value);
  this.userService.registerUser(this.signupForm.value).subscribe(

    response=>{
      console.log(response);
    }

  )
}

}
