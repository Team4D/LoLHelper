package com.fourfoureight.lolhelper.api.dto.Champion;

import lolapi.constants.Version; //  where is this?

public class Champion {
	private	boolean active;						//Indicates if the champion is active.
	private	int	attackRank;						//Champion attack rank.
	private	boolean	botEnabled;					//Bot enabled flag (for custom games).
	private	boolean	botMmEnabled;				//Bot Match Made enabled flag (for Co-op vs. AI games).
	private	int	defenseRank;					//Champion defense rank.
	private	int	difficultyRank;					//Champion difficulty rank.
	private	boolean	freeToPlay;					//Indicates if the champion is free to play. Free to play champions are rotated periodically.
	private	long id;							//Champion ID.
	private	int	magicRank;						//Champion magic rank.
	private	String name;						//Champion name.
	private	boolean rankedPlayEnabled;			//Ranked play enabled flag.
	
	public String championQuery(String region, long summonerId)
	{	
		return "/api/lol/" + region + "/" + Version.championQVersion + "/champion";
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the attackRank
	 */
	public int getAttackRank() {
		return attackRank;
	}

	/**
	 * @param attackRank the attackRank to set
	 */
	public void setAttackRank(int attackRank) {
		this.attackRank = attackRank;
	}

	/**
	 * @return the botEnabled
	 */
	public boolean isBotEnabled() {
		return botEnabled;
	}

	/**
	 * @param botEnabled the botEnabled to set
	 */
	public void setBotEnabled(boolean botEnabled) {
		this.botEnabled = botEnabled;
	}

	/**
	 * @return the botMmEnabled
	 */
	public boolean isBotMmEnabled() {
		return botMmEnabled;
	}

	/**
	 * @param botMmEnabled the botMmEnabled to set
	 */
	public void setBotMmEnabled(boolean botMmEnabled) {
		this.botMmEnabled = botMmEnabled;
	}

	/**
	 * @return the defenseRank
	 */
	public int getDefenseRank() {
		return defenseRank;
	}

	/**
	 * @param defenseRank the defenseRank to set
	 */
	public void setDefenseRank(int defenseRank) {
		this.defenseRank = defenseRank;
	}

	/**
	 * @return the difficultyRank
	 */
	public int getDifficultyRank() {
		return difficultyRank;
	}

	/**
	 * @param difficultyRank the difficultyRank to set
	 */
	public void setDifficultyRank(int difficultyRank) {
		this.difficultyRank = difficultyRank;
	}

	/**
	 * @return the freeToPlay
	 */
	public boolean isFreeToPlay() {
		return freeToPlay;
	}

	/**
	 * @param freeToPlay the freeToPlay to set
	 */
	public void setFreeToPlay(boolean freeToPlay) {
		this.freeToPlay = freeToPlay;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the magicRank
	 */
	public int getMagicRank() {
		return magicRank;
	}

	/**
	 * @param magicRank the magicRank to set
	 */
	public void setMagicRank(int magicRank) {
		this.magicRank = magicRank;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rankedPlayEnabled
	 */
	public boolean isRankedPlayEnabled() {
		return rankedPlayEnabled;
	}

	/**
	 * @param rankedPlayEnabled the rankedPlayEnabled to set
	 */
	public void setRankedPlayEnabled(boolean rankedPlayEnabled) {
		this.rankedPlayEnabled = rankedPlayEnabled;
	}
}
