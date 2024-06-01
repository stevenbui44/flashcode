package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
     * Method invoked whenever a GET request is made to either /cards or
     * /cards.html
     *
     * NOTE: /cards = path of localhost browser view
     *
     * NOTE: /api/v1/cards is called in file-cards.html instead
     *
     * @param model
     *            the underlying UI model
     * @return contents of src/main/resources/templates/file-cards.html
     */
    @GetMapping ( { "/cards", "/cards.html" } )
    public String getAssortmentCards ( final Model model ) {
        return "file-cards";
    }

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
        return "file-assortments";
    }

    @GetMapping ( "/assortment/{id}/cards" )
    public String getAssortmentCards ( @PathVariable ( "id" ) final Long assortmentId, final Model model ) {
        final Assortment assortment = assortmentRepository.findById( assortmentId )
                .orElseThrow( () -> new IllegalArgumentException( "Invalid assortment ID: " + assortmentId ) );
        model.addAttribute( "assortment", assortment );
        return "file-assortment-cards";
    }

}
