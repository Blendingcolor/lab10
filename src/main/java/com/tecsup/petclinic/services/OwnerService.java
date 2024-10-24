package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

public interface OwnerService {

    /**
     *
     * @param owner
     * @return
     */
    Owner create(Owner owner);

    /**
     *
     * @param owner
     * @return
     */
    Owner update(Owner owner);

    /**
     *
     * @param id
     * @throws PetNotFoundException
     */
    void delete(Integer id) throws OwnerNotFoundException;

    /**
     *
     * @param id
     * @return
     */
    Owner findById(Integer id) throws OwnerNotFoundException;

    /**
     *
     * @param firstName
     * @return
     */
    List<Owner> findByFirstName(String firstName);

    /**
     *
     * @param telephone
     * @return
     */
    List<Owner> findByTelephone(String telephone);

    /**
     *
     * @param lastName
     * @return
     */
    List<Owner> findByLastName(String lastName);

    /**
     *
     * @return
     */
    List<Owner> findAll();
}
