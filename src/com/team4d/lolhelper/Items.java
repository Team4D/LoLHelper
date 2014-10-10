package com.team4d.lolhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.team4d.lolhelper.api.APIData;

public class Items extends Activity
{

	static String EXTRA_MESSAGE = "";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_items);

		LinearLayout layout = (LinearLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, APIData.getItemList());
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
				int itemID = getResources().getIdentifier(EXTRA_MESSAGE.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
						"drawable", getPackageName());
				icon.setImageResource(itemID);
			}

			@Override
			public void onNothingSelected(AdapterView arg0)
			{
				// do something else
			}
		});

	}

	public void iteminfo(View view)
	{
		Intent intent = new Intent(this, ItemInfo.class);
		intent.putExtra("EXTRA_MESSAGE", EXTRA_MESSAGE);
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
