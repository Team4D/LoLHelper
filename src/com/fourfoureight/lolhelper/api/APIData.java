package com.fourfoureight.lolhelper.api;

import com.fourfoureight.lolhelper.api.dto.staticdata.Champion.Champion;
import com.fourfoureight.lolhelper.api.dto.staticdata.Item.Item;
import com.fourfoureight.lolhelper.api.dto.staticdata.Mastery.Mastery;
import com.fourfoureight.lolhelper.api.dto.staticdata.Rune.Rune;
import com.fourfoureight.lolhelper.api.dto.staticdata.SummonerSpell.SummonerSpell;

/**
 * @author KaosuRyoko
 */
public class APIData
{
	// Private constructor because static class
	private APIData()
	{
	}

	public static Champion getChampionByID(int ID)
	{
		return null;
	}

	public static Champion getChampionByName(String name)
	{
		return null;
	}

	public static Champion getChampionByKey(String key)
	{
		return null;
	}

	public static String[] getChampionList()
	{
		return null;
	}

	public static int getNumberChampions()
	{
		return -1;
	}

	public static Item getItemByID(int ID)
	{
		return null;
	}

	public static Item getItemByName(String name)
	{
		return null;
	}

	public static String[] getItemList()
	{
		return null;
	}

	public static int getNumberItems()
	{
		return -1;
	}

	public static Mastery getMasteryByID(int ID)
	{
		return null;
	}

	public static Mastery getMasteryByName(String name)
	{
		return null;
	}

	public static String[] getMasteryList()
	{
		return null;
	}

	public static int getNumberMasteries()
	{
		return -1;
	}

	public static Rune getRuneByID(int ID)
	{
		return null;
	}

	public static Rune getRuneByName(String name)
	{
		return null;
	}

	public static String[] getRuneList()
	{
		return null;
	}

	public static int getNumberRunes()
	{
		return -1;
	}

	public static SummonerSpell getSummonerSpellByID(int ID)
	{
		return null;
	}

	public static SummonerSpell getSummonerSpellByName(String name)
	{
		return null;
	}

	public static String[] getSummonerSpellList()
	{
		//Return value for tests
		String[] s = {"Barrier", "Flash"};
		return s;
	}

	public static int getNumberSummonerSpells()
	{
		return -1;
	}
}
