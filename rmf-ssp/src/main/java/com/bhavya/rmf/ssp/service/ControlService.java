package com.bhavya.rmf.ssp.service;

import com.bhavya.rmf.ssp.dao.ControlRepository;
import com.bhavya.rmf.ssp.domain.Control;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlService {

  @Autowired
  private ControlRepository controlRepository;

  public Control getControlById(Integer id) {
    Control control;
    control = controlRepository.getControlByControlId(id);
    return control;
  }

  public List<Control> getControls() {
    List<Control> controlList;
    controlList = controlRepository.getControls();
    return controlList;
  }
}
