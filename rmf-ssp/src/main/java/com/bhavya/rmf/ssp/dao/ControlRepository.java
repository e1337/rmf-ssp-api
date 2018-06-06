package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.Control;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ControlRepository {

  private static final Logger logger = LoggerFactory.getLogger(ControlRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  public Control getControlByControlId(Integer controlId) {

    Control control;
    List<Control> controlList = entityManager.createQuery(SqlStringConstants.CONTROL_BY_ID_QUERY)
        .setParameter("controlId", controlId)
        .getResultList();

    control = controlList.get(0);
    return control;

  }

  public List<Control> getControls() {
    List<Control> controlList;
    controlList = entityManager.createQuery(SqlStringConstants.CONTROL_QUERY)
        .getResultList();
    return controlList;
  }


}
