package com.stevenbui.flashcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {

    // NOTE: changed from getcards to cards
    // Method invoked whenever a GET request is made to either /cards or
    // /cards.html
    @GetMapping ( { "cards", "/cards.html" } )
    public String getAllCards ( final Model model ) {
        return "file-cards";
    }

}
