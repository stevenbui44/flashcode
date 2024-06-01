package com.stevenbui.flashcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {

    /**
     * Method invoked whenever a GET request is made to either /cards or
     * /cards.html
     *
     * NOTE: /cards = path of localhost browser view
     *
     * NOTE: /api/v1/cards is called in file-cards.html instead
     *
     * @param model
     *            the underlying UI model
     * @return contents of src/main/resources/templates/file-cards.html
     */
    @GetMapping ( { "/cards", "/cards.html" } )
    public String getAllCards ( final Model model ) {
        return "file-cards";
    }

    /**
     * Method invoked whenever a GET request is made to either /assortments or
     * /assortments.html
     *
     * NOTE: /assortments = path of localhost browser view
     *
     * NOTE: /api/v1/assortments is called in file-assortments.html instead
     *
     * @param model
     *            the underlying UI model
     * @return contents of src/main/resources/templates/file-assortments.html
     */
    @GetMapping ( { "/assortments", "assortments.html" } )
    public String getAllAssortments ( final Model model ) {
        return "file-assortments";
    }

}
