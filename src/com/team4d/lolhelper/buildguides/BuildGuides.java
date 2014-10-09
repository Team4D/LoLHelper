package com.team4d.lolhelper.buildguides;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

import com.team4d.lolhelper.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.team4d.lolhelper.GlobalVariables;
import com.team4d.lolhelper.ItemInfo;

public class BuildGuides extends ActionBarActivity
{
	// ViewPager stuff
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;

	static int i;
	static BuildDatabase database;
	static String packageName;
	static String champ;
	static String type;
	
	// Screen Size
	public static double screenInches;

	/** The view to show the ad. */
	private AdView adView;

	/* Your ad unit id. Replace with your actual ad unit id. */
	private static final String AD_UNIT_ID = "ca-app-pub-9973141875464346/2397347111";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_build);

		RelativeLayout layout = (RelativeLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		// Find views
		ImageView pic = (ImageView) findViewById(R.id.championpic);
		TextView role = (TextView) findViewById(R.id.championrole);

		// Get passed information
		Intent intent = getIntent();
		champ = intent.getStringExtra(BuildScreen.EXTRA_MESSAGE);
		type = intent.getStringExtra(BuildScreen.TYPE);
		
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
		
    	// Calculate how many pixels is 120 dp, which is the size of championpic.
        dm = getResources().getDisplayMetrics();
        float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, dm);

		// Set picture and text displayed
		role.setText(champ + " " + type + " Guide:");
		int champID = getResources().getIdentifier(champ.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
				getPackageName());
		pic.setImageResource(champID);
		
		// Set the layout depends on the screen
		if (screenInches < 6)
			pic.getLayoutParams().height = ((int) (1 * dpInPx));		// A phone is less than 6 inches.
		else if (screenInches < 9)
			pic.getLayoutParams().height = ((int) (1.6 * dpInPx));		// Small tablets are considered between 6 to 9 inches.
		else
			pic.getLayoutParams().height = ((int) (1.9 * dpInPx));		// For big tablets (larger than 9 inches).
		
		// Build proper database
		database = new BuildDatabase(type);

		// Set build guide photos
		i = ((GlobalVariables) this.getApplication()).getChampionInt(champ.replaceAll("[^a-zA-Z]+", "").toLowerCase());
		packageName = getPackageName();

		// ViewPager
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);

		LinearLayout adlayout = (LinearLayout) findViewById(R.id.container2);

		// Create an ad.
		adView = new AdView(this);
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(AD_UNIT_ID);

		// Add the AdView to the view hierarchy. The view will have no size
		// until the ad is loaded.
		adlayout.addView(adView);

		// Create an ad request. Check logcat output for the hashed device ID to
		// get test ads on a physical device.
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				// .addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE")
				.build();

		// Start loading the ad in the background.
		adView.loadAd(adRequest);
	}

	@Override
	public void onBackPressed()
	{
		mPager.setAdapter(null);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.build_guides, menu);
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

	/**
	 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
	 * sequence.
	 */
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter
	{
		public ScreenSlidePagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int position)
		{
			return ScreenSlidePageFragment.newInstance(position);
		}

		@Override
		public int getCount()
		{
			return database.getNumBuilds(i);
		}
	}

	public static class ScreenSlidePageFragment extends Fragment
	{
		int mNum;

		static ScreenSlidePageFragment newInstance(int num)
		{
			ScreenSlidePageFragment f = new ScreenSlidePageFragment();
			Bundle args = new Bundle();
			args.putInt("num", num);
			f.setArguments(args);
			return f;
		}

		/**
		 * When creating, retrieve this instance's number from its arguments.
		 */
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			mNum = getArguments() != null ? getArguments().getInt("num") : 1;
		}

		/**
		 * Fragment UI
		 */
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

			// Set titles
			TextView title = (TextView) v.findViewById(R.id.BuildHead);
			title.setText(database.getDatabase()[i][mNum].getName());

			// Set pictures
			ImageView[] views = {
					(ImageView) v.findViewById(R.id.imageViewStart1),
					(ImageView) v.findViewById(R.id.imageViewStart2),
					(ImageView) v.findViewById(R.id.imageViewStart3),
					(ImageView) v.findViewById(R.id.imageViewStart4),
					(ImageView) v.findViewById(R.id.imageViewRush1),
					(ImageView) v.findViewById(R.id.imageViewRush2),
					(ImageView) v.findViewById(R.id.imageViewRush3),
					(ImageView) v.findViewById(R.id.imageViewRush4),
					(ImageView) v.findViewById(R.id.imageViewAsNeeded1),
					(ImageView) v.findViewById(R.id.imageViewAsNeeded2),
					(ImageView) v.findViewById(R.id.imageViewAsNeeded3),
					(ImageView) v.findViewById(R.id.imageViewAsNeeded4),
					(ImageView) v.findViewById(R.id.imageViewAsNeeded5) };
			
			// Set the separation between three rows of items.
	        DisplayMetrics dm = getResources().getDisplayMetrics();
	        float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, dm);
    		int size;
			if (screenInches < 6){
				size = (int)dpInPx;
			}
			else if (screenInches < 9){
				size = (int)(3 * dpInPx);
			}
			else{
				size = (int)(4 * dpInPx);
			}
	        
			int resID;
			// Necessary because OnClickListener is weird about the
			// information it can see / use
			class Info
			{
				String message;

				String getMessage()
				{
					return message;
				}

				void setMessage(String string)
				{
					message = string;
				}
			}
			// Starting Items
			for (int j = 0; j < 4; j++)
			{
				// Sets image
				resID = getResources().getIdentifier(database.getDatabase()[i][mNum].getStart()[j], "drawable",
						packageName);
				views[j].setImageResource(resID);
				views[j].getLayoutParams().height = size;
								
				// Sets to open item info page
				final Info info = new Info();
				info.setMessage(database.getDatabase()[i][mNum].getStart()[j]);
				views[j].setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						Intent intent = new Intent(v.getContext(), ItemInfo.class);
						String EXTRA_MESSAGE = info.getMessage();
						intent.putExtra("EXTRA_MESSAGE", EXTRA_MESSAGE);
						v.getContext().startActivity(intent);
					}
				});
			}
			// Rush Items
			for (int j = 0; j < 4; j++)
			{
				// Sets image
				resID = getResources().getIdentifier(database.getDatabase()[i][mNum].getRush()[j], "drawable",
						packageName);
				views[j + 4].setImageResource(resID);
				views[j + 4].getLayoutParams().height = size;
	    		
				// Sets to open item info page
				final Info info = new Info();
				info.setMessage(database.getDatabase()[i][mNum].getRush()[j]);
				views[j + 4].setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						Intent intent = new Intent(v.getContext(), ItemInfo.class);
						String EXTRA_MESSAGE = info.getMessage();
						intent.putExtra("EXTRA_MESSAGE", EXTRA_MESSAGE);
						v.getContext().startActivity(intent);
					}
				});
			}
			// As Needed Items
			for (int j = 0; j < 5; j++)
			{
				// Sets image
				resID = getResources().getIdentifier(database.getDatabase()[i][mNum].getAsNeeded()[j], "drawable",
						packageName);
				views[j + 8].setImageResource(resID);
				views[j + 8].getLayoutParams().height = size;
	    						
				// Sets to open item info page
				final Info info = new Info();
				info.setMessage(database.getDatabase()[i][mNum].getAsNeeded()[j]);
				views[j + 8].setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						Intent intent = new Intent(v.getContext(), ItemInfo.class);
						String EXTRA_MESSAGE = info.getMessage();
						intent.putExtra("EXTRA_MESSAGE", EXTRA_MESSAGE);
						v.getContext().startActivity(intent);
					}
				});
			}
	/*		// Runes Button
			Button button = (Button) v.findViewById(R.id.additionalInfo);

			button.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Intent intent = new Intent(v.getContext(), BuildAdditional.class);
					intent.putExtra("CHAMP", champ);
					intent.putExtra("TYPE", type);
					intent.putExtra("MNUM", mNum);
					v.getContext().startActivity(intent);
				}

			});*/

			return v;
		}

	}

	@Override
	public void onResume()
	{
		super.onResume();
		if (adView != null)
		{
			adView.resume();
		}
	}

	@Override
	public void onPause()
	{
		if (adView != null)
		{
			adView.pause();
		}
		super.onPause();
	}

	/** Called before the activity is destroyed. */
	@Override
	public void onDestroy()
	{
		// Destroy the AdView.
		if (adView != null)
		{
			adView.destroy();
		}
		super.onDestroy();
	}
}