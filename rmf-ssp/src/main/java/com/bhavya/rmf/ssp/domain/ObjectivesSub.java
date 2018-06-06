package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "objectives_sub")
public class ObjectivesSub {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "objective_id")
  private Integer objectiveId;

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

  public Integer getObjectiveId() {
    return objectiveId;
  }

  public void setObjectiveId(Integer objectiveId) {
    this.objectiveId = objectiveId;
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
        .append("objectiveId", objectiveId)
        .append("number", number)
        .append("decision", decision)
        .toString();
  }
}
