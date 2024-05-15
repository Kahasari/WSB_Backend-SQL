package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Test
    public void testSearchPatientByLastName() {

        // given //
        PatientEntity patientEntity1 = new PatientEntity();
        patientEntity1.setFirstName("Jan");
        patientEntity1.setLastName("Kowalski");
        patientEntity1.setTelephoneNumber("987654321");
        patientEntity1.setEmail("jan.kowalski@wp.com");
        patientEntity1.setPatientNumber("P2");
        patientEntity1.setDateOfBirth(LocalDate.of(1985, 5, 15));
        patientEntity1.setRegistrationTime(LocalDateTime.now());

        PatientEntity patientEntity2 = new PatientEntity();
        patientEntity2.setFirstName("Maria");
        patientEntity2.setLastName("Kowalski");
        patientEntity2.setTelephoneNumber("987654321");
        patientEntity2.setEmail("maria.kowalski@onet.com");
        patientEntity2.setPatientNumber("G67");
        patientEntity2.setDateOfBirth(LocalDate.of(1988, 8, 20));
        patientEntity2.setRegistrationTime(LocalDateTime.now());

        int patientListInitSize = patientDao.findAll().size();
        int patientListSizeStartsOnLastName = patientDao.searchByPatientsLastName("Kowalski").size();

        // when //
        patientDao.save(patientEntity1);
        patientDao.save(patientEntity2);
        List<PatientEntity> patients = patientDao.searchByPatientsLastName("Kowalski");

        // then //
        Assertions.assertEquals(patientListInitSize + 2, patientDao.findAll().size());
        Assertions.assertEquals(patientListSizeStartsOnLastName + 2, patients.size());
    }

    @Test
    public void testSearchForAllPatientsWithMoreVisitsThan() {

        // given //
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Piotr");
        patientEntity.setLastName("Nowicki");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setEmail("piotr.nowicki@o2.com");
        patientEntity.setPatientNumber("B22");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 10, 25));
        patientEntity.setRegistrationTime(LocalDateTime.now());

        patientDao.save(patientEntity);

        for (int i = 0; i < 5; i++) {
            VisitEntity visit = new VisitEntity();
            visit.setDescription("Wizyta kontrolna " + (i + 1));
            visit.setTime(LocalDate.of(2024, 4, 10).atStartOfDay());
            visit.setPatient(patientEntity);
            visitDao.save(visit);
        }

        // when //
        List<PatientEntity> patients = patientDao.searchByPatientsWithXVisits(3);

        // then //
        Assertions.assertNotNull(patients);
        Assertions.assertFalse(patients.isEmpty());
        Assertions.assertTrue(patients.stream().allMatch(patient -> patient.getVisitEntities().size() > 3));
    }

    @Test
    public void testSearchForAllPatientsOlderThan() {

        // given //
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Katarzyna");
        patientEntity.setLastName("Lis");
        patientEntity.setTelephoneNumber("123123123");
        patientEntity.setEmail("katarzyna.lis@interia.com");
        patientEntity.setPatientNumber("S77");
        patientEntity.setDateOfBirth(LocalDate.of(1970, 3, 12));
        patientEntity.setRegistrationTime(LocalDateTime.now());

        patientDao.save(patientEntity);
        int age = 50;

        // when //
        List<PatientEntity> patients = patientDao.searchByPatientsBornAfterDate(LocalDate.now());

        // then //
        Assertions.assertNotNull(patients);
        Assertions.assertFalse(patients.isEmpty());
        Assertions.assertTrue(patients.stream().allMatch(patient -> {
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDateThreshold = currentDate.minusYears(age);
            return patient.getDateOfBirth().isBefore(birthDateThreshold);
        }));
    }
}
