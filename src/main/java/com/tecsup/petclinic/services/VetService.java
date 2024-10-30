package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

import java.util.List;

public interface VetService {

    /**
     *
     * @param vet
     * @return
     */
    Vet create(Vet vet);

    /**
     *
     * @param vet
     * @return
     */
    Vet update(Vet vet);

    /**
     *
     * @param id
     * @throws VetNotFoundException
     */
    void delete(Integer id) throws VetNotFoundException;

    /**
     *
     * @param id
     * @return
     */
    Vet findById(Integer id) throws VetNotFoundException;

    /**
     *
     * @param firstName
     * @return
     */
    List<Vet> findByFirstName(String firstName);

    /**
     *
     * @param lastName
     * @return
     */
    List<Vet> findByLastName(String lastName);

    /**
     *
     * @return
     */
    List<Vet> findAll();
}
