package com.pega.voting.mapper;

import com.pega.voting.model.VoteSummaryResponse;
import java.util.List;

public class VotingMapper {

  public static VoteSummaryResponse mapToVoteSummaryResponse(List<Object[]> results) {
    VoteSummaryResponse voteSummaryResponse = new VoteSummaryResponse();

    for (int i = 0; i < results.size(); i++) {
      Object[] result = results.get(i);
      String name = (String) result[0];

      if (i == 0) {
        voteSummaryResponse.setFirst(name);
      } else if (i == 1) {
        voteSummaryResponse.setSecond(name);
      } else if (i == 2) {
        voteSummaryResponse.setThird(name);
      } else {
        break;
      }
    }

    return voteSummaryResponse;
  }

}
