package com.stevenbui.flashcode.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stevenbui.flashcode.models.Card;
import com.stevenbui.flashcode.repositories.CardRepository;
import com.stevenbui.flashcode.services.CardService;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl ( final CardRepository cardRepository ) {
        super();
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> getAllCards () {
        return cardRepository.findAll();
    }

}
