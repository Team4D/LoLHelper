package com.team4d.lolhelper;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.fourfoureight.lolhelper.R;
import com.team4d.lolhelper.generalinfo.SpellDatabase;
import com.team4d.lolhelper.generalinfo.SpellInfo;
import com.team4d.lolhelper.generalinfo.items;

public class UltimateBravery extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ultimate_bravery);

		FrameLayout layout = (FrameLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		items.runMain();

		Button rand = (Button) findViewById(R.id.btnRandom);
		rand.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{

				/*
				 * Initialize all variables
				 */

				String champIcon, item1, item2, item3, item4, item5, item6, mastery;
				int placeholderItem;
				int[] itemArray = new int[61];
				int iconID;
				int[] masteryArray = { 0, 0, 0 };

				int viktorItem = getRandom(0, 3);

				TextView textView1 = (TextView) findViewById(R.id.item1);
				TextView textView2 = (TextView) findViewById(R.id.item2);
				TextView textView3 = (TextView) findViewById(R.id.item3);
				TextView textView4 = (TextView) findViewById(R.id.item4);
				TextView textView5 = (TextView) findViewById(R.id.item5);
				TextView textView6 = (TextView) findViewById(R.id.item6); // Items 1-6
				TextView textView7 = (TextView) findViewById(R.id.champname); // Champ Name
				TextView textView8 = (TextView) findViewById(R.id.mastery); // Masteries
				TextView textView9 = (TextView) findViewById(R.id.summspell1);
				TextView textView10 = (TextView) findViewById(R.id.summspell2); // Summoner Spells
				TextView textView11 = (TextView) findViewById(R.id.spell); // Spell Button (Q W or E)
				TextView textView12 = (TextView) findViewById(R.id.text_spell_name);

				ImageView imageView1 = (ImageView) findViewById(R.id.iitem1);
				ImageView imageView2 = (ImageView) findViewById(R.id.iitem2);
				ImageView imageView3 = (ImageView) findViewById(R.id.iitem3);
				ImageView imageView4 = (ImageView) findViewById(R.id.iitem4);
				ImageView imageView5 = (ImageView) findViewById(R.id.iitem5);
				ImageView imageView6 = (ImageView) findViewById(R.id.iitem6);
				ImageView imageView7 = (ImageView) findViewById(R.id.ichampname);
				ImageView imageView8 = (ImageView) findViewById(R.id.ispell);
				ImageView imageView9 = (ImageView) findViewById(R.id.isummspell1);
				ImageView imageView10 = (ImageView) findViewById(R.id.isummspell2);

				/*
				 * Set champion, items
				 */
				int champID = getChampionIcon();
				champIcon = getChampionName(champID);
				item1 = getBootsName(getBoots());

				/*
				 * Makes sure Viktor has Hexcore
				 */
				if (champIcon.equals("Viktor"))
				{
					switch (viktorItem)
					{

					case 0:
						item2 = "Hexcore: Death";
						break;
					case 1:
						item2 = "Hexcore: Gravity";
						break;
					default:
						item2 = "Hexcore: Power";

					}
				} else
				{
					placeholderItem = getItem();
					if (placeholderItem == 7 || placeholderItem == 8 || placeholderItem == 9 || placeholderItem == 10
							|| placeholderItem == 11 || placeholderItem == 12 || placeholderItem == 13)
					{
						itemArray[7] = 1;
						itemArray[8] = 1;
						itemArray[9] = 1;
						itemArray[10] = 1;
						itemArray[11] = 1;
						itemArray[12] = 1;
						itemArray[13] = 1;
					}
					itemArray[placeholderItem] = 1;
					item2 = getItemName(placeholderItem);
				}

				placeholderItem = getItem();
				while (itemArray[placeholderItem] == 1)
				{
					placeholderItem = getItem();
				}
				if (placeholderItem == 7 || placeholderItem == 8 || placeholderItem == 9 || placeholderItem == 10
						|| placeholderItem == 11 || placeholderItem == 12 || placeholderItem == 13)
				{
					itemArray[7] = 1;
					itemArray[8] = 1;
					itemArray[9] = 1;
					itemArray[10] = 1;
					itemArray[11] = 1;
					itemArray[12] = 1;
					itemArray[13] = 1;
				}
				itemArray[placeholderItem] = 1;
				item3 = getItemName(placeholderItem);

				placeholderItem = getItem();
				while (itemArray[placeholderItem] == 1)
				{
					placeholderItem = getItem();
				}
				if (placeholderItem == 7 || placeholderItem == 8 || placeholderItem == 9 || placeholderItem == 10
						|| placeholderItem == 11 || placeholderItem == 12 || placeholderItem == 13)
				{
					itemArray[7] = 1;
					itemArray[8] = 1;
					itemArray[9] = 1;
					itemArray[10] = 1;
					itemArray[11] = 1;
					itemArray[12] = 1;
					itemArray[13] = 1;
				}
				itemArray[placeholderItem] = 1;
				item4 = getItemName(placeholderItem);

				placeholderItem = getItem();
				while (itemArray[placeholderItem] == 1)
				{
					placeholderItem = getItem();
				}
				if (placeholderItem == 7 || placeholderItem == 8 || placeholderItem == 9 || placeholderItem == 10
						|| placeholderItem == 11 || placeholderItem == 12 || placeholderItem == 13)
				{
					itemArray[7] = 1;
					itemArray[8] = 1;
					itemArray[9] = 1;
					itemArray[10] = 1;
					itemArray[11] = 1;
					itemArray[12] = 1;
					itemArray[13] = 1;
				}
				itemArray[placeholderItem] = 1;
				item5 = getItemName(placeholderItem);

				placeholderItem = getItem();
				while (itemArray[placeholderItem] == 1)
				{
					placeholderItem = getItem();
				}
				itemArray[placeholderItem] = 1;
				item6 = getItemName(placeholderItem);

				/*
				 * Set names for all items and champion
				 */
				textView1.setText(item1);
				textView2.setText(item2);
				textView3.setText(item3);
				textView4.setText(item4);
				textView5.setText(item5);
				textView6.setText(item6);
				textView7.setText(champIcon);

				/*
				 * Set images for all items, champion
				 */
				iconID = getResources().getIdentifier(item1.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
						getPackageName());
				imageView1.setImageResource(iconID);

				iconID = getResources().getIdentifier(item2.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
						getPackageName());
				imageView2.setImageResource(iconID);

				iconID = getResources().getIdentifier(item3.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
						getPackageName());
				imageView3.setImageResource(iconID);

				iconID = getResources().getIdentifier(item4.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
						getPackageName());
				imageView4.setImageResource(iconID);

				iconID = getResources().getIdentifier(item5.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
						getPackageName());
				imageView5.setImageResource(iconID);

				iconID = getResources().getIdentifier(item6.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
						getPackageName());
				imageView6.setImageResource(iconID);

				iconID = getResources().getIdentifier(champIcon.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
						getPackageName());
				imageView7.setImageResource(iconID);

				/*
				 * New stuff here: Random ability - needs to be updated for champions that have more than 4 spells, i.e.
				 * elise
				 * This returns one of the first 3 spells from the database. Just added Spell button
				 */

				String champSpell, spellNum, spellButton;
				int intSpellNum = getRandom(1, 4);
				switch (intSpellNum)
				{
				case 1:
					spellNum = "1";
					spellButton = "Q";
					break;
				case 2:
					spellNum = "2";
					spellButton = "W";
					break;
				default:
					spellNum = "3";
					spellButton = "E";
					break;
				}

				textView11.setText(spellButton);

				champSpell = champIcon + spellNum;
				iconID = getResources().getIdentifier(champSpell.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase(),
						"drawable", getPackageName());
				imageView8.setImageResource(iconID);
				
				// Text for spell
				SpellDatabase spellData = new SpellDatabase();
				SpellDatabase.makeSpellDatabase();
				SpellInfo spells [][] = spellData.getSpellArray();
				textView12.setText(spells[champID][intSpellNum].getSpellName());

				/*
				 * New stuff here: Random masteries. If you look at my method, it's horribly long. I needed to randomly
				 * select a tree to populate
				 * and give it a number between 0 and 30, then randomly select a second one, randomly select between 0
				 * and 30 minus the first tree
				 * and then give the remaining tree 30-(first + second) points. It's barfy and if someone can make it
				 * better (no whiles)
				 * that would be awesome.
				 */

				masteryArray = getMasteries();
				mastery = masteryArray[0] + " " + masteryArray[1] + " " + masteryArray[2];
				textView8.setText(mastery);

				/*
				 * New stuff here: Random summoner spell. Didn't include Garrison because no one ever plays dominion and
				 * this is for
				 * Summoner's Rift anyway.
				 */

				String summSpell0, summSpell1;
				int randomSummSpell0 = getRandom(0, 12);
				int randomSummSpell1 = getRandom(0, 12);
				summSpell0 = getSummonerSpellName(randomSummSpell0);

				while (randomSummSpell0 == randomSummSpell1)
				{
					randomSummSpell1 = getRandom(0, 12);
				}

				summSpell1 = getSummonerSpellName(randomSummSpell1);
				textView9.setText(summSpell0);
				iconID = getResources().getIdentifier(summSpell0.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
						"drawable", getPackageName());
				imageView9.setImageResource(iconID);
				textView10.setText(summSpell1);
				iconID = getResources().getIdentifier(summSpell1.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
						"drawable", getPackageName());
				imageView10.setImageResource(iconID);

			}
		});

		rand.performClick();
	}

	@Override
	public void onBackPressed()
	{

		super.onBackPressed();
	}

	// Method to get random champion. High must be 1 higher than the desired index
	// VALID INDEXES ARE 0 TO 1
	public static int getChampionIcon()
	{
		Random r = new Random();
		int Low = 0;
		int High = 118;
		int R = r.nextInt(High - Low) + Low;
		return R;
	}

	public static int getBoots()
	{
		Random r = new Random();
		int Low = 0;
		int High = 7;
		int R = r.nextInt(High - Low) + Low;
		return R;
	}

	public static int getItem()
	{
		Random r = new Random();
		int Low = 0;
		int High = 61;
		int R = r.nextInt(High - Low) + Low;
		return R;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ultimate_bravery, menu);
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

	public static String getBootsName(int boots)
	{
		switch (boots)
		{
		case 0:
			return "Ionian Boots of Lucidity";
		case 1:
			return "Berserker Greaves";
		case 2:
			return "Mercury Treads";
		case 3:
			return "Boots of Mobility";
		case 4:
			return "Ninja Tabi";
		case 5:
			return "Boots of Swiftness";
		case 6:
			return "Sorcerer's Shoes";
		default:
			return "headofkhazix";
		}
	}

	public static String getItemName(int item)
	{
		switch (item)
		{

		case 0:
			return "Zeke's Herald";
		case 1:
			return "Zephyr";
		case 2:
			return "Warmog's Armor";
		case 3:
			return "Blade of the Ruined King";
		case 4:
			return "Hextech Gunblade";
		case 5:
			return "Muramana";
		case 6:
			return "Seraph's Embrace";
		case 7:
			return "Spirit of the Ancient Golem";
		case 8:
			return "Spirit of the Elder Lizard";
		case 9:
			return "Spirit of the Spectral Wraith";
		case 10:
			return "Face of the Mountain";
		case 11:
			return "Frost Queen's Claim";
		case 12:
			return "Talisman of Ascension";
		case 13:
			return "Feral Flare";
		case 14:
			return "Abyssal Scepter";
		case 15:
			return "Frozen Mallet";
		case 16:
			return "Guinsoo's Rageblade";
		case 17:
			return "Last Whisper";
		case 18:
			return "Runaan's Hurricane";
		case 19:
			return "Rylai's Crystal Scepter";
		case 20:
			return "Sunfire Cape";
		case 21:
			return "Sword of the Divine";
		case 22:
			return "Void Staff";
		case 23:
			return "Wit's End";
		case 24:
			return "Banshee's Veil";
		case 25:
			return "Deathfire Grasp";
		case 26:
			return "The Bloodthirster";
		case 27:
			return "Mercurial Scimitar";
		case 28:
			return "Ohmwrecker";
		case 29:
			return "Ruby Sightstone";
		case 30:
			return "Guardian Angel";
		case 31:
			return "Infinity Edge";
		case 32:
			return "Mejai's Soulstealer";
		case 33:
			return "Zhonya's Hourglass";
		case 34:
			return "Athene's Unholy Grail";
		case 35:
			return "Atma's Impaler";
		case 36:
			return "Banner of Command";
		case 37:
			return "The Black Cleaver";
		case 38:
			return "Thornmail";
		case 39:
			return "Trinity Force";
		case 40:
			return "Executioner's Calling";
		case 41:
			return "Rabadon's Deathcap";
		case 42:
			return "Sword of the Occult";
		case 43:
			return "Frozen Heart";
		case 44:
			return "Iceborn Gauntlet";
		case 45:
			return "Liandry's Torment";
		case 46:
			return "Lichbane";
		case 47:
			return "Locket of the Iron Solari";
		case 48:
			return "Maw of Malmortius";
		case 49:
			return "Mikael's Crucible";
		case 50:
			return "Morellonomicon";
		case 51:
			return "Nashor's Tooth";
		case 52:
			return "Phantom Dancer";
		case 53:
			return "Randuin's Omen";
		case 54:
			return "Ravenous Hydra";
		case 55:
			return "Rod of Ages";
		case 56:
			return "Spirit Visage";
		case 57:
			return "Statikk Shiv";
		case 58:
			return "Twin Shadows";
		case 59:
			return "Will of the Ancients";
		case 60:
			return "Youmuu's Ghostblade";
		default:
			return "headofkhazix";

		}

	}

	public static String getChampionName(int champ)
	{

		switch (champ)
		{
		case 0:
			return "Aatrox";
		case 1:
			return "Ahri";
		case 2:
			return "Akali";
		case 3:
			return "Alistar";
		case 4:
			return "Amumu";
		case 5:
			return "Anivia";
		case 6:
			return "Annie";
		case 7:
			return "Ashe";
		case 8:
			return "Blitzcrank";
		case 9:
			return "Brand";
		case 10:
			return "Caitlyn";
		case 11:
			return "Cassiopeia";
		case 12:
			return "Chogath";
		case 13:
			return "Corki";
		case 14:
			return "Darius";
		case 15:
			return "Diana";
		case 16:
			return "Dr. Mundo";
		case 17:
			return "Draven";
		case 18:
			return "Elise";
		case 19:
			return "Evelynn";
		case 20:
			return "Ezreal";
		case 21:
			return "Fiddlesticks";
		case 22:
			return "Fiora";
		case 23:
			return "Fizz";
		case 24:
			return "Galio";
		case 25:
			return "Gangplank";
		case 26:
			return "Garen";
		case 27:
			return "Gragas";
		case 28:
			return "Graves";
		case 29:
			return "Hecarim";
		case 30:
			return "Heimerdinger";
		case 31:
			return "Irelia";
		case 32:
			return "Janna";
		case 33:
			return "Jarvan IV";
		case 34:
			return "Jax";
		case 35:
			return "Jayce";
		case 36:
			return "Jinx";
		case 37:
			return "Karma";
		case 38:
			return "Karthus";
		case 39:
			return "Kassadin";
		case 40:
			return "Katarina";
		case 41:
			return "Kayle";
		case 42:
			return "Kennen";
		case 43:
			return "Kha'Zix";
		case 44:
			return "Kog'Maw";
		case 45:
			return "LeBlanc";
		case 46:
			return "Lee Sin";
		case 47:
			return "Leona";
		case 48:
			return "Lissandra";
		case 49:
			return "Lucian";
		case 50:
			return "Lulu";
		case 51:
			return "Lux";
		case 52:
			return "Malphite";
		case 53:
			return "Malzahar";
		case 54:
			return "Maokai";
		case 55:
			return "Master Yi";
		case 56:
			return "Miss Fortune";
		case 57:
			return "Mordekaiser";
		case 58:
			return "Morgana";
		case 59:
			return "Nami";
		case 60:
			return "Nasus";
		case 61:
			return "Nautilus";
		case 62:
			return "Nidalee";
		case 63:
			return "Nocturne";
		case 64:
			return "Nunu";
		case 65:
			return "Olaf";
		case 66:
			return "Orianna";
		case 67:
			return "Pantheon";
		case 68:
			return "Poppy";
		case 69:
			return "Quinn";
		case 70:
			return "Rammus";
		case 71:
			return "Renekton";
		case 72:
			return "Rengar";
		case 73:
			return "Riven";
		case 74:
			return "Rumble";
		case 75:
			return "Ryze";
		case 76:
			return "Sejuani";
		case 77:
			return "Shaco";
		case 78:
			return "Shen";
		case 79:
			return "Shyvana";
		case 80:
			return "Singed";
		case 81:
			return "Sion";
		case 82:
			return "Sivir";
		case 83:
			return "Skarner";
		case 84:
			return "Sona";
		case 85:
			return "Soraka";
		case 86:
			return "Swain";
		case 87:
			return "Syndra";
		case 88:
			return "Talon";
		case 89:
			return "Taric";
		case 90:
			return "Teemo";
		case 91:
			return "Thresh";
		case 92:
			return "Tristana";
		case 93:
			return "Trundle";
		case 94:
			return "Tryndamere";
		case 95:
			return "Twisted Fate";
		case 96:
			return "Twitch";
		case 97:
			return "Udyr";
		case 98:
			return "Urgot";
		case 99:
			return "Varus";
		case 100:
			return "Vayne";
		case 101:
			return "Veigar";
		case 102:
			return "Vel'Koz";
		case 103:
			return "Vi";
		case 104:
			return "Viktor";
		case 105:
			return "Vladimir";
		case 106:
			return "Volibear";
		case 107:
			return "Warwick";
		case 108:
			return "Wukong";
		case 109:
			return "Xerath";
		case 110:
			return "Xin Zhao";
		case 111:
			return "Yasuo";
		case 112:
			return "Yorick";
		case 113:
			return "Zac";
		case 114:
			return "Zed";
		case 115:
			return "Ziggs";
		case 116:
			return "Zilean";
		case 117:
			return "Zyra";
		default:
			return "Aatrox";
		}

	}

	public static String getSummonerSpellName(int sumSpell)
	{
		switch (sumSpell)
		{
		case 0:
			return "Barrier";
		case 1:
			return "Clairvoyance";
		case 2:
			return "Clarity";
		case 3:
			return "Cleanse";
		case 4:
			return "Exhaust";
		case 5:
			return "Flash";
		case 6:
			return "Ghost";
		case 7:
			return "Heal";
		case 8:
			return "Ignite";
		case 9:
			return "Revive";
		case 10:
			return "Smite";
		default:
			return "Teleport";
		}

	}

	public static int getRandom(int low, int high)
	{
		Random r = new Random();
		int Low = low;
		int High = high;
		int R = r.nextInt(High - Low) + Low;
		return R;

	}

	public static int[] getMasteries()
	{

		int[] array = { 0, 0, 0 };
		boolean a = false, b = false, c = false, secondpass = false, thirdpass = false;
		int currentTree = getRandom(0, 3);
		int firstValue = 0, secondValue = 0;

		if (currentTree == 0)
		{
			a = true;
			firstValue = getRandom(0, 31);
			array[0] = firstValue;
		} else if (currentTree == 1)
		{
			b = true;
			firstValue = getRandom(0, 31);
			array[1] = firstValue;
		} else
		{
			c = true;
			firstValue = getRandom(0, 31);
			array[2] = firstValue;
		}

		while (secondpass == false)
		{
			currentTree = getRandom(0, 3);

			if (currentTree == 0 && a != true)
			{
				a = true;
				secondValue = getRandom(0, 31 - firstValue);
				array[0] = secondValue;
				secondpass = true;
			}
			if (currentTree == 1 && b != true)
			{
				b = true;
				secondValue = getRandom(0, 31 - firstValue);
				array[1] = secondValue;
				secondpass = true;
			}
			if (currentTree == 2 && c != true)
			{
				c = true;
				secondValue = getRandom(0, 31 - firstValue);
				array[2] = secondValue;
				secondpass = true;
			}

		}

		while (thirdpass == false)
		{
			currentTree = getRandom(0, 3);

			if (currentTree == 0 && a != true)
			{
				a = true;
				array[0] = 30 - (firstValue + secondValue);
				thirdpass = true;
			}
			if (currentTree == 1 && b != true)
			{
				b = true;
				array[1] = 30 - (firstValue + secondValue);
				thirdpass = true;
			}
			if (currentTree == 2 && c != true)
			{
				c = true;
				array[2] = 30 - (firstValue + secondValue);
				thirdpass = true;
			}

		}

		return array;

	}

}
