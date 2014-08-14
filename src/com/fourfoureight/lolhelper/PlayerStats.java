package com.fourfoureight.lolhelper;

import java.io.IOException;

import org.json.JSONException;

import com.fourfoureight.lolhelper.R;
import com.fourfoureight.lolhelper.Stats.StatsPull;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

public class PlayerStats extends ActionBarActivity {
	String results[];
	EditText edit1;	
	TextView rankedHeader, normalHeader, dominionHeader, normal3v3Header, ofaHeader, fb1Header, fb2Header, hexHeader, urfHeader;
	TextView[] statTypeTV = new TextView[60];
	TextView[] statTV = new TextView[30];
	TextView[] statAdvancedTV = new TextView[31];
	String rankedSoloLossesString;
	boolean hasPlayedRanked5v5 = false, hasPlayedNormal5v5 = false, hasPlayedDominion = false, hasPlayedNormal3v3 = false, hasPlayedofa = false, hasPlayedfb1 = false, hasPlayedfb2 = false, hasPlayedhex = false, hasPlayedurf = false;
	boolean resetViewsToVisible = false, caughtJSONException = false, caughtIOException = false;
	int height;
	TextView summonerName;
	float statsFontSize = 18, modeHeaderFontSize = 28, summonerNameFontSize = 36;
	Toast fetchingSummonerStatsToast;
	
	//Automatically called when the activity starts. Initializes stats array, sets the layout of the page and establishes the touch event listeners.
	/*
		Prototype: void onCreate(Bundle savedInstanceState);
		Parameter: savedInstanceState (Bundle)
		Returns: none
		Description: Called when the activiy starts. Initializes layout and stats and establishes touch event listeners.
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_stats);
		
		String enterString = ((GlobalVariables) this.getApplication()).getEnterString();
		Button enter = (Button)findViewById(R.id.enter);
		enter.setText(enterString);
		
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.container);
        if (((GlobalVariables) this.getApplication()).getskin() == 1)
    	{
    		layout.setBackgroundResource(R.drawable.bg);
    	}
    	if (((GlobalVariables) this.getApplication()).getskin() == 2)
    	{
    		layout.setBackgroundResource(R.drawable.bg2);
    	}
    	
		results = new String[66];
		for(int i=0; i<66; i++){
			results[i] = "";
		}
	
		findViews();
		setStatFontSize();
		pullStats();
	
	}
	
	//Finds the ID's of each text view
	/*
		Prototype: findViews()
		Parameter: none
		Returns: none
		Description: Finds the ID's of each text view
	*/
	private void findViews(){
	summonerName = (TextView) findViewById(R.id.SummonerName);
	
	// Header Text Views
	rankedHeader = (TextView) (findViewById(R.id.textView1_RankedHeader));
	normalHeader = (TextView) (findViewById(R.id.textView1));
	dominionHeader = (TextView) (findViewById(R.id.TextView11));
	normal3v3Header = (TextView) (findViewById(R.id.TextView43));
	ofaHeader = (TextView) (findViewById(R.id.TextView43_ofa));
	fb1Header = (TextView) (findViewById(R.id.TextView43_fb1));
	fb2Header = (TextView) (findViewById(R.id.TextView43_fb2));
	hexHeader = (TextView) (findViewById(R.id.TextView43_hex));
	urfHeader = (TextView) (findViewById(R.id.TextView43_urf));
	
	// Ranked solo 5v5 Stat Type Views
	statTypeTV[1]  = (TextView) findViewById(R.id.textView2_RankedWins);
	statTypeTV[2]  = (TextView) findViewById(R.id.textView2_RankedLosses);
	statTypeTV[3]  = (TextView) findViewById(R.id.TextView03_RankedKills);
	statTypeTV[4]  = (TextView) findViewById(R.id.TextView01_RankedAssists);
	statTypeTV[5]  = (TextView) findViewById(R.id.TextView09_RankedMinionKills);
	statTypeTV[6]  = (TextView) findViewById(R.id.TextView08_RankedNeutralMinionKills);
	statTypeTV[7]  = (TextView) findViewById(R.id.TextView06_RankedTurretsDestroyed);
	
	// Normal 5v5 Stat Type Views
	statTypeTV[8]  = (TextView) findViewById(R.id.textView2);
	statTypeTV[9]  = (TextView) findViewById(R.id.TextView03);
	statTypeTV[10] = (TextView) findViewById(R.id.TextView01);
	statTypeTV[11] = (TextView) findViewById(R.id.TextView09);
	statTypeTV[12] = (TextView) findViewById(R.id.TextView08);
	statTypeTV[13] = (TextView) findViewById(R.id.TextView06);
	
	// Dominion Stat Type Views
	statTypeTV[14] = (TextView) findViewById(R.id.TextView18);
	statTypeTV[15] = (TextView) findViewById(R.id.TextView23);
	statTypeTV[16] = (TextView) findViewById(R.id.TextView21);
	statTypeTV[17] = (TextView) findViewById(R.id.TextView12);
	statTypeTV[18] = (TextView) findViewById(R.id.TextView13);
	statTypeTV[19] = (TextView) findViewById(R.id.TextView15);
	statTypeTV[20] = (TextView) findViewById(R.id.TextView30);
	statTypeTV[21] = (TextView) findViewById(R.id.TextView35);
	statTypeTV[22] = (TextView) findViewById(R.id.TextView33);
	statTypeTV[23] = (TextView) findViewById(R.id.TextView24);
	
	// Normal 3v3 Stat Type Views
	statTypeTV[24] = (TextView) findViewById(R.id.TextView42);
	statTypeTV[25] = (TextView) findViewById(R.id.TextView48);
	statTypeTV[26] = (TextView) findViewById(R.id.TextView46);
	statTypeTV[27] = (TextView) findViewById(R.id.TextView36);
	statTypeTV[28] = (TextView) findViewById(R.id.TextView37);
	statTypeTV[29] = (TextView) findViewById(R.id.TextView39);
	
	// One for All Stat Type Views
	statTypeTV[30] = (TextView) findViewById(R.id.TextView42_ofa);
	statTypeTV[31] = (TextView) findViewById(R.id.TextView48_ofa);
	statTypeTV[32] = (TextView) findViewById(R.id.TextView46_ofa);
	statTypeTV[33] = (TextView) findViewById(R.id.TextView36_ofa);
	statTypeTV[34] = (TextView) findViewById(R.id.TextView37_ofa);
	statTypeTV[35] = (TextView) findViewById(R.id.TextView39_ofa);
	
	// First Blood 1v1 Stat Type Views
	statTypeTV[36] = (TextView) findViewById(R.id.TextView42_fb1);
	statTypeTV[37] = (TextView) findViewById(R.id.TextView48_fb1);
	statTypeTV[38] = (TextView) findViewById(R.id.TextView46_fb1);
	statTypeTV[39] = (TextView) findViewById(R.id.TextView36_fb1);
	statTypeTV[40] = (TextView) findViewById(R.id.TextView37_fb1);
	statTypeTV[41] = (TextView) findViewById(R.id.TextView39_fb1);
	
	// First Blood 2v2 Stat Type Views
	statTypeTV[42] = (TextView) findViewById(R.id.TextView42_fb2);
	statTypeTV[43] = (TextView) findViewById(R.id.TextView48_fb2);
	statTypeTV[44] = (TextView) findViewById(R.id.TextView46_fb2);
	statTypeTV[45] = (TextView) findViewById(R.id.TextView36_fb2);
	statTypeTV[46] = (TextView) findViewById(R.id.TextView37_fb2);
	statTypeTV[47] = (TextView) findViewById(R.id.TextView39_fb2);
	
	// First Hexakill Type Views
	statTypeTV[48] = (TextView) findViewById(R.id.TextView42_hex);
	statTypeTV[49] = (TextView) findViewById(R.id.TextView48_hex);
	statTypeTV[50] = (TextView) findViewById(R.id.TextView46_hex);
	statTypeTV[51] = (TextView) findViewById(R.id.TextView36_hex);
	statTypeTV[52] = (TextView) findViewById(R.id.TextView37_hex);
	statTypeTV[53] = (TextView) findViewById(R.id.TextView39_hex);
	
	// First URF Type Views
	statTypeTV[54] = (TextView) findViewById(R.id.TextView42_urf);
	statTypeTV[55] = (TextView) findViewById(R.id.TextView48_urf);
	statTypeTV[56] = (TextView) findViewById(R.id.TextView46_urf);
	statTypeTV[57] = (TextView) findViewById(R.id.TextView36_urf);
	statTypeTV[58] = (TextView) findViewById(R.id.TextView37_urf);
	statTypeTV[59] = (TextView) findViewById(R.id.TextView39_urf);
	
	statTV[1]  = (TextView) findViewById(R.id.wins5v5_Ranked);
	statTV[2]  = (TextView) findViewById(R.id.losses5v5_Ranked);
	statTV[3]  = (TextView) findViewById(R.id.kills5v5_Ranked);
	statTV[4]  = (TextView) findViewById(R.id.assists5v5_Ranked);
	statTV[5]  = (TextView) findViewById(R.id.minionkills5v5_Ranked);
	statTV[6]  = (TextView) findViewById(R.id.neutralminionkills5v5_Ranked);
	statTV[7]  = (TextView) findViewById(R.id.turretsdestroyed5v5_Ranked);
	
	statTV[8]  = (TextView) findViewById(R.id.wins5v5);
	statTV[9]  = (TextView) findViewById(R.id.kills5v5);
	statTV[10]  = (TextView) findViewById(R.id.assists5v5);
	statTV[11] = (TextView) findViewById(R.id.minionkills5v5);
	statTV[12] = (TextView) findViewById(R.id.neutralminionkills5v5);
	statTV[13] = (TextView) findViewById(R.id.turretsdestroyed5v5);
	
	statTV[14] = (TextView) findViewById(R.id.winsdom);
	statTV[15] = (TextView) findViewById(R.id.killsdom);
	statTV[16] = (TextView) findViewById(R.id.mostkillsdom);
	statTV[17] = (TextView) findViewById(R.id.assistsdom);
	statTV[18] = (TextView) findViewById(R.id.mostassistsdom);
	statTV[19] = (TextView) findViewById(R.id.highestscoredom);
	statTV[20] = (TextView) findViewById(R.id.nodescaptureddom);
	statTV[21] = (TextView) findViewById(R.id.mostnodescaptureddom);
	statTV[22] = (TextView) findViewById(R.id.nodesneutralizeddom);
	statTV[23] = (TextView) findViewById(R.id.mostnodesneutralizeddom);

	statTV[24] = (TextView) findViewById(R.id.wins3v3);
	statTV[25] = (TextView) findViewById(R.id.kills3v3);
	statTV[26] = (TextView) findViewById(R.id.assists3v3);
	statTV[27] = (TextView) findViewById(R.id.minionkills3v3);
	statTV[28] = (TextView) findViewById(R.id.neutralminionkills3v3);
	statTV[29] = (TextView) findViewById(R.id.turretsdestroyed3v3);
	
	statAdvancedTV[1]  = (TextView) findViewById(R.id.winsofa);
	statAdvancedTV[2]  = (TextView) findViewById(R.id.killsofa);
	statAdvancedTV[3]  = (TextView) findViewById(R.id.assistsofa);
	statAdvancedTV[4]  = (TextView) findViewById(R.id.minionkillsofa);
	statAdvancedTV[5]  = (TextView) findViewById(R.id.neutralminionkillsofa);
	statAdvancedTV[6]  = (TextView) findViewById(R.id.turretsdestroyedofa);
	
	statAdvancedTV[7]  = (TextView) findViewById(R.id.winsfb1);
	statAdvancedTV[8]  = (TextView) findViewById(R.id.killsfb1);
	statAdvancedTV[9]  = (TextView) findViewById(R.id.assistsfb1);
	statAdvancedTV[10] = (TextView) findViewById(R.id.minionkillsfb1);
	statAdvancedTV[11] = (TextView) findViewById(R.id.neutralminionkillsfb1);
	statAdvancedTV[12] = (TextView) findViewById(R.id.turretsdestroyedfb1);
	
	statAdvancedTV[13] = (TextView) findViewById(R.id.winsfb2);
	statAdvancedTV[14] = (TextView) findViewById(R.id.killsfb2);
	statAdvancedTV[15] = (TextView) findViewById(R.id.assistsfb2);
	statAdvancedTV[16] = (TextView) findViewById(R.id.minionkillsfb2);
	statAdvancedTV[17] = (TextView) findViewById(R.id.neutralminionkillsfb2);
	statAdvancedTV[18] = (TextView) findViewById(R.id.turretsdestroyedfb2);
	
	statAdvancedTV[19] = (TextView) findViewById(R.id.winshex);
	statAdvancedTV[20] = (TextView) findViewById(R.id.killshex);
	statAdvancedTV[21] = (TextView) findViewById(R.id.assistshex);
	statAdvancedTV[22] = (TextView) findViewById(R.id.minionkillshex);
	statAdvancedTV[23] = (TextView) findViewById(R.id.neutralminionkillshex);
	statAdvancedTV[24] = (TextView) findViewById(R.id.turretsdestroyedhex);
	
	statAdvancedTV[25] = (TextView) findViewById(R.id.winsurf);
	statAdvancedTV[26] = (TextView) findViewById(R.id.killsurf);
	statAdvancedTV[27] = (TextView) findViewById(R.id.assistsurf);
	statAdvancedTV[28] = (TextView) findViewById(R.id.minionkillsurf);
	statAdvancedTV[29] = (TextView) findViewById(R.id.neutralminionkillsurf);
	statAdvancedTV[30] = (TextView) findViewById(R.id.turretsdestroyedurf);
	
	
	// Set the color of the text to abide by skin rules
    if (((GlobalVariables) this.getApplication()).getskin() == 1)
	{
		// Nothing yet, needs to be handled
	}
	if (((GlobalVariables) this.getApplication()).getskin() == 2) // Right now just sets text color to black
	{
		for(int i=1; i<statTypeTV.length; i++)
		{
			statTypeTV[i].setTextColor(Color.parseColor("#000000"));
		}
		for(int i=1; i<statTV.length; i++)
		{
			statTV[i].setTextColor(Color.parseColor("#000000"));
		}
		for(int i=1; i<statAdvancedTV.length; i++)
		{
			statAdvancedTV[i].setTextColor(Color.parseColor("#000000"));
		}
	}
	
	height = statTypeTV[1].getHeight();
	}
	
	//Sets up the touch event listeners
	/*
		Prototype: pullStats()
		Parameter: none
		Returns: none
		Description: Sets up the touch event listeners
	*/
	private void pullStats(){
	edit1 = (EditText) findViewById(R.id.editText1);
	Button enter = (Button) findViewById(R.id.enter);
	
	
	// Links the "done" soft key with execution
	View.OnKeyListener myOnKeyListener = new View.OnKeyListener() {
	@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
				new StatsTask().execute();
					if(resetViewsToVisible == true){
						showAllViews();
						resetViewsToVisible = false;
					}
					return true;
				}
			return false;
			}
		}; 
		
		// Code that is executed when the button is pressed is housed inside onClick
		View.OnClickListener myListener = new View.OnClickListener() {
			
			
		@Override
			public void onClick(View v) {
				hideKeyboard(v);
				new StatsTask().execute();
					if(resetViewsToVisible == true){
						showAllViews();
						resetViewsToVisible = false;
					}
			};
		
		};
		enter.setOnClickListener(myListener);
		edit1.setOnKeyListener(myOnKeyListener);
	}
	

	//Creates an instance of StatsPull and retrieves the stats summary for the given summoner and writes it to the text views
	//REQUIRES INTERNET CONNECTION
	/*
		Prototype: StatsTask()
		Parameter: none
		Returns: none
		Description: Creates an instance of StatsPull and retrieves the stats summary for the given summoner and writes them to the text views
	*/
	private class StatsTask extends AsyncTask<String, Void, String[]>{
	@Override
	protected String[] doInBackground(String... params) {
	String summonerName = edit1.getText().toString();
	results[0] = summonerName;
	try {
	StatsPull stats = new StatsPull(summonerName);
	
	hasPlayedRanked5v5 = stats.isHasPlayedRanked5v5();
	hasPlayedNormal5v5 = stats.isHasPlayedNormal5v5();
	hasPlayedDominion  = stats.isHasPlayedDominion();
	hasPlayedNormal3v3 = stats.isHasPlayedNormal3v3();
	hasPlayedofa       = stats.isHasPlayedofa();
	hasPlayedfb1       = stats.isHasPlayedfb1();
	hasPlayedfb2       = stats.isHasPlayedfb2();
	hasPlayedhex       = stats.isHasPlayedhex();
	hasPlayedurf       = stats.isHasPlayedurf();
	
	results[1] = stats.getProfileIcon();
	results[2] = stats.getLevel();
	
	//Ranked Stats
	results[3]  = Long.toString(stats.getRankedSolo5x5Wins());
	rankedSoloLossesString = Long.toString(stats.getRankedSolo5x5Losses());
	results[4]  = Long.toString(stats.getrChampKills());
	results[5]  = Long.toString(stats.getrAssists());
	results[6]  = Long.toString(stats.getrMinionKills());
	results[7]  = Long.toString(stats.getrNeutralMonsterKills());
	results[8]  = Long.toString(stats.getrTotalTurretKills());
	
	//Normal Stats
	results[9]  = Long.toString(stats.getUnrankedWins());
	results[10] = Long.toString(stats.getnChampKills());	
	results[11] = Long.toString(stats.getnAssists());
	results[12] = Long.toString(stats.getnMinionKills());
	results[13] = Long.toString(stats.getnNeutralMonsterKills());
	results[14] = Long.toString(stats.getnTotalTurretKills());
	
	//Dominion Stats (OdinUnranked)
	results[15] = Long.toString(stats.getDomWins());
	results[16] = Long.toString(stats.getDomChampKills());
	results[17] = Long.toString(stats.getDomMostKills());
	results[18] = Long.toString(stats.getDomAssists());
	results[19] = Long.toString(stats.getDomMostAssists());
	results[20] = Long.toString(stats.getDomHighestScore());
	results[21] = Long.toString(stats.getDomNodesCaptured());
	results[22] = Long.toString(stats.getDomMostNodesCaptured());
	results[23] = Long.toString(stats.getDomNodesNeutralized());
	results[24] = Long.toString(stats.getDomMostNodesNeutralized());
	
	//3v3 Stats
	results[25] = Long.toString(stats.getUnranked3x3Wins());
	results[26] = Long.toString(stats.getTvtChampKills());
	results[27] = Long.toString(stats.getTvtAssists());
	results[28] = Long.toString(stats.getTvtMinionKills());
	results[29] = Long.toString(stats.getTvtNeutralMonsterKills());
	results[30] = Long.toString(stats.getTvtTotalTurretKills());
	
	//One for All
	results[31] = Long.toString(stats.getOfaWins());
	results[32] = Long.toString(stats.getOfaChampKills());
	results[33] = Long.toString(stats.getOfaAssists());
	results[34] = Long.toString(stats.getOfaMinionKills());
	results[35] = Long.toString(stats.getOfaNeutralMonsterKills());
	results[36] = Long.toString(stats.getOfaTotalTurretKills());
	
	//First Blood 1v1
	results[37] = Long.toString(stats.getFb1Wins());
	results[38] = Long.toString(stats.getFb1ChampKills());
	results[39] = Long.toString(stats.getFb1Assists());
	results[40] = Long.toString(stats.getFb1MinionKills());
	results[41] = Long.toString(stats.getFb1NeutralMonsterKills());
	results[42] = Long.toString(stats.getFb1TotalTurretKills());
	
	//First Blood 2v2
	results[43] = Long.toString(stats.getFb2Wins());
	results[44] = Long.toString(stats.getFb2ChampKills());
	results[45] = Long.toString(stats.getFb2Assists());
	results[46] = Long.toString(stats.getFb2MinionKills());
	results[47] = Long.toString(stats.getFb2NeutralMonsterKills());
	results[48] = Long.toString(stats.getFb2TotalTurretKills());
	
	//Hexakill
	results[49] = Long.toString(stats.getHexWins());
	results[50] = Long.toString(stats.getHexChampKills());
	results[51] = Long.toString(stats.getHexAssists());
	results[52] = Long.toString(stats.getHexMinionKills());
	results[53] = Long.toString(stats.getHexNeutralMonsterKills());
	results[54] = Long.toString(stats.getHexTotalTurretKills());
	
	//Urf
	results[55] = Long.toString(stats.getUrfWins());
	results[56] = Long.toString(stats.getUrfChampKills());
	results[57] = Long.toString(stats.getUrfAssists());
	results[58] = Long.toString(stats.getUrfMinionKills());
	results[59] = Long.toString(stats.getUrfNeutralMonsterKills());
	results[60] = Long.toString(stats.getUrfTotalTurretKills());
	
	//Extra Ranked Stats
	results[61] = Long.toString(stats.getRankedPremade3x3Wins());
	results[62] = Long.toString(stats.getRankedPremade5x5Wins());
	results[63] = Long.toString(stats.getRankedTeam3x3Wins());
	results[64] = Long.toString(stats.getRankedTeam5x5Wins());
	results[65] = Long.toString(stats.getCoopVsAIWins());
	
	}catch (JSONException je){
		System.err.println(je);
		for(int i=0; i<66; i++){
			results[i] = "";
		}
		rankedSoloLossesString = "";
		resetViewsToVisible = true;
		caughtJSONException = true;
	}
	catch (IOException e) {
		System.err.println(e);
		for(int i=0; i<66; i++){
			results[i] = "";
		}
		rankedSoloLossesString = "";
		resetViewsToVisible = true;
		caughtIOException = true;
	}
	return results;
	}
	
	@Override
        protected void onPostExecute(String[] results) {
	height = statTV[1].getHeight();
	
		if(caughtIOException){
			caughtIOException = false;
			results[0] = "Invalid Summoner Name";
			summonerName.setText(results[0]);
			showAllViews();
		} else if(caughtJSONException){
			caughtJSONException = false;
			results[0] = "No stats History";
			summonerName.setText(results[0]);
			showAllViews();
		} else {
			summonerName.setText(results[0] + ": " + results[2]);
		}
		
		if(resetViewsToVisible == true){
			showAllViews();
			resetViewsToVisible = false;
		} else {
			showAllViews();
			hideEmptyViews();
		}
		
		// Ranked Stats
		statTV[1].setText(results[3]);
		statTV[2].setText(rankedSoloLossesString);
		statTV[3].setText(results[4]);
		statTV[4].setText(results[5]);
		statTV[5].setText(results[6]);
		statTV[6].setText(results[7]);
		statTV[7].setText(results[8]);
		
		// Normal Stats
		statTV[8].setText(results[9]);
		statTV[9].setText(results[10]);
		statTV[10].setText(results[11]);
		statTV[11].setText(results[12]);
		statTV[12].setText(results[13]);
		statTV[13].setText(results[14]);
		
		//Dominion Stats
		statTV[14].setText(results[15]);
		statTV[15].setText(results[16]);
		statTV[16].setText(results[17]);
		statTV[17].setText(results[18]);
		statTV[18].setText(results[19]);
		statTV[19].setText(results[20]);
		statTV[20].setText(results[21]);
		statTV[21].setText(results[22]);
		statTV[22].setText(results[23]);
		statTV[23].setText(results[24]);
		
		// 3v3 Unranked
		statTV[24].setText(results[25]);
		statTV[25].setText(results[26]);
		statTV[26].setText(results[27]);
		statTV[27].setText(results[28]);
		statTV[28].setText(results[29]);
		statTV[29].setText(results[30]);
		
		// One for All
		statAdvancedTV[1].setText(results[31]);
		statAdvancedTV[2].setText(results[32]);
		statAdvancedTV[3].setText(results[33]);
		statAdvancedTV[4].setText(results[34]);
		statAdvancedTV[5].setText(results[35]);
		statAdvancedTV[6].setText(results[36]);
		
		// First Blood 1v1
		statAdvancedTV[7].setText(results[37]);
		statAdvancedTV[8].setText(results[38]);
		statAdvancedTV[9].setText(results[39]);
		statAdvancedTV[10].setText(results[40]);
		statAdvancedTV[11].setText(results[41]);
		statAdvancedTV[12].setText(results[42]);
		
		// First Blood 2v2
		statAdvancedTV[13].setText(results[43]);
		statAdvancedTV[14].setText(results[44]);
		statAdvancedTV[15].setText(results[45]);
		statAdvancedTV[16].setText(results[46]);
		statAdvancedTV[17].setText(results[47]);
		statAdvancedTV[18].setText(results[48]);
		
		// Hexakill
		statAdvancedTV[19].setText(results[49]);
		statAdvancedTV[20].setText(results[50]);
		statAdvancedTV[21].setText(results[51]);
		statAdvancedTV[22].setText(results[52]);
		statAdvancedTV[23].setText(results[53]);
		statAdvancedTV[24].setText(results[54]);
		
		// U.R.F
		statAdvancedTV[25].setText(results[55]);
		statAdvancedTV[26].setText(results[56]);
		statAdvancedTV[27].setText(results[57]);
		statAdvancedTV[28].setText(results[58]);
		statAdvancedTV[29].setText(results[59]);
		statAdvancedTV[30].setText(results[60]);
		
		fetchingSummonerStatsToast.cancel();
	        }
	
	        @Override
	        protected void onPreExecute() {
	        	CharSequence text = "Fetching Summoner Stats";
	        	int duration = Toast.LENGTH_LONG;
	        	fetchingSummonerStatsToast = Toast.makeText(getApplicationContext(), text, duration);
	        	fetchingSummonerStatsToast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
	        	fetchingSummonerStatsToast.show();
	        }
	
	        @Override
	        protected void onProgressUpdate(Void... values) {}
	}
	
	// Resets the height of every view back to its original so that it may be viewed again
	/*
		Prototype: showAllViews()
		Parameter: none
		Returns: none
		Description: Restores the height of every text view back to its original height.
	*/
	public void showAllViews(){
	for(int i = 1; i < 60; i++){
	this.statTypeTV[i].setHeight(height);
	}
	for(int j = 1; j < 30; j++){
	this.statTV[j].setHeight(height);
	this.statAdvancedTV[j].setHeight(height);
	}
	this.statAdvancedTV[30].setHeight(height);
	
	this.statTypeTV[1].setText("Wins");
	this.statTypeTV[8].setText("Wins");
	this.statTypeTV[14].setText("Wins");
	this.statTypeTV[24].setText("Wins");
	this.statTypeTV[30].setText("Wins");
	this.statTypeTV[36].setText("Wins");
	this.statTypeTV[42].setText("Wins");
	this.statTypeTV[48].setText("Wins");
	this.statTypeTV[54].setText("Wins");
	}
	
	//Hides any of the stats categories that are empty
	/*
		Prototype: hideEmptyViews()
		Parameter: none
		Returns: none
		Description: Hides any of the stats categories that are empty.
	*/
	public void hideEmptyViews(){
	if(this.hasPlayedRanked5v5 == false){
	for(int i = 2; i < 8; i++){
	this.statTypeTV[i].setHeight(0);
	this.statTV[i].setHeight(0);
	}
	this.statTypeTV[7].setHeight(0);
	this.statTypeTV[1].setText("Games Played");
	this.statTV[1].setText("0");
	} 
	if(this.hasPlayedNormal5v5 == false){
	for(int i = 9; i < 14; i++){
	this.statTypeTV[i].setHeight(0);
	this.statTV[i].setHeight(0);
	}
	this.statTypeTV[8].setText("Games Played");
	this.statTV[8].setText("0");
	}
	if(this.hasPlayedDominion == false){
	for(int i = 15; i < 24; i++){
	this.statTypeTV[i].setHeight(0);
	this.statTV[i].setHeight(0);
	}
	this.statTypeTV[14].setText("Games Played");
	this.statTV[14].setText("0");
	}
	if(this.hasPlayedNormal3v3 == false){
	for(int i = 25; i < 30; i++){
	this.statTypeTV[i].setHeight(0);
	this.statTV[i].setHeight(0);
	}
	this.statTypeTV[24].setText("Games Played");
	this.statTV[24].setText("0");
	}
	if(this.hasPlayedofa == false){
	for(int i = 31, j = i -29; i < 36; i++, j++){
	this.statTypeTV[i].setHeight(0);
	this.statAdvancedTV[j].setHeight(0);
	}
	this.statTypeTV[30].setText("Games Played");
	this.statAdvancedTV[1].setText("0");
	}
	if(this.hasPlayedfb1 == false){
	for(int i = 37, j = i-29; i < 42; i++, j++){
	this.statTypeTV[i].setHeight(0);
	this.statAdvancedTV[j].setHeight(0);
	}
	this.statTypeTV[36].setText("Games Played");
	this.statAdvancedTV[7].setText("0");
	}
	if(this.hasPlayedfb2 == false){
	for(int i = 43, j = i -29; i < 48; i++, j++){
	this.statTypeTV[i].setHeight(0);
	this.statAdvancedTV[j].setHeight(0);
	}
	this.statTypeTV[42].setText("Games Played");
	this.statAdvancedTV[13].setText("0");
	}
	if(this.hasPlayedhex == false){
	for(int i = 49, j = i -29; i < 54; i++, j++){
	this.statTypeTV[i].setHeight(0);
	this.statAdvancedTV[j].setHeight(0);
	}
	this.statTypeTV[48].setText("Games Played");
	this.statAdvancedTV[19].setText("0");
	}
	if(this.hasPlayedurf == false){
	for(int i = 55, j = i -29; i < 60; i++, j++){
	this.statTypeTV[i].setHeight(0);
	this.statAdvancedTV[j].setHeight(0);
	}
	this.statTypeTV[54].setText("Games Played");
	this.statAdvancedTV[25].setText("0");
	}
	}
	
	//Uses class variables to set the font size of every text field.
	/*
		Prototype: setStatFontSize()
		Parameter: none
		Returns: none
		Description: Uses class variables to set the font size of every text field.
	*/
	public void setStatFontSize(){
	summonerName.setTextSize(this.summonerNameFontSize);
	rankedHeader.setTextSize(this.modeHeaderFontSize);
	normalHeader.setTextSize(this.modeHeaderFontSize);
	dominionHeader.setTextSize(this.modeHeaderFontSize);
	normal3v3Header.setTextSize(this.modeHeaderFontSize);
	ofaHeader.setTextSize(this.modeHeaderFontSize);
	fb1Header.setTextSize(this.modeHeaderFontSize);
	fb2Header.setTextSize(this.modeHeaderFontSize);
	hexHeader.setTextSize(this.modeHeaderFontSize);
	urfHeader.setTextSize(this.modeHeaderFontSize);
	
	for(int i = 1; i < 60; i++){
	this.statTypeTV[i].setTextSize(this.statsFontSize);
	}
	for(int j = 1; j < 30; j++){
	this.statTV[j].setTextSize(this.statsFontSize);
	this.statAdvancedTV[j].setTextSize(this.statsFontSize);
	}
	this.statAdvancedTV[30].setTextSize(this.statsFontSize);
	
	statTV[2].setTextColor(Color.RED);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	if (id == R.id.action_settings) {
	return true;
	}
	return super.onOptionsItemSelected(item);
	}
	
	public void hideKeyboard(View view) {
		InputMethodManager inputManager = (InputMethodManager) this
	            .getSystemService(Context.INPUT_METHOD_SERVICE);

	    //check if no view has focus:
	    View v=this.getCurrentFocus();
	    if(v==null)
	        return;

	    inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

}