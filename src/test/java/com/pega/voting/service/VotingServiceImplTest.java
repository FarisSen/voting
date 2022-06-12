package com.pega.voting.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.pega.voting.model.Vote;
import com.pega.voting.model.VoteSummaryResponse;
import com.pega.voting.repository.VoteRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ExtendWith(MockitoExtension.class)
public class VotingServiceImplTest {

  @Mock
  private VoteRepository voteRepositoryMock;

  @InjectMocks
  private VotingServiceImpl votingServiceImpl;

  @Test
  void TestAddVote() {

    Vote voteDto = new Vote();
    voteDto.setCountryFrom("Netherland");
    voteDto.setVotedFor("Turkey");
    voteDto.setYearNum(2022);

    Vote voteDto2 = new Vote();
    voteDto2.setCountryFrom("Netherland");
    voteDto2.setVotedFor("Turkey");
    voteDto2.setYearNum(2022);

    when(voteRepositoryMock.save(voteDto2)).thenReturn(voteDto);

    boolean result = votingServiceImpl.addVote(voteDto);
    Assert.assertEquals(result, true);

  }

  @Test
  void TestGetTopThreeListByYear() {
    Integer yearNum = 2022;
    VoteSummaryResponse voteSummaryResponse = new VoteSummaryResponse();
    voteSummaryResponse.setFirst("firstCountry");
    voteSummaryResponse.setSecond("secondCountry");
    voteSummaryResponse.setThird("thirdCountry");

    List<Object[]> objects = new ArrayList<>();
    Object[] objects1 = new Object[2];
    objects1[0] = "firstCountry";
    objects1[1] = "10";
    objects.add(objects1);

    Object[] objects2 = new Object[2];
    objects2[0] = "secondCountry";
    objects2[1] = "8";
    objects.add(objects2);

    Object[] objects3 = new Object[2];
    objects3[0] = "thirdCountry";
    objects3[1] = "5";
    objects.add(objects3);

    when(voteRepositoryMock.countTotalVotesByYear(anyInt())).thenReturn(objects);

    VoteSummaryResponse result = votingServiceImpl.getTopThreeListByYear(yearNum);
    Assert.assertNotNull(result);
  }

  @Test
  void TestGetTopThreeListByCountry() {
    Integer yearNum = 2022;
    String countryName = "countryName";
    VoteSummaryResponse voteSummaryResponse = new VoteSummaryResponse();
    voteSummaryResponse.setFirst("firstCountry");
    voteSummaryResponse.setSecond("secondCountry");
    voteSummaryResponse.setThird("thirdCountry");

    List<Object[]> objects = new ArrayList<>();
    Object[] objects1 = new Object[2];
    objects1[0] = "firstCountry";
    objects1[1] = "10";
    objects.add(objects1);

    Object[] objects2 = new Object[2];
    objects2[0] = "secondCountry";
    objects2[1] = "8";
    objects.add(objects2);

    Object[] objects3 = new Object[2];
    objects3[0] = "thirdCountry";
    objects3[1] = "5";
    objects.add(objects3);

    when(voteRepositoryMock.countTotalVotesByCountry(yearNum,countryName)).thenReturn(objects);

    VoteSummaryResponse result = votingServiceImpl.getTopThreeListByCountry(yearNum,countryName);
    Assert.assertNotNull(result);
  }


}