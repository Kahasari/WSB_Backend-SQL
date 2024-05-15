package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Component;

@Component
public final class VisitMapper {
    public VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setLocalDate(visitEntity.getTime().toLocalDate());
        return visitTO;
    }
    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription(visitEntity.getDescription());
        visitTO.setLocalDate(visitEntity.getTime().toLocalDate());
        return visitEntity;
    }
}
