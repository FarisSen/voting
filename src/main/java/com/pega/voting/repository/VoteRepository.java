package com.pega.voting.repository;

import com.pega.voting.model.Vote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote, Long> {

  @Query("SELECT v.votedFor, COUNT(v.votedFor) as totalVote FROM Vote AS v WHERE v.yearNum = ?1 GROUP BY v.votedFor ORDER BY totalVote DESC")
  List<Object[]> countTotalVotesByYear(Integer yearNum);

  @Query("SELECT v.votedFor, COUNT(v.votedFor) as totalVote FROM Vote AS v WHERE v.yearNum = ?1 AND v.countryFrom = ?2 GROUP BY v.votedFor ORDER BY totalVote DESC")
  List<Object[]> countTotalVotesByCountry(Integer yearNum, String CountryName);
}
