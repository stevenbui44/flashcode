package com.stevenbui.flashcode;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stevenbui.flashcode.models.Assortment;
import com.stevenbui.flashcode.models.Card;
import com.stevenbui.flashcode.models.MyUser;
import com.stevenbui.flashcode.repositories.AssortmentRepository;
import com.stevenbui.flashcode.repositories.CardRepository;
import com.stevenbui.flashcode.repositories.MyUserRepository;

@SpringBootApplication
public class FlashcodeApplication implements CommandLineRunner {

    public static void main ( final String[] args ) {
        SpringApplication.run( FlashcodeApplication.class, args );
    }

    @Autowired
    private CardRepository       cardRepository;

    @Autowired
    private AssortmentRepository assortmentRepository;

    @Autowired
    private MyUserRepository     myUserRepository;

    @Override
    public void run ( final String... args ) throws Exception {

        cardRepository.deleteAll();
        assortmentRepository.deleteAll();
        myUserRepository.deleteAll();

        if ( assortmentRepository.count() == 0 && cardRepository.count() == 0 && myUserRepository.count() == 0 ) {

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
            // assortmentRepository.save( assortment1 );
            // assortmentRepository.save( assortment2 );
            // assortmentRepository.save( assortment3 );

            final List<Assortment> list4 = Arrays.asList( assortment1 );
            final List<Assortment> list5 = Arrays.asList( assortment2, assortment3 );

            final MyUser admin = new MyUser();
            admin.setUsername( "admin" );
            admin.setPassword(
                    "$2a$12$OG2VWWPrqVsjp0LL/b1ni.nfVPNIBOQ8HNUWwV.oytSYrwbNaUnFm" );
            admin.setRole( "ADMIN,USER" );
            // TODO: let admin see assortments too somehow

            final MyUser user1 = new MyUser();
            user1.setUsername( "user1" );
            user1.setPassword(
                    "$2a$12$6CxdJ9tz12oh/7F5BBXAZuYlWdc8xgoEoOcrNiROQzuSAaQChWxIK" );
            user1.setRole( "USER" );
            user1.setAssortments( list4 );

            final MyUser user2 = new MyUser();
            user2.setUsername( "user2" );
            user2.setPassword(
                    "$2a$12$rrHy48bkw32yaPP1eT26tulmYVWs9fX/MkISAu0389Wb92zNFfH3a" );
            user2.setRole( "USER" );
            user2.setAssortments( list5 );

            myUserRepository.save( admin );
            myUserRepository.save( user1 );
            myUserRepository.save( user2 );

        }
        else {
            System.out.println( "Restart :(" );
        }

    }

}
