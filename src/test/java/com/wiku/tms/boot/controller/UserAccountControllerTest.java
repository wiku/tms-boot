/*
 * Copyright (c) 2017 Wiku. All rights reserved.
 */
package com.wiku.tms.boot.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wiku.tms.boot.model.users.UserAccount;
import com.wiku.tms.boot.repository.UserAccountRepository;

public class UserAccountControllerTest
{

    private static final List<UserAccount> USERS = Arrays.asList(new UserAccount("user", "password", "role"));

    @Mock
    private UserAccountRepository repository;
    @InjectMocks
    private UserAccountController controller;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void canGetAllUsersFromRepository()
    {
        when(repository.findAll()).thenReturn(USERS);
        assertThat(controller.getAll()).isEqualTo(USERS);
    }

}
