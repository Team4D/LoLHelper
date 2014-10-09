package com.team4d.lolhelper.api.dto.summoner;

public class Rune {
	private String description;	//	Rune description.
	private int id;	//Rune ID.
	private String name; //Rune name.
	private int tier; //	Rune tier.
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
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
	 * @return the tier
	 */
	public int getTier() {
		return tier;
	}
}
