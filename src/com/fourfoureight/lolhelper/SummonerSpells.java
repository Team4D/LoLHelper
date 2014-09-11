package com.fourfoureight.lolhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.fourfoureight.lolhelper.General_Info.SSpell;

public class SummonerSpells extends ActionBarActivity
{

	static String EXTRA_MESSAGE = "";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summoner_spells);

		LinearLayout layout = (LinearLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		SSpell.runSSpells();

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.summonerspell_array, R.layout.spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		final ImageView icon = (ImageView) findViewById(R.id.icon);

		Spinner s = (Spinner) findViewById(R.id.spinner1);
		s.setAdapter(adapter);
		s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView adapter, View v, int i, long lng)
			{
				EXTRA_MESSAGE = adapter.getItemAtPosition(i).toString();

				if (EXTRA_MESSAGE.equals("Barrier"))
				{
					i = 0;
				} else if (EXTRA_MESSAGE.equals("Clairvoyance"))
				{
					i = 1;
				} else if (EXTRA_MESSAGE.equals("Clarity"))
				{
					i = 2;
				} else if (EXTRA_MESSAGE.equals("Cleanse"))
				{
					i = 3;
				} else if (EXTRA_MESSAGE.equals("Exhaust"))
				{
					i = 4;
				} else if (EXTRA_MESSAGE.equals("Flash"))
				{
					i = 5;
				} else if (EXTRA_MESSAGE.equals("Garrison"))
				{
					i = 6;
				} else if (EXTRA_MESSAGE.equals("Ghost"))
				{
					i = 7;
				} else if (EXTRA_MESSAGE.equals("Heal"))
				{
					i = 8;
				} else if (EXTRA_MESSAGE.equals("Ignite"))
				{
					i = 9;
				} else if (EXTRA_MESSAGE.equals("Revive"))
				{
					i = 10;
				} else if (EXTRA_MESSAGE.equals("Smite"))
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

			}

			@Override
			public void onNothingSelected(AdapterView arg0)
			{
				// do something else
			}
		});

	}

	public void sspellinfo(View view)
	{
		Intent intent = new Intent(this, SummonerSpellInfo.class);
		intent.putExtra(EXTRA_MESSAGE, EXTRA_MESSAGE);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.items, menu);
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
