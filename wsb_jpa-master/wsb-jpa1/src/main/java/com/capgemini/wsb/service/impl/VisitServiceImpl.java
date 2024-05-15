package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.service.VisitService;

import java.util.Collection;
import java.util.stream.Collectors;

public class VisitServiceImpl implements VisitService {
    private final VisitDao visitDao;
    private final VisitMapper visitMapper;

    public VisitServiceImpl(VisitDao visitDao, VisitMapper visitMapper) {
        this.visitDao = visitDao;
        this.visitMapper = visitMapper;
    }

    @Override
    public Collection<VisitTO> showAllVisits() {
        return visitDao.findAll().stream().map(visitMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public VisitTO getVisitWithId(Long id) {
        return visitMapper.mapToTO(visitDao.findOne(getVisitWithId(id).getId()));
    }

    @Override
    public VisitTO addVisit(VisitTO visitTO) {
        return visitMapper.mapToTO(visitDao.save(VisitMapper.mapToEntity(visitTO)));
    }

    @Override
    public void removeVisit(Long id) {
        visitDao.delete(id);
    }
}
