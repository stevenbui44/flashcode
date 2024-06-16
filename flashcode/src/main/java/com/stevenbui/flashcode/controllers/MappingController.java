package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stevenbui.flashcode.models.Assortment;
import com.stevenbui.flashcode.repositories.AssortmentRepository;

@Controller
public class MappingController {

    @Autowired
    private AssortmentRepository assortmentRepository;

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

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication != null && authentication.getPrincipal() instanceof UserDetails ) {
            final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            final String username = userDetails.getUsername();
            model.addAttribute( "username", username );
        }

        return "file-assortments";
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
        final Assortment assortment = assortmentRepository.findById( assortmentId )
                .orElseThrow( () -> new IllegalArgumentException( "Invalid assortment ID: " + assortmentId ) );
        model.addAttribute( "assortment", assortment );

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication != null && authentication.getPrincipal() instanceof UserDetails ) {
            final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            final String username = userDetails.getUsername();
            model.addAttribute( "username", username );
        }

        return "file-assortment-cards";
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
        final Assortment assortment = assortmentRepository.findById( assortmentId )
                .orElseThrow( () -> new IllegalArgumentException( "Invalid assortment ID: " + assortmentId ) );
        model.addAttribute( "assortment", assortment );

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication != null && authentication.getPrincipal() instanceof UserDetails ) {
            final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            final String username = userDetails.getUsername();
            model.addAttribute( "username", username );
        }

        return "file-study";
    }

    @GetMapping ( { "/error", "error.html" } )
    public String error ( final Model model ) {
        return "error";
    }

    @GetMapping ( "/login" )
    public String login ( final Model model ) {
        return "login";
    }

}
