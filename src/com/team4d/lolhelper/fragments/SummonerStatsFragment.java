package com.team4d.lolhelper.fragments;

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
import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.stats.PlayerStatsSummaryList;
import com.team4d.lolhelper.api.dto.stats.RankedStats;
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
	public void onStart()
	{
		super.onStart();
		final Context c = this.getActivity();
		final View v = this.getView();

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

					new SummonerStatsAsyncTask(c, v).execute(summonername);
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
				new SummonerStatsAsyncTask(c, v).execute(summonername);
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
		View mView;

		public SummonerStatsAsyncTask(Context c, View v)
		{
			mContext = c;
			mView = v;
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
			RankedStats summonerRanked = APIData.getRankedStatsByName(summonername[0]);
			PlayerStatsSummaryList summonerSummary = APIData.getSummaryStatsByName(summonername[0]);
			Gson gson = new Gson();
			results.add("summoner", gson.toJsonTree(summoner, Summoner.class));
			results.add("summonerRanked", gson.toJsonTree(summonerRanked, RankedStats.class));
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
			Summoner summoner = gson.fromJson(results.get("summoner"), Summoner.class);
			RankedStats summonerRanked = gson.fromJson(results.get("summonerRanked"), RankedStats.class);
			PlayerStatsSummaryList summonerSummary = gson.fromJson(results.get("summonerSummary"),
					PlayerStatsSummaryList.class);
			LinearLayout statsLayout = (LinearLayout) mView.findViewById(R.id.StatsLayout);

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
			summonerLevel.setText("Summoner Level: " + summoner.getSummonerLevel());
			summonerLevel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			statsLayout.addView(summonerLevel);
		}
	}
}