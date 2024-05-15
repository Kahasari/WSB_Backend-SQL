package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.MedicalTreatmentTo;

import java.util.Collection;

public interface MedicalTreatmentService {
    Collection<MedicalTreatmentTo> showAllTreatments();
    MedicalTreatmentTo getTreatmentWithId(Long id);
    MedicalTreatmentTo addTreatment(MedicalTreatmentTo medicalTreatmentTo);
    void removeTreatment(long id);
}
