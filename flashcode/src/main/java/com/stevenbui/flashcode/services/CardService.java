package com.stevenbui.flashcode.services;

import java.util.List;

import com.stevenbui.flashcode.models.Card;

public interface CardService {

    // abstract method for getting all flash cards
    List<Card> getAllCards ();

}
