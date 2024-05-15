package com.capgemini.wsb.mappers;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class PatientMapperTest {

    @Test
    public void testMapToTO() {

        // given //
        PatientEntity patientEntity1 = new PatientEntity();
        patientEntity1.setFirstName("Jan");
        patientEntity1.setLastName("Kowalski");
        patientEntity1.setTelephoneNumber("987654321");
        patientEntity1.setEmail("jan.kowalski@wp.com");
        patientEntity1.setPatientNumber("P2");
        patientEntity1.setDateOfBirth(LocalDate.of(1985, 5, 15));
        patientEntity1.setRegistrationTime(LocalDateTime.of(2023, 5, 15, 12, 0, 5));

        // when//
        PatientTO patientTO = new PatientMapper().mapToTO(patientEntity1);

        // then//
        assertNotNull(patientTO);
        assertEquals(patientEntity1.getId(), patientTO.getId());
        assertEquals(patientEntity1.getFirstName(), patientTO.getFirstName());
        assertEquals(patientEntity1.getLastName(), patientTO.getLastName());
        assertEquals(patientEntity1.getTelephoneNumber(), patientTO.getTelephoneNumber());
        assertEquals(patientEntity1.getEmail(), patientTO.getEmail());
        assertEquals(patientEntity1.getPatientNumber(), patientTO.getPatientNumber());
        assertEquals(patientEntity1.getDateOfBirth(), patientTO.getDateOfBirth());
        assertEquals(LocalDateTime.of(2023, 5, 15, 12, 0, 5), patientTO.getRegistrationTime());
    }

    @Test
    public void testMapToEntity() {

        // given //
        PatientTO patientTO = new PatientTO();
        patientTO.setId(1L);
        patientTO.setFirstName("Ania");
        patientTO.setLastName("Bachleda");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("curuś.olga@wp.com");
        patientTO.setPatientNumber("H66");
        patientTO.setDateOfBirth(LocalDate.of(1999, 9, 7));
        patientTO.setRegistrationTime(LocalDateTime.of(2024,5,15,22,4, 8));

        // when //
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);

        // then //
        assertNotNull(patientEntity);
        assertEquals(patientTO.getId(), patientEntity.getId());
        assertEquals(patientTO.getFirstName(), patientEntity.getFirstName());
        assertEquals(patientTO.getLastName(), patientEntity.getLastName());
        assertEquals(patientTO.getTelephoneNumber(), patientEntity.getTelephoneNumber());
        assertEquals(patientTO.getEmail(), patientEntity.getEmail());
        assertEquals(patientTO.getPatientNumber(), patientEntity.getPatientNumber());
        assertEquals(patientTO.getDateOfBirth(), patientEntity.getDateOfBirth());
        assertEquals(LocalDateTime.of(2024, 5, 15, 22, 4, 8), patientEntity.getRegistrationTime());
    }
}

/**
  Test do weryfikacji, różnica w nano-sekundach, nawet pomimo ustawienia czasu na "sztywno"
 **/