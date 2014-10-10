package com.team4d.lolhelper.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

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

					new SummonerStatsAsyncTask().execute(summonername);
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
				new SummonerStatsAsyncTask().execute(summonername);
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

		}
	}
}