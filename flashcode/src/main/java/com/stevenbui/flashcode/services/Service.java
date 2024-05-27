package com.stevenbui.flashcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stevenbui.flashcode.models.DomainObject;

/**
 * Provides CRUD operations against the database. Provides a way to save,
 * update, retrieve, and delete objects.
 *
 * @param <T>
 *            type of entity to be handled by Service
 * @param <K>
 *            key for the entity
 */
public abstract class Service <T extends DomainObject, K> {

    /**
     * Returns the repository used for interacting with the database. This MUST
     * be overridden by Service classes
     *
     * @return the repository instance
     */
    abstract protected JpaRepository<T, K> getRepository ();

    /**
     * Saves the object into the database, overwriting any existing record
     *
     * @param obj
     *            the object to save into the database
     */
    public void save ( final T obj ) {
        getRepository().saveAndFlush( obj );
    }

    /**
     * Returns all records in the database
     *
     * @return all records in the database
     */
    public List<T> findAll () {
        return getRepository().findAll();
    }

    /**
     * Saves all given objects into the database, overwriting any existing
     * records. If an error occurs, none of the objects will be saved
     *
     * @param objects
     *            objects to save into the database
     */
    public void saveAll ( final List<T> objects ) {
        getRepository().saveAll( objects );
        getRepository().flush();
    }

    /**
     * Deletes an object from the database
     *
     * @param obj
     *            object to delete from the database
     */
    public void delete ( final T obj ) {
        getRepository().delete( obj );
    }

    /**
     * Deletes all objects from the database.
     */
    public void deleteAll () {
        getRepository().deleteAll();
    }

    /**
     * Returns the number of records of a given type in the database
     *
     * @return the number of records of a given type in the database
     */
    public long count () {
        return getRepository().count();
    }

    /**
     * Retrieves a specific type of element from the database
     *
     * @param example
     *            example to match against
     * @return all matching records found, or an empty list if none found
     */
    protected List<T> findBy ( final Example<T> example ) {
        return getRepository().findAll( example );
    }

    /**
     * Checks if an object with the given ID exists in the database
     *
     * @param id
     *            id of the object to check existence of
     * @return true if the object was found
     */
    public boolean existsById ( final K id ) {
        return getRepository().existsById( id );
    }

    /**
     * Finds an object with the given ID
     *
     * @param id
     *            id of the object to retrieve
     * @return the object, or null if none found
     */
    public T findById ( final K id ) {
        if ( null == id ) {
            return null;
        }
        final Optional<T> res = getRepository().findById( id );
        if ( res.isPresent() ) {
            return res.get();
        }
        return null;
    }
}
