package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.models.Assortment;
import com.stevenbui.flashcode.models.Card;
import com.stevenbui.flashcode.services.AssortmentService;
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
    private final CardService       cardService;

    @Autowired
    private final AssortmentService assortmentService;

    /**
     * Constructor that uses a given CardService
     *
     * @param cardService
     *            the CardService
     */
    public APICardController ( final CardService cardService, final AssortmentService assortmentService ) {
        super();
        this.cardService = cardService;
        this.assortmentService = assortmentService;
    }

    @PostMapping ( BASE_PATH + "/assortments/{id}" )
    public ResponseEntity addAssortmentCard ( @PathVariable ( "id" ) final Long assortmentId,
            @RequestBody final Card card ) {
        final Assortment assortment = assortmentService.findById( assortmentId );
        if ( assortment == null ) {
            return new ResponseEntity( HttpStatus.NOT_FOUND );
        }
        assortment.addCard( card );
        assortmentService.save( assortment );
        return new ResponseEntity( HttpStatus.OK );
    }

    @DeleteMapping ( BASE_PATH + "/assortments/{assortmentId}/{cardId}" )
    public ResponseEntity deleteCard ( @PathVariable ( "assortmentId" ) final Long assortmentId,
            @PathVariable ( "cardId" ) final Long cardId ) {
        final Assortment assortment = assortmentService.findById( assortmentId );
        if ( assortment == null ) {
            return new ResponseEntity( HttpStatus.NOT_FOUND );
        }
        Card card = null;
        for ( final Card c : assortment.getCards() ) {
            if ( c.getId() == cardId ) {
                card = c;
                break;
            }
        }
        if ( card == null ) {
            return new ResponseEntity( HttpStatus.NOT_FOUND );
        }
        assortment.removeCard( card );
        assortmentService.save( assortment );
        return new ResponseEntity( HttpStatus.OK );
    }

}
