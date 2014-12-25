package com.team4d.lolhelper;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;
import com.team4d.lolhelper.api.database.LOLSQLiteHelper;
import com.team4d.lolhelper.fragments.*;

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
	//Test ads:
	private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111";
	//Our ads:
//	private static final String AD_UNIT_ID = "ca-app-pub-9973141875464346/2397347111";

	// Jungle Timer things
	Button GR, GB, LR, LB, DR, BA;
	Timer[] timer = new Timer[6];
	boolean reset[] = { true, true, true, true, true, true };
	boolean running[] = { false, false, false, false, false, false };
	private final int[] TimeLeft = new int[6];

	Uri notification;
	Ringtone ringtone;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		new DatabaseAsyncTask(this, this).execute();

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

		/*
		 * if (savedInstanceState == null)
		 * {
		 * selectItem(0);
		 * }
		 */
		// Jungle Timer Drawer
		final SlidingUpPanelLayout mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
		mLayout.setPanelSlideListener(new PanelSlideListener()
		{
			@Override
			public void onPanelSlide(View panel, float slideOffset)
			{
				setActionBarTranslation(mLayout.getCurrentParalaxOffset());
			}

			@Override
			public void onPanelExpanded(View panel)
			{
				ImageView arrow = (ImageView) findViewById(R.id.arrowbararrow);
				arrow.setBackgroundResource(R.drawable.uparrow);
			}

			@Override
			public void onPanelCollapsed(View panel)
			{
				ImageView arrow = (ImageView) findViewById(R.id.arrowbararrow);
				arrow.setBackgroundResource(R.drawable.downarrow);
			}

			@Override
			public void onPanelAnchored(View panel)
			{
			}

			@Override
			public void onPanelHidden(View panel)
			{
			}
		});

		// Jungle Timers
		GB = (Button) findViewById(R.id.Button0);
		LB = (Button) findViewById(R.id.Button1);
		BA = (Button) findViewById(R.id.Button2);
		DR = (Button) findViewById(R.id.Button3);
		LR = (Button) findViewById(R.id.Button4);
		GR = (Button) findViewById(R.id.Button5);

		LinearLayout layout = (LinearLayout) findViewById(R.id.jungletimerbar);
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.setMargins(0, getActionBarHeight(), 0, 0);
		layout.setLayoutParams(params);

		notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
		
		// Create an ad.
		LinearLayout adlayout = (LinearLayout) findViewById(R.id.adcontainer);
		adView = new AdView(this);
		AdSize adSize = new AdSize(AdSize.FULL_WIDTH, AdSize.AUTO_HEIGHT);
		adView.setAdSize(adSize);
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

	private int getActionBarHeight()
	{
		int actionBarHeight = 0;
		TypedValue tv = new TypedValue();
		if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
		{
			actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
		}
		return actionBarHeight;
	}

	public void setActionBarTranslation(float y)
	{
		// Figure out the actionbar height
		int actionBarHeight = getActionBarHeight();
		// A hack to add the translation to the action bar
		ViewGroup content = ((ViewGroup) findViewById(android.R.id.content).getParent());
		int children = content.getChildCount();
		for (int i = 0; i < children; i++)
		{
			View child = content.getChildAt(i);
			if (child.getId() != android.R.id.content)
			{
				if (y <= -actionBarHeight)
				{
					child.setVisibility(View.GONE);
				} else
				{
					child.setVisibility(View.VISIBLE);
					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
					{
						child.setTranslationY(y);
					} else
					{
						AnimatorProxy.wrap(child).setTranslationY(y);
					}
				}
			}
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
		FragmentManager fragmentManager = getSupportFragmentManager();
		// Create appropriate fragment
		switch (position)
		{
		case 1:
			HomeFragment fragment0 = new HomeFragment();
			// Insert the fragment by replacing any existing fragment
			FragmentTransaction transaction0 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment0);
			transaction0.addToBackStack(null);
			transaction0.commit();
			break;
		case 2:
			TeamBuilderFragment fragment1 = new TeamBuilderFragment();
			FragmentTransaction transaction1 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment1);
			transaction1.addToBackStack(null);
			transaction1.commit();
			break;
		case 3:
			BuildRouletteFragment fragment2 = new BuildRouletteFragment();
			FragmentTransaction transaction2 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment2);
			transaction2.addToBackStack(null);
			transaction2.commit();
			break;
		case 4:
			SummonerStatsFragment fragment3 = new SummonerStatsFragment();
			FragmentTransaction transaction3 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment3);
			transaction3.addToBackStack(null);
			transaction3.commit();
			break;
//		case 5:
//			break;
		case 5:
			ChampionListFragment fragment4 = new ChampionListFragment();
			FragmentTransaction transaction4 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment4);
			transaction4.addToBackStack(null);
			transaction4.commit();
			break;
		case 6:
			ItemListFragment fragment5 = new ItemListFragment();
			FragmentTransaction transaction5 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment5);
			transaction5.addToBackStack(null);
			transaction5.commit();
			break;
		case 7:
			SummonerSpellListFragment fragment6 = new SummonerSpellListFragment();
			FragmentTransaction transaction6 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment6);
			transaction6.addToBackStack(null);
			transaction6.commit();
			break;
		case 8:
			AboutFragment fragment7 = new AboutFragment();
			FragmentTransaction transaction7 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment7);
			transaction7.addToBackStack(null);
			transaction7.commit();
			break;
		case 9:
			OptionsFragment fragment8 = new OptionsFragment();
			FragmentTransaction transaction8 = fragmentManager.beginTransaction().replace(R.id.content_frame, fragment8);
			transaction8.addToBackStack(null);
			transaction8.commit();
			break;
		default:
			Fragment fragment = new Fragment();
		}

		// Bundle args = new Bundle();
		// args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
		// fragment.setArguments(args);

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

	private class DatabaseAsyncTask extends AsyncTask<Void, String, Void>
	{
		private final Context mContext;
		private final Activity activity;
		private final PopupWindow popup;

		public DatabaseAsyncTask(Context c, Activity a)
		{
			mContext = c;
			activity = a;
			popup = new PopupWindow(activity);
		}

		@Override
		protected void onPreExecute()
		{
			LinearLayout view = (LinearLayout) activity.findViewById(R.id.loadingpopup);
			LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup_loading, view);


			PopupWindow popup = new PopupWindow(activity);
/*			popup.setContentView(layout);
			popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
			popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
			popup.setOutsideTouchable(true);
			popup.setFocusable(true);
			popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
			*/
		}

		@Override
		protected Void doInBackground(Void... params)
		{
			Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND + Process.THREAD_PRIORITY_MORE_FAVORABLE);
			APIData.getNumberChampions();
			//LOLSQLiteHelper.getInstance(mContext).getWritableDatabase();
			return null;
		}

		@Override
		protected void onProgressUpdate(String... status)
		{
		}

		@Override
		protected void onPostExecute(Void empty)
		{
			popup.dismiss();
			
			// Create a new fragment and specify the planet to show based on
			// position
			HomeFragment fragment = new HomeFragment();

			// Insert the fragment by replacing any existing fragment
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
		}
	}

	//
	// All the timer methods
	//
	/**
	 * The timer for Blue Golem.
	 * 
	 * @author Alexa
	 */
	private void TimerMethod0()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[0] <= 0)
				{
					ringtone.play();
					GB.setText("Alive");
					GB.setTextColor(Color.WHITE);
					running[0] = false;
					timer[0].cancel();
					timer[0].purge();
					GB.setBackgroundResource(R.drawable.timer0);
				} else if (TimeLeft[0] > 0)
				{
					if (TimeLeft[0] == 30000)
					{
						ringtone.play();
						GB.setTextColor(Color.YELLOW);
					} else if (TimeLeft[0] == 10000)
					{
						GB.setTextColor(Color.RED);
					}
					GB.setText("" + TimeLeft[0] / 60000 + ":" + String.format("%02d", (TimeLeft[0] / 1000) % 60));
					TimeLeft[0] -= 1000;
				}

			}
		});
	}

	/**
	 * The timer for Blue Lizard.
	 * 
	 * @author Alexa
	 */
	private void TimerMethod1()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[1] <= 0)
				{
					ringtone.play();
					LB.setText("Alive");
					LB.setTextColor(Color.WHITE);
					running[1] = false;
					timer[1].cancel();
					timer[1].purge();
					LB.setBackgroundResource(R.drawable.timer1);
				}
				else if (TimeLeft[1] > 0)
				{
					if (TimeLeft[1] == 30000)
					{
						ringtone.play();
						LB.setTextColor(Color.YELLOW);
					} else if (TimeLeft[1] == 10000)
					{
						LB.setTextColor(Color.RED);
					}
					LB.setText("" + TimeLeft[1] / 60000 + ":" + String.format("%02d", (TimeLeft[1] / 1000) % 60));
					TimeLeft[1] -= 1000;
				}

			}
		});
	}

	/**
	 * The timer for Baron.
	 * 
	 * @author Alexa
	 */
	private void TimerMethod2()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[2] <= 0)
				{
					ringtone.play();
					BA.setText("Alive");
					BA.setTextColor(Color.WHITE);
					running[2] = false;
					timer[2].cancel();
					timer[2].purge();
					BA.setBackgroundResource(R.drawable.timer2);
				}
				else if (TimeLeft[2] > 0)
				{
					if (TimeLeft[2] == 60000)
					{
						BA.setTextColor(Color.LTGRAY);
					} else if (TimeLeft[2] == 30000)
					{
						ringtone.play();
						BA.setTextColor(Color.YELLOW);
					} else if (TimeLeft[2] == 10000)
					{
						BA.setTextColor(Color.RED);
					}
					BA.setText("" + TimeLeft[2] / 60000 + ":" + String.format("%02d", (TimeLeft[2] / 1000) % 60));
					TimeLeft[2] -= 1000;
				}

			}
		});
	}

	/**
	 * The timer for Dragon.
	 * 
	 * @author Alexa
	 */
	private void TimerMethod3()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[3] <= 0)
				{
					ringtone.play();
					DR.setText("Alive");
					DR.setTextColor(Color.WHITE);
					running[3] = false;
					timer[3].cancel();
					timer[3].purge();
					DR.setBackgroundResource(R.drawable.timer3);
				}
				else if (TimeLeft[3] > 0)
				{
					if (TimeLeft[3] == 30000)
					{
						ringtone.play();
						DR.setTextColor(Color.YELLOW);
					} else if (TimeLeft[3] == 10000)
					{
						DR.setTextColor(Color.RED);
					}
					DR.setText("" + TimeLeft[3] / 60000 + ":" + String.format("%02d", (TimeLeft[3] / 1000) % 60));
					TimeLeft[3] -= 1000;
				}

			}
		});
	}

	/**
	 * The timer for Red Lizard.
	 * 
	 * @author Alexa
	 */
	private void TimerMethod4()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[4] <= 0)
				{
					ringtone.play();
					LR.setText("Alive");
					LR.setTextColor(Color.WHITE);
					running[4] = false;
					timer[4].cancel();
					timer[4].purge();
					LR.setBackgroundResource(R.drawable.timer4);
				}
				else if (TimeLeft[4] > 0)
				{
					if (TimeLeft[4] == 30000)
					{
						ringtone.play();
						LR.setTextColor(Color.YELLOW);
					} else if (TimeLeft[4] == 10000)
					{
						LR.setTextColor(Color.RED);
					}
					LR.setText("" + TimeLeft[4] / 60000 + ":" + String.format("%02d", (TimeLeft[4] / 1000) % 60));
					TimeLeft[4] -= 1000;
				}

			}
		});
	}

	/**
	 * The timer for Red Golem.
	 * 
	 * @author Alexa
	 */
	private void TimerMethod5()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[5] <= 0)
				{
					ringtone.play();
					GR.setText("Alive");
					GR.setTextColor(Color.WHITE);
					running[5] = false;
					timer[5].cancel();
					timer[5].purge();
					GR.setBackgroundResource(R.drawable.timer5);
				}
				else if (TimeLeft[5] > 0)
				{
					if (TimeLeft[5] == 30000)
					{
						ringtone.play();
						GR.setTextColor(Color.YELLOW);
					} else if (TimeLeft[5] == 10000)
					{
						GR.setTextColor(Color.RED);
					}
					GR.setText("" + TimeLeft[5] / 60000 + ":" + String.format("%02d", (TimeLeft[5] / 1000) % 60));
					TimeLeft[5] -= 1000;
				}

			}
		});
	}

	//
	// Called when each of these buttons is clicked
	//
	/**
	 * The OnClickListener for Blue Golem.
	 * Starts or cancels the timer accordingly.
	 * 
	 * @author Alexa
	 * @param view
	 */
	public void BlueGolem(View view)
	{
		TimeLeft[0] = 300000;
		if (!running[0]) // start it
		{
			GB.setBackgroundResource(R.drawable.timer0blank);
			running[0] = true;
			timer[0] = new Timer();
			timer[0].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod0();
				}
			}, 0, 1000);
		} else
		// cancel it
		{
			GB.setBackgroundResource(R.drawable.timer0);
			timer[0].cancel();
			timer[0].purge();
			GB.setText("--");
			running[0] = false;
		}
	}

	/**
	 * The OnClickListener for Blue Lizard.
	 * Starts or cancels the timer accordingly.
	 * 
	 * @author Alexa
	 * @param view
	 */
	public void BlueLizard(View view)
	{
		TimeLeft[1] = 300000;
		if (!running[1])
		{
			LB.setBackgroundResource(R.drawable.timer1blank);
			running[1] = true;
			timer[1] = new Timer();
			timer[1].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod1();
				}
			}, 0, 1000);
		} else
		{
			timer[1].cancel();
			timer[1].purge();
			LB.setBackgroundResource(R.drawable.timer1);
			LB.setText("--");
			running[1] = false;
		}
	}

	/**
	 * The OnClickListener for Baron.
	 * Starts or cancels the timer accordingly.
	 * 
	 * @author Alexa
	 * @param view
	 */
	public void Baron(View view)
	{
		TimeLeft[2] = 420000;
		if (!running[2])
		{
			BA.setBackgroundResource(R.drawable.timer2blank);
			running[2] = true;
			timer[2] = new Timer();
			timer[2].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod2();
				}
			}, 0, 1000);
		} else
		{
			timer[2].cancel();
			timer[2].purge();
			BA.setBackgroundResource(R.drawable.timer2);
			BA.setText("--");
			running[2] = false;
		}
	}

	/**
	 * The OnClickListener for Dragon.
	 * Starts or cancels the timer accordingly.
	 * 
	 * @author Alexa
	 * @param view
	 */
	public void Dragon(View view)
	{
		TimeLeft[3] = 360000;
		if (!running[3])
		{
			DR.setBackgroundResource(R.drawable.timer3blank);
			running[3] = true;
			timer[3] = new Timer();
			timer[3].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod3();
				}
			}, 0, 1000);
		} else
		{
			timer[3].cancel();
			timer[3].purge();
			DR.setBackgroundResource(R.drawable.timer3);
			DR.setText("--");
			running[3] = false;
		}

	}

	/**
	 * The OnClickListener for Red Lizard.
	 * Starts or cancels the timer accordingly.
	 * 
	 * @author Alexa
	 * @param view
	 */
	public void RedLizard(View view)
	{
		TimeLeft[4] = 300000;
		if (!running[4])
		{
			LR.setBackgroundResource(R.drawable.timer4blank);
			running[4] = true;
			timer[4] = new Timer();
			timer[4].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod4();
				}
			}, 0, 1000);
		} else
		{
			timer[4].cancel();
			timer[4].purge();
			LR.setBackgroundResource(R.drawable.timer4);
			LR.setText("--");
			running[4] = false;
		}

	}

	/**
	 * The OnClickListener for Red Golem.
	 * Starts or cancels the timer accordingly.
	 * 
	 * @author Alexa
	 * @param view
	 */
	public void RedGolem(View view)
	{
		TimeLeft[5] = 300000;
		if (!running[5])
		{
			GR.setBackgroundResource(R.drawable.timer5blank);
			running[5] = true;
			timer[5] = new Timer();
			timer[5].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod5();
				}
			}, 0, 1000);
		} else
		{
			timer[5].cancel();
			timer[5].purge();
			GR.setBackgroundResource(R.drawable.timer5);
			GR.setText("--");
			running[5] = false;
		}
	}
}
