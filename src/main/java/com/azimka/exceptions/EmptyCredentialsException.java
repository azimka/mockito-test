package com.azimka.exceptions;

public class EmptyCredentialsException extends Exception {

    public EmptyCredentialsException() {
        super("credentials should be not empty");
    }
}
