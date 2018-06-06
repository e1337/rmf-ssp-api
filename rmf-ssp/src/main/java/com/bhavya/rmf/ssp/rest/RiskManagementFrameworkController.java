package com.bhavya.rmf.ssp.rest;

import com.bhavya.rmf.ssp.configuration.CorsFilterConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskManagementFrameworkController extends CorsFilterConfiguration {

  private static final Logger logger = LoggerFactory
      .getLogger(RiskManagementFrameworkController.class);

}

