package com.stevenbui.flashcode.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.stevenbui.flashcode.models.Card;
import com.stevenbui.flashcode.repositories.CardRepository;

@Component
public class CardService extends Service {

    private final CardRepository cardRepository;

    public CardService ( final CardRepository cardRepository ) {
        super();
        this.cardRepository = cardRepository;
    }

    @Override
    protected JpaRepository<Card, Long> getRepository () {
        return cardRepository;
    }

}
