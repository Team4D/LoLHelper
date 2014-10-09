package com.team4d.lolhelper.api.dto.summoner;

import java.util.ArrayList;

public class RunePage {
	private boolean current	;//	Indicates if the page is the current page.
	private long id	;//	Rune page ID.
	private String name;//Rune page name.
	private ArrayList<RuneSlot> slots;//List of rune slots associated with the rune page.
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
	 * @return the slots
	 */
	public ArrayList<RuneSlot> getSlots() {
		return slots;
	}
}
