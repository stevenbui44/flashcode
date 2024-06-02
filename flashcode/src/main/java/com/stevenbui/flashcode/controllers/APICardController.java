package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.services.CardService;

/**
 * Handles REST API endpoints for flash cards
 */
@SuppressWarnings ( { "unchecked", "rawtypes" } )
@RestController
public class APICardController extends APIController {

    /**
     * CardService object, intermediary between repository and controller
     */
    @Autowired
    private final CardService cardService;

    /**
     * Constructor that uses a given CardService
     *
     * @param cardService
     *            the CardService
     */
    public APICardController ( final CardService cardService ) {
        super();
        this.cardService = cardService;
    }

    // /**
    // * REST API endpoint to allow GET access for all cards
    // *
    // * @return list of all cards
    // */
    // @GetMapping ( BASE_PATH + "/cards" )
    // public List<Card> getCards () {
    // return cardService.findAll();
    // }

}
