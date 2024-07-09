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

    @Column ( name = "question", columnDefinition = "TEXT" )
    private String question;

    @Column ( name = "approach", columnDefinition = "TEXT" )
    private String approach;

    @Column ( name = "code", columnDefinition = "TEXT" )
    private String code;

    @Column ( name = "time_complexity", columnDefinition = "TEXT" )
    private String timeComplexity;

    @Column ( name = "space_complexity", columnDefinition = "TEXT" )
    private String spaceComplexity;

    // // many cards can be in one assortment
    // @ManyToOne ( fetch = FetchType.LAZY )
    // @JoinColumn ( name = "assortment_id" )
    // private Assortment assortment;

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
        // this.assortment = assortment;
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

    // public Assortment getAssortment () {
    // return assortment;
    // }
    //
    // public void setAssortment ( final Assortment assortment ) {
    // this.assortment = assortment;
    // }

}
