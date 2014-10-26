package com.team4d.lolhelper.buildguides;

public class BuildInfo
{
	private String[] items;
	private String[] skillorder;
	private int i; //Number of items
	private int j; //To count for skill order

	private boolean exists = false;
	private String name = "";

	public BuildInfo()
	{
		items = new String[12];
		skillorder = new String[18];
		i = 0;
		j=0;
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

	public void addSkillOrder(String s)
	{
		skillorder[j] = s;
		j++;
	}

	public String[] getSkillOrder()
	{
		return skillorder;
	}

	public void addItem(String newitem){
		items[i]=newitem;
		i++;
	}

	public String[] getItems()
	{
		return items;
	}
	
	public int getNumItems(){
		return i;
	}
}
