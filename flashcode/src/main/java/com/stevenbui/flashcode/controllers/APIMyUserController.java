package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.repositories.MyUserRepository;

@RestController
public class APIMyUserController extends APIController {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder  passwordEncoder;

    // @PostMapping ( "/register" )
    // public String createUser ( @ModelAttribute ( "user" ) final MyUser user,
    // final Model model ) {
    //
    // model.addAttribute( "username", user.getUsername() );
    // user.setPassword( passwordEncoder.encode( user.getPassword() ) );
    // user.setRole( "USER" );
    // user.setAssortments( new ArrayList<Assortment>() );
    // myUserRepository.save( user );
    // return "redirect:/login";
    // }

}
