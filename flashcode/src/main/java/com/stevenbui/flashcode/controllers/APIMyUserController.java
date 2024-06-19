package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.repositories.MyUserRepository;

@RestController
public class APIMyUserController extends APIController {

    @Autowired
    private MyUserRepository myUserRepository;

}
