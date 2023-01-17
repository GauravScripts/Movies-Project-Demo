package com.challange.UserTrackService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Artist Already Exist Exception")
public class ArtistAlreadyExistException extends Exception{
}
