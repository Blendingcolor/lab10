package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testFindVetById() {

        Integer ID = 1;
        String first_name = "James";
        Vet vet = null;

        try {

            vet = vetService.findById(ID);

        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }
        log.info("" + vet);
        assertEquals(first_name, vet.getFirstName());
    }

    @Test
    public void testCreateVet() {

        String first_name = "Jose";
        String last_name = "Arguedas";

        Vet vet = new Vet(first_name, last_name);
        Vet vetCreated = this.vetService.create(vet);
        log.info("VET CREATED :" + vetCreated.toString());

        assertNotNull(vetCreated.getId());
        assertEquals(first_name, vetCreated.getFirstName());
        assertEquals(last_name, vetCreated.getLastName());
    }

    @Test
    public void testUpdateVet() {

        String first_name = "Jose";
        String last_name = "Arguedas";

        String up_first_name = "Sebastian";
        String up_last_name = "Abel";

        Vet vet = new Vet(first_name, last_name);
        log.info(">" + vet);
        Vet vetCreated = this.vetService.create(vet);
        log.info(">>" + vetCreated);

        vetCreated.setFirstName(up_first_name);
        vetCreated.setLastName(up_last_name);

        Vet upgradeVet = this.vetService.update(vetCreated);
        log.info(">>>>" + upgradeVet);

        assertEquals(up_first_name, upgradeVet.getFirstName());
        assertEquals(up_last_name, upgradeVet.getLastName());
    }

    @Test
    public void testDeleteVet() {

        String first_name = "Parasitology";
        String last_name = "Evergreen";

        Vet vet = new Vet(first_name, last_name);
        vet = this.vetService.create(vet);
        log.info("" + vet);

        try {
            this.vetService.delete(vet.getId());
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        try {
            this.vetService.findById(vet.getId());
            assertTrue(false);
        } catch (VetNotFoundException e) {
            assertTrue(true);
        }

    }
}
