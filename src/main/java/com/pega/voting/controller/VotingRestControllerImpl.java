package com.pega.voting.controller;

import com.pega.voting.model.Vote;
import com.pega.voting.model.VoteRequest;
import com.pega.voting.model.VoteSummaryResponse;
import com.pega.voting.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotingRestControllerImpl implements VotingRestController{

  @Autowired
  private VotingService votingService;

  public VotingRestControllerImpl(VotingService votingService) {
    this.votingService = votingService;
  }

  @Override
  public ResponseEntity<Boolean> addVote(Integer yearNum, VoteRequest request){

    boolean response = false;

    if(!request.getCountryFrom().equals(request.getVotedFor())) {
      Vote voteDto = new Vote();
      voteDto.setId(System.nanoTime());
      voteDto.setYearNum(yearNum);
      voteDto.setCountryFrom(request.getCountryFrom());
      voteDto.setVotedFor(request.getVotedFor());

      response = votingService.addVote(voteDto);
    }

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<VoteSummaryResponse> getVoteSummary(Integer yearNum){
    VoteSummaryResponse voteSummaryResponse = votingService.getTopThreeListByYear(yearNum);

    return new ResponseEntity<>(voteSummaryResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<VoteSummaryResponse> getVoteSummaryByCountry(Integer yearNum,
      String countryName){

    VoteSummaryResponse voteSummaryResponse = votingService.getTopThreeListByCountry(yearNum,countryName);
    return new ResponseEntity<>(voteSummaryResponse, HttpStatus.OK);
  }
}

