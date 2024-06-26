package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.models.Assortment;
import com.stevenbui.flashcode.models.Card;
import com.stevenbui.flashcode.models.MyUser;
import com.stevenbui.flashcode.services.AssortmentService;
import com.stevenbui.flashcode.services.CardService;
import com.stevenbui.flashcode.services.MyUserService;

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

    @Autowired
    private final MyUserService     myUserService;

    /**
     * Constructor that uses a given CardService
     *
     * @param cardService
     *            the CardService
     */
    public APICardController ( final CardService cardService, final AssortmentService assortmentService,
            final MyUserService myUserService ) {
        super();
        this.cardService = cardService;
        this.assortmentService = assortmentService;
        this.myUserService = myUserService;
    }

    /**
     * Adds a card to the given assortment
     *
     * @param assortmentId
     *            id of the assortment to add a card to
     * @param card
     *            card to add to the assortment
     * @return NOT_FOUND is assortment not found, OK if good
     */
    @PostMapping ( BASE_PATH + "/assortments/{id}" )
    public ResponseEntity addAssortmentCard ( @PathVariable ( "id" ) final Long assortmentId,
            @RequestBody final Card card ) {

        final MyUser currentUser = myUserService.getCurrentUser();
        if ( currentUser == null ) {
            return new ResponseEntity( HttpStatus.UNAUTHORIZED );
        }

        final Assortment assortment = assortmentService.findById( assortmentId );
        if ( assortment == null ) {
            return new ResponseEntity( HttpStatus.NOT_FOUND );
        }

        if ( !currentUser.getAssortments().contains( assortment ) ) {
            return new ResponseEntity( HttpStatus.UNAUTHORIZED );
        }
        assortment.addCard( card );
        assortmentService.save( assortment );
        return new ResponseEntity( HttpStatus.OK );
    }

    /**
     * Deletes a given card from a given assortment
     *
     * @param assortmentId
     *            id of the assortment to remove a card from
     * @param cardId
     *            id of the card to remove
     * @return NOT_FOUND if assortment or card could not be found, OK if good
     */
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
        cardService.delete( card );
        return new ResponseEntity( HttpStatus.OK );
    }

    /**
     * Updates a given card from a given assortment
     *
     * @param assortmentId
     *            id of the assortment to update a card
     * @param cardId
     *            id of the card to update
     * @param card
     *            card with updated data
     * @return NOT_FOUND if assortment or card could not be found, OK if good,
     *         BAD_REQUEST otherwise
     */
    @PutMapping ( BASE_PATH + "/assortments/{assortmentId}/{cardId}" )
    public ResponseEntity updateCard ( @PathVariable ( "assortmentId" ) final Long assortmentId,
            @PathVariable ( "cardId" ) final Long cardId, @RequestBody final Card card ) {
        try {
            final Assortment assortment = assortmentService.findById( assortmentId );
            if ( assortment == null ) {
                return new ResponseEntity( HttpStatus.NOT_FOUND );
            }
            final Card existingCard = assortment.getCards().stream().filter( c -> c.getId().equals( cardId ) )
                    .findFirst().orElse( null );
            if ( existingCard == null ) {
                return new ResponseEntity( HttpStatus.NOT_FOUND );
            }
            existingCard.setQuestion( card.getQuestion() );
            existingCard.setApproach( card.getApproach() );
            existingCard.setCode( card.getCode() );
            existingCard.setTimeComplexity( card.getTimeComplexity() );
            existingCard.setSpaceComplexity( card.getSpaceComplexity() );
            assortmentService.save( assortment );

            return new ResponseEntity( HttpStatus.OK );
        }
        catch ( final Exception e ) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST );
        }

    }

}
