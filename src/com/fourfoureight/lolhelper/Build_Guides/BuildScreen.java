package com.fourfoureight.lolhelper.Build_Guides;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.fourfoureight.lolhelper.GlobalVariables;
import com.fourfoureight.lolhelper.R;

public class BuildScreen extends ActionBarActivity
{

	public static String EXTRA_MESSAGE = "";
	public static String TYPE = "";
	public static int arrayValue = 0;

	// Screen Size
	public static double screenInches;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_build_screen);

		LinearLayout layout = (LinearLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}
		
		

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
		
		// Calculate the screen diagonal in inches.
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width=dm.widthPixels;
		int height=dm.heightPixels;
		int dens=dm.densityDpi;
		double wi=(double)width/(double)dens;
		double hi=(double)height/(double)dens;
		double x = Math.pow(wi,2);
		double y = Math.pow(hi,2);
		screenInches = Math.sqrt(x+y);
		
    	// Calculate how many pixels is 180 dp, which is the size of championIcon.
        dm = getResources().getDisplayMetrics();
        float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, dm);
        float dpInPx2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, dm);
		
		// Set the layout
		ImageView championIcon = (ImageView) findViewById(R.id.icon);
		if (screenInches < 6){
			championIcon.getLayoutParams().height = ((int) (1 * dpInPx));		// A phone is less than 6 inches.
			s.getLayoutParams().height = ((int) (1 * dpInPx2));
		}
		else if (screenInches < 9){
			championIcon.getLayoutParams().height = ((int) (1.8 * dpInPx));		// Small tablets are considered between 6 to 9 inches.
			s.getLayoutParams().height = ((int) (1.5 * dpInPx2));
		}
		else{
			championIcon.getLayoutParams().height = ((int) (2.2 * dpInPx));		// For big tablets (larger than 9 inches).
			s.getLayoutParams().height = ((int) (2 * dpInPx2));
		}
		
	}

	public void viewtop(View view)
	{
		Intent intent = new Intent(this, BuildGuides.class);
		intent.putExtra(EXTRA_MESSAGE, EXTRA_MESSAGE);
		TYPE = "Top";
		intent.putExtra(TYPE, TYPE);
		startActivity(intent);
	}

	public void viewmid(View view)
	{
		Intent intent = new Intent(this, BuildGuides.class);
		intent.putExtra(EXTRA_MESSAGE, EXTRA_MESSAGE);
		TYPE = "Mid";
		intent.putExtra(TYPE, TYPE);
		startActivity(intent);
	}

	public void viewadc(View view)
	{
		Intent intent = new Intent(this, BuildGuides.class);
		intent.putExtra(EXTRA_MESSAGE, EXTRA_MESSAGE);
		TYPE = "ADC";
		intent.putExtra(TYPE, TYPE);
		startActivity(intent);
	}

	public void viewsupp(View view)
	{
		Intent intent = new Intent(this, BuildGuides.class);
		intent.putExtra(EXTRA_MESSAGE, EXTRA_MESSAGE);
		TYPE = "Support";
		intent.putExtra(TYPE, TYPE);
		startActivity(intent);
	}

	public void viewjung(View view)
	{
		Intent intent = new Intent(this, BuildGuides.class);
		intent.putExtra(EXTRA_MESSAGE, EXTRA_MESSAGE);
		TYPE = "Jungle";
		intent.putExtra(TYPE, TYPE);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.build_screen, menu);
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
