package com.stevenbui.flashcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stevenbui.flashcode.services.CardService;

@Controller
public class CardController {
    private final CardService cardService;

    public CardController ( final CardService cardService ) {
        super();
        this.cardService = cardService;
    }

    /**
     * GET all of the cards ever made.
     *
     * URI: localhost:8080/cards
     *
     * @param model
     * @return the file file-cards.html
     */
    @GetMapping ( "/cards" )
    public String listCards ( final Model model ) {
        model.addAttribute( "cards", cardService.getAllCards() );
        return "file_cards";
    }

}
