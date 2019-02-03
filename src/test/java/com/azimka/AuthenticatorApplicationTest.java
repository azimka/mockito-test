package com.azimka;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class AuthenticatorApplicationTest {

    @Test
    public void authentiatorMockTest() {

        String userName = "azimka";

        String password = "password";

        AuthenticatorInterface authenticatorMock = Mockito.mock(AuthenticatorInterface.class);

        AuthenticatorApplication authenticatorApplication = new AuthenticatorApplication(authenticatorMock);

        when(authenticatorMock.authenticateUser(userName, password)).thenReturn(false);

        assertFalse(authenticatorApplication.authenticate(userName, password));

    }
}
