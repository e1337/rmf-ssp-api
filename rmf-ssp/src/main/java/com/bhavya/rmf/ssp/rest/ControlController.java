package com.bhavya.rmf.ssp.rest;

import com.bhavya.rmf.ssp.domain.Control;
import com.bhavya.rmf.ssp.dto.ControlDetail;
import com.bhavya.rmf.ssp.service.ControlDetailService;
import com.bhavya.rmf.ssp.service.ControlService;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controls/")
public class ControlController {

  private static final Logger logger = LoggerFactory.getLogger(ControlController.class);

  @Autowired
  private ControlService controlService;

  @Autowired
  private ControlDetailService controlDetailService;

  /**
   * Returns a iterable with all controls listed. The POJO is an array of all controls in the
   * Control table.
   *
   * @param transId RequestHeader(value = "trans-id") String
   */
  @RequestMapping(value = "id", method = RequestMethod.GET)
  public Iterable<Control> listControls(@RequestHeader(value = "trans-id") String transId) {

    Iterable<Control> listOfControls = () -> new ArrayList<Control>().iterator();

    StopWatch stopWatch = new StopWatch();

    try {
      stopWatch.start();
      // final String operationName = "listControls";
      // String serviceName = getClass().getPackage().getImplementationTitle();
      // String serviceVersion = getClass().getPackage().getImplementationVersion();

      listOfControls = controlService.getControls();
    } catch (Throwable throwable) {
      logger.error("getMessage : {}", throwable.getMessage());
      logger.error("getStackTrace : {}", throwable.getStackTrace()[0]);
      logger.error("fillInStackTrace : {}", throwable.fillInStackTrace());
    } finally {
      stopWatch.stop();
      if (logger.isInfoEnabled()) {
        logger.info("duration = {}ms", stopWatch.getTotalTimeMillis());
      }
    }
    return listOfControls;
  }

  /**
   * Returns a Control object.
   *
   * @param strId PathVariable(name = "id") String strId - id in the Control table.
   * @return Control
   */
  @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
  public Control getControl(@PathVariable(name = "id") String strId) {
    Integer id = Integer.parseInt(strId);
    StopWatch stopWatch = new StopWatch();
    Control control = new Control();
    try {
      logger.info("{}", id);
      stopWatch.start();
      control = controlService.getControlById(id);
      if (control == null) {
        logger.warn("control not found");
      }
    } catch (Throwable throwable) {
      logger.error("getMessage : {}", throwable.getMessage());
      logger.error("getStackTrace : {}", throwable.getStackTrace()[0]);
      logger.error("fillInStackTrace : {}", throwable.fillInStackTrace());
    } finally {
      stopWatch.stop();
      if (logger.isInfoEnabled()) {
        logger.info("duration = {}ms", stopWatch.getTotalTimeMillis());
      }
    }
    return control;
  }

  /**
   * Returns specific details about a control.
   *
   * @param strId id in the control table.
   * @return Response
   */
  @RequestMapping(
      value = "id/{id}/details",
      method = RequestMethod.GET,
      headers = "Accept=application/json")
  public ResponseEntity<ControlDetail> getControlDetails(@PathVariable(name = "id") String strId) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    Integer id = Integer.parseInt(strId);
    ControlDetail controlDetail;
    try {
      logger.info("{}", id);
      controlDetail = controlDetailService.getControlDetails(id);
      if (controlDetail == null) {
        logger.warn("control not found");
      }
    } catch (Throwable throwable) {
      logger.error("getMessage : {}", throwable.getMessage());
      logger.error("getStackTrace : {}", throwable.getStackTrace()[0]);
      logger.error("fillInStackTrace : {}", throwable.fillInStackTrace());
      logger.error(throwable.toString());
      controlDetail = new ControlDetail();
    } finally {
      stopWatch.stop();
      if (logger.isInfoEnabled()) {
        logger.info("duration = {}ms", stopWatch.getTotalTimeMillis());

      }
    }
    return new ResponseEntity<>(controlDetail, HttpStatus.OK);

  }
}
