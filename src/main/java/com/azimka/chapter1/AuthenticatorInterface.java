package com.azimka.chapter1;

import com.azimka.exceptions.EmptyCredentialsException;

public interface AuthenticatorInterface {

    boolean authenticateUser(String name, String password) throws EmptyCredentialsException;

    boolean validateCredentials(String name, String password);
}
