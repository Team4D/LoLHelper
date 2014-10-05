package com.team4d.lolhelper.buildguides;

public class BuildInfo
{
	// Build Guide Variables - Start (4), Rush (4), As Needed (5)
	private final String[] start = {
			"total_transparent",
			"total_transparent",
			"total_transparent",
			"total_transparent" };
	private final String[] rush = {
			"total_transparent"
			, "total_transparent"
			, "total_transparent"
			, "total_transparent" };
	private final String[] asNeeded = {
			"total_transparent",
			"total_transparent",
			"total_transparent",
			"total_transparent",
			"total_transparent" };
	private final int[] skillOrder = { 1, 2, 3, 4 };

	private boolean exists = false;
	private String name = "";

	public BuildInfo()
	{

	}

	public boolean exists()
	{
		return exists;
	}

	public void setName(String set)
	{
		name = set;
	}

	public String getName()
	{
		return name;
	}

	public void setSkillOrder(int s1, int s2, int s3, int s4)
	{
		skillOrder[0] = s1;
		skillOrder[1] = s2;
		skillOrder[2] = s3;
		skillOrder[3] = s4;
	}

	public int[] getSkillOrder()
	{
		return skillOrder;
	}

	public void setStart(String set)
	{
		exists = true;
		start[0] = set;
		start[1] = "total_transparent";
		start[2] = "total_transparent";
		start[3] = "total_transparent";
	}

	public void setStart(String set1, String set2)
	{
		exists = true;
		start[0] = set1;
		start[1] = set2;
		start[2] = "total_transparent";
		start[3] = "total_transparent";
	}

	public void setStart(String set1, String set2, String set3)
	{
		exists = true;
		start[0] = set1;
		start[1] = set2;
		start[2] = set3;
		start[3] = "total_transparent";
	}

	public void setStart(String set1, String set2, String set3, String set4)
	{
		exists = true;
		start[0] = set1;
		start[1] = set2;
		start[2] = set3;
		start[3] = set4;
	}

	public void setRush(String set)
	{
		exists = true;
		rush[0] = set;
		rush[1] = "total_transparent";
		rush[2] = "total_transparent";
		rush[3] = "total_transparent";
	}

	public void setRush(String set1, String set2)
	{
		exists = true;
		rush[0] = set1;
		rush[1] = set2;
		rush[2] = "total_transparent";
		rush[3] = "total_transparent";
	}

	public void setRush(String set1, String set2, String set3)
	{
		exists = true;
		rush[0] = set1;
		rush[1] = set2;
		rush[2] = set3;
		rush[3] = "total_transparent";
	}

	public void setRush(String set1, String set2, String set3, String set4)
	{
		exists = true;
		rush[0] = set1;
		rush[1] = set2;
		rush[2] = set3;
		rush[3] = set4;
	}

	public void setAsNeeded(String set)
	{
		exists = true;
		asNeeded[0] = set;
		asNeeded[1] = "total_transparent";
		asNeeded[2] = "total_transparent";
		asNeeded[3] = "total_transparent";
		asNeeded[4] = "total_transparent";
	}

	public void setAsNeeded(String set1, String set2)
	{
		exists = true;
		asNeeded[0] = set1;
		asNeeded[1] = set2;
		asNeeded[2] = "total_transparent";
		asNeeded[3] = "total_transparent";
		asNeeded[4] = "total_transparent";
	}

	public void setAsNeeded(String set1, String set2, String set3)
	{
		exists = true;
		asNeeded[0] = set1;
		asNeeded[1] = set2;
		asNeeded[2] = set3;
		asNeeded[3] = "total_transparent";
		asNeeded[4] = "total_transparent";
	}

	public void setAsNeeded(String set1, String set2, String set3, String set4)
	{
		exists = true;
		asNeeded[0] = set1;
		asNeeded[1] = set2;
		asNeeded[2] = set3;
		asNeeded[3] = set4;
		asNeeded[4] = "total_transparent";
	}

	public void setAsNeeded(String set1, String set2, String set3, String set4, String set5)
	{
		exists = true;
		asNeeded[0] = set1;
		asNeeded[1] = set2;
		asNeeded[2] = set3;
		asNeeded[3] = set4;
		asNeeded[4] = set5;
	}

	public String[] getStart()
	{
		return start;
	}

	public String[] getRush()
	{
		return rush;
	}

	public String[] getAsNeeded()
	{
		return asNeeded;
	}

	public void clear()
	{
		exists = false;
		for (int i = 0; i < 4; i++)
		{
			start[i] = "total_transparent";
			rush[i] = "total_transparent";
			asNeeded[i] = "total_transparent";
		}
		asNeeded[4] = "total_transparent";
		name = "";
	}
}
