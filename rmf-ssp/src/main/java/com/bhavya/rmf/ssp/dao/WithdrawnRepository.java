package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.Withdrawn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class WithdrawnRepository {


  private static final Logger logger = LoggerFactory.getLogger(WithdrawnRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  public List<Withdrawn> getWithdrawnsByControlId(Integer controlId) {
    List<Withdrawn> withdrawnList;
    withdrawnList = entityManager.createQuery(SqlStringConstants.WITHDRAWN_BY_CONTROL_ID_QUERY)
        .setParameter("controlId", controlId).getResultList();
    return withdrawnList;
  }


  public List<Withdrawn> getWithdrawnsByControlEnhancementId(Integer id) {
    return entityManager.createQuery(SqlStringConstants.WITHDRAWN_BY_CONTROL_ENHANCEMENT_ID_QUERY)
        .setParameter("controlEnhancementId", id).getResultList();
  }
}
