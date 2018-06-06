package com.bhavya.rmf.ssp.dto;

import com.bhavya.rmf.ssp.domain.BaselineImpacts;
import com.bhavya.rmf.ssp.domain.Control;
import com.bhavya.rmf.ssp.domain.Objectives;
import com.bhavya.rmf.ssp.domain.ObjectivesSub;
import com.bhavya.rmf.ssp.domain.ObjectivesSubSub;
import com.bhavya.rmf.ssp.domain.PotentialAssessments;
import com.bhavya.rmf.ssp.domain.PotentialAssessmentsObjects;
import com.bhavya.rmf.ssp.domain.References;
import com.bhavya.rmf.ssp.domain.Withdrawn;
import java.util.List;

public class ControlDetail extends Control {

  private List<Withdrawn> withdrawn;
  private List<BaselineImpacts> baselineImpacts;
  private List<ControlEnhancementStructure> controlEnhancementStructures;
  private List<Objectives> objectives;
  private List<ObjectivesSub> objectivesSub;
  private List<ObjectivesSubSub> objectivesSubSub;
  private List<PotentialAssessments> potentialAssessments;
  private List<PotentialAssessmentsObjects> potentialAssessmentsObjects;
  private List<References> references;
  private List<StatementStructure> statementStructureList;
  private SupplementalGuidanceStructure supplementalGuidanceStructure;

  public ControlDetail(Integer id, String familyName, String familyNumber,
      String familyAbbrv, String title, String priority) {
    super(id, familyName, familyNumber, familyAbbrv, title, priority);
  }

  public ControlDetail() {

  }

  public List<Withdrawn> getWithdrawn() {
    return withdrawn;
  }

  public void setWithdrawn(List<Withdrawn> withdrawn) {
    this.withdrawn = withdrawn;
  }

  public List<BaselineImpacts> getBaselineImpacts() {
    return baselineImpacts;
  }

  public void setBaselineImpacts(List<BaselineImpacts> baselineImpacts) {
    this.baselineImpacts = baselineImpacts;
  }


  public List<Objectives> getObjectives() {
    return objectives;
  }

  public void setObjectives(List<Objectives> objectives) {
    this.objectives = objectives;
  }

  public List<ObjectivesSub> getObjectivesSub() {
    return objectivesSub;
  }

  public void setObjectivesSub(List<ObjectivesSub> objectivesSub) {
    this.objectivesSub = objectivesSub;
  }

  public List<ObjectivesSubSub> getObjectivesSubSub() {
    return objectivesSubSub;
  }

  public void setObjectivesSubSub(
      List<ObjectivesSubSub> objectivesSubSub) {
    this.objectivesSubSub = objectivesSubSub;
  }

  public List<PotentialAssessments> getPotentialAssessments() {
    return potentialAssessments;
  }

  public void setPotentialAssessments(
      List<PotentialAssessments> potentialAssessments) {
    this.potentialAssessments = potentialAssessments;
  }

  public List<PotentialAssessmentsObjects> getPotentialAssessmentsObjects() {
    return potentialAssessmentsObjects;
  }

  public void setPotentialAssessmentsObjects(
      List<PotentialAssessmentsObjects> potentialAssessmentsObjects) {
    this.potentialAssessmentsObjects = potentialAssessmentsObjects;
  }

  public List<References> getReferences() {
    return references;
  }

  public void setReferences(List<References> references) {
    this.references = references;
  }


  public List<StatementStructure> getStatementStructureList() {
    return statementStructureList;
  }

  public void setStatementStructureList(List<StatementStructure> statementStructureList) {
    this.statementStructureList = statementStructureList;
  }

  public SupplementalGuidanceStructure getSupplementalGuidanceStructure() {
    return supplementalGuidanceStructure;
  }

  public void setSupplementalGuidanceStructure(
      SupplementalGuidanceStructure supplementalGuidanceStructure) {
    this.supplementalGuidanceStructure = supplementalGuidanceStructure;
  }

  public List<ControlEnhancementStructure> getControlEnhancementStructures() {
    return controlEnhancementStructures;
  }

  public void setControlEnhancementStructures(
      List<ControlEnhancementStructure> controlEnhancementStructures) {
    this.controlEnhancementStructures = controlEnhancementStructures;
  }
}
