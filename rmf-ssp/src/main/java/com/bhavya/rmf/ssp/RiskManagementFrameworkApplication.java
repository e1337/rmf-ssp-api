package com.bhavya.rmf.ssp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RiskManagementFrameworkApplication {

  private static final Logger logger = LoggerFactory
      .getLogger(RiskManagementFrameworkApplication.class);

  public static void main(String[] args) {
    logger.info("RiskManagementFrameworkApplication : Started");
    SpringApplication.run(RiskManagementFrameworkApplication.class, args);
  }
}
