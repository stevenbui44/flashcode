package com.stevenbui.flashcode.models;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table ( name = "cards" )
public class Card {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column ( name = "id" )
    private Long         id;

    @Column ( name = "question" )
    private String       question;

    @Column ( name = "approach" )
    private String       approach;

    @Column ( name = "code" )
    private String       code;

    @Column ( name = "time_complexity" )
    private String       timeComplexity;

    @Column ( name = "space_complexity" )
    private String       spaceComplexity;

    // ElementCollection = indicates that this field is a collection of elements
    // that should be stored in a separate table
    @ElementCollection
    // CollectionTable = specifies the table to store the strings is named
    // card_tags and is joined to this table (cards) using card_id as the
    // foreign key
    @CollectionTable ( name = "card_tags", joinColumns = @JoinColumn ( name = "card_id" ) )
    @Column ( name = "tags" )
    private List<String> tags;

    public Card () {

    }

    public Card ( final String question, final String approach, final String code, final String timeComplexity,
            final String spaceComplexity, final List<String> tags ) {
        super();
        this.question = question;
        this.approach = approach;
        this.code = code;
        this.timeComplexity = timeComplexity;
        this.spaceComplexity = spaceComplexity;
        this.tags = tags;
    }

    public Long getId () {
        return id;
    }

    public void setId ( final Long id ) {
        this.id = id;
    }

    public String getQuestion () {
        return question;
    }

    public void setQuestion ( final String question ) {
        this.question = question;
    }

    public String getApproach () {
        return approach;
    }

    public void setApproach ( final String approach ) {
        this.approach = approach;
    }

    public String getCode () {
        return code;
    }

    public void setCode ( final String code ) {
        this.code = code;
    }

    public String getTimeComplexity () {
        return timeComplexity;
    }

    public void setTimeComplexity ( final String timeComplexity ) {
        this.timeComplexity = timeComplexity;
    }

    public String getSpaceComplexity () {
        return spaceComplexity;
    }

    public void setSpaceComplexity ( final String spaceComplexity ) {
        this.spaceComplexity = spaceComplexity;
    }

    public List<String> getTags () {
        return tags;
    }

    public void setTags ( final List<String> tags ) {
        this.tags = tags;
    }

}
