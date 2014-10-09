package com.team4d.lolhelper.api.dto.league;

import java.util.List;

public class League {
	private	List<LeagueItem> entries; //
	private String name;	//	
	private String participantId;		
	private	String queue;	//	 (legal values: RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5)
	private	String tier;	//	 (legal values: CHALLENGER, DIAMOND, PLATINUM, GOLD, SILVER, BRONZE)
	/**
	 * @return the entries
	 */
	public List<LeagueItem> getEntries() {
		return entries;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the participantId
	 */
	public String getParticipantId() {
		return participantId;
	}
	/**
	 * @return the queue
	 */
	public String getQueue() {
		return queue;
	}
	/**
	 * @return the tier
	 */
	public String getTier() {
		return tier;
	}

	
}
