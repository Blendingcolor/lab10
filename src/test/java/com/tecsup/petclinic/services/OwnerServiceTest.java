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

		String firstName = "Abel";
		String lastName = "Garcia";
		String address = "La Molina";
		String city = "Lima";
		String telephone = "912199999";

		Owner owner = new Owner(firstName, lastName, address, city, telephone);
		Owner petCreated = this.ownerService.create(owner);
		log.info("OWNER CREATED :" + petCreated.toString());

		assertNotNull(petCreated.getId());
		assertEquals(firstName, petCreated.getFirstName());
		assertEquals(lastName, petCreated.getLastName());
		assertEquals(address, petCreated.getAddress());
		assertEquals(city, petCreated.getCity());
		assertEquals(telephone, petCreated.getTelephone());
	}

	@Test
	public void testUpdateOwner() {

		String firstName = "Abel";
		String lastName = "Garcia";
		String address = "La Molina";
		String city = "Lima";
		String telephone = "912199999";

		String up_firstName = "Mauricio";
		String up_lastName = "Becerra";
		String up_address = "Chorrillos";
		String up_city = "Lima";
		String up_telephone = "916620659";

		Owner owner = new Owner(firstName, lastName, address, city, telephone);
		log.info(">" + owner);
		Owner ownerCreated = this.ownerService.create(owner);
		log.info(">>" + ownerCreated);

		ownerCreated.setFirstName(up_firstName);
		ownerCreated.setLastName(up_lastName);
		ownerCreated.setAddress(up_address);
		ownerCreated.setCity(up_city);
		ownerCreated.setTelephone(up_telephone);

		Owner upgradeOwner = this.ownerService.update(ownerCreated);
		log.info(">>>>" + upgradeOwner);

		assertEquals(up_firstName, upgradeOwner.getFirstName());
		assertEquals(up_lastName, upgradeOwner.getLastName());
		assertEquals(up_address, upgradeOwner.getAddress());
		assertEquals(up_city, upgradeOwner.getCity());
		assertEquals(up_telephone, upgradeOwner.getTelephone());
	}

	@Test
	public void testDeleteOwner() {

		String firstName = "Abel";
		String lastName = "Garcia";
		String address = "La Molina";
		String city = "Lima";
		String telephone = "912199999";

		Owner owner = new Owner(firstName, lastName, address, city, telephone);
		owner = this.ownerService.create(owner);
		log.info("" + owner);

		try {
			this.ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}

		try {
			this.ownerService.findById(owner.getId());
			assertTrue(false);
		} catch (OwnerNotFoundException e) {
			assertTrue(true);
		}

	}
}
