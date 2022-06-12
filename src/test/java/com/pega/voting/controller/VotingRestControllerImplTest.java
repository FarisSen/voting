package com.pega.voting.controller;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.pega.voting.model.Vote;
import com.pega.voting.model.VoteRequest;
import com.pega.voting.model.VoteSummaryResponse;
import com.pega.voting.repository.VoteRepository;
import com.pega.voting.service.VotingService;
import com.pega.voting.service.VotingServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class VotingRestControllerImplTest {

  @Mock
  private VotingService votingService;

  @InjectMocks
  private VotingRestControllerImpl votingRestControllerImpl;

  @Test
  public void TestAddVote() {

    ResponseEntity<Boolean> response;

    Integer yearNum = 2022;
    VoteRequest voteRequest = new VoteRequest();
    voteRequest.setCountryFrom("Netherland");
    voteRequest.setVotedFor("Turkey");

    when(votingService.addVote(any(Vote.class))).thenReturn(true);

    response = votingRestControllerImpl.addVote(yearNum,voteRequest);
    Assert.assertEquals(response.getBody(),true);
    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

  }

  @Test
  public void TestGetVoteSummary() {
    ResponseEntity<VoteSummaryResponse> response;

    Integer yearNum = 2022;
    VoteSummaryResponse voteSummaryResponse = new VoteSummaryResponse();
    voteSummaryResponse.setFirst("firstCountry");
    voteSummaryResponse.setSecond("secondCountry");
    voteSummaryResponse.setThird("thirdCountry");

    when(votingService.getTopThreeListByYear(anyInt())).thenReturn(voteSummaryResponse);

    response = votingRestControllerImpl.getVoteSummary(yearNum);
    Assert.assertNotNull(response);
    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void TestGetVoteSummaryByCountry() {
    ResponseEntity<VoteSummaryResponse> response;

    Integer yearNum = 2022;
    String countryName = "countryName";
    VoteSummaryResponse voteSummaryResponse = new VoteSummaryResponse();
    voteSummaryResponse.setFirst("firstCountry");
    voteSummaryResponse.setSecond("secondCountry");
    voteSummaryResponse.setThird("thirdCountry");

    when(votingService.getTopThreeListByCountry(anyInt(),anyString())).thenReturn(voteSummaryResponse);

    response = votingRestControllerImpl.getVoteSummaryByCountry(yearNum,countryName);
    Assert.assertNotNull(response);
    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}