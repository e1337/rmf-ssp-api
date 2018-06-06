package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.References;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ReferencesRepository {

  private static final Logger logger = LoggerFactory.getLogger(WithdrawnRepository.class);

  @PersistenceContext
  private EntityManager entityManager;


  public List<References> getReferences(Integer controlId) {
    List<References> referencesList;
    referencesList = entityManager.createQuery(SqlStringConstants.REFERENCE_QUERY)
        .setParameter("controlId", controlId)
        .getResultList();
    return referencesList;
  }

}
