package com.team4d.lolhelper.buildguides;

/**
 * The build class. Includes build name, items, and skill order.
 * 
 * @author Alexa
 */
public class BuildInfo
{
	private String[] items;
	private String[] skillorder;
	private int i; //Number of items
	private int j; //Used to count when adding skill order
	private String name = "";

	/**
	 * Constructor.
	 */
	public BuildInfo()
	{
		items = new String[12];
		skillorder = new String[18];
		i = 0;
		j=0;
	}

	/**
	 * Sets the name of the build.
	 * 
	 * @param name the String to name the build
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the name of the build as a String.
	 * 
	 * @return the name of the build.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Adds the specified skill next in the skill order. The skill must
	 * be "q", "w", "e", or "r", corresponding to champion abilities.
	 * <p>
	 * All 18 skills must be added before accessing the skill order.
	 * 
	 * @param s the skill as a string ("q", "w", "e", or "r") to add next in the skill order
	 */
	public void addSkillOrder(String s)
	{
		skillorder[j] = s;
		j++;
	}

	/**
	 * Returns the skill order as an array of Strings. Possible values
	 * are "q", "w", "e", or "r"
	 * 
	 * @return a String array of skill order ("q", "w", "e", or "r")
	 */
	public String[] getSkillOrder()
	{
		return skillorder;
	}

	/**
	 * Adds the specified item next in the build. The item must
	 * be added using the item ID.
	 * 
	 * @param newitem the item to be added by ID (String)
	 */
	public void addItem(String newitem){
		items[i]=newitem;
		i++;
	}

	/**
	 * Returns the item list as an array of Strings. Each item is
	 * by item ID.
	 * 
	 * @return a String array of items by item ID
	 */
	public String[] getItems()
	{
		return items;
	}
	
	/**
	 * Returns the number of items in the build.
	 * 
	 * @return the number of items in the build
	 */
	public int getNumItems(){
		return i;
	}
}
