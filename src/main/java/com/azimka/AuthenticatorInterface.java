package com.azimka;

public interface AuthenticatorInterface {

    boolean authenticateUser(String name, String password);

    boolean validateCredentials(String name, String password);
}
