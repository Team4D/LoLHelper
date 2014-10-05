package com.team4d.lolhelper.api.dto.team;

public class TeamStatDetail {
	private int averageGamesPlayed;	
	private String fullId;	
	private int losses;	
	private String teamStatType;	
	private int wins;
	/**
	 * @return the averageGamesPlayed
	 */
	public int getAverageGamesPlayed() {
		return averageGamesPlayed;
	}
	/**
	 * @return the fullId
	 */
	public String getFullId() {
		return fullId;
	}
	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * @return the teamStatType
	 */
	public String getTeamStatType() {
		return teamStatType;
	}
	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}
}
