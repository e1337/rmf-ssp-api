package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.SupplementalGuidance;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SupplementalGuidanceRepository {

  private static final Logger logger = LoggerFactory
      .getLogger(SupplementalGuidanceRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  public List<SupplementalGuidance> getSupplementalGuidanceByControlId(Integer id) {
    return entityManager
        .createQuery(SqlStringConstants.SUPPLEMENTAL_GUIDANCE_BY_CONTROL_ID_QUERY)
        .setParameter("controlId", id)
        .getResultList();
  }

  public List<SupplementalGuidance> getSupplementalGuidanceByControlEnhancementId(Integer id) {
    return entityManager
        .createQuery(SqlStringConstants.SUPPLEMENTAL_GUIDANCE_BY_CONTROL_ENHANCEMENT_ID_QUERY)
        .setParameter("controlEnhancementId", id)
        .getResultList();
  }
}
