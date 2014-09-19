package lolapi.dto.Game;

import java.util.ArrayList;

public class Games {
	private	int	championId;						//Champion ID associated with game.
	private	long createDate;					//Date that end game data was recorded, specified as epoch milliseconds.
	private	ArrayList<Player> fellowPlayers;	//	Other players associated with the game.
	private	long gameId;						//Game ID.
	private	String gameMode	;					//Game mode. (legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, FIRSTBLOOD)
	private	String gameType	;					//Game type. (legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME)
	private	boolean invalid	;					//Invalid flag.
	private	int level;							//Level.
	private	int mapId;							//Map ID.
	private	int spell1;							//ID of first summoner spell.
	private	int spell2;							//ID of second summoner spell.
	private	RawStats stats;					//Statistics associated with the game for this summoner.
	private	String subType;						//Game sub-type. (legal values: NONE, NORMAL, BOT, RANKED_SOLO_5x5, RANKED_PREMADE_3x3, RANKED_PREMADE_5x5, ODIN_UNRANKED, RANKED_TEAM_3x3, RANKED_TEAM_5x5, NORMAL_3x3, BOT_3x3, ARAM_UNRANKED_5x5, ONEFORALL_5x5, FIRSTBLOOD_1x1, FIRSTBLOOD_2x2)
	private	int teamId;		 					//Team ID associated with game.
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
	 * @return the createDate
	 */
	public long getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the fellowPlayers
	 */
	public ArrayList<Player> getFellowPlayers() {
		return fellowPlayers;
	}
	/**
	 * @param fellowPlayers the fellowPlayers to set
	 */
	public void setFellowPlayers(ArrayList<Player> fellowPlayers) {
		this.fellowPlayers = fellowPlayers;
	}
	/**
	 * @return the gameId
	 */
	public long getGameId() {
		return gameId;
	}
	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	/**
	 * @return the gameMode
	 */
	public String getGameMode() {
		return gameMode;
	}
	/**
	 * @param gameMode the gameMode to set
	 */
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	/**
	 * @return the gameType
	 */
	public String getGameType() {
		return gameType;
	}
	/**
	 * @param gameType the gameType to set
	 */
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	/**
	 * @return the invalid
	 */
	public boolean isInvalid() {
		return invalid;
	}
	/**
	 * @param invalid the invalid to set
	 */
	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the mapId
	 */
	public int getMapId() {
		return mapId;
	}
	/**
	 * @param mapId the mapId to set
	 */
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	/**
	 * @return the spell1
	 */
	public int getSpell1() {
		return spell1;
	}
	/**
	 * @param spell1 the spell1 to set
	 */
	public void setSpell1(int spell1) {
		this.spell1 = spell1;
	}
	/**
	 * @return the spell2
	 */
	public int getSpell2() {
		return spell2;
	}
	/**
	 * @param spell2 the spell2 to set
	 */
	public void setSpell2(int spell2) {
		this.spell2 = spell2;
	}
	/**
	 * @return the stats
	 */
	public RawStats getStats() {
		return stats;
	}
	/**
	 * @param stats the stats to set
	 */
	public void setStats(RawStats stats) {
		this.stats = stats;
	}
	/**
	 * @return the subType
	 */
	public String getSubType() {
		return subType;
	}
	/**
	 * @param subType the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
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
