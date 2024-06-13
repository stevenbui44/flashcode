package com.stevenbui.flashcode.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.stevenbui.flashcode.models.MyUser;
import com.stevenbui.flashcode.repositories.MyUserRepository;

@Component
public class MyUserService extends Service<MyUser, Long> implements UserDetailsService {

    @Autowired
    private final MyUserRepository userRepository;

    public MyUserService ( final MyUserRepository userRepository ) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    protected JpaRepository<MyUser, Long> getRepository () {
        return userRepository;
    }

    // @Override
    // public UserDetails loadUserByUsername ( final String username ) throws
    // UsernameNotFoundException {
    // final MyUser user = userRepository.findByUsername( username );
    // if ( user == null ) {
    //
    // System.out.println( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" );
    //
    // return User.builder()
    // .username( user.getUsername() )
    // .password( user.getPassword() )
    // .roles( getRoles( user ) )
    // .build();
    // }
    // else {
    //
    // System.out.println( "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" );
    //
    // throw new UsernameNotFoundException( username );
    // }
    // }

    @Override
    public UserDetails loadUserByUsername ( final String username ) throws UsernameNotFoundException {
        final Optional<MyUser> user = userRepository.findByUsername( username );
        if ( user.isPresent() ) {
            final var userObj = user.get();
            return User.builder()
                    .username( userObj.getUsername() )
                    .password( userObj.getPassword() )
                    .roles( getRoles( userObj ) )
                    .build();
        }
        else {
            throw new UsernameNotFoundException( username );
        }
    }

    private String[] getRoles ( final MyUser user ) {
        if ( user.getRole() == null ) {
            return new String[] { "USER" };
        }
        return user.getRole().split( "," );
    }

}
