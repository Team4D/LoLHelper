package com.team4d.lolhelper;

import com.fourfoureight.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.staticdata.summonerspell.SummonerSpell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class SummonerSpells extends Activity
{
	
	private class getSpells extends AsyncTask<Context, Void, ArrayAdapter<String>>
	{
		@Override
		protected ArrayAdapter<String> doInBackground(Context... context)
		{
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(context[0], R.layout.spinner_item, APIData.getSummonerSpellList());
			// Note: This return value is passed as a parameter to onPostExecute
			return adapter;
		}

		@Override
		protected void onPostExecute(ArrayAdapter<String> adapter)
		{
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
					int resID = getResources().getIdentifier(EXTRA_MESSAGE.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
							"drawable", getPackageName());
					icon.setImageResource(resID);
				}

				@Override
				public void onNothingSelected(AdapterView arg0)
				{
					// do something else
				}
			});
		}
	}

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

		new getSpells().execute(this);
		
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
