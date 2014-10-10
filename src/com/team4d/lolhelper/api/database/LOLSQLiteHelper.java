package com.team4d.lolhelper.api.database;

import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.team4d.lolhelper.api.RiotAPI;

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

	private final Context con;

	// Private constructor, should ONLY EVER be called from getInstance() to be a proper singleton.
	private LOLSQLiteHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		con = context;
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

			RiotAPI api = new RiotAPI("na");
			// RiotAPI api = new RiotAPI(con.getRegion());
			JsonElement vo = api.GetVersions();
			String apiversion;
			apiversion = vo.getAsJsonArray().get(0).toString().replaceAll("'", "''");
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
		 * Grab all of the static data from the api as JsonElements
		 */
		RiotAPI api = new RiotAPI("na");

		/*
		 * Creates the champions db table
		 */
		JsonObject Champions = api.GetChampions().getAsJsonObject();
		JsonObject ChampionKeys = Champions.get("keys").getAsJsonObject();
		JsonObject ChampionData = Champions.getAsJsonObject("data");

		String CreateChampionsTable = "CREATE TABLE champions(_id INTEGER PRIMARY KEY, name TEXT, key TEXT, json TEXT)";
		database.execSQL(CreateChampionsTable);

		for (Map.Entry<String, JsonElement> entry : ChampionKeys.entrySet())
		{
			String key = entry.getValue().getAsString();
			JsonObject champ = ChampionData.getAsJsonObject(key);
			int id = champ.get("id").getAsInt();
			String name = champ.get("name").getAsString();

			String LoadChamp = "INSERT INTO champions (_id, name, key, json) VALUES (" + id + ", '"
					+ name.replaceAll("'", "''") + "', '" + key + "', '" + champ.toString().replaceAll("'", "''")
					+ "');";
			database.execSQL(LoadChamp);
		}

		Champions = null;
		ChampionKeys = null;
		ChampionData = null;
		CreateChampionsTable = null;

		/*
		 * Creates the items db table
		 */
		JsonObject Items = api.GetItems().getAsJsonObject();
		JsonObject ItemData = Items.get("data").getAsJsonObject();
		String CreateItemsTable = "CREATE TABLE items(_id INTEGER PRIMARY KEY, name TEXT, json TEXT)";
		database.execSQL(CreateItemsTable);

		for (Map.Entry<String, JsonElement> entry : ItemData.entrySet())
		{
			JsonObject Item = entry.getValue().getAsJsonObject();
			int id = Item.get("id").getAsInt();
			String name = Item.get("name").getAsString().replaceAll("'", "''");

			String LoadItem = "INSERT INTO items (_id, name, json) VALUES (" + id + ", '" + name.replaceAll("'", "''")
					+ "', '" + Item.toString().replaceAll("'", "''") + "');";
			database.execSQL(LoadItem);
		}

		Items = null;
		ItemData = null;
		CreateItemsTable = null;

		/*
		 * Create the masteries db table
		 * Currently doesn't save the tree shape
		 */
		JsonObject Masteries = api.GetMasteries().getAsJsonObject();
		String CreateMasteriesTable = "CREATE TABLE masteries(_id INTEGER PRIMARY KEY, name TEXT, json TEXT)";
		database.execSQL(CreateMasteriesTable);

		JsonObject MasteryData = Masteries.get("data").getAsJsonObject();

		for (Map.Entry<String, JsonElement> entry : MasteryData.entrySet())
		{
			JsonObject Mastery = entry.getValue().getAsJsonObject();
			int id = Mastery.get("id").getAsInt();
			String name = Mastery.get("name").getAsString();

			String LoadMastery = "INSERT INTO masteries (_id, name, json) VALUES (" + id + ", '"
					+ name.replaceAll("'", "''") + "', '" + Mastery.toString().replaceAll("'", "''") + "');";
			database.execSQL(LoadMastery);
		}

		Masteries = null;
		CreateMasteriesTable = null;

		/*
		 * Create the runes db table
		 */
		JsonObject Runes = api.GetRunes().getAsJsonObject();
		String CreateRunesTable = "CREATE TABLE runes(_id INTEGER PRIMARY KEY, name TEXT, json TEXT)";
		database.execSQL(CreateRunesTable);

		JsonObject RuneData = Runes.get("data").getAsJsonObject();

		for (Map.Entry<String, JsonElement> entry : RuneData.entrySet())
		{
			JsonObject Rune = entry.getValue().getAsJsonObject();
			int id = Rune.get("id").getAsInt();
			String name = Rune.get("name").getAsString();

			String LoadRune = "INSERT INTO runes (_id, name, json) VALUES (" + id + ", '" + name.replaceAll("'", "''")
					+ "', '" + Rune.toString().replaceAll("'", "''") + "');";
			database.execSQL(LoadRune);
		}

		Runes = null;
		CreateRunesTable = null;

		/*
		 * Create the summonerspells db table
		 */
		JsonObject SummonerSpells = api.GetSummonerSpells().getAsJsonObject();
		String CreateSummonerSpellsTable = "CREATE TABLE summonerspells(_id INTEGER PRIMARY KEY AUTOINCREMENT, key TEXT, name TEXT, json TEXT)";
		database.execSQL(CreateSummonerSpellsTable);

		JsonObject SummonerSpellData = SummonerSpells.get("data").getAsJsonObject();

		for (Map.Entry<String, JsonElement> entry : SummonerSpellData.entrySet())
		{
			JsonObject SummonerSpell = entry.getValue().getAsJsonObject();
			String key = SummonerSpell.get("key").getAsString();
			String name = SummonerSpell.get("name").getAsString();

			String LoadSummonerSpell = "INSERT INTO summonerspells (key, name, json) VALUES ('" + key + "', '"
					+ name.replaceAll("'", "''") + "', '" + SummonerSpell.toString().replaceAll("'", "''") + "');";
			database.execSQL(LoadSummonerSpell);
		}

		SummonerSpells = null;
		CreateSummonerSpellsTable = null;

		/*
		 * Create the realms db table
		 */
		/**
		 * TODO: Update to add info for all realms.
		 */
		JsonObject Realm = api.GetRealm().getAsJsonObject();
		String CreateRealmsTable = "CREATE TABLE realms(_id INTEGER PRIMARY KEY AUTOINCREMENT, json TEXT)";
		database.execSQL(CreateRealmsTable);

		String LoadRealm = "INSERT INTO realms (json) VALUES ('" + Realm.toString() + "');";
		database.execSQL(LoadRealm);

		CreateRealmsTable = null;
		LoadRealm = null;
		Realm = null;

		/*
		 * Create the versions db table
		 */
		String CreateVersionsTable = "CREATE TABLE versions(_id INTEGER PRIMARY KEY AUTOINCREMENT, version TEXT)";
		database.execSQL(CreateVersionsTable);

		JsonArray Versions = api.GetVersions().getAsJsonArray();
		for (int i = 0; i < Versions.size(); i++)
		{
			String LoadVersion = "INSERT INTO versions (version) VALUES ('" + Versions.get(i) + "');";
			database.execSQL(LoadVersion);
		}

		Versions = null;
		CreateVersionsTable = null;
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
