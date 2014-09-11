package com.fourfoureight.lolhelper.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RiotAPI
{
	private static final String APIKey = "api_key=f685bd80-568e-4ff3-9d20-4bde13ab7106";
	/**
	 * TODO: Update to handle multiple regions.
	 */
	private static String BaseAPIAddress = "https://na.api.pvp.net/api/lol/";

	/**
	 * Private constructor to prevent initialization of static class.
	 */
	private RiotAPI()
	{
	}

	/**
	 * Takes a string (which represents a URL), opens the URL connection and input stream, then converts the entire
	 * contents of the result of the UR to a JSONObject. All other methods in this class call this method.
	 * 
	 * @param APIQuery
	 *            The String representing the Riot API URL for the desired call.
	 * @return
	 *         A JSONObject containing the results of the Riot API call.
	 */
	private static JSONObject CallAPIObject(String APIQuery)
	{
		try
		{
			String APIResult;
			URL APIQueryURL = new URL(APIQuery);
			InputStream APIQueryIS = APIQueryURL.openStream();
			Scanner scan = new Scanner(APIQueryIS);
			APIResult = scan.useDelimiter("\\A").next();
			scan.close();
			APIQueryIS.close();
			JSONObject APIResultJSON;

			try
			{
				APIResultJSON = new JSONObject(APIResult);
				return APIResultJSON;
			} catch (JSONException e)
			{
				return null;
			}

		} catch (IOException e)
		{
			return null;
		}
	}

	/**
	 * Takes a string (which represents a URL), opens the URL connection and input stream, then converts the entire
	 * contents of the result of the UR to a JSONObject. All other methods in this class call this method.
	 * 
	 * @param APIQuery
	 *            The String representing the Riot API URL for the desired call.
	 * @return
	 *         A JSONArray containing the results of the Riot API call.
	 */
	private static JSONArray CallAPIArray(String APIQuery)
	{
		try
		{
			String APIResult;
			URL APIQueryURL = new URL(APIQuery);
			InputStream APIQueryIS = APIQueryURL.openStream();
			Scanner scan = new Scanner(APIQueryIS);
			APIResult = scan.useDelimiter("\\A").next();
			scan.close();
			APIQueryIS.close();
			JSONArray APIResultJSON;

			try
			{
				APIResultJSON = new JSONArray(APIResult);
				return APIResultJSON;
			} catch (JSONException e)
			{
				return null;
			}

		} catch (IOException e)
		{
			return null;
		}
	}

	/*
	 * Beginning of Static API Queries
	 */
	private static String StaticDataAPIAddress = "static-data/na/v1.2/";

	public static JSONObject GetChampions()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "champion?champData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetChampion(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "champion/" + id + "?champData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetItems()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "item?itemListData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetItem(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "item/" + id + "?itemData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetMasteries()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "mastery?masteryListData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetMastery(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "mastery/" + id + "?masteryData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetRealm()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "realm?" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetRunes()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "rune?runeListData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetRune(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "rune/" + id + "?runedata=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetSummonerSpells()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "summoner-spell?spellData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONObject GetSummonerSpell(int id)
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "summoner-spell/" + id + "?spellData=all&" + APIKey;
		return CallAPIObject(APIQuery);
	}

	public static JSONArray GetVersions()
	{
		String APIQuery = BaseAPIAddress + StaticDataAPIAddress + "versions?" + APIKey;
		return CallAPIArray(APIQuery);
	}
	/*
	 * End of Static API Queries
	 */

}