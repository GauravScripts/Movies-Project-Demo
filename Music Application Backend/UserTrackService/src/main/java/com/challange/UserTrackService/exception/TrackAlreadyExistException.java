package com.challange.UserTrackService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Track Already Exist !!!!!!11")
public class TrackAlreadyExistException extends Exception{
}
