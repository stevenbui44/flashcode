package com.stevenbui.flashcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.models.Assortment;
import com.stevenbui.flashcode.models.Card;
import com.stevenbui.flashcode.services.AssortmentService;

import jakarta.persistence.EntityNotFoundException;

/**
 * Handles REST API endpoints for flash card sets
 */
@SuppressWarnings ( { "unchecked", "rawtypes" } )
@RestController
public class APIAssortmentController extends APIController {

    /**
     * AssortmentService object, intermediary between repository and controller
     */
    @Autowired
    private final AssortmentService assortmentService;

    /**
     * Constructor that uses a given AssortmentService
     *
     * @param assortmentService
     *            the AssortmentService
     */
    public APIAssortmentController ( final AssortmentService assortmentService ) {
        super();
        this.assortmentService = assortmentService;
    }

    @GetMapping ( BASE_PATH + "/assortments" )
    public List<Assortment> getAssortments () {
        return assortmentService.findAll();
    }

    @GetMapping ( BASE_PATH + "/assortments/{id}" )
    public List<Card> getAssortmentCards ( @PathVariable ( "id" ) final Long assortmentId ) {
        final Assortment assortment = assortmentService.findById( assortmentId );
        if ( assortment == null ) {
            throw new EntityNotFoundException( "Assortment not found with ID: " + assortmentId );
        }
        return assortment.getCards();
    }

    @PostMapping ( BASE_PATH + "/assortments/{id}" )
    public ResponseEntity addAssortmentCard ( @PathVariable ( "id" ) final Long assortmentId,
            @RequestBody final Card card ) {
        final Assortment assortment = assortmentService.findById( assortmentId );
        if ( assortment == null ) {
            return new ResponseEntity( "Assortment not found with ID: " + assortmentId, HttpStatus.NOT_FOUND );
        }
        assortment.addCard( card );
        assortmentService.save( assortment );
        return new ResponseEntity( HttpStatus.OK );
    }

    // @DeleteMapping ( BASE_PATH + "/cards/{id}" )
    // public ResponseEntity deleteCard ( @PathVariable ( "id" ) final Long
    // cardId ) {
    // final Assortment assortment = assortmentService.findById( assortmentId );
    // if ( assortment == null ) {
    // throw new EntityNotFoundException( "Assortment not found with ID: " +
    // assortmentId );
    // }
    // assortment.removeCard( card );
    // assortmentService.save( assortment );
    // }

}
