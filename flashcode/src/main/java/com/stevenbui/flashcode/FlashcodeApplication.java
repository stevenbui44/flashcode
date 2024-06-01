package com.stevenbui.flashcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stevenbui.flashcode.models.Assortment;
import com.stevenbui.flashcode.models.Card;
import com.stevenbui.flashcode.repositories.AssortmentRepository;
import com.stevenbui.flashcode.repositories.CardRepository;

@SpringBootApplication
public class FlashcodeApplication implements CommandLineRunner {

    public static void main ( final String[] args ) {
        SpringApplication.run( FlashcodeApplication.class, args );
    }

    @Autowired
    private CardRepository       cardRepository;

    @Autowired
    private AssortmentRepository assortmentRepository;

    @Override
    public void run ( final String... args ) throws Exception {

        if ( assortmentRepository.count() == 0 ) {
            final Assortment a1 = new Assortment( "title1", "description1" );
            assortmentRepository.save( a1 );

            final Assortment a2 = new Assortment( "title2", "description2" );
            assortmentRepository.save( a2 );

            final Assortment a3 = new Assortment( "title3", "description3" );
            assortmentRepository.save( a3 );
        }

        if ( cardRepository.count() == 0 ) {
            final Card c1 = new Card( "Q1", "A1", "C1", "TC1", "SC1" );
            cardRepository.save( c1 );

            final Card c2 = new Card( "Q2", "A2", "C2", "TC2", "SC2" );
            cardRepository.save( c2 );

            final Card c3 = new Card( "Q3", "A3", "C3", "TC3", "SC3" );
            cardRepository.save( c3 );
        }
    }

}
