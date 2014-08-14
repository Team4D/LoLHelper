package com.fourfoureight.lolhelper;


import com.fourfoureight.lolhelper.*;
import com.fourfoureight.lolhelper.General_Info.*;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class Items extends ActionBarActivity {

	static String EXTRA_MESSAGE = "";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_items);
		
        LinearLayout layout = (LinearLayout)findViewById(R.id.container);
        if (((GlobalVariables) this.getApplication()).getskin() == 1)
    	{
    		layout.setBackgroundResource(R.drawable.bg);
    	}
    	if (((GlobalVariables) this.getApplication()).getskin() == 2)
    	{
    		layout.setBackgroundResource(R.drawable.bg2);
    	}
		
		
		items.runMain();


        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                          this, R.array.item_array, R.layout.spinner_item);
                        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
                        final ImageView icon = (ImageView)findViewById(R.id.icon);
                        int i = 0;

                        
                        Spinner s = (Spinner) findViewById( R.id.spinner1 );
                        s.setAdapter( adapter );
                        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                                 

                                
                                @Override
                                public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                                        EXTRA_MESSAGE = adapter.getItemAtPosition(i).toString();
                                       
                                        if(EXTRA_MESSAGE.equals("Abyssal Scepter")){
                                            i = 0;
                             			}else if(EXTRA_MESSAGE.equals("Aegis of the Legion")){
                                            i = 1;
                                    	}else if(EXTRA_MESSAGE.equals("Aether Wisp")){
                                            i = 2;
                                    	}else if(EXTRA_MESSAGE.equals("Amplifying Tome")){
                                    		i = 3;
                                    	}else if(EXTRA_MESSAGE.equals("Ancient Coin")){
                                    		i = 4;
                                    	}else if(EXTRA_MESSAGE.equals("Archangels Staff")){
                                    		i = 5;
                                    	}else if(EXTRA_MESSAGE.equals("Athenes Unholy Grail")){
                                    		i = 6;
                                    	}else if(EXTRA_MESSAGE.equals("Atmas Impaler")){
                                            i = 7;
                                    	}else if(EXTRA_MESSAGE.equals("Augment: Death")){
                                            i = 8;
                                    	}else if(EXTRA_MESSAGE.equals("Augment: Gravity")){
                                            i = 9;
                                    	}else if(EXTRA_MESSAGE.equals("Augment: Power")){
                                    		i = 10;
                                    	}else if(EXTRA_MESSAGE.equals("B.F. Sword")){
                                    		i = 11;
                                    	}else if(EXTRA_MESSAGE.equals("Banner of Command")){
                                    		i = 12;
                                    	}else if(EXTRA_MESSAGE.equals("Banshees Veil")){
                                    		i = 13;
                                    	}else if(EXTRA_MESSAGE.equals("Berserkers Greaves")){
                                    		i = 14;
                                    	}else if(EXTRA_MESSAGE.equals("Bilgewater Cutlass")){
                                    		i = 15;
                                    	}else if(EXTRA_MESSAGE.equals("Blackfire Torch")){
                                    		i = 16;
                                    	}else if(EXTRA_MESSAGE.equals("Blade of the Ruined King")){
                                    		i = 17;
                                    	}else if(EXTRA_MESSAGE.equals("Blasting Wand")){
                                    		i = 18;
                                    	}else if(EXTRA_MESSAGE.equals("Bonetooth Necklace (Blue)")){
                                    		i = 19;
                                    	}else if(EXTRA_MESSAGE.equals("Bonetooth Necklace (Green)")){
                                    		i = 20;
                                    	}else if(EXTRA_MESSAGE.equals("Bonetooth Necklace (Red)")){
                                    		i = 21;
                                    	}else if(EXTRA_MESSAGE.equals("Bonetooth Necklace (Yellow)")){
                                    		i = 22;
                                    	}else if(EXTRA_MESSAGE.equals("Boots of Mobility")){
                                    		i = 23;
                                    	}else if(EXTRA_MESSAGE.equals("Boots of Speed")){
                                    		i = 24;
                                    	}else if(EXTRA_MESSAGE.equals("Boots of Swiftness")){
                                    		i = 25;
                                    	}else if(EXTRA_MESSAGE.equals("Brawlers Gloves")){
                                    		i = 26;
                                    	}else if(EXTRA_MESSAGE.equals("Catalyst the Protector")){
                                    		i = 27;
                                    	}else if(EXTRA_MESSAGE.equals("Chain Vest")){
                                    		i = 28;
                                    	}else if(EXTRA_MESSAGE.equals("Chalice of Harmony")){
                                    		i = 29;
                                    	}else if(EXTRA_MESSAGE.equals("Cloak of Agility")){
                                    		i = 30;
                                    	}else if(EXTRA_MESSAGE.equals("Cloth Armor")){
                                    		i = 31;
                                    	}else if(EXTRA_MESSAGE.equals("Crystalline Flask")){
                                    		i = 32;
                                    	}else if(EXTRA_MESSAGE.equals("Dagger")){
                                    		i = 33;
                                    	}else if(EXTRA_MESSAGE.equals("Deathfire Grasp")){
                                    		i = 34;
                                    	}else if(EXTRA_MESSAGE.equals("Dervish Blade")){
                                    		i = 35;
                                    	}else if(EXTRA_MESSAGE.equals("Dorans Blade")){
                                    		i = 36;
                                    	}else if(EXTRA_MESSAGE.equals("Dorans Ring")){
                                    		i = 37;
                                    	}else if(EXTRA_MESSAGE.equals("Dorans Shield")){
                                    		i = 38;
                                    	}else if(EXTRA_MESSAGE.equals("Elixir of Brilliance")){
                                    		i = 39;
                                    	}else if(EXTRA_MESSAGE.equals("Elixir of Fortitude")){
                                    		i = 40;
                                    	}else if(EXTRA_MESSAGE.equals("Enchantment: Alacrity")){
                                    		i = 41;
                                    	}else if(EXTRA_MESSAGE.equals("Enchantment: Captain")){
                                    		i = 42;
                                    	}else if(EXTRA_MESSAGE.equals("Enchantment: Distortion")){
                                    		i = 43;
                                    	}else if(EXTRA_MESSAGE.equals("Enchantment: Furor")){
                                    		i = 44;
                                    	}else if(EXTRA_MESSAGE.equals("Enchantment: Homeguard")){
                                    		i = 45;
                                    	}else if(EXTRA_MESSAGE.equals("Entropy")){
                                    		i = 46;
                                    	}else if(EXTRA_MESSAGE.equals("Executioner�s Calling")){
                                    		i = 47;
                                    	}else if(EXTRA_MESSAGE.equals("Explorers Ward")){
                                    		i = 48;
                                    	}else if(EXTRA_MESSAGE.equals("Face of the Mountain")){
                                    		i = 49;
                                    	}else if(EXTRA_MESSAGE.equals("Faerie Charm")){
                                    		i = 50;
                                    	}else if(EXTRA_MESSAGE.equals("Farsight Orb")){
                                    		i = 51;
                                    	}else if(EXTRA_MESSAGE.equals("Feral Flare")){
                                    		i = 52;
                                    	}else if(EXTRA_MESSAGE.equals("Fiendish Codex")){
                                    		i = 53;
                                    	}else if(EXTRA_MESSAGE.equals("Forbidden Idol")){
                                    		i = 54;
                                    	}else if(EXTRA_MESSAGE.equals("Frost Queen�s Claim")){
                                    		i = 55;
                                    	}else if(EXTRA_MESSAGE.equals("Frostfang")){
                                    		i = 56;
                                    	}else if(EXTRA_MESSAGE.equals("Frozen Heart")){
                                    		i = 57;
                                    	}else if(EXTRA_MESSAGE.equals("Frozen Mallet")){
                                    		i = 58;
                                    	}else if(EXTRA_MESSAGE.equals("Giants Belt")){
                                    		i = 59;
                                    	}else if(EXTRA_MESSAGE.equals("Glacial Shroud")){
                                    		i = 60;
                                    	}else if(EXTRA_MESSAGE.equals("Greater Stealth Totem")){
                                    		i = 61;
                                    	}else if(EXTRA_MESSAGE.equals("Greater Vision Totem")){
                                    		i = 62;
                                    	}else if(EXTRA_MESSAGE.equals("Grezs Spectral Lantern")){
                                    		i = 63;
                                    	}else if(EXTRA_MESSAGE.equals("Guardian Angel")){
                                    		i = 64;
                                    	}else if(EXTRA_MESSAGE.equals("Guardians Horn")){
                                    		i = 65;
                                    	}else if(EXTRA_MESSAGE.equals("Guinsoos Rageblade")){
                                    		i = 66;
                                    	}else if(EXTRA_MESSAGE.equals("Haunting Guise")){
                                    		i = 67;
                                    	}else if(EXTRA_MESSAGE.equals("Health Potion")){
                                    		i = 69;
                                    	}else if(EXTRA_MESSAGE.equals("Hexdrinker")){
                                    		i = 70;
                                    	}else if(EXTRA_MESSAGE.equals("Hextech Gunblade")){
                                    		i = 71;
                                    	}else if(EXTRA_MESSAGE.equals("Hextech Sweeper")){
                                    		i = 72;
                                    	}else if(EXTRA_MESSAGE.equals("Hunters Machete")){
                                    		i = 73;
                                    	}else if(EXTRA_MESSAGE.equals("Iceborn Gauntlet")){
                                    		i = 74;
                                    	}else if(EXTRA_MESSAGE.equals("Ichor of Illumination")){
                                    		i = 75;
                                    	}else if(EXTRA_MESSAGE.equals("Ichor of Rage")){
                                    		i = 76;
                                    	}else if(EXTRA_MESSAGE.equals("Infinity Edge")){
                                    		i = 77;
                                    	}else if(EXTRA_MESSAGE.equals("Ionian Boots of Lucidity")){
                                    		i = 78;
                                    	}else if(EXTRA_MESSAGE.equals("Kindlegem")){
                                    		i = 79;
                                    	}else if(EXTRA_MESSAGE.equals("Kitaes Bloodrazor")){ //inaccessible
                                    		i = 80;
                                    	}else if(EXTRA_MESSAGE.equals("Last Whisper")){
                                    		i = 81;
                                    	}else if(EXTRA_MESSAGE.equals("Liandry�s Torment")){
                                    		i = 82;
                                    	}else if(EXTRA_MESSAGE.equals("Lich Bane")){
                                    		i = 83;
                                    	}else if(EXTRA_MESSAGE.equals("Locket of the Iron Solari")){
                                    		i = 84;
                                    	}else if(EXTRA_MESSAGE.equals("Long Sword")){
                                    		i = 85;
                                    	}else if(EXTRA_MESSAGE.equals("Lord Van Damms Pillager")){
                                    		i = 86;
                                    	}else if(EXTRA_MESSAGE.equals("Madreds Razors")){
                                    		i = 87;
                                    	}else if(EXTRA_MESSAGE.equals("Mana Manipulator")){ //inaccessible
                                    		i = 88;
                                    	}else if(EXTRA_MESSAGE.equals("Mana Potion")){
                                    		i = 89;
                                    	}else if(EXTRA_MESSAGE.equals("Manamune")){
                                    		i = 90;
                                    	}else if(EXTRA_MESSAGE.equals("Maw of Malmortius")){
                                    		i = 91;
                                    	}else if(EXTRA_MESSAGE.equals("Mejais Soulstealer")){
                                    		i = 92;
                                    	}else if(EXTRA_MESSAGE.equals("Mercurial Scimitar")){
                                    		i = 93;
                                    	}else if(EXTRA_MESSAGE.equals("Mercurys Treads")){
                                    		i = 94;
                                    	}else if(EXTRA_MESSAGE.equals("Mikaels Crucible")){
                                    		i = 95;
                                    	}else if(EXTRA_MESSAGE.equals("Moonflair Spellblade")){
                                    		i = 96;
                                    	}else if(EXTRA_MESSAGE.equals("Morellonomicon")){
                                    		i = 97;
                                    	}else if(EXTRA_MESSAGE.equals("Muramana")){
                                    		i = 98;
                                    	}else if(EXTRA_MESSAGE.equals("Nashor�s Tooth")){
                                    		i = 99;
                                    	}else if(EXTRA_MESSAGE.equals("Needlessly Large Rod")){
                                    		i = 100;
                                    	}else if(EXTRA_MESSAGE.equals("Negatron Cloak")){
                                    		i = 101;
                                    	}else if(EXTRA_MESSAGE.equals("Ninja Tabi")){
                                    		i = 102;
                                    	}else if(EXTRA_MESSAGE.equals("Nomads Medallion")){
                                    		i = 103;
                                    	}else if(EXTRA_MESSAGE.equals("Null-Magic Mantle")){
                                    		i = 104;
                                    	}else if(EXTRA_MESSAGE.equals("Odyns Veil")){
                                    		i = 105;
                                    	}else if(EXTRA_MESSAGE.equals("Ohmwrecker")){
                                    		i = 106;
                                    	}else if(EXTRA_MESSAGE.equals("Oracles Extract")){
                                    		i = 107;
                                    	}else if(EXTRA_MESSAGE.equals("Oracles Lens")){
                                    		i = 108;
                                    	}else if(EXTRA_MESSAGE.equals("Orb of Winter")){
                                    		i = 109;
                                    	}else if(EXTRA_MESSAGE.equals("Overlords Bloodmail")){
                                    		i = 110;
                                    	}else if(EXTRA_MESSAGE.equals("Phage")){
                                    		i = 111;
                                    	}else if(EXTRA_MESSAGE.equals("Phantom Dancer")){
                                    		i = 112;
                                    	}else if(EXTRA_MESSAGE.equals("Pickaxe")){
                                    		i = 113;
                                    	}else if(EXTRA_MESSAGE.equals("Poro-Snax")){
                                    		i = 114;
                                    	}else if(EXTRA_MESSAGE.equals("Prospectors Blade")){
                                    		i = 115;
                                    	}else if(EXTRA_MESSAGE.equals("Prospectors Ring")){
                                    		i = 116;
                                    	}else if(EXTRA_MESSAGE.equals("Quicksilver Sash")){
                                    		i = 117;
                                    	}else if(EXTRA_MESSAGE.equals("Rabadons Deathcap")){
                                    		i = 118;
                                    	}else if(EXTRA_MESSAGE.equals("Randuin�s Omen")){
                                    		i = 119;
                                    	}else if(EXTRA_MESSAGE.equals("Ravenous Hydra")){
                                    		i = 120;
                                    	}else if(EXTRA_MESSAGE.equals("Recurve Bow")){
                                    		i = 121;
                                    	}else if(EXTRA_MESSAGE.equals("Rejuvenation Bead")){
                                    		i = 122;
                                    	}else if(EXTRA_MESSAGE.equals("Relic Shield")){
                                    		i = 123;
                                    	}else if(EXTRA_MESSAGE.equals("Rod of Ages")){
                                    		i = 124;
                                    	}else if(EXTRA_MESSAGE.equals("Ruby Crystal")){
                                    		i = 125;
                                    	}else if(EXTRA_MESSAGE.equals("Ruby Sightstone")){
                                    		i = 126;
                                    	}else if(EXTRA_MESSAGE.equals("Runaans Hurricane")){
                                    		i = 127;
                                    	}else if(EXTRA_MESSAGE.equals("Rylais Crystal Scepter")){
                                    		i = 128;
                                    	}else if(EXTRA_MESSAGE.equals("Sanguine Blade")){
                                    		i = 129;
                                    	}else if(EXTRA_MESSAGE.equals("Sapphire Crystal")){
                                    		i = 130;
                                    	}else if(EXTRA_MESSAGE.equals("Scrying Orb")){
                                    		i = 131;
                                    	}else if(EXTRA_MESSAGE.equals("Seekers Armguard")){
                                    		i = 132;
                                    	}else if(EXTRA_MESSAGE.equals("Seraphs Embrace")){
                                    		i = 133;
                                    	}else if(EXTRA_MESSAGE.equals("Sheen")){
                                    		i = 134;
                                    	}else if(EXTRA_MESSAGE.equals("Sightstone")){
                                    		i = 135;
                                    	}else if(EXTRA_MESSAGE.equals("Sorcerers Shoes")){
                                    		i = 136;
                                    	}else if(EXTRA_MESSAGE.equals("Spectres Cowl")){
                                    		i = 137;
                                    	}else if(EXTRA_MESSAGE.equals("Spellthiefs Edge")){
                                    		i = 138;
                                    	}else if(EXTRA_MESSAGE.equals("Spirit of the Ancient Golem")){
                                    		i = 139;
                                    	}else if(EXTRA_MESSAGE.equals("Spirit of the Elder Lizard")){
                                    		i = 140;
                                    	}else if(EXTRA_MESSAGE.equals("Spirit of the Spectral Wraith")){
                                    		i = 141;
                                    	}else if(EXTRA_MESSAGE.equals("Spirit Stone")){
                                    		i = 142;
                                    	}else if(EXTRA_MESSAGE.equals("Spirit Visage")){
                                    		i = 143;
                                    	}else if(EXTRA_MESSAGE.equals("Statikk Shiv")){
                                    		i = 144;
                                    	}else if(EXTRA_MESSAGE.equals("Stealth Ward")){
                                    		i = 145;
                                    	}else if(EXTRA_MESSAGE.equals("Stinger")){
                                    		i = 146;
                                    	}else if(EXTRA_MESSAGE.equals("Sunfire Cape")){
                                    		i = 147;
                                    	}else if(EXTRA_MESSAGE.equals("Sweeping Lens")){
                                    		i = 148;
                                    	}else if(EXTRA_MESSAGE.equals("Sword of the Divine")){
                                    		i = 149;
                                    	}else if(EXTRA_MESSAGE.equals("Sword of the Occult")){
                                    		i = 150;
                                    	}else if(EXTRA_MESSAGE.equals("Talisman of Ascension")){
                                    		i = 151;
                                    	}else if(EXTRA_MESSAGE.equals("Targons Brace")){
                                    		i = 152;
                                    	}else if(EXTRA_MESSAGE.equals("Tear of the Goddess")){
                                    		i = 153;
                                    	}else if(EXTRA_MESSAGE.equals("The Black Cleaver")){
                                    		i = 154;
                                    	}else if(EXTRA_MESSAGE.equals("The Bloodthrister")){
                                    		i = 155;
                                    	}else if(EXTRA_MESSAGE.equals("The Brutalizer")){
                                    		i = 156;
                                    	}else if(EXTRA_MESSAGE.equals("The Hex Core")){
                                    		i = 157;
                                    	}else if(EXTRA_MESSAGE.equals("The Lightbringer")){
                                    		i = 158;
                                    	}else if(EXTRA_MESSAGE.equals("Thornmail")){
                                    		i = 159;
                                    	}else if(EXTRA_MESSAGE.equals("Tiamat")){
                                    		i = 160;
                                    	}else if(EXTRA_MESSAGE.equals("Total Biscuit of Rejuvenation")){
                                    		i = 161;
                                    	}else if(EXTRA_MESSAGE.equals("Trinity Force")){
                                    		i = 162;
                                    	}else if(EXTRA_MESSAGE.equals("Twin Shadows")){
                                    		i = 163;
                                    	}else if(EXTRA_MESSAGE.equals("Vampiric Scepter")){
                                    		i = 164;
                                    	}else if(EXTRA_MESSAGE.equals("Vision Ward")){
                                    		i = 165;
                                    	}else if(EXTRA_MESSAGE.equals("Void Staff")){
                                    		i = 166;
                        				}else if(EXTRA_MESSAGE.equals("Wardens Mail")){
                        					i = 167;
                                    	}else if(EXTRA_MESSAGE.equals("Warding Totem")){
                                    		i = 168;
                                    	}else if(EXTRA_MESSAGE.equals("Warmogs Armor")){
                                    		i = 169;
                                    	}else if(EXTRA_MESSAGE.equals("Wicked Hatchet")){
                                    		i = 170;
                                    	}else if(EXTRA_MESSAGE.equals("Will of the Ancients")){
                                    		i = 171;
                                    	}else if(EXTRA_MESSAGE.equals("Wits End")){
                                    		i = 172;
                                    	}else if(EXTRA_MESSAGE.equals("Wooglets Witchcap")){
                                    		i = 173;
                                    	}else if(EXTRA_MESSAGE.equals("Wriggles Lantern")){
                                    		i = 174;
                                    	}else if(EXTRA_MESSAGE.equals("Youmuus Ghostblade")){
                                    		i = 175;
                                    	}else if(EXTRA_MESSAGE.equals("Zeal")){
                                    		i = 176;
                                    	}else if(EXTRA_MESSAGE.equals("Zekes Herald")){
                                    		i = 177;
                                    	}else if(EXTRA_MESSAGE.equals("Zephyr")){
                                    		i = 178;
                                    	}else{
                                    		i = 179;
                                    	}
                        			     				
                             			switch(i){
                             			case 0: icon.setImageResource(R.drawable.abyssalscepter);
                             					break;
                             			case 1: icon.setImageResource(R.drawable.aegisofthelegion);
                        						break;
                             			case 2: icon.setImageResource(R.drawable.aetherwisp);
                        						break;
                             			case 3: icon.setImageResource(R.drawable.amplifyingtome);
                        						break;
                             			case 4: icon.setImageResource(R.drawable.ancientcoin);
                             					break;
                             			case 5: icon.setImageResource(R.drawable.archangelsstaff);
                             					break;
                             			case 6: icon.setImageResource(R.drawable.athenesunholygrail);
                             					break;
                             			case 7: icon.setImageResource(R.drawable.atmasimpaler);
                             					break;
                             			case 8: icon.setImageResource(R.drawable.viktor2);
                             					break;
                             			case 9: icon.setImageResource(R.drawable.viktor4);
                             					break;
                             			case 10: icon.setImageResource(R.drawable.viktor6);
                             					break;
                             			case 11: icon.setImageResource(R.drawable.bfsword);
                             					break;
                             			case 12: icon.setImageResource(R.drawable.bannerofcommand);
                             					break;
                             			case 13: icon.setImageResource(R.drawable.bansheesveil);
                        						break;
                             			case 14: icon.setImageResource(R.drawable.berserkergreaves);
                             					break;						
                             			case 15: icon.setImageResource(R.drawable.bilgewatercutlass);
                        						break;						
                             			case 16: icon.setImageResource(R.drawable.blackfiretorch);
                        						break;						
                             			case 17: icon.setImageResource(R.drawable.bladeoftheruinedking);
                        						break;						
                             			case 18: icon.setImageResource(R.drawable.blastingwand);
                        						break;						
                             			case 19: icon.setImageResource(R.drawable.bonetoothnecklaceblue1);
                        						break;						
                             			case 20: icon.setImageResource(R.drawable.bonetoothnecklacegreen1);
                        						break;						
                             			case 21: icon.setImageResource(R.drawable.bonetoothnecklacered1);
                        						break;						
                             			case 22: icon.setImageResource(R.drawable.bonetoothnecklaceyellow1);
                        						break;						
                             			case 23: icon.setImageResource(R.drawable.bootsofmobility);
                        						break;						
                             			case 24: icon.setImageResource(R.drawable.bootsofspeed);
                        						break;						
                             			case 25: icon.setImageResource(R.drawable.bootsofswiftness);
                        						break;						
                             			case 26: icon.setImageResource(R.drawable.brawlersgloves);
                        						break;						
                             			case 27: icon.setImageResource(R.drawable.catalysttheprotector);
                        						break;						
                             			case 28: icon.setImageResource(R.drawable.chainvest);
                        						break;						
                             			case 29: icon.setImageResource(R.drawable.chaliceofharmony);
                        						break;						
                             			case 30: icon.setImageResource(R.drawable.cloakofagility);
                        						break;						
                             			case 31: icon.setImageResource(R.drawable.clotharmor);
                        						break;						
                             			case 32: icon.setImageResource(R.drawable.crystallineflask);
                        						break;						
                             			case 33: icon.setImageResource(R.drawable.dagger);
                        						break;						
                             			case 34: icon.setImageResource(R.drawable.deathfiregrasp);
                        						break;						
                             			case 35: icon.setImageResource(R.drawable.dervishblade);
                        						break;						
                             			case 36: icon.setImageResource(R.drawable.doransblade);
                        						break;						
                             			case 37: icon.setImageResource(R.drawable.doransring);
                        						break;
                             			case 38: icon.setImageResource(R.drawable.doransshield);
                        						break;
                             			case 39: icon.setImageResource(R.drawable.elixirofbrilliance);
                        						break;     	
                             			case 40: icon.setImageResource(R.drawable.elixiroffortitude);
                        						break;     	
                             			case 41: icon.setImageResource(R.drawable.alacrity);
                        						break;     	
                             			case 42: icon.setImageResource(R.drawable.captain);
                        						break;     	
                             			case 43: icon.setImageResource(R.drawable.distortion);
                        						break;     	
                             			case 44: icon.setImageResource(R.drawable.furor);
                        						break;     	
                             			case 45: icon.setImageResource(R.drawable.homeguard);
                        						break;     	
                             			case 46: icon.setImageResource(R.drawable.entropy);
                        						break;     	
                             			case 47: icon.setImageResource(R.drawable.executionerscalling);
                        						break;     	
                             			case 48: icon.setImageResource(R.drawable.explorersward);
                        						break;     	
                             			case 49: icon.setImageResource(R.drawable.faceofthemountain);
                        						break;     	
                             			case 50: icon.setImageResource(R.drawable.faeriecharm);
                        						break;     	
                             			case 51: icon.setImageResource(R.drawable.farsightorb);
                        						break;     	
                             			case 52: icon.setImageResource(R.drawable.feralflare);
                        						break;     	
                             			case 53: icon.setImageResource(R.drawable.fiendishcodex);
                        						break;     	
                             			case 54: icon.setImageResource(R.drawable.forbiddenidol);
                        						break;     	
                             			case 55: icon.setImageResource(R.drawable.frostqueensclaim);
                        						break;     	
                             			case 56: icon.setImageResource(R.drawable.frostfang);
                        						break;     	
                             			case 57: icon.setImageResource(R.drawable.frozenheart);
                        						break;     	
                             			case 58: icon.setImageResource(R.drawable.frozenmallet);
                        						break;     	
                             			case 59: icon.setImageResource(R.drawable.giantsbelt);
                        						break;     	
                             			case 60: icon.setImageResource(R.drawable.glacialshroud);
                        						break;     	
                             			case 61: icon.setImageResource(R.drawable.greaterstealthtotem);
                        						break;     	
                             			case 62: icon.setImageResource(R.drawable.greatervisiontotem);
                        						break;     	
                             			case 63: icon.setImageResource(R.drawable.grezsspectrallantern);
                        						break;     	
                             			case 64: icon.setImageResource(R.drawable.guardianangel);
                        						break;     	
                             			case 65: icon.setImageResource(R.drawable.guardianshorn);
                        						break;     	
                             			case 66: icon.setImageResource(R.drawable.guinsoosrageblade);
                        						break;     	
                             			case 67: icon.setImageResource(R.drawable.hauntingguise);
                        						break;     	
                             			case 68: icon.setImageResource(R.drawable.headofkhazix);
                        						break;     	
                             			case 69: icon.setImageResource(R.drawable.healthpotion);
                        						break;     	
                             			case 70: icon.setImageResource(R.drawable.hexdrinker);
                        						break;     	
                             			case 71: icon.setImageResource(R.drawable.hextechgunblade);
                        						break;     	
                             			case 72: icon.setImageResource(R.drawable.hextechsweeper);
                        						break;     	
                             			case 73: icon.setImageResource(R.drawable.huntersmachete);
                        						break;     	
                             			case 74: icon.setImageResource(R.drawable.iceborngauntlet);
                        						break;     	
                             			case 75: icon.setImageResource(R.drawable.ichorofillumination);
                        						break;     	
                             			case 76: icon.setImageResource(R.drawable.ichorofrage);
                        						break;     	
                             			case 77: icon.setImageResource(R.drawable.infinityedge);
                        						break; 		
                             			case 78: icon.setImageResource(R.drawable.ionianbootsoflucidity);
                        						break;     			
                             			case 79: icon.setImageResource(R.drawable.kindlegem);
                        						break;     			
                             			case 80: icon.setImageResource(R.drawable.kindlegem);
                        						break;     			
                             			case 81: icon.setImageResource(R.drawable.lastwhisper);
                        						break;     			
                             			case 82: icon.setImageResource(R.drawable.liandrystorment);
                        						break;     			
                             			case 83: icon.setImageResource(R.drawable.lichbane);
                        						break;     			
                             			case 84: icon.setImageResource(R.drawable.locketoftheironsolari);
                        						break;     			
                             			case 85: icon.setImageResource(R.drawable.longsword);
                        						break;     			
                             			case 86: icon.setImageResource(R.drawable.lordvandammspillager);
                        						break;     			
                             			case 87: icon.setImageResource(R.drawable.madredsrazors);
                        						break;     			
                             			case 88: icon.setImageResource(R.drawable.madredsrazors);
                        						break;     			
                             			case 89: icon.setImageResource(R.drawable.manapotion);
                        						break;     			
                             			case 90: icon.setImageResource(R.drawable.manamune);
                        						break;     			
                             			case 91: icon.setImageResource(R.drawable.mawofmalmortius);
                        						break;     			
                             			case 92: icon.setImageResource(R.drawable.mejaissoulstealer);
                        						break;     			
                             			case 93: icon.setImageResource(R.drawable.mercurialscimitar);
                        						break;     			
                             			case 94: icon.setImageResource(R.drawable.mercurytreads);
                        						break;     			
                             			case 95: icon.setImageResource(R.drawable.mikaelscrucible);
                        						break;     			
                             			case 96: icon.setImageResource(R.drawable.moonflairspellblade);
                        						break;     			
                             			case 97: icon.setImageResource(R.drawable.morellonomicon);
                        						break;     			
                             			case 98: icon.setImageResource(R.drawable.muramana);
                        						break;     			
                             			case 99: icon.setImageResource(R.drawable.nashorstooth);
                        						break;     			
                             			case 100: icon.setImageResource(R.drawable.needlesslylargerod);
                        						break;     			
                             			case 101: icon.setImageResource(R.drawable.negatroncloak);
                        						break;     			
                             			case 102: icon.setImageResource(R.drawable.ninjatabi);
                        						break;     			
                             			case 103: icon.setImageResource(R.drawable.nomadsmedallion);
                        						break;     			
                             			case 104: icon.setImageResource(R.drawable.nullmagicmantle);
                        						break;     			
                             			case 105: icon.setImageResource(R.drawable.odynsveil);
                        						break;     			
                             			case 106: icon.setImageResource(R.drawable.ohmwrecker);
                        						break;     			
                             			case 107: icon.setImageResource(R.drawable.oraclesextract);
                        						break;     			
                             			case 108: icon.setImageResource(R.drawable.oracleslens);
                        						break;     			
                             			case 109: icon.setImageResource(R.drawable.orbofwinter);
                        						break;     			
                             			case 110: icon.setImageResource(R.drawable.overlordsbloodmail);
                        						break;     			
                             			case 111: icon.setImageResource(R.drawable.phage);
                        						break;     			
                             			case 112: icon.setImageResource(R.drawable.phantomdancer);
                        						break;     			
                             			case 113: icon.setImageResource(R.drawable.pickaxe);
                        						break;     			
                             			case 114: icon.setImageResource(R.drawable.porosnax);
                        						break;     			
                             			case 115: icon.setImageResource(R.drawable.prospectorsblade);
                        						break;     			
                             			case 116: icon.setImageResource(R.drawable.prospectorsring);
                        						break;     			
                             			case 117: icon.setImageResource(R.drawable.quicksilversash);
                        						break;     	
                             			case 118: icon.setImageResource(R.drawable.rabadonsdeathcap);
                             					break;     	
                             			case 119: icon.setImageResource(R.drawable.randuinsomen);
                             					break;     	
                             			case 120: icon.setImageResource(R.drawable.ravenoushydra);
                             					break;   
                             			case 121: icon.setImageResource(R.drawable.recurvebow);
                        					break;  
                             			case 122: icon.setImageResource(R.drawable.rejuvenationbead);
                        					break;   
                             			case 123: icon.setImageResource(R.drawable.relicshield);
                        					break;   
                             			case 124: icon.setImageResource(R.drawable.rodofages);
                        					break;
                             			case 125: icon.setImageResource(R.drawable.rubycrystal);
                        					break;  
                             			case 126: icon.setImageResource(R.drawable.rubysightstone);
                        					break;   
                             			case 127: icon.setImageResource(R.drawable.runaanshurricane);
                        					break;   
                             			case 128: icon.setImageResource(R.drawable.rylaiscrystalscepter);
                        					break; 
                             			case 129: icon.setImageResource(R.drawable.sanguineblade);
                        					break;
                             			case 130: icon.setImageResource(R.drawable.sapphirecrystal);
                        					break;   
                             			case 131: icon.setImageResource(R.drawable.scryingorb);
                             				break;
                             			case 132: icon.setImageResource(R.drawable.seekersarmguard);
                         					break;
                             			case 133: icon.setImageResource(R.drawable.seraphsembrace);
                         					break;
                             			case 134: icon.setImageResource(R.drawable.sheen);
                         					break;
                             			case 135: icon.setImageResource(R.drawable.sightstone);
                         					break;
                             			case 136: icon.setImageResource(R.drawable.sorcerersshoes);
                         					break;
                             			case 137: icon.setImageResource(R.drawable.spectrescowl);
                         					break;
                             			case 138: icon.setImageResource(R.drawable.spellthiefsedge);
                         					break;
                             			case 139: icon.setImageResource(R.drawable.spiritoftheancientgolem);
                         					break;
                             			case 140: icon.setImageResource(R.drawable.spiritoftheelderlizard);
                         					break;
                             			case 141: icon.setImageResource(R.drawable.spiritofthespectralwraith);
                         					break;
                             			case 142: icon.setImageResource(R.drawable.spiritstone);
                         					break;
                             			case 143: icon.setImageResource(R.drawable.spiritvisage);
                         					break;
                             			case 144: icon.setImageResource(R.drawable.statikkshiv);
                         					break;
                             			case 145: icon.setImageResource(R.drawable.stealthward);
                         					break;
                             			case 146: icon.setImageResource(R.drawable.stinger);
                             				break;
                             			case 147: icon.setImageResource(R.drawable.sunfirecape);
                         					break;
                             			case 148: icon.setImageResource(R.drawable.sweepinglens);
                         					break;
                             			case 149: icon.setImageResource(R.drawable.swordofthedivine);
                             				break;
                             			case 150: icon.setImageResource(R.drawable.swordoftheoccult);
                         					break;
                             			case 151: icon.setImageResource(R.drawable.talismanofascension);
                         					break;
                             			case 152: icon.setImageResource(R.drawable.targonsbrace);
                         					break;
                             			case 153: icon.setImageResource(R.drawable.tearofthegoddess);
                         					break;
                             			case 154: icon.setImageResource(R.drawable.theblackcleaver);
                         					break;
                             			case 155: icon.setImageResource(R.drawable.thebloodthirster);
                         					break;
                             			case 156: icon.setImageResource(R.drawable.thebrutalizer);
                         					break;
                             			case 157: icon.setImageResource(R.drawable.hexcore);
                         					break;
                             			case 158: icon.setImageResource(R.drawable.thelightbringer);
                         					break;
                             			case 159: icon.setImageResource(R.drawable.thornmail);
                         					break;
                             			case 160: icon.setImageResource(R.drawable.tiamat);
                         					break;
                             			case 161: icon.setImageResource(R.drawable.totalbiscuitofrejuvenation);
                         					break;
                             			case 162: icon.setImageResource(R.drawable.trinityforce);
                         					break;
                             			case 163: icon.setImageResource(R.drawable.twinshadows);
                         					break;
                             			case 164: icon.setImageResource(R.drawable.vampiricscepter);
                         					break;
                             			case 165: icon.setImageResource(R.drawable.visionward);
                         					break;
                             			case 166: icon.setImageResource(R.drawable.voidstaff);
                         					break;
                             			case 167: icon.setImageResource(R.drawable.wardensmail);
                         					break;
                             			case 168: icon.setImageResource(R.drawable.wardingtotem);
                         					break;
                             			case 169: icon.setImageResource(R.drawable.warmogsarmor);
                         					break;
                             			case 170: icon.setImageResource(R.drawable.wickedhatchet);
                         					break;
                             			case 171: icon.setImageResource(R.drawable.willoftheancients);
                         					break;
                             			case 172: icon.setImageResource(R.drawable.witsend);
                         					break;
                             			case 173: icon.setImageResource(R.drawable.woogletswitchcap);
                         					break;
                             			case 174: icon.setImageResource(R.drawable.wriggleslantern);
                         					break;
                             			case 175: icon.setImageResource(R.drawable.youmuusghostblade);
                         					break;
                             			case 176: icon.setImageResource(R.drawable.zeal);
                         					break;
                             			case 177: icon.setImageResource(R.drawable.zekesherald);
                         					break;
                             			case 178: icon.setImageResource(R.drawable.zephyr);
                         					break;
                             			case 179: icon.setImageResource(R.drawable.zhonyashourglass);
                        					break;
                        				default: break;
                        				
                        				
                        				
                             			}

                                }
                                 
                                @Override
                                public void onNothingSelected(AdapterView arg0) {
                                //do something else
                                }
                                });
                        
		
	}

	
	public void iteminfo(View view) {
        Intent intent = new Intent(this, ItemInfo.class);
        intent.putExtra("EXTRA_MESSAGE", EXTRA_MESSAGE);
        startActivity(intent);
   }
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.items, menu);
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
}
