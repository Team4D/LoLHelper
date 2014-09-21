package com.fourfoureight.lolhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.LinearLayout;

import com.fourfoureight.lolhelper.Build_Guides.BuildScreen;
import com.fourfoureight.lolhelper.api.database.LOLDatabaseAsyncTask;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends ActionBarActivity
{

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	/** The view to show the ad. */
	private AdView adView;

	/* Your ad unit id. Replace with your actual ad unit id. */
	private static final String AD_UNIT_ID = "ca-app-pub-9973141875464346/2397347111";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LinearLayout layout = (LinearLayout) findViewById(R.id.container);

		// Initialize the database for use.
		new LOLDatabaseAsyncTask(this).execute();

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild,
				((GlobalVariables) this.getApplication()).getskin());

		// setting list adapter
		expListView.setAdapter(listAdapter);

		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener()
		{

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id)
			{

				if (groupPosition == 2) // If Player Stats is pressed, no expansion is necessary, go directly to screen
				{
					playerStats(v);
				}
				// else if (groupPosition == 4) // If Options is pressed, no expansion is necessary, go directly to
				// screen
				// {
				// options(v);
				// }
				else if (groupPosition == 4) // If About is pressed, no expansion is necessary, go directly to screen
				{
					about(v);
				}
				return false; // Otherwise nothing
			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener()
		{

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id)
			{
				if ((groupPosition == 0) && (childPosition == 0))
				{
					teamBuilder(v);
				}
				else if ((groupPosition == 0) && (childPosition == 1))
				{
					counters(v);
				}
				else if ((groupPosition == 0) && (childPosition == 2))
				{
					ultimateBravery(v);
				}
				else if ((groupPosition == 1) && (childPosition == 0))
				{
					buildGuides(v);
				}
				else if ((groupPosition == 1) && (childPosition == 1))
				{
					jungleTimers(v);
				}
				else if ((groupPosition == 3) && (childPosition == 0))
				{
					champions(v);
				}
				else if ((groupPosition == 3) && (childPosition == 1))
				{
					items(v);
				}
				else if ((groupPosition == 3) && (childPosition == 2))
				{
					summonerSpells(v);
				}

				return false;
			}
		});

		LinearLayout adlayout = (LinearLayout) findViewById(R.id.container2);

		// Create an ad.
		adView = new AdView(this);
		adView.setAdSize(AdSize.BANNER);
		adView.setAdUnitId(AD_UNIT_ID);
		adView.setBottom(0);

		// Add the AdView to the view hierarchy. The view will have no size
		// until the ad is loaded.
		adlayout.addView(adView);

		// Create an ad request. Check logcat output for the hashed device ID to
		// get test ads on a physical device.
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				// .addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE")
				.build();

		// Start loading the ad in the background.
		adView.loadAd(adRequest);

	}

	private void prepareListData()
	{
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		String championSelectString = ((GlobalVariables) this.getApplication()).getChampionSelectString();
		String inGameString = ((GlobalVariables) this.getApplication()).getInGameString();
		String playerStatsString = ((GlobalVariables) this.getApplication()).getPlayerStatsString();
		String generalInfoString = ((GlobalVariables) this.getApplication()).getGeneralInfoString();
		String aboutString = ((GlobalVariables) this.getApplication()).getAboutString();
		String teamBuilderString = ((GlobalVariables) this.getApplication()).getTeamBuilderString();
		String countersString = ((GlobalVariables) this.getApplication()).getCountersString();
		String ultimateBraveryString = ((GlobalVariables) this.getApplication()).getUltimateBraveryString();
		String buildGuidesString = ((GlobalVariables) this.getApplication()).getBuildGuidesString();
		String jungleTimerString = ((GlobalVariables) this.getApplication()).getJungleTimerString();
		String championsString = ((GlobalVariables) this.getApplication()).getChampionsString();
		String itemsString = ((GlobalVariables) this.getApplication()).getItemsString();
		String summonerSpellsString = ((GlobalVariables) this.getApplication()).getSummonerSpellsString();
		String optionsString = ((GlobalVariables) this.getApplication()).getOptionsString();

		// Button names
		listDataHeader.add(championSelectString);
		listDataHeader.add(inGameString);
		listDataHeader.add(playerStatsString);
		listDataHeader.add(generalInfoString);
		// listDataHeader.add(optionsString);
		listDataHeader.add(aboutString);

		// Subbutton names
		List<String> championSelect = new ArrayList<String>();
		championSelect.add(teamBuilderString);
		championSelect.add(countersString);
		championSelect.add(ultimateBraveryString);

		List<String> inGame = new ArrayList<String>();
		inGame.add(buildGuidesString);
		inGame.add(jungleTimerString);

		List<String> playerStats = new ArrayList<String>(); // No subbuttons, but necessary to prevent app crashing

		List<String> generalInfo = new ArrayList<String>();
		generalInfo.add(championsString);
		generalInfo.add(itemsString);
		generalInfo.add(summonerSpellsString);

		List<String> options = new ArrayList<String>(); // No subbuttons, but necessary to prevent app crashing

		List<String> about = new ArrayList<String>(); // No subbuttons, but necessary to prevent app crashing

		listDataChild.put(listDataHeader.get(0), championSelect); // Header, Child data
		listDataChild.put(listDataHeader.get(1), inGame);
		listDataChild.put(listDataHeader.get(2), playerStats);
		listDataChild.put(listDataHeader.get(3), generalInfo);
		// listDataChild.put(listDataHeader.get(4), options);
		listDataChild.put(listDataHeader.get(4), about);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed()
	{
		// Log.d("CDA", "onBackPressed Called");
		Intent setIntent = new Intent(Intent.ACTION_MAIN);
		setIntent.addCategory(Intent.CATEGORY_HOME);
		setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(setIntent);
	}

	@Override
	public void onResume()
	{
		super.onResume();
		if (adView != null)
		{
			adView.resume();
		}
	}

	@Override
	public void onPause()
	{
		if (adView != null)
		{
			adView.pause();
		}
		super.onPause();
	}

	/** Called before the activity is destroyed. */
	@Override
	public void onDestroy()
	{
		// Destroy the AdView.
		if (adView != null)
		{
			adView.destroy();
		}
		super.onDestroy();
	}

	// Button press functions
	public void buildGuides(View view)
	{
		Intent intent = new Intent(this, BuildScreen.class);
		startActivity(intent);
	}

	public void jungleTimers(View view)
	{
		Intent intent = new Intent(this, JungleTimer.class);
		startActivity(intent);
	}

	public void teamBuilder(View view)
	{
		Intent intent = new Intent(this, TeamBuilder.class);
		startActivity(intent);
	}

	public void counters(View view)
	{
		Intent intent = new Intent(this, Counters.class);
		startActivity(intent);
	}

	public void ultimateBravery(View view)
	{
		Intent intent = new Intent(this, UltimateBravery.class);
		startActivity(intent);
	}

	public void playerStats(View view)
	{
		Intent intent = new Intent(this, PlayerStats.class);
		startActivity(intent);
	}

	public void items(View view)
	{
		Intent intent = new Intent(this, Items.class);
		startActivity(intent);
	}

	public void champions(View view)
	{
		Intent intent = new Intent(this, Champions.class);
		startActivity(intent);
	}

	public void summonerSpells(View view)
	{
		Intent intent = new Intent(this, SummonerSpells.class);
		startActivity(intent);
	}

	public void options(View view)
	{
		Intent intent = new Intent(this, Options.class);
		startActivity(intent);
	}

	public void about(View view)
	{
		Intent intent = new Intent(this, About.class);
		startActivity(intent);
	}
}
