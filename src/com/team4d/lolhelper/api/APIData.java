package com.team4d.lolhelper.api;

import java.util.Arrays;
import java.util.List;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.team4d.lolhelper.api.database.LOLSQLiteHelper;
import com.team4d.lolhelper.api.dto.staticdata.SpellVars;
import com.team4d.lolhelper.api.dto.staticdata.champion.Champion;
import com.team4d.lolhelper.api.dto.staticdata.champion.ChampionSpell;
import com.team4d.lolhelper.api.dto.staticdata.item.Item;
import com.team4d.lolhelper.api.dto.staticdata.mastery.Mastery;
import com.team4d.lolhelper.api.dto.staticdata.rune.Rune;
import com.team4d.lolhelper.api.dto.staticdata.summonerspell.SummonerSpell;
import com.team4d.lolhelper.api.dto.stats.PlayerStatsSummaryList;
import com.team4d.lolhelper.api.dto.stats.RankedStats;
import com.team4d.lolhelper.api.dto.summoner.Summoner;

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

	/*
	 * ********************************
	 * Start of Static API Data
	 * ********************************
	 */
	/**
	 * Finds a champion in the database by ID.
	 * If no champion has that ID, returns null.
	 * 
	 * @param ID the ID of the champion needed
	 * @return the Champion object associated with the specified ID
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Finds a champion in the database by name.
	 * If no champion has that name, returns null.
	 * 
	 * @param name the name of the champion needed
	 * @return the Champion object associated with the specified name
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Finds a champion in the database by key.
	 * If no champion has that key, returns null.
	 * 
	 * @param key the key of the champion needed
	 * @return the Champion object associated with the specified key
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Takes the ID of a champion and finds the name of the
	 * champion with that ID.
	 * 
	 * @param ID the ID of the champion needed
	 * @return the name of the champion associated with the specified ID
	 */
	public static String getChampionNameByID(int ID)
	{
		Champion theChamp = getChampionByID(ID);
		return theChamp.getName();
	}

	/**
	 * Returns an array of all champion names as Strings.
	 * The array is sorted in alphabetical order.
	 * 
	 * @return a String array of all champion names, sorted alphabetically
	 */
	public static String[] getChampionList()
	{
		// Get all names
		Cursor dbcursor = myDB.rawQuery("select name from champions", null);
		int n = dbcursor.getCount(); // number of entries
		int m = dbcursor.getColumnIndex("name"); // index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		// Put each entry name into s
		for (int i = 0; i < n; i++)
		{
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	/**
	 * Returns the number of champions in the database.
	 * 
	 * @return the number of champions in the database
	 */
	public static int getNumberChampions()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "champions");
	}

	/**
	 * Finds an item in the database by ID.
	 * If no item has that ID, returns null.
	 * 
	 * @param ID the ID of the item needed
	 * @return the Item object associated with the specified ID
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Finds an item in the database by name.
	 * If no item has that name, returns null.
	 * 
	 * @param name the name of the item needed
	 * @return the Item object associated with the specified name
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Returns an array of all item names as Strings.
	 * The array is sorted in the order they appear in the database.
	 * 
	 * @return a String array of all item names
	 */
	public static String[] getItemList()
	{
		// Get all names
		Cursor dbcursor = myDB.rawQuery("select name from items", null);
		int n = dbcursor.getCount(); // number of entries
		int m = dbcursor.getColumnIndex("name"); // index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		// Put each entry name into s
		for (int i = 0; i < n; i++)
		{
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		return s;
	}
	
	/**
	 * Returns an array of all item IDs.
	 * The array is sorted in the order they appear in the database.
	 * 
	 * @return an integer array of all item IDs
	 */
	public static int[] getItemIDList()
	{
		// Get all names
		Cursor dbcursor = myDB.rawQuery("select _id from items", null);
		int n = dbcursor.getCount(); // number of entries
		int m = dbcursor.getColumnIndex("_id"); // index of id column
		int[] ids = new int[n];
		dbcursor.moveToFirst();
		// Put each entry id into s
		for (int i = 0; i < n; i++)
		{
			ids[i] = dbcursor.getInt(m);
			System.out.println(ids[i]);
			dbcursor.moveToNext();
		}
		return ids;
	}

	/**
	 * Returns the number of items in the database.
	 * 
	 * @return the number of items in the database
	 */
	public static int getNumberItems()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "items");
	}

	/**
	 * Finds a mastery in the database by ID.
	 * If no mastery has that ID, returns null.
	 * 
	 * @param ID the ID of the mastery needed
	 * @return the Mastery object associated with the specified ID
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Finds a mastery in the database by name.
	 * If no mastery has that name, returns null.
	 * 
	 * @param name the name of the mastery needed
	 * @return the Mastery object associated with the specified name
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Returns an array of all mastery names as Strings.
	 * The array is sorted in alphabetical order.
	 * 
	 * @return a String array of all mastery names, sorted alphabetically
	 */
	public static String[] getMasteryList()
	{
		// Get all names
		Cursor dbcursor = myDB.rawQuery("select name from masteries", null);
		int n = dbcursor.getCount(); // number of entries
		int m = dbcursor.getColumnIndex("name"); // index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		// Put each entry name into s
		for (int i = 0; i < n; i++)
		{
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	/**
	 * Returns the number of masteries in the database.
	 * 
	 * @return the number of masteries in the database
	 */
	public static int getNumberMasteries()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "masteries");
	}

	/**
	 * Finds a rune in the database by ID.
	 * If no rune has that ID, returns null.
	 * 
	 * @param ID the ID of the rune needed
	 * @return the Rune object associated with the specified ID
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Finds a rune in the database by name.
	 * If no rune has that name, returns null.
	 * 
	 * @param name the name of the rune needed
	 * @return the Rune object associated with the specified name
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Returns an array of all rune names as Strings.
	 * The array is sorted in alphabetical order.
	 * 
	 * @return a String array of all rune names, sorted alphabetically
	 */
	public static String[] getRuneList()
	{
		// Get all names
		Cursor dbcursor = myDB.rawQuery("select name from runes", null);
		int n = dbcursor.getCount(); // number of entries
		int m = dbcursor.getColumnIndex("name"); // index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		// Put each entry name into s
		for (int i = 0; i < n; i++)
		{
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	/**
	 * Returns the number of runes in the database.
	 * 
	 * @return the number of runes in the database
	 */
	public static int getNumberRunes()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "runes");
	}

	/**
	 * Finds a summoner spell in the database by ID.
	 * If no summoner spell has that ID, returns null.
	 * 
	 * @param ID the ID of the summoner spell needed
	 * @return the SummonerSpell object associated with the specified ID
	 */
	public static SummonerSpell getSummonerSpellByID(int ID)
	{
		Cursor dbcursor = myDB.query("summonerspells", new String[] { "json" }, "_id = " + ID, null, null, null, null,
				null);
		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String spell = dbcursor.getString(dbcursor.getColumnIndex("json"));
			try
			{
				SummonerSpell s = new Gson().fromJson(spell, SummonerSpell.class);
				return s;
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}
	
	/**
	 * Finds a summoner spell in the database by name.
	 * If no summoner spell has that name, returns null.
	 * 
	 * @param name the name of the summoner spell needed
	 * @return the SummonerSpell object associated with the specified name
	 */
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
			} catch (Exception e)
			{
				// Should probably at least do some logging, but not worried about that right now.
			}
		}
		return null;
	}

	/**
	 * Returns an array of all summoner spell names as Strings.
	 * The array is sorted in alphabetical order.
	 * 
	 * @return a String array of all summoner spell names, sorted alphabetically
	 */
	public static String[] getSummonerSpellList()
	{
		// Get all names
		Cursor dbcursor = myDB.rawQuery("select name from summonerspells", null);
		int n = dbcursor.getCount(); // number of entries
		int m = dbcursor.getColumnIndex("name"); // index of name column
		String[] s = new String[n];
		dbcursor.moveToFirst();
		// Put each entry name into s
		for (int i = 0; i < n; i++)
		{
			s[i] = dbcursor.getString(m);
			System.out.println(s[i]);
			dbcursor.moveToNext();
		}
		Arrays.sort(s);
		return s;
	}

	/**
	 * Returns the number of summoner spells in the database.
	 * 
	 * @return the number of summoner spells in the database
	 */
	public static int getNumberSummonerSpells()
	{
		return (int) DatabaseUtils.queryNumEntries(myDB, "summonerspells");
	}

	/*
	 * ********************************
	 * End of Static API Data
	 * ********************************
	 */
	/*
	 * ********************************
	 * Start of Utility Functions
	 * ********************************
	 */
	
	/**
	 * Takes a champion spell and parses the description in the following way:
	 * Turns HTML breaks into newlines,
	 * removes and disregards other HTML formatting,
	 * replaces all variables in the spell description with corresponding numbers from the API, and
	 * handles special cases in which the variables need to be edited or removed completely, such as
	 * when they depend on in-game information that does not apply in general.
	 * <p>
	 * The returned String is clean and ready to be displayed.
	 * 
	 * @author Alexa
	 * @param spell the ChampionSpell object from which to parse the description
	 * @return a String of the parsed description
	 */
	public static String parse(ChampionSpell spell)
	{
		String base = spell.getDescription() + "\n\n" + spell.getTooltip();
		List<String> e = spell.getEffectBurn();
		List<SpellVars> vars = spell.getVars();
		// Remove HTML formatting
		base = base.replaceAll("<br>", "\n");
		base = base.replaceAll("(<[^>]*>)?", "");
		// Replace e's
		int n = e.size();
		for (int i = 0; i < n; i++)
		{
			base = base.replace("{{ e" + i + " }}", e.get(i));
		}
		// Replace f's (individual cases)
		String name = spell.getName();
		if (name.equals("Flay"))
		{
			base = base.replace("{{ f1 }}-{{ f2 }} ", "");
		} else if (name.equals("Blood Thirst / Blood Price"))
		{
			base = base.replace("({{ f5 }}) ", "");
			base = base.replace("{{ f4 }} ", "");
		} else if (name.equals("Hawkshot"))
		{
			base = base.replaceAll("Total Gold Retrieved: .*", "");
		} else if (name.equals("Baleful Strike"))
		{
			base = base.replaceAll("Ability Power bonus: .*", "");
		} else if (name.equals("Enrage"))
		{
			base = base.replaceAll("Total Health gained: .*", "");
		} else if (name.equals("Vorpal Blade"))
		{
			base = base.replace("{{ f1 }} ", "");
			base = base.replace("{{ f2 }} ", "");
			base = base.replace("restores {{ f3 }} Health", "heals 33% of normal amount");
		} else if (name.equals("Winter's Bite"))
		{
			base = base.replace("{{ f1 }} ", "");
		}
		// Replace a's and f's
		if(vars!=null){
			n = vars.size();
			SpellVars v;
			String addition = "";
			for (int i = 0; i < n; i++)
			{
				v = vars.get(i);
				String k = v.getKey();
				String s = v.getLink();
				// Special cases (THANKS RITO)
				if (s.equals("@special.BraumWArmor") || s.equals("@special.BraumWMR") || s.equals("@special.jaxrarmor")
						|| s.equals("@special.jaxrmr"))
				{
					base = base.replace("{{ " + k + " }} ", "");
				} else if (s.equals("@special.nautilusq"))
				{
					base = base.replace("({{ " + k + " }}) ", "");
				} else if (s.equals("@cooldownchampion") || s.equals("@text") || s.equals("@special.dariusr3")
						|| s.equals("@cooldownchampion"))
				{
					base = base.replace("{{ " + k + " }}", list(v.getCoeff()));
				} else if (s.equals("@special.viw"))
				{
					base = base.replace("{{ " + k + " }}", "1% per " + list(v.getCoeff()) + " bonus Attack Damage");
				} else if (s.equals("@stacks"))
				{
					base = base.replace("{{ " + k + " }}", list(v.getCoeff()) + " per stack");
				} else if (s.equals("@dynamic.attackdamage"))
				{
					if (spell.getName().equals("Savagery"))
					{
						base = base.replace("({{ " + k + " }}) ", "");
					} else
					{
						base = base.replace("{{ " + k + " }}", "(+" + listPercent(v.getCoeff()) + "% Attack Damage)");
					}
				} else if (s.equals("@dynamic.abilitypower"))
				{
					base = base.replace("{{ " + k + " }}", "(+" + listPercent(v.getCoeff()) + "% Ability Power)");
				} else
				{ // normal cases
					if (s.equals("spelldamage"))
					{
						addition = "% Ability Power";
					} else if (s.equals("attackdamage"))
					{
						addition = "% Attack Damage";
					} else if (s.equals("bonusattackdamage"))
					{
						addition = "% bonus Attack Damage";
					} else if (s.equals("bonushealth"))
					{
						addition = "% bonus Health";
					} else if (s.equals("bonusspellblock"))
					{
						addition = "% bonus Magic Resist";
					} else if (s.equals("bonusarmor"))
					{
						addition = "% bonus Armor";
					} else if (s.equals("armor"))
					{
						addition = "% Armor";
					} else if (s.equals("mana"))
					{
						addition = "% maximum Mana";
					}
					base = base.replace("{{ " + k + " }}", listPercent(v.getCoeff()) + addition);
				}
			}			
		}
		return base;
	}
	
	/**
	 * Takes a summoner spell and parses the tooltip in the following way:
	 * Turns HTML breaks into newlines,
	 * removes and disregards other HTML formatting, and
	 * replaces all variables in the spell tooltip with corresponding numbers from the API.
	 * <p>
	 * The returned String is clean and ready to be displayed.
	 * 
	 * @author Alexa
	 * @param spell the SummonerSpell object from which to parse the tooltip
	 * @return a String of the parsed tooltip
	 */
	public static String parse(SummonerSpell spell)
	{
		String base = spell.getTooltip();
		List<SpellVars> vars = spell.getVars();
		int n = vars.size();
		// Remove HTML formatting
		base = base.replaceAll("<br>", "\n");
		base = base.replaceAll("(<[^>]*>)?", "");
		// Replace variables
		for (int i = 0; i < n; i++)
		{
			base = base.replace("{{ " + vars.get(i).getKey() + " }}", list(vars.get(i).getCoeff()));
		}
		return base;
	}

	/**
	 * Takes a list from the API of the form [a, b, c, ...]
	 * (typically a, b, c, ... are numbers) and turns it into
	 * the form a/b/c/...
	 * 
	 * @param o the list from the API to format
	 * @return the formatted list with slashes in between numbers
	 */
	private static String list(Object o)
	{
		String str = o.toString();
		str = str.replace("[", "");
		str = str.replace("]", "");
		str = str.replace(",", "/");
		return str;
	}

	/**
	 * Takes a list from the API of the form [a, b, c, ...]
	 * where a, b, and c are decimal representations of percentages
	 * and turns it into x/y/z/... where x, y, and z are the percentage
	 * representations.
	 * <p>
	 * For example, turns [0.1, 0.15, 0.2] into 10/15/20
	 * 
	 * @param o the decimal list from the API to format
	 * @return the formatted list in percentages with slashes in between numbers
	 */
	private static String listPercent(Object o)
	{
		// Need to turn decimals to percentages
		String str = o.toString();
		String result = "";
		int last;
		double value;
		// Remove [
		str = str.substring(1);
		// Start parsing
		last = str.indexOf(',');
		// Get inner parts (one value of [x] will skip this step)
		while (last > 0)
		{
			value = Double.parseDouble(str.substring(0, last));
			result = result + (int) (value * 100) + '/';
			str = str.substring(last + 1);
			last = str.indexOf(',');
		}
		// Get last part (])
		last = str.indexOf(']');
		value = Double.parseDouble(str.substring(0, last));
		result = result + (int) (value * 100);

		return result;
	}

	/**
	 * Turns HTML breaks into newlines.
	 * Removes and disregards other HTML formatting.
	 * 
	 * @param str the string to parse
	 * @return the given string without HTML formatting
	 */
	public static String parseOutHtml(String str)
	{
		str = str.replaceAll("<br>", "\n");
		str = str.replaceAll("(<[^>]*>)?", "");
		return str;
	}

	/**
	 * Returns the cost and resource of a champion spell using the cost
	 * variable given in the API.
	 * 
	 * Example: 10/20/25 Mana
	 * 
	 * @param spell a champion spell
	 * @return the cost and resource of the given spell
	 */
	public static String parseResource(ChampionSpell spell)
	{
		String str = spell.getResource();
		String cost = spell.getCostBurn();
		str = str.replace("{{ cost }}", cost);
		return str;
	}

	/*
	 * ********************************
	 * End of Utility Functions
	 * ********************************
	 */
	/*
	 * ********************************
	 * Start of Champion API Data
	 * ********************************
	 */
	public static String[] getFreeChampionList()
	{
		RiotAPI api = new RiotAPI("na");
		JsonElement APIReturn = api.GetLiveChampions(true);
		JsonArray Champions = APIReturn.getAsJsonObject().getAsJsonArray("champions");
		api = null;

		String[] ChampList = new String[Champions.size()];
		for (int i = 0; i < Champions.size(); i++)
		{
			ChampList[i] = getChampionNameByID(Champions.get(i).getAsJsonObject().get("id").getAsInt());
		}
		return ChampList;
	}

	/*
	 * ********************************
	 * End of Champion API Data
	 * ********************************
	 */
	/*
	 * ********************************
	 * Start of Summoner API Data
	 * ********************************
	 */
	public static Summoner getSummonerByName(String name)
	{
		RiotAPI api = new RiotAPI("na");
		JsonElement summoner = api.GetSummonerByName(name);
		api = null;
		try
		{
			Summoner s = new Gson().fromJson(summoner.toString(), Summoner.class);
			return s;
		} catch (Exception e)
		{
			// Should probably at least do some logging, but not worried about that right now.
			return null;
		}
	}

	/*
	 * ********************************
	 * End of Summoner API Data
	 * ********************************
	 */
	/*
	 * ********************************
	 * Start of Stats API Data
	 * ********************************
	 */
	public static RankedStats getRankedStatsByID(int id)
	{
		RiotAPI api = new RiotAPI("na");
		JsonElement ranked = api.GetRankedStatsByID(id);
		api = null;

		try
		{
			RankedStats s = new Gson().fromJson(ranked, RankedStats.class);
			return s;
		} catch (Exception e)
		{
			// Should probably at least do some logging, but not worried about that right now.
		}
		return null;
	}

	public static RankedStats getRankedStatsByName(String name)
	{
		RiotAPI api = new RiotAPI("na");
		try
		{
			Summoner s = getSummonerByName(name);
			JsonElement ranked = api.GetRankedStatsByID(Integer.valueOf(parseID(s.getId())));
			RankedStats rs = new Gson().fromJson(ranked, RankedStats.class);
			return rs;
		} catch (Exception e)
		{
			// Should probably at least do some logging, but not worried about that right now.
		}
		return null;
	}

	public static PlayerStatsSummaryList getSummaryStatsByID(int id)
	{
		RiotAPI api = new RiotAPI("na");
		JsonElement summary = api.GetSummaryStatsByID(id);
		api = null;

		try
		{
			PlayerStatsSummaryList s = new Gson().fromJson(summary, PlayerStatsSummaryList.class);
			return s;
		} catch (Exception e)
		{
			// Should probably at least do some logging, but not worried about that right now.
			return null;
		}
	}

	public static PlayerStatsSummaryList getSummaryStatsByName(String name)
	{
		PlayerStatsSummaryList rs;

		RiotAPI api = new RiotAPI("na");
		try
		{
			Summoner s = getSummonerByName(name);
			JsonElement summary = api.GetSummaryStatsByID((int) s.getId());
			rs = new Gson().fromJson(summary, PlayerStatsSummaryList.class);
			return rs;
		} catch (Exception e)
		{
			// Should probably at least do some logging, but not worried about that right now.
			return null;
		}
	}

	public static String parseID(Object o)
	{
		String str = o.toString();
		str = str.replace(".", "");
		str = str.substring(0, str.length() - 2);
		return str;
	}
	/*
	 * ********************************
	 * End of Stats API Data
	 * ********************************
	 */
}
