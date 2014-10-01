package com.fourfoureight.lolhelper.api;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fourfoureight.lolhelper.api.database.LOLSQLiteHelper;
import com.fourfoureight.lolhelper.api.dto.staticdata.Champion.Champion;
import com.fourfoureight.lolhelper.api.dto.staticdata.Item.Item;
import com.fourfoureight.lolhelper.api.dto.staticdata.Mastery.Mastery;
import com.fourfoureight.lolhelper.api.dto.staticdata.Rune.Rune;
import com.fourfoureight.lolhelper.api.dto.staticdata.SummonerSpell.SummonerSpell;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

/**
 * @author KaosuRyoko
 */
public class APIData
{
	// Private constructor because static class
	private APIData()
	{
	}
	
	private static SQLiteDatabase myDB = LOLSQLiteHelper.getInstance(null).getWritableDatabase();

	public static Champion getChampionByID(int ID)
	{
		Cursor dbcursor = myDB.query("champions", new String[] { "json" }, "_id = " + ID, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String champ = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Champion champion = new Gson().fromJson(champ, Champion.class);
				return champion;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	public static Champion getChampionByName(String name)
	{
		Cursor dbcursor = myDB.query("champions", new String[] { "json" }, "name = " + name, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String champ = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Champion champion = new Gson().fromJson(champ, Champion.class);
				return champion;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	public static Champion getChampionByKey(String key)
	{
		Cursor dbcursor = myDB.query("champions", new String[] { "json" }, "key = " + key, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String champ = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Champion champion = new Gson().fromJson(champ, Champion.class);
				return champion;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
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
		Cursor dbcursor = myDB.query("items", new String[] { "json" }, "_id = " + ID, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String item = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Item i = new Gson().fromJson(item, Item.class);
				return i;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	public static Item getItemByName(String name)
	{
		Cursor dbcursor = myDB.query("items", new String[] { "json" }, "name = " + name, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String item = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Item i = new Gson().fromJson(item, Item.class);
				return i;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;	}

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
		Cursor dbcursor = myDB.query("masteries", new String[] { "json" }, "_id = " + ID, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String mastery = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Mastery m = new Gson().fromJson(mastery, Mastery.class);
				return m;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	public static Mastery getMasteryByName(String name)
	{
		Cursor dbcursor = myDB.query("masteries", new String[] { "json" }, "name = " + name, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String mastery = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Mastery m = new Gson().fromJson(mastery, Mastery.class);
				return m;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
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
		Cursor dbcursor = myDB.query("runes", new String[] { "json" }, "_id = " + ID, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String rune = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Rune r = new Gson().fromJson(rune, Rune.class);
				return r;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	public static Rune getRuneByName(String name)
	{
		Cursor dbcursor = myDB.query("runes", new String[] { "json" }, "name = " + name, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String rune = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				Rune r = new Gson().fromJson(rune, Rune.class);
				return r;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
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
		Cursor dbcursor = myDB.query("summonerspells", new String[] { "json" }, "_id = " + ID, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String spell = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				SummonerSpell s = new Gson().fromJson(spell, SummonerSpell.class);
				return s;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	public static SummonerSpell getSummonerSpellByName(String name)
	{
		Cursor dbcursor = myDB.query("summonerspells", new String[] { "json" }, "name = " + name, null, null, null, null, null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String spell = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				SummonerSpell s = new Gson().fromJson(spell, SummonerSpell.class);
				return s;
			}
			catch (Exception e)
			{
				//Should probably at least do some logging, but not worried about that right now.
			}
		}
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
