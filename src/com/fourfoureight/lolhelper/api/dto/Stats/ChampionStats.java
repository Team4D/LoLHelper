package com.fourfoureight.lolhelper.api.dto.Stats;

public class ChampionStats {
	private int id;		//Champion id.
	private String name;	//Champion name.
	private AggregatedStats stats; //Aggregated stats associated with the champion.
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the stats
	 */
	public AggregatedStats getStats() {
		return stats;
	}

}
