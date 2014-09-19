package lolapi.dto.Game;

public class Player {
	private int championId;			//	Champion id associated with player.
	private long summonerId;		//	Summoner id associated with player.
	private int teamId;				//	Team id associated with player.
	/**
	 * @return the championId
	 */
	public int getChampionId() {
		return championId;
	}
	/**
	 * @param championId the championId to set
	 */
	public void setChampionId(int championId) {
		this.championId = championId;
	}
	/**
	 * @return the summonerId
	 */
	public long getSummonerId() {
		return summonerId;
	}
	/**
	 * @param summonerId the summonerId to set
	 */
	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}
	/**
	 * @return the teamId
	 */
	public int getTeamId() {
		return teamId;
	}
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
}
