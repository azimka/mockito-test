package com.azimka.chapter1_1;

import com.azimka.exceptions.NotAuthenticateException;

public class AuthenticatorApplication {
    private AuthenticatorInterface authenticatorInterface;

    public AuthenticatorApplication(AuthenticatorInterface authenticatorInterface) {
        this.authenticatorInterface = authenticatorInterface;
    }

    public void authenticate(String username, String password) throws NotAuthenticateException {
        this.authenticatorInterface.authenticate(username, password);
    }
}
