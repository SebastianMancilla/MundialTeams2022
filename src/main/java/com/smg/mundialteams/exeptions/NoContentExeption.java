package com.smg.mundialteams.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentExeption extends  RuntimeException{

    public NoContentExeption(String message){
        super(message);
    }

}
