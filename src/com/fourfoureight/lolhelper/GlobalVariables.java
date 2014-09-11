package com.fourfoureight.lolhelper;

import android.app.Application;

public class GlobalVariables extends Application
{

	private int language = 1; // 1 = English, 2 = German, 3 = Spanish, 4 = French, 5 = Italian

	private int skin = 1; // (could have 'secret 0' be the scrolls lol, 1 = alpha skin, 2 = release skin (tbd)

	private String userSummonerName = "";
	// Main Menu Strings
	private String championSelectString = "Champion Select";
	private String inGameString = "In Game";
	private String playerStatsString = "Player Stats";
	private String generalInfoString = "General Info";
	private String optionsString = "Options";
	private String aboutString = "About";
	private String teamBuilderString = "Team Builder";
	private String countersString = "Counters";
	private String ultimateBraveryString = "Ultimate Bravery";
	private String buildGuidesString = "Build Guides";
	private String jungleTimerString = "Jungle Timer";
	private String championsString = "Champions";
	private String itemsString = "Items";
	private String summonerSpellsString = "Summoner Spells";
	// Options Menu Strings
	private String summonerNameString = "Summoner Name:";
	private String languageString = "Language:";
	private String skinString = "Skin:";
	private String enterString = "Enter";
	private String betaString = "Beta";
	private String releaseString = "Release";
	// About Menu Strings
	private String createdByString = "Created by Team 4th Dimension";
	private String aboutRolesRightString = "\nLeader, Documentation\nProject Analyst, Programmer\nProgrammer (App Design)\nProgrammer (Item Builds)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (General Info)\nProgrammer (General Info)\nProgrammer (Timers)\nProgrammer (Timers)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nBusiness Consultant, Programmer (General Info)\nDesign\n";
	private final String versionNumberString = "0.9.008"; // # of commits minus 182 for beta
	private String versionString = "Version " + versionNumberString;

	public void setStrings()
	{
		if (language == 1) // English
		{
			// Main menu
			this.championSelectString = "Champion Select";
			this.inGameString = "In Game";
			this.playerStatsString = "Player Stats";
			this.generalInfoString = "General Info";
			this.optionsString = "Options";
			this.aboutString = "About";
			this.teamBuilderString = "Team Builder";
			this.countersString = "Counters";
			this.ultimateBraveryString = "Ultimate Bravery";
			this.buildGuidesString = "Build Guides";
			this.jungleTimerString = "Jungle Timer";
			this.championsString = "Champions";
			this.itemsString = "Items";
			this.summonerSpellsString = "Summoner Spells";
			// Options menu
			this.summonerNameString = "Summoner Name:";
			this.languageString = "Language:";
			this.skinString = "Skin:";
			this.enterString = "Enter";
			this.betaString = "Beta";
			this.releaseString = "Release";
			// About menu
			this.createdByString = "Created by Team 4th Dimension";
			this.aboutRolesRightString = "\nLeader, Documentation\nProject Analyst, Programmer\nProgrammer (App Design)\nProgrammer (Item Builds)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (General Info)\nProgrammer (General Info)\nProgrammer (Timers)\nProgrammer (Timers)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nBusiness Consultant, Programmer (General Info)\nDesign\n";
			this.versionString = "Version " + versionNumberString;
		}
		else if (language == 2) // German, currently a direct translation so probably sucks ass
		{
			// Main menu
			this.championSelectString = "Beschwörer Wählen";
			this.inGameString = "Im Spiel";
			this.playerStatsString = "Spieler-Statistik";
			this.generalInfoString = "Allgemein Info";
			this.optionsString = "Optionen";
			this.aboutString = "Über";
			this.teamBuilderString = "Team-Hersteller";
			this.countersString = "Gegenzüge";
			this.ultimateBraveryString = "Ultimate Bravery";
			this.buildGuidesString = "Itemaufbau";
			this.jungleTimerString = "Dschungel-Timer";
			this.championsString = "Champions";
			this.itemsString = "Gegenstände";
			this.summonerSpellsString = "Beschwörerzauber";
			// Options menu
			this.summonerNameString = "Beschwörer";
			this.languageString = "Sprache:";
			this.skinString = "Skin:";
			this.enterString = "Eingeben";
			this.betaString = "Beta";
			this.releaseString = "Freigabe";
			// About menu
			this.createdByString = "Erstellt von Team 4th Dimension";
			this.aboutRolesRightString = "\nFührer, Dokumentation\nProjekt-Analyst, Programmierer\nProgrammierer (App-Design)\nProgrammierer (Artikel Baut)\nProgrammierer (Spieler-Statistik)\nProgrammierer (Spieler-Statistik)\nProgrammierer (Spieler-Statistik)\nProgrammierer (Allgemeine Infos)\nProgrammierer (Allgemeine Infos)\nProgrammierer (Timer)\nProgrammierer (Timer)\nProgrammierer (Team-Builder)\nProgrammierer (Team-Builder)\nProgrammierer (Team-Builder)\nUnternehmensberater, Programmierer (Allgemeine Infos)\nDesign\n";
			this.versionString = "Version " + versionNumberString;
		}
		else if (language == 3) // Spanish, currently a direct translation so probably sucks ass
		{
			// Main menu
			this.championSelectString = "Selecci�n de Campe�n";
			this.inGameString = "En Juego";
			this.playerStatsString = "Estad�sticas de los Jugadores";
			this.generalInfoString = "Info General";
			this.optionsString = "Opciones";
			this.aboutString = "Acerca de";
			this.teamBuilderString = "Equipo Constructor";
			this.countersString = "Contra";
			this.ultimateBraveryString = "Valent�a Final";
			this.buildGuidesString = "Construir Gu�as";
			this.jungleTimerString = "Temporizador Selva";
			this.championsString = "Campeones";
			this.itemsString = "Art�culos";
			this.summonerSpellsString = "Hechizos de Invocador";
			// Options menu
			this.summonerNameString = "Nombre Del Invocador:";
			this.languageString = "Idioma:";
			this.skinString = "Piel:";
			this.enterString = "Entrar";
			this.betaString = "Beta";
			this.releaseString = "Lanzamiento";
			// About menu
			this.createdByString = "Creado por Team 4th Dimension";
			this.aboutRolesRightString = "\nLeader, Documentation\nProject Analyst, Programmer\nProgrammer (App Design)\nProgrammer (Item Builds)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (General Info)\nProgrammer (General Info)\nProgrammer (Timers)\nProgrammer (Timers)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nBusiness Consultant, Programmer (General Info)\nDesign\n";
			this.versionString = "Versi�n " + versionNumberString;
		}
		else if (language == 4) // French, currently a direct translation so probably sucks ass
		{
			// Main menu
			this.championSelectString = "Champion S�lectionner";
			this.inGameString = "Dans le Jeu";
			this.playerStatsString = "Statistiques des Joueurs";
			this.generalInfoString = "Information G�n�rale";
			this.optionsString = "Les Options";
			this.aboutString = "A propos";
			this.teamBuilderString = "B�tisseur d'Equipe";
			this.countersString = "Contre";
			this.ultimateBraveryString = "Bravoure Ultime";
			this.buildGuidesString = "Construire Guides";
			this.jungleTimerString = "Minuterie Jungle";
			this.championsString = "Champions";
			this.itemsString = "Articles";
			this.summonerSpellsString = "Sorts d'Invocateur";
			// Options menu
			this.summonerNameString = "Nom D'Invocateur:";
			this.languageString = "Langue:";
			this.skinString = "Peau:";
			this.enterString = "Entrer";
			this.betaString = "B�ta";
			this.releaseString = "Lancement";
			// About menu
			this.createdByString = "Cr��e par Team 4th Dimension";
			this.aboutRolesRightString = "\nLeader, Documentation\nProject Analyst, Programmer\nProgrammer (App Design)\nProgrammer (Item Builds)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (General Info)\nProgrammer (General Info)\nProgrammer (Timers)\nProgrammer (Timers)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nBusiness Consultant, Programmer (General Info)\nDesign\n";
			this.versionString = "Version " + versionNumberString;
		}
		else if (language == 5) // Italian, currently a direct translation so probably sucks ass
		{
			// Main menu
			this.championSelectString = "Selezione Campione";
			this.inGameString = "In Gioco";
			this.playerStatsString = "Statistiche Giocatore";
			this.generalInfoString = "Informazione Generale";
			this.optionsString = "Scelte";
			this.aboutString = "Circa"; // unsure
			this.teamBuilderString = "Costruttore della Squadra";
			this.countersString = "Awersario"; // unsure
			this.ultimateBraveryString = "Ultimate Bravery";
			this.buildGuidesString = "Guide di Construzione";
			this.jungleTimerString = "Timer del Jungle";
			this.championsString = "Campioni";
			this.itemsString = "Oggetti";
			this.summonerSpellsString = "Summoner Spells";
			// Options menu
			this.summonerNameString = "Nome del Summoner:";
			this.languageString = "Lingua:";
			this.skinString = "Skin:";
			this.enterString = "Inserire"; // unsure
			this.betaString = "Beta";
			this.releaseString = "Rilascio"; // unsure
			// About menu
			this.createdByString = "Creato di Team 4th Dimension";
			this.aboutRolesRightString = "\nLeader, Documentation\nProject Analyst, Programmer\nProgrammer (App Design)\nProgrammer (Item Builds)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (Player Stats)\nProgrammer (General Info)\nProgrammer (General Info)\nProgrammer (Timers)\nProgrammer (Timers)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nProgrammer (Team Builder)\nBusiness Consultant, Programmer (General Info)\nDesign\n";
			this.versionString = "Versione " + versionNumberString;
		}
	}

	// Strings used in the main menu

	public String getChampionSelectString()
	{
		return championSelectString;
	}

	public void setChampionSelectString(String x)
	{
		this.championSelectString = x;
	}

	public String getInGameString()
	{
		return inGameString;
	}

	public void setInGameString(String x)
	{
		this.inGameString = x;
	}

	public String getPlayerStatsString()
	{
		return playerStatsString;
	}

	public void setPlayerStatsString(String x)
	{
		this.playerStatsString = x;
	}

	public String getGeneralInfoString()
	{
		return generalInfoString;
	}

	public void setGeneralInfoString(String x)
	{
		this.generalInfoString = x;
	}

	public String getOptionsString()
	{
		return optionsString;
	}

	public void setOptionsString(String x)
	{
		this.optionsString = x;
	}

	public String getAboutString()
	{
		return aboutString;
	}

	public void setAboutString(String x)
	{
		this.aboutString = x;
	}

	public String getTeamBuilderString()
	{
		return teamBuilderString;
	}

	public void setTeamBuilderString(String x)
	{
		this.teamBuilderString = x;
	}

	public String getCountersString()
	{
		return countersString;
	}

	public void setCountersString(String x)
	{
		this.countersString = x;
	}

	public String getUltimateBraveryString()
	{
		return ultimateBraveryString;
	}

	public void setUltimateBraveryString(String x)
	{
		this.ultimateBraveryString = x;
	}

	public String getBuildGuidesString()
	{
		return buildGuidesString;
	}

	public void setBuildGuidesString(String x)
	{
		this.buildGuidesString = x;
	}

	public String getJungleTimerString()
	{
		return jungleTimerString;
	}

	public void setJungleTimerString(String x)
	{
		this.jungleTimerString = x;
	}

	public String getChampionsString()
	{
		return championsString;
	}

	public void setChampionsString(String x)
	{
		this.championsString = x;
	}

	public String getItemsString()
	{
		return itemsString;
	}

	public void setItemsString(String x)
	{
		this.itemsString = x;
	}

	public String getSummonerSpellsString()
	{
		return summonerSpellsString;
	}

	public void setSummonerSpellsString(String x)
	{
		this.summonerSpellsString = x;
	}

	// Strings used in the options menu

	public String getSummonerNameString()
	{
		return summonerNameString;
	}

	public void setSummonerNameString(String x)
	{
		this.summonerNameString = x;
	}

	public String getLanguageString()
	{
		return languageString;
	}

	public void setLanguageString(String x)
	{
		this.languageString = x;
	}

	public String getSkinString()
	{
		return skinString;
	}

	public void setSkinString(String x)
	{
		this.skinString = x;
	}

	public String getEnterString()
	{
		return enterString;
	}

	public void setEnterString(String x)
	{
		this.enterString = x;
	}

	public String getBetaString()
	{
		return betaString;
	}

	public void setBetaString(String x)
	{
		this.betaString = x;
	}

	public String getReleaseString()
	{
		return releaseString;
	}

	public void setReleaseString(String x)
	{
		this.releaseString = x;
	}

	// Strings used in the about menu

	public String getCreatedByString()
	{
		return createdByString;
	}

	public void setCreatedByString(String x)
	{
		this.createdByString = x;
	}

	public String getAboutRolesRightString()
	{
		return aboutRolesRightString;
	}

	public void setAboutRolesRightString(String x)
	{
		this.aboutRolesRightString = x;
	}

	public String getVersionString()
	{
		return versionString;
	}

	public void setVersionString(String x)
	{
		this.versionString = x;
	}

	// Variables used cross-activity

	public int getLanguage()
	{
		return language;
	}

	public void setLanguage(int x)
	{
		this.language = x;
	}

	public int getskin()
	{
		return skin;
	}

	public void setskin(int x)
	{
		this.skin = x;
	}

	public String getUserSummonerName()
	{
		return userSummonerName;
	}

	public void setUserSummonerName(String x)
	{
		this.userSummonerName = x;
	}

	public int getChampionInt(String name)
	{
		String champions[] = { "aatrox", "ahri", "akali", "alistar", "amumu", "anivia", "annie", "ashe",
				"blitzcrank", "brand", "caitlyn", "cassiopeia", "chogath", "corki",
				"darius", "diana", "drmundo", "draven", "elise", "evelynn", "ezreal",
				"fiddlesticks", "fiora", "fizz", "galio", "gangplank", "garen", "gragas", "graves",
				"hecarim", "heimerdinger", "irelia", "janna", "jarvaniv", "jax", "jayce", "jinx",
				"karma", "karthus", "kassadin", "katarina", "kayle", "kennen", "khazix", "kogmaw",
				"leblanc", "leesin", "leona", "lissandra", "lucian", "lulu", "lux",
				"malphite", "malzahar", "maokai", "masteryi", "missfortune", "mordekaiser", "morgana",
				"nami", "nasus", "nautilius", "nidalee", "nocturne", "nunu", "olaf", "orianna",
				"pantheon", "poppy", "quinn", "rammus", "renekton", "rengar", "riven", "rumble", "ryze",
				"sejuani", "shaco", "shen", "shyvana", "singed", "sion", "sivir", "skarner", "sona", "soraka", "swain",
				"syndra",
				"talon", "taric", "teemo", "thresh", "tristana", "trundle", "tryndamere", "twistedfate", "twitch",
				"udyr", "urgot", "varus", "vayne", "veigar", "velkoz", "vi", "viktor", "vladimir", "volibear",
				"warwick", "wukong", "xerath", "xinzhao", "yasuo", "yorick", "zac", "zed", "ziggs", "zilean", "zyra" };
		for (int i = 0; i < champions.length; i++)
		{
			if (champions[i].equals(name))
			{
				return i;
			}
		}
		return -1;
	}
}
