package com.fourfoureight.lolhelper;

import java.io.IOException;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Leaguecounters extends ActionBarActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaguecounters);

		RelativeLayout layout = (RelativeLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		DBcounters myDbHelper = new DBcounters(this);

		try
		{

			myDbHelper.createDataBase();

		} catch (IOException ioe)
		{

			throw new Error("Unable to create database");

		}

		try
		{

			myDbHelper.openDataBase();

		} catch (SQLException sqle)
		{

			throw sqle;

		}

		String foo[] =
		{ "_id", "Name", "Counter1", "Counter2", "Counter3", "GA1", "GA2",
				"GA3" };
		Intent intent = getIntent();
		String champ = intent.getStringExtra("champion");
		SQLiteDatabase counters = myDbHelper.getReadableDatabase();
		Cursor result = counters.query("counters", foo, "Name=\"" + champ + "\"",
				null, null, null, null);
		result.moveToFirst();

		// Set images for champion
		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		iv.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						champ.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", getPackageName())));

		ImageView iv0 = (ImageView) findViewById(R.id.imageView2);
		iv0.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("Counter1"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", getPackageName())));

		ImageView iv1 = (ImageView) findViewById(R.id.imageView3);
		iv1.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("Counter2"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", getPackageName())));

		ImageView iv2 = (ImageView) findViewById(R.id.imageView4);
		iv2.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("Counter3"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", getPackageName())));

		ImageView iv3 = (ImageView) findViewById(R.id.imageView5);
		iv3.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("GA1"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", getPackageName())));

		ImageView iv4 = (ImageView) findViewById(R.id.imageView6);
		iv4.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("GA2"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", getPackageName())));

		ImageView iv5 = (ImageView) findViewById(R.id.imageView7);
		iv5.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("GA3"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", getPackageName())));

		// Set text for champion 3 countered by and 3 counters
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(champ);

		TextView tv0 = (TextView) findViewById(R.id.TextView02);
		tv0.setText(result.getString(result.getColumnIndex("Counter1")));

		TextView tv1 = (TextView) findViewById(R.id.textView2);
		tv1.setText(result.getString(result.getColumnIndex("Counter2")));

		TextView tv2 = (TextView) findViewById(R.id.TextView04);
		tv2.setText(result.getString(result.getColumnIndex("Counter3")));

		TextView tv3 = (TextView) findViewById(R.id.TextView01);
		tv3.setText(result.getString(result.getColumnIndex("GA1")));

		TextView tv4 = (TextView) findViewById(R.id.TextView05);
		tv4.setText(result.getString(result.getColumnIndex("GA2")));

		TextView tv5 = (TextView) findViewById(R.id.TextView03);
		tv5.setText(result.getString(result.getColumnIndex("GA3")));

		result.close();
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
