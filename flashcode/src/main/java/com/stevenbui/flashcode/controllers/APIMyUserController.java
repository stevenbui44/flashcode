package com.stevenbui.flashcode.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.models.MyUser;
import com.stevenbui.flashcode.repositories.MyUserRepository;
import com.stevenbui.flashcode.services.MyUserService;

@RestController
public class APIMyUserController extends APIController {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private MyUserService    myUserService;

    @GetMapping ( "/api/v1/users/current" )
    public ResponseEntity< ? > getCurrentUser () {
        final MyUser currentUser = myUserService.getCurrentUser();
        if ( currentUser != null ) {
            return ResponseEntity.ok( currentUser );
        }
        else {
            return ResponseEntity.badRequest().body( "No user is currently logged in." );
        }
    }

    @DeleteMapping ( "/api/v1/users/{userId}" )
    public ResponseEntity< ? > deleteUser ( @PathVariable final Long userId ) {
        final Optional<MyUser> optionalUser = myUserRepository.findById( userId );
        if ( optionalUser.isPresent() ) {
            final MyUser user = optionalUser.get();
            myUserRepository.delete( user );
            SecurityContextHolder.getContext().setAuthentication( null );
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.badRequest().body( "User not found." );
        }
    }

}
