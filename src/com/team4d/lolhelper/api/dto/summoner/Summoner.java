package com.team4d.lolhelper.api.dto.summoner;

import java.util.Map;


public class Summoner {
	Map<String, SummonerDto> map;
	
	public Map<String, SummonerDto> getMap(){
		return map;
	}
	
	public void setMap(Map<String, SummonerDto> map){
		this.map = map;
	}
}
