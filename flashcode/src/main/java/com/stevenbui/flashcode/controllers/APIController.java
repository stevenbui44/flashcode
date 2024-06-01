package com.stevenbui.flashcode.controllers;

import com.google.gson.Gson;

/**
 * Base class for all API controllers for manipulating DomainObjects.
 */
public abstract class APIController {

    /**
     * Serializes data to JSON for transmitting through REST API
     */
    static final private Gson GSON = new Gson();

    /**
     * Turns the given object to JSON
     *
     * @param obj
     *            the object to serialize
     * @return the resulting JSON String
     */
    static final protected String toJson ( final Object obj ) {
        return GSON.toJson( obj );
    }

    /**
     * Turns the provided object into JSON, including the object's class for
     * better serialization. Should be used if the type is known
     *
     * @param obj
     *            the object to serialize
     * @param class
     *            the object's class
     * @return the resulting JSON String
     */
    static final protected String toJson ( final Object obj, final Class<JSONResponse> cls ) {
        return GSON.toJson( obj, cls );
    }

    /**
     * Creates a JSONResponse String for sending an error or informational
     * message back to the user
     *
     * @param status
     *            status of request to send
     * @param message
     *            detailed message to send
     * @return the resulting JSON String
     */
    static final protected String responseMessage ( final String status, final String message ) {
        return toJson( new JSONResponse( status, message ), JSONResponse.class );
    }

    /**
     * Creates a JSONResponse with a failed status and the provided message
     *
     * @param message
     *            the given message to send
     * @return the resulting JSON String with failed status
     */
    static final protected String errorResponse ( final String message ) {
        return responseMessage( "failed", message );
    }

    /**
     * Creates a JSONResponse with a success status and the provided message
     *
     * @param message
     *            the given message to send
     * @return the resulting JSON String with success status
     */
    static final protected String successResponse ( final String message ) {
        return responseMessage( "success", message );
    }

    /**
     * Class for creating a success/error message to return via REST API.
     * Contains an action status and message
     */
    static protected class JSONResponse {

        /** Success or failed */
        String status;

        /** What went wrong, informational, etc */
        String message;

        /**
         * Default constructor for the JSONResponse
         *
         * @param status
         *            success or failed
         * @param message
         *            what went wrong, informational, etc
         */
        public JSONResponse ( final String status, final String message ) {
            this.status = status;
            this.message = message;
        }
    }
}
