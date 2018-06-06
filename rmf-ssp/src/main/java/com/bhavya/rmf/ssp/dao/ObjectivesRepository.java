package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.Objectives;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ObjectivesRepository {

  private static final Logger logger = LoggerFactory.getLogger(ObjectivesRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  public List<Objectives> getObjectivesByControlId(Integer id) {
    return entityManager.createQuery(SqlStringConstants.OBJECTIVES_BY_CONTROL_ID_QUERY)
        .setParameter("controlId", id)
        .getResultList();
  }

}
