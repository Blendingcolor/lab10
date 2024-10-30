package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exception.SpecialtyNotFoundException;

@SpringBootTest
@Slf4j
public class SpecialtyServiceTest {

	@Autowired
   	private SpecialtyService specialtyService;

	@Test
	public void testFindSpecialtyById() {

		Integer ID = 1;
		String name = "radiology";
		Specialty specialty = null;
		
		try {
			
			specialty = specialtyService.findById(ID);
			
		} catch (SpecialtyNotFoundException e) {
			fail(e.getMessage());
		}
		log.info("" + specialty);

		assertEquals(name, specialty.getName());

	}

	@Test
	public void testCreateSpecialty() {

		String name = "Parasitology";
		String office = "Evergreen";
		Integer h_open = 9;
		Integer h_close = 20;

		Specialty specialty = new Specialty(name, office, h_open, h_close);
		Specialty specialtyCreated = this.specialtyService.create(specialty);
		log.info("SPECIALTY CREATED :" + specialtyCreated.toString());

		assertNotNull(specialtyCreated.getId());
		assertEquals(name, specialtyCreated.getName());
		assertEquals(office, specialtyCreated.getOffice());
		assertEquals(h_open, specialtyCreated.gethOpen());
		assertEquals(h_close, specialtyCreated.gethClose());
	}

	@Test
	public void testUpdateSpecialty() {

		String name = "Parasitology";
		String office = "Evergreen";
		Integer h_open = 9;
		Integer h_close = 20;

		String up_name = "Parasitology";
		String up_office = "Redwood";
		Integer up_h_open = 8;
		Integer up_h_close = 18;

		Specialty specialty = new Specialty(name, office, h_open, h_close);
		log.info(">" + specialty);
		Specialty specialtyCreated = this.specialtyService.create(specialty);
		log.info(">>" + specialtyCreated);

		specialtyCreated.setName(up_name);
		specialtyCreated.setOffice(up_office);
		specialtyCreated.sethOpen(up_h_open);
		specialtyCreated.sethClose(up_h_close);

		Specialty upgradeSpecialty = this.specialtyService.update(specialtyCreated);
		log.info(">>>>" + upgradeSpecialty);

		assertEquals(up_name, upgradeSpecialty.getName());
		assertEquals(up_office, upgradeSpecialty.getOffice());
		assertEquals(up_h_open, upgradeSpecialty.gethOpen());
		assertEquals(up_h_close, upgradeSpecialty.gethClose());
	}

	@Test
	public void testDeleteSpecialty() {

		String name = "Parasitology";
		String office = "Evergreen";
		Integer h_open = 9;
		Integer h_close = 20;

		Specialty specialty = new Specialty(name, office, h_open, h_close);
		specialty = this.specialtyService.create(specialty);
		log.info("" + specialty);

		try {
			this.specialtyService.delete(specialty.getId());
		} catch (SpecialtyNotFoundException e) {
			fail(e.getMessage());
		}

		try {
			this.specialtyService.findById(specialty.getId());
			assertTrue(false);
		} catch (SpecialtyNotFoundException e) {
			assertTrue(true);
		}
	}
}
