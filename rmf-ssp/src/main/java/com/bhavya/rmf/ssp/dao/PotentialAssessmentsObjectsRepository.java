package com.bhavya.rmf.ssp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PotentialAssessmentsObjectsRepository {

  private static final Logger logger = LoggerFactory
      .getLogger(PotentialAssessmentsObjectsRepository.class);
  @PersistenceContext
  private EntityManager entityManager;

}
