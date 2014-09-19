package lolapi.dto.Game;

import java.util.ArrayList;

public class RecentGames {
	private ArrayList<Games> games;
	private long summonerId;
	/**
	 * @return the games
	 */
	public ArrayList<Games> getGames() {
		return games;
	}
	/**
	 * @return the summonerId
	 */
	public long getSummonerId() {
		return summonerId;
	}
	
}
