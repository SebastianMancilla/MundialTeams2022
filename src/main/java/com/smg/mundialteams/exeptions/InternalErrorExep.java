package com.smg.mundialteams.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorExep extends  RuntimeException{
    public InternalErrorExep (String message){
        super(message);
    }
}