package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientDao extends Dao<PatientEntity, Long> {
    List<PatientEntity> searchByPatientsLastName (String lastName);
    List<VisitEntity> searchForVisitsByPatientId (long patientId);

    List<PatientEntity> searchByPatientsWithXVisits (long visitCount);
    List<PatientEntity> searchByPatientsBornAfterDate (LocalDate date);
}