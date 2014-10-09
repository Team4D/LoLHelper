package com.team4d.lolhelper.api.dto.summoner;

public class Summoner {
	private long id;		//	Summoner ID.
	private String name;		//	Summoner name.
	private int profileIconId;	//	ID of the summoner icon associated with the summoner.
	private long revisionDate; 	//	Date summoner was last modified specified as epoch milliseconds.
	private long summonerLevel;	//	Summoner level associated with the summoner.
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the profileIconId
	 */
	public int getProfileIconId() {
		return profileIconId;
	}
	/**
	 * @return the revisionDate
	 */
	public long getRevisionDate() {
		return revisionDate;
	}
	/**
	 * @return the summonerLevel
	 */
	public long getSummonerLevel() {
		return summonerLevel;
	}
}
