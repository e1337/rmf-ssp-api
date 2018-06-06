package com.bhavya.rmf.ssp.dto;

import com.bhavya.rmf.ssp.domain.BaselineImpacts;
import com.bhavya.rmf.ssp.domain.ControlEnhancements;
import com.bhavya.rmf.ssp.domain.Withdrawn;
import java.util.List;

public class ControlEnhancementStructure extends ControlEnhancements {

  private List<BaselineImpacts> baselineImpactsLists;
  private List<Withdrawn> withdrawnList;
  private List<SupplementalGuidanceStructure> supplementalGuidanceStructureList;
  private List<StatementStructure> statementStructureList;

  public ControlEnhancementStructure(Integer id, Integer controlId, Integer controlEnhancementId,
      String familyNumber, String title) {
    super(id, controlId, controlEnhancementId, familyNumber, title);
  }

  public List<BaselineImpacts> getBaselineImpactsLists() {
    return baselineImpactsLists;
  }

  public void setBaselineImpactsLists(
      List<BaselineImpacts> baselineImpactsLists) {
    this.baselineImpactsLists = baselineImpactsLists;
  }

  public List<Withdrawn> getWithdrawnList() {
    return withdrawnList;
  }

  public void setWithdrawnList(List<Withdrawn> withdrawnList) {
    this.withdrawnList = withdrawnList;
  }

  public List<SupplementalGuidanceStructure> getSupplementalGuidanceStructureList() {
    return supplementalGuidanceStructureList;
  }

  public void setSupplementalGuidanceStructureList(
      List<SupplementalGuidanceStructure> supplementalGuidanceStructureList) {
    this.supplementalGuidanceStructureList = supplementalGuidanceStructureList;
  }

  public List<StatementStructure> getStatementStructureList() {
    return statementStructureList;
  }

  public void setStatementStructureList(
      List<StatementStructure> statementStructureList) {
    this.statementStructureList = statementStructureList;
  }
}
