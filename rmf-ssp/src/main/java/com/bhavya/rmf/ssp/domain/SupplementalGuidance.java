package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "supplemental_guidance")
public class SupplementalGuidance {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "control_id")
  private Integer controlId;

  @Column(name = "control_enhancement_id")
  private Integer controlEnhancementId;

  @Column(name = "description")
  private String description;

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("controlId", controlId)
        .append("controlEnhancementId", controlEnhancementId)
        .append("description", description)
        .toString();
  }

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
