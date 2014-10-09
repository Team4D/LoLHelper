package com.team4d.lolhelper.api.dto.summoner;

import java.util.ArrayList;

public class MasteryPages {
	private ArrayList<MasteryPage> pages;	// List of mastery pages associated with the summoner.
	private long summonerId;					// Summoner ID.
	/**
	 * @return the pages
	 */
	public ArrayList<MasteryPage> getPages() {
		return pages;
	}
	/**
	 * @return the summonerId
	 */
	public long getSummonerId() {
		return summonerId;
	}
}
