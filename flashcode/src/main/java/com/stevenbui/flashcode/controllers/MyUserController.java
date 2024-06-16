package com.stevenbui.flashcode.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.models.MyUser;
import com.stevenbui.flashcode.repositories.MyUserRepository;

@RestController
public class MyUserController extends APIController {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder  passwordEncoder;

    // TODO: add functionality for adding a user lol
    @PostMapping ( "/register/user" )
    public MyUser createUser ( @RequestBody final MyUser user ) {
        user.setPassword( passwordEncoder.encode( user.getPassword() ) );
        return myUserRepository.save( user );
    }

    // Map<String, String> represents JSON data where key="username", value=user
    // username
    @GetMapping ( BASE_PATH + "/user/info" )
    public Map<String, String> getUsername () {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final Map<String, String> response = new HashMap<>();
        response.put( "username", userDetails.getUsername() );
        return response;
    }

}
