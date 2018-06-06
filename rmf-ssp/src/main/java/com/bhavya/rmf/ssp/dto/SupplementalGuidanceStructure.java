package com.bhavya.rmf.ssp.dto;

import com.bhavya.rmf.ssp.domain.RelatedControls;
import com.bhavya.rmf.ssp.domain.SupplementalGuidance;
import java.util.List;

public class SupplementalGuidanceStructure {

  private SupplementalGuidance supplementalGuidance;
  private List<RelatedControls> relatedControls;

  public SupplementalGuidance getSupplementalGuidance() {
    return supplementalGuidance;
  }

  public void setSupplementalGuidance(SupplementalGuidance supplementalGuidance) {
    this.supplementalGuidance = supplementalGuidance;
  }

  public List<RelatedControls> getRelatedControls() {
    return relatedControls;
  }

  public void setRelatedControls(List<RelatedControls> relatedControls) {
    this.relatedControls = relatedControls;
  }
}
