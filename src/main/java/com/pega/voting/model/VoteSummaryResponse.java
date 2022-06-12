package com.pega.voting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VoteSummaryResponse {

  @JsonProperty("first")
  private String first;

  @JsonProperty("second")
  private String second;

  @JsonProperty("third")
  private String third;

}
