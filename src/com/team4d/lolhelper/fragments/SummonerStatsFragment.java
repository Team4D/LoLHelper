package com.team4d.lolhelper.fragments;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.stats.PlayerStatsSummary;
import com.team4d.lolhelper.api.dto.stats.PlayerStatsSummaryList;
import com.team4d.lolhelper.api.dto.summoner.Summoner;
import com.team4d.lolhelper.api.dto.summoner.SummonerDto;

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
	public void onStart()
	{
		super.onStart();
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

					new SummonerStatsAsyncTask(c, activity, summonername).execute(summonername);
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
				new SummonerStatsAsyncTask(c, activity, summonername).execute(summonername);
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
		LinkedTreeMap<String, Object> summoner;

		public SummonerStatsAsyncTask(Context c, Activity a, String name)
		{
			mContext = c;
			activity = a;
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
			summoner = APIData.getSummonerByName(summonername[0]);
			PlayerStatsSummaryList summonerSummary = APIData.getSummaryStatsByName(summonername[0]);
			Gson gson = new Gson();
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
			Gson gson = new Gson();
			PlayerStatsSummaryList summonerSummary = gson.fromJson(results.get("summonerSummary"),
					PlayerStatsSummaryList.class);
//			List<PlayerStatsSummary> summary = summonerSummary.getPlayerStatSummaries();
			LinearLayout statsLayout = (LinearLayout) activity.findViewById(R.id.StatsLayout);

			// Creates the title bar with the summoner name
			TextView summonerTitle = new TextView(mContext);
			summonerTitle.setBackgroundColor(Color.parseColor("#CC151515"));
			summonerTitle.setTextColor(Color.parseColor("#FFFFFFFF"));
			summonerTitle.setGravity(Gravity.CENTER);
			summonerTitle.setTextSize(20);
			summonerTitle.setText(summoner.get("name").toString());
			summonerTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			statsLayout.addView(summonerTitle);

			// Creates the text view with the summoner level
			TextView summonerLevel = new TextView(mContext);
			summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
			summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
			summonerLevel.setGravity(Gravity.CENTER);
			summonerLevel.setTextSize(20);
			summonerLevel.setText("Summoner Level: " + summoner.get("summonerLevel").toString());
			summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			statsLayout.addView(summonerLevel);

			
			//Add all the game types that exist for this player! (that we want to add)
			int i=-1;
			
			/**
			 * Ranked Solo
			 */
//			i = find("RankedSolo5x5", summary);
			if(i>-1){ //exists
				TextView soloHead = new TextView(mContext);
				summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
				summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
				summonerLevel.setGravity(Gravity.CENTER);
				summonerLevel.setTextSize(20);
				summonerLevel.setText("Ranked Solo");
				summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(soloHead);
			}
			
			
			/**
			 * Normal
			 */
//			i = find("Unranked", summary);
			if(i>-1){ //exists
				TextView normalHead = new TextView(mContext);
				summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
				summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
				summonerLevel.setGravity(Gravity.CENTER);
				summonerLevel.setTextSize(20);
				summonerLevel.setText("Normal");
				summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(normalHead);
			}
			
			
			/**
			 * Ranked 5x5
			 */
//			i = find("RankedTeam5x5", summary);
			if(i>-1){ //exists
				TextView ranked5Head = new TextView(mContext);
				summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
				summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
				summonerLevel.setGravity(Gravity.CENTER);
				summonerLevel.setTextSize(20);
				summonerLevel.setText("Ranked 5x5");
				summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(ranked5Head);
			}
			
			
			/**
			 * Ranked 3x3
			 */
//			i = find("RankedTeam3x3", summary);
			if(i>-1){ //exists
				TextView ranked3Head = new TextView(mContext);
				summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
				summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
				summonerLevel.setGravity(Gravity.CENTER);
				summonerLevel.setTextSize(20);
				summonerLevel.setText("Ranked 3x3");
				summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(ranked3Head);
			}
			
			
			/**
			 * Team Builder
			 */
//			i = find("CAP5x5", summary);
			if(i>-1){ //exists
				TextView tbHead = new TextView(mContext);
				summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
				summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
				summonerLevel.setGravity(Gravity.CENTER);
				summonerLevel.setTextSize(20);
				summonerLevel.setText("Team Builder");
				summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(tbHead);
			}
			
			
			/**
			 * ARAM
			 */
//			i = find("AramUnranked5x5", summary);
			if(i>-1){ //exists
				TextView aramHead = new TextView(mContext);
				summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
				summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
				summonerLevel.setGravity(Gravity.CENTER);
				summonerLevel.setTextSize(20);
				summonerLevel.setText("ARAM");
				summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(aramHead);
			}
			
			
			/**
			 * Co-op vs AI
			 */
//			i = find("CoopVsAI", summary);
			if(i>-1){ //exists
				TextView coopHead = new TextView(mContext);
				summonerLevel.setBackgroundColor(Color.parseColor("#CC404040"));
				summonerLevel.setTextColor(Color.parseColor("#FFFFFFFF"));
				summonerLevel.setGravity(Gravity.CENTER);
				summonerLevel.setTextSize(20);
				summonerLevel.setText("Co-op vs AI");
				summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				statsLayout.addView(coopHead);
			}
		}
	}
	
	private int find(String type, List<PlayerStatsSummary> summary){
		int n = summary.size();
		for(int i=0; i<n; i++){
			if(summary.get(i).getPlayerStatSummaryType().equals(type)){
				return i;
			}
		}
		return -1;
	}
}