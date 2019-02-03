package com.azimka;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
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
        when(authenticatorMock.validateCredentials(userName, password)).thenReturn(true);
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

    @Test
    public void verifyMethodCallsOrder(){
        authenticatorApplication.authenticate(userName, password);

        InOrder inOrder = inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).validateCredentials(userName, password);
        inOrder.verify(authenticatorMock).authenticateUser(userName, password);
    }

    @Test
    public void timeoutTest(){
        authenticatorApplication.authenticate(userName, password);

        verify(authenticatorMock, timeout(100).times(1)).authenticateUser(userName, password);
    }
}
