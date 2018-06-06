package com.bhavya.rmf.ssp.dao;

import com.bhavya.rmf.ssp.constants.SqlStringConstants;
import com.bhavya.rmf.ssp.domain.StatementsSubSub;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StatementsSubSubRepository {

  private static final Logger logger = LoggerFactory.getLogger(StatementsSubSubRepository.class);

  @PersistenceContext
  private EntityManager entityManager;

  public List<StatementsSubSub> getStatementsSubSubByStatementSubId(Integer id) {
    return entityManager.createQuery(SqlStringConstants.STATEMENT_SUB_SUB_BY_STATEMENT_SUB_ID_QUERY)
        .setParameter("statementSubId", id)
        .getResultList();
  }


}
