package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.Statements;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StatementsRepository {

  private static final Logger logger = LoggerFactory.getLogger(StatementsRepository.class);
  @PersistenceContext
  private EntityManager entityManager;

  public List<Statements> getStatementsByControlId(Integer id) {
    List<Statements> statementsList;
    statementsList = entityManager.createQuery(SqlStringConstants.STATEMENT_BY_CONTROL_ID_QUERY)
        .setParameter("controlId", id)
        .getResultList();
    return statementsList;
  }

  public List<Statements> getStatementsByControlEnhancementId(Integer id) {
    return entityManager.createQuery(SqlStringConstants.STATEMENT_BY_CONTROL_ENHANCEMENT_ID_QUERY)
        .setParameter("controlEnhancementId", id)
        .getResultList();
  }
}
