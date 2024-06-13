package com.stevenbui.flashcode.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table ( name = "myusers" )
public class MyUser extends DomainObject {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column ( name = "id" )
    private Long   id;

    @Column ( name = "username" )
    private String username;

    @Column ( name = "password" )
    private String password;

    @Column ( name = "role" )
    private String role;

    public MyUser () {

    }

    public MyUser ( final String username, final String password, final String role ) {
        super();
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public Long getId () {
        return id;
    }

    public void setId ( final Long id ) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( final String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( final String password ) {
        this.password = password;
    }

    public String getRole () {
        return role;
    }

    public void setRole ( final String role ) {
        this.role = role;
    }
}
