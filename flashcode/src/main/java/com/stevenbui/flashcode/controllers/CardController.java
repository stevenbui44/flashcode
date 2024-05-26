package com.stevenbui.flashcode.controllers;

import org.springframework.stereotype.Controller;

import com.stevenbui.flashcode.services.CardService;

@Controller
public class CardController {
    private final CardService cardService;

    public CardController ( final CardService cardService ) {
        super();
        this.cardService = cardService;
    }

}
