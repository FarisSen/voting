package com.pega.voting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VoteRequest {

  @JsonProperty("countryFrom")
  private String countryFrom;

  @JsonProperty("votedFor")
  private String votedFor;

}
