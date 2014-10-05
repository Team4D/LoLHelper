package com.team4d.lolhelper.stats;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class StatSummary
{
	private final Map<String, Long> fields;
	private final JSONObject aggregatedStats;

	public StatSummary(JSONObject aggregatedStats)
	{
		this.fields = new HashMap<String, Long>();
		this.aggregatedStats = aggregatedStats;
	}

	public long getField(String fieldName)
	{
		return fields.get(fieldName);
	}

	public void addField(String name, long field)
	{
		fields.put(name, field);
	}

	public boolean hasField(String fieldName)
	{
		return fields.containsKey(fieldName);
	}

	public int getAggregatedStat(String statName) throws JSONException
	{
		return aggregatedStats.getInt(statName);
	}

	public boolean hasAggregatedStats()
	{
		return !aggregatedStats.toString().equals("{}");
	}
}