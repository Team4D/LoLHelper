package com.team4d.lolhelper.api.dto.team;

public class MatchHistorySummary {
	private int assists;	
	private int deaths;	
	private long gameId;	
	private String gameMode;
	private boolean invalid;	
	private int kills;	
	private int mapId;	
	private int opposingTeamKills;	
	private String opposingTeamName;	
	private boolean win;
	/**
	 * @return the assists
	 */
	public int getAssists() {
		return assists;
	}
	/**
	 * @return the deaths
	 */
	public int getDeaths() {
		return deaths;
	}
	/**
	 * @return the gameId
	 */
	public long getGameId() {
		return gameId;
	}
	/**
	 * @return the gameMode
	 */
	public String getGameMode() {
		return gameMode;
	}
	/**
	 * @return the invalid
	 */
	public boolean isInvalid() {
		return invalid;
	}
	/**
	 * @return the kills
	 */
	public int getKills() {
		return kills;
	}
	/**
	 * @return the mapId
	 */
	public int getMapId() {
		return mapId;
	}
	/**
	 * @return the opposingTeamKills
	 */
	public int getOpposingTeamKills() {
		return opposingTeamKills;
	}
	/**
	 * @return the opposingTeamName
	 */
	public String getOpposingTeamName() {
		return opposingTeamName;
	}
	/**
	 * @return the win
	 */
	public boolean isWin() {
		return win;
	}
}
