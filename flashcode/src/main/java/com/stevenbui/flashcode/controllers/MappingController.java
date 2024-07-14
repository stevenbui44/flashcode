package com.stevenbui.flashcode.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stevenbui.flashcode.models.Assortment;
import com.stevenbui.flashcode.models.MyUser;
import com.stevenbui.flashcode.repositories.AssortmentRepository;
import com.stevenbui.flashcode.repositories.MyUserRepository;
import com.stevenbui.flashcode.services.MyUserService;

@Controller
public class MappingController {

    @Autowired
    private AssortmentRepository assortmentRepository;

    @Autowired
    private MyUserService        myUserService;

    @Autowired
    private UserDetailsService   userDetailsService;

    @Autowired
    private MyUserRepository     myUserRepository;

    @Autowired
    private PasswordEncoder      passwordEncoder;

    /**
     * Method invoked whenever a GET request is made to either /assortments or
     * /assortments.html
     *
     * NOTE: /assortments = path of localhost browser view
     *
     * NOTE: /api/v1/assortments is called in file-assortments.html instead
     *
     * @param model
     *            the underlying UI model
     * @return contents of src/main/resources/templates/file-assortments.html
     */
    @GetMapping ( { "/assortments", "assortments.html", "/" } )
    public String getAllAssortments ( final Model model ) {

        final MyUser currentUser = myUserService.getCurrentUser();
        if ( currentUser != null ) {
            final List<Assortment> userAssortments = currentUser.getAssortments();

            model.addAttribute( "username", currentUser.getUsername() );
            model.addAttribute( "assortments", userAssortments );

            return "file-assortments";
        }
        return "error";
    }

    /**
     * Method invoked whenever a GET request is made to /assortments/{id}
     *
     * NOTE: /assortments/{id} = path of localhost browser view
     *
     * NOTE: /api/v1/assortments/{id} does not exist
     *
     * @param assortmentId
     *            id of the assortment
     * @param model
     *            the underlying UI model
     * @return contents of file-assortment-cards.html
     */
    @GetMapping ( "/assortments/{id}" )
    public String getAssortmentCards ( @PathVariable ( "id" ) final Long assortmentId, final Model model ) {

        final MyUser currentUser = myUserService.getCurrentUser();
        if ( currentUser == null ) {
            return "redirect:/login";
        }
        final Assortment assortment = assortmentRepository.findById( assortmentId )
                .orElseThrow( () -> new IllegalArgumentException( "Invalid assortment ID: " + assortmentId ) );

        if ( currentUser.getAssortments().contains( assortment ) ) {
            model.addAttribute( "assortment", assortment );
            model.addAttribute( "username", currentUser.getUsername() );
            return "file-assortment-cards";
        }

        return "error";
    }

    /**
     * Method invoked whenever a GET request is made to /assortments/{id}/study
     *
     * NOTE: /assortments/{id}/study path of localhost browser view
     *
     * NOTE: /api/v1/assortments/{id} does not exist
     *
     * @param assortmentId
     *            id of the assortment
     * @param model
     *            the underlying UI model
     * @return contents of file-study.html
     */
    @GetMapping ( "/assortments/{id}/study" )
    public String getAssortmentStudy ( @PathVariable ( "id" ) final Long assortmentId, final Model model ) {

        final MyUser currentUser = myUserService.getCurrentUser();
        if ( currentUser == null ) {
            return "redirect:/login";
        }

        final Assortment assortment = assortmentRepository.findById( assortmentId )
                .orElseThrow( () -> new IllegalArgumentException( "Invalid assortment ID: " + assortmentId ) );

        if ( currentUser.getAssortments().contains( assortment ) ) {
            model.addAttribute( "assortment", assortment );
            model.addAttribute( "username", currentUser.getUsername() );
            return "file-study";
        }

        return "error";
    }

    @GetMapping ( { "/error", "error.html" } )
    public String error ( final Model model ) {
        return "error";
    }

    @GetMapping ( "/login" )
    public String login ( @RequestParam ( value = "success", required = false ) final String success,
            final Model model ) {
        if ( success != null ) {
            model.addAttribute( "message", "Account successfully created. Please log in." );
        }
        return "login";
    }

    @GetMapping ( "/register" )
    public String showRegistrationForm ( final Model model ) {
        model.addAttribute( "user", new MyUser() );
        return "registration";
    }

    @PostMapping ( "/register" )
    public String createUser ( @ModelAttribute ( "user" ) final MyUser user, final Model model ) {

        model.addAttribute( "username", user.getUsername() );
        user.setPassword( passwordEncoder.encode( user.getPassword() ) );
        user.setRole( "USER" );
        user.setAssortments( new ArrayList<Assortment>() );
        myUserRepository.save( user );

        final UserDetails userDetails = userDetailsService.loadUserByUsername( user.getUsername() );
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities() );
        SecurityContextHolder.getContext().setAuthentication(
                authenticationToken );

        return "redirect:/login?success";

    }

}
