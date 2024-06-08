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
import org.springframework.web.bind.annotation.PutMapping;
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

    /**
     * Gets a list of all assortments
     *
     * @return all assortments
     */
    @GetMapping ( BASE_PATH + "/assortments" )
    public List<Assortment> getAssortments () {
        return assortmentService.findAll();
    }

    /**
     * Gets a specific assortment
     *
     * @param assortmentId
     *            id of the assortment to get
     * @return a specific assortment with the given ID
     */
    @GetMapping ( BASE_PATH + "/assortments/{id}" )
    public List<Card> getAssortmentCards ( @PathVariable ( "id" ) final Long assortmentId ) {
        final Assortment assortment = assortmentService.findById( assortmentId );
        if ( assortment == null ) {
            throw new EntityNotFoundException( "Assortment not found with ID: " + assortmentId );
        }
        return assortment.getCards();
    }

    /**
     * Creates a new assortment
     *
     * @param assortment
     *            assortment with data to add to assortments
     * @return the newly created assortment
     */
    @PostMapping ( BASE_PATH + "/assortments" )
    public Assortment createAssortment ( @RequestBody final Assortment assortment ) {
        assortment.setDescription( "" );
        assortment.setCards( new ArrayList<>() );
        assortmentService.save( assortment );
        return assortment;
    }

    /**
     * Deletes an assortment with the given id
     *
     * @param id
     *            id of the assortment to delete
     * @return NOT_FOUND if the assortment could not be found, OK if good,
     *         BAD_REQUEST otherwise
     */
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

    /**
     * Updates an assortment with a given assortment id
     *
     * @param id
     *            id of the assortment to replace
     * @param updatedAssortment
     *            assortment with data to replace the existing assortment
     * @return NOT_FOUND if the assortment could not be found, OK if good,
     *         BAD_REQUEST otherwise
     */
    @PutMapping ( BASE_PATH + "/assortments/{id}" )
    public ResponseEntity updateAssortment ( @PathVariable ( "id" ) final Long id,
            @RequestBody final Assortment updatedAssortment ) {

        try {
            final Assortment assortment = assortmentService.findById( id );
            if ( assortment == null ) {
                return new ResponseEntity( HttpStatus.NOT_FOUND );
            }
            assortment.setTitle( updatedAssortment.getTitle() );
            assortment.setDescription( updatedAssortment.getDescription() );
            assortmentService.save( assortment );
            return new ResponseEntity( HttpStatus.OK );
        }
        catch ( final Exception e ) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST );
        }
    }
}
