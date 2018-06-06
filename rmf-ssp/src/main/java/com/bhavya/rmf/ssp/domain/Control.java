package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(schema = "RMF", name = "CONTROLS")
public class Control {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "family_name")
  private String familyName;

  @Column(name = "family_number")
  private String familyNumber;

  @Column(name = "family_abbrv")
  private String familyAbbrv;

  @Column(name = "title")
  private String title;

  @Column(name = "priority")
  private String priority;

  public Control(Integer id, String familyName, String familyNumber, String familyAbbrv,
      String title, String priority) {
    this.id = id;
    this.familyName = familyName;
    this.familyNumber = familyNumber;
    this.familyAbbrv = familyAbbrv;
    this.title = title;
    this.priority = priority;
  }

  public Control() {

  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getFamilyNumber() {
    return familyNumber;
  }

  public void setFamilyNumber(String familyNumber) {
    this.familyNumber = familyNumber;
  }

  public String getFamilyAbbrv() {
    return familyAbbrv;
  }

  public void setFamilyAbbrv(String familyAbbrv) {
    this.familyAbbrv = familyAbbrv;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this)
        .append("id", id)
        .append("family_name", familyName)
        .append("family_abbrv", familyAbbrv)
        .append("family_number", familyNumber)
        .append("title", title)
        .append("priority", priority)
        .toString();
  }
}