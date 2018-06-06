package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "objectives")
public class Objectives {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "control_id")
  private Integer controlId;

  @Column(name = "control_enhancement_id")
  private Integer controlEnhancementId;

  @Column(name = "decision")
  private String decision;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getControlId() {
    return controlId;
  }

  public void setControlId(Integer controlId) {
    this.controlId = controlId;
  }

  public Integer getControlEnhancementId() {
    return controlEnhancementId;
  }

  public void setControlEnhancementId(Integer controlEnhancementId) {
    this.controlEnhancementId = controlEnhancementId;
  }

  public String getDecision() {
    return decision;
  }

  public void setDecision(String decision) {
    this.decision = decision;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("controlId", controlId)
        .append("controlEnhancementId", controlEnhancementId)
        .append("decision", decision)
        .toString();
  }

}
