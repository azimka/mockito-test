package com.azimka.chapter1;

import com.azimka.chapter1.AuthenticatorApplication;
import com.azimka.chapter1.AuthenticatorInterface;
import com.azimka.exceptions.EmptyCredentialsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShorthandMockTest {

    @Mock
    private AuthenticatorInterface authenticatorMock;

    @InjectMocks
    private AuthenticatorApplication authenticatorApplication;

    private String username = "azimka";
    private String password = "password";

    @Before
    public void doBefore() throws EmptyCredentialsException {
        when(authenticatorMock.authenticateUser(username, password)).thenReturn(true);

        when(authenticatorMock.validateCredentials(username, password)).thenReturn(true);
    }

    @Test
    public void testObjectMockedProperly() throws EmptyCredentialsException {
        assertTrue(authenticatorApplication.authenticate(username, password));
    }
}
