/*
 * Copyright (c) 2017 Wiku. All rights reserved.
 */
package com.wiku.tms.boot.model.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class UserAccount
{
    @Id
    @GeneratedValue
    private String id;
    private String username;
    private String password;
    private String role;

    public UserAccount( String username, String password, String role )
    {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
