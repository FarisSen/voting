package com.pega.voting.service;

import com.pega.voting.mapper.VotingMapper;
import com.pega.voting.model.Vote;
import com.pega.voting.model.VoteSummaryResponse;
import com.pega.voting.repository.VoteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingServiceImpl implements VotingService {

  @Autowired
  private VoteRepository voteRepository;

  @Override
  public boolean addVote(Vote request) {
    return (voteRepository.save(request) != null);
  }

  @Override
  public VoteSummaryResponse getTopThreeListByYear(Integer yearNum) {
    List<Object[]> results = voteRepository.countTotalVotesByYear(yearNum);
    VoteSummaryResponse voteSummaryResponse = VotingMapper.mapToVoteSummaryResponse(results);

    return voteSummaryResponse;
  }

  @Override
  public VoteSummaryResponse getTopThreeListByCountry(Integer yearNum, String countryName) {
    List<Object[]> results = voteRepository.countTotalVotesByCountry(yearNum,countryName);
    VoteSummaryResponse voteSummaryResponse = VotingMapper.mapToVoteSummaryResponse(results);

    return voteSummaryResponse;
  }

}
