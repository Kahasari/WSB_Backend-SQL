package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.service.DoctorService;

import java.util.Collection;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorDao doctorDao;
    private final DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorDao doctorDao, DoctorMapper doctorMapper) {
        this.doctorDao = doctorDao;
        this.doctorMapper = doctorMapper;
    }


    @Override
    public Collection<DoctorTO> showAllDoctors() {
        return doctorDao.findAll().stream().map(doctorMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public DoctorTO getDoctorWithId(Long id) {
        return doctorMapper.mapToTO((DoctorEntity) doctorDao.getOne(id));
    }

    @Override
    public DoctorTO addDoctor(DoctorTO doctorTO) {
        return doctorMapper.mapToTO(doctorDao.save(DoctorMapper.mapToEntity(doctorTO)));
    }

    @Override
    public void removeDoctor(Long id) {
        doctorDao.delete(id);
    }
}
