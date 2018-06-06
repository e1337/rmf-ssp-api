package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.RelatedControls;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RelatedControlsRepository {

  private static final Logger logger = LoggerFactory.getLogger(RelatedControlsRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  public List<RelatedControls> getRelatedControlsBySupplementalGuidanceId(Integer id) {
    return entityManager
        .createQuery(SqlStringConstants.RELATED_CONTROLS_BY_SUPPLEMENTAL_GUIDANCE_ID_QUERY)
        .setParameter("supplementalGuidanceId", id)
        .getResultList();
  }
}
