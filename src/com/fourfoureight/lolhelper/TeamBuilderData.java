package com.fourfoureight.lolhelper;

import com.fourfoureight.lolhelper.General_Info.ChampionAttributes;

// Description:
// Utility class for Team Builder, contains all the data processing methods.
// Caller: TeamBuilder.java
public class TeamBuilderData{

	public static final int numOfChampions = 120;

	//numbers of champions who are good in some positions, i.e. top, mid......
	private int[] numOfPosition;
	
	private ChampionAttributes[] allChampions;
	private ChampionAttributes[] ourTeam;

	// strategy array encoding: the first position indicates how many strategies
	// this team is good at, followed by a list of strategies.
	// strategies are numbered from 0 to 9
	private int[] availableStrategy;
	
	// this is the actual strategy the user pick. -1 means not picked yet.
	private int ourStrategy;

//==============================================================================
	
	// Constructor
	public TeamBuilderData(){
		
		// Initialize everything
		numOfPosition = new int[5];
		ourTeam = new ChampionAttributes[5];
		ourStrategy = -1;
		availableStrategy = new int[11];
		allChampions = new ChampionAttributes[numOfChampions];
		
		for (int i = 0; i < 5; i++){
			ourTeam[i] = new ChampionAttributes();
		}
		
		// initially all 10 strategies are available.
		availableStrategy[0] = 10;
		for (int i = 1; i < 11; i++){
			availableStrategy[i] = i - 1;
		}
		
		// Attributes data for all champions. See ChampionAttributes.java for encoding information.
		int[] AatroxAttributes = {20, 10, 10, 10, 0, 20, 0, 20, 10, 10};
		int[] AhriAttributes = {10, 10, 20, 20, 0, 0, 0, 0, 10, 10};
		int[] AkaliAttributes = {20, 10, 0, 20, 0, 0, 0, 0, 0, 10};
		int[] AlistarAttributes = {0, 20, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] AmumuAttributes = {20, 0, 0, 20, 20, 0, 20, 0, 0, 10};
		int[] AniviaAttributes = {20, 20, 20, 20, 10, 0, 0, 20, 10, 10};
		int[] AnnieAttributes = {20, 10, 10, 20, 20, 0, 0, 0, 20, 10};
		int[] AsheAttributes = {20, 20, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] BlitzcrankAttributes = {20, 0, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] BrandAttributes = {10, 10, 20, 20, 20, 0, 0, 0, 10, 10};
		int[] BraumAttributes = {10, 20, 20, 20, 20, 0, 0, 0, 10, 10};
		int[] CaitlynAttributes = {0, 10, 20, 10, 0, 0, 0, 0, 20, 10};
		int[] CassiopeiaAttributes = {10, 20, 20, 20, 20, 0, 0, 0, 10, 10};
		int[] ChoGathAttributes = {20, 20, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] CorikiAttributes = {0, 20, 20, 10, 10, 0, 20, 0, 10, 10};
		int[] DariusAttributes = {20, 10, 0, 20, 10, 20, 0, 0, 10, 10};
		int[] DianaAttributes = {20, 0, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] DrMundoAttributes = {10, 20, 20, 10, 0, 0, 0, 0, 0, 10};
		int[] DravenAttributes = {10, 20, 20, 20, 10, 0, 0, 0, 20, 10};
		int[] EliseAttributes = {20, 20, 20, 20, 10, 0, 0, 0, 20, 10};
		int[] EvelynnAttributes = {20, 0, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] EzrealAttributes = {10, 20, 20, 10, 10, 0, 0, 0, 10, 10};
		int[] FiddlesticksAttributes = {20, 20, 10, 20, 20, 0, 0, 0, 0, 10};
		int[] FioraAttributes = {20, 20, 0, 10, 10, 0, 0, 0, 10, 10};
		int[] FizzAttributes = {10, 0, 0, 20, 10, 0, 0, 0, 0, 20};
		int[] GalioAttributes = {10, 20, 20, 20, 20, 0, 0, 0, 10, 10};
		int[] GangplankAttributes = {10, 0, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] GarenAttributes = {10, 10, 0, 10, 10, 20, 0, 0, 20, 10};
		int[] GnarAttributes = {20, 20, 20, 10, 20, 10, 20, 0, 10, 10};
		int[] GragasAttributes = {20, 20, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] GravesAttributes = {10, 10, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] HecarimAttributes = {20, 10, 0, 10, 10, 0, 0, 0, 10, 10};
		int[] HeimerdingerAttributes = {0, 20, 10, 10, 10, 0, 20, 0, 10, 10};
		int[] IreliaAttributes = {20, 10, 0, 20, 10, 0, 0, 0, 0, 20};
		int[] JannaAttributes = {10, 20, 20, 10, 0, 0, 0, 0, 10, 10};
		int[] JarvanIVAttributes = {20, 0, 10, 20, 20, 20, 0, 0, 20, 10};
		int[] JaxAttributes = {20, 20, 0, 20, 0, 20, 0, 0, 0, 20};
		int[] JayceAttributes = {10, 10, 20, 10, 0, 20, 0, 0, 20, 10};
		int[] JinxAttributes = {10, 0, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] KarmaAttributes = {10, 20, 20, 10, 10, 0, 0, 0, 10, 10};
		int[] KarthusAttributes = {10, 10, 20, 0, 20, 0, 0, 20, 0, 20};
		int[] KassadinAttributes = {10, 0, 0, 20, 0, 0, 0, 0, 0, 20};
		int[] KatarinaAttributes = {20, 0, 0, 10, 20, 0, 0, 0, 10, 10};
		int[] KayleAttributes = {10, 20, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] KennenAttributes = {20, 10, 20, 20, 20, 0, 20, 0, 10, 10};
		int[] KhaZixAttributes = {20, 10, 10, 20, 10, 20, 20, 0, 10, 10};
		int[] KogMawAttributes = {10, 0, 20, 10, 10, 0, 0, 0, 0, 20};
		int[] LeBlancAttributes = {10, 10, 10, 20, 0, 0, 0, 0, 20, 0};
		int[] LeeSinAttributes = {20, 20, 10, 20, 0, 0, 0, 0, 20, 10};
		int[] LeonaAttributes = {20, 10, 0, 20, 20, 0, 0, 0, 20, 10};
		int[] LissandraAttributes = {20, 10, 10, 20, 20, 0, 0, 0, 10, 10};
		int[] LucianAttributes = {20, 10, 20, 10, 0, 0, 0, 0, 10, 10};
		int[] LuluAttributes = {20, 10, 20, 20, 10, 0, 20, 0, 10, 10};
		int[] LuxAttributes = {10, 10, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] MalphiteAttributes = {20, 0, 10, 10, 20, 0, 0, 0, 10, 10};
		int[] MalzaharAttributes = {0, 0, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] MaokaiAttributes = {20, 0, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] MasterYiAttributes = {10, 20, 0, 20, 10, 0, 0, 0, 0, 20};
		int[] MissFortuneAttributes = {10, 10, 10, 10, 20, 0, 0, 0, 10, 10};
		int[] MordekaiserAttributes = {10, 0, 0, 10, 10, 0, 0, 0, 10, 10};
		int[] MorganaAttributes = {20, 10, 10, 20, 20, 0, 0, 0, 10, 10};
		int[] NamiAttributes = {10, 10, 10, 20, 20, 0, 0, 0, 10, 10};
		int[] NasusAttributes = {10, 20, 0, 10, 0, 0, 0, 0, 0, 20};
		int[] NautilusAttributes = {20, 0, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] NidaleeAttributes = {10, 0, 20, 0, 10, 0, 0, 0, 10, 10};
		int[] NocturneAttributes = {10, 10, 10, 20, 0, 0, 0, 0, 10, 10};
		int[] NunuAttributes = {10, 10, 10, 20, 20, 0, 0, 0, 10, 10};
		int[] OlafAttributes = {10, 10, 10, 10, 0, 20, 0, 0, 20, 10};
		int[] OriannaAttributes = {10, 10, 20, 10, 20, 0, 0, 0, 10, 10};
		int[] PantheonAttributes = {10, 0, 10, 20, 10, 20, 0, 0, 20, 10};
		int[] PoppyAttributes = {20, 10, 0, 10, 0, 0, 20, 0, 10, 20};
		int[] QuinnAttributes = {20, 10, 20, 10, 10, 0, 0, 0, 10, 10};
		int[] RammusAttributes = {20, 0, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] RenektonAttributes = {20, 10, 0, 20, 10, 0, 0, 0, 20, 10};
		int[] RengarAttributes = {10, 10, 10, 20, 0, 20, 0, 0, 10, 10};
		int[] RivenAttributes = {20, 0, 0, 20, 10, 20, 0, 0, 20, 10};
		int[] RumbleAttributes = {10, 10, 20, 10, 20, 0, 20, 0, 10, 10};
		int[] RyzeAttributes = {20, 10, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] SejuaniAttributes = {20, 10, 0, 20, 20, 0, 0, 0, 10, 10};
		int[] ShacoAttributes = {0, 20, 10, 20, 0, 0, 0, 0, 10, 10};
		int[] ShenAttributes = {20, 20, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] ShyvanaAttributes = {20, 10, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] SingedAttributes = {20, 20, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] SionAttributes = {10, 0, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] SivirAttributes = {10, 0, 20, 10, 0, 0, 0, 0, 10, 10};
		int[] SkarnerAttributes = {10, 0, 0, 20, 0, 0, 0, 0, 10, 10};
		int[] SonaAttributes = {20, 10, 20, 20, 20, 0, 0, 0, 10, 10};
		int[] SorakaAttributes = {0, 0, 10, 10, 10, 0, 0, 0, 10, 10};
		int[] SwainAttributes = {20, 10, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] SyndraAttributes = {0, 20, 20, 20, 10, 0, 0, 0, 10, 10};
		int[] TalonAttributes = {20, 0, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] TaricAttributes = {10, 0, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] TeemoAttributes = {0, 20, 10, 10, 0, 0, 20, 0, 20, 10};
		int[] ThreshAttributes = {20, 20, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] TristanaAttributes = {0, 20, 20, 10, 10, 20, 20, 0, 10, 20};
		int[] TrundleAttributes = {20, 20, 0, 20, 0, 0, 0, 0, 10, 10};
		int[] TryndamereAttributes = {20, 20, 0, 10, 0, 0, 0, 0, 0, 20};
		int[] TwistedFateAttributes = {10, 20, 20, 20, 0, 0, 0, 0, 10, 10};
		int[] TwitchAttributes = {10, 0, 20, 10, 20, 0, 0, 0, 10, 10};
		int[] UdyrAttributes = {20, 10, 0, 20, 0, 0, 0, 0, 10, 10};
		int[] UrgotAttributes = {10, 0, 20, 20, 0, 0, 0, 0, 10, 10};
		int[] VarusAttributes = {20, 0, 20, 10, 20, 0, 0, 0, 10, 10};
		int[] VayneAttributes = {10, 20, 10, 20, 0, 0, 0, 0, 0, 20};
		int[] VeigarAttributes = {10, 10, 10, 20, 10, 0, 20, 0, 0, 20};
		int[] VelKozAttributes = {10, 10, 20, 10, 20, 0, 0, 0, 10, 10};
		int[] ViAttributes = {20, 0, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] ViktorAttributes = {0, 10, 20, 20, 20, 0, 0, 0, 10, 10};
		int[] VladimirAttributes = {0, 10, 10, 0, 20, 0, 0, 0, 10, 10};
		int[] VolibearAttributes = {20, 0, 0, 20, 10, 0, 0, 0, 10, 10};
		int[] WarwickAttributes = {10, 20, 0, 20, 0, 0, 0, 0, 10, 10};
		int[] WukongAttributes = {20, 10, 0, 20, 20, 0, 0, 0, 10, 10};
		int[] XerathAttributes = {0, 10, 20, 10, 10, 0, 0, 0, 10, 10};
		int[] XinZhaoAttributes = {20, 20, 0, 20, 0, 0, 0, 0, 10, 10};
		int[] YasuoAttributes = {20, 20, 10, 10, 20, 20, 0, 0, 20, 10};
		int[] YorickAttributes = {10, 20, 20, 0, 10, 0, 0, 20, 20, 10};
		int[] ZacAttributes = {20, 10, 0, 20, 20, 20, 0, 20, 10, 10};
		int[] ZedAttributes = {10, 20, 10, 20, 10, 0, 0, 0, 10, 10};
		int[] ZiggsAttributes = {10, 10, 20, 10, 20, 0, 20, 0, 10, 10};
		int[] ZileanAttributes = {10, 10, 10, 20, 10, 0, 0, 20, 10, 10};
		int[] ZyraAttributes = {10, 20, 10, 20, 20, 0, 0, 0, 10, 10};
		
		// Position data for all champions. See ChampionAttributes.java for encoding information.
		int[] AatroxPositions = {1, 1, 0, 0, 0};
		int[] AhriPositions = {0, 0, 1, 0, 0};
		int[] AkaliPositions = {0, 0, 1, 0, 0};
		int[] AlistarPositions = {0, 0, 0, 0, 1};
		int[] AmumuPositions = {0, 1, 0, 0, 0};
		int[] AniviaPositions = {0, 0, 1, 0, 0};
		int[] AnniePositions = {0, 0, 1, 0, 1};
		int[] AshePositions = {0, 0, 0, 1, 0};
		int[] BlitzcrankPositions = {0, 0, 0, 0, 1};
		int[] BrandPositions = {0, 0, 1, 0, 0};
		int[] BraumPositions = {1, 0, 0, 0, 1};
		int[] CaitlynPositions = {0, 0, 0, 1, 0};
		int[] CassiopeiaPositions = {0, 0, 1, 0, 0};
		int[] ChoGathPositions = {1, 1, 0, 0, 0};
		int[] CorikiPositions = {0, 0, 0, 1, 0};
		int[] DariusPositions = {1, 0, 0, 0, 0};
		int[] DrMundoPositions = {1, 1, 0, 0, 0};
		int[] DianaPositions = {0, 1, 1, 0, 0};
		int[] DravenPositions = {0, 0, 0, 1, 0};
		int[] ElisePositions = {1, 1, 0, 0, 0};
		int[] EvelynnPositions = {0, 1, 1, 0, 0};
		int[] EzrealPositions = {0, 0, 1, 1, 0};
		int[] FiddlesticksPositions = {0, 1, 1, 0, 0};
		int[] FioraPositions = {1, 0, 0, 0, 0};
		int[] FizzPositions = {0, 0, 1, 0, 0};
		int[] GalioPositions = {0, 0, 1, 0, 1};
		int[] GangplankPositions = {1, 0, 0, 0, 0};
		int[] GarenPositions = {1, 0, 0, 0, 0};
		int[] GnarPositions = {1, 0, 0, 0, 0};
		int[] GragasPositions = {0, 1, 1, 0, 0};
		int[] GravesPositions = {0, 0, 0, 1, 0};
		int[] HecarimPositions = {0, 1, 0, 0, 0};
		int[] HeimerdingerPositions = {0, 0, 1, 0, 0};
		int[] IreliaPositions = {1, 0, 0, 0, 0};
		int[] JannaPositions = {0, 0, 0, 0, 1};
		int[] JarvanIVPositions = {1, 1, 0, 0, 0};
		int[] JaxPositions = {1, 1, 0, 0, 0};
		int[] JaycePositions = {1, 0, 1, 0, 0};
		int[] JinxPositions = {0, 0, 0, 1, 0};
		int[] KarmaPositions = {0, 0, 1, 0, 1};
		int[] KarthusPositions = {0, 0, 1, 0, 0};
		int[] KassadinPositions = {0, 0, 1, 0, 0};
		int[] KatarinaPositions = {0, 0, 1, 0, 0};
		int[] KaylePositions = {1, 0, 1, 0, 0};
		int[] KennenPositions = {1, 0, 1, 0, 0};
		int[] KhaZixPositions = {0, 1, 1, 0, 0};
		int[] KogMawPositions = {0, 0, 1, 1, 0};
		int[] LeBlancPositions = {0, 0, 1, 0, 1};
		int[] LeeSinPositions = {0, 1, 1, 0, 0};
		int[] LeonaPositions = {0, 0, 0, 0, 1};
		int[] LissandraPositions = {0, 0, 1, 0, 0};
		int[] LucianPositions = {0, 0, 0, 1, 0};
		int[] LuluPositions = {1, 0, 0, 0, 1};
		int[] LuxPositions = {0, 0, 1, 0, 1};
		int[] MalphitePositions = {1, 1, 0, 0, 0};
		int[] MalzaharPositions = {0, 0, 1, 0, 0};
		int[] MaokaiPositions = {0, 1, 0, 0, 1};
		int[] MasterYiPositions = {1, 1, 0, 0, 0};
		int[] MissFortunePositions = {0, 0, 0, 1, 0};
		int[] MordekaiserPositions = {0, 0, 1, 0, 0};
		int[] MorganaPositions = {0, 0, 1, 0, 1};
		int[] NamiPositions = {0, 0, 0, 0, 1};
		int[] NasusPositions = {1, 1, 0, 0, 0};
		int[] NautilusPositions = {0, 1, 0, 0, 1};
		int[] NidaleePositions = {0, 0, 1, 0, 1};
		int[] NocturnePositions = {0, 1, 0, 0, 0};
		int[] NunuPositions = {0, 1, 0, 0, 1};
		int[] OlafPositions = {1, 1, 0, 0, 0};
		int[] OriannaPositions = {0, 0, 1, 0, 0};
		int[] PantheonPositions = {1, 1, 0, 0, 0};
		int[] PoppyPositions = {1, 1, 0, 0, 0};
		int[] QuinnPositions = {0, 0, 0, 1, 0};
		int[] RammusPositions = {0, 1, 0, 0, 0};
		int[] RenektonPositions = {1, 0, 0, 0, 0};
		int[] RengarPositions = {1, 1, 0, 0, 0};
		int[] RivenPositions = {1, 0, 1, 0, 0};
		int[] RumblePositions = {1, 0, 0, 0, 0};
		int[] RyzePositions = {1, 0, 1, 0, 0};
		int[] SejuaniPositions = {0, 1, 0, 0, 0};
		int[] ShacoPositions = {0, 1, 0, 0, 0};
		int[] ShenPositions = {1, 1, 0, 0, 0};
		int[] ShyvanaPositions = {1, 1, 0, 0, 0};
		int[] SingedPositions = {1, 0, 0, 0, 0};
		int[] SionPositions = {1, 0, 0, 0, 0};
		int[] SivirPositions = {0, 0, 0, 1, 0};
		int[] SkarnerPositions = {0, 1, 0, 0, 0};
		int[] SonaPositions = {0, 0, 0, 0, 1};
		int[] SorakaPositions = {0, 0, 1, 0, 1};
		int[] SwainPositions = {0, 0, 1, 0, 0};
		int[] SyndraPositions = {0, 0, 1, 0, 0};
		int[] TalonPositions = {0, 0, 1, 0, 0};
		int[] TaricPositions = {0, 0, 0, 0, 1};
		int[] TeemoPositions = {1, 0, 1, 0, 0};
		int[] ThreshPositions = {0, 0, 0, 0, 1};
		int[] TristanaPositions = {0, 0, 1, 1, 0};
		int[] TrundlePositions = {1, 1, 0, 0, 0};
		int[] TryndamerePositions = {1, 1, 0, 0, 0};
		int[] TwistedFatePositions = {0, 0, 1, 0, 0};
		int[] TwitchPositions = {0, 0, 0, 1, 0};
		int[] UdyrPositions = {1, 1, 0, 0, 0};
		int[] UrgotPositions = {0, 0, 0, 1, 0};
		int[] VarusPositions = {0, 0, 0, 1, 0};
		int[] VaynePositions = {0, 0, 0, 1, 0};
		int[] VeigarPositions = {0, 0, 1, 0, 0};
		int[] VelkozPositions = {0, 0, 1, 0, 0};
		int[] ViPositions = {0, 1, 0, 0, 0};
		int[] ViktorPositions = {0, 0, 1, 0, 0};
		int[] VladimirPositions = {1, 0, 1, 0, 0};
		int[] VolibearPositions = {1, 1, 0, 0, 0};
		int[] WarwickPositions = {1, 1, 0, 0, 0};
		int[] WukongPositions = {1, 1, 0, 0, 0};
		int[] XerathPositions = {0, 0, 1, 0, 1};
		int[] XinZhaoPositions = {1, 1, 0, 0, 0};
		int[] YasuoPositions = {1, 0, 1, 0, 0};
		int[] YorickPositions = {1, 0, 0, 0, 0};
		int[] ZacPositions = {1, 1, 0, 0, 0};
		int[] ZedPositions = {0, 0, 1, 0, 0};
		int[] ZiggsPositions = {0, 0, 1, 0, 0};
		int[] ZileanPositions = {0, 0, 1, 0, 1};
		int[] ZyraPositions = {0, 0, 1, 0, 1};
		
		// Creating class instances for all champions and fit into the array allChampions[]
		allChampions[0] = (new ChampionAttributes("Aatrox", AatroxAttributes, AatroxPositions));
		allChampions[1] = (new ChampionAttributes("Ahri", AhriAttributes, AhriPositions));
		allChampions[2] = (new ChampionAttributes("Akali", AkaliAttributes, AkaliPositions));
		allChampions[3] = (new ChampionAttributes("Alistar", AlistarAttributes, AlistarPositions));
		allChampions[4] = (new ChampionAttributes("Amumu", AmumuAttributes, AmumuPositions));
		allChampions[5] = (new ChampionAttributes("Anivia", AniviaAttributes, AniviaPositions));
		allChampions[6] = (new ChampionAttributes("Annie", AnnieAttributes, AnniePositions));
		allChampions[7] = (new ChampionAttributes("Ashe", AsheAttributes, AshePositions));
		allChampions[8] = (new ChampionAttributes("Blitzcrank", BlitzcrankAttributes, BlitzcrankPositions));
		allChampions[9] = (new ChampionAttributes("Brand", BrandAttributes, BrandPositions));
		allChampions[10] = (new ChampionAttributes("Braum", BraumAttributes, BraumPositions));
		allChampions[11] = (new ChampionAttributes("Caitlyn", CaitlynAttributes, CaitlynPositions));
		allChampions[12] = (new ChampionAttributes("Cassiopeia", CassiopeiaAttributes, CassiopeiaPositions));
		allChampions[13] = (new ChampionAttributes("Cho Gath", ChoGathAttributes, ChoGathPositions));
		allChampions[14] = (new ChampionAttributes("Corki", CorikiAttributes, CorikiPositions));
		allChampions[15] = (new ChampionAttributes("Darius", DariusAttributes, DariusPositions));
		allChampions[16] = (new ChampionAttributes("Diana", DianaAttributes, DianaPositions));
		allChampions[17] = (new ChampionAttributes("Dr. Mundo", DrMundoAttributes, DrMundoPositions));
		allChampions[18] = (new ChampionAttributes("Draven", DravenAttributes, DravenPositions));
		allChampions[19] = (new ChampionAttributes("Elise", EliseAttributes, ElisePositions));
		allChampions[20] = (new ChampionAttributes("Evelynn", EvelynnAttributes, EvelynnPositions));
		allChampions[21] = (new ChampionAttributes("Ezreal", EzrealAttributes, EzrealPositions));
		allChampions[22] = (new ChampionAttributes("Fiddlesticks", FiddlesticksAttributes, FiddlesticksPositions));
		allChampions[23] = (new ChampionAttributes("Fiora", FioraAttributes, FioraPositions));
		allChampions[24] = (new ChampionAttributes("Fizz", FizzAttributes, FizzPositions));
		allChampions[25] = (new ChampionAttributes("Galio", GalioAttributes, GalioPositions));
		allChampions[26] = (new ChampionAttributes("Gangplank", GangplankAttributes, GangplankPositions));
		allChampions[27] = (new ChampionAttributes("Garen", GarenAttributes, GarenPositions));
		allChampions[28] = (new ChampionAttributes("Gnar", GnarAttributes, GnarPositions));
		allChampions[29] = (new ChampionAttributes("Gragas", GragasAttributes, GragasPositions));
		allChampions[30] = (new ChampionAttributes("Graves", GravesAttributes, GravesPositions));
		allChampions[31] = (new ChampionAttributes("Hecarim", HecarimAttributes, HecarimPositions));
		allChampions[32] = (new ChampionAttributes("Heimerdinger", HeimerdingerAttributes, HeimerdingerPositions));
		allChampions[33] = (new ChampionAttributes("Irelia", IreliaAttributes, IreliaPositions));
		allChampions[34] = (new ChampionAttributes("Janna", JannaAttributes, JannaPositions));
		allChampions[35] = (new ChampionAttributes("Jarvan IV", JarvanIVAttributes, JarvanIVPositions));
		allChampions[36] = (new ChampionAttributes("Jax", JaxAttributes, JaxPositions));
		allChampions[37] = (new ChampionAttributes("Jayce", JayceAttributes, JaycePositions));
		allChampions[38] = (new ChampionAttributes("Jinx", JinxAttributes, JinxPositions));
		allChampions[39] = (new ChampionAttributes("Karma", KarmaAttributes, KarmaPositions));
		allChampions[40] = (new ChampionAttributes("Karthus", KarthusAttributes, KarthusPositions));
		allChampions[41] = (new ChampionAttributes("Kassadin", KassadinAttributes, KassadinPositions));
		allChampions[42] = (new ChampionAttributes("Katarina", KatarinaAttributes, KatarinaPositions));
		allChampions[43] = (new ChampionAttributes("Kayle", KayleAttributes, KaylePositions));
		allChampions[44] = (new ChampionAttributes("Kennen", KennenAttributes, KennenPositions));
		allChampions[45] = (new ChampionAttributes("Kha Zix", KhaZixAttributes, KhaZixPositions));
		allChampions[46] = (new ChampionAttributes("Kog Maw", KogMawAttributes, KogMawPositions));
		allChampions[47] = (new ChampionAttributes("LeBlanc", LeBlancAttributes, LeBlancPositions));
		allChampions[48] = (new ChampionAttributes("Lee Sin", LeeSinAttributes, LeeSinPositions));
		allChampions[49] = (new ChampionAttributes("Leona", LeonaAttributes, LeonaPositions));
		allChampions[50] = (new ChampionAttributes("Lissandra", LissandraAttributes, LissandraPositions));
		allChampions[51] = (new ChampionAttributes("Lucian", LucianAttributes, LucianPositions));
		allChampions[52] = (new ChampionAttributes("Lulu", LuluAttributes, LuluPositions));
		allChampions[53] = (new ChampionAttributes("Lux", LuxAttributes, LuxPositions));
		allChampions[54] = (new ChampionAttributes("Malphite", MalphiteAttributes, MalphitePositions));
		allChampions[55] = (new ChampionAttributes("Malzahar", MalzaharAttributes, MalzaharPositions));
		allChampions[56] = (new ChampionAttributes("Maokai", MaokaiAttributes, MaokaiPositions));
		allChampions[57] = (new ChampionAttributes("Master Yi", MasterYiAttributes, MasterYiPositions));
		allChampions[58] = (new ChampionAttributes("Miss Fortune", MissFortuneAttributes, MissFortunePositions));
		allChampions[59] = (new ChampionAttributes("Mordekaiser", MordekaiserAttributes, MordekaiserPositions));
		allChampions[60] = (new ChampionAttributes("Morgana", MorganaAttributes, MorganaPositions));
		allChampions[61] = (new ChampionAttributes("Nami", NamiAttributes, NamiPositions));
		allChampions[62] = (new ChampionAttributes("Nasus", NasusAttributes, NasusPositions));
		allChampions[63] = (new ChampionAttributes("Nautilus", NautilusAttributes, NautilusPositions));
		allChampions[64] = (new ChampionAttributes("Nidalee", NidaleeAttributes, NidaleePositions));
		allChampions[65] = (new ChampionAttributes("Nocturne", NocturneAttributes, NocturnePositions));
		allChampions[66] = (new ChampionAttributes("Nunu", NunuAttributes, NunuPositions));
		allChampions[67] = (new ChampionAttributes("Olaf", OlafAttributes, OlafPositions));
		allChampions[68] = (new ChampionAttributes("Orianna", OriannaAttributes, OriannaPositions));
		allChampions[69] = (new ChampionAttributes("Pantheon", PantheonAttributes, PantheonPositions));
		allChampions[70] = (new ChampionAttributes("Poppy", PoppyAttributes, PoppyPositions));
		allChampions[71] = (new ChampionAttributes("Quinn", QuinnAttributes, QuinnPositions));
		allChampions[72] = (new ChampionAttributes("Rammus", RammusAttributes, RammusPositions));
		allChampions[73] = (new ChampionAttributes("Renekton", RenektonAttributes, RenektonPositions));
		allChampions[74] = (new ChampionAttributes("Rengar", RengarAttributes, RengarPositions));
		allChampions[75] = (new ChampionAttributes("Riven", RivenAttributes, RivenPositions));
		allChampions[76] = (new ChampionAttributes("Rumble", RumbleAttributes, RumblePositions));
		allChampions[77] = (new ChampionAttributes("Ryze", RyzeAttributes, RyzePositions));
		allChampions[78] = (new ChampionAttributes("Sejuani", SejuaniAttributes, SejuaniPositions));
		allChampions[79] = (new ChampionAttributes("Shaco", ShacoAttributes, ShacoPositions));
		allChampions[80] = (new ChampionAttributes("Shen", ShenAttributes, ShenPositions));
		allChampions[81] = (new ChampionAttributes("Shyvana", ShyvanaAttributes, ShyvanaPositions));
		allChampions[82] = (new ChampionAttributes("Singed", SingedAttributes, SingedPositions));
		allChampions[83] = (new ChampionAttributes("Sion", SionAttributes, SionPositions));
		allChampions[84] = (new ChampionAttributes("Sivir", SivirAttributes, SivirPositions));
		allChampions[85] = (new ChampionAttributes("Skarner", SkarnerAttributes, SkarnerPositions));
		allChampions[86] = (new ChampionAttributes("Sona", SonaAttributes, SonaPositions));
		allChampions[87] = (new ChampionAttributes("Soraka", SorakaAttributes, SorakaPositions));
		allChampions[88] = (new ChampionAttributes("Swain", SwainAttributes, SwainPositions));
		allChampions[89] = (new ChampionAttributes("Syndra", SyndraAttributes, SyndraPositions));
		allChampions[90] = (new ChampionAttributes("Talon", TalonAttributes, TalonPositions));
		allChampions[91] = (new ChampionAttributes("Taric", TaricAttributes, TaricPositions));
		allChampions[92] = (new ChampionAttributes("Teemo", TeemoAttributes, TeemoPositions));
		allChampions[93] = (new ChampionAttributes("Thresh", ThreshAttributes, ThreshPositions));
		allChampions[94] = (new ChampionAttributes("Tristana", TristanaAttributes, TristanaPositions));
		allChampions[95] = (new ChampionAttributes("Trundle", TrundleAttributes, TrundlePositions));
		allChampions[96] = (new ChampionAttributes("Tryndamere", TryndamereAttributes, TryndamerePositions));
		allChampions[97] = (new ChampionAttributes("Twisted Fate", TwistedFateAttributes, TwistedFatePositions));
		allChampions[98] = (new ChampionAttributes("Twitch", TwitchAttributes, TwitchPositions));
		allChampions[99] = (new ChampionAttributes("Udyr", UdyrAttributes, UdyrPositions));
		allChampions[100] = (new ChampionAttributes("Urgot", UrgotAttributes, UrgotPositions));
		allChampions[101] = (new ChampionAttributes("Varus", VarusAttributes, VarusPositions));
		allChampions[102] = (new ChampionAttributes("Vayne", VayneAttributes, VaynePositions));
		allChampions[103] = (new ChampionAttributes("Veigar", VeigarAttributes, VeigarPositions));
		allChampions[104] = (new ChampionAttributes("Vel Koz", VelKozAttributes, VelkozPositions));
		allChampions[105] = (new ChampionAttributes("Vi", ViAttributes, ViPositions));
		allChampions[106] = (new ChampionAttributes("Viktor", ViktorAttributes, ViktorPositions));
		allChampions[107] = (new ChampionAttributes("Vladimir", VladimirAttributes, VladimirPositions));
		allChampions[108] = (new ChampionAttributes("Volibear", VolibearAttributes, VolibearPositions));
		allChampions[109] = (new ChampionAttributes("Warwick", WarwickAttributes, WarwickPositions));
		allChampions[110] = (new ChampionAttributes("Wukong", WukongAttributes, WukongPositions));
		allChampions[111] = (new ChampionAttributes("Xerath", XerathAttributes, XerathPositions));
		allChampions[112] = (new ChampionAttributes("Xin Zhao", XinZhaoAttributes, XinZhaoPositions));
		allChampions[113] = (new ChampionAttributes("Yasuo", YasuoAttributes, YasuoPositions));
		allChampions[114] = (new ChampionAttributes("Yorick", YorickAttributes, YorickPositions));
		allChampions[115] = (new ChampionAttributes("Zac", ZacAttributes, ZacPositions));
		allChampions[116] = (new ChampionAttributes("Zed", ZedAttributes, ZedPositions));
		allChampions[117] = (new ChampionAttributes("Ziggs", ZiggsAttributes, ZiggsPositions));
		allChampions[118] = (new ChampionAttributes("Zilean", ZileanAttributes, ZileanPositions));
		allChampions[119] = (new ChampionAttributes("Zyra", ZyraAttributes, ZyraPositions));
		
		// For all 5 positions, find how many champions are good at it.
		findNumOfPositions();
	}
	
//==============================================================================

	// Set a team member in the team.
	// postion is one of five positions in the team
	// newChampion is the champion will be put on the position.
	public void setOurTeam(int position, ChampionAttributes newChampion){
		this.ourTeam[position] = newChampion;
	}
	
	// Set the strategy for team
	// strategy is the strategy user picked from available options.
	public void setOurStrategy(int strategy){
		this.ourStrategy = strategy;
	}
	
	// Return the current team strategy
	public int getOurStrategy(){
		return this.ourStrategy;
	}
	
	// Return an available strategy in the array availableStrategy[] with some index.
	public int getAvailableStrategyArray(int index){
		return this.availableStrategy[index];
	}
	
	// Return an string array contains all available strategies for team
	public String[] getAvailableStrategy(){
		String[] returnArray = new String[availableStrategy[0] + 1];
		returnArray[0] = "Check Team Style Here";
		for (int i = 1; i <= availableStrategy[0]; i++){
			switch (availableStrategy[i]){
				case 0:
					returnArray[i] = "Hard Engage";
					break;
				case 1:
					returnArray[i] = "Split Push";
					break;
				case 2:
					returnArray[i] = "Poke";
					break;
				case 3:
					returnArray[i] = "Catch Out";
					break;
				case 4:
					returnArray[i] = "Wombo Combo";
					break;
				case 5:
					returnArray[i] = "Dunk Squad";
					break;
				case 6:
					returnArray[i] = "Yordle Only";
					break;
				case 7:
					returnArray[i] = "Full Revive Bungaloo";
					break;
				case 8:
					returnArray[i] = "Early Game";
					break;
				case 9:
					returnArray[i] = "Late Game";
					break;
			}
		}
		return returnArray;
	}
	
//==============================================================================
	
	// For all 5 positions, find how many champions are good at it.
	private void findNumOfPositions(){
		// initialize the array
		for (int i = 0; i < 5; i++){
			numOfPosition[i] = 0;
		}
		for (int i = 0; i < numOfChampions; i++){
			for (int j = 0; j < 5; j++){
				if (allChampions[i].getPosition(j) == 1)
					numOfPosition[j] += 1;
			}
		}
	}
	
	// Count champions who are good at given strategy and position.
	// Return is the number of qualified champions
	private int championCounter(int strategy, int position){
		int count = 0;
		for (int i = 0; i < numOfChampions; i++){
			boolean strategyMatch = false;
			boolean positionMatch = false;
			for (int j = 0; j < 10; j++){
				if (allChampions[i].getAttribute(j) == 20){
					strategyMatch = true;
					break;
				}
			}
			for (int k = 0; k < 5; k++){
				if (allChampions[i].getPosition(k) == 1){
					positionMatch = true;
					break;
				}
			}
			if (strategyMatch && positionMatch){
				count += 1;
			}
		}
		return count;
	}
	
	// Return a list of champions that matches the team strategy and given position.
	// the return list won't include the champions that already in the team.
	public ChampionAttributes[] suggestChampionsByStrategy(int position){
		
		if (ourStrategy == -1){
			return suggestChampionsByPosition(position);
		}
		
		int returnSize = championCounter(ourStrategy, position);
		if (returnSize == 0){
			return null;
		}
		
		ChampionAttributes[] returnArray = new ChampionAttributes[returnSize];
		for (int i = 0; i < returnSize; i++){
			returnArray[i] = new ChampionAttributes();
		}

		// fill the return array
		for (int i = 0, j = 0; i < numOfChampions; i++){
			// Exclude all champions that already in the given team.
			if ((allChampions[i].getName() != ourTeam[0].getName()) 
								&& (allChampions[i].getName() != ourTeam[1].getName())
								&& (allChampions[i].getName() != ourTeam[2].getName())
								&& (allChampions[i].getName() != ourTeam[3].getName())
								&& (allChampions[i].getName() != ourTeam[4].getName())){

				// determine if the champion is good at given strategy
				if ((allChampions[i].getAttribute(ourStrategy) == 20) && 
						(allChampions[i].getPosition(position) == 1)){
					returnArray[j] = allChampions[i];
					j += 1;
				}
			}
		}
		return returnArray;
	}
	
	// Return a list of champions that matches the given position, ignore the strategy.
	// This method is called when the team strategy is -1 (haven't benn picked)
	// return list won't include the champions that already in the given team.
	private ChampionAttributes[] suggestChampionsByPosition(int position){

		ChampionAttributes[] returnArray = new ChampionAttributes[numOfPosition[position]];
		for (int i = 0; i < numOfPosition[position]; i++){
			returnArray[i] = new ChampionAttributes();
		}
		
		// fill the return array
		for (int i = 0, j = 0; i < numOfChampions; i++){
			
			// Exclude all champions that are already in the given team.
			if ((allChampions[i].getName() != ourTeam[0].getName()) 
								&& (allChampions[i].getName() != ourTeam[1].getName())
								&& (allChampions[i].getName() != ourTeam[2].getName())
								&& (allChampions[i].getName() != ourTeam[3].getName())
								&& (allChampions[i].getName() != ourTeam[4].getName())){

				// determine if the champion is good at given strategy
				if (allChampions[i].getPosition(position) == 1){
					returnArray[j] = allChampions[i];
					j += 1;
				}
			}
		}
		return returnArray;
	}
	
	// Suggest strategies for the team. The output will be written in availableStrategy[].
	public void suggestStrategyForTeam(){
		
		// detect # of current team members
		int numOfCurrentTeamMembers = 0;
		for (int i = 0; i < 5; i++){
			if (ourTeam[i].getName() != "NONAME")
				numOfCurrentTeamMembers += 1;
		}
		
		// if the team is empty, then all strategies are available.
		if (numOfCurrentTeamMembers == 0){
			int[] strategies = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			availableStrategy = strategies;
			return;
		}
		
		// cumulative score of a certain strategy for the given team
		int[] strategyScore = new int[10];
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 10; j++){
				strategyScore[j] += ourTeam[i].getAttribute(j);
			}
		}
		
		// returnArray encoding: the first position indicates how many strategies
		// this team is good at, followed by a list of strategies (strategy index 
		// 0 ~ 9)
		// Initialization, -1 means not strategy on that index.
		int[] returnArray = new int [11];
		returnArray[0] = 0;
		for (int i = 1; i <= 10; i++){
			returnArray[i] = -1;
		}
		
		// for every strategy score, find if it is the greatest in the array. if so, 
		// append the strategy to returnArray and increment returnArray[0] 
		for (int i = 0; i < 10; i++){
			boolean isGreatest = true;
			for (int j = 0; j < 10; j++){
				if (strategyScore[j] > strategyScore[i])
					isGreatest = false;
			}
			if (isGreatest){
				returnArray[0] += 1;
				returnArray[returnArray[0]] = i;
			}
		}		
		availableStrategy = returnArray;
	}
	
	// Retrun an array contains every champion who is not in the team.
	public ChampionAttributes[] getAllAvailableChampions(){
		ChampionAttributes[] returnArray = new ChampionAttributes[numOfChampions];
		for (int i = 0; i < numOfChampions; i++){
			returnArray[i] = new ChampionAttributes();
		}
		
		// fill the return array
		for (int i = 0, j = 0; i < numOfChampions; i++){
			// Exclude all champions that are already in the given team.
			if ((allChampions[i].getName() != ourTeam[0].getName()) 
								&& (allChampions[i].getName() != ourTeam[1].getName())
								&& (allChampions[i].getName() != ourTeam[2].getName())
								&& (allChampions[i].getName() != ourTeam[3].getName())
								&& (allChampions[i].getName() != ourTeam[4].getName())){
				returnArray[j] = allChampions[i];
				j += 1;
			}
		}
		return returnArray;
	}
}
