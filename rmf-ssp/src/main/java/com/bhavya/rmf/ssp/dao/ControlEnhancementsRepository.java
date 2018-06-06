package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.ControlEnhancements;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ControlEnhancementsRepository {

  private static final Logger logger = LoggerFactory.getLogger(ControlEnhancementsRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * Queries ControlEnhancements.
   *
   * @param id control id
   * @return List&lt;ControlEnhancements&gt;
   */
  public List<ControlEnhancements> getControlEnhancementsByControlId(Integer id) {
    return entityManager.createQuery(SqlStringConstants.CONTROL_ENHANCEMENTS_BY_CONTROL_ID_QUERY)
        .setParameter("controlId", id)
        .getResultList();
  }
}
