package com.example.springSecurityDemo.config;

import com.example.springSecurityDemo.services.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
/*
 * Creating a custom spring security configuration class via extending the WebSecurityConfigurationAdapter
 *
 *
 * */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginUserService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //creating a http basic authentication mechanism.

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/public/**").hasRole("ADMIN") //this is permit only Admin role users for  all GET urls that has /public in prefix
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    // we can set  our own user name and password via this override method
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    //returns  an object of password encoder here NoPasswordEncoder is a pre-defined class that means  we are using plain text encoder
    @Bean
    public PasswordEncoder customPasswordEncoder() {
        // plain text encoder
        //return NoOpPasswordEncoder.getInstance();
        //crypted password encoder
        return new BCryptPasswordEncoder(10);

    }



    /*
     * Authority-> are granular Permission like READ,WRITE
     * ROLE -> combination of set of Authorities (ex : ADMIN(Read,Write))
     *
     * */
}
