package com.azimka.chapter1;

import com.azimka.exceptions.EmptyCredentialsException;

public class AuthenticatorApplication {

    private AuthenticatorInterface authenticatorInterface;

    public AuthenticatorApplication(AuthenticatorInterface authenticatorInterface) {
        this.authenticatorInterface = authenticatorInterface;
    }

    public boolean authenticate(String name, String password) throws EmptyCredentialsException {

        if (!authenticatorInterface.validateCredentials(name, password)) {
            throw new RuntimeException("credentials not valid");
        }

        return this.authenticatorInterface.authenticateUser(name, password);
    }
}
