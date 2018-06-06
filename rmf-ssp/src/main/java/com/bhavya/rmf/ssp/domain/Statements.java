package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "RMF", name = "statements")
public class Statements {

  public Statements(Integer id, Integer controlId, Integer controlEnhancementId,
      String description) {
    this.id = id;
    this.controlId = controlId;
    this.controlEnhancementId = controlEnhancementId;
    this.description = description;
  }
  public Statements(){

  }

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
