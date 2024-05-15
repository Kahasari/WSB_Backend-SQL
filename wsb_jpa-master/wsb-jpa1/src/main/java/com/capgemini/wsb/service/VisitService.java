package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;

import java.util.Collection;

public interface VisitService {
    Collection<VisitTO> showAllVisits();
    VisitTO getVisitWithId(Long id);
    VisitTO addVisit(VisitTO visitTO);
    void removeVisit(Long id);
}
