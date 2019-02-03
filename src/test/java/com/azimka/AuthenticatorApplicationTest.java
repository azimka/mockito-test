package com.azimka;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class AuthenticatorApplicationTest {

    private String userName = "azimka";
    private String password = "password";

    AuthenticatorInterface authenticatorMock;
    AuthenticatorApplication authenticatorApplication;

    @Before
    public void doBefore() {
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticatorApplication = new AuthenticatorApplication(authenticatorMock);
        when(authenticatorMock.authenticateUser(userName, password)).thenReturn(false);
    }

    @Test
    public void authentiatorMockTest() {

        assertFalse(authenticatorApplication.authenticate(userName, password));

        //Проверить, что метод вызывался
        verify(authenticatorMock).authenticateUser(userName, password);

        //1 вызов
        verify(authenticatorMock, times(1)).authenticateUser(userName, password);
        verify(authenticatorMock, atLeastOnce()).authenticateUser(userName, password);
        verify(authenticatorMock, atLeast(1)).authenticateUser(userName, password);
        verify(authenticatorMock, atMost(1)).authenticateUser(userName, password);

    }

    @Test
    public void verifyMethodNotCallWithParams(){
        authenticatorApplication.authenticate(userName, password);

        //Проверка вызывался ли метод с такими параметрами
        verify(authenticatorMock).authenticateUser(userName, "some_other_password");

    }
}
