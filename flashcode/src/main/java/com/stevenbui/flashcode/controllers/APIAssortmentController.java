package com.stevenbui.flashcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stevenbui.flashcode.services.AssortmentService;

/**
 * Handles REST API endpoints for flash card sets
 */
@SuppressWarnings ( { "unchecked", "rawtypes" } )
@RestController
public class APIAssortmentController {

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

}
