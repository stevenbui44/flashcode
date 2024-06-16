package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

}
