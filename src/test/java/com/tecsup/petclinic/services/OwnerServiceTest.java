package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
    private OwnerService ownerService;

	@Test
	public void testFindOwnerById() {

		Integer ID = 1;
		String NAME = "George";
		Owner owner = null;

		try {

			owner = ownerService.findById(ID);

		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		log.info("" + owner);

		assertEquals(NAME, owner.getFirstName());

	}

	@Test
	public void testCreateOwer() {

		String firstName = "Diego";
		String lastName = "Becerra";
		String address = "Santa Anita";
		String city = "Lima";
		String telephone = "987654321";

		Owner owner = new Owner(firstName, lastName, address, city, telephone);

		Owner petCreated = this.ownerService.create(owner);

		log.info("PET CREATED :" + petCreated.toString());

		assertNotNull(petCreated.getId());
		assertEquals(firstName, petCreated.getFirstName());
		assertEquals(lastName, petCreated.getLastName());
		assertEquals(address, petCreated.getAddress());
		assertEquals(city, petCreated.getCity());
		assertEquals(telephone, petCreated.getTelephone());

	}

	@Test
	public void testUpdateOwner() {

		String firstName = "Diego";
		String lastName = "Becerra";
		String address = "Santa Anita";
		String city = "Lima";
		String telephone = "987654321";

		String up_firstName = "Abel";
		String up_lastName = "Santisteban";
		String up_address = "El Callao";
		String up_city = "Arequipa";
		String up_telephone = "924619919";

		Owner owner = new Owner(firstName, lastName, address, city, telephone);

		// ------------ Create ---------------

		log.info(">" + owner);
		Owner ownerCreated = this.ownerService.create(owner);
		log.info(">>" + ownerCreated);

		// ------------ Update ---------------

		// Prepare data for update
		ownerCreated.setFirstName(up_firstName);
		ownerCreated.setLastName(up_lastName);
		ownerCreated.setAddress(up_address);
		ownerCreated.setCity(up_city);
		ownerCreated.setTelephone(up_telephone);

		// Execute update
		Owner upgradeOwner = this.ownerService.update(ownerCreated);
		log.info(">>>>" + upgradeOwner);

		//            EXPECTED        ACTUAL
		assertEquals(up_firstName, upgradeOwner.getFirstName());
		assertEquals(up_lastName, upgradeOwner.getLastName());
		assertEquals(up_address, upgradeOwner.getAddress());
		assertEquals(up_city, upgradeOwner.getCity());
		assertEquals(up_telephone, upgradeOwner.getTelephone());
	}

	@Test
	public void testDeleteOwner() {

		String firstName = "Diego";
		String lastName = "Becerra";
		String address = "Santa Anita";
		String city = "Lima";
		String telephone = "987654321";

		// ------------ Create ---------------

		Owner owner = new Owner(firstName, lastName, address, city, telephone);
		owner = this.ownerService.create(owner);
		log.info("" + owner);

		// ------------ Delete ---------------

		try {
			this.ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}

		// ------------ Validation ---------------

		try {
			this.ownerService.findById(owner.getId());
			assertTrue(false);
		} catch (OwnerNotFoundException e) {
			assertTrue(true);
		}

	}
}
