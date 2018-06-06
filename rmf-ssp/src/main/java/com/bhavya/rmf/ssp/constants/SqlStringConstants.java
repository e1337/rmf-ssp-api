package com.bhavya.rmf.ssp.constants;

public class SqlStringConstants {

  public static final String CONTROL_QUERY = "Select  c from Control c ";
  public static final String CONTROL_BY_ID_QUERY = CONTROL_QUERY
      + "where c.id = :controlId";

  public static final String WITHDRAWN_BY_CONTROL_ID_QUERY = "Select  w from Withdrawn w "
      + "where w.controlId = :controlId";
  public static final String WITHDRAWN_BY_CONTROL_ENHANCEMENT_ID_QUERY =
      "Select w from Withdrawn w "
          + "where w.controlEnhancementId = :controlEnhancementId";

  public static final String BASELINE_IMPACTS_BY_CONTROL_ID_QUERY =
      "Select bi.baselineImpactText from BaselineImpacts bi "
          + "where bi.controlId = :controlId";
  public static final String BASELINE_IMPACTS_BY_CONTROL_ENHANCEMENT_ID_QUERY =
      "Select bi.baselineImpactText from BaselineImpacts bi "
          + "where bi.controlEnhancementId = :controlEnhancementId";

  public static final String OBJECTIVES_BY_CONTROL_ID_QUERY = "Select obj from Objectives obj "
      + "Where obj.controlId = :controlId";

  public static final String SUPPLEMENTAL_GUIDANCE_BY_CONTROL_ID_QUERY =
      "Select s from SupplementalGuidance s "
          + "where s.controlId = :controlId";
  public static final String SUPPLEMENTAL_GUIDANCE_BY_CONTROL_ENHANCEMENT_ID_QUERY =
      "Select s from SupplementalGuidance s "
          + "where s.controlEnhancementId = :controlEnhancementId";
  public static final String RELATED_CONTROLS_BY_SUPPLEMENTAL_GUIDANCE_ID_QUERY =
      "Select rc.controlName from RelatedControls rc "
          + "where rc.supplementalGuidanceId = :supplementalGuidanceId";

  public static final String CONTROL_ENHANCEMENTS_BY_CONTROL_ID_QUERY =
      "Select ce from ControlEnhancements ce "
          + "where ce.controlId = :controlId";

  public static final String STATEMENT_BY_CONTROL_ID_QUERY =
      "Select st from Statements st "
      + "where st.controlId = :controlId";
  public static final String STATEMENT_BY_CONTROL_ENHANCEMENT_ID_QUERY =
      "Select st from Statements st "
      + "where st.controlEnhancementId = :controlEnhancementId";

  public static final String STATEMENT_SUB_BY_CONTROL_ID_QUERY =
      "Select ss from StatementsSub ss "
      + "where ss.controlId = :controlId";
  public static final String STATEMENT_SUB_BY_CONTROL_ENHANCEMENT_ID_QUERY =
      "Select ss from StatementsSub ss "
      + "where ss.controlEnhancementId = :controlEnhancementId";
  public static final String STATEMENT_SUB_BY_STATEMENT_ID_QUERY =
      "Select ss from StatementsSub ss "
          + "where ss.statementId = :statementId";

  public static final String STATEMENT_SUB_SUB_BY_STATEMENT_SUB_ID_QUERY =
      "Select ss from StatementsSubSub ss "
          + "where ss.statementSubId = :statementSubId";

  public static final String REFERENCE_QUERY = "Select ref from References ref "
      + "where ref.controlId = :controlId";


}
