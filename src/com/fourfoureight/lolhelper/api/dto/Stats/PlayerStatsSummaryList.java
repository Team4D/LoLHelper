package lolapi.dto.Stats;

import java.util.List;

public class PlayerStatsSummaryList {
	private List<PlayerStatsSummary> playerStatSummaries; //List of player stats summaries associated with the summoner.
	private long summonerId; //Summoner ID.
	/**
	 * @return the playerStatSummaries
	 */
	public List<PlayerStatsSummary> getPlayerStatSummaries() {
		return playerStatSummaries;
	}
	/**
	 * @return the summonerId
	 */
	public long getSummonerId() {
		return summonerId;
	}
}
