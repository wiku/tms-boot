/*
 * Copyright (c) 2017 Wiku. All rights reserved.
 */
package com.wiku.tms.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wiku.tms.boot.model.users.UserAccount;
import com.wiku.tms.boot.repository.UserAccountRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserAccountRepository userRepository;

    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/assets", "/assets/**")
                .hasAnyRole("ADMIN", "USER")
                .antMatchers("/users")
                .hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
        auth.userDetailsService(createUserDetailsService());
    }

    @Bean
    UserDetailsService createUserDetailsService()
    {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
            {
                System.out.println("Loading user by name " + username);
                UserAccount user = userRepository.findByUsername(username);
                return new org.springframework.security.core.userdetails.User(user.getUsername(),
                        user.getPassword(),
                        AuthorityUtils.createAuthorityList("USER"));
            }
        };

    }
}