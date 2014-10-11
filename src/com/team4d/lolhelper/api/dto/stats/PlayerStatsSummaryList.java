package com.team4d.lolhelper.api.dto.stats;

import java.util.List;

public class PlayerStatsSummaryList
{
	private List<PlayerStatsSummary> playerStatSummaries; // List of player stats summaries associated with the
															// summoner.
	private String summonerId; // Summoner ID.

	/**
	 * @return the playerStatSummaries
	 */
	public List<PlayerStatsSummary> getPlayerStatSummaries()
	{
		return playerStatSummaries;
	}

	/**
	 * @return the summonerId
	 */
	public String getSummonerId()
	{
		return summonerId;
	}
}
