package com.azimka.chapter1_1;

import com.azimka.exceptions.NotAuthenticateException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorApplicationTest {

    private String username = "azimka";
    private String password = "password";

    @Mock
    AuthenticatorInterface authenticatorInterface;

    @InjectMocks
    AuthenticatorApplication authenticatorApplication;

    @Before
    public void doBefore() throws NotAuthenticateException {

        doThrow(new NotAuthenticateException())
                .when(authenticatorInterface).authenticate(username, password);
    }

    @Test(expected = NotAuthenticateException.class)
    public void testAuthentication() throws NotAuthenticateException {
        authenticatorApplication.authenticate(username, password);
    }
}
