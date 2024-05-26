package com.stevenbui.flashcode.services.impl;

import org.springframework.stereotype.Service;

import com.stevenbui.flashcode.repositories.CardRepository;
import com.stevenbui.flashcode.services.CardService;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl ( final CardRepository cardRepository ) {
        super();
        this.cardRepository = cardRepository;
    }

}
