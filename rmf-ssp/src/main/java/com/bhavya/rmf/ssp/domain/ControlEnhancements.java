package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "control_enhancements")
public class ControlEnhancements {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;
  @Column(name = "control_id")
  private Integer controlId;
  @Column(name = "control_enhancement_id")
  private Integer controlEnhancementId;
  @Column(name = "family_number")
  private String familyNumber;
  @Column(name = "title")
  private String title;

  public ControlEnhancements() {
  }

  public ControlEnhancements(Integer id, Integer controlId, Integer controlEnhancementId,
      String familyNumber, String title) {
    this.id = id;
    this.controlId = controlId;
    this.controlEnhancementId = controlEnhancementId;
    this.familyNumber = familyNumber;
    this.title = title;
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

  public String getFamilyNumber() {
    return familyNumber;
  }

  public void setFamilyNumber(String familyNumber) {
    this.familyNumber = familyNumber;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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
        .append("familyNumber", familyNumber)
        .append("title", title)
        .toString();
  }
}
