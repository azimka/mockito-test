package com.azimka.exceptions;

public class NotAuthenticateException extends Exception {

    public NotAuthenticateException() {
        super("Authentication failed");
    }
}
