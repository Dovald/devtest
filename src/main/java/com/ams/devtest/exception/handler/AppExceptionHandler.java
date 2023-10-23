package com.ams.devtest.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ams.devtest.exception.ProductNotFoundException;
import com.ams.devtest.exception.ThirdPartyException;

@ControllerAdvice
public class AppExceptionHandler 
  extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = { ProductNotFoundException.class })
    protected ResponseEntity<Object> handleProductNotFoundException(RuntimeException ex, WebRequest request) {
    	
    	String errorMessage = ex.getMessage();
        
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    
    @ExceptionHandler(value = { ThirdPartyException.class })
    protected ResponseEntity<Object> handleThirdPartyException(RuntimeException ex, WebRequest request) {
    	
    	String errorMessage = ex.getMessage();
        
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}