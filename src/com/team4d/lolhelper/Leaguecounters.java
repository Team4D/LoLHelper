package com.team4d.lolhelper;

import java.io.IOException;

import com.team4d.lolhelper.R;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Leaguecounters extends Fragment
{
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leaguecounters, container, false);
    }
	
	@Override
	public void onStart()
	{

		RelativeLayout layout = (RelativeLayout) this.getView().findViewById(R.id.container);
		layout.setBackgroundResource(R.drawable.bg);

		DBcounters myDbHelper = new DBcounters(this.getView().getContext());

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
		Intent intent = this.getActivity().getIntent();
		String champ = intent.getStringExtra("champion");
		SQLiteDatabase counters = myDbHelper.getReadableDatabase();
		Cursor result = counters.query("counters", foo, "Name=\"" + champ + "\"",
				null, null, null, null);
		result.moveToFirst();

		// Set images for champion
		ImageView iv = (ImageView) this.getView().findViewById(R.id.imageView1);
		iv.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						champ.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", this.getActivity().getPackageName())));

		ImageView iv0 = (ImageView) this.getView().findViewById(R.id.imageView2);
		iv0.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("Counter1"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", this.getActivity().getPackageName())));

		ImageView iv1 = (ImageView) this.getView().findViewById(R.id.imageView3);
		iv1.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("Counter2"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", this.getActivity().getPackageName())));

		ImageView iv2 = (ImageView) this.getView().findViewById(R.id.imageView4);
		iv2.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("Counter3"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", this.getActivity().getPackageName())));

		ImageView iv3 = (ImageView) this.getView().findViewById(R.id.imageView5);
		iv3.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("GA1"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", this.getActivity().getPackageName())));

		ImageView iv4 = (ImageView) this.getView().findViewById(R.id.imageView6);
		iv4.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("GA2"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", this.getActivity().getPackageName())));

		ImageView iv5 = (ImageView) this.getView().findViewById(R.id.imageView7);
		iv5.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(
						result.getString(result.getColumnIndex("GA3"))
								.toLowerCase().replaceAll("\\s", "")
								.replaceAll("'", "").replaceAll("\\.", ""),
						"drawable", this.getActivity().getPackageName())));

		// Set text for champion 3 countered by and 3 counters
		TextView tv = (TextView) this.getView().findViewById(R.id.textView1);
		tv.setText(champ);

		TextView tv0 = (TextView) this.getView().findViewById(R.id.TextView02);
		tv0.setText(result.getString(result.getColumnIndex("Counter1")));

		TextView tv1 = (TextView) this.getView().findViewById(R.id.textView2);
		tv1.setText(result.getString(result.getColumnIndex("Counter2")));

		TextView tv2 = (TextView) this.getView().findViewById(R.id.TextView04);
		tv2.setText(result.getString(result.getColumnIndex("Counter3")));

		TextView tv3 = (TextView) this.getView().findViewById(R.id.TextView01);
		tv3.setText(result.getString(result.getColumnIndex("GA1")));

		TextView tv4 = (TextView) this.getView().findViewById(R.id.TextView05);
		tv4.setText(result.getString(result.getColumnIndex("GA2")));

		TextView tv5 = (TextView) this.getView().findViewById(R.id.TextView03);
		tv5.setText(result.getString(result.getColumnIndex("GA3")));

		result.close();
		
		// Calculate the screen diagonal in inches.
		DisplayMetrics dm = new DisplayMetrics();
		this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width=dm.widthPixels;
		int height=dm.heightPixels;
		int dens=dm.densityDpi;
		double wi=(double)width/(double)dens;
		double hi=(double)height/(double)dens;
		double x = Math.pow(wi,2);
		double y = Math.pow(hi,2);
		double screenInches = Math.sqrt(x+y);
		
    	// Calculate how many pixels is 20 sp, which is the screen margin.
        dm = getResources().getDisplayMetrics();
        float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, dm);

		// Set the layout
		if (screenInches < 6){
			MarginLayoutParams marginParams = new MarginLayoutParams(iv.getLayoutParams());
		    marginParams.setMargins((int)((width - 4 * dpInPx - 120) / 2), 20, 0, 0);
		    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
		    iv.setLayoutParams(layoutParams);		// A phone is less than 6 inches.
		    
		}
		else if (screenInches < 9){
			MarginLayoutParams marginParams = new MarginLayoutParams(iv.getLayoutParams());
		    marginParams.setMargins((int)((width - 3 * dpInPx - 120) / 2), 300, 0, 0);
		    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
		    iv.setLayoutParams(layoutParams);		// Small tablets are considered between 6 to 9 inches.
		}
		else{
			MarginLayoutParams marginParams = new MarginLayoutParams(iv.getLayoutParams());
		    marginParams.setMargins((int)((width - 4 * dpInPx - 120) / 2), 500, 0, 0);
		    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
		    iv.setLayoutParams(layoutParams);		// For big tablets (larger than 9 inches).
		}
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
