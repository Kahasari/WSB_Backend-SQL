package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;

import java.util.Collection;

public interface DoctorService {
    Collection<DoctorTO> showAllDoctors();
    DoctorTO getDoctorWithId(Long id);
    DoctorTO addDoctor(DoctorTO doctorTO);
    void removeDoctor(Long id);
}
