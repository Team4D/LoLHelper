package com.team4d.lolhelper;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Counters extends Fragment
{

	public static String EXTRA_MESSAGE = "";
	public static int arrayValue = 0;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counters, container, false);
    }
	
	@Override
	public void onStart()
	{

		LinearLayout layout = (LinearLayout) this.getView().findViewById(R.id.container);
		if (((GlobalVariables) this.getActivity().getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getActivity().getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		// SpellDatabase.makeSpellDatabase();

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this.getView().getContext(), R.array.champion_array, R.layout.spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		final ImageView icon = (ImageView) this.getView().findViewById(R.id.icon);

		Spinner s = (Spinner) this.getView().findViewById(R.id.spinner1);
		s.setAdapter(adapter);
		s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView adapter, View v, int i, long lng)
			{
				EXTRA_MESSAGE = adapter.getItemAtPosition(i).toString();

				icon.setImageResource(getResources().getIdentifier(
						EXTRA_MESSAGE.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable", v.getContext().getPackageName()));

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

		// Calculate the screen diagonal in inches.
		DisplayMetrics dm = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels;
		int height = dm.heightPixels;
		int dens = dm.densityDpi;
		double wi = (double) width / (double) dens;
		double hi = (double) height / (double) dens;
		double x = Math.pow(wi, 2);
		double y = Math.pow(hi, 2);
		double screenInches = Math.sqrt(x + y);

		// Calculate how many pixels is 180 dp, which is the size of champion icon.
		dm = getResources().getDisplayMetrics();
		float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, dm);

		// Set the layout
		if (screenInches < 6)
		{
			icon.getLayoutParams().height = ((int) (1 * dpInPx)); // A phone is less than 6 inches.
		}
		else if (screenInches < 9)
		{
			icon.getLayoutParams().height = ((int) (1.8 * dpInPx)); // Small tablets are considered between 6 to 9
																	// inches.
		}
		else
		{
			icon.getLayoutParams().height = ((int) (2.2 * dpInPx)); // For big tablets (larger than 9 inches).
		}
	}

	public void leaguecounters(View view)
	{
		Intent intent = new Intent(this.getActivity(), Leaguecounters.class);
		intent.putExtra("champion", EXTRA_MESSAGE);
		startActivity(intent);
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
