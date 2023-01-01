package com.hectormtzm.universitydao.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationReponse {

    private final int status = HttpStatus.BAD_REQUEST.value();
    private List<String> message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ValidationReponse (List<String> message){
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

}
