package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.MedicalTreatmentTo;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import org.springframework.stereotype.Component;

@Component

public final class MedicalTreatmentMapper {
    public MedicalTreatmentTo mapToTO(final MedicalTreatmentEntity medicalTreatmentEntity) {
        if (medicalTreatmentEntity == null) {
            return null;
        }
        final MedicalTreatmentTo medicalTreatmentTo = new MedicalTreatmentTo();
        medicalTreatmentTo.setId(medicalTreatmentEntity.getId());
        medicalTreatmentTo.setDescription(medicalTreatmentEntity.getDescription());
        medicalTreatmentTo.setTreatmentType(medicalTreatmentEntity.getType());
        return medicalTreatmentTo;
    }
    public static MedicalTreatmentEntity mapToEntity(final MedicalTreatmentTo medicalTreatmentTo) {
        if (medicalTreatmentTo == null) {
            return null;
        }
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(medicalTreatmentTo.getId());
        medicalTreatmentEntity.setDescription(medicalTreatmentEntity.getDescription());
        medicalTreatmentEntity.setType(medicalTreatmentTo.getTreatmentType());
        return medicalTreatmentEntity;
    }
}
