/*
 * Copyright (c) 2017 Wiku. All rights reserved.
 */
package com.wiku.tms.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiku.tms.boot.model.users.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>
{
    public UserAccount findByUsername(String username);
}
