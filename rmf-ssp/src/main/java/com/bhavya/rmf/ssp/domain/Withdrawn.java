package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "withdrawn")
public class Withdrawn {

  @Id
  @GeneratedValue
  @Column(name = "id")
  Integer id;

  @Column(name = "control_id")
  Integer controlId;

  @Column(name = "control_enhancement_id")
  Integer controlEnhancementId;

  @Column(name = "incorporated_into")
  String incorporatedInto;


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

  public String getIncorporatedInto() {
    return incorporatedInto;
  }

  public void setIncorporatedInto(String incorporatedInto) {
    this.incorporatedInto = incorporatedInto;
  }

  public Integer getControlEnhancementId() {
    return controlEnhancementId;
  }

  public void setControlEnhancementId(Integer controlEnhancementId) {
    this.controlEnhancementId = controlEnhancementId;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("controlId", controlId)
        .append("controlEnhancementId", controlEnhancementId)
        .append("incorporatedInto", incorporatedInto)
        .toString();
  }
}
