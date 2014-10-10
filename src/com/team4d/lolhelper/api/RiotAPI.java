package com.team4d.lolhelper.api;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class RiotAPI
{
	private static final String APIKey = "api_key=434900e3-6801-47cb-b669-31cff23af9f6";
	private static String BaseAPIAddress;
	private static String StaticDataAPIAddress;
	private static String ChampionAPIAddress;

	/**
	 * Private constructor to prevent initialization of static class.
	 */
	public RiotAPI(String region)
	{
		BaseAPIAddress = "https://" + region + ".api.pvp.net/api/lol/";
		StaticDataAPIAddress = "static-data/" + region + "/v1.2/";
		ChampionAPIAddress = region + "/v1.2/champion";
	}

	/**
	 * Takes a string (which represents a URL), opens the URL connection and input stream, then converts the entire
	 * contents of the result of the UR to a JSONElement. All other methods in this class call this method.
	 * 
	 * @param APIQuery
	 *            The String representing the Riot API URL for the desired call.
	 * @return
	 *         A JSONElement containing the results of the Riot API call.
	 */
	private static JsonElement CallAPI(String APIQuery)
	{
		try
		{
			String APIString;
			URL APIQueryURL = new URL(APIQuery);
			InputStream APIQueryIS = APIQueryURL.openStream();
			Scanner scan = new Scanner(APIQueryIS);
			APIString = scan.useDelimiter("\\A").next();
			scan.close();
			APIQueryIS.close();

			JsonElement APIResult;

			APIResult = new JsonParser().parse(APIString);

			return APIResult;

		} catch (Exception e)
		{
			return null;
		}
	}

	/*
	 * ********************************
	 * Beginning of Static API Queries
	 * ********************************
	 */
	public JsonElement GetChampions()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "champion?champData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetChampion(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "champion/" + id + "?champData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetItems()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "item?itemListData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetItem(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "item/" + id + "?itemData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetMasteries()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "mastery?masteryListData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetMastery(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "mastery/" + id + "?masteryData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetRealm()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "realm?" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetRunes()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "rune?runeListData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetRune(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "rune/" + id + "?runedata=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetSummonerSpells()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "summoner-spell?spellData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetSummonerSpell(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "summoner-spell/" + id + "?spellData=all&" + APIKey;
		return CallAPI(APIQuery);
	}

	public JsonElement GetVersions()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "versions?" + APIKey;
		return CallAPI(APIQuery);
	}

	/*
	 * ********************************
	 * End of Static API Queries
	 * ********************************
	 */

	/*
	 * ********************************
	 * Beginning of Champion API Queries
	 * ********************************
	 */
	public JsonElement GetLiveChampions(boolean free)
	{
		String APIQuery = BaseAPIAddress + ChampionAPIAddress + "?freeToPlay=";
		if (free)
		{
			APIQuery = APIQuery + "true";
		}
		else
		{
			APIQuery = APIQuery + "false";
		}
		APIQuery = APIQuery + "&" + APIKey;

		return CallAPI(APIQuery);

	}
	/*
	 * ********************************
	 * End of Champion API Queries
	 * ********************************
	 */
}