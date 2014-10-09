package com.team4d.lolhelper;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdView;
import com.team4d.lolhelper.fragments.HomeFragment;

public class BaseActivity extends FragmentActivity
{
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mPageTitles;

	/** The view to show the ad. */
	private AdView adView;
	/* Your ad unit id. Replace with your actual ad unit id. */
	private static final String AD_UNIT_ID = "ca-app-pub-9973141875464346/2397347111";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		mTitle = mDrawerTitle = getTitle();
		mPageTitles = getResources().getStringArray(R.array.page_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		// set up the drawer's list view with items and click listener
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mPageTitles));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description for accessibility */
		R.string.drawer_close /* "close drawer" description for accessibility */
				)
				{
					@Override
					public void onDrawerClosed(View view)
					{
						getActionBar().setTitle(mTitle);
						invalidateOptionsMenu();
						// creates call to onPrepareOptionsMenu()
					}

					@Override
					public void onDrawerOpened(View drawerView)
					{
						getActionBar().setTitle(mDrawerTitle);
						invalidateOptionsMenu();
						// creates call to onPrepareOptionsMenu()
					}
				};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null)
		{
			selectItem(0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		// If the nav drawer is open, hide action items related to the content
		// view
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item))
		{
			return true;
		}
		switch (item.getItemId())
		{
		case R.id.action_settings:
			int i = 1;
			i = i + 2;
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
	}

	@Override
	public void onResume()
	{
		super.onResume();
	}

	@Override
	public void onPause()
	{
		super.onPause();
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id)
		{
			selectItem(position);
		}
	}

	/** Swaps fragments in the main content view */
	private void selectItem(int position)
	{
		// Create appropriate fragment
		switch(position){
			case 0:
				HomeFragment fragment0 = new HomeFragment();
				// Insert the fragment by replacing any existing fragment
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager.beginTransaction()
						.add(R.id.content_frame, fragment0).commit();
				break;
			case 1:
//				fragment = new TeamBuilderFragment();
				break;
			case 2:
//				fragment = new UltimateBraveryFragment();
				break;
			case 3:
//				fragment = new PlayerStatsFragment();
				break;
			case 4:
//				fragment = new ChampionInfoFragment();
				break;
			case 5:
//				fragment = new ItemInfoFragment();
				break;
			case 6:
//				fragment = new SummonerSpellInfoFragment();
				break;
			case 7:
//				fragment = new AboutFragment();
				break;
			default:
				Fragment fragment = new Fragment();	
		}
		
//		Bundle args = new Bundle();
//		args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
//		fragment.setArguments(args);


		// Highlight the selected item, update the title, and close the drawer
		mDrawerList.setItemChecked(position, true);
		setTitle(mPageTitles[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title)
	{
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	private class BaseAsyncTask extends AsyncTask<Void, Void, Void>
	{
		@Override
		protected void onPreExecute()
		{

		}

		@Override
		protected Void doInBackground(Void... empty)
		{
			return null;
		}

		@Override
		protected void onPostExecute(Void empty)
		{
		}
	}
}
