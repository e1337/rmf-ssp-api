package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "potential_assessments")
public class PotentialAssessments {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "controls_id")
  private Integer controlsId;

  @Column(name = "method")
  private String method;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getControlsId() {
    return controlsId;
  }

  public void setControlsId(Integer controlsId) {
    this.controlsId = controlsId;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("controlsId", controlsId)
        .append("method", method)
        .toString();
  }
}
