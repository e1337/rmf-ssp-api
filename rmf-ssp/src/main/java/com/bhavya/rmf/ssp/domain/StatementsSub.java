package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "statements_sub")
public class StatementsSub {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "statement_id")
  private Integer statementId;

  @Column(name = "control_id")
  private Integer controlId;

  @Column(name = "control_enhancement_id")
  private Integer controlEnhancementId;

  @Column(name = "number")
  private String number;

  @Column(name = "description")
  private String description;

  public StatementsSub(Integer id, Integer statementId, Integer controlId,
      Integer controlEnhancementId, String number, String description) {
    this.id = id;
    this.statementId = statementId;
    this.controlId = controlId;
    this.controlEnhancementId = controlEnhancementId;
    this.number = number;
    this.description = description;
  }
  public StatementsSub(){
    
  }

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("statementId", statementId)
        .append("controlId", controlId)
        .append("controlEnhancementId", controlEnhancementId)
        .append("number", number)
        .append("description", description)
        .toString();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getStatementId() {
    return statementId;
  }

  public void setStatementId(Integer statementId) {
    this.statementId = statementId;
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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
