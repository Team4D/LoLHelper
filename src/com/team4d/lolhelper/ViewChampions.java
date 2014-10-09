package com.team4d.lolhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.generalinfo.ChampionDatabase;
import com.team4d.lolhelper.generalinfo.SpellDatabase;
import com.team4d.lolhelper.generalinfo.SpellInfo;

public class ViewChampions extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_viewchampions);

		FrameLayout layout = (FrameLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		// final TextView display1 = (TextView)findViewById(R.id.textView1);
		int i = 0;

		SpellDatabase.makeSpellDatabase();

		Intent intent = getIntent();
		String message = intent.getStringExtra(Champions.EXTRA_MESSAGE);
		// display1.setText(message);

		ImageView icon = (ImageView) findViewById(R.id.icon);
		ImageView spell0 = (ImageView) findViewById(R.id.spell0);
		ImageView spell1 = (ImageView) findViewById(R.id.spell1);
		ImageView spell2 = (ImageView) findViewById(R.id.spell2);
		ImageView spell3 = (ImageView) findViewById(R.id.spell3);
		ImageView spell4 = (ImageView) findViewById(R.id.spell4);
		ImageView spell5 = (ImageView) findViewById(R.id.spell5);
		ImageView spell6 = (ImageView) findViewById(R.id.spell6);
		ImageView spell7 = (ImageView) findViewById(R.id.spell7);
		ImageView spell8 = (ImageView) findViewById(R.id.spell8);

		spell0.setImageResource(R.drawable.abc_search_dropdown_light);
		spell1.setImageResource(R.drawable.abc_search_dropdown_light);
		spell2.setImageResource(R.drawable.abc_search_dropdown_light);
		spell3.setImageResource(R.drawable.abc_search_dropdown_light);
		spell4.setImageResource(R.drawable.abc_search_dropdown_light);
		spell5.setImageResource(R.drawable.abc_search_dropdown_light);
		spell6.setImageResource(R.drawable.abc_search_dropdown_light);
		spell7.setImageResource(R.drawable.abc_search_dropdown_light);
		spell8.setImageResource(R.drawable.abc_search_dropdown_light);

		ChampionDatabase champs = new ChampionDatabase();
		if (message.equals("Aatrox"))
		{
			i = 0;
		} else if (message.equals("Ahri"))
		{
			i = 1;
		} else if (message.equals("Akali"))
		{
			i = 2;
		} else if (message.equals("Alistar"))
		{
			i = 3;
		} else if (message.equals("Amumu"))
		{
			i = 4;
		} else if (message.equals("Anivia"))
		{
			i = 5;
		} else if (message.equals("Annie"))
		{
			i = 6;
		} else if (message.equals("Ashe"))
		{
			i = 7;
		} else if (message.equals("Blitzcrank"))
		{
			i = 8;
		} else if (message.equals("Brand"))
		{
			i = 9;
		} else if (message.equals("Caitlyn"))
		{
			i = 10;
		} else if (message.equals("Cassiopeia"))
		{
			i = 11;
		} else if (message.equals("Cho Gath"))
		{
			i = 12;
		} else if (message.equals("Corki"))
		{
			i = 13;
		} else if (message.equals("Darius"))
		{
			i = 14;
		} else if (message.equals("Diana"))
		{
			i = 15;
		} else if (message.equals("Dr. Mundo"))
		{
			i = 16;
		} else if (message.equals("Draven"))
		{
			i = 17;
		} else if (message.equals("Elise"))
		{
			i = 18;
		} else if (message.equals("Evelynn"))
		{
			i = 19;
		} else if (message.equals("Ezreal"))
		{
			i = 20;
		} else if (message.equals("Fiddlesticks"))
		{
			i = 21;
		} else if (message.equals("Fiora"))
		{
			i = 22;
		} else if (message.equals("Fizz"))
		{
			i = 23;
		} else if (message.equals("Galio"))
		{
			i = 24;
		} else if (message.equals("Gangplank"))
		{
			i = 25;
		} else if (message.equals("Garen"))
		{
			i = 26;
		} else if (message.equals("Gragas"))
		{
			i = 27;
		} else if (message.equals("Graves"))
		{
			i = 28;
		} else if (message.equals("Hecarim"))
		{
			i = 29;
		} else if (message.equals("Heimerdinger"))
		{
			i = 30;
		} else if (message.equals("Irelia"))
		{
			i = 31;
		} else if (message.equals("Janna"))
		{
			i = 32;
		} else if (message.equals("Jarvan IV"))
		{
			i = 33;
		} else if (message.equals("Jax"))
		{
			i = 34;
		} else if (message.equals("Jayce"))
		{
			i = 35;
		} else if (message.equals("Jinx"))
		{
			i = 36;
		} else if (message.equals("Karma"))
		{
			i = 37;
		} else if (message.equals("Karthus"))
		{
			i = 38;
		} else if (message.equals("Kassadin"))
		{
			i = 39;
		} else if (message.equals("Katarina"))
		{
			i = 40;
		} else if (message.equals("Kayle"))
		{
			i = 41;
		} else if (message.equals("Kennen"))
		{
			i = 42;
		} else if (message.equals("Kha Zix"))
		{
			i = 43;
		} else if (message.equals("Kog Maw"))
		{
			i = 44;
		} else if (message.equals("LeBlanc"))
		{
			i = 45;
		} else if (message.equals("Lee Sin"))
		{
			i = 46;
		} else if (message.equals("Leona"))
		{
			i = 47;
		} else if (message.equals("Lissandra"))
		{
			i = 48;
		} else if (message.equals("Lucian"))
		{
			i = 49;
		} else if (message.equals("Lulu"))
		{
			i = 50;
		} else if (message.equals("Lux"))
		{
			i = 51;
		} else if (message.equals("Malphite"))
		{
			i = 52;
		} else if (message.equals("Malzahar"))
		{
			i = 53;
		} else if (message.equals("Maokai"))
		{
			i = 54;
		} else if (message.equals("Master Yi"))
		{
			i = 55;
		} else if (message.equals("Miss Fortune"))
		{
			i = 56;
		} else if (message.equals("Mordekaiser"))
		{
			i = 57;
		} else if (message.equals("Morgana"))
		{
			i = 58;
		} else if (message.equals("Nami"))
		{
			i = 59;
		} else if (message.equals("Nasus"))
		{
			i = 60;
		} else if (message.equals("Nautilus"))
		{
			i = 61;
		} else if (message.equals("Nidalee"))
		{
			i = 62;
		} else if (message.equals("Nocturne"))
		{
			i = 63;
		} else if (message.equals("Nunu"))
		{
			i = 64;
		} else if (message.equals("Olaf"))
		{
			i = 65;
		} else if (message.equals("Orianna"))
		{
			i = 66;
		} else if (message.equals("Pantheon"))
		{
			i = 67;
		} else if (message.equals("Poppy"))
		{
			i = 68;
		} else if (message.equals("Quinn"))
		{
			i = 69;
		} else if (message.equals("Rammus"))
		{
			i = 70;
		} else if (message.equals("Renekton"))
		{
			i = 71;
		} else if (message.equals("Rengar"))
		{
			i = 72;
		} else if (message.equals("Riven"))
		{
			i = 73;
		} else if (message.equals("Rumble"))
		{
			i = 74;
		} else if (message.equals("Ryze"))
		{
			i = 75;
		} else if (message.equals("Sejuani"))
		{
			i = 76;
		} else if (message.equals("Shaco"))
		{
			i = 77;
		} else if (message.equals("Shen"))
		{
			i = 78;
		} else if (message.equals("Shyvana"))
		{
			i = 79;
		} else if (message.equals("Singed"))
		{
			i = 80;
		} else if (message.equals("Sion"))
		{
			i = 81;
		} else if (message.equals("Sivir"))
		{
			i = 82;
		} else if (message.equals("Skarner"))
		{
			i = 83;
		} else if (message.equals("Sona"))
		{
			i = 84;
		} else if (message.equals("Soraka"))
		{
			i = 85;
		} else if (message.equals("Swain"))
		{
			i = 86;
		} else if (message.equals("Syndra"))
		{
			i = 87;
		} else if (message.equals("Talon"))
		{
			i = 88;
		} else if (message.equals("Taric"))
		{
			i = 89;
		} else if (message.equals("Teemo"))
		{
			i = 90;
		} else if (message.equals("Thresh"))
		{
			i = 91;
		} else if (message.equals("Tristana"))
		{
			i = 92;
		} else if (message.equals("Trundle"))
		{
			i = 93;
		} else if (message.equals("Tryndamere"))
		{
			i = 94;
		} else if (message.equals("Twisted Fate"))
		{
			i = 95;
		} else if (message.equals("Twitch"))
		{
			i = 96;
		} else if (message.equals("Udyr"))
		{
			i = 97;
		} else if (message.equals("Urgot"))
		{
			i = 98;
		} else if (message.equals("Varus"))
		{
			i = 99;
		} else if (message.equals("Vayne"))
		{
			i = 100;
		} else if (message.equals("Veigar"))
		{
			i = 101;
		} else if (message.equals("Vel Koz"))
		{
			i = 102;
		} else if (message.equals("Vi"))
		{
			i = 103;
		} else if (message.equals("Viktor"))
		{
			i = 104;
		} else if (message.equals("Vladimir"))
		{
			i = 105;
		} else if (message.equals("Volibear"))
		{
			i = 106;
		} else if (message.equals("Warwick"))
		{
			i = 107;
		} else if (message.equals("Wukong"))
		{
			i = 108;
		} else if (message.equals("Xerath"))
		{
			i = 109;
		} else if (message.equals("Xin Zhao"))
		{
			i = 110;
		} else if (message.equals("Yasuo"))
		{
			i = 111;
		} else if (message.equals("Yorick"))
		{
			i = 112;
		} else if (message.equals("Zac"))
		{
			i = 113;
		} else if (message.equals("Zed"))
		{
			i = 114;
		} else if (message.equals("Ziggs"))
		{
			i = 115;
		} else if (message.equals("Zilean"))
		{
			i = 116;
		} else
		{
			i = 117;
		}

		// Spells
		SpellInfo[] spells = SpellDatabase.champSpells[i];

 icon.setImageDrawable(getResources().getDrawable(
		getResources().getIdentifier(
				message.toLowerCase().replaceAll("\\s", "")
						.replaceAll("'", "").replaceAll("\\.", ""),
				"drawable", getPackageName())));			
 
 int spellsLength = spells.length;
 
	spell0.setImageDrawable(getResources().getDrawable(
		getResources().getIdentifier(
				message.toLowerCase().replaceAll("\\s", "")
						.replaceAll("'", "").replaceAll("\\.", "") + "0",
				"drawable", getPackageName())));
	spell1.setImageDrawable(getResources().getDrawable(
			getResources().getIdentifier(
					message.toLowerCase().replaceAll("\\s", "")
							.replaceAll("'", "").replaceAll("\\.", "") + "1",
					"drawable", getPackageName())));		
	spell2.setImageDrawable(getResources().getDrawable(
			getResources().getIdentifier(
					message.toLowerCase().replaceAll("\\s", "")
							.replaceAll("'", "").replaceAll("\\.", "") + "2",
					"drawable", getPackageName())));
	spell3.setImageDrawable(getResources().getDrawable(
			getResources().getIdentifier(
					message.toLowerCase().replaceAll("\\s", "")
							.replaceAll("'", "").replaceAll("\\.", "") + "3",
					"drawable", getPackageName())));
	spell4.setImageDrawable(getResources().getDrawable(
			getResources().getIdentifier(
					message.toLowerCase().replaceAll("\\s", "")
							.replaceAll("'", "").replaceAll("\\.", "") + "4",
					"drawable", getPackageName())));
	
	if(spellsLength > 5){
	spell5.setImageDrawable(getResources().getDrawable(
			getResources().getIdentifier(
					message.toLowerCase().replaceAll("\\s", "")
							.replaceAll("'", "").replaceAll("\\.", "") + "5",
					"drawable", getPackageName())));
	}
	
	if(spellsLength > 6){
	spell6.setImageDrawable(getResources().getDrawable(
			getResources().getIdentifier(
					message.toLowerCase().replaceAll("\\s", "")
							.replaceAll("'", "").replaceAll("\\.", "") + "6",
					"drawable", getPackageName())));
	}
	
	if(spellsLength > 7){
	spell7.setImageDrawable(getResources().getDrawable(
			getResources().getIdentifier(
					message.toLowerCase().replaceAll("\\s", "")
							.replaceAll("'", "").replaceAll("\\.", "") + "7",
					"drawable", getPackageName())));
	}
	
	if(spellsLength > 8){
		spell8.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						message.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", "") + "8",
						"drawable", getPackageName())));
		}



		// Name, Title, and Roles
		String name = champs.getChampList()[i].getName();
		String title = champs.getChampList()[i].getTitle();
		String primary = champs.getChampList()[i].getPrimary();
		String secondary = champs.getChampList()[i].getSecondary();

		// Stats
		double armor = champs.getChampList()[i].getArmor();
		double attackDam = champs.getChampList()[i].getAttackDam();
		double attackSpeed = champs.getChampList()[i].getAttackSpeed();
		double range = champs.getChampList()[i].getRange();
		String rangeType = champs.getChampList()[i].getRangeType();
		double health = champs.getChampList()[i].getHealth();
		double healthRegen = champs.getChampList()[i].getHealthRegen();
		double movespeed = champs.getChampList()[i].getMoveSpeed();
		double mana = champs.getChampList()[i].getMana();
		double manaRegen = champs.getChampList()[i].getManaRegen();
		double magicRes = champs.getChampList()[i].getMagicRes();

		// Per Level Stats
		double armorPerLevel = champs.getChampList()[i].getArmorPerLevel();
		double attackDamPerLevel = champs.getChampList()[i].getAttackDamPerLevel();
		double attackSpeedPerLevel = champs.getChampList()[i].getAttackSpeedPerLevel();
		double healthPerLevel = champs.getChampList()[i].getHealthPerLevel();
		double healthRegenPerLevel = champs.getChampList()[i].getHealthRegenPerLevel();
		String typeOfMana = champs.getChampList()[i].getTypeOfMana(); // could be energy or mana
		double manaPerLevel = champs.getChampList()[i].getManaPerLevel();
		double manaRegenPerLevel = champs.getChampList()[i].getManaRegenPerLevel();
		double magicResPerLevel = champs.getChampList()[i].getMagicResPerLevel();

		// Skill Rankings
		int attack = champs.getChampList()[i].getAttack();
		int defense = champs.getChampList()[i].getDefense();
		int difficulty = champs.getChampList()[i].getDifficulty();
		int magicAbility = champs.getChampList()[i].getMagicOrAbility();

		TextView nameText = (TextView) findViewById(R.id.nameDis);
		nameText.setText(name);
		TextView titleText = (TextView) findViewById(R.id.titleDis);
		TextView primaryText = (TextView) findViewById(R.id.primaryDis);
		TextView secondaryText = (TextView) findViewById(R.id.secondaryDis);

		TextView attackText = (TextView) findViewById(R.id.attackDis);
		TextView defenseText = (TextView) findViewById(R.id.defenseDis);
		TextView difficultyText = (TextView) findViewById(R.id.difficultyDis);
		TextView magicAbilityText = (TextView) findViewById(R.id.magicAbilityDis);

		TextView healthText = (TextView) findViewById(R.id.healthDis);
		TextView healthRegenText = (TextView) findViewById(R.id.healthRegenDis);
		TextView manaText = (TextView) findViewById(R.id.manaDis);
		TextView manaRegenText = (TextView) findViewById(R.id.manaRegenDis);
		TextView rangeText = (TextView) findViewById(R.id.rangeDis);
		TextView attackDamText = (TextView) findViewById(R.id.attackDamDis);
		TextView attackSpeedText = (TextView) findViewById(R.id.attackSpeedDis);
		TextView armorText = (TextView) findViewById(R.id.armorDis);
		TextView magicResText = (TextView) findViewById(R.id.magicResDis);
		TextView movespeedText = (TextView) findViewById(R.id.movespeedDis);

		// Need to figure out way to display all spell info
		// TextView spellsText = (TextView)findViewById(R.id.spellsDis);

		// Setting Text for TextViews

		titleText.setText(title);

		primaryText.setText("Primary: " + primary);

		if (secondary.equals(""))
		{
			secondaryText.setText("");
		}
		else
		{
			secondaryText.setText("Secondary: " + secondary);
		}

		attackText.setText("Attack Power: " + attack);
		defenseText.setText("Defense Power: " + defense);
		difficultyText.setText("Difficulty: " + difficulty);
		magicAbilityText.setText("Ability Power: " + magicAbility);

		healthText.setText("Health: " + health + "(+" + healthPerLevel + ")");
		healthRegenText.setText("Health Regen.: " + healthRegen + "(+" + healthRegenPerLevel + ")");

		if (typeOfMana.equals("No Resource") || typeOfMana.equals("Uses Health"))
		{
			manaText.setText(typeOfMana);
			manaRegenText.setText("");
		}
		else if (typeOfMana.equals("Fury") || typeOfMana.equals("Ferocity"))
		{
			manaText.setText(typeOfMana + ": " + mana);
			manaRegenText.setText("");
		}
		else
		{
			manaText.setText(typeOfMana + ": " + mana + "(+" + manaPerLevel + ")");
			manaRegenText.setText(typeOfMana + " Regen.: " + manaRegen + "(+" + manaRegenPerLevel + ")");
		}

		if (rangeType.equals(""))
		{
			rangeText.setText("Range: " + range);
		}
		else
		{
			rangeText.setText("Range: " + range + "(" + rangeType + ")");
		}

		attackDamText.setText("Attack Damage: " + attackDam + "(+" + attackDamPerLevel + ")");
		attackSpeedText.setText("Attack Speed: " + attackSpeed + "(+" + attackSpeedPerLevel + ")");
		armorText.setText("Armor: " + armor + "(+" + armorPerLevel + ")");
		magicResText.setText("Magic Res.: " + magicRes + "(+" + magicResPerLevel + ")");
		movespeedText.setText("Move Speed: " + movespeed);

		// ----------------------------------------------------------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------------------------------------------------------
		/*
		 * Spell(s) Info
		 * Setting of Spell Info and Spell Info Text
		 */

		// TextView spellsText = (TextView)findViewById(R.id.spellsDis);
		TextView spellName0Text = (TextView) findViewById(R.id.spellName0Dis);
		TextView spellName1Text = (TextView) findViewById(R.id.spellName1Dis);
		TextView spellName2Text = (TextView) findViewById(R.id.spellName2Dis);
		TextView spellName3Text = (TextView) findViewById(R.id.spellName3Dis);
		TextView spellName4Text = (TextView) findViewById(R.id.spellName4Dis);
		TextView spellName5Text = (TextView) findViewById(R.id.spellName5Dis);
		TextView spellName6Text = (TextView) findViewById(R.id.spellName6Dis);
		TextView spellName7Text = (TextView) findViewById(R.id.spellName7Dis);
		TextView spellName8Text = (TextView) findViewById(R.id.spellName8Dis);
		// TextView spellName9Text = (TextView)findViewById(R.id.spellName9Dis);

		// Costs
		TextView spellCost0Text = (TextView) findViewById(R.id.spellCost0Dis);
		TextView spellCost1Text = (TextView) findViewById(R.id.spellCost1Dis);
		TextView spellCost2Text = (TextView) findViewById(R.id.spellCost2Dis);
		TextView spellCost3Text = (TextView) findViewById(R.id.spellCost3Dis);
		TextView spellCost4Text = (TextView) findViewById(R.id.spellCost4Dis);
		TextView spellCost5Text = (TextView) findViewById(R.id.spellCost5Dis);
		TextView spellCost6Text = (TextView) findViewById(R.id.spellCost6Dis);
		TextView spellCost7Text = (TextView) findViewById(R.id.spellCost7Dis);
		TextView spellCost8Text = (TextView) findViewById(R.id.spellCost8Dis);

		// Cooldown
		TextView spellCooldown0Text = (TextView) findViewById(R.id.spellCooldown0Dis);
		TextView spellCooldown1Text = (TextView) findViewById(R.id.spellCooldown1Dis);
		TextView spellCooldown2Text = (TextView) findViewById(R.id.spellCooldown2Dis);
		TextView spellCooldown3Text = (TextView) findViewById(R.id.spellCooldown3Dis);
		TextView spellCooldown4Text = (TextView) findViewById(R.id.spellCooldown4Dis);
		TextView spellCooldown5Text = (TextView) findViewById(R.id.spellCooldown5Dis);
		TextView spellCooldown6Text = (TextView) findViewById(R.id.spellCooldown6Dis);
		TextView spellCooldown7Text = (TextView) findViewById(R.id.spellCooldown7Dis);
		TextView spellCooldown8Text = (TextView) findViewById(R.id.spellCooldown8Dis);

		// Range
		TextView spellRange0Text = (TextView) findViewById(R.id.spellRange0Dis);
		TextView spellRange1Text = (TextView) findViewById(R.id.spellRange1Dis);
		TextView spellRange2Text = (TextView) findViewById(R.id.spellRange2Dis);
		TextView spellRange3Text = (TextView) findViewById(R.id.spellRange3Dis);
		TextView spellRange4Text = (TextView) findViewById(R.id.spellRange4Dis);
		TextView spellRange5Text = (TextView) findViewById(R.id.spellRange5Dis);
		TextView spellRange6Text = (TextView) findViewById(R.id.spellRange6Dis);
		TextView spellRange7Text = (TextView) findViewById(R.id.spellRange7Dis);
		TextView spellRange8Text = (TextView) findViewById(R.id.spellRange8Dis);

		// Description
		TextView spellDescription0Text = (TextView) findViewById(R.id.spellDescription0Dis);
		TextView spellDescription1Text = (TextView) findViewById(R.id.spellDescription1Dis);
		TextView spellDescription2Text = (TextView) findViewById(R.id.spellDescription2Dis);
		TextView spellDescription3Text = (TextView) findViewById(R.id.spellDescription3Dis);
		TextView spellDescription4Text = (TextView) findViewById(R.id.spellDescription4Dis);
		TextView spellDescription5Text = (TextView) findViewById(R.id.spellDescription5Dis);
		TextView spellDescription6Text = (TextView) findViewById(R.id.spellDescription6Dis);
		TextView spellDescription7Text = (TextView) findViewById(R.id.spellDescription7Dis);
		TextView spellDescription8Text = (TextView) findViewById(R.id.spellDescription8Dis);

		// Stats Per Level
		TextView spellStatsPerLevel0Text = (TextView) findViewById(R.id.spellStatsPerLevel0Dis);
		TextView spellStatsPerLevel1Text = (TextView) findViewById(R.id.spellStatsPerLevel1Dis);
		TextView spellStatsPerLevel2Text = (TextView) findViewById(R.id.spellStatsPerLevel2Dis);
		TextView spellStatsPerLevel3Text = (TextView) findViewById(R.id.spellStatsPerLevel3Dis);
		TextView spellStatsPerLevel4Text = (TextView) findViewById(R.id.spellStatsPerLevel4Dis);
		TextView spellStatsPerLevel5Text = (TextView) findViewById(R.id.spellStatsPerLevel5Dis);
		TextView spellStatsPerLevel6Text = (TextView) findViewById(R.id.spellStatsPerLevel6Dis);
		TextView spellStatsPerLevel7Text = (TextView) findViewById(R.id.spellStatsPerLevel7Dis);
		TextView spellStatsPerLevel8Text = (TextView) findViewById(R.id.spellStatsPerLevel8Dis);

		/*
		 * Initial Sets for Spells
		 */
		// SpellInfo[] spells = SpellDatabase.champSpells[i];
		// spellName0Text.setText(spells[0].getSpellName());

		// Initialize Spell Names
		spellName0Text.setText("");
		spellName1Text.setText("");
		spellName2Text.setText("");
		spellName3Text.setText("");
		spellName4Text.setText("");
		spellName5Text.setText("");
		spellName6Text.setText("");
		spellName7Text.setText("");
		spellName8Text.setText("");

		// Initialize Spell Cost
		spellCost0Text.setText("");
		spellCost1Text.setText("");
		spellCost2Text.setText("");
		spellCost3Text.setText("");
		spellCost4Text.setText("");
		spellCost5Text.setText("");
		spellCost6Text.setText("");
		spellCost7Text.setText("");
		spellCost8Text.setText("");

		// Initialize Spell Cooldown
		spellCooldown0Text.setText("");
		spellCooldown1Text.setText("");
		spellCooldown2Text.setText("");
		spellCooldown3Text.setText("");
		spellCooldown4Text.setText("");
		spellCooldown5Text.setText("");
		spellCooldown6Text.setText("");
		spellCooldown7Text.setText("");
		spellCooldown8Text.setText("");

		// Initialize Spell Range
		spellRange0Text.setText("");
		spellRange1Text.setText("");
		spellRange2Text.setText("");
		spellRange3Text.setText("");
		spellRange4Text.setText("");
		spellRange5Text.setText("");
		spellRange6Text.setText("");
		spellRange7Text.setText("");
		spellRange8Text.setText("");

		// Initialize Spell Descriptions
		spellDescription0Text.setText("");
		spellDescription1Text.setText("");
		spellDescription2Text.setText("");
		spellDescription3Text.setText("");
		spellDescription4Text.setText("");
		spellDescription5Text.setText("");
		spellDescription6Text.setText("");
		spellDescription7Text.setText("");
		spellDescription8Text.setText("");

		// Initialize Spell Stats Per Level
		spellStatsPerLevel0Text.setText("");
		spellStatsPerLevel1Text.setText("");
		spellStatsPerLevel2Text.setText("");
		spellStatsPerLevel3Text.setText("");
		spellStatsPerLevel4Text.setText("");
		spellStatsPerLevel5Text.setText("");
		spellStatsPerLevel6Text.setText("");
		spellStatsPerLevel7Text.setText("");
		spellStatsPerLevel8Text.setText("");

		// Spell Name Loop/Setting
		int nameNum = 0;
		String spellName = "";
		for (nameNum = 0; nameNum < spells.length; nameNum++)
		{
			spellName = spells[nameNum].getSpellName();
			if (nameNum == 0)
			{
				spellName0Text.setText(spellName);
			} else if (nameNum == 1)
			{
				spellName1Text.setText(spellName);
			} else if (nameNum == 2)
			{
				spellName2Text.setText(spellName);
			} else if (nameNum == 3)
			{
				spellName3Text.setText(spellName);
			} else if (nameNum == 4)
			{
				spellName4Text.setText(spellName);
			} else if (nameNum == 5)
			{
				spellName5Text.setText(spellName);
			} else if (nameNum == 6)
			{
				spellName6Text.setText(spellName);
			} else if (nameNum == 7)
			{
				spellName7Text.setText(spellName);
			} else if (nameNum == 8)
			{
				spellName8Text.setText(spellName);
			}
			spellName = "";
		}

		// Spell Cost Loop/Setting
		int costNum = 0;
		String spellCost = "";
		for (costNum = 0; costNum < spells.length; costNum++)
		{
			spellCost = spells[costNum].getCost();
			if (!spellCost.equals(""))
			{
				if (costNum == 0)
				{
					spellCost0Text.setText("Cost: " + spellCost);
				} else if (costNum == 1)
				{
					spellCost1Text.setText("Cost: " + spellCost);
				} else if (costNum == 2)
				{
					spellCost2Text.setText("Cost: " + spellCost);
				} else if (costNum == 3)
				{
					spellCost3Text.setText("Cost: " + spellCost);
				} else if (costNum == 4)
				{
					spellCost4Text.setText("Cost: " + spellCost);
				} else if (costNum == 5)
				{
					spellCost5Text.setText("Cost: " + spellCost);
				} else if (costNum == 6)
				{
					spellCost6Text.setText("Cost: " + spellCost);
				} else if (costNum == 7)
				{
					spellCost7Text.setText("Cost: " + spellCost);
				} else if (costNum == 8)
				{
					spellCost8Text.setText("Cost: " + spellCost);
				}
			}
		}

		// Spell Range Loop/Setting
		int rangeNum = 0;
		String spellRange = "";
		for (rangeNum = 0; rangeNum < spells.length; rangeNum++)
		{
			spellRange = spells[rangeNum].getSpellRange();
			if (!spellRange.equals(""))
			{
				if (rangeNum == 0)
				{
					spellRange0Text.setText("Range: " + spellRange);
				} else if (rangeNum == 1)
				{
					spellRange1Text.setText("Range: " + spellRange);
				} else if (rangeNum == 2)
				{
					spellRange2Text.setText("Range: " + spellRange);
				} else if (rangeNum == 3)
				{
					spellRange3Text.setText("Range: " + spellRange);
				} else if (rangeNum == 4)
				{
					spellRange4Text.setText("Range: " + spellRange);
				} else if (rangeNum == 5)
				{
					spellRange5Text.setText("Range: " + spellRange);
				} else if (rangeNum == 6)
				{
					spellRange6Text.setText("Range: " + spellRange);
				} else if (rangeNum == 7)
				{
					spellRange7Text.setText("Range: " + spellRange);
				} else if (rangeNum == 8)
				{
					spellRange8Text.setText("Range: " + spellRange);
				}
			}
		}

		// Spell Cooldown Loop/Setting
		int cooldownNum = 0;
		String spellCooldown = "";
		for (cooldownNum = 0; cooldownNum < spells.length; cooldownNum++)
		{
			spellCooldown = spells[cooldownNum].getCoolDown();
			if (!spellCooldown.equals(""))
			{
				if (cooldownNum == 0)
				{
					spellCooldown0Text.setText("Cooldown: " + spellCooldown);
				} else if (cooldownNum == 1)
				{
					spellCooldown1Text.setText("Cooldown: " + spellCooldown);
				} else if (cooldownNum == 2)
				{
					spellCooldown2Text.setText("Cooldown: " + spellCooldown);
				} else if (cooldownNum == 3)
				{
					spellCooldown3Text.setText("Cooldown: " + spellCooldown);
				} else if (cooldownNum == 4)
				{
					spellCooldown4Text.setText("Cooldown: " + spellCooldown);
				} else if (cooldownNum == 5)
				{
					spellCooldown5Text.setText("Cooldown: " + spellCooldown);
				} else if (cooldownNum == 6)
				{
					spellCooldown6Text.setText("Cooldown: " + spellCooldown);
				} else if (cooldownNum == 7)
				{
					spellCooldown7Text.setText("Cooldown: " + spellCooldown);
				} else if (cooldownNum == 8)
				{
					spellCooldown8Text.setText("Cooldown: " + spellCooldown);
				}
			}
		}

		// Spell Description Loop/Setting
		int descriptionNum = 0;
		String spellDescription = "";
		for (descriptionNum = 0; descriptionNum < spells.length; descriptionNum++)
		{
			for (int o = 0; o < spells[descriptionNum].getDescription().length; o++)
			{
				spellDescription += spells[descriptionNum].getDescription()[o];
				if (o != spells[descriptionNum].getDescription().length - 1)
				{
					spellDescription += "\n";
				}

			}
			if (!spellDescription.equals(""))
			{
				if (descriptionNum == 0)
				{
					spellDescription0Text.setText(spellDescription);
				} else if (descriptionNum == 1)
				{
					spellDescription1Text.setText(spellDescription);
				} else if (descriptionNum == 2)
				{
					spellDescription2Text.setText(spellDescription);
				} else if (descriptionNum == 3)
				{
					spellDescription3Text.setText(spellDescription);
				} else if (descriptionNum == 4)
				{
					spellDescription4Text.setText(spellDescription);
				} else if (descriptionNum == 5)
				{
					spellDescription5Text.setText(spellDescription);
				} else if (descriptionNum == 6)
				{
					spellDescription6Text.setText(spellDescription);
				} else if (descriptionNum == 7)
				{
					spellDescription7Text.setText(spellDescription);
				} else if (descriptionNum == 8)
				{
					spellDescription8Text.setText(spellDescription);
				}
			}
			spellDescription = "";
		}

		// Spell Stats Per Level Loop/Setting
		int statsPerLevelNum = 0;
		String spellStatsPerLevel = "";
		for (statsPerLevelNum = 0; statsPerLevelNum < spells.length; statsPerLevelNum++)
		{
			for (int h = 0; h < spells[statsPerLevelNum].getStatsPerLevel().length; h++)
			{
				spellStatsPerLevel += spells[statsPerLevelNum].getStatsPerLevel()[h];
				if (h != spells[statsPerLevelNum].getStatsPerLevel().length - 1)
				{
					spellStatsPerLevel += "\n";
				}

			}
			if (!spellStatsPerLevel.equals(""))
			{
				if (statsPerLevelNum == 0)
				{
					spellStatsPerLevel0Text.setText(spellStatsPerLevel);
				} else if (statsPerLevelNum == 1)
				{
					spellStatsPerLevel1Text.setText(spellStatsPerLevel);
				} else if (statsPerLevelNum == 2)
				{
					spellStatsPerLevel2Text.setText(spellStatsPerLevel);
				} else if (statsPerLevelNum == 3)
				{
					spellStatsPerLevel3Text.setText(spellStatsPerLevel);
				} else if (statsPerLevelNum == 4)
				{
					spellStatsPerLevel4Text.setText(spellStatsPerLevel);
				} else if (statsPerLevelNum == 5)
				{
					spellStatsPerLevel5Text.setText(spellStatsPerLevel);
				} else if (statsPerLevelNum == 6)
				{
					spellStatsPerLevel6Text.setText(spellStatsPerLevel);
				} else if (statsPerLevelNum == 7)
				{
					spellStatsPerLevel7Text.setText(spellStatsPerLevel);
				} else if (statsPerLevelNum == 8)
				{
					spellStatsPerLevel8Text.setText(spellStatsPerLevel);
				}
			}
			spellStatsPerLevel = "";
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
