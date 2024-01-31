package com.nathalia.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                    .passwordEncoder(passwordEncoder())
                    .withUser("Nathalia")
                    .password(passwordEncoder().encode("pass123"))
                    .roles("USER")

                .and()
                    .passwordEncoder(passwordEncoder())
                    .withUser("admin")
                    .password(passwordEncoder().encode("admin"))
                    .roles("ADMIN")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                     .antMatchers("/test")
                         .authenticated()
                     .antMatchers("/test/admin")
                .hasRole("ADMIN")
                .and().httpBasic()
        ;

    }

}






















