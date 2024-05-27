package com.stevenbui.flashcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stevenbui.flashcode.repositories.CardRepository;

@SpringBootApplication
public class FlashcodeApplication implements CommandLineRunner {

    public static void main ( final String[] args ) {
        SpringApplication.run( FlashcodeApplication.class, args );
    }

    @Autowired
    private CardRepository studentRepository;

    @Override
    public void run ( final String... args ) throws Exception {
        // final Card c1 = new Card( "Q1", "A1", "C1", "TC1", "SC1", null );
        // studentRepository.save( c1 );
        //
        // final Card c2 = new Card( "Q2", "A2", "C2", "TC2", "SC2", null );
        // studentRepository.save( c2 );
        //
        // final Card c3 = new Card( "Q3", "A3", "C3", "TC3", "SC3", null );
        // studentRepository.save( c3 );
    }

}
