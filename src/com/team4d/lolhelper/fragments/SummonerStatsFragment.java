package com.team4d.lolhelper.fragments;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.stats.PlayerStatsSummary;
import com.team4d.lolhelper.api.dto.stats.PlayerStatsSummaryList;
import com.team4d.lolhelper.api.dto.summoner.Summoner;

public class SummonerStatsFragment extends Fragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_summonerstats, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		final Context c = this.getActivity();
		final View v = this.getView();
		final Activity activity = this.getActivity();

		// Set OnKeyListener to detect Enter and begin pulling data
		final EditText SummonerNameEditText = (EditText) this.getView().findViewById(R.id.SummonerNameEditText);
		SummonerNameEditText.setOnKeyListener(new View.OnKeyListener()
		{
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event)
			{
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
				{
					hideKeyboard(v);
					String summonername = SummonerNameEditText.getText().toString();
					if (summonername.isEmpty())
					{
						return false;
					}

					new SummonerStatsAsyncTask(c, v, activity, summonername).execute(summonername);
					return true;
				}

				return false;
			}
		});

		// OnClickListener to begin pulling data when Enter button pressed.
		Button enter = (Button) this.getView().findViewById(R.id.enter);
		enter.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				hideKeyboard(v);
				String summonername = SummonerNameEditText.getText().toString();
				if (summonername.isEmpty())
				{
					return;
				}
				new SummonerStatsAsyncTask(c, v, activity, summonername).execute(summonername);
			};

		});
	}

	public void hideKeyboard(View view)
	{
		InputMethodManager inputManager = (InputMethodManager) this.getActivity().getSystemService(
				Context.INPUT_METHOD_SERVICE);

		// check if no view has focus:
		View v = this.getActivity().getCurrentFocus();
		if (v == null)
			return;

		inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	}

	private class SummonerStatsAsyncTask extends AsyncTask<String, Void, JsonObject>
	{
		Context mContext;
		Activity activity;
		String name;
		View mView;

		public SummonerStatsAsyncTask(Context c, View v, Activity a, String name)
		{
			mContext = c;
			activity = a;
			mView = v;
			this.name = name;
		}

		@Override
		protected void onPreExecute()
		{
		}

		@Override
		protected JsonObject doInBackground(String... summonername)
		{
			JsonObject results = new JsonObject();
			Summoner summoner = APIData.getSummonerByName(summonername[0]);
			PlayerStatsSummaryList summonerSummary = APIData.getSummaryStatsByName(summonername[0]);
			Gson gson = new Gson();
			results.add("summoner", gson.toJsonTree(summoner, Summoner.class));
			results.add("summonerSummary", gson.toJsonTree(summonerSummary, PlayerStatsSummaryList.class));
			return results;
		}

		@Override
		protected void onProgressUpdate(Void... values)
		{
		}

		@Override
		protected void onPostExecute(JsonObject results)
		{
			if (mView == null || mView.isShown() == false)
			{
				return;
			}
			Gson gson = new Gson();
			Summoner summoner = gson.fromJson(results.get("summoner"), Summoner.class);
			PlayerStatsSummaryList summonerSummary = gson.fromJson(results.get("summonerSummary"),
					PlayerStatsSummaryList.class);
			List<PlayerStatsSummary> summary = summonerSummary.getPlayerStatSummaries();

			LinearLayout statsLayout = (LinearLayout) activity.findViewById(R.id.StatsLayout);

			// Creates the title bar with the summoner name
			TextView summonerTitle = new TextView(mContext);
			summonerTitle.setBackgroundColor(Color.parseColor("#CC151515"));
			summonerTitle.setTextColor(Color.parseColor("#FFFFFFFF"));
			summonerTitle.setGravity(Gravity.CENTER);
			summonerTitle.setTextSize(20);
			summonerTitle.setText(summoner.getName());
			summonerTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			statsLayout.addView(summonerTitle);

			// Creates the text view with the summoner level
			TextView summonerLevel = new TextView(mContext);
			summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
			summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
			summonerLevel.setGravity(Gravity.CENTER);
			summonerLevel.setTextSize(20);
			summonerLevel.setText("Summoner Level: " + (int) summoner.getSummonerLevel());
			summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			statsLayout.addView(summonerLevel);

			// Add all the game types that exist for this player! (that we want to add)
			int i = -1;

			/**
			 * Ranked Solo
			 */
			i = find("RankedSolo5x5", summary);
			if (i > -1)
			{ // exists
				TextView soloHead = new TextView(mContext);
				soloHead.setBackgroundColor(Color.parseColor("#CC404040"));
				soloHead.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloHead.setGravity(Gravity.CENTER);
				soloHead.setTextSize(20);
				soloHead.setText("Ranked Solo");
				soloHead.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloHead);
				
				TextView soloWins = new TextView(mContext);
				soloWins.setBackgroundColor(Color.parseColor("#CC151515"));
				soloWins.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloWins.setGravity(Gravity.CENTER);
				soloWins.setTextSize(20);
				soloWins.setText("Wins: " + summary.get(i).getWins());
				soloWins.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloWins);
				
				TextView soloLosses = new TextView(mContext);
				soloLosses.setBackgroundColor(Color.parseColor("#CC151515"));
				soloLosses.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloLosses.setGravity(Gravity.CENTER);
				soloLosses.setTextSize(20);
				soloLosses.setText("Losses: " + summary.get(i).getLosses());
				soloLosses.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloLosses);
				
				TextView soloKills = new TextView(mContext);
				soloKills.setBackgroundColor(Color.parseColor("#CC151515"));
				soloKills.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloKills.setGravity(Gravity.CENTER);
				soloKills.setTextSize(20);
				soloKills.setText("Kills: " + summary.get(i).getAggregatedStats().getTotalChampionKills());
				soloKills.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloKills);
				
				TextView soloAssists = new TextView(mContext);
				soloAssists.setBackgroundColor(Color.parseColor("#CC151515"));
				soloAssists.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloAssists.setGravity(Gravity.CENTER);
				soloAssists.setTextSize(20);
				soloAssists.setText("Assists: " + summary.get(i).getAggregatedStats().getTotalAssists());
				soloAssists.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloAssists);
				
				TextView soloMinions = new TextView(mContext);
				soloMinions.setBackgroundColor(Color.parseColor("#CC151515"));
				soloMinions.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloMinions.setGravity(Gravity.CENTER);
				soloMinions.setTextSize(20);
				soloMinions.setText("Minion Kills: " + summary.get(i).getAggregatedStats().getTotalMinionKills());
				soloMinions.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloMinions);
				
				TextView soloNeutrals = new TextView(mContext);
				soloNeutrals.setBackgroundColor(Color.parseColor("#CC151515"));
				soloNeutrals.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloNeutrals.setGravity(Gravity.CENTER);
				soloNeutrals.setTextSize(20);
				soloNeutrals.setText("Neutral Monster Kills: " + summary.get(i).getAggregatedStats().getTotalNeutralMinionsKilled());
				soloNeutrals.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloNeutrals);
				
				TextView soloTurrets = new TextView(mContext);
				soloTurrets.setBackgroundColor(Color.parseColor("#CC151515"));
				soloTurrets.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloTurrets.setGravity(Gravity.CENTER);
				soloTurrets.setTextSize(20);
				soloTurrets.setText("Turret Kills: " + summary.get(i).getAggregatedStats().getTotalTurretsKilled());
				soloTurrets.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloTurrets);
			}

			/**
			 * Normal
			 */
			i = find("Unranked", summary);
			if (i > -1)
			{ // exists
				TextView normalHead = new TextView(mContext);
				normalHead.setBackgroundColor(Color.parseColor("#CC404040"));
				normalHead.setTextColor(Color.parseColor("#FFFFFFFF"));
				normalHead.setGravity(Gravity.CENTER);
				normalHead.setTextSize(20);
				normalHead.setText("Normal");
				normalHead.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(normalHead);
				
				TextView soloWins = new TextView(mContext);
				soloWins.setBackgroundColor(Color.parseColor("#CC151515"));
				soloWins.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloWins.setGravity(Gravity.CENTER);
				soloWins.setTextSize(20);
				soloWins.setText("Wins: " + summary.get(i).getWins());
				soloWins.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloWins);
				
				TextView soloKills = new TextView(mContext);
				soloKills.setBackgroundColor(Color.parseColor("#CC151515"));
				soloKills.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloKills.setGravity(Gravity.CENTER);
				soloKills.setTextSize(20);
				soloKills.setText("Kills: " + summary.get(i).getAggregatedStats().getTotalChampionKills());
				soloKills.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloKills);
				
				TextView soloAssists = new TextView(mContext);
				soloAssists.setBackgroundColor(Color.parseColor("#CC151515"));
				soloAssists.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloAssists.setGravity(Gravity.CENTER);
				soloAssists.setTextSize(20);
				soloAssists.setText("Assists: " + summary.get(i).getAggregatedStats().getTotalAssists());
				soloAssists.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloAssists);
				
				TextView soloMinions = new TextView(mContext);
				soloMinions.setBackgroundColor(Color.parseColor("#CC151515"));
				soloMinions.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloMinions.setGravity(Gravity.CENTER);
				soloMinions.setTextSize(20);
				soloMinions.setText("Minion Kills: " + summary.get(i).getAggregatedStats().getTotalMinionKills());
				soloMinions.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloMinions);
				
				TextView soloNeutrals = new TextView(mContext);
				soloNeutrals.setBackgroundColor(Color.parseColor("#CC151515"));
				soloNeutrals.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloNeutrals.setGravity(Gravity.CENTER);
				soloNeutrals.setTextSize(20);
				soloNeutrals.setText("Neutral Monster Kills: " + summary.get(i).getAggregatedStats().getTotalNeutralMinionsKilled());
				soloNeutrals.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloNeutrals);
				
				TextView soloTurrets = new TextView(mContext);
				soloTurrets.setBackgroundColor(Color.parseColor("#CC151515"));
				soloTurrets.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloTurrets.setGravity(Gravity.CENTER);
				soloTurrets.setTextSize(20);
				soloTurrets.setText("Turret Kills: " + summary.get(i).getAggregatedStats().getTotalTurretsKilled());
				soloTurrets.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloTurrets);
			}

			/**
			 * Ranked 5x5
			 */
			i = find("RankedTeam5x5", summary);
			if (i > -1)
			{ // exists
				TextView ranked5Head = new TextView(mContext);
				ranked5Head.setBackgroundColor(Color.parseColor("#CC404040"));
				ranked5Head.setTextColor(Color.parseColor("#FFFFFFFF"));
				ranked5Head.setGravity(Gravity.CENTER);
				ranked5Head.setTextSize(20);
				ranked5Head.setText("Ranked 5x5");
				ranked5Head.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(ranked5Head);
				
				TextView soloWins = new TextView(mContext);
				soloWins.setBackgroundColor(Color.parseColor("#CC151515"));
				soloWins.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloWins.setGravity(Gravity.CENTER);
				soloWins.setTextSize(20);
				soloWins.setText("Wins: " + summary.get(i).getWins());
				soloWins.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloWins);
				
				TextView soloLosses = new TextView(mContext);
				soloLosses.setBackgroundColor(Color.parseColor("#CC151515"));
				soloLosses.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloLosses.setGravity(Gravity.CENTER);
				soloLosses.setTextSize(20);
				soloLosses.setText("Losses: " + summary.get(i).getLosses());
				soloLosses.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloLosses);
				
				TextView soloKills = new TextView(mContext);
				soloKills.setBackgroundColor(Color.parseColor("#CC151515"));
				soloKills.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloKills.setGravity(Gravity.CENTER);
				soloKills.setTextSize(20);
				soloKills.setText("Kills: " + summary.get(i).getAggregatedStats().getTotalChampionKills());
				soloKills.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloKills);
				
				TextView soloAssists = new TextView(mContext);
				soloAssists.setBackgroundColor(Color.parseColor("#CC151515"));
				soloAssists.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloAssists.setGravity(Gravity.CENTER);
				soloAssists.setTextSize(20);
				soloAssists.setText("Assists: " + summary.get(i).getAggregatedStats().getTotalAssists());
				soloAssists.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloAssists);
				
				TextView soloMinions = new TextView(mContext);
				soloMinions.setBackgroundColor(Color.parseColor("#CC151515"));
				soloMinions.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloMinions.setGravity(Gravity.CENTER);
				soloMinions.setTextSize(20);
				soloMinions.setText("Minion Kills: " + summary.get(i).getAggregatedStats().getTotalMinionKills());
				soloMinions.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloMinions);
				
				TextView soloNeutrals = new TextView(mContext);
				soloNeutrals.setBackgroundColor(Color.parseColor("#CC151515"));
				soloNeutrals.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloNeutrals.setGravity(Gravity.CENTER);
				soloNeutrals.setTextSize(20);
				soloNeutrals.setText("Neutral Monster Kills: " + summary.get(i).getAggregatedStats().getTotalNeutralMinionsKilled());
				soloNeutrals.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloNeutrals);
				
				TextView soloTurrets = new TextView(mContext);
				soloTurrets.setBackgroundColor(Color.parseColor("#CC151515"));
				soloTurrets.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloTurrets.setGravity(Gravity.CENTER);
				soloTurrets.setTextSize(20);
				soloTurrets.setText("Turret Kills: " + summary.get(i).getAggregatedStats().getTotalTurretsKilled());
				soloTurrets.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloTurrets);
			}

			/**
			 * Ranked 3x3
			 */
			i = find("RankedTeam3x3", summary);
			if (i > -1)
			{ // exists
				TextView ranked3Head = new TextView(mContext);
				ranked3Head.setBackgroundColor(Color.parseColor("#CC404040"));
				ranked3Head.setTextColor(Color.parseColor("#FFFFFFFF"));
				ranked3Head.setGravity(Gravity.CENTER);
				ranked3Head.setTextSize(20);
				ranked3Head.setText("Ranked 3x3");
				ranked3Head.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(ranked3Head);
				
				TextView soloWins = new TextView(mContext);
				soloWins.setBackgroundColor(Color.parseColor("#CC151515"));
				soloWins.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloWins.setGravity(Gravity.CENTER);
				soloWins.setTextSize(20);
				soloWins.setText("Wins: " + summary.get(i).getWins());
				soloWins.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloWins);
				
				TextView soloLosses = new TextView(mContext);
				soloLosses.setBackgroundColor(Color.parseColor("#CC151515"));
				soloLosses.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloLosses.setGravity(Gravity.CENTER);
				soloLosses.setTextSize(20);
				soloLosses.setText("Losses: " + summary.get(i).getLosses());
				soloLosses.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloLosses);
				
				TextView soloKills = new TextView(mContext);
				soloKills.setBackgroundColor(Color.parseColor("#CC151515"));
				soloKills.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloKills.setGravity(Gravity.CENTER);
				soloKills.setTextSize(20);
				soloKills.setText("Kills: " + summary.get(i).getAggregatedStats().getTotalChampionKills());
				soloKills.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloKills);
				
				TextView soloAssists = new TextView(mContext);
				soloAssists.setBackgroundColor(Color.parseColor("#CC151515"));
				soloAssists.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloAssists.setGravity(Gravity.CENTER);
				soloAssists.setTextSize(20);
				soloAssists.setText("Assists: " + summary.get(i).getAggregatedStats().getTotalAssists());
				soloAssists.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloAssists);
				
				TextView soloMinions = new TextView(mContext);
				soloMinions.setBackgroundColor(Color.parseColor("#CC151515"));
				soloMinions.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloMinions.setGravity(Gravity.CENTER);
				soloMinions.setTextSize(20);
				soloMinions.setText("Minion Kills: " + summary.get(i).getAggregatedStats().getTotalMinionKills());
				soloMinions.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloMinions);
				
				TextView soloNeutrals = new TextView(mContext);
				soloNeutrals.setBackgroundColor(Color.parseColor("#CC151515"));
				soloNeutrals.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloNeutrals.setGravity(Gravity.CENTER);
				soloNeutrals.setTextSize(20);
				soloNeutrals.setText("Neutral Monster Kills: " + summary.get(i).getAggregatedStats().getTotalNeutralMinionsKilled());
				soloNeutrals.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloNeutrals);
				
				TextView soloTurrets = new TextView(mContext);
				soloTurrets.setBackgroundColor(Color.parseColor("#CC151515"));
				soloTurrets.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloTurrets.setGravity(Gravity.CENTER);
				soloTurrets.setTextSize(20);
				soloTurrets.setText("Turret Kills: " + summary.get(i).getAggregatedStats().getTotalTurretsKilled());
				soloTurrets.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloTurrets);
			}

			/**
			 * Team Builder
			 */
			i = find("CAP5x5", summary);
			if (i > -1)
			{ // exists
				TextView tbHead = new TextView(mContext);
				tbHead.setBackgroundColor(Color.parseColor("#CC404040"));
				tbHead.setTextColor(Color.parseColor("#FFFFFFFF"));
				tbHead.setGravity(Gravity.CENTER);
				tbHead.setTextSize(20);
				tbHead.setText("Team Builder");
				tbHead.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(tbHead);
				
				TextView soloWins = new TextView(mContext);
				soloWins.setBackgroundColor(Color.parseColor("#CC151515"));
				soloWins.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloWins.setGravity(Gravity.CENTER);
				soloWins.setTextSize(20);
				soloWins.setText("Wins: " + summary.get(i).getWins());
				soloWins.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloWins);
				
				TextView soloKills = new TextView(mContext);
				soloKills.setBackgroundColor(Color.parseColor("#CC151515"));
				soloKills.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloKills.setGravity(Gravity.CENTER);
				soloKills.setTextSize(20);
				soloKills.setText("Kills: " + summary.get(i).getAggregatedStats().getTotalChampionKills());
				soloKills.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloKills);
				
				TextView soloAssists = new TextView(mContext);
				soloAssists.setBackgroundColor(Color.parseColor("#CC151515"));
				soloAssists.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloAssists.setGravity(Gravity.CENTER);
				soloAssists.setTextSize(20);
				soloAssists.setText("Assists: " + summary.get(i).getAggregatedStats().getTotalAssists());
				soloAssists.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloAssists);
				
				TextView soloMinions = new TextView(mContext);
				soloMinions.setBackgroundColor(Color.parseColor("#CC151515"));
				soloMinions.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloMinions.setGravity(Gravity.CENTER);
				soloMinions.setTextSize(20);
				soloMinions.setText("Minion Kills: " + summary.get(i).getAggregatedStats().getTotalMinionKills());
				soloMinions.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloMinions);
				
				TextView soloNeutrals = new TextView(mContext);
				soloNeutrals.setBackgroundColor(Color.parseColor("#CC151515"));
				soloNeutrals.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloNeutrals.setGravity(Gravity.CENTER);
				soloNeutrals.setTextSize(20);
				soloNeutrals.setText("Neutral Monster Kills: " + summary.get(i).getAggregatedStats().getTotalNeutralMinionsKilled());
				soloNeutrals.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloNeutrals);
				
				TextView soloTurrets = new TextView(mContext);
				soloTurrets.setBackgroundColor(Color.parseColor("#CC151515"));
				soloTurrets.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloTurrets.setGravity(Gravity.CENTER);
				soloTurrets.setTextSize(20);
				soloTurrets.setText("Turret Kills: " + summary.get(i).getAggregatedStats().getTotalTurretsKilled());
				soloTurrets.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloTurrets);
			}

			/**
			 * ARAM
			 */
			i = find("AramUnranked5x5", summary);
			if (i > -1)
			{ // exists
				TextView aramHead = new TextView(mContext);
				aramHead.setBackgroundColor(Color.parseColor("#CC404040"));
				aramHead.setTextColor(Color.parseColor("#FFFFFFFF"));
				aramHead.setGravity(Gravity.CENTER);
				aramHead.setTextSize(20);
				aramHead.setText("ARAM");
				aramHead.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(aramHead);
				
				TextView soloWins = new TextView(mContext);
				soloWins.setBackgroundColor(Color.parseColor("#CC151515"));
				soloWins.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloWins.setGravity(Gravity.CENTER);
				soloWins.setTextSize(20);
				soloWins.setText("Wins: " + summary.get(i).getWins());
				soloWins.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloWins);
				
				TextView soloKills = new TextView(mContext);
				soloKills.setBackgroundColor(Color.parseColor("#CC151515"));
				soloKills.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloKills.setGravity(Gravity.CENTER);
				soloKills.setTextSize(20);
				soloKills.setText("Kills: " + summary.get(i).getAggregatedStats().getTotalChampionKills());
				soloKills.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloKills);
				
				TextView soloAssists = new TextView(mContext);
				soloAssists.setBackgroundColor(Color.parseColor("#CC151515"));
				soloAssists.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloAssists.setGravity(Gravity.CENTER);
				soloAssists.setTextSize(20);
				soloAssists.setText("Assists: " + summary.get(i).getAggregatedStats().getTotalAssists());
				soloAssists.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloAssists);
				
				TextView soloTurrets = new TextView(mContext);
				soloTurrets.setBackgroundColor(Color.parseColor("#CC151515"));
				soloTurrets.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloTurrets.setGravity(Gravity.CENTER);
				soloTurrets.setTextSize(20);
				soloTurrets.setText("Turret Kills: " + summary.get(i).getAggregatedStats().getTotalTurretsKilled());
				soloTurrets.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloTurrets);
			}

			/**
			 * Co-op vs AI
			 */
			i = find("CoopVsAI", summary);
			if (i > -1)
			{ // exists
				TextView coopHead = new TextView(mContext);
				coopHead.setBackgroundColor(Color.parseColor("#CC404040"));
				coopHead.setTextColor(Color.parseColor("#FFFFFFFF"));
				coopHead.setGravity(Gravity.CENTER);
				coopHead.setTextSize(20);
				coopHead.setText("Co-op vs AI");
				coopHead.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(coopHead);
				
				TextView soloWins = new TextView(mContext);
				soloWins.setBackgroundColor(Color.parseColor("#CC151515"));
				soloWins.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloWins.setGravity(Gravity.CENTER);
				soloWins.setTextSize(20);
				soloWins.setText("Wins: " + summary.get(i).getWins());
				soloWins.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloWins);

				TextView soloKills = new TextView(mContext);
				soloKills.setBackgroundColor(Color.parseColor("#CC151515"));
				soloKills.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloKills.setGravity(Gravity.CENTER);
				soloKills.setTextSize(20);
				soloKills.setText("Kills: " + summary.get(i).getAggregatedStats().getTotalChampionKills());
				soloKills.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloKills);
				
				TextView soloAssists = new TextView(mContext);
				soloAssists.setBackgroundColor(Color.parseColor("#CC151515"));
				soloAssists.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloAssists.setGravity(Gravity.CENTER);
				soloAssists.setTextSize(20);
				soloAssists.setText("Assists: " + summary.get(i).getAggregatedStats().getTotalAssists());
				soloAssists.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloAssists);
				
				TextView soloMinions = new TextView(mContext);
				soloMinions.setBackgroundColor(Color.parseColor("#CC151515"));
				soloMinions.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloMinions.setGravity(Gravity.CENTER);
				soloMinions.setTextSize(20);
				soloMinions.setText("Minion Kills: " + summary.get(i).getAggregatedStats().getTotalMinionKills());
				soloMinions.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloMinions);
				
				TextView soloNeutrals = new TextView(mContext);
				soloNeutrals.setBackgroundColor(Color.parseColor("#CC151515"));
				soloNeutrals.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloNeutrals.setGravity(Gravity.CENTER);
				soloNeutrals.setTextSize(20);
				soloNeutrals.setText("Neutral Monster Kills: " + summary.get(i).getAggregatedStats().getTotalNeutralMinionsKilled());
				soloNeutrals.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloNeutrals);
				
				TextView soloTurrets = new TextView(mContext);
				soloTurrets.setBackgroundColor(Color.parseColor("#CC151515"));
				soloTurrets.setTextColor(Color.parseColor("#FFFFFFFF"));
				soloTurrets.setGravity(Gravity.CENTER);
				soloTurrets.setTextSize(20);
				soloTurrets.setText("Turret Kills: " + summary.get(i).getAggregatedStats().getTotalTurretsKilled());
				soloTurrets.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloTurrets);
			}
		}
	}

	private int find(String type, List<PlayerStatsSummary> summary)
	{
		int n = summary.size();
		for (int i = 0; i < n; i++)
		{
			if (summary.get(i).getPlayerStatSummaryType().equals(type))
			{
				return i;
			}
		}
		return -1;
	}
}