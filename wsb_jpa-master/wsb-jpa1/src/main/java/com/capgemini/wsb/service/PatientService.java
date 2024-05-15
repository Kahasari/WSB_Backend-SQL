package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

import java.util.Collection;

public interface PatientService {
    Collection<PatientTO> showPatients();
    PatientTO getPatientWithId(Long id);
    PatientTO addPatient(PatientTO patientTO);
    void removePatient(Long id);
}
