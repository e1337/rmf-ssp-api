package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "related_controls")
public class RelatedControls {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "supplemental_guidance_id")
  private Integer supplementalGuidanceId;

  @Column(name = "control_name")
  private String controlName;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSupplementalGuidanceId() {
    return supplementalGuidanceId;
  }

  public void setSupplementalGuidanceId(Integer supplementalGuidanceId) {
    this.supplementalGuidanceId = supplementalGuidanceId;
  }

  public String getControlName() {
    return controlName;
  }

  public void setControlName(String controlName) {
    this.controlName = controlName;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("supplementalGuidanceId", supplementalGuidanceId)
        .append("controlName", controlName)
        .toString();
  }
}
