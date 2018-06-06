package com.bhavya.rmf.ssp.service;

import com.bhavya.rmf.ssp.dao.BaselineImpactsRepository;
import com.bhavya.rmf.ssp.dao.ControlEnhancementsRepository;
import com.bhavya.rmf.ssp.dao.ControlRepository;
import com.bhavya.rmf.ssp.dao.ObjectivesRepository;
import com.bhavya.rmf.ssp.dao.ObjectivesSubRepository;
import com.bhavya.rmf.ssp.dao.ObjectivesSubSubRepository;
import com.bhavya.rmf.ssp.dao.PotentialAssessmentsObjectsRepository;
import com.bhavya.rmf.ssp.dao.PotentialAssessmentsRepository;
import com.bhavya.rmf.ssp.dao.ReferencesRepository;
import com.bhavya.rmf.ssp.dao.RelatedControlsRepository;
import com.bhavya.rmf.ssp.dao.StatementsRepository;
import com.bhavya.rmf.ssp.dao.StatementsSubRepository;
import com.bhavya.rmf.ssp.dao.StatementsSubSubRepository;
import com.bhavya.rmf.ssp.dao.SupplementalGuidanceRepository;
import com.bhavya.rmf.ssp.dao.WithdrawnRepository;
import com.bhavya.rmf.ssp.domain.Control;
import com.bhavya.rmf.ssp.domain.ControlEnhancements;
import com.bhavya.rmf.ssp.domain.Statements;
import com.bhavya.rmf.ssp.domain.StatementsSub;
import com.bhavya.rmf.ssp.domain.StatementsSubSub;
import com.bhavya.rmf.ssp.domain.SupplementalGuidance;
import com.bhavya.rmf.ssp.dto.ControlDetail;
import com.bhavya.rmf.ssp.dto.ControlEnhancementStructure;
import com.bhavya.rmf.ssp.dto.StatementStructure;
import com.bhavya.rmf.ssp.dto.StatementSubStructure;
import com.bhavya.rmf.ssp.dto.SupplementalGuidanceStructure;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ControlDetailService {

  private static final Logger logger = LoggerFactory.getLogger(ControlDetailService.class);

  @Autowired
  private BaselineImpactsRepository baselineImpactsRepository;
  @Autowired
  private ControlRepository controlRepository;
  @Autowired
  private ControlEnhancementsRepository controlEnhancementsRepository;

  @Autowired
  private ObjectivesRepository objectivesRepository;
  @Autowired
  private ObjectivesSubRepository objectivesSubRepository;
  @Autowired
  private ObjectivesSubSubRepository objectivesSubSubRepository;
  @Autowired
  private PotentialAssessmentsObjectsRepository potentialAssessmentsObjectsRepository;
  @Autowired
  private PotentialAssessmentsRepository potentialAssessmentsRepository;
  @Autowired
  private ReferencesRepository referencesRepository;
  @Autowired
  private RelatedControlsRepository relatedControlsRepository;
  @Autowired
  private StatementsRepository statementsRepository;
  @Autowired
  private StatementsSubRepository statementsSubRepository;
  @Autowired
  private StatementsSubSubRepository statementsSubSubRepository;
  @Autowired
  private SupplementalGuidanceRepository supplementalGuidanceRepository;
  @Autowired
  private WithdrawnRepository withdrawnRepository;


  /**
   * Fetch control details.
   *
   * @param id - id in the table.
   * @return ControlDetail object
   */
  public ControlDetail getControlDetails(Integer id) {

    //statements
    List<Statements> statementsList = statementsRepository.getStatementsByControlId(id);
    List<StatementStructure> statementStructureList = new ArrayList<>();
    for (Statements st : statementsList) {
      List<StatementsSub> statementsSubs = statementsSubRepository.getStatementsSubByControlId(id);

      List<StatementSubStructure> statementSubStructureList = new ArrayList<>();
      for (StatementsSub sts : statementsSubs) {
        StatementSubStructure statementSubStructure = new StatementSubStructure(
            sts.getId(),
            sts.getStatementId(),
            sts.getControlId(),
            sts.getControlEnhancementId(),
            sts.getNumber(),
            sts.getDescription()
        );
        List<StatementsSubSub> statementsSubSubList =
            statementsSubSubRepository.getStatementsSubSubByStatementSubId(sts.getId());
        statementSubStructure.setStatementsSubSub(statementsSubSubList);

        statementSubStructureList.add(statementSubStructure);
      }
      statementStructureList.add(new StatementStructure(st.getId(), st.getControlId(),
          st.getControlEnhancementId(), st.getDescription(), statementSubStructureList));
    }

    //supplemental guidance
    List<SupplementalGuidance> supplementalGuidanceList = supplementalGuidanceRepository
        .getSupplementalGuidanceByControlId(id);
    SupplementalGuidanceStructure supplementalGuidanceStructure =
        new SupplementalGuidanceStructure();
    for (SupplementalGuidance sg : supplementalGuidanceList) {
      supplementalGuidanceStructure.setSupplementalGuidance(sg);
      supplementalGuidanceStructure.setRelatedControls(
          relatedControlsRepository.getRelatedControlsBySupplementalGuidanceId(sg.getId())
      );
    }

    //control enhancement
    List<ControlEnhancementStructure> controlEnhancementStructureList = new ArrayList<>();
    List<ControlEnhancements> controlEnhancementsList =
        controlEnhancementsRepository.getControlEnhancementsByControlId(id);
    for (ControlEnhancements ce : controlEnhancementsList) {

      // create control structure
      ControlEnhancementStructure controlEnhancementStructure = new ControlEnhancementStructure(
          ce.getId(),
          ce.getControlId(),
          ce.getControlEnhancementId(),
          ce.getFamilyNumber(),
          ce.getTitle()
      );

      //baseline
      controlEnhancementStructure.setBaselineImpactsLists(
          baselineImpactsRepository.getBaselineImpactByControlEnhancementId(ce.getId()));

      //withdrawn
      controlEnhancementStructure.setWithdrawnList(
          withdrawnRepository.getWithdrawnsByControlEnhancementId(ce.getId()));

      //statements

      //statements
      List<Statements> ceStatementsList = statementsRepository.getStatementsByControlId(id);
      List<StatementStructure> ceStatementStructureList = new ArrayList<>();
      for (Statements ceSt : ceStatementsList) {
        List<StatementsSub> ceStatementsSubs = statementsSubRepository
            .getStatementsSubByControlId(id);

        List<StatementSubStructure> ceStatementSubStructureList = new ArrayList<>();
        for (StatementsSub ceStS : ceStatementsSubs) {
          StatementSubStructure ceStatementSubStructure = new StatementSubStructure(
              ceStS.getId(),
              ceStS.getStatementId(),
              ceStS.getControlId(),
              ceStS.getControlEnhancementId(),
              ceStS.getNumber(),
              ceStS.getDescription()
          );
          List<StatementsSubSub> ceStatementsSubSubList =
              statementsSubSubRepository.getStatementsSubSubByStatementSubId(ceStS.getId());
          ceStatementSubStructure.setStatementsSubSub(ceStatementsSubSubList);

          ceStatementSubStructureList.add(ceStatementSubStructure);
        }
        ceStatementStructureList.add(new StatementStructure(
            ceSt.getId(),
            ceSt.getControlId(),
            ceSt.getControlEnhancementId(),
            ceSt.getDescription(),
            ceStatementSubStructureList));
      }

      controlEnhancementStructure.setStatementStructureList(ceStatementStructureList);

      //supplemental guidance
      SupplementalGuidanceStructure ceSupplementalGuidanceStructure =
          new SupplementalGuidanceStructure();
      List<SupplementalGuidance> ceSupplementalGuidanceList = supplementalGuidanceRepository
          .getSupplementalGuidanceByControlEnhancementId(ce.getId());
      List<SupplementalGuidanceStructure> ceSupGuidanceStructList;
      ceSupGuidanceStructList = controlEnhancementStructure.getSupplementalGuidanceStructureList();
      if (ceSupGuidanceStructList == null) {
        ceSupGuidanceStructList = new ArrayList<SupplementalGuidanceStructure>();
      }
      for (SupplementalGuidance csg : ceSupplementalGuidanceList) {
        ceSupplementalGuidanceStructure.setSupplementalGuidance(csg);
        ceSupplementalGuidanceStructure.setRelatedControls(
            relatedControlsRepository.getRelatedControlsBySupplementalGuidanceId(csg.getId())
        );
        ceSupGuidanceStructList.add(ceSupplementalGuidanceStructure);
      }
      controlEnhancementStructure.setSupplementalGuidanceStructureList(ceSupGuidanceStructList);

      //add Control Structure
      controlEnhancementStructureList.add(controlEnhancementStructure);

    }


    Control control = controlRepository.getControlByControlId(id);

    ControlDetail controlDetail = new ControlDetail(
        control.getId(),
        control.getFamilyName(),
        control.getFamilyNumber(),
        control.getFamilyAbbrv(),
        control.getTitle(),
        control.getPriority()
    );

    controlDetail.setBaselineImpacts(baselineImpactsRepository
        .getBaselineImpactByControlId(id));

    controlDetail.setObjectives(objectivesRepository.getObjectivesByControlId(id));
    controlDetail.setStatementStructureList(statementStructureList);
    controlDetail.setSupplementalGuidanceStructure(supplementalGuidanceStructure);

    controlDetail.setControlEnhancementStructures(controlEnhancementStructureList);
    controlDetail.setReferences(referencesRepository.getReferences(id));
    controlDetail.setWithdrawn(withdrawnRepository.getWithdrawnsByControlId(id));

    return controlDetail;
  }
}

