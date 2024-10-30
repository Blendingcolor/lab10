package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exception.SpecialtyNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

import java.util.List;

public interface SpecialtyService {

    /**
     *
     * @param specialty
     * @return
     */
    Specialty create(Specialty specialty);

    /**
     *
     * @param specialty
     * @return
     */
    Specialty update(Specialty specialty);

    /**
     *
     * @param id
     * @throws SpecialtyNotFoundException
     */
    void delete(Integer id) throws SpecialtyNotFoundException;

    /**
     *
     * @param id
     * @return
     */
    Specialty findById(Integer id) throws SpecialtyNotFoundException;

    /**
     *
     * @param
     * @return
     */
    List<Specialty> findByName(String name);

    /**
     *
     * @param office
     * @return
     */
    List<Specialty> findByOffice(String office);

    /**
     *
     * @return
     */
    List<Specialty> findAll();
}
