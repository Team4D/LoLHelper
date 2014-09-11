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

import com.fourfoureight.lolhelper.General_Info.SpellDatabase;

public class Counters extends ActionBarActivity
{

	public static String EXTRA_MESSAGE = "";
	public static int arrayValue = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counters);

		LinearLayout layout = (LinearLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		SpellDatabase.makeSpellDatabase();

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.champion_array, R.layout.spinner_item);
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

				icon.setImageResource(getResources().getIdentifier(
						EXTRA_MESSAGE.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable", getPackageName()));

				if (EXTRA_MESSAGE.equals("Cho Gath"))
				{
					EXTRA_MESSAGE = "Cho'Gath";
				} else if (EXTRA_MESSAGE.equals("Kha Zix"))
				{
					EXTRA_MESSAGE = "Kha'Zix";
				} else if (EXTRA_MESSAGE.equals("Kog Maw"))
				{
					EXTRA_MESSAGE = "Kog'Maw";
				} else if (EXTRA_MESSAGE.equals("Vel Koz"))
				{
					EXTRA_MESSAGE = "Vel'Koz";
				}
			}

			@Override
			public void onNothingSelected(AdapterView arg0)
			{
				// do something else
			}
		});
	}

	public void leaguecounters(View view)
	{
		Intent intent = new Intent(this, Leaguecounters.class);
		intent.putExtra("champion", EXTRA_MESSAGE);
		startActivity(intent);
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
