package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.Specialization;

import java.io.Serializable;
import java.util.Collection;

public class DoctorTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String doctorNumber;
    private Specialization specialization;
    private Collection<VisitTO> listOfVisits;
    private Collection<AddressTO> listOfAddresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Collection<VisitTO> getListOfVisits() {
        return listOfVisits;
    }

    public void setListOfVisits(Collection<VisitTO> listOfVisits) {
        this.listOfVisits = listOfVisits;
    }

    public Collection<AddressTO> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<AddressTO> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
}

