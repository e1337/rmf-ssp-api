package com.bhavya.rmf.ssp.dto;

import com.bhavya.rmf.ssp.domain.StatementsSub;
import com.bhavya.rmf.ssp.domain.StatementsSubSub;
import java.util.List;

public class StatementSubStructure extends StatementsSub {

  private List<StatementsSubSub> statementsSubSub;


  public StatementSubStructure(Integer id, Integer statementId, Integer controlId,
      Integer controlEnhancementId, String number, String description) {
    super(id, statementId, controlId, controlEnhancementId, number, description);
  }

  public List<StatementsSubSub> getStatementsSubSub() {
    return statementsSubSub;
  }

  public void setStatementsSubSub(
      List<StatementsSubSub> statementsSubSub) {
    this.statementsSubSub = statementsSubSub;
  }

  @Override
  public String toString() {

    return super.toString() + "StatementSubStructure{" +
        "statementsSubSub=" + statementsSubSub +
        '}';
  }
}
