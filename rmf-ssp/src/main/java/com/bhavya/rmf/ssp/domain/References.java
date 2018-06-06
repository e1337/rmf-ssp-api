package com.bhavya.rmf.ssp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "RMF", name = "references")
public class References {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "control_id")
  private Integer controlId;

  @Column(name = "description")
  private String description;

  @Column(name = "link")
  private String link;

  @Column(name = "language")
  private String language;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}
