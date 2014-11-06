package com.team4d.lolhelper.fragments;

import java.util.Random;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.R.drawable;
import com.team4d.lolhelper.R.id;
import com.team4d.lolhelper.R.layout;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.staticdata.champion.Champion;
import com.team4d.lolhelper.api.dto.staticdata.champion.ChampionSpell;

public class BuildRouletteFragment extends Fragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_build_roulette, container, false);
	}

	@Override
	public void onStart()
	{
		super.onStart();
		new getRandomData(this.getActivity(), this.getView()).execute();
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
	
	// Class to get name of a champion's spell.
	private class CurrentChampion extends AsyncTask<Void, String, String[]>{
		private Champion champion;
		private String name;
		private final View view;
		private final int spellIndex;
		
		public CurrentChampion(String championName, View v, int spell){
			name = championName;
			view = v;
			spellIndex = spell;
		}
		
		@Override
		protected String[] doInBackground(Void... params) {
			champion = APIData.getChampionByName(name);
			return null;
		}
		
		protected void onPostExecute(String[] result){
			if (view == null || view.isShown() == false)
			{
				return;
			}
			final TextView textView12 = (TextView) view.findViewById(R.id.text_spell_name);
			textView12.setText(champion.getSpells().get(spellIndex).getName());
		}
	}
	
	// Class to get all random data.
	private class getRandomData extends AsyncTask<Void, String, String[]>
	{
		private final Context context;
		private final View view;
		private String[] championList;
		private String[] summonerSpellList;

		public getRandomData(Context c, View v)
		{
			context = c;
			view = v;
		}

		@Override
		protected String[] doInBackground(Void... params) {
			championList = APIData.getChampionList();
			summonerSpellList = APIData.getSummonerSpellList();
			return null;
		}
		
		@Override
		protected void onPostExecute(String[] result){
			if (view == null || view.isShown() == false)
			{
				return;
			}

			FrameLayout layout = (FrameLayout) view.findViewById(R.id.container);
			layout.setBackgroundResource(R.drawable.bg);
			
			final TextView textView1 = (TextView) view.findViewById(R.id.item1);
			final TextView textView2 = (TextView) view.findViewById(R.id.item2);
			final TextView textView3 = (TextView) view.findViewById(R.id.item3);
			final TextView textView4 = (TextView) view.findViewById(R.id.item4);
			final TextView textView5 = (TextView) view.findViewById(R.id.item5);
			final TextView textView6 = (TextView) view.findViewById(R.id.item6); // Items 1-6
			final TextView textView12 = (TextView) view.findViewById(R.id.item7);	// Trinket
			final TextView textView7 = (TextView) view.findViewById(R.id.champname); // Champ Name
			final TextView textView8 = (TextView) view.findViewById(R.id.mastery); // Masteries
			final TextView textView9 = (TextView) view.findViewById(R.id.summspell1);
			final TextView textView10 = (TextView) view.findViewById(R.id.summspell2); // Summoner Spells
			final TextView textView11 = (TextView) view.findViewById(R.id.spell); // Spell Button (Q W or E)

			final ImageView imageView1 = (ImageView) view.findViewById(R.id.iitem1);
			final ImageView imageView2 = (ImageView) view.findViewById(R.id.iitem2);
			final ImageView imageView3 = (ImageView) view.findViewById(R.id.iitem3);
			final ImageView imageView4 = (ImageView) view.findViewById(R.id.iitem4);
			final ImageView imageView5 = (ImageView) view.findViewById(R.id.iitem5);
			final ImageView imageView6 = (ImageView) view.findViewById(R.id.iitem6);
			final ImageView imageView12 = (ImageView) view.findViewById(R.id.iitem7);	// Trinket
			final ImageView imageView7 = (ImageView) view.findViewById(R.id.ichampname);
			final ImageView imageView8 = (ImageView) view.findViewById(R.id.ispell);
			final ImageView imageView9 = (ImageView) view.findViewById(R.id.isummspell1);
			final ImageView imageView10 = (ImageView) view.findViewById(R.id.isummspell2);


			Button rand = (Button) view.findViewById(R.id.btnRandom);
			rand.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					/*
					 * Initialize all variables
					 */
					final String champIcon;
					String item1, item2, item3, item4, item5, item6, item7, mastery;
					int placeholderItem;
					int[] itemArray = new int[61];
					int iconID;
					int[] masteryArray = { 0, 0, 0 };
//					int viktorItem = getRandom(0, 3);
					
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
						item2 = "Perfect Hex Core";
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
					
					item7 = getTrinket(getRandom(0, 4));
					
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
					textView12.setText(item7);

					/*
					 * Set images for all items, champion
					 */
					iconID = getResources().getIdentifier(item1.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
							v.getContext().getPackageName());
					imageView1.setImageResource(iconID);

					iconID = getResources().getIdentifier(item2.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
							v.getContext().getPackageName());
					imageView2.setImageResource(iconID);

					iconID = getResources().getIdentifier(item3.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
							v.getContext().getPackageName());
					imageView3.setImageResource(iconID);

					iconID = getResources().getIdentifier(item4.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
							v.getContext().getPackageName());
					imageView4.setImageResource(iconID);

					iconID = getResources().getIdentifier(item5.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
							v.getContext().getPackageName());
					imageView5.setImageResource(iconID);

					iconID = getResources().getIdentifier(item6.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
							v.getContext().getPackageName());
					imageView6.setImageResource(iconID);

					iconID = getResources().getIdentifier(champIcon.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
							v.getContext().getPackageName());
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
							"drawable", v.getContext().getPackageName());
					imageView8.setImageResource(iconID);

					// Text for spell					
					new CurrentChampion(champIcon, view, intSpellNum - 1).execute();

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
					 * New stuff here: Random summoner spell. 
					 */

					String summSpell0, summSpell1;
					int randomSummSpell0 = getRandom(0, summonerSpellList.length);
					int randomSummSpell1 = getRandom(0, summonerSpellList.length);
					summSpell0 = getSummonerSpellName(randomSummSpell0);

					while (randomSummSpell0 == randomSummSpell1)
					{
						randomSummSpell1 = getRandom(0, summonerSpellList.length);
					}

					summSpell1 = getSummonerSpellName(randomSummSpell1);
					textView9.setText(summSpell0);
					iconID = getResources().getIdentifier(summSpell0.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
							"drawable", v.getContext().getPackageName());
					imageView9.setImageResource(iconID);
					textView10.setText(summSpell1);
					iconID = getResources().getIdentifier(summSpell1.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
							"drawable", v.getContext().getPackageName());
					imageView10.setImageResource(iconID);

					iconID = getResources().getIdentifier(item7.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
							"drawable", v.getContext().getPackageName());
					imageView12.setImageResource(iconID);
				}
			});

			rand.performClick();
		}

		// Method to get random champion. High must be 1 higher than the desired index
		// VALID INDEXES ARE 0 TO 1
		public int getChampionIcon()
		{
			return getRandom(0, championList.length);
		}

		public int getBoots()
		{
			return getRandom(0, 7);
		}

		public int getItem()
		{
			return getRandom(0, 61);
		}


		public String getBootsName(int boots)
		{
			switch (boots)
			{
			case 0:
				return "Ionian Boots of Lucidity";
			case 1:
				return "Berserker's Greaves";
			case 2:
				return "Mercury's Treads";
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

		public String getItemName(int item)
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
				return "Runaan's Hurricane \n(ranged only)";
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
				return "Ravenous Hydra \n(melee only)";
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

		public String getChampionName(int champ)
		{
			return championList[champ];
		}

		public String getSummonerSpellName(int sumSpell)
		{
			return summonerSpellList[sumSpell];
		}

		public int getRandom(int low, int high)
		{
			Random r = new Random();
			int Low = low;
			int High = high;
			int R = r.nextInt(High - Low) + Low;
			return R;

		}
		
		public String getTrinket(int trinket){
			switch (trinket){
			case 0:
				return "Farsight Orb (trinket)";
			case 1:
				return "Greater Stealth Totem (trinket)";
			case 2:
				return "Greater Vision Totem (trinket)";
			case 3:
				return "Oracle's Lens (trinket)";
			default:
				return "headofkhazix";
			}		
		}

		public int[] getMasteries()
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
}
