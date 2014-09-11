package com.fourfoureight.lolhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.fourfoureight.lolhelper.General_Info.items;

public class ItemInfo extends ActionBarActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_info);

		FrameLayout layout = (FrameLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		//
		// Kitae's Bloodrazor and Mana Manipulator have been removed since the creation of this database. They will be
		// inaccessible by our app.
		//

		int i = 0;

		items.runMain();

		Intent intent = getIntent();
		String message = intent.getStringExtra("EXTRA_MESSAGE");
		if (message.equals("total_transparent"))
		{
			finish();
		}

		ImageView icon = (ImageView) findViewById(R.id.icon);

		message = message.replaceAll("[^a-zA-Z]+", "").toLowerCase();

		if (message.equals("abyssalscepter"))
		{
			i = 0;
		} else if (message.equals("aegisofthelegion"))
		{
			i = 1;
		} else if (message.equals("aetherwisp"))
		{
			i = 2;
		} else if (message.equals("amplifyingtome"))
		{
			i = 3;
		} else if (message.equals("ancientcoin"))
		{
			i = 4;
		} else if (message.equals("archangelsstaff"))
		{
			i = 5;
		} else if (message.equals("athenesunholygrail"))
		{
			i = 6;
		} else if (message.equals("atmasimpaler"))
		{
			i = 7;
		} else if (message.equals("augmentdeath"))
		{
			i = 8;
		} else if (message.equals("augmentgravity"))
		{
			i = 9;
		} else if (message.equals("augmentpower"))
		{
			i = 10;
		} else if (message.equals("bfsword"))
		{
			i = 11;
		} else if (message.equals("bannerofcommand"))
		{
			i = 12;
		} else if (message.equals("bansheesveil"))
		{
			i = 13;
		} else if (message.equals("berserkersgreaves") || message.equals("berserkergreaves"))
		{
			i = 14;
		} else if (message.equals("bilgewatercutlass"))
		{
			i = 15;
		} else if (message.equals("blackfiretorch"))
		{
			i = 16;
		} else if (message.equals("bladeoftheruinedking"))
		{
			i = 17;
		} else if (message.equals("blastingwand"))
		{
			i = 18;
		} else if (message.equals("bonetoothnecklaceblue"))
		{
			i = 19;
		} else if (message.equals("bonetoothnecklacegreen"))
		{
			i = 20;
		} else if (message.equals("bonetoothnecklacered"))
		{
			i = 21;
		} else if (message.equals("bonetoothnecklaceyellow"))
		{
			i = 22;
		} else if (message.equals("bootsofmobility"))
		{
			i = 23;
		} else if (message.equals("bootsofspeed"))
		{
			i = 24;
		} else if (message.equals("bootsofswiftness"))
		{
			i = 25;
		} else if (message.equals("brawlersgloves"))
		{
			i = 26;
		} else if (message.equals("catalysttheprotector"))
		{
			i = 27;
		} else if (message.equals("chainvest"))
		{
			i = 28;
		} else if (message.equals("chaliceofharmony"))
		{
			i = 29;
		} else if (message.equals("cloakofagility"))
		{
			i = 30;
		} else if (message.equals("clotharmor"))
		{
			i = 31;
		} else if (message.equals("crystallineflask"))
		{
			i = 32;
		} else if (message.equals("dagger"))
		{
			i = 33;
		} else if (message.equals("deathfiregrasp"))
		{
			i = 34;
		} else if (message.equals("dervishblade"))
		{
			i = 35;
		} else if (message.equals("doransblade"))
		{
			i = 36;
		} else if (message.equals("doransring"))
		{
			i = 37;
		} else if (message.equals("doransshield"))
		{
			i = 38;
		} else if (message.equals("elixirofbrilliance"))
		{
			i = 39;
		} else if (message.equals("elixiroffortitude"))
		{
			i = 40;
		} else if (message.equals("enchantmentalacrity"))
		{
			i = 41;
		} else if (message.equals("enchantmentcaptain"))
		{
			i = 42;
		} else if (message.equals("enchantmentdistortion"))
		{
			i = 43;
		} else if (message.equals("enchantmentfuror"))
		{
			i = 44;
		} else if (message.equals("enchantmenthomeguard"))
		{
			i = 45;
		} else if (message.equals("entropy"))
		{
			i = 46;
		} else if (message.equals("executionerscalling"))
		{
			i = 47;
		} else if (message.equals("explorersward"))
		{
			i = 48;
		} else if (message.equals("faceofthemountain"))
		{
			i = 49;
		} else if (message.equals("faeriecharm"))
		{
			i = 50;
		} else if (message.equals("farsightorb"))
		{
			i = 51;
		} else if (message.equals("feralflare"))
		{
			i = 52;
		} else if (message.equals("fiendishcodex"))
		{
			i = 53;
		} else if (message.equals("forbiddenidol"))
		{
			i = 54;
		} else if (message.equals("frostqueensclaim"))
		{
			i = 55;
		} else if (message.equals("frostfang"))
		{
			i = 56;
		} else if (message.equals("frozenheart"))
		{
			i = 57;
		} else if (message.equals("frozenmallet"))
		{
			i = 58;
		} else if (message.equals("giantsbelt"))
		{
			i = 59;
		} else if (message.equals("glacialshroud"))
		{
			i = 60;
		} else if (message.equals("greaterstealthtotem"))
		{
			i = 61;
		} else if (message.equals("greatervisiontotem"))
		{
			i = 62;
		} else if (message.equals("grezsspectrallantern"))
		{
			i = 63;
		} else if (message.equals("guardianangel"))
		{
			i = 64;
		} else if (message.equals("guardianshorn"))
		{
			i = 65;
		} else if (message.equals("guinsoosrageblade"))
		{
			i = 66;
		} else if (message.equals("hauntingguise"))
		{
			i = 67;
		} else if (message.equals("headofkhazix"))
		{
			i = 68;
		} else if (message.equals("healthpotion"))
		{
			i = 69;
		} else if (message.equals("hexdrinker"))
		{
			i = 70;
		} else if (message.equals("hextechgunblade"))
		{
			i = 71;
		} else if (message.equals("hextechsweeper"))
		{
			i = 72;
		} else if (message.equals("huntersmachete"))
		{
			i = 73;
		} else if (message.equals("iceborngauntlet"))
		{
			i = 74;
		} else if (message.equals("ichorofillumination"))
		{
			i = 75;
		} else if (message.equals("ichorofrage"))
		{
			i = 76;
		} else if (message.equals("infinityedge"))
		{
			i = 77;
		} else if (message.equals("ionianbootsoflucidity"))
		{
			i = 78;
		} else if (message.equals("kindlegem"))
		{
			i = 79;
		} else if (message.equals("kitaesbloodrazor"))
		{ // inaccessible
			i = 80;
		} else if (message.equals("lastwhisper"))
		{
			i = 81;
		} else if (message.equals("liandrystorment"))
		{
			i = 82;
		} else if (message.equals("lichbane"))
		{
			i = 83;
		} else if (message.equals("locketoftheironsolari"))
		{
			i = 84;
		} else if (message.equals("longsword"))
		{
			i = 85;
		} else if (message.equals("lordvandammspillager"))
		{
			i = 86;
		} else if (message.equals("madredsrazors"))
		{
			i = 87;
		} else if (message.equals("manamanipulator"))
		{ // inaccessible
			i = 88;
		} else if (message.equals("manapotion"))
		{
			i = 89;
		} else if (message.equals("manamune"))
		{
			i = 90;
		} else if (message.equals("mawofmalmortius"))
		{
			i = 91;
		} else if (message.equals("mejaissoulstealer"))
		{
			i = 92;
		} else if (message.equals("mercurialscimitar"))
		{
			i = 93;
		} else if (message.equals("mercurystreads"))
		{
			i = 94;
		} else if (message.equals("mikaelscrucible"))
		{
			i = 95;
		} else if (message.equals("moonflairspellblade"))
		{
			i = 96;
		} else if (message.equals("morellonomicon"))
		{
			i = 97;
		} else if (message.equals("muramana"))
		{
			i = 98;
		} else if (message.equals("nashorstooth"))
		{
			i = 99;
		} else if (message.equals("needlesslylargerod"))
		{
			i = 100;
		} else if (message.equals("negatroncloak"))
		{
			i = 101;
		} else if (message.equals("ninjatabi"))
		{
			i = 102;
		} else if (message.equals("nomadsmedallion"))
		{
			i = 103;
		} else if (message.equals("nullmagicmantle"))
		{
			i = 104;
		} else if (message.equals("odynsveil"))
		{
			i = 105;
		} else if (message.equals("ohmwrecker"))
		{
			i = 106;
		} else if (message.equals("oraclesextract"))
		{
			i = 107;
		} else if (message.equals("oracleslens"))
		{
			i = 108;
		} else if (message.equals("orbofwinter"))
		{
			i = 109;
		} else if (message.equals("overlordsbloodmail"))
		{
			i = 110;
		} else if (message.equals("phage"))
		{
			i = 111;
		} else if (message.equals("phantomdancer"))
		{
			i = 112;
		} else if (message.equals("pickaxe"))
		{
			i = 113;
		} else if (message.equals("porosnax"))
		{
			i = 114;
		} else if (message.equals("prospectorsblade"))
		{
			i = 115;
		} else if (message.equals("prospectorsring"))
		{
			i = 116;
		} else if (message.equals("quicksilversash"))
		{
			i = 117;
		} else if (message.equals("rabadonsdeathcap"))
		{
			i = 118;
		} else if (message.equals("randuinsomen"))
		{
			i = 119;
		} else if (message.equals("ravenoushydra"))
		{
			i = 120;
		} else if (message.equals("recurvebow"))
		{
			i = 121;
		} else if (message.equals("rejuvenationbead"))
		{
			i = 122;
		} else if (message.equals("relicshield"))
		{
			i = 123;
		} else if (message.equals("rodofages"))
		{
			i = 124;
		} else if (message.equals("rubycrystal"))
		{
			i = 125;
		} else if (message.equals("rubysightstone"))
		{
			i = 126;
		} else if (message.equals("runaanshurricane"))
		{
			i = 127;
		} else if (message.equals("rylaiscrystalscepter"))
		{
			i = 128;
		} else if (message.equals("sanguineblade"))
		{
			i = 129;
		} else if (message.equals("sapphirecrystal"))
		{
			i = 130;
		} else if (message.equals("scryingorb"))
		{
			i = 131;
		} else if (message.equals("seekersarmguard"))
		{
			i = 132;
		} else if (message.equals("seraphsembrace"))
		{
			i = 133;
		} else if (message.equals("sheen"))
		{
			i = 134;
		} else if (message.equals("sightstone"))
		{
			i = 135;
		} else if (message.equals("sorcerershoes") || message.equals("sorcerersshoes"))
		{
			i = 136;
		} else if (message.equals("spectrescowl"))
		{
			i = 137;
		} else if (message.equals("spellthiefsedge"))
		{
			i = 138;
		} else if (message.equals("spiritoftheancientgolem"))
		{
			i = 139;
		} else if (message.equals("spiritoftheelderlizard"))
		{
			i = 140;
		} else if (message.equals("spiritofthespectralwraith"))
		{
			i = 141;
		} else if (message.equals("spiritstone"))
		{
			i = 142;
		} else if (message.equals("spiritvisage"))
		{
			i = 143;
		} else if (message.equals("statikkshiv"))
		{
			i = 144;
		} else if (message.equals("stealthward"))
		{
			i = 145;
		} else if (message.equals("stinger"))
		{
			i = 146;
		} else if (message.equals("sunfirecape"))
		{
			i = 147;
		} else if (message.equals("sweepinglens"))
		{
			i = 148;
		} else if (message.equals("swordofthedivine"))
		{
			i = 149;
		} else if (message.equals("swordoftheoccult"))
		{
			i = 150;
		} else if (message.equals("talismanofascension"))
		{
			i = 151;
		} else if (message.equals("targonsbrace"))
		{
			i = 152;
		} else if (message.equals("tearofthegoddess"))
		{
			i = 153;
		} else if (message.equals("theblackcleaver"))
		{
			i = 154;
		} else if (message.equals("thebloodthrister"))
		{
			i = 155;
		} else if (message.equals("thebrutalizer"))
		{
			i = 156;
		} else if (message.equals("thehexcore"))
		{
			i = 157;
		} else if (message.equals("thelightbringer"))
		{
			i = 158;
		} else if (message.equals("thornmail"))
		{
			i = 159;
		} else if (message.equals("tiamat"))
		{
			i = 160;
		} else if (message.equals("totalbiscuitofrejuvenation"))
		{
			i = 161;
		} else if (message.equals("trinityforce"))
		{
			i = 162;
		} else if (message.equals("twinshadows"))
		{
			i = 163;
		} else if (message.equals("vampiricscepter"))
		{
			i = 164;
		} else if (message.equals("visionward"))
		{
			i = 165;
		} else if (message.equals("voidstaff"))
		{
			i = 166;
		} else if (message.equals("wardensmail"))
		{
			i = 167;
		} else if (message.equals("wardingtotem"))
		{
			i = 168;
		} else if (message.equals("warmogsarmor"))
		{
			i = 169;
		} else if (message.equals("wickedhatchet"))
		{
			i = 170;
		} else if (message.equals("willoftheancients"))
		{
			i = 171;
		} else if (message.equals("witsend"))
		{
			i = 172;
		} else if (message.equals("woogletswitchcap"))
		{
			i = 173;
		} else if (message.equals("wriggleslantern"))
		{
			i = 174;
		} else if (message.equals("youmuusghostblade"))
		{
			i = 175;
		} else if (message.equals("zeal"))
		{
			i = 176;
		} else if (message.equals("zekesherald"))
		{
			i = 177;
		} else if (message.equals("zephyr"))
		{
			i = 178;
		} else
		{
			i = 179;
		}

		// Set picture
		int resID = getResources().getIdentifier(message, "drawable", getPackageName());
		icon.setImageResource(resID);

		String name = items.getName(items.itemsArray[i]);
		String availability = items.getAvailability(items.itemsArray[i]);
		String tier = items.getTier(items.itemsArray[i]);
		String stats = items.getStats(items.itemsArray[i]);
		String passive1 = items.getPassive1(items.itemsArray[i]);
		String passive2 = items.getPassive2(items.itemsArray[i]);
		String passive3 = items.getPassive3(items.itemsArray[i]);
		String passive4 = items.getPassive4(items.itemsArray[i]);
		String passive5 = items.getPassive5(items.itemsArray[i]);
		String menu = items.getMenu(items.itemsArray[i]);
		String itemCost = items.getItemCost(items.itemsArray[i]);
		String sellValue = items.getSellValue(items.itemsArray[i]);

		TextView nameText = (TextView) findViewById(R.id.nameDis);
		TextView availabilityText = (TextView) findViewById(R.id.availabilityDis);
		TextView tierText = (TextView) findViewById(R.id.tierDis);
		TextView statsText = (TextView) findViewById(R.id.statsDis);
		TextView passive1Text = (TextView) findViewById(R.id.passive1Dis);
		TextView passive2Text = (TextView) findViewById(R.id.passive2Dis);
		TextView passive3Text = (TextView) findViewById(R.id.passive3Dis);
		TextView passive4Text = (TextView) findViewById(R.id.passive4Dis);
		TextView passive5Text = (TextView) findViewById(R.id.passive5Dis);
		TextView menuText = (TextView) findViewById(R.id.menuDis);
		TextView itemCostText = (TextView) findViewById(R.id.costDis);
		TextView sellValueText = (TextView) findViewById(R.id.sellDis);

		// Setting Text for TextViews
		nameText.setText(name);
		availabilityText.setText("Availability: \n" + availability);
		tierText.setText("Tier: \n" + tier);
		statsText.setText("Stats: \n" + stats);
		passive1Text.setText(passive1);
		passive2Text.setText(passive2);
		passive3Text.setText(passive3);
		passive4Text.setText(passive4);
		passive5Text.setText(passive5);
		menuText.setText("Menu: \n" + menu);
		itemCostText.setText("Cost: \n" + itemCost);
		sellValueText.setText("Sell Value: \n" + sellValue);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_info, menu);
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
