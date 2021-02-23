package com.contact.api.config;

/*
Learned from https://bezkoder.com/spring-boot-restcontrolleradvice/
 */
import com.contact.api.exception.ClientRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorAdviceController  extends ResponseEntityExceptionHandler {

@ExceptionHandler(ClientRequestException.class)
    public ResponseEntity<ErrorDetails> handleException(ClientRequestException exception , WebRequest request){
System.out.println("Error "+exception.fillInStackTrace());
    ErrorDetails details = new ErrorDetails();
    details.setMessage(exception.getMessage());
    details.setTimestamp(Calendar.getInstance().getTime());
    return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST);
}

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDetails> handleNoSuchElementException(NoSuchElementException exception , WebRequest request){

        ErrorDetails details = new ErrorDetails();
        details.setMessage(exception.getMessage());
        details.setTimestamp(Calendar.getInstance().getTime());
        return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST);
    }

}
