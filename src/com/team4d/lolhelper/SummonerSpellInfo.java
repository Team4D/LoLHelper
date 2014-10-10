package com.team4d.lolhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.staticdata.summonerspell.SummonerSpell;

public class SummonerSpellInfo extends Activity
{

	private class grabSpell extends AsyncTask<String, Void, SummonerSpell>
	{
		@Override
		protected SummonerSpell doInBackground(String... spell_name)
		{
			SummonerSpell c = APIData.getSummonerSpellByName(spell_name[0]);
			// Note: This return value is passed as a parameter to onPostExecute
			return c;
		}

		@Override
		protected void onPostExecute(SummonerSpell spell)
		{
			/*
			 * String name = SSpell.getName(SSpell.summonerspells[i]);
			 * String effect = SSpell.getEffect(SSpell.summonerspells[i]);
			 * int cooldown = SSpell.getCooldown(SSpell.summonerspells[i]);
			 * String range = SSpell.getRange(SSpell.summonerspells[i]);
			 * boolean breakstealth = SSpell.getBreakStealth(SSpell.summonerspells[i]);
			 * int level = SSpell.getLevel(SSpell.summonerspells[i]);
			 */
			TextView nameText = (TextView) findViewById(R.id.nameDis);
			TextView effectText = (TextView) findViewById(R.id.effectDis); // effectDis *************************
			TextView cooldownText = (TextView) findViewById(R.id.cooldownDis); // cooldownDis
																				// *****************************
			TextView rangeText = (TextView) findViewById(R.id.rangeDis); // rangeDis **********************************
			TextView breakstealthText = (TextView) findViewById(R.id.breakstealthDis); // breakstealthDis
																						// *****************
			TextView levelText = (TextView) findViewById(R.id.levelDis); // levelDis *******************************

			// Setting Text for TextViews
			nameText.setText(spell.getName());
			effectText.setText("Effect: \n" + spell.getDescription());
			cooldownText.setText("Cooldown: \n" + spell.getCooldownBurn());
			rangeText.setText("Range: \n" + spell.getRangeBurn());
			// TODO: Either implement breakstealth or delete completely
			levelText.setText("Level: \n" + spell.getSummonerLevel());
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_summoner_spell_info);

		FrameLayout layout = (FrameLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		Intent intent = getIntent();
		String message = intent.getStringExtra(SummonerSpells.EXTRA_MESSAGE);

		ImageView icon = (ImageView) findViewById(R.id.icon);
		int resID = getResources().getIdentifier(message.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
				"drawable", getPackageName());
		icon.setImageResource(resID);

		new grabSpell().execute(message);
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
