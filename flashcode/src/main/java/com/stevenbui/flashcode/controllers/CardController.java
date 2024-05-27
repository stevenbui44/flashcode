package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.services.CardService;

/**
 * Handles REST API endpoints for flash cards
 */
@RestController
public class CardController {

    @Autowired
    private final CardService cardService;

    public CardController ( final CardService cardService ) {
        super();
        this.cardService = cardService;
    }

    // /**
    // * GET all of the cards ever made.
    // *
    // * URI: localhost:8080/cards
    // *
    // * @param model
    // * @return the file file-cards.html
    // */
    // @GetMapping ( "/cards" )
    // public String listCards ( final Model model ) {
    // model.addAttribute( "cards", cardService.getAllCards() );
    // return "file_cards";
    // }

}
