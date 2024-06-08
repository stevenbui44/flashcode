package com.stevenbui.flashcode.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PostMapping ( BASE_PATH + "/assortments" )
    public Assortment createAssortment ( @RequestBody final Assortment assortment ) {
        assortment.setDescription( "" );
        assortment.setCards( new ArrayList<>() );
        assortmentService.save( assortment );
        // return new ResponseEntity( HttpStatus.OK );
        return assortment;
    }

    // @DeleteMapping ( "/api/v1/assortments/{id}" )
    // public ResponseEntity<String> deleteAssortment ( @PathVariable final Long
    // id ) {
    // try {
    // assortmentService.delete
    // return ResponseEntity.ok( "Assortment deleted successfully" );
    // }
    // catch ( final Exception e ) {
    // return ResponseEntity.status( HttpStatus.BAD_REQUEST);
    // }
    // }

    @DeleteMapping ( BASE_PATH + "/assortments/{id}" )
    public ResponseEntity deleteAssortment ( @PathVariable ( "id" ) final Long id ) {
        try {
            final Assortment assortment = assortmentService.findById( id );
            if ( assortment == null ) {
                return new ResponseEntity( HttpStatus.NOT_FOUND );
            }
            assortmentService.delete( assortment );
            return new ResponseEntity( HttpStatus.OK );
        }
        catch ( final Exception e ) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST );
        }
    }
}
