package com.fourfoureight.lolhelper.Build_Guides;


public class BuildDatabase {
	private BuildInfo database[][];
	private int numBuilds[];
	private int numChamps = 118;
	private int maxBuilds = 10;
	
	public BuildDatabase(String type){
		numBuilds = new int[numChamps];
		for(int i=0; i<numChamps; i++){
			numBuilds[i]=1;
		}
		database = new BuildInfo[numChamps][maxBuilds];
		for(int i=0; i<numChamps; i++){
			for(int j=1; j<maxBuilds; j++){
				database[i][j] = new BuildInfo();
			}
		}
		
		if(type.equals("Top")){
			buildtop();
		} else if(type.equals("Mid")){
			buildmid();
		} else if(type.equals("ADC")){
			buildadc();
		} else if(type.equals("Support")){
			buildsupp();
		} else {
			buildjung();
		}
		
		for(int i=0; i<numChamps; i++){
			database[i][0].setName("Recommended Build");
		}
	}
	
	public int getNumBuilds(int i){
		return numBuilds[i];
	}
	
	private void buildtop(){
		int i=0;
		
		/* ADDITIONAL BUILDS EXAMPLE
		database[i][1].setName("Custom Build");
		database[i][1].setStart("wardingtotem", "rejuvenationbead", "healthpotion", "stealthward");
		database[i][1].setRush("vampiricscepter", "mercurytreads", "ravenoushydra");
		database[i][1].setAsNeeded("warmogsarmor", "randuinsomen", "spiritvisage", "bladeoftheruinedking");
		numBuilds[i]++;
		 */
		
		//Aatrox
		database[i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "rejuvenationbead", "healthpotion", "stealthward");
		database[i][0].setRush("vampiricscepter", "mercurytreads", "ravenoushydra");
		database[i][0].setAsNeeded("warmogsarmor", "randuinsomen", "spiritvisage", "bladeoftheruinedking");
		
		//Ahri
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion", "stealthward");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "liandrystorment", "voidstaff");
		
		//Akali
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion", "stealthward");
		database[i][0].setRush("hextechgunblade", "ionianbootsoflucidity", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "lichbane", "voidstaff");

		//Alistar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("trinityforce", "mercurytreads", "bladeoftheruinedking");
		database[i][0].setAsNeeded("sunfirecape", "warmogsarmor", "guardianangel", "iceborngauntlet");

		//Amumu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("trinityforce", "mercurytreads", "liandrystorment");
		database[i][0].setAsNeeded("sunfirecape", "warmogsarmor", "guardianangel", "iceborngauntlet");

		//Anivia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rodofages", "voidstaff");
		
		//Annie
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "liandrystorment");
		
		//Ashe
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("statikkshiv", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Blitzcrank
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("trinityforce", "mercurytreads", "bladeoftheruinedking");
		database[i][0].setAsNeeded("sunfirecape", "warmogsarmor", "guardianangel", "iceborngauntlet");

		//Brand
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rylaiscrystalscepter", "sorcerersshoes", "liandrystorment");
		database[i][0].setAsNeeded("rabadonsdeathcap", "zhonyashourglass", "voidstaff");
		
		//Braum
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("sunfirecape", "spiritvisage", "mercurytreads");
		database[i][0].setAsNeeded("trinityforce", "randuinsomen", "thornmail", "warmogsarmor");
		
		//Caitlyn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
				
		//Cassiopeia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rylaiscrystalscepter", "sorcerersshoes", "liandrystorment");
		database[i][0].setAsNeeded("rabadonsdeathcap", "zhonyashourglass", "voidstaff");
		
		//Cho'Gath
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rodofages", "mercurytreads", "spiritvisage");
		database[i][0].setAsNeeded("rylaiscrystalscepter", "randuinsomen", "warmogsarmor");
		
		//Corki
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("trinityforce", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "thebloodthirster");
		
		//Darius
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "sunfirecape");
		database[i][0].setAsNeeded("frozenheart", "trinityforce", "guardianangel", "mawofmalmortius");
		
		//Diana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion", "stealthward");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("nashorstooth", "lichbane", "abyssalscepter", "voidstaff");
		
		//Dr. Mundo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("sunfirecape", "ninjatabi", "spiritvisage");
		database[i][0].setAsNeeded("thornmail", "warmogsarmor", "randuinsomen", "bansheesveil");
		
		//Draven
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Elise
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("sunfirecape", "sorcerersshoes", "liandrystorment");
		database[i][0].setAsNeeded("abyssalscepter", "iceborngauntlet", "warmogsarmor", "rylaiscrystalscepter");	
		
		//Evelynn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "trinityforce");
		database[i][0].setAsNeeded("lichbane", "iceborngauntlet", "deathfiregrasp", "liandrystorment");
		
		//Ezreal
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("trinityforce", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "thebloodthirster");
		
		//Fiddlesticks
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("rodofages", "lichbane", "abyssalscepter", "voidstaff");
		
		//Fiora
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "youmuusghostblade");
		database[i][0].setAsNeeded("lastwhisper", "bladeoftheruinedking", "thebloodthirster", "infinityedge");
		
		//Fizz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion", "stealthward");
		database[i][0].setRush("lichbane", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("nashorstooth", "zhonyashourglass", "abyssalscepter", "voidstaff");
		
		//Galio
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("athenesunholygrail", "abyssalscepter", "bansheesveil");
		database[i][0].setAsNeeded("mercurytreads", "spiritvisage", "rabadonsshield", "zhonyashourglass");
		
		//Gangplank
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "iceborngauntlet");
		database[i][0].setAsNeeded("sunfirecape", "statikkshiv", "spiritvisage", "trinityforce");
		
		//Garen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("sunfirecape", "theblackcleaver", "randuinsomen");
		database[i][0].setAsNeeded("mercurytreads", "lastwhisper", "guardianangel", "mawofmalmortius");
		
		//Gnar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("vampiricscepter", "bladeoftheruinedking", "ninjatabi");
		database[i][0].setAsNeeded("trinityforce", "randuinsomen", "mawofmalmortius", "lastwhisper");
		
		//Gragas
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("sunfirecape", "spiritvisage", "randuinsomen");
		database[i][0].setAsNeeded("mercurytreads", "abyssalscepter", "randuinsomen", "warmogsarmor");		
		
		//Graves
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Hecarim
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "iceborngauntlet");
		database[i][0].setAsNeeded("sunfirecape", "statikkshiv", "spiritvisage", "trinityforce");
		
		//Heimerdinger
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("rodofages", "lichbane", "abyssalscepter", "voidstaff");
		
		//Irelia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("trinityforce", "mercurytreads", "randuinsomen");
		database[i][0].setAsNeeded("frozenheart", "bansheesveil", "ravenoushydra", "guardianangel");
		
		//Janna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rodofages", "voidstaff");

		//J4
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "randuinsomen");
		database[i][0].setAsNeeded("frozenheart", "bansheesveil", "trinityforce", "guardianangel");
		
		//Jax
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("trinityforce", "mercurytreads", "bladeoftheruinedking");
		database[i][0].setAsNeeded("randuinsomen", "bansheesveil", "warmogsarmor", "guardianangel");
		
		//Jayce
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("manamune", "mercurytreads", "thebloodthirster");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "guardianangel", "lastwhisper");
		
		//Jinx
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Karma
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Karthus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("archangelsstaff", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Kassadin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("deathfiregrasp", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Katarina
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("voidstaff", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Kayle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("nashorstooth", "berserkergreaves", "lichbane");
		database[i][0].setAsNeeded("rabadonsdeathcap", "guinsoosrageblade", "liandrystorment","iceborngauntlet");
		
		//Kennen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("voidstaff", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Kha'Zix
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("thebloodthirster", "mercurytreads", "lastwhisper");
		database[i][0].setAsNeeded("mawofmalmortius", "randuinsomen", "theblackcleaver","ravenoushydra");
		
		//Kog'Maw
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("bladeoftheruinedking", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "phantomdancer","mercurialscimitar");
		
		//LeBlanc
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Lee Sin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "mawofmalmortius");
		database[i][0].setAsNeeded("trinityforce", "rubysightstone", "theblackcleaver","frozenmallet");
		
		//Leona
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "iceborngauntlet");
		database[i][0].setAsNeeded("frozenheart", "bansheesveil", "liandrystorment", "guardianangel");
		
		//Lissandra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rodofages", "voidstaff");

		//Lucian
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Lulu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("lichbane", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Lux
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("archangelsstaff", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Malphite
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "randuinsomen");
		database[i][0].setAsNeeded("frozenheart", "bansheesveil", "trinityforce", "guardianangel");
		
		//Malzahar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("archangelsstaff", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Maokai
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "iceborngauntlet");
		database[i][0].setAsNeeded("frozenheart", "bansheesveil", "liandrystorment", "guardianangel");
		
		//Master Yi
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("bladeoftheruinedking", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("phantomdancer", "ravenoushydra", "warmogsarmor", "mawofmalmortius");
		
		//Miss Fortune
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Mordekaiser
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("hextechgunblade", "sorcerersshoes", "zhonyashourglass");
		database[i][0].setAsNeeded("deathfiregrasp", "rabadonsdeathcap", "voidstaff", "guardianangel");

		//Morgana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rodofages", "voidstaff");
		
		//Nami
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rodofages", "voidstaff");

		//Nasus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("iceborngauntlet", "mercurytreads", "spiritvisage");
		database[i][0].setAsNeeded("randuinsomen", "trinityforce", "guardianangel", "bansheesveil");
		
		//Nautilus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("iceborngauntlet", "mercurytreads", "trinityforce");
		database[i][0].setAsNeeded("randuinsomen", "warmogsarmor", "guardianangel", "bansheesveil");
		
		//Nidalee
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("trinityforce", "mercurytreads", "spiritvisage");
		database[i][0].setAsNeeded("randuinsomen", "iceborngauntlet", "guardianangel", "bansheesveil");
		
		//Nocturne
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "mawofmalmortius");
		database[i][0].setAsNeeded("trinityforce", "randuinsomen", "theblackcleaver","frozenmallet");
		
		//Nunu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("rabadonsdeathcap", "sorcerersshoes", "zhonyashourglass");
		database[i][0].setAsNeeded("deathfiregrasp", "lichbane", "voidstaff", "guardianangel");
		
		//Olaf
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "mawofmalmortius");
		database[i][0].setAsNeeded("trinityforce", "randuinsomen", "theblackcleaver","frozenmallet");
		
		//Orianna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rodofages", "voidstaff");
		
		//Pantheon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "mawofmalmortius");
		database[i][0].setAsNeeded("trinityforce", "randuinsomen", "theblackcleaver","frozenmallet");
		
		//Poppy
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("iceborngauntlet", "mercurytreads", "trinityforce");
		database[i][0].setAsNeeded("randuinsomen", "warmogsarmor", "guardianangel", "bansheesveil");
		
		//Quinn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Rammus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "talismanofascension");
		database[i][0].setAsNeeded("spiritvisage", "thornmail", "liandrystorment", "warmogsarmor");
		
		//Renekton
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "mercurytreads", "ravenoushydra");
		database[i][0].setAsNeeded("lastwhisper", "mawofmalmortius", "guardianangel", "thebloodthirster");
		
		//Rengar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("trinityforce", "sorcerersshoes", "thebloodthirster");
		database[i][0].setAsNeeded("lastwhisper", "theblackcleaver", "bladeoftheruinedking", "guardianangel");
		
		//Riven
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("ravenoushydra", "ionianbootsoflucidity", "lastwhisper");
		database[i][0].setAsNeeded("theblackcleaver", "youmuusghostblade", "mawofmalmortius", "randuinsomen");
		
		//Rumble
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("rylaiscrystalscepter", "sorcerersshoes", "liandrystorment");
		database[i][0].setAsNeeded("abyssalscepter", "zhonyashourglass", "voidstaff", "guardianangel");
		
		//Ryze
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("rodofages", "sorcerersshoes", "seraphsembrace");
		database[i][0].setAsNeeded("spiritvisage", "frozenheart", "voidstaff", "willoftheancients");
		
		//Sejuani
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "talismanofascension");
		database[i][0].setAsNeeded("spiritvisage", "thornmail", "liandrystorment", "warmogsarmor");
		
		//Shaco
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("bladeoftheruinedking", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("phantomdancer", "ravenoushydra", "warmogsarmor", "mawofmalmortius");
		
		//Shen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("randuinsomen", "mercurytreads", "sunfirecape");
		database[i][0].setAsNeeded("witsend", "spiritvisage", "frozenmallet", "guardianangel");
		
		//Shyvana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("randuinsomen", "mercurytreads", "sunfirecape");
		database[i][0].setAsNeeded("spiritvisage", "bladeoftheruinedking", "bansheesveil", "guardianangel");
		
		//Singed
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("seraphsembrace", "mercurytreads", "rylaiscrystalscepter");
		database[i][0].setAsNeeded("liandrystorment", "thornmail", "bansheesveil", "guardianangel");
		
		//Sion
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("trinityforce", "berserkergreaves", "phantomdancer");
		database[i][0].setAsNeeded("infinityedge", "statikkshiv", "bladeoftheruinedking", "atmasimplaler");
		
		//Sivir
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Skarner
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("trinityforce", "mercurytreads", "bladeoftheruinedking");
		database[i][0].setAsNeeded("sunfirecape", "warmogsarmor", "guardianangel", "iceborngauntlet");
		
		//Sona
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rodofages", "voidstaff");
		
		//Soraka
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rodofages", "voidstaff");
		
		//Swain
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("seraphsembrace", "sorcerersshoes", "rodofages");
		database[i][0].setAsNeeded("zhonyashourglass", "liandrystorment", "rabadonsdeathcap", "voidstaff");
		
		//Syndra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "liandrystorment","voidstaff");
		
		//Talon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "trinityforce");
		database[i][0].setAsNeeded("thebloodthirster", "theblackcleaver", "lastwhisper", "guardianangel");
		
		//Taric
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "spiritvisage");
		database[i][0].setAsNeeded("guardianangel", "thornmail", "liandrystorment", "warmogsarmor");
		
		//Teemo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("frozenmallet", "mercurytreads", "bladeoftheruinedking");
		database[i][0].setAsNeeded("runaanshurricane", "trinityforce", "liandrystorment", "witsend");

		//Thresh
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "spiritvisage");
		database[i][0].setAsNeeded("guardianangel", "thornmail", "liandrystorment", "warmogsarmor");
		
		//Tristana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "lichbane","voidstaff");
		
		//Trundle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "randuinsomen");
		database[i][0].setAsNeeded("trinityforce", "bladeoftheruinedking", "thornmail","bansheesveil");
		
		//Tryndamere
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("bladeoftheruinedking", "berserkergreaves", "statikkshiv");
		database[i][0].setAsNeeded("ravenoushydra", "mawofmalmortius", "guardianangel","mercurialscimitar");

		//Twisted Fate
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("lichbane", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "deathfiregrasp","voidstaff");
		
		//Twitch
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Udyr
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("trinityforce", "ninjatabi", "bladeoftheruinedking");
		database[i][0].setAsNeeded("frozenheart", "bansheesveil", "randuinsomen", "zephyr");
		
		//Urgot
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("manamune", "mercurytreads", "thebloodthirster");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "guardianangel", "lastwhisper");
		
		//Varus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
		
		//Vayne
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("thebloodthirster", "berserkergreaves", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "phantomdancer", "guardianangel", "zephyr");
	
		//Veigar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "archangelsstaff","voidstaff");
		
		//Vel'Koz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "liandrystorment","voidstaff");
	
		//Vi
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("trinityforce", "ninjatabi", "bladeoftheruinedking");
		database[i][0].setAsNeeded("randuinsomen", "spiritvisage", "theblackcleaver", "mawofmalmortius");

		//Viktor
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "liandrystorment","voidstaff");

		//Vladimir
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("rylaiscrystalscepter", "mercurytreads", "liandrystorment");
		database[i][0].setAsNeeded("abyssalscepter", "zhonyashourglass", "voidstaff", "spiritvisage");
		
		//Volibear
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "spiritvisage");
		database[i][0].setAsNeeded("trinityforce", "bansheesveil", "witsend", "guardianangel");
		
		//Warwick
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "healthpotion", "stealthward");
		database[i][0].setRush("frozenmallet", "sorcerersshoes", "spiritvisage");
		database[i][0].setAsNeeded("bladeoftheruinedking", "witsend", "warmogsarmor", "frozenmallet");
		
		//Wukong
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("ravenoushydra", "berserkergreaves", "lastwhisper");
		database[i][0].setAsNeeded("trinityforce", "frozenmallet", "sunfirecape", "guardianangel");
		
		//Xerath
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rabadonsdeathcap", "sorcerersshoes", "athenesunholygrail");
		database[i][0].setAsNeeded("abyssalscepter", "zhonyashourglass", "voidstaff", "guardianangel");

		//Xin Zhao
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("sunfirecape", "mercurytreads", "bladeoftheruinedking");
		database[i][0].setAsNeeded("iceborngauntlet", "bansheesveil", "randuinsomen", "guardianangel");
		
		//Yasuo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("statikkshiv", "mercurytreads", "bladeoftheruinedking");
		database[i][0].setAsNeeded("lastwhisper", "infinityedge", "randuinsomen", "guardianangel");

		//Yorick
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("manamune", "mercurytreads", "iceborngauntlet");
		database[i][0].setAsNeeded("sunfirecape", "spiritvisage", "warmogsarmor", "guardianangel");
		
		//Zac
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("sunfirecape", "ninjatabi", "spiritvisage");
		database[i][0].setAsNeeded("abyssalscepter", "randuinsomen", "bansheesveil", "liandrystorment");

		//Zed
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("bladeoftheruinedking", "ninjatabi", "lastwhisper");
		database[i][0].setAsNeeded("sunfirecape", "theblackcleaver", "randuinsomen", "mawofmalmortius");

		//Ziggs
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rabadonsdeathcap", "sorcerersshoes", "athenesunholygrail");
		database[i][0].setAsNeeded("rylaiscrystalscepter", "zhonyashourglass", "voidstaff", "lichbane");
		
		//Zilean
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("rabadonsdeathcap", "sorcerersshoes", "athenesunholygrail");
		database[i][0].setAsNeeded("abyssalscepter", "zhonyashourglass", "voidstaff", "liandrystorment");
		
		//Zyra
		database[++i][0] = new BuildInfo();		
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rabadonsdeathcap", "sorcerersshoes", "athenesunholygrail");
		database[i][0].setAsNeeded("rylaiscrystalscepter", "zhonyashourglass", "voidstaff", "liandrystorment");
	}
	
	private void buildmid(){
		int i=0;
		
		//Aatrox
		database[i][0] = new BuildInfo();
		numBuilds[i]--;

		//Ahri
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "voidstaff", "rabadonsdeathcap");
		database[i][0].setAsNeeded("athenesunholygrail", "zhonyashourglass", "rylaiscrystalscepter", "guardianangel");

		//Akali
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("hextechgunblade", "sorcerersshoes", "rabadonsdeathcap", "voidstaff");
		database[i][0].setAsNeeded("zhonyashourglass", "guardianangel", "lichbane", "deathfiregrasp");

		//Alistar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rodofages", "sorcerersshoes", "twinshadows", "lichbane");
		database[i][0].setAsNeeded("spiritvisage", "abyssalscepter", "sunfirecape", "guardianangel");

		//Amumu
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Anivia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("athenesunholygrail", "sorcerersshoes", "rabadonsdeathcap", "voidstaff");
		database[i][0].setAsNeeded("zhonyashourglass", "guardianangel", "liandrystorment", "rodofages");

		//Annie
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "rabadonsdeathcap", "sorcerersshoes", "voidstaff");
		database[i][0].setAsNeeded("zhonyashourglass", "guardianangel", "athenesunholygrail", "liandrystorment");
		
		//Ashe
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Blitzcrank
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Brand
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rabadonsdeathcap", "sorcerersshoes", "athenesunholygrail", "voidstaff");
		database[i][0].setAsNeeded("liandrystorment", "zhonyashourglass", "guardianangel");

		//Braum
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "rubycrystal", "healthpotion");
		database[i][0].setRush("bladeoftheruinedking", "mercurytreads", "trinityforce");
		database[i][0].setAsNeeded("warmogsarmor", "sunfirecape", "spiritvisage", "frozenmallet");
		
		//Caitlyn
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Cassiopeia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff");
		database[i][0].setAsNeeded("athenesunholygrail", "liandrystorment", "guardianangel", "zhonyashourglass");

		//Cho'Gath
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "zhonyashourglass");
		database[i][0].setAsNeeded("rodofages", "athenesunholygrail", "guardianangel", "bansheesveil");

		//Corki
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Darius
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Diana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "deathfiregrasp");
		database[i][0].setAsNeeded("iceborngauntlet", "lichbane", "guardianangel", "bansheesveil");

		//Dr. Mundo
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Draven
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Elise
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "lichbane");
		database[i][0].setAsNeeded("spiritvisage", "randuinsomen", "bansheesveil", "guardianangel");
		
		//Evelynn
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Ezreal
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "lichbane");
		database[i][0].setAsNeeded("athenesunholygrail", "rylaiscrystalscepter", "deathfiregrasp", "guardianangel");

		//Fiddlesticks
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("zhonyashourglass", "rabadonsdeathcap", "voidstaff", "sorcerersshoes");
		database[i][0].setAsNeeded("liandrystorment", "rylaiscrystalscepter", "guardianangel", "athenesunholygrail");

		//Fiora
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Fizz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "lichbane", "voidstaff");
		database[i][0].setAsNeeded("deathfiregrasp", "guardianangel", "bansheesveil", "athenesunholygrail");

		//Galio
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("guardianangel", "bansheesveil", "spiritvisage", "liandrystorment");

		//Gangplank
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Garen
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Gnar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("vampiricscepter", "ionianbootsoflucidity", "thebloodthirster", "trinityforce");
		database[i][0].setAsNeeded("bladeoftheruinedking", "infinityedge", "lastwhisper", "youmuusghostblade");
		
		//Gragas
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("guardianangel", "bansheesveil", "lichbane", "");

		//Graves
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Hecarim
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Heimerdinger
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("liandrystorment", "bannerofcommand", "guardianangel", "zhonyashourglass");

		//Irelia
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Janna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("guardianangel", "zhonyashourglass", "liandrystorment", "bansheesveil");

		//J4
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Jax
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Jayce
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("muramana", "ionianbootsoflucidity", "thebloodthirster", "lastwhisper");
		database[i][0].setAsNeeded("theblackcleaver", "mawofmalmortius", "guardianangel", "bansheesveil");

		//Jinx
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Karma
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("liandrystorment", "bansheesveil", "guardianangel", "rylaiscrystalscepter");

		//Karthus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("zhonyashourglass", "rodofages", "seraphsembrace", "bansheesveil");
		
		//Kassadin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "rodofages");
		database[i][0].setAsNeeded("lichbane", "iceborngauntlet", "seraphsembrace", "guardianangel");

		//Katarina
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("deathfiregrasp", "sorcerersshoes", "rabadonsdeathcap", "voidstaff");
		database[i][0].setAsNeeded("liandrystorment", "zhonyashourglass", "abyssalscepter", "guardianangel");

		//Kayle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "nashorstooth");
		database[i][0].setAsNeeded("lichbane", "guardianangel", "bansheesveil", "athenesunholygrail");

		//Kennen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "hextechgunblade", "guardianangel");

		//Kha'Zix
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("theblackcleaver", "ravenoushydra", "ionianbootsoflucidity", "lastwhisper");
		database[i][0].setAsNeeded("thebloodthirster", "guardianangel", "bansheesveil", "mawofmalmortius");

		//Kog'Maw
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("liandrystorment", "rylaiscrystalscepter", "bansheesveil", "zhonyashourglass");

		//LeBlanc
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "deathfiregrasp", "voidstaff", "rabadonsdeathcap");
		database[i][0].setAsNeeded("athenesunholygrail", "guardianangel", "liandrystorment", "bansheesveil");

		//Lee Sin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("ravenoushydra", "mercurytreads", "lastwhisper", "randuinsomen");
		database[i][0].setAsNeeded("spiritvisage", "guardianangel", "bansheesveil", "thebloodthirster");

		//Leona
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Lissandra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "deathfiregrasp");
		database[i][0].setAsNeeded("bansheesveil", "guardianangel", "athenesunholygrail", "liandrystorment");

		//Lucian
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "trinityforce", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "statikkshiv", "guardianangel", "bansheesveil");

		//Lulu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("liandrystorment", "guardianangel", "bansheesveil");

		//Lux
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("mejaissoulstealer", "lichbane", "zhonyashourglass", "bansheesveil");

		//Malphite
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("guardianangel", "randuinsomen", "spiritvisage", "bansheesveil");
		
		//Malzahar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "athenesunholygrail", "deathfiregrasp");
		database[i][0].setAsNeeded("voidstaff", "liandrystorment", "zhonyashourglass");

		//Maokai
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("liandrystorment", "guardianangel", "bansheesveil", "zhonyashourglass");

		//Master Yi
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Miss Fortune
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Mordekaiser
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "willoftheancients");
		database[i][0].setAsNeeded("deathfiregrasp", "liandrystorment", "guardianangel", "bansheesveil");

		//Morgana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "zhonyashourglass", "athenesunholygrail");
		database[i][0].setAsNeeded("voidstaff", "guardianangel", "liandrystorment", "bansheesveil");

		//Nami
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("liandrystorment", "bansheesveil", "lichbane");

		//Nasus
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Nautilus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "athenesunholygrail");
		database[i][0].setAsNeeded("randuinsomen", "bansheesveil", "voidstaff", "guardianangel");

		//Nidalee
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "athenesunholygrail", "rabadonsdeathcap", "voidstaff");
		database[i][0].setAsNeeded("iceborngauntlet", "lichbane", "zhonyashourglass");

		//Nocturne
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Nunu
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Olaf
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Orianna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("lichbane", "zhonyashourglass", "guardianangel");

		//Pantheon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("ionianbootsoflucidity", "theblackcleaver", "ravenoushydra", "lastwhisper");
		database[i][0].setAsNeeded("randuinsomen", "spiritvisage", "lastwhisper", "thebloodthirster");

		//Poppy
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Quinn
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Rammus
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Renekton
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Rengar
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Riven
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("mercurytreads", "theblackcleaver", "ravenoushydra");
		database[i][0].setAsNeeded("thebloodthirster", "lastwhisper", "randuinsomen", "spiritvisage");

		//Rumble
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Ryze
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rodofages", "seraphsembrace", "frozenshield");
		database[i][0].setAsNeeded("bansheesveil", "spiritvisage", "guardianangel", "voidstaff");

		//Sejuani
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Shaco
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Shen
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Shyvana
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Singed
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Sion
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("deathfiregrasp", "lichbane", "guardianangel", "bansheesveil");

		//Sivir
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Skarner
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Sona
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Soraka
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("liandrystorment", "rylaiscrystalscepter", "guardianangel", "bansheesveil");

		//Swain
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("guardianangel", "bansheesveil", "willoftheancients", "liandrystorment");

		//Syndra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "deathfiregrasp", "athenesunholygrail");
		database[i][0].setAsNeeded("voidstaff", "bansheesveil", "guardianangel", "zhonyashourglass");

		//Talon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("mercurytreads", "theblackcleaver", "lastwhisper", "ravenoushydra");
		database[i][0].setAsNeeded("trinityforce", "bansheesveil", "thebloodthirster", "infinityedge");

		//Taric
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Teemo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "nashorstooth", "lichbane");
		database[i][0].setAsNeeded("bansheesveil", "voidstaff", "guardianangel", "");

		//Thresh
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Tristana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "deathfiregrasp");
		database[i][0].setAsNeeded("lichbane", "zhonyashourglass", "guardianangel", "bansheesveil");

		//Trundle
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Tryndamere
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Twisted Fate
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "lichbane", "voidstaff");
		database[i][0].setAsNeeded("zhonyashourglass", "bansheesveil", "guardianangel");

		//Twitch
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Udyr
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Urgot
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Varus
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Vayne
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Veigar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "athenesunholygrail", "deathfiregrasp");
		database[i][0].setAsNeeded("voidstaff", "zhonyashourglass", "bansheesveil", "guardianangel");

		//Vel'Koz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("zhonyashourglass", "deathfiregrasp", "liandrystorment", "rylaiscrystalscepter");

		//Vi
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Viktor
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "hexcoredeath", "voidstaff");
		database[i][0].setAsNeeded("zhonyashourglass", "athenesunholygrail", "bansheesveil", "liandrystorment");

		//Vladimir
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "willoftheancients");
		database[i][0].setAsNeeded("zhonyashourglass", "guardianangel", "bansheesveil");

		//Volibear
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Warwick
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Wukong
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("theblackcleaver", "mercurytreads", "randuinsomen", "spiritvisage");
		database[i][0].setAsNeeded("lastwhisper", "ravenoushydra", "bansheesveil", "sunfirecape");

		//Xerath
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("zhonyashourglass", "bansheesveil", "liandrystorment", "rylaiscrystalscepter");

		//Xin Zhao
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Yasuo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("statikkshiv", "berserkergreaves", "infinityedge", "lastwhisper");
		database[i][0].setAsNeeded("guardianangel", "ravenoushydra", "mawofmalmortius", "bansheesveil");

		//Yorick
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Zac
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Zed
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("bladeoftheruinedking", "mercurytreads", "lastwhisper", "theblackcleaver");
		database[i][0].setAsNeeded("youmuusghostblade", "ravenoushydra", "guardianangel", "bansheesveil");

		//Ziggs
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("lichbane", "zhonyashourglass", "guardianangel", "bansheesveil");

		//Zilean
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("zhonyashourglass", "morellonomicon", "rylaiscrystalscepter", "bansheesveil");

		//Zyra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");
		database[i][0].setAsNeeded("rylaiscrystalscepter", "liandrystorment", "guardianangel", "bansheesveil");
	}
	
	private void buildadc(){
		int i=0;
			
		//Aatrox
		database[i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "rubycrystal", "bootsofspeed");
		database[i][0].setRush("berserkergreaves", "ravenoushydra", "thebloodthirster", "phantomdancer");
		database[i][0].setAsNeeded("lastwhisper", "statikkshiv", "theblackcleaver");
	
		//Ahri
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
		
		//Akali
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "hextechgunblade", "bladeoftheruinedking", "trinityforce");
		database[i][0].setAsNeeded("infinityedge", "youmuusghostblade", "guardianangel", "warmogsarmor");
		
		//Alistar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "dagger", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "theblackcleaver", "statikkshiv");
	
		//Amumu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "dagger", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "theblackcleaver", "statikkshiv");
		
		//Anivia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
		
		//Annie
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
		
		//Ashe
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "infinityedge", "thebloodthirster", "phantomdancer");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "statikkshiv");
	
		//Blitzcrank
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "frozenmallet");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "marumana");
	
		//Brand
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
		
		//Braum
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Caitlyn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("bladeoftheruinedking", "lastwhisper", "bansheesveil", "guardianangel");
		
		//Cassiopeia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Cho'Gath
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "frozenmallet");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "marumana");
	
		//Corki
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "thebloodthirster", "trinityforce", "infinityedge");
		database[i][0].setAsNeeded("muramana", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Darius
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "theblackcleaver", "mawofmalmortius");
		database[i][0].setAsNeeded("trinityforce", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Diana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "theblackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "warmogsarmor");
	
		//Dr. Mundo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "warmogsarmor", "theblackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Draven
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "theblackcleaver");
	
		//Elise
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("mercurytreads", "thebloodthirster", "trinityforce", "blackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "randuinsomen", "frozenmallet");
	
		//Evelynn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("bootsofmobility", "thebloodthirster", "trinityforce", "blackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "randuinsomen", "witsend");
	
		//Ezreal
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "trinityforce", "infinityedgse");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bladeoftheruinedking", "muramana");
	
		//Fiddlesticks
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Fiora
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "theblackcleavr");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bladeoftheruinedking", "ravenoushydra");
	
		//Fizz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "theblackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Galio
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "muramana");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Gangplank
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "thebloodthirster", "bansheesveil", "frozenmallet");
	
		//Garen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "randuinsomen", "frozenmallet");
	
		//Gnar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "bladeoftheruinedking", "lastwhisper");
		database[i][0].setAsNeeded("infinityedge", "phantomdancer", "guardianangel", "trinityforce");
	
		//Gragas
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "muramana");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Graves
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedgse");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bladeoftheruinedking", "bansheesveil");
	
		//Hecarim
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Heimerdinger
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Irelia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Janna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//J4
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "ravenoushydra", "sunfirecape");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Jax
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("berserkergreaves", "witsend", "trinityforce", "bladeoftheruinedking");
		database[i][0].setAsNeeded("thebloodthirster", "randuinsomen", "bansheesveil", "hextechgunblade");
		
		//Jayce
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "theblackcleaver", "infinityedgse");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bladeoftheruinedking", "bansheesveil");
	
		//Jinx
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedgse");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bladeoftheruinedking", "bansheesveil");
	
		//Karma
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Karthus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Kassadin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("ionianbootsoflucidity", "thebloodthirster", "ravenoushydra", "muramana");
		database[i][0].setAsNeeded("guardianangel", "zephyr", "statikkshiv", "iceborngauntlet");
	
		//Katarina
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "lastwhisper", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "thornmail", "bansheesveil", "randuinsomen");
	
		//Kayle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "ravenoushydra", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "zephyr", "statikkshiv", "phantomdancer");
	
		//Kennen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Kha'Zix
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("ionianbootsoflucidity", "theblackcleaver", "ravenoushydra", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "mawofmalmortius", "frozenheart", "thebloodthirster");
	
		//Kog'Maw
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "infinityedge", "thebloodthirster", "lastwhisper");
		database[i][0].setAsNeeded("guardianangel", "statikkshiv", "phantomdancer", "frozenmallet");
	
		//LeBlanc
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Lee Sin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("ionianbootsoflucidity", "theblackcleaver", "ravenoushydra", "randuinsomen");
		database[i][0].setAsNeeded("guardianangel", "mawofmalmortius", "frozenheart", "thebloodthirster");
	
		//Leona
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "atmasimpaler", "bansheesveil", "warmogsarmor");
	
		//Lissandra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Lucian
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "trinityforce", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "bladeoftheruinedking");
	
		//Lulu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "manamune");
	
		//Lux
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Malphite
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "atmasimpaler", "bansheesveil", "warmogsarmor");
		
		//Malzahar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Maokai
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "atmasimpaler", "bansheesveil", "warmogsarmor");
	
		//Master Yi
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "infinityedge", "phantomdancer");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "sunfirecape", "ravenoushydra");
	
		//Miss Fortune
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "bladeoftheruinedking");
	
		//Mordekaiser
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "mawofmalmortius");
		database[i][0].setAsNeeded("guardianangel", "randuinsomen", "bansheesveil", "warmogsarmor");
	
		//Morgana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil");
	
		//Nami
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Nasus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "trinityforce", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "theblackcleaver");
	
		//Nautilus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "atmasimpaler", "bansheesveil", "warmogsarmor");
	
		//Nidalee
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Nocturne
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "ravenoushydra", "phantomdancer");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Nunu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "youmuusghostblade", "lastwhisper");
		database[i][0].setAsNeeded("infinityedge", "phantomdancer", "bansheesveil", "warmogsarmor");
	
		//Olaf
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "atmasimpaler", "bansheesveil", "warmogsarmor");
	
		//Orianna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Pantheon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "infinityedge", "phantomdancer");
		database[i][0].setAsNeeded("theblackcleaver", "guardianangel", "bansheesveil", "warmogsarmor");
	
		//Poppy
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "trinityforce", "phantomdancer");
		database[i][0].setAsNeeded("zephyr", "mercurialscimitar", "bansheesveil", "hextechgunblade");
	
		//Quinn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "bladeoftheruinedking", "infinityedge", "phantomdancer");
		database[i][0].setAsNeeded("frozenmallet", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Rammus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "trinityforce");
		database[i][0].setAsNeeded("guardianangel", "atmasimpaler", "bansheesveil", "warmogsarmor");
	
		//Renekton
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "ravenoushydra", "sunfirecape");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Rengar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("mecurytreads", "thebloodthirster", "mawofmalmortius", "atmasimpaler");
		database[i][0].setAsNeeded("frozenmallet", "lastwhisper", "bansheesveil", "warmogsarmor");
	
		//Riven
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("ninjatabi", "thebloodthirster", "mawofmalmortius", "frozenmallet");
		database[i][0].setAsNeeded("ravenoushydra", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Rumble
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "mawofmalmortius");
		database[i][0].setAsNeeded("guardianangel", "atmasimpaler", "bansheesveil", "warmogsarmor");
	
		//Ryze
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge", "mawofmalmortius");
	
		//Sejuani
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "atmasimpaler");
		database[i][0].setAsNeeded("guardianangel", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Shaco
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("bootsofswiftness", "statikkshiv", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("ravenoushydra", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Shen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "atmasimpaler");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Shyvana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "atmasimpaler");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Singed
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("berserkergreaves", "ravenoushydra", "sunfirecape", "muramana");
		database[i][0].setAsNeeded("guardianangel", "randuinsomen", "bansheesveil", "frozenheart");
		
		//Sion
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "ravenoushydra", "phantomdancer");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Sivir
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("mercurialscimitar", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Skarner
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "atmasimpaler");
		database[i][0].setAsNeeded("witsend", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Sona
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Soraka
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Swain
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge", "mawofmalmortius");
	
		//Syndra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Talon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("bootsofswiftness", "frozenmallet", "trinityforce", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "youmuusghostblade");
	
		//Taric
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "atmasimpaler");
		database[i][0].setAsNeeded("witsend", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Teemo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("mercurialscimitar", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Thresh
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "statikkshiv", "infinityedge");
		database[i][0].setAsNeeded("bladeoftheruinedking", "guardianangel", "bansheesveil", "lastwhisper");
	
		//Tristana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("bladeoftheruinedking", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Trundle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "frozenmallet", "atmasimpaler");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Tryndamere
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("berserkergreaves", "bladeoftheruinedking", "lastwhisper", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "statikkshiv", "youmuusghostblade", "theblackcleaver");
	
		//Twisted Fate
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "statikkshiv", "lastwhisper");
		database[i][0].setAsNeeded("guardianangel", "bansheesveil", "infinityedge");
	
		//Twitch
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("mercurialscimitar", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Udyr
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "infinityedge", "phantomdancer");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Urgot
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("mercurytreads", "muramana", "theblackcleaver", "mawofmalmortius");
		database[i][0].setAsNeeded("frozenheart", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Varus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("bladeoftheruinedking", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Vayne
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("berserkergreaves", "bladeoftheruinedking", "phantomdancer", "infinityedge");
		database[i][0].setAsNeeded("thebloodthirster", "lastwhisper", "bansheesveil", "guardianangel");
	
		//Veigar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge", "mawofmalmortius");
	
		//Vel'Koz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge", "mawofmalmortius");
	
		//Vi
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "infinityedge", "phantomdancer");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Viktor
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Vladimir
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge", "mawofmalmortius");
	
		//Volibear
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "clotharmor", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "ravenoushydra", "phantomdancer");
		database[i][0].setAsNeeded("bladeoftheruinedking", "mawofmalmortius", "bansheesveil", "warmogsarmor");
	
		//Warwick
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "longsword", "healthpotion");
		database[i][0].setRush("mercurytreads", "thebloodthirster", "ravenoushydra", "frozenmallet");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "witsend");
	
		//Wukong
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("mercurytreads", "thebloodthirster", "ravenoushydra", "theblackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Xerath
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	
		//Xin Zhao
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("mercurytreads", "thebloodthirster", "ravenoushydra", "theblackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Yasuo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("mercurytreads", "bladeoftheruinedking", "statikkshiv", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "randuinsomen");
	
		//Yorick
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransblade", "healthpotion");
		database[i][0].setRush("mercurystreads", "bladeoftheruinedking", "statikkshiv", "infinityedge");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "randuinsomen");
	
		//Zac
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("mercurytreads", "thebloodthirster", "ravenoushydra", "theblackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "frozenmallet");
	
		//Zed
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("mercurytreads", "thebloodthirster", "bladeoftheruinedking", "theblackcleaver");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "mercurialscimitar", "randuinsomen");
	
		//Ziggs
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge", "mawofmalmortius");
	
		//Zilean
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge", "mawofmalmortius");
	
		//Zyra
		database[++i][0] = new BuildInfo();	
		database[i][0].setStart("wardingtotem", "bootsofspeed", "healthpotion");
		database[i][0].setRush("berserkergreaves", "thebloodthirster", "phantomdancer", "manamune");
		database[i][0].setAsNeeded("guardianangel", "lastwhisper", "bansheesveil", "infinityedge");
	}
	
	private void buildsupp(){
		int i=0;
		
		//Aatrox
		database[i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "rejuvenationbead", "stealthward", "healthpotion");
		database[i][0].setRush("avariceblade", "mercurytreads", "rubysightstone");
		database[i][0].setAsNeeded("spiritvisage", "aegisofthelegion", "hexdrinker", "mawofmalmortius", "youmuusghostblade");

		//Ahri
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward");
		database[i][0].setRush("chaliceofharmony", "rubysightstone", "bootsofmobility", "liandrystorment");
		database[i][0].setAsNeeded("mikaelscrucible","deathfiregrasp", "morellonomicon", "zhonyashourglass","rylaiscrystalscepter");
		
		//Akali
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Alistar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "iceborngauntlet");
		database[i][0].setAsNeeded("mikaelscrucible", "locketoftheironsolari", "talismanofascension", "randuinsomen", "spiritvisage");

		//Amumu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("abyssalscepter", "sunfirecape", "bootsofmobility");
		database[i][0].setAsNeeded("rylaiscrystalscepter", "randuinsomen", "zhonyashourglass", "locketoftheironsolari", "talismanofascension");
		
		//Anivia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("chaliceofharmony", "rubysightstone", "sorcerersshoes");
		database[i][0].setAsNeeded("athenesunholygrail", "rabadonsdeathcap", "zhonyashourglass", "abyssalscepter", "liandrystorment");

		//Annie
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "healthpotion");
		database[i][0].setRush("chaliceofharmony", "rubysightstone", "bootsofmobility");
		database[i][0].setAsNeeded("talismanofascension", "rabadonsdeathcap", "mikaelscrucible", "deathfiregrasp");

		//Ashe
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("tearofthegoddess", "talismanofascension", "berserkergreaves");
		database[i][0].setAsNeeded("manamune", "locketoftheironsolari", "theblackcleaver", "infinityedge");

		//Blitzcrank
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "talismanofascension", "ninjatabi");
		database[i][0].setAsNeeded("twinshadows", "sunfirecape", "iceborngauntlet", "locketoftheironsolari", "bansheesveil");

		//Brand
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "frostqueensclaim", "rylaiscrystalscepter", "bootsofmobility");
		database[i][0].setAsNeeded("rabadonsdeathcap", "voidstaff", "randuinsomen", "liandrystorment", "locketoftheironsolari");
		
		//Braum
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "healthpotion");
		database[i][0].setRush("rubysightstone", "mercurytreads", "faceofthemountain");
		database[i][0].setAsNeeded("randuinsomen", "locketoftheironsolari", "bansheesveil", "frozenheart", "mikaelscrucible");
	
		//Caitlyn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("vampiricscepter", "rubysightstone", "berserkergreaves");
		database[i][0].setAsNeeded("frozenmallet", "talismanofascension", "bladeoftheruinedking", "zephyr");
		
		//Cassiopeia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "liandrystorment", "rylaiscrystalscepter", "sorcerersshoes");
		database[i][0].setAsNeeded("abyssalscepter", "athenesunholygrail", "seraphsembrace", "rodofages", "zhonyashourglass");

		//Cho'Gath
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "mercurytreads", "talismanofascension");
		database[i][0].setAsNeeded("spiritvisage", "warmogsarmor", "randuinsomen", "rodofages", "abyssalscepter");

		//Corki
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Darius
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofswiftness", "faceofthemountain");
		database[i][0].setAsNeeded("spiritvisage", "randuinsomen", "guardianangel", "warmogsarmor", "trinityforce");
		
		//Diana
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Dr. Mundo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "spiritvisage", "ninjatabi", "sunfirecape");
		database[i][0].setAsNeeded("locketoftheironsolari", "bansheesveil", "faceofthemountain", "warmogsarmor", "liandrystorment");

		//Draven
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Elise
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "frostqueensclaim", "liandrystorment");
		database[i][0].setAsNeeded("morellonomicon", "rylaiscrystalscepter", "mikaelscrucible", "locketoftheironsolari", "abyssalscepter");
		
		//Evelynn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("bootsofmobility", "frostqueensclaim", "rylaiscrystalscepter");
		database[i][0].setAsNeeded("catalysttheprotector", "rodofages", "abyssalscepter", "locketoftheironsolari", "talismanofascension");

		//Ezreal
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "ionianbootsoflucidity", "atmasimpaler");
		database[i][0].setAsNeeded("trinityforce", "locketoftheironsolari", "faceofthemountain", "zekesherald");

		//Fiddlesticks
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "ancientcoin", "stealthward");
		database[i][0].setRush("rubysightstone", "talismanofascension", "bootsofmobility");
		database[i][0].setAsNeeded("locketoftheironsolari", "twinshadows", "spiritvisage", "abyssalscepter", "zhonyashourglass");

		//Fiora
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Fizz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rylaiscrystalscepter", "bladeoftheruinedking", "mercurytreads");
		database[i][0].setAsNeeded("warmogsarmor", "sunfirecape", "frozenheart", "spiritvisage");
		
		//Galio
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "healthpotion");
		database[i][0].setRush("chaliceofharmony", "rubysightstone", "mercurytreads");
		database[i][0].setAsNeeded("athenesunholygrail", "abyssalscepter", "talismanofascension", "sunfirecape");

		//Gangplank
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("avariceblade", "rubysightstone", "mercurytreads");
		database[i][0].setAsNeeded("talismanofascension", "locketoftheironsolari", "atmasimpaler", "frozenmallet", "warmogsarmor");
		
		//Garen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("avariceblade", "ninjatabi", "sunfirecape", "rubysightstone");
		database[i][0].setAsNeeded("warmogsarmor", "talismanofascension", "atmasimpaler");

		//Gnar
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Gragas
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward");
		database[i][0].setRush("frostqueensclaim", "rubysightstone", "bootsofmobility");
		database[i][0].setAsNeeded("athenesunholygrail", "morellonomicon", "rylaiscrystalscepter", "twinshadows");

		//Graves
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Hecarim
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("rubysightstone", "thornmail", "ninjatabi");
		database[i][0].setAsNeeded("talismanofascension", "warmogsarmor", "bansheesveil");

		//Heimerdinger
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "talismanofascension");
		database[i][0].setAsNeeded("abyssalscepter", "morellonomicon", "rabadonsdeathcap", "rylaiscrystalscepter", "zhonyashourglass");

		//Irelia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("rubysightstone", "ninjatabi");
		database[i][0].setAsNeeded("bladeoftheruinedking", "trinityforce", "statikkshiv");

		//Janna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "talismanofascension", "mercurytreads");
		database[i][0].setAsNeeded("mikaelscrucible", "locketoftheironsolari", "morellonomicon", "rabadonsdeathcap");
		
		//J4
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "vampiricscepter", "bootsofmobility", "theblackcleaver");
		database[i][0].setAsNeeded("locketoftheironsolari", "faceofthemountain", "randuinsomen", "iceborngauntlet", "zekesherald");

		//Jax
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Jayce
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "ionianbootsoflucidity");
		database[i][0].setAsNeeded("locketoftheironsolari", "zekesherald", "talismanofascension", "theblackcleaver", "randuinsomen");

		//Jinx
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Karma
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "talismanofascension");
		database[i][0].setAsNeeded("mikaelscrucible", "locketoftheironsolari", "liandrystorment", "rabadonsdeathcap", "morellonomicon");
		
		//Karthus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("nomadsmedallion", "tearofthegoddess", "sorcerersshoes");
		database[i][0].setAsNeeded("rodofages", "rabadonsdeathcap", "voidstaff", "zhonyashourglass", "talismanofascension");
		
		//Kassadin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "healthpotion");
		database[i][0].setRush("tearofthegoddess", "catalysttheprotector", "rabadonsdeathcap", "bootsofswiftness");
		database[i][0].setAsNeeded("rodofages", "rylaiscrystalscepter", "archangelsstaff", "zhonyashourglass");

		//Katarina
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Kayle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "ionianbootsoflucidity", "nashorstooth", "morellonomicon");
		database[i][0].setAsNeeded("mikaelscrucible", "lichbane", "voidstaff", "liandrystorment", "abyssalscepter");

		//Kennen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "stealthward");
		database[i][0].setRush("rylaiscrystalscepter", "rubysightstone", "ninjatabi");
		database[i][0].setAsNeeded("randuinsomen", "locketoftheironsolari", "liandrystorment", "talismanofascension", "abyssalscepter");

		//Kha'Zix
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Kog'Maw
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//LeBlanc
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "stealthward", "healthpotion");
		database[i][0].setRush("nomadsmedallion", "rubysightstone", "deathfiregrasp");
		database[i][0].setAsNeeded("sorcerersshoes", "talismanofascension", "rabadonsdeathcap", "zhonyashourglass", "morellonomicon");

		//Lee Sin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "faceofthemountain");
		database[i][0].setAsNeeded("locketoftheironsolari", "randuinsomen", "theblackcleaver", "zekesherald");

		//Leona
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "targonsbrace", "mercurytreads");
		database[i][0].setAsNeeded("talismanofascension", "faceofthemountain", "locketoftheironsolari", "frozenheart", "bansheesveil");

		//Lissandra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("frostqueensclaim", "rubysightstone", "zhonyashourglass", "sorcerersshoes");
		database[i][0].setAsNeeded("abyssalscepter", "guardianangel", "frozenheart", "liandrystorment", "deathfiregrasp");

		//Lucian
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Lulu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "sorcerersshoes", "mikaelscrucible");
		database[i][0].setAsNeeded("lichbane", "morellonomicon", "locketoftheironsolari", "bansheesveil", "zhonyashourglass");
		
		//Lux
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("frostqueensclaim", "sorcerersshoes", "rubysightstone");
		database[i][0].setAsNeeded("twinshadows", "zekesherald", "mikaelscrucible", "rabadonsdeathcap", "zhonyashourglass");
		
		//Malphite
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("rubysightstone", "sorcerersshoes", "frozenheart");
		database[i][0].setAsNeeded("talismanofascension", "abyssalscepter", "randuinsomen", "locketoftheironsolari", "liandrystorment");
		
		//Malzahar
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Maokai
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "mercurytreads", "spiritvisage");
		database[i][0].setAsNeeded("talismanofascension", "randuinsomen", "locketoftheironsolari", "iceborngauntlet", "athenesunholygrail");
		
		//Master Yi
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Miss Fortune
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Mordekaiser
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Morgana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "spellthiefsedge", "stealthward");
		database[i][0].setRush("rubysightstone", "mercurytreads", "zhonyashourglass");
		database[i][0].setAsNeeded("frostqueensclaim", "rodofages", "liandrystorment", "rabadonsdeathcap", "abyssalscepter");

		//Nami
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "chaliceofharmony", "bootsofmobility");
		database[i][0].setAsNeeded("talismanofascension", "mikaelscrucible", "locketoftheironsolari", "bansheesveil");

		//Nasus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofswiftness", "frozenheart", "locketoftheironsolari");
		database[i][0].setAsNeeded("frozenmallet", "spiritvisage", "sunfirecape", "warmogsarmor", "randuinsomen");

		//Nautilus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "ninjatabi", "faceofthemountain");
		database[i][0].setAsNeeded("locketoftheironsolari", "randuinsomen", "spiritvisage");

		//Nidalee
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "manapotion");
		database[i][0].setRush("rubysightstone", "frostqueensclaim", "bootsofmobility");
		database[i][0].setAsNeeded("rabadonsdeathcap", "bannerofcommand", "voidstaff", "lichbane", "rylaiscrystalscepter");

		//Nocturne
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Nunu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "talismanofascension");
		database[i][0].setAsNeeded("randuinsomen", "spiritvisage", "locketoftheironsolari", "sunfirecape");

		//Olaf
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Orianna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("athenesunholygrail", "frostqueensclaim", "mercurytreads");
		database[i][0].setAsNeeded("locketoftheironsolari", "rylaiscrystalscepter", "liandrystorment", "twinshadows", "zhonyashourglass");

		//Pantheon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "crystallineflask", "stealthward", "healthpotion");
		database[i][0].setRush("theblackcleaver", "lastwhisper", "mercurytreads");
		database[i][0].setAsNeeded("randuinsomen", "spiritvisage", "thebloodthirster");

		//Poppy
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "healthpotion");
		database[i][0].setRush("sheen", "rubysightstone", "ionianbootsoflucidity");
		database[i][0].setAsNeeded("trinityforce", "hextechgunblade", "talismanofascension", "frozenheart", "bladeoftheruinedking");

		//Quinn
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Rammus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "ancientcoin", "stealthward");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "talismanofascension", "sunfirecape");
		database[i][0].setAsNeeded("randuinsomen", "thornmail", "locketoftheironsolari", "spiritvisage", "warmogsarmor");

		//Renekton
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Rengar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "zekesherald", "tiamat");
		database[i][0].setAsNeeded("spiritvisage", "sunfirecape", "ravenoushydra", "infinityedge", "theblackcleaver");

		//Riven
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("thebrutalizer", "ravenoushydra", "ninjatabi");
		database[i][0].setAsNeeded("talismanofascension", "thebloodthirster", "theblackcleaver", "lastwhisper");

		//Rumble
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("doransshield", "sorcerersshoes", "rylaiscrystalscepter", "locketoftheironsolari");
		database[i][0].setAsNeeded("zhonyashourglass", "abyssalscepter", "randuinsomen", "rabadonsdeathcap", "liandrystorment");

		//Ryze
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Sejuani
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Shaco
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "frostqueensclaim");
		database[i][0].setAsNeeded("frostqueensclaim", "zhonyashourglass", "rabadonsdeathcap", "mikaelscrucible", "lichbane");
				
		//Shen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "mercurytreads", "faceofthemountain");
		database[i][0].setAsNeeded("locketoftheironsolari", "warmogsarmor", "spiritvisage", "randuinsomen", "bansheesveil");

		//Shyvana
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Singed
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("archangelsstaff", "rylaiscrystalscepter", "liandrystorment");
		database[i][0].setAsNeeded("randuinsomen", "spiritvisage", "warmogsarmor", "thornmail");
		
		//Sion
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("voidstaff", "mercurytreads", "rubysightstone");
		database[i][0].setAsNeeded("talismanofascension", "lichbane", "iceborngauntlet", "abyssalscepter", "rylaiscrystalscepter");

		//Sivir
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Skarner
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Sona
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "ionianbootsoflucidity", "talismanofascension", "mikaelscrucible");
		database[i][0].setAsNeeded("locketoftheironsolari", "randuinsomen", "rabadonsdeathcap", "lichbane", "frozenheart");

		//Soraka
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "talismanofascension", "locketoftheironsolari");
		database[i][0].setAsNeeded("mikaelscrucible", "randuinsomen", "rylaiscrystalscepter", "liandrystorment", "morellonomicon");
		
		//Swain
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward");
		database[i][0].setRush("rodofages", "hauntingguise", "sorcerersshoes", "rylaiscrystalscepter");
		database[i][0].setAsNeeded("liandrystorment", "rabadonsdeathcap", "zhonyashourglass", "spiritvisage");

		//Syndra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("chaliceofharmony", "sorcerersshoes", "talismanofascension", "rubysightstone");
		database[i][0].setAsNeeded("athenesunholygrail", "voidstaff", "liandrystorment", "locketoftheironsolari", "rylaiscrystalscepter");

		//Talon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "relicshield", "stealthward", "manapotion");
		database[i][0].setRush("frozenheart", "ionianbootsoflucidity", "warmogsarmor");
		database[i][0].setAsNeeded("spiritvisage", "randuinsomen", "locketoftheironsolari", "theblackcleaver", "youmuusghostblade");

		//Taric
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("targonsbrace", "rubysightstone", "bootsofmobility");
		database[i][0].setAsNeeded("frozenheart", "faceofthemountain", "mikaelscrucible", "locketoftheironsolari", "talismanofascension");

		//Teemo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rabadonsdeathcap", "nashorstooth");
		database[i][0].setAsNeeded("voidstaff", "liandrystorment", "zhonyashourglass", "frostqueensclaim", "runaanshurricane");

		//Thresh
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "bootsofmobility", "talismanofascension");
		database[i][0].setAsNeeded("locketoftheironsolari", "mikaelscrucible", "sunfirecape", "abyssalscepter", "randuinsomen");

		//Tristana
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Trundle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "zekesherald", "talismanofascension", "bootsofmobility");
		database[i][0].setAsNeeded("iceborngauntlet", "frozenmallet", "randuinsomen", "warmogsarmor", "bladeoftheruinedking");

		//Tryndamere
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("targonsbrace", "ionianbootsoflucidity", "rubysightstone");
		database[i][0].setAsNeeded("locketoftheironsolari", "faceofthemountain", "randuinsomen", "frozenmallet", "zekesherald");

		//Twisted Fate
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("frostqueensclaim", "bootsofmobility", "rubysightstone");
		database[i][0].setAsNeeded("zephyr", "youmuusghostblade", "rylaiscrystalscepter");

		//Twitch
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Udyr
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "mercurytreads", "nomadsmedallion");
		database[i][0].setAsNeeded("talismanofascension", "iceborngauntlet", "locketoftheironsolari", "randuinsomen", "bansheesveil");

		//Urgot
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransshield", "healthpotion");
		database[i][0].setRush("rubysightstone", "kindlegem", "mercurytreads", "talismanofascension");
		database[i][0].setAsNeeded("locketoftheironsolari", "frozenmallet", "zekesherald", "frozenheart", "mikaelscrucible");

		//Varus
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Vayne
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Veigar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("rubysightstone", "ionianbootsoflucidity", "deathfiregrasp");
		database[i][0].setAsNeeded("voidstaff", "rabadonsdeathcap", "talismanofascension", "zhonyashourglass", "guardianangel");

		//Vel'Koz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "healthpotion");
		database[i][0].setRush("frostqueensclaim", "athenesunholygrail");
		database[i][0].setAsNeeded("zhonyashourglass", "rylaiscrystalscepter", "iceborngauntlet", "abyssalscepter");

		//Vi
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "thebrutalizer", "mercurytreads");
		database[i][0].setAsNeeded("frozenmallet", "theblackcleaver", "locketoftheironsolari", "thebloodthirster");

		//Viktor
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "stealthward", "healthpotion");
		database[i][0].setRush("viktor4", "rubysightstone", "bootsofmobility");
		database[i][0].setAsNeeded("athenesunholygrail", "rylaiscrystalscepter", "frostqueensclaim");

		//Vladimir
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Volibear
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "healthpotion");
		database[i][0].setRush("rubysightstone", "ninjatabi", "faceofthemountain");
		database[i][0].setAsNeeded("randuinsomen", "sunfirecape", "spiritvisage", "warmogsarmor");

		//Warwick
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("nomadsmedallion", "witsend", "bootsofmobility", "bladeoftheruinedking");
		database[i][0].setAsNeeded("frozenmallet", "spiritvisage", "sunfirecape", "talismanofascension", "locketoftheironsolari");
				
		//Wukong
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Xerath
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Xin Zhao
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Yasuo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward", "healthpotion");
		database[i][0].setRush("targonsbrace", "mercurytreads", "rubysightstone", "statikkshiv");
		database[i][0].setAsNeeded("trinityforce", "ravenoushydra", "randuinsomen", "frozenmallet", "bansheesveil");

		//Yorick
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Zac
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "relicshield", "stealthward");
		database[i][0].setRush("aegisofthelegion", "rubysightstone", "spiritvisage", "mercurytreads");
		database[i][0].setAsNeeded("faceofthemountain", "warmogsarmor", "locketoftheironsolari", "abyssalscepter", "rylaiscrystalscepter");

		//Zed
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Ziggs
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "ancientcoin", "stealthward", "healthpotion");
		database[i][0].setRush("rubysightstone", "sorcerersshoes", "talismanofascension", "lichbane");
		database[i][0].setAsNeeded("athenesunholygrail", "rabadonsdeathcap", "rylaiscrystalscepter", "liandrystorment", "voidstaff");

		//Zilean
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "crystallineflask", "stealthward", "healthpotion");
		database[i][0].setRush("chaliceofharmony", "bootsofmobility", "rubysightstone");
		database[i][0].setAsNeeded("talismanofascension", "mikaelscrucible", "locketoftheironsolari");

		//Zyra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "spellthiefsedge", "healthpotion");
		database[i][0].setRush("rubysightstone", "ionianbootsoflucidity", "liandrystorment");
		database[i][0].setAsNeeded("frostqueensclaim", "rylaiscrystalscepter", "zhonyashourglass", "rabadonsdeathcap");
	}
	
	private void buildjung(){
		int i=0;
		
		//Aatrox
		database[i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "guardianangel", "bootsofmobility", "bladeoftheruinedking");
		database[i][0].setAsNeeded("spiritvisage", "warmogsarmor", "randuinsomen", "ravenoushydra", "swordofthedivine");

		//Ahri
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "bootsofmobility", "rabadonsdeathcap");
		database[i][0].setAsNeeded("sheen", "zeal", "trinityforce", "hextechgunblade");

		//Akali
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("hextechgunblade", "sorcerersshoes", "zhonyashourglass");
		database[i][0].setAsNeeded("rabadonsdeathcap", "lichbane", "voidstaff", "rylaiscrystalscepter", "abyssalscepter");

		//Alistar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("iceborngauntlet", "bootsofmobility", "spiritoftheancientgolem", "spectrescowl");
		database[i][0].setAsNeeded("guardianangel", "zekesherald", "athenesunholygrail", "twinshadows");

		//Amumu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofmobility", "sunfirecape", "locketoftheironsolari");
		database[i][0].setAsNeeded("spiritoftheancientgolem", "abyssalscepter", "frozenheart", "randuinsomen");

		//Anivia
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Annie
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofmobility", "rabadonsdeathcap", "spiritofthespectralwraith");
		database[i][0].setAsNeeded("liandrystorment", "rylaiscrystalscepter", "voidstaff", "zhonyashourglass", "lichbane");

		//Ashe
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "liandrystorment", "bootsofmobility");
		database[i][0].setAsNeeded("iceborngauntlet", "theblackcleaver", "mawofmalmortius", "guinsoosrageblade", "zekesherald");
		
		//Blitzcrank
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "bootsofmobility", "tearofthegoddess");
		database[i][0].setAsNeeded("thebrutalizer", "trinityforce", "manamune", "theblackcleaver", "frozenheart");
		
		//Brand
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "bootsofmobility", "liandrystorment");
		database[i][0].setAsNeeded("rabadonsdeathcap", "rylaiscrystalscepter", "voidstaff", "abyssalscepter");
		
		//Braum
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "bootsofswiftness", "phage", "tiamat");
		database[i][0].setAsNeeded("ravenoushydra", "randuinsomen", "trinityforce", "frozenmallet", "mercurialscimitar");
		
		//Caitlyn
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Cassiopeia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("archangelsstaff", "rabadonsdeathcap", "spiritofthespectralwraith", "bootsofswiftness");
		database[i][0].setAsNeeded("lichbane", "rylaiscrystalscepter", "liandrystorment", "deathfiregrasp");
		
		//Cho'Gath
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "ninjatabi", "frozenheart");
		database[i][0].setAsNeeded("abyssalscepter", "randuinsomen", "spiritvisage", "witsend");
		
		//Corki
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "vampiricscepter", "bootsofswiftness");
		database[i][0].setAsNeeded("theblackcleaver", "thebloodthirster", "warmogsarmor", "iceborngauntlet", "trinityforce");

		//Darius
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "bootsofmobility");
		database[i][0].setAsNeeded("sunfirecape", "frozenmallet", "warmogsarmor", "randuinsomen");

		//Diana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("sorcerersshoes","spiritofthespectralwraith", "lichbane");
		database[i][0].setAsNeeded("zhonyashourglass", "rabadonsdeathcap", "nashorstooth");

		//Dr. Mundo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("ninjatabi", "spiritoftheancientgolem");
		database[i][0].setAsNeeded("spiritvisage", "sunfirecape", "randuinsomen", "warmogsarmor");
		
		//Draven
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("madredsrazors", "bootsofmobility", "wriggleslantern");
		database[i][0].setAsNeeded("thebloodthirster", "trinityforce", "infinityedge", "phantomdancer", "guardianangel");

		//Elise
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "liandrystorment");
		database[i][0].setAsNeeded("sunfirecape", "spiritvisage", "randuinsomen", "rylaiscrystalscepter", "frozenheart");

		//Evelynn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "deathfiregrasp");
		database[i][0].setAsNeeded("voidstaff", "zhonyashourglass", "rabadonsdeathcap", "abyssalscepter");
		

		//Ezreal
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "ionianbootsoflucidity");
		database[i][0].setAsNeeded("trinityforce", "thebloodthirster", "lastwhisper", "manamune", "iceborngauntlet");

		//Fiddlesticks
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "doransring", "stealthward");
		database[i][0].setRush("bootsofmobility", "zhonyashourglass", "rabadonsdeathcap");
		database[i][0].setAsNeeded("spiritofthespectralwraith", "voidstaff", "rylaiscrystalscepter", "liandrystorment");

		//Fiora
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "mercurytreads", "thebrutalizer");
		database[i][0].setAsNeeded("thebloodthirster", "ravenoushydra", "lastwhisper", "youmuusghostblade");

		//Fizz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofmobility", "iceborngauntlet");
		database[i][0].setAsNeeded("spiritoftheancientgolem", "locketoftheironsolari", "abyssalscepter", "lichbane");

		//Galio
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofmobility", "spiritoftheancientgolem", "iceborngauntlet");
		database[i][0].setAsNeeded("spiritvisage", "rodofages", "rylaiscrystalscepter", "warmogsarmor", "sunfirecape");

		//Gangplank
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "spiritoftheelderlizard", "hexdrinker");
		database[i][0].setAsNeeded("trinityforce", "mawofmalmortius", "ravenoushydra", "randuinsomen", "lastwhisper");

		//Garen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "spiritoftheancientgolem", "spiritvisage", "sunfirecape");
		database[i][0].setAsNeeded("locketoftheironsolari", "randuinsomen", "thornmail", "zekesherald");

		//Gnar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "ninjatabi", "youmuusghostblade", "trinityforce");
		database[i][0].setAsNeeded("randuinsomen", "bladeoftheruinedking", "thebloodthirster", "spiritvisage", "warmogsarmor");
		
		//Gragas
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes");
		database[i][0].setAsNeeded("liandrystorment", "voidstaff", "randuinsomen", "bansheesveil", "athenesunholygrail");

		//Graves
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "thebloodthirster", "berserkergreaves", "bladeoftheruinedking");
		database[i][0].setAsNeeded("frozenmallet", "runaanshurricane", "infinityedge", "phantomdancer", "theblackcleaver");
		
		//Hecarim
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "bootsofswiftness", "iceborngauntlet", "spiritvisage");
		database[i][0].setAsNeeded("randuinsomen", "locketoftheironsolari", "sunfirecape", "trinityforce");

		//Heimerdinger
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "rylaiscrystalscepter", "abyssalscepter");
		database[i][0].setAsNeeded("zhonyashourglass", "rabadonsdeathcap", "voidstaff", "athenesunholygrail");

		//Irelia
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "bootsofswiftness", "bilgewatercutlass", "zephyr");
		database[i][0].setAsNeeded("bladeoftheruinedking", "trinityforce", "ravenoushydra", "theblackcleaver");

		//Janna
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "bootsofmobility", "zephyr");
		database[i][0].setAsNeeded("zhonyashourglass", "nashorstooth", "iceborngauntlet");
		
		//J4
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "bootsofmobility", "tiamat");
		database[i][0].setAsNeeded("randuinsomen", "ravenoushydra", "locketoftheironsolari", "spiritvisage");

		//Jax
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "wriggleslantern", "bilgewatercutlass", "trinityforce");
		database[i][0].setAsNeeded("frozenheart", "mawofmalmortius", "hextechgunblade");

		//Jayce
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "frozenheart", "hexdrinker");
		database[i][0].setAsNeeded("lastwhisper", "randuinsomen", "mawofmalmortius", "trinityforce");

		//Jinx
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "berserkergreaves", "phantomdancer", "lastwhisper");
		database[i][0].setAsNeeded("thebloodthirster", "guardianangel", "infinityedge", "frozenmallet");

		//Karma
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "liandrystorment", "spiritofthespectralwraith");
		database[i][0].setAsNeeded("athenesunholygrail", "zhonyashourglass", "rabadonsdeathcap", "rylaiscrystalscepter");

		//Karthus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "rodofages", "zhonyashourglass");
		database[i][0].setAsNeeded("voidstaff", "rabadonsdeathcap", "rylaiscrystalscepter", "deathfiregrasp", "liandrystorment");

		//Kassadin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritstone", "sorcerersshoes", "archangelsstaff");
		database[i][0].setAsNeeded("rodofages", "rabadonsdeathcap", "voidstaff", "zhonyashourglass");

		//Katarina
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "sorcerersshoes", "liandrystorment");
		database[i][0].setAsNeeded("rylaiscrystalscepter", "sunfirecape", "zhonyashourglass", "rabadonsdeathcap");

		//Kayle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "sorcerersshoes", "nashorstooth", "rabadonsdeathcap");
		database[i][0].setAsNeeded("lichbane", "zephyr", "feralflare", "voidstaff");
		
		//Kennen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("berserkergreaves", "wriggleslantern", "phantomdancer");
		database[i][0].setAsNeeded("trinityforce", "thebloodthirster", "frozenmallet", "infinityedge");

		//Kha'Zix
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "spiritoftheelderlizard");
		database[i][0].setAsNeeded("mawofmalmortius", "randuinsomen", "lastwhisper", "guardianangel");
		
		//Kog'Maw
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//LeBlanc
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "mercurytreads", "lichbane");
		database[i][0].setAsNeeded("athenesunholygrail", "zhonyashourglass", "warmogsarmor", "rylaiscrystalscepter");

		//Lee Sin
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "spiritoftheelderlizard", "tiamat");
		database[i][0].setAsNeeded("lastwhisper", "theblackcleaver", "rubysightstone", "randuinsomen", "locketoftheironsolari");

		//Leona
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("sheen", "sunfirecape", "bootsofmobility", "spiritoftheancientgolem");
		database[i][0].setAsNeeded("iceborngauntlet", "trinityforce", "mawofmalmortius", "randuinsomen", "wriggleslantern");

		//Lissandra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "zhonyashourglass", "rabadonsdeathcap");
		database[i][0].setAsNeeded("morellonomicon", "voidstaff", "rylaiscrystalscepter", "liandrystorment");

		//Lucian
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Lulu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritstone", "avariceblade", "ionianbootsoflucidity");
		database[i][0].setAsNeeded("runaanshurricane", "zephyr", "spiritoftheelderlizard", "witsend", "staikkshiv");
		
		//Lux
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "fiendishcodex", "rabadonsdeathcap");
		database[i][0].setAsNeeded("morellonomicon", "rylaiscrystalscepter", "voidstaff", "abyssalscepter");

		//Malphite
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("ninjatabi", "spiritoftheancientgolem");
		database[i][0].setAsNeeded("locketoftheironsolari", "randuinsomen", "abyssalscepter", "frozenmallet");
		
		//Malzahar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritstone", "bootsofmobility", "archangelsstaff", "spiritofthespectralwraith");
		database[i][0].setAsNeeded("rodofages", "rabadonsdeathcap", "liandrystorment", "zhonyashourglass", "rylaiscrystalscepter");

		//Maokai
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofmobility", "spiritoftheancientgolem", "locketoftheironsolari");
		database[i][0].setAsNeeded("frozenheart", "randuinsomen", "abyssalscepter");

		//Master Yi
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "bootsofmobility", "youmuusghostblade", "infinityedge");
		database[i][0].setAsNeeded("bladeoftheruinedking", "feralflare", "guardianangel");

		//Miss Fortune
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("rabadonsdeathcap", "bootsofmobility", "spiritoftheelderlizard");
		database[i][0].setAsNeeded("lichbane", "trinityforce", "guardianangel", "warmogsarmor", "hextechgunblade");

		//Mordekaiser
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "bootsofswiftness", "sunfirecape");
		database[i][0].setAsNeeded("frozenheart", "bansheesveil", "voidstaff");

		//Morgana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "zhonyashourglass");
		database[i][0].setAsNeeded("rylaiscrystalscepter", "spiritvisage", "rodofages", "deathfiregrasp", "liandrystorment");

		//Nami
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "rodofages");
		database[i][0].setAsNeeded("rabadonsdeathcap", "liandrystorment", "morellonomicon", "zhonyashourglass");

		//Nasus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofswiftness", "spiritoftheancientgolem", "spiritvisage");
		database[i][0].setAsNeeded("randuinsomen", "iceborngauntlet", "warmogsarmor", "locketoftheironsolari");

		//Nautilus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofmobility", "spiritoftheancientgolem");
		database[i][0].setAsNeeded("locketoftheironsolari", "randuinsomen", "witsend");

		//Nidalee
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("archangelsstaff", "sorcerersshoes", "rabadonsdeathcap");
		database[i][0].setAsNeeded("voidstaff", "morellonomicon", "zhonyashourglass", "lichbane");

		//Nocturne
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "mercurytreads", "bladeoftheruinedking");
		database[i][0].setAsNeeded("randuinsomen", "bansheesveil", "lastwhisper", "frozenmallet");

		//Nunu
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "bootsofmobility", "locketoftheironsolari");
		database[i][0].setAsNeeded("spiritvisage", "randuinsomen", "sunfirecape");

		//Olaf
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "thebrutalizer", "mercurytreads", "locketoftheironsolari");
		database[i][0].setAsNeeded("warmogsarmor", "randuinsomen", "frozenheart", "frozenmallet");
		
		//Orianna
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Pantheon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofmobility", "spiritoftheelderlizard", "thebrutalizer");
		database[i][0].setAsNeeded("theblackcleaver", "locketoftheironsolari", "randuinsomen", "bladeoftheruinedking");

		//Poppy
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("trinityforce", "spiritoftheelderlizard", "bootsofmobility");
		database[i][0].setAsNeeded("ravenoushydra", "hextechgunblade", "randuinsomen", "thebloodthirster");

		//Quinn
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "bootsofmobility", "bladeoftheruinedking");
		database[i][0].setAsNeeded("frozenmallet", "lastwhisper", "mercurialscimitar", "thebloodthirster");

		//Rammus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "ninjatabi", "sunfirecape");
		database[i][0].setAsNeeded("bansheesveil", "randuinsomen", "thornmail");

		//Renekton
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "bootsofmobility", "sunfirecape");
		database[i][0].setAsNeeded("spiritvisage", "randuinsomen", "warmogsarmor", "mawofmalmortius", "thornmail");

		//Rengar
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "ravenoushydra", "bonetoothnecklace");
		database[i][0].setAsNeeded("lastwhisper", "randuinsomen", "mawofmalmortius", "spiritvisage", "guardianangel");

		//Riven
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("thebrutalizer", "spiritoftheelderlizard", "mercurytreads");
		database[i][0].setAsNeeded("ravenoushydra", "lastwhisper", "guardianangel", "theblackcleaver");

		//Rumble
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "zhonyashourglass");
		database[i][0].setAsNeeded("abyssalscepter", "rabadonsdeathcap", "liandrystorment", "randuinsomen", "rylaiscrystalscepter");

		//Ryze
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "archangelsstaff");
		database[i][0].setAsNeeded("athenesunholygrail", "abyssalscepter", "zhonyashourglass", "randuinsomen", "iceborngauntlet");

		//Sejuani
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "ninjatabi", "liandrystorment", "randuinsomen");
		database[i][0].setAsNeeded("spiritvisage", "sunfirecape", "guardianangel", "locketoftheironsolari", "frozenheart");

		//Shaco
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "doransblade");
		database[i][0].setRush("doransblade", "berserkergreaves", "statikkshiv");
		database[i][0].setAsNeeded("bladeoftheruinedking", "infinityedge", "lastwhisper", "phantomdancer");
		
		//Shen
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("madredsrazors", "ninjatabi", "sunfirecape");
		database[i][0].setAsNeeded("warmogsarmor", "witsend", "randuinsomen", "bladeoftheruinedking");

		//Shyvana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("ninjatabi", "spiritoftheancientgolem", "bladeoftheruinedking");
		database[i][0].setAsNeeded("sunfirecape", "randuinsomen", "locketoftheironsolari", "trinityforce", "spiritvisage");

		//Singed
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("ninjatabi", "spiritoftheancientgolem", "rylaiscrystalscepter");
		database[i][0].setAsNeeded("thornmail", "bansheesveil", "liandrystorment", "randuinsomen", "abyssalscepter");

		//Sion
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("avariceblade", "berserkergreaves", "vampiricscepter", "ravenoushydra");
		database[i][0].setAsNeeded("warmogsarmor", "infinityedge", "randuinsomen", "atmasimpaler", "zephyr");

		//Sivir
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("berserkergreaves", "wriggleslantern");
		database[i][0].setAsNeeded("infinityedge", "phantomdancer", "thebloodthirster", "theblackcleaver");

		//Skarner
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "bootsofmobility", "iceborngauntlet");
		database[i][0].setAsNeeded("sunfirecape", "witsend", "randuinsomen", "frozenheart", "trinityforce");

		//Sona
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;
		
		//Soraka
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "doransring", "healthpotion");
		database[i][0].setRush("tearofthegoddess", "mercurytreads", "archangelsstaff");
		database[i][0].setAsNeeded("bansheesveil", "locketoftheironsolari", "mikaelscrucible");

		//Swain
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Syndra
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritstone", "sorcerersshoes", "athenesunholygrail");
		database[i][0].setAsNeeded("spiritofthespectralwraith", "rabadonsdeathcap", "zhonyashourglass", "liandrystorment", "voidstaff");

		//Talon
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "bootsofmobility", "tearofthegoddess", "vampiricscepter");
		database[i][0].setAsNeeded("ravenoushydra", "theblackcleaver", "thebloodthirster", "spiritvisage", "lastwhisper");

		//Taric
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "ninjatabi", "manamune");
		database[i][0].setAsNeeded("bilgewatercutlass", "hextechgunblade", "zhonyashourglass", "frozenheart", "locketoftheironsolari");
		
		//Teemo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "sorcerersshoes", "nashorstooth");
		database[i][0].setAsNeeded("runaanshurricane", "rabadonsdeathcap", "liandrystorment", "lichbane");
		
		//Thresh
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("bootsofmobility", "wriggleslantern", "guinsoosrageblade");
		database[i][0].setAsNeeded("frozenmallet", "mawofmalmortius", "atmasimpaler", "sunfirecape");

		//Tristana
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("madredsrazors", "berserkergreaves", "bladeoftheruinedking");
		database[i][0].setAsNeeded("phantomdancer", "infinityedge", "lastwhisper", "guardianangel");

		//Trundle
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "mercurytreads", "thebrutalizer", "frozenmallet");
		database[i][0].setAsNeeded("theblackcleaver", "bilgewatercutlass", "bladeoftheruinedking", "randuinsomen");
		
		//Tryndamere
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "berserkergreaves", "avariceblade", "phantomdancer");
		database[i][0].setAsNeeded("infinityedge", "ravenoushydra", "youmuusghostblade", "thebloodthirster");

		//Twisted Fate
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("giantsbelt", "berserkergreaves", "runaanshurricane");
		database[i][0].setAsNeeded("frozenmallet", "manamune", "thebloodthirster", "bladeoftheruinedking");

		//Twitch
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("feralflare", "bootsofmobility", "spiritoftheelderlizard");
		database[i][0].setAsNeeded("lastwhisper", "bladeoftheruinedking", "infinityedge", "phantomdancer");

		//Udyr
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "mercurytreads", "trinityforce");
		database[i][0].setAsNeeded("frozenheart", "trinityforce", "bladeoftheruinedking", "mawofmalmortius");

		//Urgot
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "thebrutalizer", "mercurytreads");
		database[i][0].setAsNeeded("theblackcleaver", "iceborngauntlet", "mawofmalmortius", "thebloodthirster");

		//Varus
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "doransblade");
		database[i][0].setRush("berserkergreaves", "zeal", "vampiricscepter", "infinityedge");
		database[i][0].setAsNeeded("lastwhisper", "thebloodthirster", "phantomdancer", "frozenmallet", "bansheesveil");

		//Vayne
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("wriggleslantern", "berserkergreaves", "phantomdancer");
		database[i][0].setAsNeeded("thebloodthirster", "statikkshiv", "bladeoftheruinedking", "infinityedge");

		//Veigar
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Vel'Koz
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("sorcerersshoes", "spiritoftheancientgolem", "rabadonsdeathcap");
		database[i][0].setAsNeeded("voidstaff", "rylaiscrystalscepter", "athenesunholygrail", "liandrystorment");

		//Vi
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "spiritoftheelderlizard", "trinityforce");
		database[i][0].setAsNeeded("randuinsomen", "bansheesveil", "frozenheart");

		//Viktor
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "viktor0", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "bootsofmobility", "viktor6", "hextechrevolver");
		database[i][0].setAsNeeded("liandrystorment", "voidstaff", "rabadonsdeathcap");

		//Vladimir
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("hextechrevolver", "spiritofthespectralwraith", "bootsofmobility");
		database[i][0].setAsNeeded("willoftheancients", "hextechgunblade", "spiritvisage");

		//Volibear
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "mercurytreads", "randuinsomen", "spiritvisage");
		database[i][0].setAsNeeded("bladeoftheruinedking", "frozenmallet", "witsend", "sunfirecape", "warmogsarmor");

		//Warwick
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "ninjatabi", "bladeoftheruinedking");
		database[i][0].setAsNeeded("spiritvisage", "randuinsomen", "frozenheart", "sunfirecape", "witsend");

		//Wukong
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "theblackcleaver", "mercurytreads");
		database[i][0].setAsNeeded("bansheesveil","randuinsomen", "guardianangel", "mawofmalmortius", "lastwhisper");

		//Xerath
		database[++i][0] = new BuildInfo();
		numBuilds[i]--;

		//Xin Zhao
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "bladeoftheruinedking", "randuinsomen");
		database[i][0].setAsNeeded("guardianangel", "bansheesveil", "theblackcleaver", "thornmail");

		//Yasuo
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "berserkergreaves", "statikkshiv", "bladeoftheruinedking");
		database[i][0].setAsNeeded("infinityedge", "zephyr", "randuinsomen", "bansheesveil", "lastwhisper");

		//Yorick
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "bootsofmobility", "manamune");
		database[i][0].setAsNeeded("iceborngauntlet", "spiritvisage", "randuinsomen", "warmogsarmor", "sunfirecape");

		//Zac
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheancientgolem", "locketoftheironsolari", "ninjatabi", "spiritvisage");
		database[i][0].setAsNeeded("randuinsomen", "liandrystorment", "abyssalscepter", "thornmail");

		//Zed
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("wardingtotem", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritoftheelderlizard", "bootsofmobility", "lastwhisper");
		database[i][0].setAsNeeded("thebloodthirster", "bladeoftheruinedking", "warmogsarmor");

		//Ziggs
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes", "athenesunholygrail");
		database[i][0].setAsNeeded("rabadonsdeathcap", "voidstaff", "lichbane", "deathfiregrasp");

		//Zilean
		database[++i][0] = new BuildInfo();
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("spiritofthespectralwraith", "sorcerersshoes");
		database[i][0].setAsNeeded("zhonyashourglass", "rabadonsdeathcap", "rodofages", "rylaiscrystalscepter");
		
		//Zyra
		database[++i][0] = new BuildInfo();	
		database[i][0].setStart("sweepinglens", "huntersmachete", "healthpotion");
		database[i][0].setRush("mercurytreads", "spiritofthespectralwraith", "rylaiscrystalscepter", "zhonyashourglass");
		database[i][0].setAsNeeded("rabadonsdeathcap", "abyssalscepter", "frozenheart", "voidstaff", "liandrystorment");
	}
	
	public BuildInfo[][] getDatabase(){
		return database;
	}
}
