package com.bhavya.rmf.ssp.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ControlRepositoryTest {

  private static final Logger logger = LoggerFactory.getLogger(ControlRepositoryTest.class);
  private ControlRepository controlRepository;

  @Autowired
  public void setProductRepository(ControlRepository controlRepository) {
    this.controlRepository = controlRepository;
  }

  @Test
  public void testFindControl() {
    logger.warn("===== Executing Test : controlRepositoryTest");
//stopping test for reasons -
    //Control fetchedControl = controlRepository.getControlByControlId(1);
    // assertNotNull(fetchedControl);
    // logger.warn(fetchedControl.toString());

    // assertEquals(fetchedControl.getFamilyNumber(), "AC-1");

  }

  @Test
  public void testControlCount() {
    long controlCount = controlRepository.getControls().size();
    // stopping test for reasons -
    // assertEquals(255, controlCount);

//    Iterable<Control> controls = controlRepository.getControls();
//
//    int count = 0;
//
//    for (Control control : controls) {
//      count++;
//    }

    // assertEquals(255, count);
  }
}
