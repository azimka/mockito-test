package com.azimka;

public class AuthenticatorApplication {

    private AuthenticatorInterface authenticatorInterface;

    public AuthenticatorApplication(AuthenticatorInterface authenticatorInterface) {
        this.authenticatorInterface = authenticatorInterface;
    }

    public boolean authenticate(String name, String password) {

        if (!authenticatorInterface.validateCredentials(name, password)) {
            throw new RuntimeException("credentials not valid");
        }

        return this.authenticatorInterface.authenticateUser(name, password);
    }
}
