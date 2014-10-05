package com.team4d.lolhelper.api.dto.stats;

import java.util.ArrayList;

public class RankedStats {
	private ArrayList<ChampionStats> champions;	//List of aggregated stats summarized by champion.
	private long modifyDate;	//	Date stats were last modified specified as epoch milliseconds.
	private long summonerId;	//	Summoner ID.
	/**
	 * @return the champions
	 */
	public ArrayList<ChampionStats> getChampions() {
		return champions;
	}
	/**
	 * @return the modifyDate
	 */
	public long getModifyDate() {
		return modifyDate;
	}
	/**
	 * @return the summonerId
	 */
	public long getSummonerId() {
		return summonerId;
	}
}
