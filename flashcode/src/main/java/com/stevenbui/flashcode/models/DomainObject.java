package com.stevenbui.flashcode.models;

import java.io.Serializable;

/**
 * The root class for all persistent models. Creates a serializable getId()
 * method for service classes to use
 */
public abstract class DomainObject {

    /**
     * Returns the ID of the object for persistent database storage
     *
     * @return the ID of the object
     */
    public abstract Serializable getId ();
}
