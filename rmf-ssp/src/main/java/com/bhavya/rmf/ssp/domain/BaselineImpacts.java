package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "baseline_impacts ")
public class BaselineImpacts {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "control_id")
  private Integer controlId;

  @Column(name = "control_enhancement_id")
  private Integer controlEnhancementId;

  @Column(name = "baseline_impact_text")
  private String baselineImpactText;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getControlEnhancementId() {
    return controlEnhancementId;
  }

  public void setControlEnhancementId(Integer controlEnhancementId) {
    this.controlEnhancementId = controlEnhancementId;
  }

  public Integer getControlId() {
    return controlId;
  }

  public void setControlId(Integer controlId) {
    this.controlId = controlId;
  }

  public String getBaselineImpactText() {
    return baselineImpactText;
  }

  public void setBaselineImpactText(String baselineImpactText) {
    this.baselineImpactText = baselineImpactText;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("controlEnhancementId", controlEnhancementId)
        .append("controlId", controlId)
        .append("baselineImpactText", baselineImpactText)
        .toString();
  }
}
