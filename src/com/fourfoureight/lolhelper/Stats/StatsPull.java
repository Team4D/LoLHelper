package com.fourfoureight.lolhelper.Stats;

import java.net.*;
import java.io.*;

import org.json.JSONException;

public class StatsPull  {
	private String summonerName, summonerID, profileIcon, level;
	private SummonerStats summonerStats;
	private String apikey = "?api_key=f685bd80-568e-4ff3-9d20-4bde13ab7106";

	//  ---===== Player Statistics data =====---
	// Wins
	private long rankedPremade3x3Wins, rankedPremade5x5Wins, rankedSolo5x5Losses, rankedTeam3x3Wins, rankedTeam5x5Wins, rankedSolo5x5Wins;
	private long unrankedWins, unranked3x3Wins, coopVsAIWins, ofaWins, fb1Wins, fb2Wins, hexWins, urfWins;
	// Normal Stats
	private long nChampKills, nAssists, nMinionKills, nNeutralMonsterKills, nTotalTurretKills; 
	// Ranked Solo 5x5 Stats
	private long rChampKills, rAssists, rMinionKills, rNeutralMonsterKills, rTotalTurretKills;
	// Normal 3x3 Stats
	private long tvtChampKills, tvtAssists, tvtMinionKills, tvtNeutralMonsterKills, tvtTotalTurretKills;
	//One For All Stats
	private long ofaChampKills, ofaAssists, ofaMinionKills, ofaNeutralMonsterKills, ofaTotalTurretKills;
	//First Blood 1x1 Stats
	private long fb1ChampKills, fb1Assists, fb1MinionKills, fb1NeutralMonsterKills, fb1TotalTurretKills;
	//First Blood 2x2 Stats
	private long fb2ChampKills, fb2Assists, fb2MinionKills, fb2NeutralMonsterKills, fb2TotalTurretKills;
	//Hexakill Stats
	private long hexChampKills, hexAssists, hexMinionKills, hexNeutralMonsterKills, hexTotalTurretKills;
	//URF Stats
	private long urfChampKills, urfAssists, urfMinionKills, urfNeutralMonsterKills, urfTotalTurretKills;
	//Dominion Stats
	private long domWins, domChampKills, domAssists, domMostKills, domMostAssists, domHighestScore, domNodesCaptured, domMostNodesCaptured, domNodesNeutralized, domMostNodesNeutralized;  
	//Booleans for have played game modes
	private boolean hasPlayedRanked5v5 = false, hasPlayedNormal5v5 = false, hasPlayedDominion = false, hasPlayedNormal3v3 = false, hasPlayedofa = false, hasPlayedfb1 = false, hasPlayedfb2 = false, hasPlayedhex = false, hasPlayedurf = false;
	
	//Method to fetch summoner profile info in order to extract summoner ID, level and profile image.
	//REQUIRES INTERNET CONNECTION
	/*
		Prototype: void retrieveSummonerID();
		Parameter: none,
		Returns: none
		Description: Retrieves a given summoner's ID, profile and summoner level using the League of legends API
	*/
	private void retrieveSummonerID() throws IOException{
		String summonerInfo, newSummonerInfo, actualSummonerID;
		int index = 0;
		String summonerinfo = "https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/"+summonerName+apikey;
		
		URL info = new URL(summonerinfo);
		URLConnection yc1 = info.openConnection();
		BufferedReader summonerInfoReader = new BufferedReader(new InputStreamReader(yc1.getInputStream()));
		summonerInfo = summonerInfoReader.readLine();
	
		// Parse summoner Info to extract summonerID
		newSummonerInfo = summonerInfo.substring(summonerName.length() + 9);
		index = newSummonerInfo.indexOf(",");	
		actualSummonerID = newSummonerInfo.substring(1, index);
		this.summonerID = actualSummonerID;
	
		//Parse summoner Info to extract profile picture
		newSummonerInfo = summonerInfo.substring(2*summonerName.length() + summonerID.length() + 36);
		index = newSummonerInfo.indexOf(",");	
		profileIcon = newSummonerInfo.substring(1, index);
	
		//Parse summonerInfo to extract level
		newSummonerInfo = newSummonerInfo.substring(profileIcon.length() + 17);
		index = newSummonerInfo.indexOf(",");	
		this.level = newSummonerInfo.substring(1, index);
	}

	//Method to fetch summoner stats summary which includes general/lifelong stats for all game modes.
	//REQUIRES INTERNET CONNECTION
	/*
		Prototype: void retrieveSummonerStats();
		Parameter: none
		Returns: none
		Description: Retrieves a given summoner's stat summary using the League of legends API
	*/
	private void retrieveSummonerStats() throws IOException, JSONException {
		String statsrequest = "https://na.api.pvp.net/api/lol/na/v1.3/stats/by-summoner/" + summonerID + "/summary" + apikey;
		URL oracle = new URL(statsrequest);
		URLConnection yc = oracle.openConnection();
		this.summonerStats = new SummonerStats(yc.getInputStream());
		statsExtract();
	}

	//Method to retrieve each "relevant" stat from the stats summary of the given summoner.
	/*
		Prototype: void statsExtractID();
		Parameter: none
		Returns: none
		Description: Extracts all the relevant stats from the stats summary of the given summoner.
	*/
	private void statsExtract() throws JSONException {

	//Normal Stats
	try{	
		if((summonerStats.hasSummary("Unranked")) && (summonerStats.getSummary("Unranked").hasAggregatedStats())){
			this.hasPlayedNormal5v5 = true;
			this.unrankedWins         = summonerStats.getSummary("Unranked").getField("wins");
			this.nAssists	          = summonerStats.getSummary("Unranked").getAggregatedStat("totalAssists");
			this.nChampKills          = summonerStats.getSummary("Unranked").getAggregatedStat("totalChampionKills");
			this.nMinionKills         = summonerStats.getSummary("Unranked").getAggregatedStat("totalMinionKills");
			this.nNeutralMonsterKills = summonerStats.getSummary("Unranked").getAggregatedStat("totalNeutralMinionsKilled");
			this.nTotalTurretKills    = summonerStats.getSummary("Unranked").getAggregatedStat("totalTurretsKilled");
		}
	} catch (JSONException e){
		this.unranked3x3Wins = 0;
		this.nChampKills = 0;
		this.nAssists = 0;
		this.nMinionKills = 0;
		this.nNeutralMonsterKills = 0;
		this.nTotalTurretKills = 0;
	}

	//Ranked 5v5
	try{
		if((summonerStats.hasSummary("RankedSolo5x5")) && (summonerStats.getSummary("RankedSolo5x5").hasAggregatedStats())){ 
			this.rankedSolo5x5Wins    = summonerStats.getSummary("RankedSolo5x5").getField("wins");
			this.rankedSolo5x5Losses  = summonerStats.getSummary("RankedSolo5x5").getField("losses");
			this.rAssists             = summonerStats.getSummary("RankedSolo5x5").getAggregatedStat("totalAssists");
			this.rChampKills          = summonerStats.getSummary("RankedSolo5x5").getAggregatedStat("totalChampionKills");
			this.rMinionKills         = summonerStats.getSummary("RankedSolo5x5").getAggregatedStat("totalMinionKills");
			this.rNeutralMonsterKills = summonerStats.getSummary("RankedSolo5x5").getAggregatedStat("totalNeutralMinionsKilled");
			this.rTotalTurretKills    = summonerStats.getSummary("RankedSolo5x5").getAggregatedStat("totalTurretsKilled");
			if((rankedSolo5x5Wins != 0) && (rankedSolo5x5Losses != 0)){
				this.hasPlayedRanked5v5 = true;
			}
		}
	} catch (JSONException e){
		this.rankedSolo5x5Wins = 0;
		this.rChampKills = 0;
		this.rAssists = 0;
		this.rMinionKills = 0;
		this.rNeutralMonsterKills = 0;
		this.rTotalTurretKills = 0;
	}
	
	//Dominion stats
	try{
		if((summonerStats.hasSummary("OdinUnranked")) && (summonerStats.getSummary("OdinUnranked").hasAggregatedStats())){
			this.hasPlayedDominion = true;
			this.domWins                 = summonerStats.getSummary("OdinUnranked").getField("wins");
			this.domAssists              = summonerStats.getSummary("OdinUnranked").getAggregatedStat("totalAssists");
			this.domChampKills           = summonerStats.getSummary("OdinUnranked").getAggregatedStat("totalChampionKills");
			this.domHighestScore	     = summonerStats.getSummary("OdinUnranked").getAggregatedStat("maxTotalPlayerScore");
			this.domMostAssists	         = summonerStats.getSummary("OdinUnranked").getAggregatedStat("maxAssists");
			this.domMostKills	         = summonerStats.getSummary("OdinUnranked").getAggregatedStat("maxChampionsKilled");
			this.domMostNodesCaptured    = summonerStats.getSummary("OdinUnranked").getAggregatedStat("maxNodeCapture");
			this.domMostNodesNeutralized = summonerStats.getSummary("OdinUnranked").getAggregatedStat("maxNodeNeutralize");
			this.domNodesCaptured 	     = summonerStats.getSummary("OdinUnranked").getAggregatedStat("totalNodeCapture");
			this.domNodesNeutralized	 = summonerStats.getSummary("OdinUnranked").getAggregatedStat("totalNodeNeutralize");
		}
	} catch (JSONException e){
		this.domWins = 0;
		this.domChampKills = 0;
		this.domAssists = 0;
		this.domMostAssists = 0;
		this.domMostKills = 0;
		this.domHighestScore = 0;
		this.domNodesCaptured = 0;
		this.domMostNodesCaptured = 0;
		this.domNodesNeutralized = 0;
		this.domMostNodesNeutralized = 0;
	}

	// Normal 3v3
	try{
		if((summonerStats.hasSummary("Unranked3x3")) && (summonerStats.getSummary("Unranked3x3").hasAggregatedStats())){
			this.hasPlayedNormal3v3 = true;
			this.unranked3x3Wins        = summonerStats.getSummary("Unranked3x3").getField("wins");
			this.tvtAssists	    = summonerStats.getSummary("Unranked3x3").getAggregatedStat("totalAssists");
			this.tvtChampKills          = summonerStats.getSummary("Unranked3x3").getAggregatedStat("totalChampionKills");
			this.tvtMinionKills         = summonerStats.getSummary("Unranked3x3").getAggregatedStat("totalMinionKills");
			this.tvtNeutralMonsterKills = summonerStats.getSummary("Unranked3x3").getAggregatedStat("totalNeutralMinionsKilled");
			this.tvtTotalTurretKills    = summonerStats.getSummary("Unranked3x3").getAggregatedStat("totalTurretsKilled");
		}
	} catch (JSONException e){
		this.unranked3x3Wins = 0;
		this.tvtChampKills = 0;
		this.tvtAssists = 0;
		this.tvtMinionKills = 0;
		this.tvtNeutralMonsterKills = 0;
		this.tvtTotalTurretKills = 0;
	}

	//Ranked Premade 3v3
	if(summonerStats.hasSummary("RankedPremade3x3")){
	this.rankedPremade3x3Wins = summonerStats.getSummary("RankedPremade3x3").getField("wins");
	}

	//Ranked Premade 5v5
	if(summonerStats.hasSummary("RankedPremade5x5")){
	this.rankedPremade5x5Wins = summonerStats.getSummary("RankedPremade5x5").getField("wins");
	}

	//Ranked Team 3v3
	if(summonerStats.hasSummary("RankedTeam3x3")){
	this.rankedTeam3x3Wins    = summonerStats.getSummary("RankedTeam3x3").getField("wins");
	}

	//Ranked Team 5v5
	if(summonerStats.hasSummary("RankedTeam5x5")){
	this.rankedTeam5x5Wins    = summonerStats.getSummary("RankedTeam5x5").getField("wins");
	}

	//Coop Vs AI
	if(summonerStats.hasSummary("CoopVsAI")){
	this.coopVsAIWins         = summonerStats.getSummary("CoopVsAI").getField("wins");
	}

	//One For All Stats
	try{
		if((summonerStats.hasSummary("OneForAll5x5")) && (summonerStats.getSummary("OneForAll5x5").hasAggregatedStats())){
			this.hasPlayedofa = true;
			this.ofaWins                = summonerStats.getSummary("OneForAll5x5").getField("wins");
			this.ofaAssists	    		= summonerStats.getSummary("OneForAll5x5").getAggregatedStat("totalAssists");
			this.ofaChampKills          = summonerStats.getSummary("OneForAll5x5").getAggregatedStat("totalChampionKills");
			this.ofaMinionKills         = summonerStats.getSummary("OneForAll5x5").getAggregatedStat("totalMinionKills");
			this.ofaNeutralMonsterKills = summonerStats.getSummary("OneForAll5x5").getAggregatedStat("totalNeutralMinionsKilled");
			this.ofaTotalTurretKills    = summonerStats.getSummary("OneForAll5x5").getAggregatedStat("totalTurretsKilled");
		}
	} catch (JSONException e){
		this.ofaWins = 0;
		this.ofaChampKills = 0;
		this.ofaAssists = 0;
		this.ofaMinionKills = 0;
		this.ofaNeutralMonsterKills = 0;
		this.ofaTotalTurretKills = 0;
	}

	//First Blood 1x1 Stats
	try{
		if((summonerStats.hasSummary("FirstBlood1x1")) && (summonerStats.getSummary("FirstBlood1x1").hasAggregatedStats())){
			this.hasPlayedfb1 = true;
			this.fb1Wins                = summonerStats.getSummary("FirstBlood1x1").getField("wins");
			this.fb1Assists	    = summonerStats.getSummary("FirstBlood1x1").getAggregatedStat("totalAssists");
			this.fb1ChampKills          = summonerStats.getSummary("FirstBlood1x1").getAggregatedStat("totalChampionKills");
			this.fb1MinionKills         = summonerStats.getSummary("FirstBlood1x1").getAggregatedStat("totalMinionKills");
			this.fb1NeutralMonsterKills = summonerStats.getSummary("FirstBlood1x1").getAggregatedStat("totalNeutralMinionsKilled");
			this.fb1TotalTurretKills    = summonerStats.getSummary("FirstBlood1x1").getAggregatedStat("totalTurretsKilled");
		}
	} catch (JSONException e) {
		this.fb1Wins = 0;
		this.fb1ChampKills = 0;
		this.fb1Assists = 0;
		this.fb1MinionKills = 0;
		this.fb1NeutralMonsterKills = 0;
		this.fb1TotalTurretKills = 0;
	}

	//First Blood 2x2 Stats
	try {
		if((summonerStats.hasSummary("FirstBlood2x2")) && (summonerStats.getSummary("FirstBlood2x2").hasAggregatedStats())){
			this.hasPlayedfb2 = true;
			this.fb2Wins                = summonerStats.getSummary("FirstBlood2x2").getField("wins");
			this.fb2Assists	    		= summonerStats.getSummary("FirstBlood2x2").getAggregatedStat("totalAssists");
			this.fb2ChampKills          = summonerStats.getSummary("FirstBlood2x2").getAggregatedStat("totalChampionKills");
			this.fb2MinionKills         = summonerStats.getSummary("FirstBlood2x2").getAggregatedStat("totalMinionKills");
			this.fb2NeutralMonsterKills = summonerStats.getSummary("FirstBlood2x2").getAggregatedStat("totalNeutralMinionsKilled");
			this.fb2TotalTurretKills    = summonerStats.getSummary("FirstBlood2x2").getAggregatedStat("totalTurretsKilled");
		}
	} catch (JSONException e){
		this.fb2Wins = 0;
		this.fb2ChampKills = 0;
		this.fb2Assists = 0;
		this.fb2MinionKills = 0;
		this.fb2NeutralMonsterKills = 0;
		this.fb2TotalTurretKills = 0;
	}
	
	//Hexakill Stats
	try{
		if((summonerStats.hasSummary("SummonersRift6x6")) && (summonerStats.getSummary("SummonersRift6x6").hasAggregatedStats())){
			this.hasPlayedhex = true;
			this.hexWins                = summonerStats.getSummary("SummonersRift6x6").getField("wins");
			this.hexAssists	   		    = summonerStats.getSummary("SummonersRift6x6").getAggregatedStat("totalAssists");
			this.hexChampKills          = summonerStats.getSummary("SummonersRift6x6").getAggregatedStat("totalChampionKills");
			this.hexMinionKills         = summonerStats.getSummary("SummonersRift6x6").getAggregatedStat("totalMinionKills");
			this.hexNeutralMonsterKills = summonerStats.getSummary("SummonersRift6x6").getAggregatedStat("totalNeutralMinionsKilled");
			this.hexTotalTurretKills    = summonerStats.getSummary("SummonersRift6x6").getAggregatedStat("totalTurretsKilled");
		}
	} catch (JSONException e){
		this.hexChampKills = 0;
		this.hexAssists = 0;
		this.hexMinionKills = 0;
		this.hexNeutralMonsterKills = 0;
		this.hexTotalTurretKills = 0;
	}

	//URF Stats
	try{
		if((summonerStats.hasSummary("URF")) && (summonerStats.getSummary("URF").hasAggregatedStats())){
			this.hasPlayedurf = true;
			this.urfWins                = summonerStats.getSummary("URF").getField("wins");
			this.urfAssists	   	    	= summonerStats.getSummary("URF").getAggregatedStat("totalAssists");
			this.urfChampKills          = summonerStats.getSummary("URF").getAggregatedStat("totalChampionKills");
			this.urfMinionKills         = summonerStats.getSummary("URF").getAggregatedStat("totalMinionKills");
			this.urfNeutralMonsterKills = summonerStats.getSummary("URF").getAggregatedStat("totalNeutralMinionsKilled");
			this.urfTotalTurretKills    = summonerStats.getSummary("URF").getAggregatedStat("totalTurretsKilled");
		}
	} catch (JSONException e){
		this.urfWins = 0;
		this.urfChampKills = 0;
		this.urfAssists = 0;
		this.urfMinionKills = 0;
		this.urfNeutralMonsterKills = 0;
		this.urfTotalTurretKills = 0;
	}
	}
	
	//Constructor that initializes the stats to avoid unexpected results and initiates the API stats requests
	/*
		Prototype: StatsPull();
		Parameter: none
		Returns: none
		Description: Initializes stats and initiates the API stats requests.
	*/
	public StatsPull(String givenSummonerName) throws IOException, JSONException{
	//Initializations to prevent unexpected outputs
	summonerID = "0";
	profileIcon = "607";
	level = "0";
	rankedPremade3x3Wins = 0;
	rankedPremade5x5Wins = 0;
	rankedTeam3x3Wins = 0;
	rankedTeam5x5Wins = 0;
	rankedSolo5x5Wins = 0;
	rankedSolo5x5Losses = 0;
	unrankedWins = 0;
	unranked3x3Wins = 0;
	coopVsAIWins = 0;
	ofaWins = 0;
	fb1Wins = 0;
	fb2Wins = 0;
	hexWins = 0;
	urfWins = 0;
	nChampKills = 0;
	nAssists = 0;
	nMinionKills = 0;
	nNeutralMonsterKills = 0;
	nTotalTurretKills = 0;
	rChampKills = 0;
	rAssists = 0;
	rMinionKills = 0;
	rNeutralMonsterKills = 0;
	rTotalTurretKills = 0;
	tvtChampKills = 0;
	tvtAssists = 0;
	tvtMinionKills = 0;
	tvtNeutralMonsterKills = 0;
	tvtTotalTurretKills = 0;
	ofaChampKills = 0;
	ofaAssists = 0;
	ofaMinionKills = 0;
	ofaNeutralMonsterKills = 0;
	ofaTotalTurretKills = 0;
	fb1ChampKills = 0;
	fb1Assists = 0;
	fb1MinionKills = 0;
	fb1NeutralMonsterKills = 0;
	fb1TotalTurretKills = 0;
	fb2ChampKills = 0;
	fb2Assists = 0;
	fb2MinionKills = 0;
	fb2NeutralMonsterKills = 0;
	fb2TotalTurretKills = 0;
	hexChampKills = 0;
	hexAssists = 0;
	hexMinionKills = 0;
	hexNeutralMonsterKills = 0;
	hexTotalTurretKills = 0;
	urfChampKills = 0;
	urfAssists = 0;
	urfMinionKills = 0;
	urfNeutralMonsterKills = 0;
	urfTotalTurretKills = 0;
	domWins = 0;
	domChampKills = 0;
	domAssists = 0;
	domMostAssists = 0;
	domMostKills = 0;
	domHighestScore = 0;
	domNodesCaptured = 0;
	domMostNodesCaptured = 0;
	domNodesNeutralized = 0;
	domMostNodesNeutralized = 0;

	this.summonerName = givenSummonerName;
	this.retrieveSummonerID();
	try {
		this.retrieveSummonerStats();
	} catch (JSONException e) {
		System.err.println(e);
		throw e;
		//System.exit(1);
	} catch (IOException io){
		System.err.println(io);
		throw io;
	}
	}

	// Getter Methods
	public String getSummonerName() {
	return summonerName;
	}

	public String getSummonerID() {
	return summonerID;
	}

	public String getProfileIcon(){
	return profileIcon;
	}

	public String getLevel(){
	return level;
	}

	public SummonerStats getSummonerStats() {
	return summonerStats;
	}

	public long getRankedPremade3x3Wins() {
	return rankedPremade3x3Wins;
	}

	public long getRankedPremade5x5Wins() {
	return rankedPremade5x5Wins;
	}

	public long getRankedTeam3x3Wins() {
	return rankedTeam3x3Wins;
	}

	public long getRankedTeam5x5Wins() {
	return rankedTeam5x5Wins;
	}

	public long getRankedSolo5x5Wins() {
	return rankedSolo5x5Wins;
	}
	
	public long getRankedSolo5x5Losses() {
	return rankedSolo5x5Losses;
	}
	
	public long getUnrankedWins() {
	return unrankedWins;
	}

	public long getUnranked3x3Wins(){
	return unranked3x3Wins;
	}


	public long getCoopVsAIWins() {
	return coopVsAIWins;
	}

	public long getnChampKills() {
	return nChampKills;
	}

	public long getnAssists() {
	return nAssists;
	}

	public long getnMinionKills() {
	return nMinionKills;
	}

	public long getnNeutralMonsterKills() {
	return nNeutralMonsterKills;
	}

	public long getnTotalTurretKills() {
	return nTotalTurretKills;
	}

	public long getrChampKills() {
	return rChampKills;
	}

	public long getrAssists() {
	return rAssists;
	}

	public long getrMinionKills() {
	return rMinionKills;
	}

	public long getrNeutralMonsterKills() {
	return rNeutralMonsterKills;
	}

	public long getrTotalTurretKills() {
	return rTotalTurretKills;
	}

	public long getTvtChampKills() {
	return tvtChampKills;
	}

	public long getTvtAssists() {
	return tvtAssists;
	}

	public long getTvtMinionKills() {
	return tvtMinionKills;
	}

	public long getTvtNeutralMonsterKills() {
	return tvtNeutralMonsterKills;
	}

	public long getTvtTotalTurretKills() {
	return tvtTotalTurretKills;
	}
	public long getOfaWins(){
	return ofaWins;
	}
	public long getOfaChampKills() {
	return ofaChampKills;
	}

	public long getOfaAssists() {
	return ofaAssists;
	}

	public long getOfaMinionKills() {
	return ofaMinionKills;
	}

	public long getOfaNeutralMonsterKills() {
	return ofaNeutralMonsterKills;
	}

	public long getOfaTotalTurretKills() {
	return ofaTotalTurretKills;
	}
	public long getFb1Wins(){
	return fb1Wins;
	}
	public long getFb1ChampKills() {
	return fb1ChampKills;
	}
	public long getFb1Assists() {
	return fb1Assists;
	}
	public long getFb1MinionKills() {
	return fb1MinionKills;
	}
	public long getFb1NeutralMonsterKills() {
	return fb1NeutralMonsterKills;
	}
	public long getFb1TotalTurretKills() {
	return fb1TotalTurretKills;
	}
	public long getFb2Wins(){
	return fb2Wins;
	}
	public long getFb2ChampKills() {
	return fb2ChampKills;
	}
	public long getFb2Assists() {
	return fb2Assists;
	}
	public long getFb2MinionKills() {
	return fb2MinionKills;
	}
	public long getFb2NeutralMonsterKills() {
	return fb2NeutralMonsterKills;
	}
	public long getFb2TotalTurretKills() {
	return fb2TotalTurretKills;
	}
	public long getHexWins(){
	return hexWins;
	}
	public long getHexChampKills() {
	return hexChampKills;
	}
	public long getHexAssists() {
	return hexAssists;
	}
	public long getHexMinionKills() {
	return hexMinionKills;
	}
	public long getHexNeutralMonsterKills() {
	return hexNeutralMonsterKills;
	}
	public long getHexTotalTurretKills() {
	return hexTotalTurretKills;
	}
	public long getUrfWins(){
	return urfWins;
	}
	public long getUrfChampKills() {
	return urfChampKills;
	}
	public long getUrfAssists() {
	return urfAssists;
	}
	public long getUrfMinionKills() {
	return urfMinionKills;
	}
	public long getUrfNeutralMonsterKills() {
	return urfNeutralMonsterKills;
	}
	public long getUrfTotalTurretKills() {
	return urfTotalTurretKills;
	}

	public long getDomWins() {
	return domWins;
	}

	public long getDomChampKills() {
	return domChampKills;
	}

	public long getDomAssists() {
	return domAssists;
	}

	public long getDomMostKills() {
	return domMostKills;
	}

	public long getDomMostAssists() {
	return domMostAssists;
	}

	public long getDomHighestScore() {
	return domHighestScore;
	}

	public long getDomNodesCaptured() {
	return domNodesCaptured;
	}

	public long getDomMostNodesCaptured() {
	return domMostNodesCaptured;
	}

	public long getDomNodesNeutralized() {
	return domNodesNeutralized;
	}

	public long getDomMostNodesNeutralized() {
	return domMostNodesNeutralized;
	}

	public boolean isHasPlayedRanked5v5() {
		return hasPlayedRanked5v5;
	}

	public boolean isHasPlayedNormal5v5() {
		return hasPlayedNormal5v5;
	}

	public boolean isHasPlayedDominion() {
		return hasPlayedDominion;
	}

	public boolean isHasPlayedNormal3v3() {
		return hasPlayedNormal3v3;
	}

	public boolean isHasPlayedofa() {
		return hasPlayedofa;
	}

	public boolean isHasPlayedfb1() {
		return hasPlayedfb1;
	}

	public boolean isHasPlayedfb2() {
		return hasPlayedfb2;
	}

	public boolean isHasPlayedhex() {
		return hasPlayedhex;
	}

	public boolean isHasPlayedurf() {
		return hasPlayedurf;
	}
}