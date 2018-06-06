package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "statements_sub_sub")
public class StatementsSubSub {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "statement_sub_id")
  private Integer statementSubId;

  @Column(name = "number")
  private String number;

  @Column(name = "description")
  private String description;


  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("statementSubId", statementSubId)
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

  public Integer getStatementSubId() {
    return statementSubId;
  }

  public void setStatementSubId(Integer statementSubId) {
    this.statementSubId = statementSubId;
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
