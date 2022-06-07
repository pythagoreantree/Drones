package com.delivery.drones.exceptions;

public class DronesApiException {
    String message;
    Throwable cause;

    public DronesApiException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }
}
