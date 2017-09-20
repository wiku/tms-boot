/*
 * Copyright (c) 2017 Wiku. All rights reserved.
 */
package com.wiku.tms.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiku.tms.boot.model.users.UserAccount;
import com.wiku.tms.boot.repository.UserAccountRepository;

@RestController
@RequestMapping("api/v1")
public class UserAccountController
{

    @Autowired
    private UserAccountRepository repository;

    @RequestMapping(value="users", method=RequestMethod.GET)
    public List<UserAccount> getAll()
    {
        return repository.findAll();
    }
}
