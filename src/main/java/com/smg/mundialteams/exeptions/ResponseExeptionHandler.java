package com.smg.mundialteams.exeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

//@ControllerAdvice
public class ResponseExeptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(NoContentExeption.class)
//    public  ResponseEntity<ExeptionResponse> notContent(NoContentExeption ex, WebRequest webRequest){
//        ExeptionResponse exeptionResponse = new ExeptionResponse(LocalDateTime.now(), ex.getMessage(),webRequest.getDescription(false), ex.getHttpStatus());
//        return new ResponseEntity<>(exeptionResponse, ex.getHttpStatus());
//    }

}
