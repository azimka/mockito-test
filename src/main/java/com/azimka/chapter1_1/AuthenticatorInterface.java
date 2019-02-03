package com.azimka.chapter1_1;

import com.azimka.exceptions.NotAuthenticateException;

public interface AuthenticatorInterface {

    void authenticate(String username, String password) throws NotAuthenticateException;
}
