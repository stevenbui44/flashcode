package com.stevenbui.flashcode;

import java.util.Arrays;
import java.util.List;

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

        if ( assortmentRepository.count() == 0 && cardRepository.count() == 0 ) {

            // Create 3 cards
            final Card card1 = new Card();
            card1.setQuestion( "Question 1" );
            card1.setApproach( "Approach 1" );
            card1.setCode( "Code 1" );
            card1.setTimeComplexity( "O(n)" );
            card1.setSpaceComplexity( "O(1)" );

            final Card card2 = new Card();
            card2.setQuestion( "Question 2" );
            card2.setApproach( "Approach 2" );
            card2.setCode( "Code 2" );
            card2.setTimeComplexity( "O(log n)" );
            card2.setSpaceComplexity( "O(n)" );

            final Card card3 = new Card();
            card3.setQuestion( "Question 3" );
            card3.setApproach( "Approach 3" );
            card3.setCode( "Code 3" );
            card3.setTimeComplexity( "O(n^2)" );
            card3.setSpaceComplexity( "O(n)" );

            final Card card4 = new Card();
            card4.setQuestion( "Question 4" );
            card4.setApproach( "Approach 4" );
            card4.setCode( "Code 4" );
            card4.setTimeComplexity( "O(n)" );
            card4.setSpaceComplexity( "O(1)" );

            final Card card5 = new Card();
            card5.setQuestion( "Question 5" );
            card5.setApproach( "Approach 5" );
            card5.setCode( "Code 5" );
            card5.setTimeComplexity( "O(n log n)" );
            card5.setSpaceComplexity( "O(n)" );

            final Card card6 = new Card();
            card6.setQuestion( "Question 6" );
            card6.setApproach( "Approach 6" );
            card6.setCode( "Code 6" );
            card6.setTimeComplexity( "O(n^3)" );
            card6.setSpaceComplexity( "O(1)" );

            // Save the cards in the repository
            // cardRepository.save( card1 );
            // cardRepository.save( card2 );
            // cardRepository.save( card3 );

            // Create a list of the cards
            final List<Card> list1 = Arrays.asList( card1, card2 );
            final List<Card> list2 = Arrays.asList( card3, card4 );
            final List<Card> list3 = Arrays.asList( card5, card6 );

            // Create 3 assortments
            final Assortment assortment1 = new Assortment();
            assortment1.setTitle( "Assortment 1" );
            assortment1.setDescription( "Description 1" );
            assortment1.setCards( list1 );

            final Assortment assortment2 = new Assortment();
            assortment2.setTitle( "Assortment 2" );
            assortment2.setDescription( "Description 2" );
            assortment2.setCards( list2 );

            final Assortment assortment3 = new Assortment();
            assortment3.setTitle( "Assortment 3" );
            assortment3.setDescription( "Description 3" );
            assortment3.setCards( list3 );

            // Save the assortments in the repository
            assortmentRepository.save( assortment1 );
            assortmentRepository.save( assortment2 );
            assortmentRepository.save( assortment3 );

        }
    }

}
