package com.stevenbui.flashcode.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table ( name = "cards" )
public class Card extends DomainObject {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column ( name = "id" )
    private Long   id;

    @Column ( name = "question" )
    private String question;

    @Column ( name = "approach" )
    private String approach;

    @Column ( name = "code" )
    private String code;

    @Column ( name = "time_complexity" )
    private String timeComplexity;

    @Column ( name = "space_complexity" )
    private String spaceComplexity;

    public Card () {

    }

    public Card ( final String question, final String approach, final String code, final String timeComplexity,
            final String spaceComplexity ) {
        super();
        this.question = question;
        this.approach = approach;
        this.code = code;
        this.timeComplexity = timeComplexity;
        this.spaceComplexity = spaceComplexity;
    }

    @Override
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

}
