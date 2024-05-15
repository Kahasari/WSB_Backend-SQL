package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class PatientServiceImplTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientMapper patientMapper;

    @Test
    public void testShowPatients() {

        // given //
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Marek");
        patientEntity.setLastName("Belka");
        patientEntity.setDateOfBirth(LocalDate.of(1995, 5, 3));
        patientEntity.setRegistrationTime(LocalDateTime.now());

        patientDao.save(patientEntity);

        // when //
        Collection<PatientTO> patients = patientService.showPatients();

        // then //
        Assertions.assertNotNull(patients);
        Assertions.assertFalse(patients.isEmpty());
    }

    @Test
    public void testGetPatientWithId() {

        // given //
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Konrad");
        patientEntity.setLastName("Wallenrod");
        patientEntity.setDateOfBirth(LocalDate.of(1998, 2, 8));
        patientEntity.setRegistrationTime(LocalDateTime.now());

        patientDao.save(patientEntity);
        Long patientId = patientEntity.getId();

        // when //
        PatientTO patientTO = patientService.getPatientWithId(patientId);

        // then //
        Assertions.assertNotNull(patientTO);
        Assertions.assertEquals(patientEntity.getFirstName(), patientTO.getFirstName());
        Assertions.assertEquals(patientEntity.getLastName(), patientTO.getLastName());
    }

    @Test
    public void testAddPatient() {

        // given //
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Dalai");
        patientTO.setLastName("Lama");
        patientTO.setDateOfBirth(LocalDate.of(1992, 2, 2));
        patientTO.setRegistrationTime(LocalDateTime.now());

        // when //
        PatientTO savedPatientTO = patientService.addPatient(patientTO);

        // then //
        Assertions.assertNotNull(savedPatientTO.getId());
        Assertions.assertEquals(patientTO.getFirstName(), savedPatientTO.getFirstName());
        Assertions.assertEquals(patientTO.getLastName(), savedPatientTO.getLastName());
    }

    @Test
    public void testRemovePatient() {

        // given //
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Aureliusz");
        patientEntity.setLastName("Bednarko");
        patientEntity.setDateOfBirth(LocalDate.of(1997, 7, 11));
        patientEntity.setRegistrationTime(LocalDateTime.now());

        patientDao.save(patientEntity);
        Long patientId = patientEntity.getId();

        // when //
        patientService.removePatient(patientId);

        // then //
        Assertions.assertNull(patientDao.searchForVisitsByPatientId(patientId));
    }
}
