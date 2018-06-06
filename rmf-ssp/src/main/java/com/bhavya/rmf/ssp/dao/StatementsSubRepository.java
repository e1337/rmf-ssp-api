package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.StatementsSub;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StatementsSubRepository {

  private static final Logger logger = LoggerFactory.getLogger(StatementsSubRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  public List<StatementsSub> getStatementsSubByStatementId(Integer id) {
    return entityManager.createQuery(SqlStringConstants.STATEMENT_SUB_BY_STATEMENT_ID_QUERY)
        .setParameter("statementId", id)
        .getResultList();
  }

  public List<StatementsSub> getStatementsSubByControlId(Integer id) {
    return entityManager.createQuery(SqlStringConstants.STATEMENT_SUB_BY_CONTROL_ID_QUERY)
        .setParameter("controlId", id)
        .getResultList();
  }

  public List<StatementsSub> getStatementsSubByControlEnhancementId(Integer id) {
    return entityManager.createQuery(SqlStringConstants.STATEMENT_SUB_BY_CONTROL_ENHANCEMENT_ID_QUERY)
        .setParameter("controlEnhancementId", id)
        .getResultList();
  }
}
