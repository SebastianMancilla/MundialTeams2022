package com.smg.mundialteams.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContent extends  RuntimeException{
    public NoContent (String message){
        super(message);
    }
    public NoContent(String message, Throwable throwable){
        super(message, throwable);
    }
}
