package com.smg.mundialteams.exeptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExeptionResponse {
    private LocalDateTime localDateTime;
    private String message;

    private HttpStatus status;
    private String details;

    public ExeptionResponse(LocalDateTime localDateTime, String message, String details, HttpStatus httpStatus){
        super();
        this.localDateTime = localDateTime;
        this.message = message;
        this.status = httpStatus;
        this.details = details;
    }
}
