package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> searchByPatientsLastName(String lastName) {
        return entityManager.createQuery("select patient from PatientEntity patient " +
                        "where patient.lastName like :lastName", PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
    }

    @Override
    public List<VisitEntity> searchForVisitsByPatientId(long patientId) {
        return entityManager.createQuery("select visit from VisitEntity visit " +
                        "where visit.patient.id = :patientId", VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }

    @Override
    public List<PatientEntity> searchByPatientsWithXVisits(long visitCount) {
        return entityManager.createQuery("select patient from PatientEntity patient " +
                        "where size(patient.visits) > :visitCount", PatientEntity.class)
                .setParameter("visitCount", visitCount)
                .getResultList();
    }

    @Override
    public List<PatientEntity> searchByPatientsBornAfterDate(LocalDate date) {
        return entityManager.createQuery("select patient from PatientEntity patient " +
                        "where patient.dateOfBirth > :date", PatientEntity.class)
                .setParameter("date", date)
                .getResultList();
    }
}

// Pamiętaj tu o implementacji!! ////////////////////////////////////////////////////////////