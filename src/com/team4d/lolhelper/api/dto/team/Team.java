package com.team4d.lolhelper.api.dto.team;

import java.util.ArrayList;

public class Team {
	private long createDate;	
	private String fullId;	
	private long lastGameDate;	
	private long lastJoinDate;	
	private long lastJoinedRankedTeamQueueDate;	
	private ArrayList<MatchHistorySummary> matchHistory;	
	private MessageOfDay messageOfDay;		
	private long modifyDate;	
	private String name;	
	private Roster roster;	
	private long secondLastJoinDate;	
	private String status;	
	private String tag;	
	private TeamStatSummary teamStatSummary;	
	private long thirdLastJoinDate;
	/**
	 * @return the createDate
	 */
	public long getCreateDate() {
		return createDate;
	}
	/**
	 * @return the fullId
	 */
	public String getFullId() {
		return fullId;
	}
	/**
	 * @return the lastGameDate
	 */
	public long getLastGameDate() {
		return lastGameDate;
	}
	/**
	 * @return the lastJoinDate
	 */
	public long getLastJoinDate() {
		return lastJoinDate;
	}
	/**
	 * @return the lastJoinedRankedTeamQueueDate
	 */
	public long getLastJoinedRankedTeamQueueDate() {
		return lastJoinedRankedTeamQueueDate;
	}
	/**
	 * @return the matchHistory
	 */
	public ArrayList<MatchHistorySummary> getMatchHistory() {
		return matchHistory;
	}
	/**
	 * @return the messageOfDay
	 */
	public MessageOfDay getMessageOfDay() {
		return messageOfDay;
	}
	/**
	 * @return the modifyDate
	 */
	public long getModifyDate() {
		return modifyDate;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the roster
	 */
	public Roster getRoster() {
		return roster;
	}
	/**
	 * @return the secondLastJoinDate
	 */
	public long getSecondLastJoinDate() {
		return secondLastJoinDate;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @return the teamStatSummary
	 */
	public TeamStatSummary getTeamStatSummary() {
		return teamStatSummary;
	}
	/**
	 * @return the thirdLastJoinDate
	 */
	public long getThirdLastJoinDate() {
		return thirdLastJoinDate;
	}
}
