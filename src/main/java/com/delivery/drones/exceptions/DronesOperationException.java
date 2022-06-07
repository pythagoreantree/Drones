package com.delivery.drones.exceptions;

public class DronesOperationException extends RuntimeException {

    public DronesOperationException(String message){
        super(message);
    }

    public DronesOperationException(String message, Throwable e){
        super(message, e);
    }
}
