package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.BaselineImpacts;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BaselineImpactsRepository {

  private static final Logger logger = LoggerFactory.getLogger(BaselineImpactsRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * Returns list of BaselineImpacts by querying using control Id.
   *
   * @param id Conrol ID
   * @return List&lt;BaselineImpacts&gt;
   */
  public List<BaselineImpacts> getBaselineImpactByControlId(Integer id) {

    return entityManager.createQuery(SqlStringConstants.BASELINE_IMPACTS_BY_CONTROL_ID_QUERY)
        .setParameter("controlId", id)
        .getResultList();

  }

  public List<BaselineImpacts> getBaselineImpactByControlEnhancementId(Integer id) {
    return entityManager
        .createQuery(SqlStringConstants.BASELINE_IMPACTS_BY_CONTROL_ENHANCEMENT_ID_QUERY)
        .setParameter("controlEnhancementId", id)
        .getResultList();
  }
}
