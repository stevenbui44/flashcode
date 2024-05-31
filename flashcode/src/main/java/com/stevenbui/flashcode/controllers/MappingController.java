package com.stevenbui.flashcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {

    @GetMapping ( { "/getcards", "/cards.html" } )
    public String getAllCards ( final Model model ) {
        return "cards";
    }

}
