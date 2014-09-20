package com.fourfoureight.lolhelper.api.dto.Stats;

public class PlayerStatsSummary {
	private AggregatedStats aggregatedStats;	// Aggregated stats.
	private int losses;							// Number of losses for this queue type. Returned for ranked queue types only.
	private long modifyDate;					// Date stats were last modified specified as epoch milliseconds.
	private String playerStatSummaryType;		// Player stats summary type. (legal values: AramUnranked5x5, CoopVsAI, CoopVsAI3x3, OdinUnranked, RankedPremade3x3, RankedPremade5x5, RankedSolo5x5, RankedTeam3x3, RankedTeam5x5, Unranked, Unranked3x3, OneForAll5x5, FirstBlood1x1, FirstBlood2x2)
	private String wins;						// Number of wins for this queue type.
	/**
	 * @return the aggregatedStats
	 */
	public AggregatedStats getAggregatedStats() {
		return aggregatedStats;
	}
	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * @return the modifyDate
	 */
	public long getModifyDate() {
		return modifyDate;
	}
	/**
	 * @return the playerStatSummaryType
	 */
	public String getPlayerStatSummaryType() {
		return playerStatSummaryType;
	}
	/**
	 * @return the wins
	 */
	public String getWins() {
		return wins;
	}

}
