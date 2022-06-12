package com.pega.voting.controller;

import com.pega.voting.model.VoteRequest;
import com.pega.voting.model.VoteSummaryResponse;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping(value = "/votes",produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags="Eurovision Song Contest Voting Rest Controller")
public interface VotingRestController {

  @PostMapping(value = "/{yearNum}")
  ResponseEntity<Boolean> addVote(@PathVariable Integer yearNum, @RequestBody VoteRequest request);

  @GetMapping(value = "/{yearNum}")
  ResponseEntity<VoteSummaryResponse> getVoteSummary(@PathVariable Integer yearNum);

  @GetMapping(value = "/{yearNum}/{countryName}")
  ResponseEntity<VoteSummaryResponse> getVoteSummaryByCountry(@PathVariable Integer yearNum, @PathVariable String countryName);

}


