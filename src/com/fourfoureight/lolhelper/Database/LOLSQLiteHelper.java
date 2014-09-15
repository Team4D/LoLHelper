package com.fourfoureight.lolhelper.Database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fourfoureight.lolhelper.api.RiotAPI;

/**
 * @author KaosuRyoko
 *         Defines a singleton SQLite Helper. Allows us to have multithreaded database access without conflict, as all
 *         simultaneous commands get queued and processes sequentially internally.
 */
public class LOLSQLiteHelper extends SQLiteOpenHelper
{
	// THE only instance of the db helper.
	private static LOLSQLiteHelper instance;

	private static final String DATABASE_NAME = "lolhelper.db";
	private static final int DATABASE_VERSION = 1;

	// Private constructor, should ONLY EVER be called from getInstance() to be a proper singleton.
	private LOLSQLiteHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public static synchronized LOLSQLiteHelper getInstance(Context context)
	{
		if (instance == null)
		{
			instance = new LOLSQLiteHelper(context);
		}
		return instance;
	}

	@Override
	public SQLiteDatabase getWritableDatabase()
	{
		SQLiteDatabase db = super.getWritableDatabase();
		Cursor dbcursor = db.query("versions", new String[] { "version" }, "_id = 1", null, null, null, null, null);

		if (dbcursor.getCount() > -1)
		{
			dbcursor.moveToFirst();
			String dbversion = dbcursor.getString(dbcursor.getColumnIndex("version"));

			JSONArray vo = RiotAPI.GetVersions();
			String apiversion;
			try
			{
				apiversion = vo.getString(0);
			} catch (JSONException e)
			{
				apiversion = e.getMessage();
			}
			if (dbversion.compareTo(apiversion) != 0)
			{
				onUpgrade(db, 1, 1);
			}
		}

		return db;
	}

	@Override
	public void onCreate(SQLiteDatabase database)
	{
		/*
		 * Grab all of the static data from the api as JSONObjects
		 */
		JSONObject Champions = RiotAPI.GetChampions();
		JSONObject Items = RiotAPI.GetItems();
		JSONObject Masteries = RiotAPI.GetMasteries();
		JSONObject Runes = RiotAPI.GetRunes();
		JSONObject SummonerSpells = RiotAPI.GetSummonerSpells();
		JSONObject Realm = RiotAPI.GetRealm();
		JSONArray Versions = RiotAPI.GetVersions();

		/*
		 * Creates the champions db table
		 * image is stored as a JSONObject
		 * info is stored as a JSONObject
		 * passive is stored as a JSONObject
		 * recommended is stored as a JSONArray of JSONObjects
		 * skins is stored as a JSONArray of JSONObjects
		 * spells is stored as a JSONArray of JSONObjects
		 * stats is stored as a JSONObject
		 */
		String CreateChampionsTable = "CREATE TABLE champions(_id INTEGER PRIMARY KEY, " +
				"name TEXT, key TEXT, title TEXT, blurb TEXT, lore TEXT, tags TEXT, allytips TEXT, enemytips TEXT, " +
				"image TEXT, info TEXT, partype TEXT, passive TEXT, recommended TEXT, skins TEXT, " +
				"spells TEXT, stats TEXT)";
		database.execSQL(CreateChampionsTable);
		/*
		 * Creates the items db table:
		 * fromitem is stored as a JSONArray of Strings
		 * gold is stored as a JSONObject
		 * image is stored as a JSONObject
		 * intoitem is stored as a JSONArray of Strings
		 * maps is stored as a JSONObject
		 * rune is stored as a JSONObject
		 * stats is stored as a JSONObject - This might be worth saving in it's own table instead in the future
		 * tags is stored as a JSONArray of Strings
		 */
		String CreateItemsTable = "CREATE TABLE items(_id INTEGER PRIMARY KEY, " +
				"name TEXT, plaintext TEXT, description TEXT, sanitizeddescription TEXT, " +
				"image TEXT, colloq TEXT, consumeonfull TEXT, consumed TEXT, depth INTEGER, fromitem TEXT, " +
				"gold TEXT, groupname TEXT, hidefromall TEXT, instore TEXT, intoitem TEXT, maps TEXT, " +
				"requiredchampion TEXT, rune TEXT, specialrecipe INTEGER, stacks INTEGER, " +
				"stats TEXT, tags TEXT)";
		database.execSQL(CreateItemsTable);
		/*
		 * Create the masteries db table:
		 * Note: Doesn't explicitly store tree data
		 * image is storedas a JSONObject
		 */
		String CreateMasteriesTable = "CREATE TABLE masteries(_id INTEGER PRIMARY KEY, " +
				"name TEXT, description TEXT, sanitizeddescription TEXT, prereq TEXT, ranks INTEGER, " +
				"image TEXT)";
		database.execSQL(CreateMasteriesTable);
		/*
		 * Create the runes db table:
		 * fromrune is stored as a JSONArray of Strings
		 * gold is stored as a JSONObject
		 * image is stored as a JSONObject
		 * intorune is stored as a JSONArray of Strings
		 * maps is stored as a JSONObject
		 * rune is stored as a JSONObject
		 * stats is stored as a JSONObject - This might be worth saving in it's own table instead in the future
		 * tags is stored as a JSONArray of Strings
		 */
		String CreateRunesTable = "CREATE TABLE runes(_id INTEGER PRIMARY KEY, " +
				"name TEXT, plaintext TEXT, description TEXT, sanitizeddescription TEXT, " +
				"image TEXT, colloq TEXT, consumeonfull TEXT, consumed TEXT, depth INTEGER, fromrune TEXT, " +
				"gold TEXT, groupname TEXT, hidefromall TEXT, instore TEXT, intorune TEXT, maps TEXT, " +
				"requiredchampion TEXT, rune TEXT, specialrecipe INTEGER, stacks INTEGER, " +
				"stats TEXT, tags TEXT)";
		database.execSQL(CreateRunesTable);
		/*
		 * Create the summonerspells db table:
		 * cooldown is stored as a JSONArray of doubles
		 * cost is stored as a JSONArray of integers
		 * effect is stored as a JSONArray of JSONObjects (List of List of doubles)
		 * effectburn is stored as a JSONArray of Strings
		 * image is stored as a JSONObject String
		 * leveltip is stored as a JSONObject
		 * modes is stored as a JSONArray of Strings
		 * range is stored as a JSONObject (Is either a JSONArray of integers, or the string self)
		 * vars is stored as a JSONObject
		 */
		String CreateSummonerSpellsTable = "CREATE TABLE summonerspells(_id INTEGER PRIMARY KEY, "
				+
				"key TEXT, name TEXT, description TEXT, sanitizeddescription TEXT, tooltip TEXT, sanitizedtooltip TEXT, "
				+
				"image TEXT, cooldown TEXT, cooldownburn TEXT, cost TEXT, costburn TEXT, costtype TEXT, effect TEXT, "
				+
				"effectburn TEXT, leveltip TEXT, maxrank INTEGER, modes TEXT, range TEXT, rangeburn TEXT, resource TEXT, "
				+
				"summonerLevel INTEGER, vars TEXT)";
		database.execSQL(CreateSummonerSpellsTable);
		/*
		 * Create the realms db table
		 */
		String CreateRealmsTable = "CREATE TABLE realms(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"language TEXT, version TEXT, ddragonurl TEXT, ddragoncss TEXT, ddragonversion TEXT)";
		database.execSQL(CreateRealmsTable);
		/*
		 * Create the versions db table
		 */
		String CreateVersionsTable = "CREATE TABLE versions(_id INTEGER PRIMARY KEY AUTOINCREMENT, version TEXT)";
		database.execSQL(CreateVersionsTable);

		/*
		 * Load the version db table
		 */
		for (int i = 0; i < Versions.length(); i++)
		{
			try
			{
				String LoadVersion = "INSERT INTO versions (version) VALUES ('" + Versions.getString(i) + "');";
				database.execSQL(LoadVersion);
			} catch (JSONException e)
			{
				String LoadVersion = "INSERT INTO versions (version) VALUES ('" + e.getMessage() + "');";
				database.execSQL(LoadVersion);
			}
		}

	}

	/**
	 * Called when the database version number is updated.
	 * TODO: Find a better method than completely dropping all tables and rebuilding them.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		/*
		 * Drop all tables and rebuild.
		 */
		db.execSQL("DROP TABLE IF EXISTS champion");
		db.execSQL("DROP TABLE IF EXISTS item");
		db.execSQL("DROP TABLE IF EXISTS masteries");
		db.execSQL("DROP TABLE IF EXISTS runes");
		db.execSQL("DROP TABLE IF EXISTS summonerspells");
		db.execSQL("DROP TABLE IF EXISTS realms");
		db.execSQL("DROP TABLE IF EXISTS versions");

		onCreate(db);
	}
}
