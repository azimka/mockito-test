package com.azimka;

public class AuthenticatorApplication {

    private AuthenticatorInterface authenticatorInterface;

    public AuthenticatorApplication(AuthenticatorInterface authenticatorInterface) {
        this.authenticatorInterface = authenticatorInterface;
    }

    public boolean authenticate(String name, String password) {
        return this.authenticatorInterface.authenticateUser(name, password);
    }
}
