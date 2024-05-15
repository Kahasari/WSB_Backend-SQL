package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.io.Serializable;

public class MedicalTreatmentTo implements Serializable {
    private Long id;
    private String description;
    private TreatmentType treatmentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }
}
