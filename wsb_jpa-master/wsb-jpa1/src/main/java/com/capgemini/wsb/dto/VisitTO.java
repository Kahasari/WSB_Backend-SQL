package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

public class VisitTO implements Serializable {
    private Long id;
    private String description;
    private LocalDate localDate;
    private Collection<MedicalTreatmentTo> listOfTreatments;

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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Collection<MedicalTreatmentTo> getListOfTreatments() {
        return listOfTreatments;
    }

    public void setListOfTreatments(Collection<MedicalTreatmentTo> listOfTreatments) {
        this.listOfTreatments = listOfTreatments;
    }
}
