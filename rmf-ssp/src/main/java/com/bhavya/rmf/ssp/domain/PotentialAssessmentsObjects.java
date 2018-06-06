package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "potential_assessments_objects")
public class PotentialAssessmentsObjects {

  @Id
  @GeneratedValue
  @Column(name = "id")
  Integer id;

  @Column(name = "potential_assessment_id")
  Integer potentialAssessmentId;

  @Column(name = "object")
  String object;

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("potentialAssessmentId", potentialAssessmentId)
        .append("object", object)
        .toString();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPotentialAssessmentId() {
    return potentialAssessmentId;
  }

  public void setPotentialAssessmentId(Integer potentialAssessmentId) {
    this.potentialAssessmentId = potentialAssessmentId;
  }

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }
}
