package com.bhavya.rmf.ssp.dto;

import com.bhavya.rmf.ssp.domain.Statements;
import java.util.List;

public class StatementStructure extends Statements {

  private List<StatementSubStructure> statementSubStructures;

  public StatementStructure(Integer id, Integer controlId, Integer controlEnhancementId,
      String description, List<StatementSubStructure> statementSubStructures) {
    super(id, controlId, controlEnhancementId, description);

    this.statementSubStructures = statementSubStructures;
  }

  public List<StatementSubStructure> getStatementSubStructures() {
    return statementSubStructures;
  }

  public void setStatementSubStructures(
      List<StatementSubStructure> statementSubStructures) {
    this.statementSubStructures = statementSubStructures;
  }
}

