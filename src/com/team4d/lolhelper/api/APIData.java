package com.team4d.lolhelper.api;

import java.util.Arrays;
import java.util.List;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.team4d.lolhelper.api.database.LOLSQLiteHelper;
import com.team4d.lolhelper.api.dto.staticdata.SpellVars;
import com.team4d.lolhelper.api.dto.staticdata.champion.Champion;
import com.team4d.lolhelper.api.dto.staticdata.champion.ChampionSpell;
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
	
	public static String parse(ChampionSpell spell){
		String base = spell.getTooltip();
		List<String> e = spell.getEffectBurn();
		List<SpellVars> vars = spell.getVars();
		//Remove HTML formatting
		base = base.replaceAll("<br>", "\n");
		base = base.replaceAll("(<(.[^>])*>)?", "");
		base = base.replaceAll("</span>", "");
		//Replace e's
		int n = e.size();
		for(int i=0; i<n; i++){
			base = base.replace("{{ e" + i + " }}", e.get(i));
		}
		//Replace a's and f's
		n = vars.size();
		SpellVars v;
		String addition = "";
		for(int i=0; i<n; i++){
			v = vars.get(i);
			String k = v.getKey();
			String s = v.getLink();
			//Special cases (THANKS RITO)
			if(s.equals("@special.BraumWArmor") || s.equals("@special.BraumWMR") || s.equals("@special.jaxrarmor") || s.equals("@special.jaxrmr")){
				base = base.replace("{{ " + k + " }} ", "");
			} else if(s.equals("@special.nautilusq")){
				base = base.replace("({{ " + k + " }}) ", "");
			} else if(s.equals("@cooldownchampion") || s.equals("@text") || s.equals("@special.dariusr3") || s.equals("@cooldownchampion")){
				base = base.replace("{{ " + k + " }}", list(v.getCoeff()));
			} else if(s.equals("@special.viw")){
				base = base.replace("{{ " + k + " }}", "1% per " + list(v.getCoeff()) + " bonus Attack Damage");
			} else if(s.equals("@stacks")){
				base = base.replace("{{ " + k + " }}", list(v.getCoeff()) + " per stack");
			} else if(s.equals("@dynamic.attackdamage")){
				if(spell.getName().equals("Savagery")){
					base = base.replace("({{ " + k + " }}) ", "");
				} else {
					base = base.replace("{{ " + k + " }}", "+" + listPercent(v.getCoeff()) + "% of Attack Damage");
				}
			} else if(s.equals("@dynamic.abilitypower")){
				base = base.replace("{{ " + k + " }}", "+" + listPercent(v.getCoeff()) + "% of Ability Power");
			} else { // normal cases
				if(s.equals("spelldamage")){
					addition = "% Ability Power";
				} else if(s.equals("attackdamage")){
					addition = "% Attack Damage";
				} else if(s.equals("bonusattackdamage")){
					addition = "% bonus Attack Damage";
				} else if(s.equals("bonushealth")){
					addition = "% bonus Health";
				} else if(s.equals("bonusspellblock")){
					addition = "% bonus Magic Resist";
				} else if(s.equals("bonusarmor")){
					addition = "% bonus Armor";
				} else if(s.equals("armor")){
					addition = "% Armor";
				} else if(s.equals("mana")){
					addition = "% maximum Mana";
				}
				base = base.replace("{{ " + k + " }}", listPercent(v.getCoeff()) + addition);
			}
		}
		//Replace f's (individual cases)
		if(spell.getName().equals("Flay")){
			base = base.replace("{{ f1 }}-{{ f2 }} ", "");
		} else if(spell.getName().equals("Blood Thirst / Blood Price")){
			base = base.replace("({{ f5 }}) ", "");
			base = base.replace("{{ f4 }} ", "");
		}
		return base;
	}
	
	public static String parse(SummonerSpell spell){
		String base = spell.getTooltip();
		List<SpellVars> vars = spell.getVars();
		int n = vars.size();
		for(int i=0; i<n; i++){
			base = base.replace("{{ " + vars.get(i).getKey() + " }}", vars.get(i).getCoeff().toString());
		}
		//Remove HTML formatting
		base = base.replaceAll("<br>", "\n");
		base = base.replaceAll("(<(.[^>])*>)?", "");
		base = base.replaceAll("</span>", "");
		return base;
	}
	
	private static String list(Object o){
		return o.toString();
	}
	
	private static String listPercent(Object o){
		return o.toString();
	}
}
