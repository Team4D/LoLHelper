package com.team4d.lolhelper.api;

import java.util.Arrays;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.team4d.lolhelper.api.database.LOLSQLiteHelper;
import com.team4d.lolhelper.api.dto.staticdata.champion.Champion;
import com.team4d.lolhelper.api.dto.staticdata.item.Item;
import com.team4d.lolhelper.api.dto.staticdata.mastery.Mastery;
import com.team4d.lolhelper.api.dto.staticdata.rune.Rune;
import com.team4d.lolhelper.api.dto.staticdata.summonerspell.SummonerSpell;

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
		Cursor dbcursor = myDB.rawQuery("select json from champions where name = ?", new String[] { name });
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
		Cursor dbcursor = myDB.rawQuery("select json from champions where key = ?", new String[] { key });
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
		//Get all names
		Cursor dbcursor = myDB.rawQuery("select name from champions", null);
		int n = dbcursor.getCount(); //number of entries
		int m = dbcursor.getColumnIndex("name"); //index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		//Put each entry name into s
		for(int i=0; i<n; i++){
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	public static int getNumberChampions()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "champions");
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
		Cursor dbcursor = myDB.rawQuery("select json from items where name = ?", new String[] { name });
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
		//Get all names
		Cursor dbcursor = myDB.rawQuery("select name from items", null);
		int n = dbcursor.getCount(); //number of entries
		int m = dbcursor.getColumnIndex("name"); //index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		//Put each entry name into s
		for(int i=0; i<n; i++){
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	public static int getNumberItems()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "items");
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
		Cursor dbcursor = myDB.rawQuery("select json from masteries where name = ?", new String[] { name });
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
		//Get all names
		Cursor dbcursor = myDB.rawQuery("select name from masteries", null);
		int n = dbcursor.getCount(); //number of entries
		int m = dbcursor.getColumnIndex("name"); //index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		//Put each entry name into s
		for(int i=0; i<n; i++){
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	public static int getNumberMasteries()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "masteries");
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
		Cursor dbcursor = myDB.rawQuery("select json from runess where name = ?", new String[] { name });
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
		//Get all names
		Cursor dbcursor = myDB.rawQuery("select name from runes", null);
		int n = dbcursor.getCount(); //number of entries
		int m = dbcursor.getColumnIndex("name"); //index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		//Put each entry name into s
		for(int i=0; i<n; i++){
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	public static int getNumberRunes()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "runes");
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
		Cursor dbcursor = myDB.rawQuery("select json from summonerspells where name = ?", new String[] { name });
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
		//Get all names
		Cursor dbcursor = myDB.rawQuery("select name from summonerspells", null);
		int n = dbcursor.getCount(); //number of entries
		int m = dbcursor.getColumnIndex("name"); //index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		//Put each entry name into s
		for(int i=0; i<n; i++){
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	public static int getNumberSummonerSpells()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "summonerspells");
	}
}
