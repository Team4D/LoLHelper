package com.fourfoureight.lolhelper.Stats;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;

public class SummonerStats {
	private Map<String, StatSummary> summaries;

	// Process the JSON data in the given InputStream into the summaries Map.
	@SuppressLint("NewApi")
	private void parseSummaries(InputStream stream) throws JSONException {
		String contents = new Scanner(stream).useDelimiter("\\A").next();
		JSONObject jsonObject    = new JSONObject(contents);
		JSONArray  jsonSummaries = jsonObject.getJSONArray("playerStatSummaries");
			
		// Extract all the summaries
		for (int i = 0; i < jsonSummaries.length(); ++i) {
			JSONObject  jsonSummary = jsonSummaries.getJSONObject(i);
			String      summaryType = jsonSummary.get("playerStatSummaryType").toString();

			@SuppressWarnings("unchecked")
			Iterator<String> it = jsonSummary.keys();
			
			JSONObject aggregatedStats = null;
			
			// Extract aggregatedStats if they exist
			if (!jsonSummary.get("aggregatedStats").equals("{}")) {
				aggregatedStats = jsonSummary.getJSONObject("aggregatedStats");
			}
				
			StatSummary summary = new StatSummary(aggregatedStats);
			
			// Add everything else to the summary (skipping over aggregatedStats and playerStatSummaryType
			// since we already have those).
			while (it.hasNext()) {
				String entry = it.next();
				if (entry.equals("aggregatedStats") || entry.equals("playerStatSummaryType")) {
					continue;
				}
				summary.addField(entry, jsonSummary.getInt(entry));
			}
			summaries.put(summaryType, summary);
		}
	}
	
	public SummonerStats(InputStream stream) throws JSONException {
		this.summaries = new HashMap<String, StatSummary>();
		parseSummaries(stream);
	}
	
	public boolean hasSummary(String summaryType) {
		return summaries.containsKey(summaryType);
	}
	
	public Set<String> summaryTypeSet() {
		return summaries.keySet();
	}
	
	public StatSummary getSummary(String summaryType) {
		return summaries.get(summaryType);
	}
}