package com.fourfoureight.lolhelper;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.fourfoureight.lolhelper.General_Info.ChampionAttributes;

// Description:
// This is the main Team Builder class.
// It deals with the user interface for the team builder page.
public class TeamBuilder extends ActionBarActivity {
    
	// Create an instance for the data storage class.
    TeamBuilderData teambuilder = new TeamBuilderData();
	// button pressed = 1, button not pressed = 0
    int[] buttonPressFlags = {-1, -1, -1, -1, -1};
	// button is displaying a champion = 1, button is not displaying a champion = 0
    int[] buttonChangedFlags = {0, 0, 0, 0, 0};
        
	// Run when the team builder page created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_builder);
        
        FrameLayout layout = (FrameLayout)findViewById(R.id.container);
        if (((GlobalVariables) this.getApplication()).getskin() == 1)
    	{
    		layout.setBackgroundResource(R.drawable.bg);
    	}
    	if (((GlobalVariables) this.getApplication()).getskin() == 2)
    	{
    		layout.setBackgroundResource(R.drawable.bg2);
    	}
        
	// five buttons on the left
        final ImageButton top = (ImageButton)findViewById(R.id.imageButton00);
        final ImageButton jungle = (ImageButton)findViewById(R.id.imageButton01);
        final ImageButton middle = (ImageButton)findViewById(R.id.imageButton02);
        final ImageButton adc = (ImageButton)findViewById(R.id.imageButton03);
        final ImageButton support = (ImageButton)findViewById(R.id.imageButton04);
	// button "Suggest Champion" is invisible
        final Button suggestChampion = (Button)findViewById(R.id.Button06);
	// button "Suggest Style"
        final Button suggestStyle = (Button)findViewById(R.id.Button05);
	// spinner to selecting team styles
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
	// a table layout to display "All Available Champions"	
	final TableLayout table = (TableLayout)findViewById(R.id.Table);
        
        // set the display content for spinner
        String[] allStrategies = teambuilder.getAvailableStrategy();
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, allStrategies);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        // selector control for spinner
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                	teambuilder.setOurStrategy(-1);
                }
                else {
                	teambuilder.setOurStrategy(teambuilder.getAvailableStrategyArray(position));
                }
            	
			suggestChampion.performClick();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                teambuilder.setOurStrategy(-1);
            }
        });
                        
        // button Suggest Style
        suggestStyle.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				teambuilder.suggestStrategyForTeam();
		// update the contents in spinner
                String[] allStrategies = teambuilder.getAvailableStrategy();
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(TeamBuilder.this, android.R.layout.simple_spinner_item, allStrategies);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
				suggestChampion.performClick();
			}
		});
        
        // button Suggest Champion
        suggestChampion.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				
				// horizontal scroll bars after five buttons to display suggested champions.
				LinearLayout scroll1 = (LinearLayout)findViewById(R.id.Linear1);
				LinearLayout scroll2 = (LinearLayout)findViewById(R.id.Linear2);
				LinearLayout scroll3 = (LinearLayout)findViewById(R.id.Linear3);
				LinearLayout scroll4 = (LinearLayout)findViewById(R.id.Linear4);
				LinearLayout scroll5 = (LinearLayout)findViewById(R.id.Linear5);
				
				scroll1.removeAllViews();
				scroll2.removeAllViews();
				scroll3.removeAllViews();
				scroll4.removeAllViews();
				scroll5.removeAllViews();
				
				// suggested top champions
				ChampionAttributes[] suggestedTop = teambuilder.suggestChampionsByStrategy(0);
				if ((suggestedTop != null) && (buttonChangedFlags[0] == 0)){
					for (int i = 0; i < suggestedTop.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilder.this), suggestedTop[i]);
						if (suggestedTop[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						scroll1.addView(newButton);
						final ChampionAttributes currentChampion = suggestedTop[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[0] == 1){
									teambuilder.setOurTeam(0, currentChampion);
							    	String message = currentChampion.getName();
							    	int i;
							    	
							    	if(message.equals("Aatrox")){
							            i = 0;
									}else if(message.equals("Ahri")){
							            i = 1;
							    	}else if(message.equals("Akali")){
							            i = 2;
							    	}else if(message.equals("Alistar")){
							    		i = 3;
							    	}else if(message.equals("Amumu")){
							    		i = 4;
							    	}else if(message.equals("Anivia")){
							    		i = 5;
							    	}else if(message.equals("Annie")){
							    		i = 6;
							    	}else if(message.equals("Ashe")){
							            i = 7;
							    	}else if(message.equals("Blitzcrank")){
							            i = 8;
							    	}else if(message.equals("Brand")){
							            i = 9;
							    	}else if(message.equals("Caitlyn")){
							    		i = 10;
							    	}else if(message.equals("Cassiopeia")){
							    		i = 11;
							    	}else if(message.equals("Cho Gath")){
							    		i = 12;
							    	}else if(message.equals("Corki")){
							    		i = 13;
							    	}else if(message.equals("Darius")){
							    		i = 14;
							    	}else if(message.equals("Diana")){
							    		i = 15;
							    	}else if(message.equals("Dr. Mundo")){
							    		i = 16;
							    	}else if(message.equals("Draven")){
							    		i = 17;
							    	}else if(message.equals("Elise")){
							    		i = 18;
							    	}else if(message.equals("Evelynn")){
							    		i = 19;
							    	}else if(message.equals("Ezreal")){
							    		i = 20;
							    	}else if(message.equals("Fiddlesticks")){
							    		i = 21;
							    	}else if(message.equals("Fiora")){
							    		i = 22;
							    	}else if(message.equals("Fizz")){
							    		i = 23;
							    	}else if(message.equals("Galio")){
							    		i = 24;
							    	}else if(message.equals("Gangplank")){
							    		i = 25;
							    	}else if(message.equals("Garen")){
							    		i = 26;
							    	}else if(message.equals("Gragas")){
							    		i = 27;
							    	}else if(message.equals("Graves")){
							    		i = 28;
							    	}else if(message.equals("Hecarim")){
							    		i = 29;
							    	}else if(message.equals("Heimerdinger")){
							    		i = 30;
							    	}else if(message.equals("Irelia")){
							    		i = 31;
							    	}else if(message.equals("Janna")){
							    		i = 32;
							    	}else if(message.equals("Jarvan IV")){
							    		i = 33;
							    	}else if(message.equals("Jax")){
							    		i = 34;
							    	}else if(message.equals("Jayce")){
							    		i = 35;
							    	}else if(message.equals("Jinx")){
							    		i = 36;
							    	}else if(message.equals("Karma")){
							    		i = 37;
							    	}else if(message.equals("Karthus")){
							    		i = 38;
							    	}else if(message.equals("Kassadin")){
							    		i = 39;
							    	}else if(message.equals("Katarina")){
							    		i = 40;
							    	}else if(message.equals("Kayle")){
							    		i = 41;
							    	}else if(message.equals("Kennen")){
							    		i = 42;
							    	}else if(message.equals("Kha Zix")){
							    		i = 43;
							    	}else if(message.equals("Kog Maw")){
							    		i = 44;
							    	}else if(message.equals("LeBlanc")){
							    		i = 45;
							    	}else if(message.equals("Lee Sin")){
							    		i = 46;
							    	}else if(message.equals("Leona")){
							    		i = 47;
							    	}else if(message.equals("Lissandra")){
							    		i = 48;
							    	}else if(message.equals("Lucian")){
							    		i = 49;
							    	}else if(message.equals("Lulu")){
							    		i = 50;
							    	}else if(message.equals("Lux")){
							    		i = 51;
							    	}else if(message.equals("Malphite")){
							    		i = 52;
							    	}else if(message.equals("Malzahar")){
							    		i = 53;
							    	}else if(message.equals("Maokai")){
							    		i = 54;
							    	}else if(message.equals("Master Yi")){
							    		i = 55;
							    	}else if(message.equals("Miss Fortune")){
							    		i = 56;
							    	}else if(message.equals("Mordekaiser")){
							    		i = 57;
							    	}else if(message.equals("Morgana")){
							    		i = 58;
							    	}else if(message.equals("Nami")){
							    		i = 59;
							    	}else if(message.equals("Nasus")){
							    		i = 60;
							    	}else if(message.equals("Nautilus")){
							    		i = 61;
							    	}else if(message.equals("Nidalee")){
							    		i = 62;
							    	}else if(message.equals("Nocturne")){
							    		i = 63;
							    	}else if(message.equals("Nunu")){
							    		i = 64;
							    	}else if(message.equals("Olaf")){
							    		i = 65;
							    	}else if(message.equals("Orianna")){
							    		i = 66;
							    	}else if(message.equals("Pantheon")){
							    		i = 67;
							    	}else if(message.equals("Poppy")){
							    		i = 68;
							    	}else if(message.equals("Quinn")){
							    		i = 69;
							    	}else if(message.equals("Rammus")){
							    		i = 70;
							    	}else if(message.equals("Renekton")){
							    		i = 71;
							    	}else if(message.equals("Rengar")){
							    		i = 72;
							    	}else if(message.equals("Riven")){
							    		i = 73;
							    	}else if(message.equals("Rumble")){
							    		i = 74;
							    	}else if(message.equals("Ryze")){
							    		i = 75;
							    	}else if(message.equals("Sejuani")){
							    		i = 76;
							    	}else if(message.equals("Shaco")){
							    		i = 77;
							    	}else if(message.equals("Shen")){
							    		i = 78;
							    	}else if(message.equals("Shyvana")){
							    		i = 79;
							    	}else if(message.equals("Singed")){
							    		i = 80;
							    	}else if(message.equals("Sion")){
							    		i = 81;
							    	}else if(message.equals("Sivir")){
							    		i = 82;
							    	}else if(message.equals("Skarner")){
							    		i = 83;
							    	}else if(message.equals("Sona")){
							    		i = 84;
							    	}else if(message.equals("Soraka")){
							    		i = 85;
							    	}else if(message.equals("Swain")){
							    		i = 86;
							    	}else if(message.equals("Syndra")){
							    		i = 87;
							    	}else if(message.equals("Talon")){
							    		i = 88;
							    	}else if(message.equals("Taric")){
							    		i = 89;
							    	}else if(message.equals("Teemo")){
							    		i = 90;
							    	}else if(message.equals("Thresh")){
							    		i = 91;
							    	}else if(message.equals("Tristana")){
							    		i = 92;
							    	}else if(message.equals("Trundle")){
							    		i = 93;
							    	}else if(message.equals("Tryndamere")){
							    		i = 94;
							    	}else if(message.equals("Twisted Fate")){
							    		i = 95;
							    	}else if(message.equals("Twitch")){
							    		i = 96;
							    	}else if(message.equals("Udyr")){
							    		i = 97;
							    	}else if(message.equals("Urgot")){
							    		i = 98;
							    	}else if(message.equals("Varus")){
							    		i = 99;
							    	}else if(message.equals("Vayne")){
							    		i = 100;
							    	}else if(message.equals("Veigar")){
							    		i = 101;
							    	}else if(message.equals("Vel Koz")){
							    		i = 102;
							    	}else if(message.equals("Vi")){
							    		i = 103;
							    	}else if(message.equals("Viktor")){
							    		i = 104;
							    	}else if(message.equals("Vladimir")){
							    		i = 105;
							    	}else if(message.equals("Volibear")){
							    		i = 106;
							    	}else if(message.equals("Warwick")){
							    		i = 107;
							    	}else if(message.equals("Wukong")){
							    		i = 108;
							    	}else if(message.equals("Xerath")){
							    		i = 109;
							    	}else if(message.equals("Xin Zhao")){
							    		i = 110;
							    	}else if(message.equals("Yasuo")){
							    		i = 111;
							    	}else if(message.equals("Yorick")){
							    		i = 112;
							    	}else if(message.equals("Zac")){
							    		i = 113;
							    	}else if(message.equals("Zed")){
							    		i = 114;
							    	}else if(message.equals("Ziggs")){
							    		i = 115;
							    	}else if(message.equals("Zilean")){
							    		i = 116;
							    	}else{
							    		i=117;
							    	}

									switch(i){
										case 0: top.setImageResource(R.drawable.aatrox);
											break;
										case 1: top.setImageResource(R.drawable.ahri);
											break;
										case 2: top.setImageResource(R.drawable.akali);
											break;
										case 3: top.setImageResource(R.drawable.alistar);
											break;
										case 4: top.setImageResource(R.drawable.amumu);
											break;
										case 5: top.setImageResource(R.drawable.anivia);
											break;
										case 6: top.setImageResource(R.drawable.annie);
											break;
										case 7: top.setImageResource(R.drawable.ashe);
											break;
										case 8: top.setImageResource(R.drawable.blitzcrank);
											break;
										case 9: top.setImageResource(R.drawable.brand);
											break;
										case 10: top.setImageResource(R.drawable.caitlyn);
											break;
										case 11: top.setImageResource(R.drawable.cassiopeia);
											break;
										case 12: top.setImageResource(R.drawable.chogath);
											break;
										case 13: top.setImageResource(R.drawable.corki);
											break;
										case 14: top.setImageResource(R.drawable.darius);
											break;						
										case 15: top.setImageResource(R.drawable.diana);
											break;						
										case 16: top.setImageResource(R.drawable.drmundo);
											break;						
										case 17: top.setImageResource(R.drawable.draven);
											break;						
										case 18: top.setImageResource(R.drawable.elise);
											break;						
										case 19: top.setImageResource(R.drawable.evelynn);
											break;						
										case 20: top.setImageResource(R.drawable.ezreal);
											break;						
										case 21: top.setImageResource(R.drawable.fiddlesticks);
											break;						
										case 22: top.setImageResource(R.drawable.fiora);
											break;						
										case 23: top.setImageResource(R.drawable.fizz);
											break;						
										case 24: top.setImageResource(R.drawable.galio);
											break;						
										case 25: top.setImageResource(R.drawable.gangplank);
											break;						
										case 26: top.setImageResource(R.drawable.garen);
											break;						
										case 27: top.setImageResource(R.drawable.gragas);
											break;						
										case 28: top.setImageResource(R.drawable.graves);
											break;						
										case 29: top.setImageResource(R.drawable.hecarim);
											break;						
										case 30: top.setImageResource(R.drawable.heimerdinger);
											break;						
										case 31: top.setImageResource(R.drawable.irelia);
											break;						
										case 32: top.setImageResource(R.drawable.janna);
											break;						
										case 33: top.setImageResource(R.drawable.jarvaniv);
											break;						
										case 34: top.setImageResource(R.drawable.jax);
											break;						
										case 35: top.setImageResource(R.drawable.jayce);
											break;						
										case 36: top.setImageResource(R.drawable.jinx);
											break;						
										case 37: top.setImageResource(R.drawable.karma);
											break;
										case 38: top.setImageResource(R.drawable.karthus);
											break;
										case 39: top.setImageResource(R.drawable.kassadin);
											break;     	
										case 40: top.setImageResource(R.drawable.katarina);
											break;     	
										case 41: top.setImageResource(R.drawable.kayle);
											break;     	
										case 42: top.setImageResource(R.drawable.kennen);
											break;     	
										case 43: top.setImageResource(R.drawable.khazix);
											break;     	
										case 44: top.setImageResource(R.drawable.kogmaw);
											break;     	
										case 45: top.setImageResource(R.drawable.leblanc);
											break;     	
										case 46: top.setImageResource(R.drawable.leesin);
											break;     	
										case 47: top.setImageResource(R.drawable.leona);
											break;     	
										case 48: top.setImageResource(R.drawable.lissandra);
											break;     	
										case 49: top.setImageResource(R.drawable.lucian);
											break;     	
										case 50: top.setImageResource(R.drawable.lulu);
											break;     	
										case 51: top.setImageResource(R.drawable.lux);
											break;     	
										case 52: top.setImageResource(R.drawable.malphite);
											break;     	
										case 53: top.setImageResource(R.drawable.malzahar);
											break;     	
										case 54: top.setImageResource(R.drawable.maokai);
											break;     	
										case 55: top.setImageResource(R.drawable.masteryi);
											break;     	
										case 56: top.setImageResource(R.drawable.missfortune);
											break;     	
										case 57: top.setImageResource(R.drawable.mordekaiser);
											break;     	
										case 58: top.setImageResource(R.drawable.morgana);
											break;     	
										case 59: top.setImageResource(R.drawable.nami);
											break;     	
										case 60: top.setImageResource(R.drawable.nasus);
											break;     	
										case 61: top.setImageResource(R.drawable.nautilus);
											break;     	
										case 62: top.setImageResource(R.drawable.nidalee);
											break;     	
										case 63: top.setImageResource(R.drawable.nocturne);
											break;     	
										case 64: top.setImageResource(R.drawable.nunu);
											break;     	
										case 65: top.setImageResource(R.drawable.olaf);
											break;     	
										case 66: top.setImageResource(R.drawable.orianna);
											break;     	
										case 67: top.setImageResource(R.drawable.pantheon);
											break;     	
										case 68: top.setImageResource(R.drawable.poppy);
											break;     	
										case 69: top.setImageResource(R.drawable.quinn);
											break;     	
										case 70: top.setImageResource(R.drawable.rammus);
											break;     	
										case 71: top.setImageResource(R.drawable.renekton);
											break;     	
										case 72: top.setImageResource(R.drawable.rengar);
											break;     	
										case 73: top.setImageResource(R.drawable.riven);
											break;     	
										case 74: top.setImageResource(R.drawable.rumble);
											break;     	
										case 75: top.setImageResource(R.drawable.ryze);
											break;     	
										case 76: top.setImageResource(R.drawable.sejuani);
											break;     	
										case 77: top.setImageResource(R.drawable.shaco);
											break; 		
										case 78: top.setImageResource(R.drawable.shen);
											break;     			
										case 79: top.setImageResource(R.drawable.shyvana);
											break;     			
										case 80: top.setImageResource(R.drawable.singed);
											break;     			
										case 81: top.setImageResource(R.drawable.sion);
											break;     			
										case 82: top.setImageResource(R.drawable.sivir);
											break;     			
										case 83: top.setImageResource(R.drawable.skarner);
											break;     			
										case 84: top.setImageResource(R.drawable.sona);
											break;     			
										case 85: top.setImageResource(R.drawable.soraka);
											break;     			
										case 86: top.setImageResource(R.drawable.swain);
											break;     			
										case 87: top.setImageResource(R.drawable.syndra);
											break;     			
										case 88: top.setImageResource(R.drawable.talon);
											break;     			
										case 89: top.setImageResource(R.drawable.taric);
											break;     			
										case 90: top.setImageResource(R.drawable.teemo);
											break;     			
										case 91: top.setImageResource(R.drawable.thresh);
											break;     			
										case 92: top.setImageResource(R.drawable.tristana);
											break;     			
										case 93: top.setImageResource(R.drawable.trundle);
											break;     			
										case 94: top.setImageResource(R.drawable.tryndamere);
											break;     			
										case 95: top.setImageResource(R.drawable.twistedfate);
											break;     			
										case 96: top.setImageResource(R.drawable.twitch);
											break;     			
										case 97: top.setImageResource(R.drawable.udyr);
											break;     			
										case 98: top.setImageResource(R.drawable.urgot);
											break;     			
										case 99: top.setImageResource(R.drawable.varus);
											break;     			
										case 100: top.setImageResource(R.drawable.vayne);
											break;     			
										case 101: top.setImageResource(R.drawable.veigar);
											break;     			
										case 102: top.setImageResource(R.drawable.velkoz);
											break;     			
										case 103: top.setImageResource(R.drawable.vi);
											break;     			
										case 104: top.setImageResource(R.drawable.viktor);
											break;     			
										case 105: top.setImageResource(R.drawable.vladimir);
											break;     			
										case 106: top.setImageResource(R.drawable.volibear);
											break;     			
										case 107: top.setImageResource(R.drawable.warwick);
											break;     			
										case 108: top.setImageResource(R.drawable.wukong);
											break;     			
										case 109: top.setImageResource(R.drawable.xerath);
											break;     			
										case 110: top.setImageResource(R.drawable.xinzhao);
											break;     			
										case 111: top.setImageResource(R.drawable.yasuo);
											break;     			
										case 112: top.setImageResource(R.drawable.yorick);
											break;     			
										case 113: top.setImageResource(R.drawable.zac);
											break;     			
										case 114: top.setImageResource(R.drawable.zed);
											break;     			
										case 115: top.setImageResource(R.drawable.ziggs);
											break;     			
										case 116: top.setImageResource(R.drawable.zilean);
											break;     			
										case 117: top.setImageResource(R.drawable.zyra);
											break;     							
										default: 
											break;
										}

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[0] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}
				
				// suggested jungle champions
				ChampionAttributes[] suggestedJungle = teambuilder.suggestChampionsByStrategy(1);
				if ((suggestedJungle != null) && (buttonChangedFlags[1] == 0)){
					for (int i = 0; i < suggestedJungle.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilder.this), suggestedJungle[i]);
						if (suggestedJungle[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						scroll2.addView(newButton);
						final ChampionAttributes currentChampion = suggestedJungle[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[1] == 1){
									teambuilder.setOurTeam(1, currentChampion);
							    	String message = currentChampion.getName();
							    	int i;
							    	
							    	if(message.equals("Aatrox")){
							            i = 0;
									}else if(message.equals("Ahri")){
							            i = 1;
							    	}else if(message.equals("Akali")){
							            i = 2;
							    	}else if(message.equals("Alistar")){
							    		i = 3;
							    	}else if(message.equals("Amumu")){
							    		i = 4;
							    	}else if(message.equals("Anivia")){
							    		i = 5;
							    	}else if(message.equals("Annie")){
							    		i = 6;
							    	}else if(message.equals("Ashe")){
							            i = 7;
							    	}else if(message.equals("Blitzcrank")){
							            i = 8;
							    	}else if(message.equals("Brand")){
							            i = 9;
							    	}else if(message.equals("Caitlyn")){
							    		i = 10;
							    	}else if(message.equals("Cassiopeia")){
							    		i = 11;
							    	}else if(message.equals("Cho Gath")){
							    		i = 12;
							    	}else if(message.equals("Corki")){
							    		i = 13;
							    	}else if(message.equals("Darius")){
							    		i = 14;
							    	}else if(message.equals("Diana")){
							    		i = 15;
							    	}else if(message.equals("Dr. Mundo")){
							    		i = 16;
							    	}else if(message.equals("Draven")){
							    		i = 17;
							    	}else if(message.equals("Elise")){
							    		i = 18;
							    	}else if(message.equals("Evelynn")){
							    		i = 19;
							    	}else if(message.equals("Ezreal")){
							    		i = 20;
							    	}else if(message.equals("Fiddlesticks")){
							    		i = 21;
							    	}else if(message.equals("Fiora")){
							    		i = 22;
							    	}else if(message.equals("Fizz")){
							    		i = 23;
							    	}else if(message.equals("Galio")){
							    		i = 24;
							    	}else if(message.equals("Gangplank")){
							    		i = 25;
							    	}else if(message.equals("Garen")){
							    		i = 26;
							    	}else if(message.equals("Gragas")){
							    		i = 27;
							    	}else if(message.equals("Graves")){
							    		i = 28;
							    	}else if(message.equals("Hecarim")){
							    		i = 29;
							    	}else if(message.equals("Heimerdinger")){
							    		i = 30;
							    	}else if(message.equals("Irelia")){
							    		i = 31;
							    	}else if(message.equals("Janna")){
							    		i = 32;
							    	}else if(message.equals("Jarvan IV")){
							    		i = 33;
							    	}else if(message.equals("Jax")){
							    		i = 34;
							    	}else if(message.equals("Jayce")){
							    		i = 35;
							    	}else if(message.equals("Jinx")){
							    		i = 36;
							    	}else if(message.equals("Karma")){
							    		i = 37;
							    	}else if(message.equals("Karthus")){
							    		i = 38;
							    	}else if(message.equals("Kassadin")){
							    		i = 39;
							    	}else if(message.equals("Katarina")){
							    		i = 40;
							    	}else if(message.equals("Kayle")){
							    		i = 41;
							    	}else if(message.equals("Kennen")){
							    		i = 42;
							    	}else if(message.equals("Kha Zix")){
							    		i = 43;
							    	}else if(message.equals("Kog Maw")){
							    		i = 44;
							    	}else if(message.equals("LeBlanc")){
							    		i = 45;
							    	}else if(message.equals("Lee Sin")){
							    		i = 46;
							    	}else if(message.equals("Leona")){
							    		i = 47;
							    	}else if(message.equals("Lissandra")){
							    		i = 48;
							    	}else if(message.equals("Lucian")){
							    		i = 49;
							    	}else if(message.equals("Lulu")){
							    		i = 50;
							    	}else if(message.equals("Lux")){
							    		i = 51;
							    	}else if(message.equals("Malphite")){
							    		i = 52;
							    	}else if(message.equals("Malzahar")){
							    		i = 53;
							    	}else if(message.equals("Maokai")){
							    		i = 54;
							    	}else if(message.equals("Master Yi")){
							    		i = 55;
							    	}else if(message.equals("Miss Fortune")){
							    		i = 56;
							    	}else if(message.equals("Mordekaiser")){
							    		i = 57;
							    	}else if(message.equals("Morgana")){
							    		i = 58;
							    	}else if(message.equals("Nami")){
							    		i = 59;
							    	}else if(message.equals("Nasus")){
							    		i = 60;
							    	}else if(message.equals("Nautilus")){
							    		i = 61;
							    	}else if(message.equals("Nidalee")){
							    		i = 62;
							    	}else if(message.equals("Nocturne")){
							    		i = 63;
							    	}else if(message.equals("Nunu")){
							    		i = 64;
							    	}else if(message.equals("Olaf")){
							    		i = 65;
							    	}else if(message.equals("Orianna")){
							    		i = 66;
							    	}else if(message.equals("Pantheon")){
							    		i = 67;
							    	}else if(message.equals("Poppy")){
							    		i = 68;
							    	}else if(message.equals("Quinn")){
							    		i = 69;
							    	}else if(message.equals("Rammus")){
							    		i = 70;
							    	}else if(message.equals("Renekton")){
							    		i = 71;
							    	}else if(message.equals("Rengar")){
							    		i = 72;
							    	}else if(message.equals("Riven")){
							    		i = 73;
							    	}else if(message.equals("Rumble")){
							    		i = 74;
							    	}else if(message.equals("Ryze")){
							    		i = 75;
							    	}else if(message.equals("Sejuani")){
							    		i = 76;
							    	}else if(message.equals("Shaco")){
							    		i = 77;
							    	}else if(message.equals("Shen")){
							    		i = 78;
							    	}else if(message.equals("Shyvana")){
							    		i = 79;
							    	}else if(message.equals("Singed")){
							    		i = 80;
							    	}else if(message.equals("Sion")){
							    		i = 81;
							    	}else if(message.equals("Sivir")){
							    		i = 82;
							    	}else if(message.equals("Skarner")){
							    		i = 83;
							    	}else if(message.equals("Sona")){
							    		i = 84;
							    	}else if(message.equals("Soraka")){
							    		i = 85;
							    	}else if(message.equals("Swain")){
							    		i = 86;
							    	}else if(message.equals("Syndra")){
							    		i = 87;
							    	}else if(message.equals("Talon")){
							    		i = 88;
							    	}else if(message.equals("Taric")){
							    		i = 89;
							    	}else if(message.equals("Teemo")){
							    		i = 90;
							    	}else if(message.equals("Thresh")){
							    		i = 91;
							    	}else if(message.equals("Tristana")){
							    		i = 92;
							    	}else if(message.equals("Trundle")){
							    		i = 93;
							    	}else if(message.equals("Tryndamere")){
							    		i = 94;
							    	}else if(message.equals("Twisted Fate")){
							    		i = 95;
							    	}else if(message.equals("Twitch")){
							    		i = 96;
							    	}else if(message.equals("Udyr")){
							    		i = 97;
							    	}else if(message.equals("Urgot")){
							    		i = 98;
							    	}else if(message.equals("Varus")){
							    		i = 99;
							    	}else if(message.equals("Vayne")){
							    		i = 100;
							    	}else if(message.equals("Veigar")){
							    		i = 101;
							    	}else if(message.equals("Vel Koz")){
							    		i = 102;
							    	}else if(message.equals("Vi")){
							    		i = 103;
							    	}else if(message.equals("Viktor")){
							    		i = 104;
							    	}else if(message.equals("Vladimir")){
							    		i = 105;
							    	}else if(message.equals("Volibear")){
							    		i = 106;
							    	}else if(message.equals("Warwick")){
							    		i = 107;
							    	}else if(message.equals("Wukong")){
							    		i = 108;
							    	}else if(message.equals("Xerath")){
							    		i = 109;
							    	}else if(message.equals("Xin Zhao")){
							    		i = 110;
							    	}else if(message.equals("Yasuo")){
							    		i = 111;
							    	}else if(message.equals("Yorick")){
							    		i = 112;
							    	}else if(message.equals("Zac")){
							    		i = 113;
							    	}else if(message.equals("Zed")){
							    		i = 114;
							    	}else if(message.equals("Ziggs")){
							    		i = 115;
							    	}else if(message.equals("Zilean")){
							    		i = 116;
							    	}else{
							    		i=117;
							    	}

									switch(i){
										case 0: jungle.setImageResource(R.drawable.aatrox);
											break;
										case 1: jungle.setImageResource(R.drawable.ahri);
											break;
										case 2: jungle.setImageResource(R.drawable.akali);
											break;
										case 3: jungle.setImageResource(R.drawable.alistar);
											break;
										case 4: jungle.setImageResource(R.drawable.amumu);
											break;
										case 5: jungle.setImageResource(R.drawable.anivia);
											break;
										case 6: jungle.setImageResource(R.drawable.annie);
											break;
										case 7: jungle.setImageResource(R.drawable.ashe);
											break;
										case 8: jungle.setImageResource(R.drawable.blitzcrank);
											break;
										case 9: jungle.setImageResource(R.drawable.brand);
											break;
										case 10: jungle.setImageResource(R.drawable.caitlyn);
											break;
										case 11: jungle.setImageResource(R.drawable.cassiopeia);
											break;
										case 12: jungle.setImageResource(R.drawable.chogath);
											break;
										case 13: jungle.setImageResource(R.drawable.corki);
											break;
										case 14: jungle.setImageResource(R.drawable.darius);
											break;						
										case 15: jungle.setImageResource(R.drawable.diana);
											break;						
										case 16: jungle.setImageResource(R.drawable.drmundo);
											break;						
										case 17: jungle.setImageResource(R.drawable.draven);
											break;						
										case 18: jungle.setImageResource(R.drawable.elise);
											break;						
										case 19: jungle.setImageResource(R.drawable.evelynn);
											break;						
										case 20: jungle.setImageResource(R.drawable.ezreal);
											break;						
										case 21: jungle.setImageResource(R.drawable.fiddlesticks);
											break;						
										case 22: jungle.setImageResource(R.drawable.fiora);
											break;						
										case 23: jungle.setImageResource(R.drawable.fizz);
											break;						
										case 24: jungle.setImageResource(R.drawable.galio);
											break;						
										case 25: jungle.setImageResource(R.drawable.gangplank);
											break;						
										case 26: jungle.setImageResource(R.drawable.garen);
											break;						
										case 27: jungle.setImageResource(R.drawable.gragas);
											break;						
										case 28: jungle.setImageResource(R.drawable.graves);
											break;						
										case 29: jungle.setImageResource(R.drawable.hecarim);
											break;						
										case 30: jungle.setImageResource(R.drawable.heimerdinger);
											break;						
										case 31: jungle.setImageResource(R.drawable.irelia);
											break;						
										case 32: jungle.setImageResource(R.drawable.janna);
											break;						
										case 33: jungle.setImageResource(R.drawable.jarvaniv);
											break;						
										case 34: jungle.setImageResource(R.drawable.jax);
											break;						
										case 35: jungle.setImageResource(R.drawable.jayce);
											break;						
										case 36: jungle.setImageResource(R.drawable.jinx);
											break;						
										case 37: jungle.setImageResource(R.drawable.karma);
											break;
										case 38: jungle.setImageResource(R.drawable.karthus);
											break;
										case 39: jungle.setImageResource(R.drawable.kassadin);
											break;     	
										case 40: jungle.setImageResource(R.drawable.katarina);
											break;     	
										case 41: jungle.setImageResource(R.drawable.kayle);
											break;     	
										case 42: jungle.setImageResource(R.drawable.kennen);
											break;     	
										case 43: jungle.setImageResource(R.drawable.khazix);
											break;     	
										case 44: jungle.setImageResource(R.drawable.kogmaw);
											break;     	
										case 45: jungle.setImageResource(R.drawable.leblanc);
											break;     	
										case 46: jungle.setImageResource(R.drawable.leesin);
											break;     	
										case 47: jungle.setImageResource(R.drawable.leona);
											break;     	
										case 48: jungle.setImageResource(R.drawable.lissandra);
											break;     	
										case 49: jungle.setImageResource(R.drawable.lucian);
											break;     	
										case 50: jungle.setImageResource(R.drawable.lulu);
											break;     	
										case 51: jungle.setImageResource(R.drawable.lux);
											break;     	
										case 52: jungle.setImageResource(R.drawable.malphite);
											break;     	
										case 53: jungle.setImageResource(R.drawable.malzahar);
											break;     	
										case 54: jungle.setImageResource(R.drawable.maokai);
											break;     	
										case 55: jungle.setImageResource(R.drawable.masteryi);
											break;     	
										case 56: jungle.setImageResource(R.drawable.missfortune);
											break;     	
										case 57: jungle.setImageResource(R.drawable.mordekaiser);
											break;     	
										case 58: jungle.setImageResource(R.drawable.morgana);
											break;     	
										case 59: jungle.setImageResource(R.drawable.nami);
											break;     	
										case 60: jungle.setImageResource(R.drawable.nasus);
											break;     	
										case 61: jungle.setImageResource(R.drawable.nautilus);
											break;     	
										case 62: jungle.setImageResource(R.drawable.nidalee);
											break;     	
										case 63: jungle.setImageResource(R.drawable.nocturne);
											break;     	
										case 64: jungle.setImageResource(R.drawable.nunu);
											break;     	
										case 65: jungle.setImageResource(R.drawable.olaf);
											break;     	
										case 66: jungle.setImageResource(R.drawable.orianna);
											break;     	
										case 67: jungle.setImageResource(R.drawable.pantheon);
											break;     	
										case 68: jungle.setImageResource(R.drawable.poppy);
											break;     	
										case 69: jungle.setImageResource(R.drawable.quinn);
											break;     	
										case 70: jungle.setImageResource(R.drawable.rammus);
											break;     	
										case 71: jungle.setImageResource(R.drawable.renekton);
											break;     	
										case 72: jungle.setImageResource(R.drawable.rengar);
											break;     	
										case 73: jungle.setImageResource(R.drawable.riven);
											break;     	
										case 74: jungle.setImageResource(R.drawable.rumble);
											break;     	
										case 75: jungle.setImageResource(R.drawable.ryze);
											break;     	
										case 76: jungle.setImageResource(R.drawable.sejuani);
											break;     	
										case 77: jungle.setImageResource(R.drawable.shaco);
											break; 		
										case 78: jungle.setImageResource(R.drawable.shen);
											break;     			
										case 79: jungle.setImageResource(R.drawable.shyvana);
											break;     			
										case 80: jungle.setImageResource(R.drawable.singed);
											break;     			
										case 81: jungle.setImageResource(R.drawable.sion);
											break;     			
										case 82: jungle.setImageResource(R.drawable.sivir);
											break;     			
										case 83: jungle.setImageResource(R.drawable.skarner);
											break;     			
										case 84: jungle.setImageResource(R.drawable.sona);
											break;     			
										case 85: jungle.setImageResource(R.drawable.soraka);
											break;     			
										case 86: jungle.setImageResource(R.drawable.swain);
											break;     			
										case 87: jungle.setImageResource(R.drawable.syndra);
											break;     			
										case 88: jungle.setImageResource(R.drawable.talon);
											break;     			
										case 89: jungle.setImageResource(R.drawable.taric);
											break;     			
										case 90: jungle.setImageResource(R.drawable.teemo);
											break;     			
										case 91: jungle.setImageResource(R.drawable.thresh);
											break;     			
										case 92: jungle.setImageResource(R.drawable.tristana);
											break;     			
										case 93: jungle.setImageResource(R.drawable.trundle);
											break;     			
										case 94: jungle.setImageResource(R.drawable.tryndamere);
											break;     			
										case 95: jungle.setImageResource(R.drawable.twistedfate);
											break;     			
										case 96: jungle.setImageResource(R.drawable.twitch);
											break;     			
										case 97: jungle.setImageResource(R.drawable.udyr);
											break;     			
										case 98: jungle.setImageResource(R.drawable.urgot);
											break;     			
										case 99: jungle.setImageResource(R.drawable.varus);
											break;     			
										case 100: jungle.setImageResource(R.drawable.vayne);
											break;     			
										case 101: jungle.setImageResource(R.drawable.veigar);
											break;     			
										case 102: jungle.setImageResource(R.drawable.velkoz);
											break;     			
										case 103: jungle.setImageResource(R.drawable.vi);
											break;     			
										case 104: jungle.setImageResource(R.drawable.viktor);
											break;     			
										case 105: jungle.setImageResource(R.drawable.vladimir);
											break;     			
										case 106: jungle.setImageResource(R.drawable.volibear);
											break;     			
										case 107: jungle.setImageResource(R.drawable.warwick);
											break;     			
										case 108: jungle.setImageResource(R.drawable.wukong);
											break;     			
										case 109: jungle.setImageResource(R.drawable.xerath);
											break;     			
										case 110: jungle.setImageResource(R.drawable.xinzhao);
											break;     			
										case 111: jungle.setImageResource(R.drawable.yasuo);
											break;     			
										case 112: jungle.setImageResource(R.drawable.yorick);
											break;     			
										case 113: jungle.setImageResource(R.drawable.zac);
											break;     			
										case 114: jungle.setImageResource(R.drawable.zed);
											break;     			
										case 115: jungle.setImageResource(R.drawable.ziggs);
											break;     			
										case 116: jungle.setImageResource(R.drawable.zilean);
											break;     			
										case 117: jungle.setImageResource(R.drawable.zyra);
											break;     							
										default: 
											break;
										}

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[1] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}

				// Suggested middle champions				
				ChampionAttributes[] suggestedMid = teambuilder.suggestChampionsByStrategy(2);
				if ((suggestedMid != null) && (buttonChangedFlags[2] == 0)){
					for (int i = 0; i < suggestedMid.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilder.this), suggestedMid[i]);
						if (suggestedMid[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						scroll3.addView(newButton);
						final ChampionAttributes currentChampion = suggestedMid[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[2] == 1){
									teambuilder.setOurTeam(2, currentChampion);
							    	String message = currentChampion.getName();
							    	int i;
							    	
							    	if(message.equals("Aatrox")){
							            i = 0;
									}else if(message.equals("Ahri")){
							            i = 1;
							    	}else if(message.equals("Akali")){
							            i = 2;
							    	}else if(message.equals("Alistar")){
							    		i = 3;
							    	}else if(message.equals("Amumu")){
							    		i = 4;
							    	}else if(message.equals("Anivia")){
							    		i = 5;
							    	}else if(message.equals("Annie")){
							    		i = 6;
							    	}else if(message.equals("Ashe")){
							            i = 7;
							    	}else if(message.equals("Blitzcrank")){
							            i = 8;
							    	}else if(message.equals("Brand")){
							            i = 9;
							    	}else if(message.equals("Caitlyn")){
							    		i = 10;
							    	}else if(message.equals("Cassiopeia")){
							    		i = 11;
							    	}else if(message.equals("Cho Gath")){
							    		i = 12;
							    	}else if(message.equals("Corki")){
							    		i = 13;
							    	}else if(message.equals("Darius")){
							    		i = 14;
							    	}else if(message.equals("Diana")){
							    		i = 15;
							    	}else if(message.equals("Dr. Mundo")){
							    		i = 16;
							    	}else if(message.equals("Draven")){
							    		i = 17;
							    	}else if(message.equals("Elise")){
							    		i = 18;
							    	}else if(message.equals("Evelynn")){
							    		i = 19;
							    	}else if(message.equals("Ezreal")){
							    		i = 20;
							    	}else if(message.equals("Fiddlesticks")){
							    		i = 21;
							    	}else if(message.equals("Fiora")){
							    		i = 22;
							    	}else if(message.equals("Fizz")){
							    		i = 23;
							    	}else if(message.equals("Galio")){
							    		i = 24;
							    	}else if(message.equals("Gangplank")){
							    		i = 25;
							    	}else if(message.equals("Garen")){
							    		i = 26;
							    	}else if(message.equals("Gragas")){
							    		i = 27;
							    	}else if(message.equals("Graves")){
							    		i = 28;
							    	}else if(message.equals("Hecarim")){
							    		i = 29;
							    	}else if(message.equals("Heimerdinger")){
							    		i = 30;
							    	}else if(message.equals("Irelia")){
							    		i = 31;
							    	}else if(message.equals("Janna")){
							    		i = 32;
							    	}else if(message.equals("Jarvan IV")){
							    		i = 33;
							    	}else if(message.equals("Jax")){
							    		i = 34;
							    	}else if(message.equals("Jayce")){
							    		i = 35;
							    	}else if(message.equals("Jinx")){
							    		i = 36;
							    	}else if(message.equals("Karma")){
							    		i = 37;
							    	}else if(message.equals("Karthus")){
							    		i = 38;
							    	}else if(message.equals("Kassadin")){
							    		i = 39;
							    	}else if(message.equals("Katarina")){
							    		i = 40;
							    	}else if(message.equals("Kayle")){
							    		i = 41;
							    	}else if(message.equals("Kennen")){
							    		i = 42;
							    	}else if(message.equals("Kha Zix")){
							    		i = 43;
							    	}else if(message.equals("Kog Maw")){
							    		i = 44;
							    	}else if(message.equals("LeBlanc")){
							    		i = 45;
							    	}else if(message.equals("Lee Sin")){
							    		i = 46;
							    	}else if(message.equals("Leona")){
							    		i = 47;
							    	}else if(message.equals("Lissandra")){
							    		i = 48;
							    	}else if(message.equals("Lucian")){
							    		i = 49;
							    	}else if(message.equals("Lulu")){
							    		i = 50;
							    	}else if(message.equals("Lux")){
							    		i = 51;
							    	}else if(message.equals("Malphite")){
							    		i = 52;
							    	}else if(message.equals("Malzahar")){
							    		i = 53;
							    	}else if(message.equals("Maokai")){
							    		i = 54;
							    	}else if(message.equals("Master Yi")){
							    		i = 55;
							    	}else if(message.equals("Miss Fortune")){
							    		i = 56;
							    	}else if(message.equals("Mordekaiser")){
							    		i = 57;
							    	}else if(message.equals("Morgana")){
							    		i = 58;
							    	}else if(message.equals("Nami")){
							    		i = 59;
							    	}else if(message.equals("Nasus")){
							    		i = 60;
							    	}else if(message.equals("Nautilus")){
							    		i = 61;
							    	}else if(message.equals("Nidalee")){
							    		i = 62;
							    	}else if(message.equals("Nocturne")){
							    		i = 63;
							    	}else if(message.equals("Nunu")){
							    		i = 64;
							    	}else if(message.equals("Olaf")){
							    		i = 65;
							    	}else if(message.equals("Orianna")){
							    		i = 66;
							    	}else if(message.equals("Pantheon")){
							    		i = 67;
							    	}else if(message.equals("Poppy")){
							    		i = 68;
							    	}else if(message.equals("Quinn")){
							    		i = 69;
							    	}else if(message.equals("Rammus")){
							    		i = 70;
							    	}else if(message.equals("Renekton")){
							    		i = 71;
							    	}else if(message.equals("Rengar")){
							    		i = 72;
							    	}else if(message.equals("Riven")){
							    		i = 73;
							    	}else if(message.equals("Rumble")){
							    		i = 74;
							    	}else if(message.equals("Ryze")){
							    		i = 75;
							    	}else if(message.equals("Sejuani")){
							    		i = 76;
							    	}else if(message.equals("Shaco")){
							    		i = 77;
							    	}else if(message.equals("Shen")){
							    		i = 78;
							    	}else if(message.equals("Shyvana")){
							    		i = 79;
							    	}else if(message.equals("Singed")){
							    		i = 80;
							    	}else if(message.equals("Sion")){
							    		i = 81;
							    	}else if(message.equals("Sivir")){
							    		i = 82;
							    	}else if(message.equals("Skarner")){
							    		i = 83;
							    	}else if(message.equals("Sona")){
							    		i = 84;
							    	}else if(message.equals("Soraka")){
							    		i = 85;
							    	}else if(message.equals("Swain")){
							    		i = 86;
							    	}else if(message.equals("Syndra")){
							    		i = 87;
							    	}else if(message.equals("Talon")){
							    		i = 88;
							    	}else if(message.equals("Taric")){
							    		i = 89;
							    	}else if(message.equals("Teemo")){
							    		i = 90;
							    	}else if(message.equals("Thresh")){
							    		i = 91;
							    	}else if(message.equals("Tristana")){
							    		i = 92;
							    	}else if(message.equals("Trundle")){
							    		i = 93;
							    	}else if(message.equals("Tryndamere")){
							    		i = 94;
							    	}else if(message.equals("Twisted Fate")){
							    		i = 95;
							    	}else if(message.equals("Twitch")){
							    		i = 96;
							    	}else if(message.equals("Udyr")){
							    		i = 97;
							    	}else if(message.equals("Urgot")){
							    		i = 98;
							    	}else if(message.equals("Varus")){
							    		i = 99;
							    	}else if(message.equals("Vayne")){
							    		i = 100;
							    	}else if(message.equals("Veigar")){
							    		i = 101;
							    	}else if(message.equals("Vel Koz")){
							    		i = 102;
							    	}else if(message.equals("Vi")){
							    		i = 103;
							    	}else if(message.equals("Viktor")){
							    		i = 104;
							    	}else if(message.equals("Vladimir")){
							    		i = 105;
							    	}else if(message.equals("Volibear")){
							    		i = 106;
							    	}else if(message.equals("Warwick")){
							    		i = 107;
							    	}else if(message.equals("Wukong")){
							    		i = 108;
							    	}else if(message.equals("Xerath")){
							    		i = 109;
							    	}else if(message.equals("Xin Zhao")){
							    		i = 110;
							    	}else if(message.equals("Yasuo")){
							    		i = 111;
							    	}else if(message.equals("Yorick")){
							    		i = 112;
							    	}else if(message.equals("Zac")){
							    		i = 113;
							    	}else if(message.equals("Zed")){
							    		i = 114;
							    	}else if(message.equals("Ziggs")){
							    		i = 115;
							    	}else if(message.equals("Zilean")){
							    		i = 116;
							    	}else{
							    		i=117;
							    	}

									switch(i){
										case 0: middle.setImageResource(R.drawable.aatrox);
											break;
										case 1: middle.setImageResource(R.drawable.ahri);
											break;
										case 2: middle.setImageResource(R.drawable.akali);
											break;
										case 3: middle.setImageResource(R.drawable.alistar);
											break;
										case 4: middle.setImageResource(R.drawable.amumu);
											break;
										case 5: middle.setImageResource(R.drawable.anivia);
											break;
										case 6: middle.setImageResource(R.drawable.annie);
											break;
										case 7: middle.setImageResource(R.drawable.ashe);
											break;
										case 8: middle.setImageResource(R.drawable.blitzcrank);
											break;
										case 9: middle.setImageResource(R.drawable.brand);
											break;
										case 10: middle.setImageResource(R.drawable.caitlyn);
											break;
										case 11: middle.setImageResource(R.drawable.cassiopeia);
											break;
										case 12: middle.setImageResource(R.drawable.chogath);
											break;
										case 13: middle.setImageResource(R.drawable.corki);
											break;
										case 14: middle.setImageResource(R.drawable.darius);
											break;						
										case 15: middle.setImageResource(R.drawable.diana);
											break;						
										case 16: middle.setImageResource(R.drawable.drmundo);
											break;						
										case 17: middle.setImageResource(R.drawable.draven);
											break;						
										case 18: middle.setImageResource(R.drawable.elise);
											break;						
										case 19: middle.setImageResource(R.drawable.evelynn);
											break;						
										case 20: middle.setImageResource(R.drawable.ezreal);
											break;						
										case 21: middle.setImageResource(R.drawable.fiddlesticks);
											break;						
										case 22: middle.setImageResource(R.drawable.fiora);
											break;						
										case 23: middle.setImageResource(R.drawable.fizz);
											break;						
										case 24: middle.setImageResource(R.drawable.galio);
											break;						
										case 25: middle.setImageResource(R.drawable.gangplank);
											break;						
										case 26: middle.setImageResource(R.drawable.garen);
											break;						
										case 27: middle.setImageResource(R.drawable.gragas);
											break;						
										case 28: middle.setImageResource(R.drawable.graves);
											break;						
										case 29: middle.setImageResource(R.drawable.hecarim);
											break;						
										case 30: middle.setImageResource(R.drawable.heimerdinger);
											break;						
										case 31: middle.setImageResource(R.drawable.irelia);
											break;						
										case 32: middle.setImageResource(R.drawable.janna);
											break;						
										case 33: middle.setImageResource(R.drawable.jarvaniv);
											break;						
										case 34: middle.setImageResource(R.drawable.jax);
											break;						
										case 35: middle.setImageResource(R.drawable.jayce);
											break;						
										case 36: middle.setImageResource(R.drawable.jinx);
											break;						
										case 37: middle.setImageResource(R.drawable.karma);
											break;
										case 38: middle.setImageResource(R.drawable.karthus);
											break;
										case 39: middle.setImageResource(R.drawable.kassadin);
											break;     	
										case 40: middle.setImageResource(R.drawable.katarina);
											break;     	
										case 41: middle.setImageResource(R.drawable.kayle);
											break;     	
										case 42: middle.setImageResource(R.drawable.kennen);
											break;     	
										case 43: middle.setImageResource(R.drawable.khazix);
											break;     	
										case 44: middle.setImageResource(R.drawable.kogmaw);
											break;     	
										case 45: middle.setImageResource(R.drawable.leblanc);
											break;     	
										case 46: middle.setImageResource(R.drawable.leesin);
											break;     	
										case 47: middle.setImageResource(R.drawable.leona);
											break;     	
										case 48: middle.setImageResource(R.drawable.lissandra);
											break;     	
										case 49: middle.setImageResource(R.drawable.lucian);
											break;     	
										case 50: middle.setImageResource(R.drawable.lulu);
											break;     	
										case 51: middle.setImageResource(R.drawable.lux);
											break;     	
										case 52: middle.setImageResource(R.drawable.malphite);
											break;     	
										case 53: middle.setImageResource(R.drawable.malzahar);
											break;     	
										case 54: middle.setImageResource(R.drawable.maokai);
											break;     	
										case 55: middle.setImageResource(R.drawable.masteryi);
											break;     	
										case 56: middle.setImageResource(R.drawable.missfortune);
											break;     	
										case 57: middle.setImageResource(R.drawable.mordekaiser);
											break;     	
										case 58: middle.setImageResource(R.drawable.morgana);
											break;     	
										case 59: middle.setImageResource(R.drawable.nami);
											break;     	
										case 60: middle.setImageResource(R.drawable.nasus);
											break;     	
										case 61: middle.setImageResource(R.drawable.nautilus);
											break;     	
										case 62: middle.setImageResource(R.drawable.nidalee);
											break;     	
										case 63: middle.setImageResource(R.drawable.nocturne);
											break;     	
										case 64: middle.setImageResource(R.drawable.nunu);
											break;     	
										case 65: middle.setImageResource(R.drawable.olaf);
											break;     	
										case 66: middle.setImageResource(R.drawable.orianna);
											break;     	
										case 67: middle.setImageResource(R.drawable.pantheon);
											break;     	
										case 68: middle.setImageResource(R.drawable.poppy);
											break;     	
										case 69: middle.setImageResource(R.drawable.quinn);
											break;     	
										case 70: middle.setImageResource(R.drawable.rammus);
											break;     	
										case 71: middle.setImageResource(R.drawable.renekton);
											break;     	
										case 72: middle.setImageResource(R.drawable.rengar);
											break;     	
										case 73: middle.setImageResource(R.drawable.riven);
											break;     	
										case 74: middle.setImageResource(R.drawable.rumble);
											break;     	
										case 75: middle.setImageResource(R.drawable.ryze);
											break;     	
										case 76: middle.setImageResource(R.drawable.sejuani);
											break;     	
										case 77: middle.setImageResource(R.drawable.shaco);
											break; 		
										case 78: middle.setImageResource(R.drawable.shen);
											break;     			
										case 79: middle.setImageResource(R.drawable.shyvana);
											break;     			
										case 80: middle.setImageResource(R.drawable.singed);
											break;     			
										case 81: middle.setImageResource(R.drawable.sion);
											break;     			
										case 82: middle.setImageResource(R.drawable.sivir);
											break;     			
										case 83: middle.setImageResource(R.drawable.skarner);
											break;     			
										case 84: middle.setImageResource(R.drawable.sona);
											break;     			
										case 85: middle.setImageResource(R.drawable.soraka);
											break;     			
										case 86: middle.setImageResource(R.drawable.swain);
											break;     			
										case 87: middle.setImageResource(R.drawable.syndra);
											break;     			
										case 88: middle.setImageResource(R.drawable.talon);
											break;     			
										case 89: middle.setImageResource(R.drawable.taric);
											break;     			
										case 90: middle.setImageResource(R.drawable.teemo);
											break;     			
										case 91: middle.setImageResource(R.drawable.thresh);
											break;     			
										case 92: middle.setImageResource(R.drawable.tristana);
											break;     			
										case 93: middle.setImageResource(R.drawable.trundle);
											break;     			
										case 94: middle.setImageResource(R.drawable.tryndamere);
											break;     			
										case 95: middle.setImageResource(R.drawable.twistedfate);
											break;     			
										case 96: middle.setImageResource(R.drawable.twitch);
											break;     			
										case 97: middle.setImageResource(R.drawable.udyr);
											break;     			
										case 98: middle.setImageResource(R.drawable.urgot);
											break;     			
										case 99: middle.setImageResource(R.drawable.varus);
											break;     			
										case 100: middle.setImageResource(R.drawable.vayne);
											break;     			
										case 101: middle.setImageResource(R.drawable.veigar);
											break;     			
										case 102: middle.setImageResource(R.drawable.velkoz);
											break;     			
										case 103: middle.setImageResource(R.drawable.vi);
											break;     			
										case 104: middle.setImageResource(R.drawable.viktor);
											break;     			
										case 105: middle.setImageResource(R.drawable.vladimir);
											break;     			
										case 106: middle.setImageResource(R.drawable.volibear);
											break;     			
										case 107: middle.setImageResource(R.drawable.warwick);
											break;     			
										case 108: middle.setImageResource(R.drawable.wukong);
											break;     			
										case 109: middle.setImageResource(R.drawable.xerath);
											break;     			
										case 110: middle.setImageResource(R.drawable.xinzhao);
											break;     			
										case 111: middle.setImageResource(R.drawable.yasuo);
											break;     			
										case 112: middle.setImageResource(R.drawable.yorick);
											break;     			
										case 113: middle.setImageResource(R.drawable.zac);
											break;     			
										case 114: middle.setImageResource(R.drawable.zed);
											break;     			
										case 115: middle.setImageResource(R.drawable.ziggs);
											break;     			
										case 116: middle.setImageResource(R.drawable.zilean);
											break;     			
										case 117: middle.setImageResource(R.drawable.zyra);
											break;     							
										default: 
											break;
										}

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[2] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}
				
				// suggested ADCs
				ChampionAttributes[] suggestedADC = teambuilder.suggestChampionsByStrategy(3);
				if ((suggestedADC != null) && (buttonChangedFlags[3] == 0)){
					for (int i = 0; i < suggestedADC.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilder.this), suggestedADC[i]);
						if (suggestedADC[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						scroll4.addView(newButton);
						final ChampionAttributes currentChampion = suggestedADC[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[3] == 1){
									teambuilder.setOurTeam(3, currentChampion);
							    	String message = currentChampion.getName();
							    	int i;
							    	
							    	if(message.equals("Aatrox")){
							            i = 0;
									}else if(message.equals("Ahri")){
							            i = 1;
							    	}else if(message.equals("Akali")){
							            i = 2;
							    	}else if(message.equals("Alistar")){
							    		i = 3;
							    	}else if(message.equals("Amumu")){
							    		i = 4;
							    	}else if(message.equals("Anivia")){
							    		i = 5;
							    	}else if(message.equals("Annie")){
							    		i = 6;
							    	}else if(message.equals("Ashe")){
							            i = 7;
							    	}else if(message.equals("Blitzcrank")){
							            i = 8;
							    	}else if(message.equals("Brand")){
							            i = 9;
							    	}else if(message.equals("Caitlyn")){
							    		i = 10;
							    	}else if(message.equals("Cassiopeia")){
							    		i = 11;
							    	}else if(message.equals("Cho Gath")){
							    		i = 12;
							    	}else if(message.equals("Corki")){
							    		i = 13;
							    	}else if(message.equals("Darius")){
							    		i = 14;
							    	}else if(message.equals("Diana")){
							    		i = 15;
							    	}else if(message.equals("Dr. Mundo")){
							    		i = 16;
							    	}else if(message.equals("Draven")){
							    		i = 17;
							    	}else if(message.equals("Elise")){
							    		i = 18;
							    	}else if(message.equals("Evelynn")){
							    		i = 19;
							    	}else if(message.equals("Ezreal")){
							    		i = 20;
							    	}else if(message.equals("Fiddlesticks")){
							    		i = 21;
							    	}else if(message.equals("Fiora")){
							    		i = 22;
							    	}else if(message.equals("Fizz")){
							    		i = 23;
							    	}else if(message.equals("Galio")){
							    		i = 24;
							    	}else if(message.equals("Gangplank")){
							    		i = 25;
							    	}else if(message.equals("Garen")){
							    		i = 26;
							    	}else if(message.equals("Gragas")){
							    		i = 27;
							    	}else if(message.equals("Graves")){
							    		i = 28;
							    	}else if(message.equals("Hecarim")){
							    		i = 29;
							    	}else if(message.equals("Heimerdinger")){
							    		i = 30;
							    	}else if(message.equals("Irelia")){
							    		i = 31;
							    	}else if(message.equals("Janna")){
							    		i = 32;
							    	}else if(message.equals("Jarvan IV")){
							    		i = 33;
							    	}else if(message.equals("Jax")){
							    		i = 34;
							    	}else if(message.equals("Jayce")){
							    		i = 35;
							    	}else if(message.equals("Jinx")){
							    		i = 36;
							    	}else if(message.equals("Karma")){
							    		i = 37;
							    	}else if(message.equals("Karthus")){
							    		i = 38;
							    	}else if(message.equals("Kassadin")){
							    		i = 39;
							    	}else if(message.equals("Katarina")){
							    		i = 40;
							    	}else if(message.equals("Kayle")){
							    		i = 41;
							    	}else if(message.equals("Kennen")){
							    		i = 42;
							    	}else if(message.equals("Kha Zix")){
							    		i = 43;
							    	}else if(message.equals("Kog Maw")){
							    		i = 44;
							    	}else if(message.equals("LeBlanc")){
							    		i = 45;
							    	}else if(message.equals("Lee Sin")){
							    		i = 46;
							    	}else if(message.equals("Leona")){
							    		i = 47;
							    	}else if(message.equals("Lissandra")){
							    		i = 48;
							    	}else if(message.equals("Lucian")){
							    		i = 49;
							    	}else if(message.equals("Lulu")){
							    		i = 50;
							    	}else if(message.equals("Lux")){
							    		i = 51;
							    	}else if(message.equals("Malphite")){
							    		i = 52;
							    	}else if(message.equals("Malzahar")){
							    		i = 53;
							    	}else if(message.equals("Maokai")){
							    		i = 54;
							    	}else if(message.equals("Master Yi")){
							    		i = 55;
							    	}else if(message.equals("Miss Fortune")){
							    		i = 56;
							    	}else if(message.equals("Mordekaiser")){
							    		i = 57;
							    	}else if(message.equals("Morgana")){
							    		i = 58;
							    	}else if(message.equals("Nami")){
							    		i = 59;
							    	}else if(message.equals("Nasus")){
							    		i = 60;
							    	}else if(message.equals("Nautilus")){
							    		i = 61;
							    	}else if(message.equals("Nidalee")){
							    		i = 62;
							    	}else if(message.equals("Nocturne")){
							    		i = 63;
							    	}else if(message.equals("Nunu")){
							    		i = 64;
							    	}else if(message.equals("Olaf")){
							    		i = 65;
							    	}else if(message.equals("Orianna")){
							    		i = 66;
							    	}else if(message.equals("Pantheon")){
							    		i = 67;
							    	}else if(message.equals("Poppy")){
							    		i = 68;
							    	}else if(message.equals("Quinn")){
							    		i = 69;
							    	}else if(message.equals("Rammus")){
							    		i = 70;
							    	}else if(message.equals("Renekton")){
							    		i = 71;
							    	}else if(message.equals("Rengar")){
							    		i = 72;
							    	}else if(message.equals("Riven")){
							    		i = 73;
							    	}else if(message.equals("Rumble")){
							    		i = 74;
							    	}else if(message.equals("Ryze")){
							    		i = 75;
							    	}else if(message.equals("Sejuani")){
							    		i = 76;
							    	}else if(message.equals("Shaco")){
							    		i = 77;
							    	}else if(message.equals("Shen")){
							    		i = 78;
							    	}else if(message.equals("Shyvana")){
							    		i = 79;
							    	}else if(message.equals("Singed")){
							    		i = 80;
							    	}else if(message.equals("Sion")){
							    		i = 81;
							    	}else if(message.equals("Sivir")){
							    		i = 82;
							    	}else if(message.equals("Skarner")){
							    		i = 83;
							    	}else if(message.equals("Sona")){
							    		i = 84;
							    	}else if(message.equals("Soraka")){
							    		i = 85;
							    	}else if(message.equals("Swain")){
							    		i = 86;
							    	}else if(message.equals("Syndra")){
							    		i = 87;
							    	}else if(message.equals("Talon")){
							    		i = 88;
							    	}else if(message.equals("Taric")){
							    		i = 89;
							    	}else if(message.equals("Teemo")){
							    		i = 90;
							    	}else if(message.equals("Thresh")){
							    		i = 91;
							    	}else if(message.equals("Tristana")){
							    		i = 92;
							    	}else if(message.equals("Trundle")){
							    		i = 93;
							    	}else if(message.equals("Tryndamere")){
							    		i = 94;
							    	}else if(message.equals("Twisted Fate")){
							    		i = 95;
							    	}else if(message.equals("Twitch")){
							    		i = 96;
							    	}else if(message.equals("Udyr")){
							    		i = 97;
							    	}else if(message.equals("Urgot")){
							    		i = 98;
							    	}else if(message.equals("Varus")){
							    		i = 99;
							    	}else if(message.equals("Vayne")){
							    		i = 100;
							    	}else if(message.equals("Veigar")){
							    		i = 101;
							    	}else if(message.equals("Vel Koz")){
							    		i = 102;
							    	}else if(message.equals("Vi")){
							    		i = 103;
							    	}else if(message.equals("Viktor")){
							    		i = 104;
							    	}else if(message.equals("Vladimir")){
							    		i = 105;
							    	}else if(message.equals("Volibear")){
							    		i = 106;
							    	}else if(message.equals("Warwick")){
							    		i = 107;
							    	}else if(message.equals("Wukong")){
							    		i = 108;
							    	}else if(message.equals("Xerath")){
							    		i = 109;
							    	}else if(message.equals("Xin Zhao")){
							    		i = 110;
							    	}else if(message.equals("Yasuo")){
							    		i = 111;
							    	}else if(message.equals("Yorick")){
							    		i = 112;
							    	}else if(message.equals("Zac")){
							    		i = 113;
							    	}else if(message.equals("Zed")){
							    		i = 114;
							    	}else if(message.equals("Ziggs")){
							    		i = 115;
							    	}else if(message.equals("Zilean")){
							    		i = 116;
							    	}else{
							    		i=117;
							    	}

									switch(i){
										case 0: adc.setImageResource(R.drawable.aatrox);
											break;
										case 1: adc.setImageResource(R.drawable.ahri);
											break;
										case 2: adc.setImageResource(R.drawable.akali);
											break;
										case 3: adc.setImageResource(R.drawable.alistar);
											break;
										case 4: adc.setImageResource(R.drawable.amumu);
											break;
										case 5: adc.setImageResource(R.drawable.anivia);
											break;
										case 6: adc.setImageResource(R.drawable.annie);
											break;
										case 7: adc.setImageResource(R.drawable.ashe);
											break;
										case 8: adc.setImageResource(R.drawable.blitzcrank);
											break;
										case 9: adc.setImageResource(R.drawable.brand);
											break;
										case 10: adc.setImageResource(R.drawable.caitlyn);
											break;
										case 11: adc.setImageResource(R.drawable.cassiopeia);
											break;
										case 12: adc.setImageResource(R.drawable.chogath);
											break;
										case 13: adc.setImageResource(R.drawable.corki);
											break;
										case 14: adc.setImageResource(R.drawable.darius);
											break;						
										case 15: adc.setImageResource(R.drawable.diana);
											break;						
										case 16: adc.setImageResource(R.drawable.drmundo);
											break;						
										case 17: adc.setImageResource(R.drawable.draven);
											break;						
										case 18: adc.setImageResource(R.drawable.elise);
											break;						
										case 19: adc.setImageResource(R.drawable.evelynn);
											break;						
										case 20: adc.setImageResource(R.drawable.ezreal);
											break;						
										case 21: adc.setImageResource(R.drawable.fiddlesticks);
											break;						
										case 22: adc.setImageResource(R.drawable.fiora);
											break;						
										case 23: adc.setImageResource(R.drawable.fizz);
											break;						
										case 24: adc.setImageResource(R.drawable.galio);
											break;						
										case 25: adc.setImageResource(R.drawable.gangplank);
											break;						
										case 26: adc.setImageResource(R.drawable.garen);
											break;						
										case 27: adc.setImageResource(R.drawable.gragas);
											break;						
										case 28: adc.setImageResource(R.drawable.graves);
											break;						
										case 29: adc.setImageResource(R.drawable.hecarim);
											break;						
										case 30: adc.setImageResource(R.drawable.heimerdinger);
											break;						
										case 31: adc.setImageResource(R.drawable.irelia);
											break;						
										case 32: adc.setImageResource(R.drawable.janna);
											break;						
										case 33: adc.setImageResource(R.drawable.jarvaniv);
											break;						
										case 34: adc.setImageResource(R.drawable.jax);
											break;						
										case 35: adc.setImageResource(R.drawable.jayce);
											break;						
										case 36: adc.setImageResource(R.drawable.jinx);
											break;						
										case 37: adc.setImageResource(R.drawable.karma);
											break;
										case 38: adc.setImageResource(R.drawable.karthus);
											break;
										case 39: adc.setImageResource(R.drawable.kassadin);
											break;     	
										case 40: adc.setImageResource(R.drawable.katarina);
											break;     	
										case 41: adc.setImageResource(R.drawable.kayle);
											break;     	
										case 42: adc.setImageResource(R.drawable.kennen);
											break;     	
										case 43: adc.setImageResource(R.drawable.khazix);
											break;     	
										case 44: adc.setImageResource(R.drawable.kogmaw);
											break;     	
										case 45: adc.setImageResource(R.drawable.leblanc);
											break;     	
										case 46: adc.setImageResource(R.drawable.leesin);
											break;     	
										case 47: adc.setImageResource(R.drawable.leona);
											break;     	
										case 48: adc.setImageResource(R.drawable.lissandra);
											break;     	
										case 49: adc.setImageResource(R.drawable.lucian);
											break;     	
										case 50: adc.setImageResource(R.drawable.lulu);
											break;     	
										case 51: adc.setImageResource(R.drawable.lux);
											break;     	
										case 52: adc.setImageResource(R.drawable.malphite);
											break;     	
										case 53: adc.setImageResource(R.drawable.malzahar);
											break;     	
										case 54: adc.setImageResource(R.drawable.maokai);
											break;     	
										case 55: adc.setImageResource(R.drawable.masteryi);
											break;     	
										case 56: adc.setImageResource(R.drawable.missfortune);
											break;     	
										case 57: adc.setImageResource(R.drawable.mordekaiser);
											break;     	
										case 58: adc.setImageResource(R.drawable.morgana);
											break;     	
										case 59: adc.setImageResource(R.drawable.nami);
											break;     	
										case 60: adc.setImageResource(R.drawable.nasus);
											break;     	
										case 61: adc.setImageResource(R.drawable.nautilus);
											break;     	
										case 62: adc.setImageResource(R.drawable.nidalee);
											break;     	
										case 63: adc.setImageResource(R.drawable.nocturne);
											break;     	
										case 64: adc.setImageResource(R.drawable.nunu);
											break;     	
										case 65: adc.setImageResource(R.drawable.olaf);
											break;     	
										case 66: adc.setImageResource(R.drawable.orianna);
											break;     	
										case 67: adc.setImageResource(R.drawable.pantheon);
											break;     	
										case 68: adc.setImageResource(R.drawable.poppy);
											break;     	
										case 69: adc.setImageResource(R.drawable.quinn);
											break;     	
										case 70: adc.setImageResource(R.drawable.rammus);
											break;     	
										case 71: adc.setImageResource(R.drawable.renekton);
											break;     	
										case 72: adc.setImageResource(R.drawable.rengar);
											break;     	
										case 73: adc.setImageResource(R.drawable.riven);
											break;     	
										case 74: adc.setImageResource(R.drawable.rumble);
											break;     	
										case 75: adc.setImageResource(R.drawable.ryze);
											break;     	
										case 76: adc.setImageResource(R.drawable.sejuani);
											break;     	
										case 77: adc.setImageResource(R.drawable.shaco);
											break; 		
										case 78: adc.setImageResource(R.drawable.shen);
											break;     			
										case 79: adc.setImageResource(R.drawable.shyvana);
											break;     			
										case 80: adc.setImageResource(R.drawable.singed);
											break;     			
										case 81: adc.setImageResource(R.drawable.sion);
											break;     			
										case 82: adc.setImageResource(R.drawable.sivir);
											break;     			
										case 83: adc.setImageResource(R.drawable.skarner);
											break;     			
										case 84: adc.setImageResource(R.drawable.sona);
											break;     			
										case 85: adc.setImageResource(R.drawable.soraka);
											break;     			
										case 86: adc.setImageResource(R.drawable.swain);
											break;     			
										case 87: adc.setImageResource(R.drawable.syndra);
											break;     			
										case 88: adc.setImageResource(R.drawable.talon);
											break;     			
										case 89: adc.setImageResource(R.drawable.taric);
											break;     			
										case 90: adc.setImageResource(R.drawable.teemo);
											break;     			
										case 91: adc.setImageResource(R.drawable.thresh);
											break;     			
										case 92: adc.setImageResource(R.drawable.tristana);
											break;     			
										case 93: adc.setImageResource(R.drawable.trundle);
											break;     			
										case 94: adc.setImageResource(R.drawable.tryndamere);
											break;     			
										case 95: adc.setImageResource(R.drawable.twistedfate);
											break;     			
										case 96: adc.setImageResource(R.drawable.twitch);
											break;     			
										case 97: adc.setImageResource(R.drawable.udyr);
											break;     			
										case 98: adc.setImageResource(R.drawable.urgot);
											break;     			
										case 99: adc.setImageResource(R.drawable.varus);
											break;     			
										case 100: adc.setImageResource(R.drawable.vayne);
											break;     			
										case 101: adc.setImageResource(R.drawable.veigar);
											break;     			
										case 102: adc.setImageResource(R.drawable.velkoz);
											break;     			
										case 103: adc.setImageResource(R.drawable.vi);
											break;     			
										case 104: adc.setImageResource(R.drawable.viktor);
											break;     			
										case 105: adc.setImageResource(R.drawable.vladimir);
											break;     			
										case 106: adc.setImageResource(R.drawable.volibear);
											break;     			
										case 107: adc.setImageResource(R.drawable.warwick);
											break;     			
										case 108: adc.setImageResource(R.drawable.wukong);
											break;     			
										case 109: adc.setImageResource(R.drawable.xerath);
											break;     			
										case 110: adc.setImageResource(R.drawable.xinzhao);
											break;     			
										case 111: adc.setImageResource(R.drawable.yasuo);
											break;     			
										case 112: adc.setImageResource(R.drawable.yorick);
											break;     			
										case 113: adc.setImageResource(R.drawable.zac);
											break;     			
										case 114: adc.setImageResource(R.drawable.zed);
											break;     			
										case 115: adc.setImageResource(R.drawable.ziggs);
											break;     			
										case 116: adc.setImageResource(R.drawable.zilean);
											break;     			
										case 117: adc.setImageResource(R.drawable.zyra);
											break;     							
										default: 
											break;
										}

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[3] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}
				
				// suggested support champions
				ChampionAttributes[] suggestedSupport = teambuilder.suggestChampionsByStrategy(4);
				if ((suggestedSupport != null) && (buttonChangedFlags[4] == 0)){
					for (int i = 0; i < suggestedSupport.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilder.this), suggestedSupport[i]);
						if (suggestedSupport[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						scroll5.addView(newButton);
						final ChampionAttributes currentChampion = suggestedSupport[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[4] == 1){
									teambuilder.setOurTeam(4, currentChampion);
							    	String message = currentChampion.getName();
							    	int i;
							    	
							    	if(message.equals("Aatrox")){
							            i = 0;
									}else if(message.equals("Ahri")){
							            i = 1;
							    	}else if(message.equals("Akali")){
							            i = 2;
							    	}else if(message.equals("Alistar")){
							    		i = 3;
							    	}else if(message.equals("Amumu")){
							    		i = 4;
							    	}else if(message.equals("Anivia")){
							    		i = 5;
							    	}else if(message.equals("Annie")){
							    		i = 6;
							    	}else if(message.equals("Ashe")){
							            i = 7;
							    	}else if(message.equals("Blitzcrank")){
							            i = 8;
							    	}else if(message.equals("Brand")){
							            i = 9;
							    	}else if(message.equals("Caitlyn")){
							    		i = 10;
							    	}else if(message.equals("Cassiopeia")){
							    		i = 11;
							    	}else if(message.equals("Cho Gath")){
							    		i = 12;
							    	}else if(message.equals("Corki")){
							    		i = 13;
							    	}else if(message.equals("Darius")){
							    		i = 14;
							    	}else if(message.equals("Diana")){
							    		i = 15;
							    	}else if(message.equals("Dr. Mundo")){
							    		i = 16;
							    	}else if(message.equals("Draven")){
							    		i = 17;
							    	}else if(message.equals("Elise")){
							    		i = 18;
							    	}else if(message.equals("Evelynn")){
							    		i = 19;
							    	}else if(message.equals("Ezreal")){
							    		i = 20;
							    	}else if(message.equals("Fiddlesticks")){
							    		i = 21;
							    	}else if(message.equals("Fiora")){
							    		i = 22;
							    	}else if(message.equals("Fizz")){
							    		i = 23;
							    	}else if(message.equals("Galio")){
							    		i = 24;
							    	}else if(message.equals("Gangplank")){
							    		i = 25;
							    	}else if(message.equals("Garen")){
							    		i = 26;
							    	}else if(message.equals("Gragas")){
							    		i = 27;
							    	}else if(message.equals("Graves")){
							    		i = 28;
							    	}else if(message.equals("Hecarim")){
							    		i = 29;
							    	}else if(message.equals("Heimerdinger")){
							    		i = 30;
							    	}else if(message.equals("Irelia")){
							    		i = 31;
							    	}else if(message.equals("Janna")){
							    		i = 32;
							    	}else if(message.equals("Jarvan IV")){
							    		i = 33;
							    	}else if(message.equals("Jax")){
							    		i = 34;
							    	}else if(message.equals("Jayce")){
							    		i = 35;
							    	}else if(message.equals("Jinx")){
							    		i = 36;
							    	}else if(message.equals("Karma")){
							    		i = 37;
							    	}else if(message.equals("Karthus")){
							    		i = 38;
							    	}else if(message.equals("Kassadin")){
							    		i = 39;
							    	}else if(message.equals("Katarina")){
							    		i = 40;
							    	}else if(message.equals("Kayle")){
							    		i = 41;
							    	}else if(message.equals("Kennen")){
							    		i = 42;
							    	}else if(message.equals("Kha Zix")){
							    		i = 43;
							    	}else if(message.equals("Kog Maw")){
							    		i = 44;
							    	}else if(message.equals("LeBlanc")){
							    		i = 45;
							    	}else if(message.equals("Lee Sin")){
							    		i = 46;
							    	}else if(message.equals("Leona")){
							    		i = 47;
							    	}else if(message.equals("Lissandra")){
							    		i = 48;
							    	}else if(message.equals("Lucian")){
							    		i = 49;
							    	}else if(message.equals("Lulu")){
							    		i = 50;
							    	}else if(message.equals("Lux")){
							    		i = 51;
							    	}else if(message.equals("Malphite")){
							    		i = 52;
							    	}else if(message.equals("Malzahar")){
							    		i = 53;
							    	}else if(message.equals("Maokai")){
							    		i = 54;
							    	}else if(message.equals("Master Yi")){
							    		i = 55;
							    	}else if(message.equals("Miss Fortune")){
							    		i = 56;
							    	}else if(message.equals("Mordekaiser")){
							    		i = 57;
							    	}else if(message.equals("Morgana")){
							    		i = 58;
							    	}else if(message.equals("Nami")){
							    		i = 59;
							    	}else if(message.equals("Nasus")){
							    		i = 60;
							    	}else if(message.equals("Nautilus")){
							    		i = 61;
							    	}else if(message.equals("Nidalee")){
							    		i = 62;
							    	}else if(message.equals("Nocturne")){
							    		i = 63;
							    	}else if(message.equals("Nunu")){
							    		i = 64;
							    	}else if(message.equals("Olaf")){
							    		i = 65;
							    	}else if(message.equals("Orianna")){
							    		i = 66;
							    	}else if(message.equals("Pantheon")){
							    		i = 67;
							    	}else if(message.equals("Poppy")){
							    		i = 68;
							    	}else if(message.equals("Quinn")){
							    		i = 69;
							    	}else if(message.equals("Rammus")){
							    		i = 70;
							    	}else if(message.equals("Renekton")){
							    		i = 71;
							    	}else if(message.equals("Rengar")){
							    		i = 72;
							    	}else if(message.equals("Riven")){
							    		i = 73;
							    	}else if(message.equals("Rumble")){
							    		i = 74;
							    	}else if(message.equals("Ryze")){
							    		i = 75;
							    	}else if(message.equals("Sejuani")){
							    		i = 76;
							    	}else if(message.equals("Shaco")){
							    		i = 77;
							    	}else if(message.equals("Shen")){
							    		i = 78;
							    	}else if(message.equals("Shyvana")){
							    		i = 79;
							    	}else if(message.equals("Singed")){
							    		i = 80;
							    	}else if(message.equals("Sion")){
							    		i = 81;
							    	}else if(message.equals("Sivir")){
							    		i = 82;
							    	}else if(message.equals("Skarner")){
							    		i = 83;
							    	}else if(message.equals("Sona")){
							    		i = 84;
							    	}else if(message.equals("Soraka")){
							    		i = 85;
							    	}else if(message.equals("Swain")){
							    		i = 86;
							    	}else if(message.equals("Syndra")){
							    		i = 87;
							    	}else if(message.equals("Talon")){
							    		i = 88;
							    	}else if(message.equals("Taric")){
							    		i = 89;
							    	}else if(message.equals("Teemo")){
							    		i = 90;
							    	}else if(message.equals("Thresh")){
							    		i = 91;
							    	}else if(message.equals("Tristana")){
							    		i = 92;
							    	}else if(message.equals("Trundle")){
							    		i = 93;
							    	}else if(message.equals("Tryndamere")){
							    		i = 94;
							    	}else if(message.equals("Twisted Fate")){
							    		i = 95;
							    	}else if(message.equals("Twitch")){
							    		i = 96;
							    	}else if(message.equals("Udyr")){
							    		i = 97;
							    	}else if(message.equals("Urgot")){
							    		i = 98;
							    	}else if(message.equals("Varus")){
							    		i = 99;
							    	}else if(message.equals("Vayne")){
							    		i = 100;
							    	}else if(message.equals("Veigar")){
							    		i = 101;
							    	}else if(message.equals("Vel Koz")){
							    		i = 102;
							    	}else if(message.equals("Vi")){
							    		i = 103;
							    	}else if(message.equals("Viktor")){
							    		i = 104;
							    	}else if(message.equals("Vladimir")){
							    		i = 105;
							    	}else if(message.equals("Volibear")){
							    		i = 106;
							    	}else if(message.equals("Warwick")){
							    		i = 107;
							    	}else if(message.equals("Wukong")){
							    		i = 108;
							    	}else if(message.equals("Xerath")){
							    		i = 109;
							    	}else if(message.equals("Xin Zhao")){
							    		i = 110;
							    	}else if(message.equals("Yasuo")){
							    		i = 111;
							    	}else if(message.equals("Yorick")){
							    		i = 112;
							    	}else if(message.equals("Zac")){
							    		i = 113;
							    	}else if(message.equals("Zed")){
							    		i = 114;
							    	}else if(message.equals("Ziggs")){
							    		i = 115;
							    	}else if(message.equals("Zilean")){
							    		i = 116;
							    	}else{
							    		i=117;
							    	}

									switch(i){
										case 0: support.setImageResource(R.drawable.aatrox);
											break;
										case 1: support.setImageResource(R.drawable.ahri);
											break;
										case 2: support.setImageResource(R.drawable.akali);
											break;
										case 3: support.setImageResource(R.drawable.alistar);
											break;
										case 4: support.setImageResource(R.drawable.amumu);
											break;
										case 5: support.setImageResource(R.drawable.anivia);
											break;
										case 6: support.setImageResource(R.drawable.annie);
											break;
										case 7: support.setImageResource(R.drawable.ashe);
											break;
										case 8: support.setImageResource(R.drawable.blitzcrank);
											break;
										case 9: support.setImageResource(R.drawable.brand);
											break;
										case 10: support.setImageResource(R.drawable.caitlyn);
											break;
										case 11: support.setImageResource(R.drawable.cassiopeia);
											break;
										case 12: support.setImageResource(R.drawable.chogath);
											break;
										case 13: support.setImageResource(R.drawable.corki);
											break;
										case 14: support.setImageResource(R.drawable.darius);
											break;						
										case 15: support.setImageResource(R.drawable.diana);
											break;						
										case 16: support.setImageResource(R.drawable.drmundo);
											break;						
										case 17: support.setImageResource(R.drawable.draven);
											break;						
										case 18: support.setImageResource(R.drawable.elise);
											break;						
										case 19: support.setImageResource(R.drawable.evelynn);
											break;						
										case 20: support.setImageResource(R.drawable.ezreal);
											break;						
										case 21: support.setImageResource(R.drawable.fiddlesticks);
											break;						
										case 22: support.setImageResource(R.drawable.fiora);
											break;						
										case 23: support.setImageResource(R.drawable.fizz);
											break;						
										case 24: support.setImageResource(R.drawable.galio);
											break;						
										case 25: support.setImageResource(R.drawable.gangplank);
											break;						
										case 26: support.setImageResource(R.drawable.garen);
											break;						
										case 27: support.setImageResource(R.drawable.gragas);
											break;						
										case 28: support.setImageResource(R.drawable.graves);
											break;						
										case 29: support.setImageResource(R.drawable.hecarim);
											break;						
										case 30: support.setImageResource(R.drawable.heimerdinger);
											break;						
										case 31: support.setImageResource(R.drawable.irelia);
											break;						
										case 32: support.setImageResource(R.drawable.janna);
											break;						
										case 33: support.setImageResource(R.drawable.jarvaniv);
											break;						
										case 34: support.setImageResource(R.drawable.jax);
											break;						
										case 35: support.setImageResource(R.drawable.jayce);
											break;						
										case 36: support.setImageResource(R.drawable.jinx);
											break;						
										case 37: support.setImageResource(R.drawable.karma);
											break;
										case 38: support.setImageResource(R.drawable.karthus);
											break;
										case 39: support.setImageResource(R.drawable.kassadin);
											break;     	
										case 40: support.setImageResource(R.drawable.katarina);
											break;     	
										case 41: support.setImageResource(R.drawable.kayle);
											break;     	
										case 42: support.setImageResource(R.drawable.kennen);
											break;     	
										case 43: support.setImageResource(R.drawable.khazix);
											break;     	
										case 44: support.setImageResource(R.drawable.kogmaw);
											break;     	
										case 45: support.setImageResource(R.drawable.leblanc);
											break;     	
										case 46: support.setImageResource(R.drawable.leesin);
											break;     	
										case 47: support.setImageResource(R.drawable.leona);
											break;     	
										case 48: support.setImageResource(R.drawable.lissandra);
											break;     	
										case 49: support.setImageResource(R.drawable.lucian);
											break;     	
										case 50: support.setImageResource(R.drawable.lulu);
											break;     	
										case 51: support.setImageResource(R.drawable.lux);
											break;     	
										case 52: support.setImageResource(R.drawable.malphite);
											break;     	
										case 53: support.setImageResource(R.drawable.malzahar);
											break;     	
										case 54: support.setImageResource(R.drawable.maokai);
											break;     	
										case 55: support.setImageResource(R.drawable.masteryi);
											break;     	
										case 56: support.setImageResource(R.drawable.missfortune);
											break;     	
										case 57: support.setImageResource(R.drawable.mordekaiser);
											break;     	
										case 58: support.setImageResource(R.drawable.morgana);
											break;     	
										case 59: support.setImageResource(R.drawable.nami);
											break;     	
										case 60: support.setImageResource(R.drawable.nasus);
											break;     	
										case 61: support.setImageResource(R.drawable.nautilus);
											break;     	
										case 62: support.setImageResource(R.drawable.nidalee);
											break;     	
										case 63: support.setImageResource(R.drawable.nocturne);
											break;     	
										case 64: support.setImageResource(R.drawable.nunu);
											break;     	
										case 65: support.setImageResource(R.drawable.olaf);
											break;     	
										case 66: support.setImageResource(R.drawable.orianna);
											break;     	
										case 67: support.setImageResource(R.drawable.pantheon);
											break;     	
										case 68: support.setImageResource(R.drawable.poppy);
											break;     	
										case 69: support.setImageResource(R.drawable.quinn);
											break;     	
										case 70: support.setImageResource(R.drawable.rammus);
											break;     	
										case 71: support.setImageResource(R.drawable.renekton);
											break;     	
										case 72: support.setImageResource(R.drawable.rengar);
											break;     	
										case 73: support.setImageResource(R.drawable.riven);
											break;     	
										case 74: support.setImageResource(R.drawable.rumble);
											break;     	
										case 75: support.setImageResource(R.drawable.ryze);
											break;     	
										case 76: support.setImageResource(R.drawable.sejuani);
											break;     	
										case 77: support.setImageResource(R.drawable.shaco);
											break; 		
										case 78: support.setImageResource(R.drawable.shen);
											break;     			
										case 79: support.setImageResource(R.drawable.shyvana);
											break;     			
										case 80: support.setImageResource(R.drawable.singed);
											break;     			
										case 81: support.setImageResource(R.drawable.sion);
											break;     			
										case 82: support.setImageResource(R.drawable.sivir);
											break;     			
										case 83: support.setImageResource(R.drawable.skarner);
											break;     			
										case 84: support.setImageResource(R.drawable.sona);
											break;     			
										case 85: support.setImageResource(R.drawable.soraka);
											break;     			
										case 86: support.setImageResource(R.drawable.swain);
											break;     			
										case 87: support.setImageResource(R.drawable.syndra);
											break;     			
										case 88: support.setImageResource(R.drawable.talon);
											break;     			
										case 89: support.setImageResource(R.drawable.taric);
											break;     			
										case 90: support.setImageResource(R.drawable.teemo);
											break;     			
										case 91: support.setImageResource(R.drawable.thresh);
											break;     			
										case 92: support.setImageResource(R.drawable.tristana);
											break;     			
										case 93: support.setImageResource(R.drawable.trundle);
											break;     			
										case 94: support.setImageResource(R.drawable.tryndamere);
											break;     			
										case 95: support.setImageResource(R.drawable.twistedfate);
											break;     			
										case 96: support.setImageResource(R.drawable.twitch);
											break;     			
										case 97: support.setImageResource(R.drawable.udyr);
											break;     			
										case 98: support.setImageResource(R.drawable.urgot);
											break;     			
										case 99: support.setImageResource(R.drawable.varus);
											break;     			
										case 100: support.setImageResource(R.drawable.vayne);
											break;     			
										case 101: support.setImageResource(R.drawable.veigar);
											break;     			
										case 102: support.setImageResource(R.drawable.velkoz);
											break;     			
										case 103: support.setImageResource(R.drawable.vi);
											break;     			
										case 104: support.setImageResource(R.drawable.viktor);
											break;     			
										case 105: support.setImageResource(R.drawable.vladimir);
											break;     			
										case 106: support.setImageResource(R.drawable.volibear);
											break;     			
										case 107: support.setImageResource(R.drawable.warwick);
											break;     			
										case 108: support.setImageResource(R.drawable.wukong);
											break;     			
										case 109: support.setImageResource(R.drawable.xerath);
											break;     			
										case 110: support.setImageResource(R.drawable.xinzhao);
											break;     			
										case 111: support.setImageResource(R.drawable.yasuo);
											break;     			
										case 112: support.setImageResource(R.drawable.yorick);
											break;     			
										case 113: support.setImageResource(R.drawable.zac);
											break;     			
										case 114: support.setImageResource(R.drawable.zed);
											break;     			
										case 115: support.setImageResource(R.drawable.ziggs);
											break;     			
										case 116: support.setImageResource(R.drawable.zilean);
											break;     			
										case 117: support.setImageResource(R.drawable.zyra);
											break;     							
										default: 
											break;
										}

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[4] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}
				
				// Table to display all available champions
				table.removeAllViews();
				int buttonInRow = 5;
				TableRow currentRow = null;
				ChampionAttributes[] allAvailableChampions = teambuilder.getAllAvailableChampions();
				for (int i = 0; i < allAvailableChampions.length; i++){
					if (buttonInRow == 5){
						buttonInRow = 0;
						TableRow newRow = new TableRow(TeamBuilder.this);
						newRow.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 60));
						table.addView(newRow);
						currentRow = newRow;
					}
					final ImageButton newButton = initializeButton(new ImageButton(TeamBuilder.this), allAvailableChampions[i]);
					if (allAvailableChampions[i].getName().equals("NONAME")){
						newButton.setVisibility(View.GONE);
					}
					else{
						buttonInRow += 1;
					}
					currentRow.addView(newButton);
					
					final ChampionAttributes currentChampion = allAvailableChampions[i];
					newButton.setOnClickListener(new View.OnClickListener(){
						@Override
				        public void onClick(View v){
							if (buttonPressFlags[0] == 1){
								teambuilder.setOurTeam(0, currentChampion);
								buttonChangedFlags[0] = 1;
						    	String message = currentChampion.getName();
						    	int i;
						    	
						    	if(message.equals("Aatrox")){
						            i = 0;
								}else if(message.equals("Ahri")){
						            i = 1;
						    	}else if(message.equals("Akali")){
						            i = 2;
						    	}else if(message.equals("Alistar")){
						    		i = 3;
						    	}else if(message.equals("Amumu")){
						    		i = 4;
						    	}else if(message.equals("Anivia")){
						    		i = 5;
						    	}else if(message.equals("Annie")){
						    		i = 6;
						    	}else if(message.equals("Ashe")){
						            i = 7;
						    	}else if(message.equals("Blitzcrank")){
						            i = 8;
						    	}else if(message.equals("Brand")){
						            i = 9;
						    	}else if(message.equals("Caitlyn")){
						    		i = 10;
						    	}else if(message.equals("Cassiopeia")){
						    		i = 11;
						    	}else if(message.equals("Cho Gath")){
						    		i = 12;
						    	}else if(message.equals("Corki")){
						    		i = 13;
						    	}else if(message.equals("Darius")){
						    		i = 14;
						    	}else if(message.equals("Diana")){
						    		i = 15;
						    	}else if(message.equals("Dr. Mundo")){
						    		i = 16;
						    	}else if(message.equals("Draven")){
						    		i = 17;
						    	}else if(message.equals("Elise")){
						    		i = 18;
						    	}else if(message.equals("Evelynn")){
						    		i = 19;
						    	}else if(message.equals("Ezreal")){
						    		i = 20;
						    	}else if(message.equals("Fiddlesticks")){
						    		i = 21;
						    	}else if(message.equals("Fiora")){
						    		i = 22;
						    	}else if(message.equals("Fizz")){
						    		i = 23;
						    	}else if(message.equals("Galio")){
						    		i = 24;
						    	}else if(message.equals("Gangplank")){
						    		i = 25;
						    	}else if(message.equals("Garen")){
						    		i = 26;
						    	}else if(message.equals("Gragas")){
						    		i = 27;
						    	}else if(message.equals("Graves")){
						    		i = 28;
						    	}else if(message.equals("Hecarim")){
						    		i = 29;
						    	}else if(message.equals("Heimerdinger")){
						    		i = 30;
						    	}else if(message.equals("Irelia")){
						    		i = 31;
						    	}else if(message.equals("Janna")){
						    		i = 32;
						    	}else if(message.equals("Jarvan IV")){
						    		i = 33;
						    	}else if(message.equals("Jax")){
						    		i = 34;
						    	}else if(message.equals("Jayce")){
						    		i = 35;
						    	}else if(message.equals("Jinx")){
						    		i = 36;
						    	}else if(message.equals("Karma")){
						    		i = 37;
						    	}else if(message.equals("Karthus")){
						    		i = 38;
						    	}else if(message.equals("Kassadin")){
						    		i = 39;
						    	}else if(message.equals("Katarina")){
						    		i = 40;
						    	}else if(message.equals("Kayle")){
						    		i = 41;
						    	}else if(message.equals("Kennen")){
						    		i = 42;
						    	}else if(message.equals("Kha Zix")){
						    		i = 43;
						    	}else if(message.equals("Kog Maw")){
						    		i = 44;
						    	}else if(message.equals("LeBlanc")){
						    		i = 45;
						    	}else if(message.equals("Lee Sin")){
						    		i = 46;
						    	}else if(message.equals("Leona")){
						    		i = 47;
						    	}else if(message.equals("Lissandra")){
						    		i = 48;
						    	}else if(message.equals("Lucian")){
						    		i = 49;
						    	}else if(message.equals("Lulu")){
						    		i = 50;
						    	}else if(message.equals("Lux")){
						    		i = 51;
						    	}else if(message.equals("Malphite")){
						    		i = 52;
						    	}else if(message.equals("Malzahar")){
						    		i = 53;
						    	}else if(message.equals("Maokai")){
						    		i = 54;
						    	}else if(message.equals("Master Yi")){
						    		i = 55;
						    	}else if(message.equals("Miss Fortune")){
						    		i = 56;
						    	}else if(message.equals("Mordekaiser")){
						    		i = 57;
						    	}else if(message.equals("Morgana")){
						    		i = 58;
						    	}else if(message.equals("Nami")){
						    		i = 59;
						    	}else if(message.equals("Nasus")){
						    		i = 60;
						    	}else if(message.equals("Nautilus")){
						    		i = 61;
						    	}else if(message.equals("Nidalee")){
						    		i = 62;
						    	}else if(message.equals("Nocturne")){
						    		i = 63;
						    	}else if(message.equals("Nunu")){
						    		i = 64;
						    	}else if(message.equals("Olaf")){
						    		i = 65;
						    	}else if(message.equals("Orianna")){
						    		i = 66;
						    	}else if(message.equals("Pantheon")){
						    		i = 67;
						    	}else if(message.equals("Poppy")){
						    		i = 68;
						    	}else if(message.equals("Quinn")){
						    		i = 69;
						    	}else if(message.equals("Rammus")){
						    		i = 70;
						    	}else if(message.equals("Renekton")){
						    		i = 71;
						    	}else if(message.equals("Rengar")){
						    		i = 72;
						    	}else if(message.equals("Riven")){
						    		i = 73;
						    	}else if(message.equals("Rumble")){
						    		i = 74;
						    	}else if(message.equals("Ryze")){
						    		i = 75;
						    	}else if(message.equals("Sejuani")){
						    		i = 76;
						    	}else if(message.equals("Shaco")){
						    		i = 77;
						    	}else if(message.equals("Shen")){
						    		i = 78;
						    	}else if(message.equals("Shyvana")){
						    		i = 79;
						    	}else if(message.equals("Singed")){
						    		i = 80;
						    	}else if(message.equals("Sion")){
						    		i = 81;
						    	}else if(message.equals("Sivir")){
						    		i = 82;
						    	}else if(message.equals("Skarner")){
						    		i = 83;
						    	}else if(message.equals("Sona")){
						    		i = 84;
						    	}else if(message.equals("Soraka")){
						    		i = 85;
						    	}else if(message.equals("Swain")){
						    		i = 86;
						    	}else if(message.equals("Syndra")){
						    		i = 87;
						    	}else if(message.equals("Talon")){
						    		i = 88;
						    	}else if(message.equals("Taric")){
						    		i = 89;
						    	}else if(message.equals("Teemo")){
						    		i = 90;
						    	}else if(message.equals("Thresh")){
						    		i = 91;
						    	}else if(message.equals("Tristana")){
						    		i = 92;
						    	}else if(message.equals("Trundle")){
						    		i = 93;
						    	}else if(message.equals("Tryndamere")){
						    		i = 94;
						    	}else if(message.equals("Twisted Fate")){
						    		i = 95;
						    	}else if(message.equals("Twitch")){
						    		i = 96;
						    	}else if(message.equals("Udyr")){
						    		i = 97;
						    	}else if(message.equals("Urgot")){
						    		i = 98;
						    	}else if(message.equals("Varus")){
						    		i = 99;
						    	}else if(message.equals("Vayne")){
						    		i = 100;
						    	}else if(message.equals("Veigar")){
						    		i = 101;
						    	}else if(message.equals("Vel Koz")){
						    		i = 102;
						    	}else if(message.equals("Vi")){
						    		i = 103;
						    	}else if(message.equals("Viktor")){
						    		i = 104;
						    	}else if(message.equals("Vladimir")){
						    		i = 105;
						    	}else if(message.equals("Volibear")){
						    		i = 106;
						    	}else if(message.equals("Warwick")){
						    		i = 107;
						    	}else if(message.equals("Wukong")){
						    		i = 108;
						    	}else if(message.equals("Xerath")){
						    		i = 109;
						    	}else if(message.equals("Xin Zhao")){
						    		i = 110;
						    	}else if(message.equals("Yasuo")){
						    		i = 111;
						    	}else if(message.equals("Yorick")){
						    		i = 112;
						    	}else if(message.equals("Zac")){
						    		i = 113;
						    	}else if(message.equals("Zed")){
						    		i = 114;
						    	}else if(message.equals("Ziggs")){
						    		i = 115;
						    	}else if(message.equals("Zilean")){
						    		i = 116;
						    	}else{
						    		i=117;
						    	}

								switch(i){
									case 0: top.setImageResource(R.drawable.aatrox);
										break;
									case 1: top.setImageResource(R.drawable.ahri);
										break;
									case 2: top.setImageResource(R.drawable.akali);
										break;
									case 3: top.setImageResource(R.drawable.alistar);
										break;
									case 4: top.setImageResource(R.drawable.amumu);
										break;
									case 5: top.setImageResource(R.drawable.anivia);
										break;
									case 6: top.setImageResource(R.drawable.annie);
										break;
									case 7: top.setImageResource(R.drawable.ashe);
										break;
									case 8: top.setImageResource(R.drawable.blitzcrank);
										break;
									case 9: top.setImageResource(R.drawable.brand);
										break;
									case 10: top.setImageResource(R.drawable.caitlyn);
										break;
									case 11: top.setImageResource(R.drawable.cassiopeia);
										break;
									case 12: top.setImageResource(R.drawable.chogath);
										break;
									case 13: top.setImageResource(R.drawable.corki);
										break;
									case 14: top.setImageResource(R.drawable.darius);
										break;						
									case 15: top.setImageResource(R.drawable.diana);
										break;						
									case 16: top.setImageResource(R.drawable.drmundo);
										break;						
									case 17: top.setImageResource(R.drawable.draven);
										break;						
									case 18: top.setImageResource(R.drawable.elise);
										break;						
									case 19: top.setImageResource(R.drawable.evelynn);
										break;						
									case 20: top.setImageResource(R.drawable.ezreal);
										break;						
									case 21: top.setImageResource(R.drawable.fiddlesticks);
										break;						
									case 22: top.setImageResource(R.drawable.fiora);
										break;						
									case 23: top.setImageResource(R.drawable.fizz);
										break;						
									case 24: top.setImageResource(R.drawable.galio);
										break;						
									case 25: top.setImageResource(R.drawable.gangplank);
										break;						
									case 26: top.setImageResource(R.drawable.garen);
										break;						
									case 27: top.setImageResource(R.drawable.gragas);
										break;						
									case 28: top.setImageResource(R.drawable.graves);
										break;						
									case 29: top.setImageResource(R.drawable.hecarim);
										break;						
									case 30: top.setImageResource(R.drawable.heimerdinger);
										break;						
									case 31: top.setImageResource(R.drawable.irelia);
										break;						
									case 32: top.setImageResource(R.drawable.janna);
										break;						
									case 33: top.setImageResource(R.drawable.jarvaniv);
										break;						
									case 34: top.setImageResource(R.drawable.jax);
										break;						
									case 35: top.setImageResource(R.drawable.jayce);
										break;						
									case 36: top.setImageResource(R.drawable.jinx);
										break;						
									case 37: top.setImageResource(R.drawable.karma);
										break;
									case 38: top.setImageResource(R.drawable.karthus);
										break;
									case 39: top.setImageResource(R.drawable.kassadin);
										break;     	
									case 40: top.setImageResource(R.drawable.katarina);
										break;     	
									case 41: top.setImageResource(R.drawable.kayle);
										break;     	
									case 42: top.setImageResource(R.drawable.kennen);
										break;     	
									case 43: top.setImageResource(R.drawable.khazix);
										break;     	
									case 44: top.setImageResource(R.drawable.kogmaw);
										break;     	
									case 45: top.setImageResource(R.drawable.leblanc);
										break;     	
									case 46: top.setImageResource(R.drawable.leesin);
										break;     	
									case 47: top.setImageResource(R.drawable.leona);
										break;     	
									case 48: top.setImageResource(R.drawable.lissandra);
										break;     	
									case 49: top.setImageResource(R.drawable.lucian);
										break;     	
									case 50: top.setImageResource(R.drawable.lulu);
										break;     	
									case 51: top.setImageResource(R.drawable.lux);
										break;     	
									case 52: top.setImageResource(R.drawable.malphite);
										break;     	
									case 53: top.setImageResource(R.drawable.malzahar);
										break;     	
									case 54: top.setImageResource(R.drawable.maokai);
										break;     	
									case 55: top.setImageResource(R.drawable.masteryi);
										break;     	
									case 56: top.setImageResource(R.drawable.missfortune);
										break;     	
									case 57: top.setImageResource(R.drawable.mordekaiser);
										break;     	
									case 58: top.setImageResource(R.drawable.morgana);
										break;     	
									case 59: top.setImageResource(R.drawable.nami);
										break;     	
									case 60: top.setImageResource(R.drawable.nasus);
										break;     	
									case 61: top.setImageResource(R.drawable.nautilus);
										break;     	
									case 62: top.setImageResource(R.drawable.nidalee);
										break;     	
									case 63: top.setImageResource(R.drawable.nocturne);
										break;     	
									case 64: top.setImageResource(R.drawable.nunu);
										break;     	
									case 65: top.setImageResource(R.drawable.olaf);
										break;     	
									case 66: top.setImageResource(R.drawable.orianna);
										break;     	
									case 67: top.setImageResource(R.drawable.pantheon);
										break;     	
									case 68: top.setImageResource(R.drawable.poppy);
										break;     	
									case 69: top.setImageResource(R.drawable.quinn);
										break;     	
									case 70: top.setImageResource(R.drawable.rammus);
										break;     	
									case 71: top.setImageResource(R.drawable.renekton);
										break;     	
									case 72: top.setImageResource(R.drawable.rengar);
										break;     	
									case 73: top.setImageResource(R.drawable.riven);
										break;     	
									case 74: top.setImageResource(R.drawable.rumble);
										break;     	
									case 75: top.setImageResource(R.drawable.ryze);
										break;     	
									case 76: top.setImageResource(R.drawable.sejuani);
										break;     	
									case 77: top.setImageResource(R.drawable.shaco);
										break; 		
									case 78: top.setImageResource(R.drawable.shen);
										break;     			
									case 79: top.setImageResource(R.drawable.shyvana);
										break;     			
									case 80: top.setImageResource(R.drawable.singed);
										break;     			
									case 81: top.setImageResource(R.drawable.sion);
										break;     			
									case 82: top.setImageResource(R.drawable.sivir);
										break;     			
									case 83: top.setImageResource(R.drawable.skarner);
										break;     			
									case 84: top.setImageResource(R.drawable.sona);
										break;     			
									case 85: top.setImageResource(R.drawable.soraka);
										break;     			
									case 86: top.setImageResource(R.drawable.swain);
										break;     			
									case 87: top.setImageResource(R.drawable.syndra);
										break;     			
									case 88: top.setImageResource(R.drawable.talon);
										break;     			
									case 89: top.setImageResource(R.drawable.taric);
										break;     			
									case 90: top.setImageResource(R.drawable.teemo);
										break;     			
									case 91: top.setImageResource(R.drawable.thresh);
										break;     			
									case 92: top.setImageResource(R.drawable.tristana);
										break;     			
									case 93: top.setImageResource(R.drawable.trundle);
										break;     			
									case 94: top.setImageResource(R.drawable.tryndamere);
										break;     			
									case 95: top.setImageResource(R.drawable.twistedfate);
										break;     			
									case 96: top.setImageResource(R.drawable.twitch);
										break;     			
									case 97: top.setImageResource(R.drawable.udyr);
										break;     			
									case 98: top.setImageResource(R.drawable.urgot);
										break;     			
									case 99: top.setImageResource(R.drawable.varus);
										break;     			
									case 100: top.setImageResource(R.drawable.vayne);
										break;     			
									case 101: top.setImageResource(R.drawable.veigar);
										break;     			
									case 102: top.setImageResource(R.drawable.velkoz);
										break;     			
									case 103: top.setImageResource(R.drawable.vi);
										break;     			
									case 104: top.setImageResource(R.drawable.viktor);
										break;     			
									case 105: top.setImageResource(R.drawable.vladimir);
										break;     			
									case 106: top.setImageResource(R.drawable.volibear);
										break;     			
									case 107: top.setImageResource(R.drawable.warwick);
										break;     			
									case 108: top.setImageResource(R.drawable.wukong);
										break;     			
									case 109: top.setImageResource(R.drawable.xerath);
										break;     			
									case 110: top.setImageResource(R.drawable.xinzhao);
										break;     			
									case 111: top.setImageResource(R.drawable.yasuo);
										break;     			
									case 112: top.setImageResource(R.drawable.yorick);
										break;     			
									case 113: top.setImageResource(R.drawable.zac);
										break;     			
									case 114: top.setImageResource(R.drawable.zed);
										break;     			
									case 115: top.setImageResource(R.drawable.ziggs);
										break;     			
									case 116: top.setImageResource(R.drawable.zilean);
										break;     			
									case 117: top.setImageResource(R.drawable.zyra);
										break;     							
									default: 
										break;
									}

							}
							else if (buttonPressFlags[1] == 1){
								teambuilder.setOurTeam(1, currentChampion);
								buttonChangedFlags[1] = 1;
						    	String message = currentChampion.getName();
						    	int i;
						    	
						    	if(message.equals("Aatrox")){
						            i = 0;
								}else if(message.equals("Ahri")){
						            i = 1;
						    	}else if(message.equals("Akali")){
						            i = 2;
						    	}else if(message.equals("Alistar")){
						    		i = 3;
						    	}else if(message.equals("Amumu")){
						    		i = 4;
						    	}else if(message.equals("Anivia")){
						    		i = 5;
						    	}else if(message.equals("Annie")){
						    		i = 6;
						    	}else if(message.equals("Ashe")){
						            i = 7;
						    	}else if(message.equals("Blitzcrank")){
						            i = 8;
						    	}else if(message.equals("Brand")){
						            i = 9;
						    	}else if(message.equals("Caitlyn")){
						    		i = 10;
						    	}else if(message.equals("Cassiopeia")){
						    		i = 11;
						    	}else if(message.equals("Cho Gath")){
						    		i = 12;
						    	}else if(message.equals("Corki")){
						    		i = 13;
						    	}else if(message.equals("Darius")){
						    		i = 14;
						    	}else if(message.equals("Diana")){
						    		i = 15;
						    	}else if(message.equals("Dr. Mundo")){
						    		i = 16;
						    	}else if(message.equals("Draven")){
						    		i = 17;
						    	}else if(message.equals("Elise")){
						    		i = 18;
						    	}else if(message.equals("Evelynn")){
						    		i = 19;
						    	}else if(message.equals("Ezreal")){
						    		i = 20;
						    	}else if(message.equals("Fiddlesticks")){
						    		i = 21;
						    	}else if(message.equals("Fiora")){
						    		i = 22;
						    	}else if(message.equals("Fizz")){
						    		i = 23;
						    	}else if(message.equals("Galio")){
						    		i = 24;
						    	}else if(message.equals("Gangplank")){
						    		i = 25;
						    	}else if(message.equals("Garen")){
						    		i = 26;
						    	}else if(message.equals("Gragas")){
						    		i = 27;
						    	}else if(message.equals("Graves")){
						    		i = 28;
						    	}else if(message.equals("Hecarim")){
						    		i = 29;
						    	}else if(message.equals("Heimerdinger")){
						    		i = 30;
						    	}else if(message.equals("Irelia")){
						    		i = 31;
						    	}else if(message.equals("Janna")){
						    		i = 32;
						    	}else if(message.equals("Jarvan IV")){
						    		i = 33;
						    	}else if(message.equals("Jax")){
						    		i = 34;
						    	}else if(message.equals("Jayce")){
						    		i = 35;
						    	}else if(message.equals("Jinx")){
						    		i = 36;
						    	}else if(message.equals("Karma")){
						    		i = 37;
						    	}else if(message.equals("Karthus")){
						    		i = 38;
						    	}else if(message.equals("Kassadin")){
						    		i = 39;
						    	}else if(message.equals("Katarina")){
						    		i = 40;
						    	}else if(message.equals("Kayle")){
						    		i = 41;
						    	}else if(message.equals("Kennen")){
						    		i = 42;
						    	}else if(message.equals("Kha Zix")){
						    		i = 43;
						    	}else if(message.equals("Kog Maw")){
						    		i = 44;
						    	}else if(message.equals("LeBlanc")){
						    		i = 45;
						    	}else if(message.equals("Lee Sin")){
						    		i = 46;
						    	}else if(message.equals("Leona")){
						    		i = 47;
						    	}else if(message.equals("Lissandra")){
						    		i = 48;
						    	}else if(message.equals("Lucian")){
						    		i = 49;
						    	}else if(message.equals("Lulu")){
						    		i = 50;
						    	}else if(message.equals("Lux")){
						    		i = 51;
						    	}else if(message.equals("Malphite")){
						    		i = 52;
						    	}else if(message.equals("Malzahar")){
						    		i = 53;
						    	}else if(message.equals("Maokai")){
						    		i = 54;
						    	}else if(message.equals("Master Yi")){
						    		i = 55;
						    	}else if(message.equals("Miss Fortune")){
						    		i = 56;
						    	}else if(message.equals("Mordekaiser")){
						    		i = 57;
						    	}else if(message.equals("Morgana")){
						    		i = 58;
						    	}else if(message.equals("Nami")){
						    		i = 59;
						    	}else if(message.equals("Nasus")){
						    		i = 60;
						    	}else if(message.equals("Nautilus")){
						    		i = 61;
						    	}else if(message.equals("Nidalee")){
						    		i = 62;
						    	}else if(message.equals("Nocturne")){
						    		i = 63;
						    	}else if(message.equals("Nunu")){
						    		i = 64;
						    	}else if(message.equals("Olaf")){
						    		i = 65;
						    	}else if(message.equals("Orianna")){
						    		i = 66;
						    	}else if(message.equals("Pantheon")){
						    		i = 67;
						    	}else if(message.equals("Poppy")){
						    		i = 68;
						    	}else if(message.equals("Quinn")){
						    		i = 69;
						    	}else if(message.equals("Rammus")){
						    		i = 70;
						    	}else if(message.equals("Renekton")){
						    		i = 71;
						    	}else if(message.equals("Rengar")){
						    		i = 72;
						    	}else if(message.equals("Riven")){
						    		i = 73;
						    	}else if(message.equals("Rumble")){
						    		i = 74;
						    	}else if(message.equals("Ryze")){
						    		i = 75;
						    	}else if(message.equals("Sejuani")){
						    		i = 76;
						    	}else if(message.equals("Shaco")){
						    		i = 77;
						    	}else if(message.equals("Shen")){
						    		i = 78;
						    	}else if(message.equals("Shyvana")){
						    		i = 79;
						    	}else if(message.equals("Singed")){
						    		i = 80;
						    	}else if(message.equals("Sion")){
						    		i = 81;
						    	}else if(message.equals("Sivir")){
						    		i = 82;
						    	}else if(message.equals("Skarner")){
						    		i = 83;
						    	}else if(message.equals("Sona")){
						    		i = 84;
						    	}else if(message.equals("Soraka")){
						    		i = 85;
						    	}else if(message.equals("Swain")){
						    		i = 86;
						    	}else if(message.equals("Syndra")){
						    		i = 87;
						    	}else if(message.equals("Talon")){
						    		i = 88;
						    	}else if(message.equals("Taric")){
						    		i = 89;
						    	}else if(message.equals("Teemo")){
						    		i = 90;
						    	}else if(message.equals("Thresh")){
						    		i = 91;
						    	}else if(message.equals("Tristana")){
						    		i = 92;
						    	}else if(message.equals("Trundle")){
						    		i = 93;
						    	}else if(message.equals("Tryndamere")){
						    		i = 94;
						    	}else if(message.equals("Twisted Fate")){
						    		i = 95;
						    	}else if(message.equals("Twitch")){
						    		i = 96;
						    	}else if(message.equals("Udyr")){
						    		i = 97;
						    	}else if(message.equals("Urgot")){
						    		i = 98;
						    	}else if(message.equals("Varus")){
						    		i = 99;
						    	}else if(message.equals("Vayne")){
						    		i = 100;
						    	}else if(message.equals("Veigar")){
						    		i = 101;
						    	}else if(message.equals("Vel Koz")){
						    		i = 102;
						    	}else if(message.equals("Vi")){
						    		i = 103;
						    	}else if(message.equals("Viktor")){
						    		i = 104;
						    	}else if(message.equals("Vladimir")){
						    		i = 105;
						    	}else if(message.equals("Volibear")){
						    		i = 106;
						    	}else if(message.equals("Warwick")){
						    		i = 107;
						    	}else if(message.equals("Wukong")){
						    		i = 108;
						    	}else if(message.equals("Xerath")){
						    		i = 109;
						    	}else if(message.equals("Xin Zhao")){
						    		i = 110;
						    	}else if(message.equals("Yasuo")){
						    		i = 111;
						    	}else if(message.equals("Yorick")){
						    		i = 112;
						    	}else if(message.equals("Zac")){
						    		i = 113;
						    	}else if(message.equals("Zed")){
						    		i = 114;
						    	}else if(message.equals("Ziggs")){
						    		i = 115;
						    	}else if(message.equals("Zilean")){
						    		i = 116;
						    	}else{
						    		i=117;
						    	}

								switch(i){
									case 0: jungle.setImageResource(R.drawable.aatrox);
										break;
									case 1: jungle.setImageResource(R.drawable.ahri);
										break;
									case 2: jungle.setImageResource(R.drawable.akali);
										break;
									case 3: jungle.setImageResource(R.drawable.alistar);
										break;
									case 4: jungle.setImageResource(R.drawable.amumu);
										break;
									case 5: jungle.setImageResource(R.drawable.anivia);
										break;
									case 6: jungle.setImageResource(R.drawable.annie);
										break;
									case 7: jungle.setImageResource(R.drawable.ashe);
										break;
									case 8: jungle.setImageResource(R.drawable.blitzcrank);
										break;
									case 9: jungle.setImageResource(R.drawable.brand);
										break;
									case 10: jungle.setImageResource(R.drawable.caitlyn);
										break;
									case 11: jungle.setImageResource(R.drawable.cassiopeia);
										break;
									case 12: jungle.setImageResource(R.drawable.chogath);
										break;
									case 13: jungle.setImageResource(R.drawable.corki);
										break;
									case 14: jungle.setImageResource(R.drawable.darius);
										break;						
									case 15: jungle.setImageResource(R.drawable.diana);
										break;						
									case 16: jungle.setImageResource(R.drawable.drmundo);
										break;						
									case 17: jungle.setImageResource(R.drawable.draven);
										break;						
									case 18: jungle.setImageResource(R.drawable.elise);
										break;						
									case 19: jungle.setImageResource(R.drawable.evelynn);
										break;						
									case 20: jungle.setImageResource(R.drawable.ezreal);
										break;						
									case 21: jungle.setImageResource(R.drawable.fiddlesticks);
										break;						
									case 22: jungle.setImageResource(R.drawable.fiora);
										break;						
									case 23: jungle.setImageResource(R.drawable.fizz);
										break;						
									case 24: jungle.setImageResource(R.drawable.galio);
										break;						
									case 25: jungle.setImageResource(R.drawable.gangplank);
										break;						
									case 26: jungle.setImageResource(R.drawable.garen);
										break;						
									case 27: jungle.setImageResource(R.drawable.gragas);
										break;						
									case 28: jungle.setImageResource(R.drawable.graves);
										break;						
									case 29: jungle.setImageResource(R.drawable.hecarim);
										break;						
									case 30: jungle.setImageResource(R.drawable.heimerdinger);
										break;						
									case 31: jungle.setImageResource(R.drawable.irelia);
										break;						
									case 32: jungle.setImageResource(R.drawable.janna);
										break;						
									case 33: jungle.setImageResource(R.drawable.jarvaniv);
										break;						
									case 34: jungle.setImageResource(R.drawable.jax);
										break;						
									case 35: jungle.setImageResource(R.drawable.jayce);
										break;						
									case 36: jungle.setImageResource(R.drawable.jinx);
										break;						
									case 37: jungle.setImageResource(R.drawable.karma);
										break;
									case 38: jungle.setImageResource(R.drawable.karthus);
										break;
									case 39: jungle.setImageResource(R.drawable.kassadin);
										break;     	
									case 40: jungle.setImageResource(R.drawable.katarina);
										break;     	
									case 41: jungle.setImageResource(R.drawable.kayle);
										break;     	
									case 42: jungle.setImageResource(R.drawable.kennen);
										break;     	
									case 43: jungle.setImageResource(R.drawable.khazix);
										break;     	
									case 44: jungle.setImageResource(R.drawable.kogmaw);
										break;     	
									case 45: jungle.setImageResource(R.drawable.leblanc);
										break;     	
									case 46: jungle.setImageResource(R.drawable.leesin);
										break;     	
									case 47: jungle.setImageResource(R.drawable.leona);
										break;     	
									case 48: jungle.setImageResource(R.drawable.lissandra);
										break;     	
									case 49: jungle.setImageResource(R.drawable.lucian);
										break;     	
									case 50: jungle.setImageResource(R.drawable.lulu);
										break;     	
									case 51: jungle.setImageResource(R.drawable.lux);
										break;     	
									case 52: jungle.setImageResource(R.drawable.malphite);
										break;     	
									case 53: jungle.setImageResource(R.drawable.malzahar);
										break;     	
									case 54: jungle.setImageResource(R.drawable.maokai);
										break;     	
									case 55: jungle.setImageResource(R.drawable.masteryi);
										break;     	
									case 56: jungle.setImageResource(R.drawable.missfortune);
										break;     	
									case 57: jungle.setImageResource(R.drawable.mordekaiser);
										break;     	
									case 58: jungle.setImageResource(R.drawable.morgana);
										break;     	
									case 59: jungle.setImageResource(R.drawable.nami);
										break;     	
									case 60: jungle.setImageResource(R.drawable.nasus);
										break;     	
									case 61: jungle.setImageResource(R.drawable.nautilus);
										break;     	
									case 62: jungle.setImageResource(R.drawable.nidalee);
										break;     	
									case 63: jungle.setImageResource(R.drawable.nocturne);
										break;     	
									case 64: jungle.setImageResource(R.drawable.nunu);
										break;     	
									case 65: jungle.setImageResource(R.drawable.olaf);
										break;     	
									case 66: jungle.setImageResource(R.drawable.orianna);
										break;     	
									case 67: jungle.setImageResource(R.drawable.pantheon);
										break;     	
									case 68: jungle.setImageResource(R.drawable.poppy);
										break;     	
									case 69: jungle.setImageResource(R.drawable.quinn);
										break;     	
									case 70: jungle.setImageResource(R.drawable.rammus);
										break;     	
									case 71: jungle.setImageResource(R.drawable.renekton);
										break;     	
									case 72: jungle.setImageResource(R.drawable.rengar);
										break;     	
									case 73: jungle.setImageResource(R.drawable.riven);
										break;     	
									case 74: jungle.setImageResource(R.drawable.rumble);
										break;     	
									case 75: jungle.setImageResource(R.drawable.ryze);
										break;     	
									case 76: jungle.setImageResource(R.drawable.sejuani);
										break;     	
									case 77: jungle.setImageResource(R.drawable.shaco);
										break; 		
									case 78: jungle.setImageResource(R.drawable.shen);
										break;     			
									case 79: jungle.setImageResource(R.drawable.shyvana);
										break;     			
									case 80: jungle.setImageResource(R.drawable.singed);
										break;     			
									case 81: jungle.setImageResource(R.drawable.sion);
										break;     			
									case 82: jungle.setImageResource(R.drawable.sivir);
										break;     			
									case 83: jungle.setImageResource(R.drawable.skarner);
										break;     			
									case 84: jungle.setImageResource(R.drawable.sona);
										break;     			
									case 85: jungle.setImageResource(R.drawable.soraka);
										break;     			
									case 86: jungle.setImageResource(R.drawable.swain);
										break;     			
									case 87: jungle.setImageResource(R.drawable.syndra);
										break;     			
									case 88: jungle.setImageResource(R.drawable.talon);
										break;     			
									case 89: jungle.setImageResource(R.drawable.taric);
										break;     			
									case 90: jungle.setImageResource(R.drawable.teemo);
										break;     			
									case 91: jungle.setImageResource(R.drawable.thresh);
										break;     			
									case 92: jungle.setImageResource(R.drawable.tristana);
										break;     			
									case 93: jungle.setImageResource(R.drawable.trundle);
										break;     			
									case 94: jungle.setImageResource(R.drawable.tryndamere);
										break;     			
									case 95: jungle.setImageResource(R.drawable.twistedfate);
										break;     			
									case 96: jungle.setImageResource(R.drawable.twitch);
										break;     			
									case 97: jungle.setImageResource(R.drawable.udyr);
										break;     			
									case 98: jungle.setImageResource(R.drawable.urgot);
										break;     			
									case 99: jungle.setImageResource(R.drawable.varus);
										break;     			
									case 100: jungle.setImageResource(R.drawable.vayne);
										break;     			
									case 101: jungle.setImageResource(R.drawable.veigar);
										break;     			
									case 102: jungle.setImageResource(R.drawable.velkoz);
										break;     			
									case 103: jungle.setImageResource(R.drawable.vi);
										break;     			
									case 104: jungle.setImageResource(R.drawable.viktor);
										break;     			
									case 105: jungle.setImageResource(R.drawable.vladimir);
										break;     			
									case 106: jungle.setImageResource(R.drawable.volibear);
										break;     			
									case 107: jungle.setImageResource(R.drawable.warwick);
										break;     			
									case 108: jungle.setImageResource(R.drawable.wukong);
										break;     			
									case 109: jungle.setImageResource(R.drawable.xerath);
										break;     			
									case 110: jungle.setImageResource(R.drawable.xinzhao);
										break;     			
									case 111: jungle.setImageResource(R.drawable.yasuo);
										break;     			
									case 112: jungle.setImageResource(R.drawable.yorick);
										break;     			
									case 113: jungle.setImageResource(R.drawable.zac);
										break;     			
									case 114: jungle.setImageResource(R.drawable.zed);
										break;     			
									case 115: jungle.setImageResource(R.drawable.ziggs);
										break;     			
									case 116: jungle.setImageResource(R.drawable.zilean);
										break;     			
									case 117: jungle.setImageResource(R.drawable.zyra);
										break;     							
									default: 
										break;
									}

							}
							else if (buttonPressFlags[2] == 1){
								teambuilder.setOurTeam(2, currentChampion);
								buttonChangedFlags[2] = 1;
						    	String message = currentChampion.getName();
						    	int i;
						    	
						    	if(message.equals("Aatrox")){
						            i = 0;
								}else if(message.equals("Ahri")){
						            i = 1;
						    	}else if(message.equals("Akali")){
						            i = 2;
						    	}else if(message.equals("Alistar")){
						    		i = 3;
						    	}else if(message.equals("Amumu")){
						    		i = 4;
						    	}else if(message.equals("Anivia")){
						    		i = 5;
						    	}else if(message.equals("Annie")){
						    		i = 6;
						    	}else if(message.equals("Ashe")){
						            i = 7;
						    	}else if(message.equals("Blitzcrank")){
						            i = 8;
						    	}else if(message.equals("Brand")){
						            i = 9;
						    	}else if(message.equals("Caitlyn")){
						    		i = 10;
						    	}else if(message.equals("Cassiopeia")){
						    		i = 11;
						    	}else if(message.equals("Cho Gath")){
						    		i = 12;
						    	}else if(message.equals("Corki")){
						    		i = 13;
						    	}else if(message.equals("Darius")){
						    		i = 14;
						    	}else if(message.equals("Diana")){
						    		i = 15;
						    	}else if(message.equals("Dr. Mundo")){
						    		i = 16;
						    	}else if(message.equals("Draven")){
						    		i = 17;
						    	}else if(message.equals("Elise")){
						    		i = 18;
						    	}else if(message.equals("Evelynn")){
						    		i = 19;
						    	}else if(message.equals("Ezreal")){
						    		i = 20;
						    	}else if(message.equals("Fiddlesticks")){
						    		i = 21;
						    	}else if(message.equals("Fiora")){
						    		i = 22;
						    	}else if(message.equals("Fizz")){
						    		i = 23;
						    	}else if(message.equals("Galio")){
						    		i = 24;
						    	}else if(message.equals("Gangplank")){
						    		i = 25;
						    	}else if(message.equals("Garen")){
						    		i = 26;
						    	}else if(message.equals("Gragas")){
						    		i = 27;
						    	}else if(message.equals("Graves")){
						    		i = 28;
						    	}else if(message.equals("Hecarim")){
						    		i = 29;
						    	}else if(message.equals("Heimerdinger")){
						    		i = 30;
						    	}else if(message.equals("Irelia")){
						    		i = 31;
						    	}else if(message.equals("Janna")){
						    		i = 32;
						    	}else if(message.equals("Jarvan IV")){
						    		i = 33;
						    	}else if(message.equals("Jax")){
						    		i = 34;
						    	}else if(message.equals("Jayce")){
						    		i = 35;
						    	}else if(message.equals("Jinx")){
						    		i = 36;
						    	}else if(message.equals("Karma")){
						    		i = 37;
						    	}else if(message.equals("Karthus")){
						    		i = 38;
						    	}else if(message.equals("Kassadin")){
						    		i = 39;
						    	}else if(message.equals("Katarina")){
						    		i = 40;
						    	}else if(message.equals("Kayle")){
						    		i = 41;
						    	}else if(message.equals("Kennen")){
						    		i = 42;
						    	}else if(message.equals("Kha Zix")){
						    		i = 43;
						    	}else if(message.equals("Kog Maw")){
						    		i = 44;
						    	}else if(message.equals("LeBlanc")){
						    		i = 45;
						    	}else if(message.equals("Lee Sin")){
						    		i = 46;
						    	}else if(message.equals("Leona")){
						    		i = 47;
						    	}else if(message.equals("Lissandra")){
						    		i = 48;
						    	}else if(message.equals("Lucian")){
						    		i = 49;
						    	}else if(message.equals("Lulu")){
						    		i = 50;
						    	}else if(message.equals("Lux")){
						    		i = 51;
						    	}else if(message.equals("Malphite")){
						    		i = 52;
						    	}else if(message.equals("Malzahar")){
						    		i = 53;
						    	}else if(message.equals("Maokai")){
						    		i = 54;
						    	}else if(message.equals("Master Yi")){
						    		i = 55;
						    	}else if(message.equals("Miss Fortune")){
						    		i = 56;
						    	}else if(message.equals("Mordekaiser")){
						    		i = 57;
						    	}else if(message.equals("Morgana")){
						    		i = 58;
						    	}else if(message.equals("Nami")){
						    		i = 59;
						    	}else if(message.equals("Nasus")){
						    		i = 60;
						    	}else if(message.equals("Nautilus")){
						    		i = 61;
						    	}else if(message.equals("Nidalee")){
						    		i = 62;
						    	}else if(message.equals("Nocturne")){
						    		i = 63;
						    	}else if(message.equals("Nunu")){
						    		i = 64;
						    	}else if(message.equals("Olaf")){
						    		i = 65;
						    	}else if(message.equals("Orianna")){
						    		i = 66;
						    	}else if(message.equals("Pantheon")){
						    		i = 67;
						    	}else if(message.equals("Poppy")){
						    		i = 68;
						    	}else if(message.equals("Quinn")){
						    		i = 69;
						    	}else if(message.equals("Rammus")){
						    		i = 70;
						    	}else if(message.equals("Renekton")){
						    		i = 71;
						    	}else if(message.equals("Rengar")){
						    		i = 72;
						    	}else if(message.equals("Riven")){
						    		i = 73;
						    	}else if(message.equals("Rumble")){
						    		i = 74;
						    	}else if(message.equals("Ryze")){
						    		i = 75;
						    	}else if(message.equals("Sejuani")){
						    		i = 76;
						    	}else if(message.equals("Shaco")){
						    		i = 77;
						    	}else if(message.equals("Shen")){
						    		i = 78;
						    	}else if(message.equals("Shyvana")){
						    		i = 79;
						    	}else if(message.equals("Singed")){
						    		i = 80;
						    	}else if(message.equals("Sion")){
						    		i = 81;
						    	}else if(message.equals("Sivir")){
						    		i = 82;
						    	}else if(message.equals("Skarner")){
						    		i = 83;
						    	}else if(message.equals("Sona")){
						    		i = 84;
						    	}else if(message.equals("Soraka")){
						    		i = 85;
						    	}else if(message.equals("Swain")){
						    		i = 86;
						    	}else if(message.equals("Syndra")){
						    		i = 87;
						    	}else if(message.equals("Talon")){
						    		i = 88;
						    	}else if(message.equals("Taric")){
						    		i = 89;
						    	}else if(message.equals("Teemo")){
						    		i = 90;
						    	}else if(message.equals("Thresh")){
						    		i = 91;
						    	}else if(message.equals("Tristana")){
						    		i = 92;
						    	}else if(message.equals("Trundle")){
						    		i = 93;
						    	}else if(message.equals("Tryndamere")){
						    		i = 94;
						    	}else if(message.equals("Twisted Fate")){
						    		i = 95;
						    	}else if(message.equals("Twitch")){
						    		i = 96;
						    	}else if(message.equals("Udyr")){
						    		i = 97;
						    	}else if(message.equals("Urgot")){
						    		i = 98;
						    	}else if(message.equals("Varus")){
						    		i = 99;
						    	}else if(message.equals("Vayne")){
						    		i = 100;
						    	}else if(message.equals("Veigar")){
						    		i = 101;
						    	}else if(message.equals("Vel Koz")){
						    		i = 102;
						    	}else if(message.equals("Vi")){
						    		i = 103;
						    	}else if(message.equals("Viktor")){
						    		i = 104;
						    	}else if(message.equals("Vladimir")){
						    		i = 105;
						    	}else if(message.equals("Volibear")){
						    		i = 106;
						    	}else if(message.equals("Warwick")){
						    		i = 107;
						    	}else if(message.equals("Wukong")){
						    		i = 108;
						    	}else if(message.equals("Xerath")){
						    		i = 109;
						    	}else if(message.equals("Xin Zhao")){
						    		i = 110;
						    	}else if(message.equals("Yasuo")){
						    		i = 111;
						    	}else if(message.equals("Yorick")){
						    		i = 112;
						    	}else if(message.equals("Zac")){
						    		i = 113;
						    	}else if(message.equals("Zed")){
						    		i = 114;
						    	}else if(message.equals("Ziggs")){
						    		i = 115;
						    	}else if(message.equals("Zilean")){
						    		i = 116;
						    	}else{
						    		i=117;
						    	}

								switch(i){
									case 0: middle.setImageResource(R.drawable.aatrox);
										break;
									case 1: middle.setImageResource(R.drawable.ahri);
										break;
									case 2: middle.setImageResource(R.drawable.akali);
										break;
									case 3: middle.setImageResource(R.drawable.alistar);
										break;
									case 4: middle.setImageResource(R.drawable.amumu);
										break;
									case 5: middle.setImageResource(R.drawable.anivia);
										break;
									case 6: middle.setImageResource(R.drawable.annie);
										break;
									case 7: middle.setImageResource(R.drawable.ashe);
										break;
									case 8: middle.setImageResource(R.drawable.blitzcrank);
										break;
									case 9: middle.setImageResource(R.drawable.brand);
										break;
									case 10: middle.setImageResource(R.drawable.caitlyn);
										break;
									case 11: middle.setImageResource(R.drawable.cassiopeia);
										break;
									case 12: middle.setImageResource(R.drawable.chogath);
										break;
									case 13: middle.setImageResource(R.drawable.corki);
										break;
									case 14: middle.setImageResource(R.drawable.darius);
										break;						
									case 15: middle.setImageResource(R.drawable.diana);
										break;						
									case 16: middle.setImageResource(R.drawable.drmundo);
										break;						
									case 17: middle.setImageResource(R.drawable.draven);
										break;						
									case 18: middle.setImageResource(R.drawable.elise);
										break;						
									case 19: middle.setImageResource(R.drawable.evelynn);
										break;						
									case 20: middle.setImageResource(R.drawable.ezreal);
										break;						
									case 21: middle.setImageResource(R.drawable.fiddlesticks);
										break;						
									case 22: middle.setImageResource(R.drawable.fiora);
										break;						
									case 23: middle.setImageResource(R.drawable.fizz);
										break;						
									case 24: middle.setImageResource(R.drawable.galio);
										break;						
									case 25: middle.setImageResource(R.drawable.gangplank);
										break;						
									case 26: middle.setImageResource(R.drawable.garen);
										break;						
									case 27: middle.setImageResource(R.drawable.gragas);
										break;						
									case 28: middle.setImageResource(R.drawable.graves);
										break;						
									case 29: middle.setImageResource(R.drawable.hecarim);
										break;						
									case 30: middle.setImageResource(R.drawable.heimerdinger);
										break;						
									case 31: middle.setImageResource(R.drawable.irelia);
										break;						
									case 32: middle.setImageResource(R.drawable.janna);
										break;						
									case 33: middle.setImageResource(R.drawable.jarvaniv);
										break;						
									case 34: middle.setImageResource(R.drawable.jax);
										break;						
									case 35: middle.setImageResource(R.drawable.jayce);
										break;						
									case 36: middle.setImageResource(R.drawable.jinx);
										break;						
									case 37: middle.setImageResource(R.drawable.karma);
										break;
									case 38: middle.setImageResource(R.drawable.karthus);
										break;
									case 39: middle.setImageResource(R.drawable.kassadin);
										break;     	
									case 40: middle.setImageResource(R.drawable.katarina);
										break;     	
									case 41: middle.setImageResource(R.drawable.kayle);
										break;     	
									case 42: middle.setImageResource(R.drawable.kennen);
										break;     	
									case 43: middle.setImageResource(R.drawable.khazix);
										break;     	
									case 44: middle.setImageResource(R.drawable.kogmaw);
										break;     	
									case 45: middle.setImageResource(R.drawable.leblanc);
										break;     	
									case 46: middle.setImageResource(R.drawable.leesin);
										break;     	
									case 47: middle.setImageResource(R.drawable.leona);
										break;     	
									case 48: middle.setImageResource(R.drawable.lissandra);
										break;     	
									case 49: middle.setImageResource(R.drawable.lucian);
										break;     	
									case 50: middle.setImageResource(R.drawable.lulu);
										break;     	
									case 51: middle.setImageResource(R.drawable.lux);
										break;     	
									case 52: middle.setImageResource(R.drawable.malphite);
										break;     	
									case 53: middle.setImageResource(R.drawable.malzahar);
										break;     	
									case 54: middle.setImageResource(R.drawable.maokai);
										break;     	
									case 55: middle.setImageResource(R.drawable.masteryi);
										break;     	
									case 56: middle.setImageResource(R.drawable.missfortune);
										break;     	
									case 57: middle.setImageResource(R.drawable.mordekaiser);
										break;     	
									case 58: middle.setImageResource(R.drawable.morgana);
										break;     	
									case 59: middle.setImageResource(R.drawable.nami);
										break;     	
									case 60: middle.setImageResource(R.drawable.nasus);
										break;     	
									case 61: middle.setImageResource(R.drawable.nautilus);
										break;     	
									case 62: middle.setImageResource(R.drawable.nidalee);
										break;     	
									case 63: middle.setImageResource(R.drawable.nocturne);
										break;     	
									case 64: middle.setImageResource(R.drawable.nunu);
										break;     	
									case 65: middle.setImageResource(R.drawable.olaf);
										break;     	
									case 66: middle.setImageResource(R.drawable.orianna);
										break;     	
									case 67: middle.setImageResource(R.drawable.pantheon);
										break;     	
									case 68: middle.setImageResource(R.drawable.poppy);
										break;     	
									case 69: middle.setImageResource(R.drawable.quinn);
										break;     	
									case 70: middle.setImageResource(R.drawable.rammus);
										break;     	
									case 71: middle.setImageResource(R.drawable.renekton);
										break;     	
									case 72: middle.setImageResource(R.drawable.rengar);
										break;     	
									case 73: middle.setImageResource(R.drawable.riven);
										break;     	
									case 74: middle.setImageResource(R.drawable.rumble);
										break;     	
									case 75: middle.setImageResource(R.drawable.ryze);
										break;     	
									case 76: middle.setImageResource(R.drawable.sejuani);
										break;     	
									case 77: middle.setImageResource(R.drawable.shaco);
										break; 		
									case 78: middle.setImageResource(R.drawable.shen);
										break;     			
									case 79: middle.setImageResource(R.drawable.shyvana);
										break;     			
									case 80: middle.setImageResource(R.drawable.singed);
										break;     			
									case 81: middle.setImageResource(R.drawable.sion);
										break;     			
									case 82: middle.setImageResource(R.drawable.sivir);
										break;     			
									case 83: middle.setImageResource(R.drawable.skarner);
										break;     			
									case 84: middle.setImageResource(R.drawable.sona);
										break;     			
									case 85: middle.setImageResource(R.drawable.soraka);
										break;     			
									case 86: middle.setImageResource(R.drawable.swain);
										break;     			
									case 87: middle.setImageResource(R.drawable.syndra);
										break;     			
									case 88: middle.setImageResource(R.drawable.talon);
										break;     			
									case 89: middle.setImageResource(R.drawable.taric);
										break;     			
									case 90: middle.setImageResource(R.drawable.teemo);
										break;     			
									case 91: middle.setImageResource(R.drawable.thresh);
										break;     			
									case 92: middle.setImageResource(R.drawable.tristana);
										break;     			
									case 93: middle.setImageResource(R.drawable.trundle);
										break;     			
									case 94: middle.setImageResource(R.drawable.tryndamere);
										break;     			
									case 95: middle.setImageResource(R.drawable.twistedfate);
										break;     			
									case 96: middle.setImageResource(R.drawable.twitch);
										break;     			
									case 97: middle.setImageResource(R.drawable.udyr);
										break;     			
									case 98: middle.setImageResource(R.drawable.urgot);
										break;     			
									case 99: middle.setImageResource(R.drawable.varus);
										break;     			
									case 100: middle.setImageResource(R.drawable.vayne);
										break;     			
									case 101: middle.setImageResource(R.drawable.veigar);
										break;     			
									case 102: middle.setImageResource(R.drawable.velkoz);
										break;     			
									case 103: middle.setImageResource(R.drawable.vi);
										break;     			
									case 104: middle.setImageResource(R.drawable.viktor);
										break;     			
									case 105: middle.setImageResource(R.drawable.vladimir);
										break;     			
									case 106: middle.setImageResource(R.drawable.volibear);
										break;     			
									case 107: middle.setImageResource(R.drawable.warwick);
										break;     			
									case 108: middle.setImageResource(R.drawable.wukong);
										break;     			
									case 109: middle.setImageResource(R.drawable.xerath);
										break;     			
									case 110: middle.setImageResource(R.drawable.xinzhao);
										break;     			
									case 111: middle.setImageResource(R.drawable.yasuo);
										break;     			
									case 112: middle.setImageResource(R.drawable.yorick);
										break;     			
									case 113: middle.setImageResource(R.drawable.zac);
										break;     			
									case 114: middle.setImageResource(R.drawable.zed);
										break;     			
									case 115: middle.setImageResource(R.drawable.ziggs);
										break;     			
									case 116: middle.setImageResource(R.drawable.zilean);
										break;     			
									case 117: middle.setImageResource(R.drawable.zyra);
										break;     							
									default: 
										break;
									}

							}
							else if (buttonPressFlags[3] == 1){
								teambuilder.setOurTeam(3, currentChampion);
								buttonChangedFlags[3] = 1;
						    	String message = currentChampion.getName();
						    	int i;
						    	
						    	if(message.equals("Aatrox")){
						            i = 0;
								}else if(message.equals("Ahri")){
						            i = 1;
						    	}else if(message.equals("Akali")){
						            i = 2;
						    	}else if(message.equals("Alistar")){
						    		i = 3;
						    	}else if(message.equals("Amumu")){
						    		i = 4;
						    	}else if(message.equals("Anivia")){
						    		i = 5;
						    	}else if(message.equals("Annie")){
						    		i = 6;
						    	}else if(message.equals("Ashe")){
						            i = 7;
						    	}else if(message.equals("Blitzcrank")){
						            i = 8;
						    	}else if(message.equals("Brand")){
						            i = 9;
						    	}else if(message.equals("Caitlyn")){
						    		i = 10;
						    	}else if(message.equals("Cassiopeia")){
						    		i = 11;
						    	}else if(message.equals("Cho Gath")){
						    		i = 12;
						    	}else if(message.equals("Corki")){
						    		i = 13;
						    	}else if(message.equals("Darius")){
						    		i = 14;
						    	}else if(message.equals("Diana")){
						    		i = 15;
						    	}else if(message.equals("Dr. Mundo")){
						    		i = 16;
						    	}else if(message.equals("Draven")){
						    		i = 17;
						    	}else if(message.equals("Elise")){
						    		i = 18;
						    	}else if(message.equals("Evelynn")){
						    		i = 19;
						    	}else if(message.equals("Ezreal")){
						    		i = 20;
						    	}else if(message.equals("Fiddlesticks")){
						    		i = 21;
						    	}else if(message.equals("Fiora")){
						    		i = 22;
						    	}else if(message.equals("Fizz")){
						    		i = 23;
						    	}else if(message.equals("Galio")){
						    		i = 24;
						    	}else if(message.equals("Gangplank")){
						    		i = 25;
						    	}else if(message.equals("Garen")){
						    		i = 26;
						    	}else if(message.equals("Gragas")){
						    		i = 27;
						    	}else if(message.equals("Graves")){
						    		i = 28;
						    	}else if(message.equals("Hecarim")){
						    		i = 29;
						    	}else if(message.equals("Heimerdinger")){
						    		i = 30;
						    	}else if(message.equals("Irelia")){
						    		i = 31;
						    	}else if(message.equals("Janna")){
						    		i = 32;
						    	}else if(message.equals("Jarvan IV")){
						    		i = 33;
						    	}else if(message.equals("Jax")){
						    		i = 34;
						    	}else if(message.equals("Jayce")){
						    		i = 35;
						    	}else if(message.equals("Jinx")){
						    		i = 36;
						    	}else if(message.equals("Karma")){
						    		i = 37;
						    	}else if(message.equals("Karthus")){
						    		i = 38;
						    	}else if(message.equals("Kassadin")){
						    		i = 39;
						    	}else if(message.equals("Katarina")){
						    		i = 40;
						    	}else if(message.equals("Kayle")){
						    		i = 41;
						    	}else if(message.equals("Kennen")){
						    		i = 42;
						    	}else if(message.equals("Kha Zix")){
						    		i = 43;
						    	}else if(message.equals("Kog Maw")){
						    		i = 44;
						    	}else if(message.equals("LeBlanc")){
						    		i = 45;
						    	}else if(message.equals("Lee Sin")){
						    		i = 46;
						    	}else if(message.equals("Leona")){
						    		i = 47;
						    	}else if(message.equals("Lissandra")){
						    		i = 48;
						    	}else if(message.equals("Lucian")){
						    		i = 49;
						    	}else if(message.equals("Lulu")){
						    		i = 50;
						    	}else if(message.equals("Lux")){
						    		i = 51;
						    	}else if(message.equals("Malphite")){
						    		i = 52;
						    	}else if(message.equals("Malzahar")){
						    		i = 53;
						    	}else if(message.equals("Maokai")){
						    		i = 54;
						    	}else if(message.equals("Master Yi")){
						    		i = 55;
						    	}else if(message.equals("Miss Fortune")){
						    		i = 56;
						    	}else if(message.equals("Mordekaiser")){
						    		i = 57;
						    	}else if(message.equals("Morgana")){
						    		i = 58;
						    	}else if(message.equals("Nami")){
						    		i = 59;
						    	}else if(message.equals("Nasus")){
						    		i = 60;
						    	}else if(message.equals("Nautilus")){
						    		i = 61;
						    	}else if(message.equals("Nidalee")){
						    		i = 62;
						    	}else if(message.equals("Nocturne")){
						    		i = 63;
						    	}else if(message.equals("Nunu")){
						    		i = 64;
						    	}else if(message.equals("Olaf")){
						    		i = 65;
						    	}else if(message.equals("Orianna")){
						    		i = 66;
						    	}else if(message.equals("Pantheon")){
						    		i = 67;
						    	}else if(message.equals("Poppy")){
						    		i = 68;
						    	}else if(message.equals("Quinn")){
						    		i = 69;
						    	}else if(message.equals("Rammus")){
						    		i = 70;
						    	}else if(message.equals("Renekton")){
						    		i = 71;
						    	}else if(message.equals("Rengar")){
						    		i = 72;
						    	}else if(message.equals("Riven")){
						    		i = 73;
						    	}else if(message.equals("Rumble")){
						    		i = 74;
						    	}else if(message.equals("Ryze")){
						    		i = 75;
						    	}else if(message.equals("Sejuani")){
						    		i = 76;
						    	}else if(message.equals("Shaco")){
						    		i = 77;
						    	}else if(message.equals("Shen")){
						    		i = 78;
						    	}else if(message.equals("Shyvana")){
						    		i = 79;
						    	}else if(message.equals("Singed")){
						    		i = 80;
						    	}else if(message.equals("Sion")){
						    		i = 81;
						    	}else if(message.equals("Sivir")){
						    		i = 82;
						    	}else if(message.equals("Skarner")){
						    		i = 83;
						    	}else if(message.equals("Sona")){
						    		i = 84;
						    	}else if(message.equals("Soraka")){
						    		i = 85;
						    	}else if(message.equals("Swain")){
						    		i = 86;
						    	}else if(message.equals("Syndra")){
						    		i = 87;
						    	}else if(message.equals("Talon")){
						    		i = 88;
						    	}else if(message.equals("Taric")){
						    		i = 89;
						    	}else if(message.equals("Teemo")){
						    		i = 90;
						    	}else if(message.equals("Thresh")){
						    		i = 91;
						    	}else if(message.equals("Tristana")){
						    		i = 92;
						    	}else if(message.equals("Trundle")){
						    		i = 93;
						    	}else if(message.equals("Tryndamere")){
						    		i = 94;
						    	}else if(message.equals("Twisted Fate")){
						    		i = 95;
						    	}else if(message.equals("Twitch")){
						    		i = 96;
						    	}else if(message.equals("Udyr")){
						    		i = 97;
						    	}else if(message.equals("Urgot")){
						    		i = 98;
						    	}else if(message.equals("Varus")){
						    		i = 99;
						    	}else if(message.equals("Vayne")){
						    		i = 100;
						    	}else if(message.equals("Veigar")){
						    		i = 101;
						    	}else if(message.equals("Vel Koz")){
						    		i = 102;
						    	}else if(message.equals("Vi")){
						    		i = 103;
						    	}else if(message.equals("Viktor")){
						    		i = 104;
						    	}else if(message.equals("Vladimir")){
						    		i = 105;
						    	}else if(message.equals("Volibear")){
						    		i = 106;
						    	}else if(message.equals("Warwick")){
						    		i = 107;
						    	}else if(message.equals("Wukong")){
						    		i = 108;
						    	}else if(message.equals("Xerath")){
						    		i = 109;
						    	}else if(message.equals("Xin Zhao")){
						    		i = 110;
						    	}else if(message.equals("Yasuo")){
						    		i = 111;
						    	}else if(message.equals("Yorick")){
						    		i = 112;
						    	}else if(message.equals("Zac")){
						    		i = 113;
						    	}else if(message.equals("Zed")){
						    		i = 114;
						    	}else if(message.equals("Ziggs")){
						    		i = 115;
						    	}else if(message.equals("Zilean")){
						    		i = 116;
						    	}else{
						    		i=117;
						    	}

								switch(i){
									case 0: adc.setImageResource(R.drawable.aatrox);
										break;
									case 1: adc.setImageResource(R.drawable.ahri);
										break;
									case 2: adc.setImageResource(R.drawable.akali);
										break;
									case 3: adc.setImageResource(R.drawable.alistar);
										break;
									case 4: adc.setImageResource(R.drawable.amumu);
										break;
									case 5: adc.setImageResource(R.drawable.anivia);
										break;
									case 6: adc.setImageResource(R.drawable.annie);
										break;
									case 7: adc.setImageResource(R.drawable.ashe);
										break;
									case 8: adc.setImageResource(R.drawable.blitzcrank);
										break;
									case 9: adc.setImageResource(R.drawable.brand);
										break;
									case 10: adc.setImageResource(R.drawable.caitlyn);
										break;
									case 11: adc.setImageResource(R.drawable.cassiopeia);
										break;
									case 12: adc.setImageResource(R.drawable.chogath);
										break;
									case 13: adc.setImageResource(R.drawable.corki);
										break;
									case 14: adc.setImageResource(R.drawable.darius);
										break;						
									case 15: adc.setImageResource(R.drawable.diana);
										break;						
									case 16: adc.setImageResource(R.drawable.drmundo);
										break;						
									case 17: adc.setImageResource(R.drawable.draven);
										break;						
									case 18: adc.setImageResource(R.drawable.elise);
										break;						
									case 19: adc.setImageResource(R.drawable.evelynn);
										break;						
									case 20: adc.setImageResource(R.drawable.ezreal);
										break;						
									case 21: adc.setImageResource(R.drawable.fiddlesticks);
										break;						
									case 22: adc.setImageResource(R.drawable.fiora);
										break;						
									case 23: adc.setImageResource(R.drawable.fizz);
										break;						
									case 24: adc.setImageResource(R.drawable.galio);
										break;						
									case 25: adc.setImageResource(R.drawable.gangplank);
										break;						
									case 26: adc.setImageResource(R.drawable.garen);
										break;						
									case 27: adc.setImageResource(R.drawable.gragas);
										break;						
									case 28: adc.setImageResource(R.drawable.graves);
										break;						
									case 29: adc.setImageResource(R.drawable.hecarim);
										break;						
									case 30: adc.setImageResource(R.drawable.heimerdinger);
										break;						
									case 31: adc.setImageResource(R.drawable.irelia);
										break;						
									case 32: adc.setImageResource(R.drawable.janna);
										break;						
									case 33: adc.setImageResource(R.drawable.jarvaniv);
										break;						
									case 34: adc.setImageResource(R.drawable.jax);
										break;						
									case 35: adc.setImageResource(R.drawable.jayce);
										break;						
									case 36: adc.setImageResource(R.drawable.jinx);
										break;						
									case 37: adc.setImageResource(R.drawable.karma);
										break;
									case 38: adc.setImageResource(R.drawable.karthus);
										break;
									case 39: adc.setImageResource(R.drawable.kassadin);
										break;     	
									case 40: adc.setImageResource(R.drawable.katarina);
										break;     	
									case 41: adc.setImageResource(R.drawable.kayle);
										break;     	
									case 42: adc.setImageResource(R.drawable.kennen);
										break;     	
									case 43: adc.setImageResource(R.drawable.khazix);
										break;     	
									case 44: adc.setImageResource(R.drawable.kogmaw);
										break;     	
									case 45: adc.setImageResource(R.drawable.leblanc);
										break;     	
									case 46: adc.setImageResource(R.drawable.leesin);
										break;     	
									case 47: adc.setImageResource(R.drawable.leona);
										break;     	
									case 48: adc.setImageResource(R.drawable.lissandra);
										break;     	
									case 49: adc.setImageResource(R.drawable.lucian);
										break;     	
									case 50: adc.setImageResource(R.drawable.lulu);
										break;     	
									case 51: adc.setImageResource(R.drawable.lux);
										break;     	
									case 52: adc.setImageResource(R.drawable.malphite);
										break;     	
									case 53: adc.setImageResource(R.drawable.malzahar);
										break;     	
									case 54: adc.setImageResource(R.drawable.maokai);
										break;     	
									case 55: adc.setImageResource(R.drawable.masteryi);
										break;     	
									case 56: adc.setImageResource(R.drawable.missfortune);
										break;     	
									case 57: adc.setImageResource(R.drawable.mordekaiser);
										break;     	
									case 58: adc.setImageResource(R.drawable.morgana);
										break;     	
									case 59: adc.setImageResource(R.drawable.nami);
										break;     	
									case 60: adc.setImageResource(R.drawable.nasus);
										break;     	
									case 61: adc.setImageResource(R.drawable.nautilus);
										break;     	
									case 62: adc.setImageResource(R.drawable.nidalee);
										break;     	
									case 63: adc.setImageResource(R.drawable.nocturne);
										break;     	
									case 64: adc.setImageResource(R.drawable.nunu);
										break;     	
									case 65: adc.setImageResource(R.drawable.olaf);
										break;     	
									case 66: adc.setImageResource(R.drawable.orianna);
										break;     	
									case 67: adc.setImageResource(R.drawable.pantheon);
										break;     	
									case 68: adc.setImageResource(R.drawable.poppy);
										break;     	
									case 69: adc.setImageResource(R.drawable.quinn);
										break;     	
									case 70: adc.setImageResource(R.drawable.rammus);
										break;     	
									case 71: adc.setImageResource(R.drawable.renekton);
										break;     	
									case 72: adc.setImageResource(R.drawable.rengar);
										break;     	
									case 73: adc.setImageResource(R.drawable.riven);
										break;     	
									case 74: adc.setImageResource(R.drawable.rumble);
										break;     	
									case 75: adc.setImageResource(R.drawable.ryze);
										break;     	
									case 76: adc.setImageResource(R.drawable.sejuani);
										break;     	
									case 77: adc.setImageResource(R.drawable.shaco);
										break; 		
									case 78: adc.setImageResource(R.drawable.shen);
										break;     			
									case 79: adc.setImageResource(R.drawable.shyvana);
										break;     			
									case 80: adc.setImageResource(R.drawable.singed);
										break;     			
									case 81: adc.setImageResource(R.drawable.sion);
										break;     			
									case 82: adc.setImageResource(R.drawable.sivir);
										break;     			
									case 83: adc.setImageResource(R.drawable.skarner);
										break;     			
									case 84: adc.setImageResource(R.drawable.sona);
										break;     			
									case 85: adc.setImageResource(R.drawable.soraka);
										break;     			
									case 86: adc.setImageResource(R.drawable.swain);
										break;     			
									case 87: adc.setImageResource(R.drawable.syndra);
										break;     			
									case 88: adc.setImageResource(R.drawable.talon);
										break;     			
									case 89: adc.setImageResource(R.drawable.taric);
										break;     			
									case 90: adc.setImageResource(R.drawable.teemo);
										break;     			
									case 91: adc.setImageResource(R.drawable.thresh);
										break;     			
									case 92: adc.setImageResource(R.drawable.tristana);
										break;     			
									case 93: adc.setImageResource(R.drawable.trundle);
										break;     			
									case 94: adc.setImageResource(R.drawable.tryndamere);
										break;     			
									case 95: adc.setImageResource(R.drawable.twistedfate);
										break;     			
									case 96: adc.setImageResource(R.drawable.twitch);
										break;     			
									case 97: adc.setImageResource(R.drawable.udyr);
										break;     			
									case 98: adc.setImageResource(R.drawable.urgot);
										break;     			
									case 99: adc.setImageResource(R.drawable.varus);
										break;     			
									case 100: adc.setImageResource(R.drawable.vayne);
										break;     			
									case 101: adc.setImageResource(R.drawable.veigar);
										break;     			
									case 102: adc.setImageResource(R.drawable.velkoz);
										break;     			
									case 103: adc.setImageResource(R.drawable.vi);
										break;     			
									case 104: adc.setImageResource(R.drawable.viktor);
										break;     			
									case 105: adc.setImageResource(R.drawable.vladimir);
										break;     			
									case 106: adc.setImageResource(R.drawable.volibear);
										break;     			
									case 107: adc.setImageResource(R.drawable.warwick);
										break;     			
									case 108: adc.setImageResource(R.drawable.wukong);
										break;     			
									case 109: adc.setImageResource(R.drawable.xerath);
										break;     			
									case 110: adc.setImageResource(R.drawable.xinzhao);
										break;     			
									case 111: adc.setImageResource(R.drawable.yasuo);
										break;     			
									case 112: adc.setImageResource(R.drawable.yorick);
										break;     			
									case 113: adc.setImageResource(R.drawable.zac);
										break;     			
									case 114: adc.setImageResource(R.drawable.zed);
										break;     			
									case 115: adc.setImageResource(R.drawable.ziggs);
										break;     			
									case 116: adc.setImageResource(R.drawable.zilean);
										break;     			
									case 117: adc.setImageResource(R.drawable.zyra);
										break;     							
									default: 
										break;
									}

							}
							else if (buttonPressFlags[4] == 1){
								teambuilder.setOurTeam(4, currentChampion);
								buttonChangedFlags[4] = 1;
						    	String message = currentChampion.getName();
						    	int i;
						    	
						    	if(message.equals("Aatrox")){
						            i = 0;
								}else if(message.equals("Ahri")){
						            i = 1;
						    	}else if(message.equals("Akali")){
						            i = 2;
						    	}else if(message.equals("Alistar")){
						    		i = 3;
						    	}else if(message.equals("Amumu")){
						    		i = 4;
						    	}else if(message.equals("Anivia")){
						    		i = 5;
						    	}else if(message.equals("Annie")){
						    		i = 6;
						    	}else if(message.equals("Ashe")){
						            i = 7;
						    	}else if(message.equals("Blitzcrank")){
						            i = 8;
						    	}else if(message.equals("Brand")){
						            i = 9;
						    	}else if(message.equals("Caitlyn")){
						    		i = 10;
						    	}else if(message.equals("Cassiopeia")){
						    		i = 11;
						    	}else if(message.equals("Cho Gath")){
						    		i = 12;
						    	}else if(message.equals("Corki")){
						    		i = 13;
						    	}else if(message.equals("Darius")){
						    		i = 14;
						    	}else if(message.equals("Diana")){
						    		i = 15;
						    	}else if(message.equals("Dr. Mundo")){
						    		i = 16;
						    	}else if(message.equals("Draven")){
						    		i = 17;
						    	}else if(message.equals("Elise")){
						    		i = 18;
						    	}else if(message.equals("Evelynn")){
						    		i = 19;
						    	}else if(message.equals("Ezreal")){
						    		i = 20;
						    	}else if(message.equals("Fiddlesticks")){
						    		i = 21;
						    	}else if(message.equals("Fiora")){
						    		i = 22;
						    	}else if(message.equals("Fizz")){
						    		i = 23;
						    	}else if(message.equals("Galio")){
						    		i = 24;
						    	}else if(message.equals("Gangplank")){
						    		i = 25;
						    	}else if(message.equals("Garen")){
						    		i = 26;
						    	}else if(message.equals("Gragas")){
						    		i = 27;
						    	}else if(message.equals("Graves")){
						    		i = 28;
						    	}else if(message.equals("Hecarim")){
						    		i = 29;
						    	}else if(message.equals("Heimerdinger")){
						    		i = 30;
						    	}else if(message.equals("Irelia")){
						    		i = 31;
						    	}else if(message.equals("Janna")){
						    		i = 32;
						    	}else if(message.equals("Jarvan IV")){
						    		i = 33;
						    	}else if(message.equals("Jax")){
						    		i = 34;
						    	}else if(message.equals("Jayce")){
						    		i = 35;
						    	}else if(message.equals("Jinx")){
						    		i = 36;
						    	}else if(message.equals("Karma")){
						    		i = 37;
						    	}else if(message.equals("Karthus")){
						    		i = 38;
						    	}else if(message.equals("Kassadin")){
						    		i = 39;
						    	}else if(message.equals("Katarina")){
						    		i = 40;
						    	}else if(message.equals("Kayle")){
						    		i = 41;
						    	}else if(message.equals("Kennen")){
						    		i = 42;
						    	}else if(message.equals("Kha Zix")){
						    		i = 43;
						    	}else if(message.equals("Kog Maw")){
						    		i = 44;
						    	}else if(message.equals("LeBlanc")){
						    		i = 45;
						    	}else if(message.equals("Lee Sin")){
						    		i = 46;
						    	}else if(message.equals("Leona")){
						    		i = 47;
						    	}else if(message.equals("Lissandra")){
						    		i = 48;
						    	}else if(message.equals("Lucian")){
						    		i = 49;
						    	}else if(message.equals("Lulu")){
						    		i = 50;
						    	}else if(message.equals("Lux")){
						    		i = 51;
						    	}else if(message.equals("Malphite")){
						    		i = 52;
						    	}else if(message.equals("Malzahar")){
						    		i = 53;
						    	}else if(message.equals("Maokai")){
						    		i = 54;
						    	}else if(message.equals("Master Yi")){
						    		i = 55;
						    	}else if(message.equals("Miss Fortune")){
						    		i = 56;
						    	}else if(message.equals("Mordekaiser")){
						    		i = 57;
						    	}else if(message.equals("Morgana")){
						    		i = 58;
						    	}else if(message.equals("Nami")){
						    		i = 59;
						    	}else if(message.equals("Nasus")){
						    		i = 60;
						    	}else if(message.equals("Nautilus")){
						    		i = 61;
						    	}else if(message.equals("Nidalee")){
						    		i = 62;
						    	}else if(message.equals("Nocturne")){
						    		i = 63;
						    	}else if(message.equals("Nunu")){
						    		i = 64;
						    	}else if(message.equals("Olaf")){
						    		i = 65;
						    	}else if(message.equals("Orianna")){
						    		i = 66;
						    	}else if(message.equals("Pantheon")){
						    		i = 67;
						    	}else if(message.equals("Poppy")){
						    		i = 68;
						    	}else if(message.equals("Quinn")){
						    		i = 69;
						    	}else if(message.equals("Rammus")){
						    		i = 70;
						    	}else if(message.equals("Renekton")){
						    		i = 71;
						    	}else if(message.equals("Rengar")){
						    		i = 72;
						    	}else if(message.equals("Riven")){
						    		i = 73;
						    	}else if(message.equals("Rumble")){
						    		i = 74;
						    	}else if(message.equals("Ryze")){
						    		i = 75;
						    	}else if(message.equals("Sejuani")){
						    		i = 76;
						    	}else if(message.equals("Shaco")){
						    		i = 77;
						    	}else if(message.equals("Shen")){
						    		i = 78;
						    	}else if(message.equals("Shyvana")){
						    		i = 79;
						    	}else if(message.equals("Singed")){
						    		i = 80;
						    	}else if(message.equals("Sion")){
						    		i = 81;
						    	}else if(message.equals("Sivir")){
						    		i = 82;
						    	}else if(message.equals("Skarner")){
						    		i = 83;
						    	}else if(message.equals("Sona")){
						    		i = 84;
						    	}else if(message.equals("Soraka")){
						    		i = 85;
						    	}else if(message.equals("Swain")){
						    		i = 86;
						    	}else if(message.equals("Syndra")){
						    		i = 87;
						    	}else if(message.equals("Talon")){
						    		i = 88;
						    	}else if(message.equals("Taric")){
						    		i = 89;
						    	}else if(message.equals("Teemo")){
						    		i = 90;
						    	}else if(message.equals("Thresh")){
						    		i = 91;
						    	}else if(message.equals("Tristana")){
						    		i = 92;
						    	}else if(message.equals("Trundle")){
						    		i = 93;
						    	}else if(message.equals("Tryndamere")){
						    		i = 94;
						    	}else if(message.equals("Twisted Fate")){
						    		i = 95;
						    	}else if(message.equals("Twitch")){
						    		i = 96;
						    	}else if(message.equals("Udyr")){
						    		i = 97;
						    	}else if(message.equals("Urgot")){
						    		i = 98;
						    	}else if(message.equals("Varus")){
						    		i = 99;
						    	}else if(message.equals("Vayne")){
						    		i = 100;
						    	}else if(message.equals("Veigar")){
						    		i = 101;
						    	}else if(message.equals("Vel Koz")){
						    		i = 102;
						    	}else if(message.equals("Vi")){
						    		i = 103;
						    	}else if(message.equals("Viktor")){
						    		i = 104;
						    	}else if(message.equals("Vladimir")){
						    		i = 105;
						    	}else if(message.equals("Volibear")){
						    		i = 106;
						    	}else if(message.equals("Warwick")){
						    		i = 107;
						    	}else if(message.equals("Wukong")){
						    		i = 108;
						    	}else if(message.equals("Xerath")){
						    		i = 109;
						    	}else if(message.equals("Xin Zhao")){
						    		i = 110;
						    	}else if(message.equals("Yasuo")){
						    		i = 111;
						    	}else if(message.equals("Yorick")){
						    		i = 112;
						    	}else if(message.equals("Zac")){
						    		i = 113;
						    	}else if(message.equals("Zed")){
						    		i = 114;
						    	}else if(message.equals("Ziggs")){
						    		i = 115;
						    	}else if(message.equals("Zilean")){
						    		i = 116;
						    	}else{
						    		i=117;
						    	}

								switch(i){
									case 0: support.setImageResource(R.drawable.aatrox);
										break;
									case 1: support.setImageResource(R.drawable.ahri);
										break;
									case 2: support.setImageResource(R.drawable.akali);
										break;
									case 3: support.setImageResource(R.drawable.alistar);
										break;
									case 4: support.setImageResource(R.drawable.amumu);
										break;
									case 5: support.setImageResource(R.drawable.anivia);
										break;
									case 6: support.setImageResource(R.drawable.annie);
										break;
									case 7: support.setImageResource(R.drawable.ashe);
										break;
									case 8: support.setImageResource(R.drawable.blitzcrank);
										break;
									case 9: support.setImageResource(R.drawable.brand);
										break;
									case 10: support.setImageResource(R.drawable.caitlyn);
										break;
									case 11: support.setImageResource(R.drawable.cassiopeia);
										break;
									case 12: support.setImageResource(R.drawable.chogath);
										break;
									case 13: support.setImageResource(R.drawable.corki);
										break;
									case 14: support.setImageResource(R.drawable.darius);
										break;						
									case 15: support.setImageResource(R.drawable.diana);
										break;						
									case 16: support.setImageResource(R.drawable.drmundo);
										break;						
									case 17: support.setImageResource(R.drawable.draven);
										break;						
									case 18: support.setImageResource(R.drawable.elise);
										break;						
									case 19: support.setImageResource(R.drawable.evelynn);
										break;						
									case 20: support.setImageResource(R.drawable.ezreal);
										break;						
									case 21: support.setImageResource(R.drawable.fiddlesticks);
										break;						
									case 22: support.setImageResource(R.drawable.fiora);
										break;						
									case 23: support.setImageResource(R.drawable.fizz);
										break;						
									case 24: support.setImageResource(R.drawable.galio);
										break;						
									case 25: support.setImageResource(R.drawable.gangplank);
										break;						
									case 26: support.setImageResource(R.drawable.garen);
										break;						
									case 27: support.setImageResource(R.drawable.gragas);
										break;						
									case 28: support.setImageResource(R.drawable.graves);
										break;						
									case 29: support.setImageResource(R.drawable.hecarim);
										break;						
									case 30: support.setImageResource(R.drawable.heimerdinger);
										break;						
									case 31: support.setImageResource(R.drawable.irelia);
										break;						
									case 32: support.setImageResource(R.drawable.janna);
										break;						
									case 33: support.setImageResource(R.drawable.jarvaniv);
										break;						
									case 34: support.setImageResource(R.drawable.jax);
										break;						
									case 35: support.setImageResource(R.drawable.jayce);
										break;						
									case 36: support.setImageResource(R.drawable.jinx);
										break;						
									case 37: support.setImageResource(R.drawable.karma);
										break;
									case 38: support.setImageResource(R.drawable.karthus);
										break;
									case 39: support.setImageResource(R.drawable.kassadin);
										break;     	
									case 40: support.setImageResource(R.drawable.katarina);
										break;     	
									case 41: support.setImageResource(R.drawable.kayle);
										break;     	
									case 42: support.setImageResource(R.drawable.kennen);
										break;     	
									case 43: support.setImageResource(R.drawable.khazix);
										break;     	
									case 44: support.setImageResource(R.drawable.kogmaw);
										break;     	
									case 45: support.setImageResource(R.drawable.leblanc);
										break;     	
									case 46: support.setImageResource(R.drawable.leesin);
										break;     	
									case 47: support.setImageResource(R.drawable.leona);
										break;     	
									case 48: support.setImageResource(R.drawable.lissandra);
										break;     	
									case 49: support.setImageResource(R.drawable.lucian);
										break;     	
									case 50: support.setImageResource(R.drawable.lulu);
										break;     	
									case 51: support.setImageResource(R.drawable.lux);
										break;     	
									case 52: support.setImageResource(R.drawable.malphite);
										break;     	
									case 53: support.setImageResource(R.drawable.malzahar);
										break;     	
									case 54: support.setImageResource(R.drawable.maokai);
										break;     	
									case 55: support.setImageResource(R.drawable.masteryi);
										break;     	
									case 56: support.setImageResource(R.drawable.missfortune);
										break;     	
									case 57: support.setImageResource(R.drawable.mordekaiser);
										break;     	
									case 58: support.setImageResource(R.drawable.morgana);
										break;     	
									case 59: support.setImageResource(R.drawable.nami);
										break;     	
									case 60: support.setImageResource(R.drawable.nasus);
										break;     	
									case 61: support.setImageResource(R.drawable.nautilus);
										break;     	
									case 62: support.setImageResource(R.drawable.nidalee);
										break;     	
									case 63: support.setImageResource(R.drawable.nocturne);
										break;     	
									case 64: support.setImageResource(R.drawable.nunu);
										break;     	
									case 65: support.setImageResource(R.drawable.olaf);
										break;     	
									case 66: support.setImageResource(R.drawable.orianna);
										break;     	
									case 67: support.setImageResource(R.drawable.pantheon);
										break;     	
									case 68: support.setImageResource(R.drawable.poppy);
										break;     	
									case 69: support.setImageResource(R.drawable.quinn);
										break;     	
									case 70: support.setImageResource(R.drawable.rammus);
										break;     	
									case 71: support.setImageResource(R.drawable.renekton);
										break;     	
									case 72: support.setImageResource(R.drawable.rengar);
										break;     	
									case 73: support.setImageResource(R.drawable.riven);
										break;     	
									case 74: support.setImageResource(R.drawable.rumble);
										break;     	
									case 75: support.setImageResource(R.drawable.ryze);
										break;     	
									case 76: support.setImageResource(R.drawable.sejuani);
										break;     	
									case 77: support.setImageResource(R.drawable.shaco);
										break; 		
									case 78: support.setImageResource(R.drawable.shen);
										break;     			
									case 79: support.setImageResource(R.drawable.shyvana);
										break;     			
									case 80: support.setImageResource(R.drawable.singed);
										break;     			
									case 81: support.setImageResource(R.drawable.sion);
										break;     			
									case 82: support.setImageResource(R.drawable.sivir);
										break;     			
									case 83: support.setImageResource(R.drawable.skarner);
										break;     			
									case 84: support.setImageResource(R.drawable.sona);
										break;     			
									case 85: support.setImageResource(R.drawable.soraka);
										break;     			
									case 86: support.setImageResource(R.drawable.swain);
										break;     			
									case 87: support.setImageResource(R.drawable.syndra);
										break;     			
									case 88: support.setImageResource(R.drawable.talon);
										break;     			
									case 89: support.setImageResource(R.drawable.taric);
										break;     			
									case 90: support.setImageResource(R.drawable.teemo);
										break;     			
									case 91: support.setImageResource(R.drawable.thresh);
										break;     			
									case 92: support.setImageResource(R.drawable.tristana);
										break;     			
									case 93: support.setImageResource(R.drawable.trundle);
										break;     			
									case 94: support.setImageResource(R.drawable.tryndamere);
										break;     			
									case 95: support.setImageResource(R.drawable.twistedfate);
										break;     			
									case 96: support.setImageResource(R.drawable.twitch);
										break;     			
									case 97: support.setImageResource(R.drawable.udyr);
										break;     			
									case 98: support.setImageResource(R.drawable.urgot);
										break;     			
									case 99: support.setImageResource(R.drawable.varus);
										break;     			
									case 100: support.setImageResource(R.drawable.vayne);
										break;     			
									case 101: support.setImageResource(R.drawable.veigar);
										break;     			
									case 102: support.setImageResource(R.drawable.velkoz);
										break;     			
									case 103: support.setImageResource(R.drawable.vi);
										break;     			
									case 104: support.setImageResource(R.drawable.viktor);
										break;     			
									case 105: support.setImageResource(R.drawable.vladimir);
										break;     			
									case 106: support.setImageResource(R.drawable.volibear);
										break;     			
									case 107: support.setImageResource(R.drawable.warwick);
										break;     			
									case 108: support.setImageResource(R.drawable.wukong);
										break;     			
									case 109: support.setImageResource(R.drawable.xerath);
										break;     			
									case 110: support.setImageResource(R.drawable.xinzhao);
										break;     			
									case 111: support.setImageResource(R.drawable.yasuo);
										break;     			
									case 112: support.setImageResource(R.drawable.yorick);
										break;     			
									case 113: support.setImageResource(R.drawable.zac);
										break;     			
									case 114: support.setImageResource(R.drawable.zed);
										break;     			
									case 115: support.setImageResource(R.drawable.ziggs);
										break;     			
									case 116: support.setImageResource(R.drawable.zilean);
										break;     			
									case 117: support.setImageResource(R.drawable.zyra);
										break;     							
									default: 
										break;
									}

							}
							buttonPressFlags[0] = -1;
							buttonPressFlags[1] = -1;
							buttonPressFlags[2] = -1;
							buttonPressFlags[3] = -1;
							buttonPressFlags[4] = -1;
							newButton.setVisibility(View.GONE);
							suggestChampion.performClick();
				        }
					});
				}
			}
		});
        
        // button Top
        top.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[0] = 1;
				buttonChangedFlags[0] = 0;
				
				buttonPressFlags[1] = -1;
				buttonPressFlags[2] = -1;
				buttonPressFlags[3] = -1;
				buttonPressFlags[4] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(0, emptyChampion);
				top.setImageResource(R.drawable.top);
				suggestChampion.performClick();
			}
		});
        
        // button Jungle
        jungle.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[1] = 1;
				buttonChangedFlags[1] = 0;
				
				buttonPressFlags[0] = -1;
				buttonPressFlags[2] = -1;
				buttonPressFlags[3] = -1;
				buttonPressFlags[4] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(1, emptyChampion);
				jungle.setImageResource(R.drawable.jungle);
				suggestChampion.performClick();
			}
		});
        
        // button Middle
        middle.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[2] = 1;
				buttonChangedFlags[2] = 0;
				
				buttonPressFlags[0] = -1;
				buttonPressFlags[1] = -1;
				buttonPressFlags[3] = -1;
				buttonPressFlags[4] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(2, emptyChampion);
				middle.setImageResource(R.drawable.middle);
				suggestChampion.performClick();
			}
		});
        
        // button ADC
        adc.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[3] = 1;
				buttonChangedFlags[3] = 0;
				
				buttonPressFlags[0] = -1;
				buttonPressFlags[1] = -1;
				buttonPressFlags[2] = -1;
				buttonPressFlags[4] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(3, emptyChampion);
				adc.setImageResource(R.drawable.adc);
				suggestChampion.performClick();
			}
		});
        
        // button Support
        support.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[4] = 1;
				buttonChangedFlags[4] = 0;
				
				buttonPressFlags[0] = -1;
				buttonPressFlags[1] = -1;
				buttonPressFlags[2] = -1;
				buttonPressFlags[3] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(4, emptyChampion);
				support.setImageResource(R.drawable.support);
				suggestChampion.performClick();
			}	
		});
    }

	@Override
	public void onBackPressed() {
	    super.onBackPressed();
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
    
	// Initialization method for automatically generated imagebuttons.
    private ImageButton initializeButton(ImageButton icon, ChampionAttributes champion){
    	icon.setMaxHeight(180);
    	icon.setMaxWidth(180);
    	icon.setMinimumHeight(150);
    	icon.setMinimumWidth(150);
    	icon.setAdjustViewBounds(true);
    	icon.setScaleType(ScaleType.CENTER);
    	String message = champion.getName();
    	int i;
    	
    	if(message.equals("Aatrox")){
            i = 0;
		}else if(message.equals("Ahri")){
            i = 1;
    	}else if(message.equals("Akali")){
            i = 2;
    	}else if(message.equals("Alistar")){
    		i = 3;
    	}else if(message.equals("Amumu")){
    		i = 4;
    	}else if(message.equals("Anivia")){
    		i = 5;
    	}else if(message.equals("Annie")){
    		i = 6;
    	}else if(message.equals("Ashe")){
            i = 7;
    	}else if(message.equals("Blitzcrank")){
            i = 8;
    	}else if(message.equals("Brand")){
            i = 9;
    	}else if(message.equals("Caitlyn")){
    		i = 10;
    	}else if(message.equals("Cassiopeia")){
    		i = 11;
    	}else if(message.equals("Cho Gath")){
    		i = 12;
    	}else if(message.equals("Corki")){
    		i = 13;
    	}else if(message.equals("Darius")){
    		i = 14;
    	}else if(message.equals("Diana")){
    		i = 15;
    	}else if(message.equals("Dr. Mundo")){
    		i = 16;
    	}else if(message.equals("Draven")){
    		i = 17;
    	}else if(message.equals("Elise")){
    		i = 18;
    	}else if(message.equals("Evelynn")){
    		i = 19;
    	}else if(message.equals("Ezreal")){
    		i = 20;
    	}else if(message.equals("Fiddlesticks")){
    		i = 21;
    	}else if(message.equals("Fiora")){
    		i = 22;
    	}else if(message.equals("Fizz")){
    		i = 23;
    	}else if(message.equals("Galio")){
    		i = 24;
    	}else if(message.equals("Gangplank")){
    		i = 25;
    	}else if(message.equals("Garen")){
    		i = 26;
    	}else if(message.equals("Gragas")){
    		i = 27;
    	}else if(message.equals("Graves")){
    		i = 28;
    	}else if(message.equals("Hecarim")){
    		i = 29;
    	}else if(message.equals("Heimerdinger")){
    		i = 30;
    	}else if(message.equals("Irelia")){
    		i = 31;
    	}else if(message.equals("Janna")){
    		i = 32;
    	}else if(message.equals("Jarvan IV")){
    		i = 33;
    	}else if(message.equals("Jax")){
    		i = 34;
    	}else if(message.equals("Jayce")){
    		i = 35;
    	}else if(message.equals("Jinx")){
    		i = 36;
    	}else if(message.equals("Karma")){
    		i = 37;
    	}else if(message.equals("Karthus")){
    		i = 38;
    	}else if(message.equals("Kassadin")){
    		i = 39;
    	}else if(message.equals("Katarina")){
    		i = 40;
    	}else if(message.equals("Kayle")){
    		i = 41;
    	}else if(message.equals("Kennen")){
    		i = 42;
    	}else if(message.equals("Kha Zix")){
    		i = 43;
    	}else if(message.equals("Kog Maw")){
    		i = 44;
    	}else if(message.equals("LeBlanc")){
    		i = 45;
    	}else if(message.equals("Lee Sin")){
    		i = 46;
    	}else if(message.equals("Leona")){
    		i = 47;
    	}else if(message.equals("Lissandra")){
    		i = 48;
    	}else if(message.equals("Lucian")){
    		i = 49;
    	}else if(message.equals("Lulu")){
    		i = 50;
    	}else if(message.equals("Lux")){
    		i = 51;
    	}else if(message.equals("Malphite")){
    		i = 52;
    	}else if(message.equals("Malzahar")){
    		i = 53;
    	}else if(message.equals("Maokai")){
    		i = 54;
    	}else if(message.equals("Master Yi")){
    		i = 55;
    	}else if(message.equals("Miss Fortune")){
    		i = 56;
    	}else if(message.equals("Mordekaiser")){
    		i = 57;
    	}else if(message.equals("Morgana")){
    		i = 58;
    	}else if(message.equals("Nami")){
    		i = 59;
    	}else if(message.equals("Nasus")){
    		i = 60;
    	}else if(message.equals("Nautilus")){
    		i = 61;
    	}else if(message.equals("Nidalee")){
    		i = 62;
    	}else if(message.equals("Nocturne")){
    		i = 63;
    	}else if(message.equals("Nunu")){
    		i = 64;
    	}else if(message.equals("Olaf")){
    		i = 65;
    	}else if(message.equals("Orianna")){
    		i = 66;
    	}else if(message.equals("Pantheon")){
    		i = 67;
    	}else if(message.equals("Poppy")){
    		i = 68;
    	}else if(message.equals("Quinn")){
    		i = 69;
    	}else if(message.equals("Rammus")){
    		i = 70;
    	}else if(message.equals("Renekton")){
    		i = 71;
    	}else if(message.equals("Rengar")){
    		i = 72;
    	}else if(message.equals("Riven")){
    		i = 73;
    	}else if(message.equals("Rumble")){
    		i = 74;
    	}else if(message.equals("Ryze")){
    		i = 75;
    	}else if(message.equals("Sejuani")){
    		i = 76;
    	}else if(message.equals("Shaco")){
    		i = 77;
    	}else if(message.equals("Shen")){
    		i = 78;
    	}else if(message.equals("Shyvana")){
    		i = 79;
    	}else if(message.equals("Singed")){
    		i = 80;
    	}else if(message.equals("Sion")){
    		i = 81;
    	}else if(message.equals("Sivir")){
    		i = 82;
    	}else if(message.equals("Skarner")){
    		i = 83;
    	}else if(message.equals("Sona")){
    		i = 84;
    	}else if(message.equals("Soraka")){
    		i = 85;
    	}else if(message.equals("Swain")){
    		i = 86;
    	}else if(message.equals("Syndra")){
    		i = 87;
    	}else if(message.equals("Talon")){
    		i = 88;
    	}else if(message.equals("Taric")){
    		i = 89;
    	}else if(message.equals("Teemo")){
    		i = 90;
    	}else if(message.equals("Thresh")){
    		i = 91;
    	}else if(message.equals("Tristana")){
    		i = 92;
    	}else if(message.equals("Trundle")){
    		i = 93;
    	}else if(message.equals("Tryndamere")){
    		i = 94;
    	}else if(message.equals("Twisted Fate")){
    		i = 95;
    	}else if(message.equals("Twitch")){
    		i = 96;
    	}else if(message.equals("Udyr")){
    		i = 97;
    	}else if(message.equals("Urgot")){
    		i = 98;
    	}else if(message.equals("Varus")){
    		i = 99;
    	}else if(message.equals("Vayne")){
    		i = 100;
    	}else if(message.equals("Veigar")){
    		i = 101;
    	}else if(message.equals("Vel Koz")){
    		i = 102;
    	}else if(message.equals("Vi")){
    		i = 103;
    	}else if(message.equals("Viktor")){
    		i = 104;
    	}else if(message.equals("Vladimir")){
    		i = 105;
    	}else if(message.equals("Volibear")){
    		i = 106;
    	}else if(message.equals("Warwick")){
    		i = 107;
    	}else if(message.equals("Wukong")){
    		i = 108;
    	}else if(message.equals("Xerath")){
    		i = 109;
    	}else if(message.equals("Xin Zhao")){
    		i = 110;
    	}else if(message.equals("Yasuo")){
    		i = 111;
    	}else if(message.equals("Yorick")){
    		i = 112;
    	}else if(message.equals("Zac")){
    		i = 113;
    	}else if(message.equals("Zed")){
    		i = 114;
    	}else if(message.equals("Ziggs")){
    		i = 115;
    	}else if(message.equals("Zilean")){
    		i = 116;
    	}else{
    		i=117;
    	}

		switch(i){
			case 0: icon.setImageResource(R.drawable.aatrox);
				break;
			case 1: icon.setImageResource(R.drawable.ahri);
				break;
			case 2: icon.setImageResource(R.drawable.akali);
				break;
			case 3: icon.setImageResource(R.drawable.alistar);
				break;
			case 4: icon.setImageResource(R.drawable.amumu);
				break;
			case 5: icon.setImageResource(R.drawable.anivia);
				break;
			case 6: icon.setImageResource(R.drawable.annie);
				break;
			case 7: icon.setImageResource(R.drawable.ashe);
				break;
			case 8: icon.setImageResource(R.drawable.blitzcrank);
				break;
			case 9: icon.setImageResource(R.drawable.brand);
				break;
			case 10: icon.setImageResource(R.drawable.caitlyn);
				break;
			case 11: icon.setImageResource(R.drawable.cassiopeia);
				break;
			case 12: icon.setImageResource(R.drawable.chogath);
				break;
			case 13: icon.setImageResource(R.drawable.corki);
				break;
			case 14: icon.setImageResource(R.drawable.darius);
				break;						
			case 15: icon.setImageResource(R.drawable.diana);
				break;						
			case 16: icon.setImageResource(R.drawable.drmundo);
				break;						
			case 17: icon.setImageResource(R.drawable.draven);
				break;						
			case 18: icon.setImageResource(R.drawable.elise);
				break;						
			case 19: icon.setImageResource(R.drawable.evelynn);
				break;						
			case 20: icon.setImageResource(R.drawable.ezreal);
				break;						
			case 21: icon.setImageResource(R.drawable.fiddlesticks);
				break;						
			case 22: icon.setImageResource(R.drawable.fiora);
				break;						
			case 23: icon.setImageResource(R.drawable.fizz);
				break;						
			case 24: icon.setImageResource(R.drawable.galio);
				break;						
			case 25: icon.setImageResource(R.drawable.gangplank);
				break;						
			case 26: icon.setImageResource(R.drawable.garen);
				break;						
			case 27: icon.setImageResource(R.drawable.gragas);
				break;						
			case 28: icon.setImageResource(R.drawable.graves);
				break;						
			case 29: icon.setImageResource(R.drawable.hecarim);
				break;						
			case 30: icon.setImageResource(R.drawable.heimerdinger);
				break;						
			case 31: icon.setImageResource(R.drawable.irelia);
				break;						
			case 32: icon.setImageResource(R.drawable.janna);
				break;						
			case 33: icon.setImageResource(R.drawable.jarvaniv);
				break;						
			case 34: icon.setImageResource(R.drawable.jax);
				break;						
			case 35: icon.setImageResource(R.drawable.jayce);
				break;						
			case 36: icon.setImageResource(R.drawable.jinx);
				break;						
			case 37: icon.setImageResource(R.drawable.karma);
				break;
			case 38: icon.setImageResource(R.drawable.karthus);
				break;
			case 39: icon.setImageResource(R.drawable.kassadin);
				break;     	
			case 40: icon.setImageResource(R.drawable.katarina);
				break;     	
			case 41: icon.setImageResource(R.drawable.kayle);
				break;     	
			case 42: icon.setImageResource(R.drawable.kennen);
				break;     	
			case 43: icon.setImageResource(R.drawable.khazix);
				break;     	
			case 44: icon.setImageResource(R.drawable.kogmaw);
				break;     	
			case 45: icon.setImageResource(R.drawable.leblanc);
				break;     	
			case 46: icon.setImageResource(R.drawable.leesin);
				break;     	
			case 47: icon.setImageResource(R.drawable.leona);
				break;     	
			case 48: icon.setImageResource(R.drawable.lissandra);
				break;     	
			case 49: icon.setImageResource(R.drawable.lucian);
				break;     	
			case 50: icon.setImageResource(R.drawable.lulu);
				break;     	
			case 51: icon.setImageResource(R.drawable.lux);
				break;     	
			case 52: icon.setImageResource(R.drawable.malphite);
				break;     	
			case 53: icon.setImageResource(R.drawable.malzahar);
				break;     	
			case 54: icon.setImageResource(R.drawable.maokai);
				break;     	
			case 55: icon.setImageResource(R.drawable.masteryi);
				break;     	
			case 56: icon.setImageResource(R.drawable.missfortune);
				break;     	
			case 57: icon.setImageResource(R.drawable.mordekaiser);
				break;     	
			case 58: icon.setImageResource(R.drawable.morgana);
				break;     	
			case 59: icon.setImageResource(R.drawable.nami);
				break;     	
			case 60: icon.setImageResource(R.drawable.nasus);
				break;     	
			case 61: icon.setImageResource(R.drawable.nautilus);
				break;     	
			case 62: icon.setImageResource(R.drawable.nidalee);
				break;     	
			case 63: icon.setImageResource(R.drawable.nocturne);
				break;     	
			case 64: icon.setImageResource(R.drawable.nunu);
				break;     	
			case 65: icon.setImageResource(R.drawable.olaf);
				break;     	
			case 66: icon.setImageResource(R.drawable.orianna);
				break;     	
			case 67: icon.setImageResource(R.drawable.pantheon);
				break;     	
			case 68: icon.setImageResource(R.drawable.poppy);
				break;     	
			case 69: icon.setImageResource(R.drawable.quinn);
				break;     	
			case 70: icon.setImageResource(R.drawable.rammus);
				break;     	
			case 71: icon.setImageResource(R.drawable.renekton);
				break;     	
			case 72: icon.setImageResource(R.drawable.rengar);
				break;     	
			case 73: icon.setImageResource(R.drawable.riven);
				break;     	
			case 74: icon.setImageResource(R.drawable.rumble);
				break;     	
			case 75: icon.setImageResource(R.drawable.ryze);
				break;     	
			case 76: icon.setImageResource(R.drawable.sejuani);
				break;     	
			case 77: icon.setImageResource(R.drawable.shaco);
				break; 		
			case 78: icon.setImageResource(R.drawable.shen);
				break;     			
			case 79: icon.setImageResource(R.drawable.shyvana);
				break;     			
			case 80: icon.setImageResource(R.drawable.singed);
				break;     			
			case 81: icon.setImageResource(R.drawable.sion);
				break;     			
			case 82: icon.setImageResource(R.drawable.sivir);
				break;     			
			case 83: icon.setImageResource(R.drawable.skarner);
				break;     			
			case 84: icon.setImageResource(R.drawable.sona);
				break;     			
			case 85: icon.setImageResource(R.drawable.soraka);
				break;     			
			case 86: icon.setImageResource(R.drawable.swain);
				break;     			
			case 87: icon.setImageResource(R.drawable.syndra);
				break;     			
			case 88: icon.setImageResource(R.drawable.talon);
				break;     			
			case 89: icon.setImageResource(R.drawable.taric);
				break;     			
			case 90: icon.setImageResource(R.drawable.teemo);
				break;     			
			case 91: icon.setImageResource(R.drawable.thresh);
				break;     			
			case 92: icon.setImageResource(R.drawable.tristana);
				break;     			
			case 93: icon.setImageResource(R.drawable.trundle);
				break;     			
			case 94: icon.setImageResource(R.drawable.tryndamere);
				break;     			
			case 95: icon.setImageResource(R.drawable.twistedfate);
				break;     			
			case 96: icon.setImageResource(R.drawable.twitch);
				break;     			
			case 97: icon.setImageResource(R.drawable.udyr);
				break;     			
			case 98: icon.setImageResource(R.drawable.urgot);
				break;     			
			case 99: icon.setImageResource(R.drawable.varus);
				break;     			
			case 100: icon.setImageResource(R.drawable.vayne);
				break;     			
			case 101: icon.setImageResource(R.drawable.veigar);
				break;     			
			case 102: icon.setImageResource(R.drawable.velkoz);
				break;     			
			case 103: icon.setImageResource(R.drawable.vi);
				break;     			
			case 104: icon.setImageResource(R.drawable.viktor);
				break;     			
			case 105: icon.setImageResource(R.drawable.vladimir);
				break;     			
			case 106: icon.setImageResource(R.drawable.volibear);
				break;     			
			case 107: icon.setImageResource(R.drawable.warwick);
				break;     			
			case 108: icon.setImageResource(R.drawable.wukong);
				break;     			
			case 109: icon.setImageResource(R.drawable.xerath);
				break;     			
			case 110: icon.setImageResource(R.drawable.xinzhao);
				break;     			
			case 111: icon.setImageResource(R.drawable.yasuo);
				break;     			
			case 112: icon.setImageResource(R.drawable.yorick);
				break;     			
			case 113: icon.setImageResource(R.drawable.zac);
				break;     			
			case 114: icon.setImageResource(R.drawable.zed);
				break;     			
			case 115: icon.setImageResource(R.drawable.ziggs);
				break;     			
			case 116: icon.setImageResource(R.drawable.zilean);
				break;     			
			case 117: icon.setImageResource(R.drawable.zyra);
				break;     							
			default: 
				break;
			}

    	return icon;
    }
}
