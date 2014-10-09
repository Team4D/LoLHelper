package com.team4d.lolhelper.api.dto.summoner;

import java.util.ArrayList;

public class MasteryPage {
	private boolean current; 		//	Indicates if the mastery page is the current mastery page.
	private long id	;				//	Mastery page ID.
	private String name;			//	Mastery page name.
	private ArrayList<Talent> talents;	//	List of mastery page talents associated with the mastery page.
	/**
	 * @return the current
	 */
	public boolean isCurrent() {
		return current;
	}
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
	 * @return the talents
	 */
	public ArrayList<Talent> getTalents() {
		return talents;
	}
	
}
