package com.team4d.lolhelper.generalinfo;

public class SpellInfo
{

	private String name;
	private String cost;
	private String cooldown;
	private String range;

	private String description[];
	private String statsPerLevel[];

	// constructor for basic spell info
	public SpellInfo()
	{
		name = "";
		cooldown = "";
		range = "";
		cost = "";

	}

	public SpellInfo(String n, String r, String cd, String cos, String sPL[], String d[])
	{
		name = n;
		range = r;
		cooldown = cd;

		description = new String[d.length];
		for (int i = 0; i < description.length; i++)
		{
			description[i] = d[i];
		}

		statsPerLevel = new String[sPL.length];
		for (int i = 0; i < statsPerLevel.length; i++)
		{
			statsPerLevel[i] = sPL[i];
		}

		cost = cos;
	}

	// setters for Spell Info

	// sets name of spell
	public void setSpellName(String namer)
	{
		name = namer;
	}

	// sets descritption of spell
	public void setDescription(String d[])
	{
		description = new String[d.length];
		for (int i = 0; i < description.length; i++)
		{
			description[i] = d[i];
		}
	}

	// sets cooldown rate of spell
	public void setCoolDown(String cool)
	{
		cooldown = cool;
	}

	// sets range of effect of spell
	public void setSpellRange(String spellRange)
	{
		range = spellRange;
	}

	// sets stat(s) per level of spell
	public void setStatsPerLevel(String stats[])
	{
		statsPerLevel = new String[stats.length];

		for (int i = 0; i < stats.length; i++)
		{

			statsPerLevel[i] = stats[i];

		}
	}

	// sets cost of spell
	public void setCost(String costOf)
	{
		cost = costOf;
	}

	// getters for Spell Info

	// gets spell name
	public String getSpellName()
	{
		return name;
	}

	// gets description of spell
	public String[] getDescription()
	{
		return description;
	}

	// gets cooldown rate of spell
	public String getCoolDown()
	{
		return cooldown;
	}

	// gets range of effect of spell
	public String getSpellRange()
	{
		return range;
	}

	// gets stat(s) per level of spell
	public String[] getStatsPerLevel()
	{
		return statsPerLevel;
	}

	// gets cost of spell
	public String getCost()
	{
		return cost;
	}

}
