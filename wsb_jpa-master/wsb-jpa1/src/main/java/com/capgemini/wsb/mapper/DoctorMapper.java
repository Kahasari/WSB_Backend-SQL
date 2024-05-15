package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Component;

@Component

public final class DoctorMapper {
    public DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        return doctorTO;
    }
    public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
        if (doctorTO == null) {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorEntity.getId());
        doctorEntity.setFirstName(doctorEntity.getFirstName());
        doctorEntity.setLastName(doctorEntity.getLastName());
        doctorEntity.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorEntity.setEmail(doctorEntity.getEmail());
        doctorEntity.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorEntity.setSpecialization(doctorEntity.getSpecialization());
        return doctorEntity;
    }
}
