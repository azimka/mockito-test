package com.azimka.chapter2;

import com.azimka.exceptions.NotAuthenticateException;

public interface AuthenticatorInterface {

    void authenticate(String username, String password) throws NotAuthenticateException;
}
