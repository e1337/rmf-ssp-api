package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "objectives_sub_sub")
public class ObjectivesSubSub {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "objective_sub_id")
  private Integer objectiveSubId;

  @Column(name = "number")
  private String number;

  @Column(name = "decision")
  private String decision;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getObjectiveSubId() {
    return objectiveSubId;
  }

  public void setObjectiveSubId(Integer objectiveSubId) {
    this.objectiveSubId = objectiveSubId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
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
        .append("objectiveSubId", objectiveSubId)
        .append("number", number)
        .append("decision", decision)
        .toString();
  }
}
