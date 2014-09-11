package com.fourfoureight.lolhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.fourfoureight.lolhelper.General_Info.SSpell;

public class SummonerSpellInfo extends ActionBarActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summoner_spell_info);

		FrameLayout layout = (FrameLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		int i = 0;

		SSpell.runSSpells();

		Intent intent = getIntent();
		String message = intent.getStringExtra(SummonerSpells.EXTRA_MESSAGE);

		ImageView icon = (ImageView) findViewById(R.id.icon);

		if (message.equals("Barrier"))
		{
			i = 0;
		} else if (message.equals("Clairvoyance"))
		{
			i = 1;
		} else if (message.equals("Clarity"))
		{
			i = 2;
		} else if (message.equals("Cleanse"))
		{
			i = 3;
		} else if (message.equals("Exhaust"))
		{
			i = 4;
		} else if (message.equals("Flash"))
		{
			i = 5;
		} else if (message.equals("Garrison"))
		{
			i = 6;
		} else if (message.equals("Ghost"))
		{
			i = 7;
		} else if (message.equals("Heal"))
		{
			i = 8;
		} else if (message.equals("Ignite"))
		{
			i = 9;
		} else if (message.equals("Revive"))
		{
			i = 10;
		} else if (message.equals("Smite"))
		{
			i = 11;
		} else
		{
			i = 12;
		}

		switch (i)
		{
		case 0:
			icon.setImageResource(R.drawable.barrier);
			break;
		case 1:
			icon.setImageResource(R.drawable.clairvoyance);
			break;
		case 2:
			icon.setImageResource(R.drawable.clarity);
			break;
		case 3:
			icon.setImageResource(R.drawable.cleanse);
			break;
		case 4:
			icon.setImageResource(R.drawable.exhaust);
			break;
		case 5:
			icon.setImageResource(R.drawable.flash);
			break;
		case 6:
			icon.setImageResource(R.drawable.garrison);
			break;
		case 7:
			icon.setImageResource(R.drawable.ghost);
			break;
		case 8:
			icon.setImageResource(R.drawable.heal);
			break;
		case 9:
			icon.setImageResource(R.drawable.ignite);
			break;
		case 10:
			icon.setImageResource(R.drawable.revive);
			break;
		case 11:
			icon.setImageResource(R.drawable.smite);
			break;
		case 12:
			icon.setImageResource(R.drawable.teleport);
			break;
		default:
			break;
		}

		String name = SSpell.getName(SSpell.summonerspells[i]);
		String effect = SSpell.getEffect(SSpell.summonerspells[i]);
		int cooldown = SSpell.getCooldown(SSpell.summonerspells[i]);
		String range = SSpell.getRange(SSpell.summonerspells[i]);
		boolean breakstealth = SSpell.getBreakStealth(SSpell.summonerspells[i]);
		int level = SSpell.getLevel(SSpell.summonerspells[i]);

		TextView nameText = (TextView) findViewById(R.id.nameDis);
		TextView effectText = (TextView) findViewById(R.id.effectDis); // effectDis *************************
		TextView cooldownText = (TextView) findViewById(R.id.cooldownDis); // cooldownDis *****************************
		TextView rangeText = (TextView) findViewById(R.id.rangeDis); // rangeDis **********************************
		TextView breakstealthText = (TextView) findViewById(R.id.breakstealthDis); // breakstealthDis *****************
		TextView levelText = (TextView) findViewById(R.id.levelDis); // levelDis *******************************

		// Setting Text for TextViews
		nameText.setText(name);
		effectText.setText("Effect: \n" + effect);
		cooldownText.setText("Cooldown: \n" + cooldown);
		rangeText.setText("Range: \n" + range);
		if (breakstealth)
		{
			breakstealthText.setText("Breaks Stealth: \nYes");
		}
		else
		{
			breakstealthText.setText("Breaks Stealth: \nNo");
		}
		levelText.setText("Level: \n" + level);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
