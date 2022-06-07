package com.delivery.drones.handlers;

import com.delivery.drones.exceptions.DronesApiException;
import com.delivery.drones.exceptions.DronesOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DronesExceptionHandler {

    @ExceptionHandler(value = {DronesOperationException.class})
    public ResponseEntity<Object> handleDronesOperationException(DronesOperationException exception){
        DronesApiException dronesApiException = new DronesApiException(
                exception.getMessage(),
                exception.getCause()
        );
        return new ResponseEntity<>(dronesApiException, HttpStatus.BAD_REQUEST);
    }
}
