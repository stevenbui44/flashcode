package com.stevenbui.flashcode.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table ( name = "assortments" )
public class Assortment extends DomainObject {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column ( name = "id" )
    private String id;

    @Column ( name = "title" )
    private String title;

    @Column ( name = "description" )
    private String description;

    // private List<Card> cards;

    public Assortment () {

    }

    public Assortment ( final String title, final String description ) {
        super();
        this.title = title;
        this.description = description;
        // this.cards = cards;
    }

    @Override
    public Serializable getId () {
        return id;
    }

    public void setId ( final String id ) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( final String title ) {
        this.title = title;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( final String description ) {
        this.description = description;
    }

    // public List<Card> getCards () {
    // return cards;
    // }
    //
    // public void setCards ( final List<Card> cards ) {
    // this.cards = cards;
    // }

}
