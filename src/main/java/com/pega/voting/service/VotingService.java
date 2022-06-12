package com.pega.voting.service;

import com.pega.voting.model.Vote;
import com.pega.voting.model.VoteSummaryResponse;

public interface VotingService {

  boolean addVote(Vote request);

  VoteSummaryResponse  getTopThreeListByYear(Integer yearNum);

  VoteSummaryResponse  getTopThreeListByCountry(Integer yearNum, String countryName);

}
