package com.fourfoureight.lolhelper.api.dto.League;

public class LeagueItem {
	private String division;
	private boolean isFreshBlood;	
	private boolean isHotStreak;	
	private boolean isInactive;	
	private boolean isVeteran;	
	private int leaguePoints;	
	private MiniSeries miniSeries;	
	private String playerOrTeamId;	
	private String playerOrTeamName;		
	private int wins;


	/**
	 * @return the isFreshBlood
	 */
	public boolean isFreshBlood() {
		return isFreshBlood;
	}
	/**
	 * @return the isHotStreak
	 */
	public boolean isHotStreak() {
		return isHotStreak;
	}
	/**
	 * @return the isInactive
	 */
	public boolean isInactive() {
		return isInactive;
	}
	/**
	 * @return the isVeteran
	 */
	public boolean isVeteran() {
		return isVeteran;
	}
	/**
	 * @return the leaguePoints
	 */
	public int getLeaguePoints() {
		return leaguePoints;
	}
	/**
	 * @return the miniSeries
	 */
	public MiniSeries getMiniSeries() {
		return miniSeries;
	}
	/**
	 * @return the playerOrTeamId
	 */
	public String getPlayerOrTeamId() {
		return playerOrTeamId;
	}
	/**
	 * @return the playerOrTeamName
	 */
	public String getPlayerOrTeamName() {
		return playerOrTeamName;
	}
	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}
	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	
	
}
