package com.team4d.lolhelper.fragments;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.team4d.lolhelper.DBcounters;
import com.team4d.lolhelper.Popup;
import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.staticdata.champion.Champion;
import com.team4d.lolhelper.api.dto.staticdata.champion.ChampionSpell;
import com.team4d.lolhelper.api.dto.staticdata.champion.Stats;

public class ChampionViewFragment extends Fragment
{
	View mLayout; // used for popup
	static String name;
	static final int NUM_ITEMS = 4;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		name = getArguments().getString("name");
	}

	@Override
	public void onDetach()
	{
		System.out.println("Detached");
		mPager.setAdapter(null);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_champion_view, container, false);
	}

	@Override
	public void onStart()
	{
		super.onStart();
		// ViewPager
		mPager = (ViewPager) getActivity().findViewById(R.id.pager);
		mPagerAdapter = new MyAdapter(name, getActivity().getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);

		ImageView icon = (ImageView) getView().findViewById(R.id.icon);
		int resID = getResources().getIdentifier(name.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
				"drawable", getActivity().getPackageName());
		icon.setImageResource(resID);
		new grabChampion(name).execute();

	}

	public class MyAdapter extends FragmentStatePagerAdapter
	{
		String name;
		String[] title = {
				"Overview",
				"Stats",
				"Lore",
				"Counters"
		};

		public MyAdapter(String name, FragmentManager fm)
		{
			super(fm);
			this.name = name;
		}

		@Override
		public int getCount()
		{
			return NUM_ITEMS;
		}

		@Override
		public Fragment getItem(int position)
		{
			return SlideScreenFragment.newInstance(name, position);
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			return title[position];
		}

		@Override
		public int getItemPosition(Object object)
		{
			return POSITION_NONE;
		}
	}

	public static class SlideScreenFragment extends Fragment
	{
		int mNum;
		String name;

		/**
		 * Create a new instance, providing "num"
		 * as an argument.
		 */
		static SlideScreenFragment newInstance(String name, int num)
		{
			SlideScreenFragment f = new SlideScreenFragment();

			// Supply num input as an argument.
			Bundle args = new Bundle();
			args.putInt("num", num);
			args.putString("name", name);
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
			name = getArguments().getString("name");
		}

		/**
		 * The Fragment's UI
		 */
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_pager_list, container, false);

			LinearLayout layout = (LinearLayout) v.findViewById(R.id.container);
			switch (mNum)
			{
			case 0: // Overview
				View view0 = inflater.inflate(R.layout.fragment_champion_overview, null);
				layout.addView(view0);
				new makeView(name, this.getActivity(), view0, mNum).execute();
				break;
			case 1: // Stats
				View view1 = inflater.inflate(R.layout.fragment_champion_stats, null);
				layout.addView(view1);
				new makeView(name, this.getActivity(), view1, mNum).execute();
				break;
			case 2: // Lore
				View view2 = inflater.inflate(R.layout.fragment_champion_lore, null);
				layout.addView(view2);
				new makeView(name, this.getActivity(), view2, mNum).execute();
				break;
			case 3: // Counters
				View view4 = inflater.inflate(R.layout.fragment_champion_counters, null);
				layout.addView(view4);
				new makeView(name, this.getActivity(), view4, mNum).execute();
				break;
			default:
				break;
			}
			return v;
		}

	}

	private static class makeView extends AsyncTask<String, Void, Champion>
	{
		private final String name;
		private final Context context;
		private final View view;
		private final int n;

		public makeView(String name, Context context, View view, int mNum)
		{
			this.name = name;
			this.context = context;
			this.view = view;
			n = mNum;
		}

		@Override
		protected Champion doInBackground(String... args)
		{
			Champion c = APIData.getChampionByName(name);
			// Note: This return value is passed as a parameter to onPostExecute
			return c;
		}

		@Override
		protected void onPostExecute(Champion champ)
		{
			switch (n)
			{
			case 0: // Overview
				TextView info = (TextView) view.findViewById(R.id.info);
				info.setText("Difficulty: " + champ.getInfo().getDifficulty() + "/10\n"
						+ "Attack: " + champ.getInfo().getAttack() + "/10\n"
						+ "Magic: " + champ.getInfo().getMagic() + "/10\n"
						+ "Defense: " + champ.getInfo().getDefense() + "/10");
				TextView resource = (TextView) view.findViewById(R.id.resource);
				resource.setText(champ.getPartype());

				// Champion abilities
				LinearLayout abilities = (LinearLayout) view.findViewById(R.id.abilities);

				for (int i = 0; i < 5; i++)
				{
					LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(
							Context.LAYOUT_INFLATER_SERVICE);
					ImageButton button = (ImageButton) inflater.inflate(R.layout.free_champion_image_button, null);
					String n = champ.getName().replaceAll("[^a-zA-Z0-9]+", "").toLowerCase() + i;
					Drawable btnImg = view.getResources().getDrawable(view.getResources().getIdentifier(
							n, "drawable", view.getContext().getPackageName()));
					button.setImageDrawable(btnImg);
					LayoutParams params = new LayoutParams((int) (btnImg.getIntrinsicWidth() * 1.2),
							(int) (btnImg.getIntrinsicHeight() * 1.2));
					button.setLayoutParams(params);
					if (i == 0)
					{
						// button.setOnClickListener(new ChampionSpellOnClickListener(champ.getSpells().get(i)));
					}
					else
					{
						button.setOnClickListener(new ChampionSpellOnClickListener(champ.getSpells().get(i - 1), champ.getName(), i));
					}
					abilities.addView(button);
				}
				break;
			case 1: // Stats
				TextView health = (TextView) view.findViewById(R.id.health);
				TextView resourcetype = (TextView) view.findViewById(R.id.resourcetype);
				TextView resource1 = (TextView) view.findViewById(R.id.resource);
				TextView attackdamage = (TextView) view.findViewById(R.id.attackdamage);
				TextView attackspeed = (TextView) view.findViewById(R.id.attackspeed);
				TextView attackrange = (TextView) view.findViewById(R.id.attackrange);

				TextView healthregen = (TextView) view.findViewById(R.id.healthregen);
				TextView resourcetyperegen = (TextView) view.findViewById(R.id.resourcetyperegen);
				TextView resourceregen = (TextView) view.findViewById(R.id.resourceregen);
				TextView armor = (TextView) view.findViewById(R.id.armor);
				TextView magicresist = (TextView) view.findViewById(R.id.magicresist);
				TextView movementspeed = (TextView) view.findViewById(R.id.movementspeed);

				Stats stats = champ.getStats();

				health.setText((int) stats.getHp() + " (+" + (int) stats.getHpperlevel() + " per level)");
				resourcetype.setText(champ.getPartype() + ":");
				resource1.setText((int) stats.getMp() + " (+" + stats.getMpperlevel() + " per level)");
				attackdamage.setText((int) stats.getAttackdamage() + " (+" + stats.getAttackdamageperlevel()
						+ " per level)");
				attackspeed.setText(Math.round(625 / (1 + stats.getAttackspeedoffset())) / 1000.0 + " (+"
						+ stats.getAttackspeedperlevel() + "% per level)");
				attackrange.setText("" + (int) stats.getAttackrange());

				healthregen.setText(stats.getHpregen() + " (+" + stats.getHpregenperlevel() + " per level)");
				resourcetyperegen.setText(champ.getPartype() + " Regen:");
				resourceregen.setText((int) stats.getMpregen() + " (+" + stats.getMpregenperlevel() + " per level)");
				armor.setText((int) stats.getArmor() + " (+" + stats.getArmorperlevel() + " per level)");
				magicresist
						.setText((int) stats.getSpellblock() + " (+" + stats.getSpellblockperlevel() + " per level)");
				movementspeed.setText("" + (int) stats.getMovespeed());

				break;
			case 2: // Lore
				TextView lore = (TextView) view.findViewById(R.id.lore);
				lore.setText(APIData.parseOutHtml(champ.getLore()));
				break;
			case 3: // Counters
				// Database
				DBcounters myDbHelper = new DBcounters(view.getContext());
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
				SQLiteDatabase counters = myDbHelper.getReadableDatabase();
				Cursor result = counters.query("counters", foo, "Name=\"" + champ.getName() + "\"",
						null, null, null, null);
				result.moveToFirst();
				// Info
				ImageView iv0 = (ImageView) view.findViewById(R.id.imageba1);
				iv0.setImageDrawable(view.getResources().getDrawable(
						view.getResources().getIdentifier(
								result.getString(result.getColumnIndex("Counter1"))
										.toLowerCase().replaceAll("\\s", "")
										.replaceAll("'", "").replaceAll("\\.", ""),
								"drawable", view.getContext().getPackageName())));

				ImageView iv1 = (ImageView) view.findViewById(R.id.imageba2);
				iv1.setImageDrawable(view.getResources().getDrawable(
						view.getResources().getIdentifier(
								result.getString(result.getColumnIndex("Counter2"))
										.toLowerCase().replaceAll("\\s", "")
										.replaceAll("'", "").replaceAll("\\.", ""),
								"drawable", view.getContext().getPackageName())));

				ImageView iv2 = (ImageView) view.findViewById(R.id.imageba3);
				iv2.setImageDrawable(view.getResources().getDrawable(
						view.getResources().getIdentifier(
								result.getString(result.getColumnIndex("Counter3"))
										.toLowerCase().replaceAll("\\s", "")
										.replaceAll("'", "").replaceAll("\\.", ""),
								"drawable", view.getContext().getPackageName())));

				ImageView iv3 = (ImageView) view.findViewById(R.id.imagega1);
				iv3.setImageDrawable(view.getResources().getDrawable(
						view.getResources().getIdentifier(
								result.getString(result.getColumnIndex("GA1"))
										.toLowerCase().replaceAll("\\s", "")
										.replaceAll("'", "").replaceAll("\\.", ""),
								"drawable", view.getContext().getPackageName())));

				ImageView iv4 = (ImageView) view.findViewById(R.id.imagega2);
				iv4.setImageDrawable(view.getResources().getDrawable(
						view.getResources().getIdentifier(
								result.getString(result.getColumnIndex("GA2"))
										.toLowerCase().replaceAll("\\s", "")
										.replaceAll("'", "").replaceAll("\\.", ""),
								"drawable", view.getContext().getPackageName())));

				ImageView iv5 = (ImageView) view.findViewById(R.id.imagega3);
				iv5.setImageDrawable(view.getResources().getDrawable(
						view.getResources().getIdentifier(
								result.getString(result.getColumnIndex("GA3"))
										.toLowerCase().replaceAll("\\s", "")
										.replaceAll("'", "").replaceAll("\\.", ""),
								"drawable", view.getContext().getPackageName())));

				// Set text for champion 3 countered by and 3 counters
				TextView tv0 = (TextView) view.findViewById(R.id.textba1);
				tv0.setText(result.getString(result.getColumnIndex("Counter1")));

				TextView tv1 = (TextView) view.findViewById(R.id.textba2);
				tv1.setText(result.getString(result.getColumnIndex("Counter2")));

				TextView tv2 = (TextView) view.findViewById(R.id.textba3);
				tv2.setText(result.getString(result.getColumnIndex("Counter3")));

				TextView tv3 = (TextView) view.findViewById(R.id.textga1);
				tv3.setText(result.getString(result.getColumnIndex("GA1")));

				TextView tv4 = (TextView) view.findViewById(R.id.textga2);
				tv4.setText(result.getString(result.getColumnIndex("GA2")));

				TextView tv5 = (TextView) view.findViewById(R.id.textga3);
				tv5.setText(result.getString(result.getColumnIndex("GA3")));

				result.close();

				break;
			default:
				break;
			}
		}

		public class ChampionSpellOnClickListener implements OnClickListener
		{
			ChampionSpell spell;
			String champ;
			int i;

			public ChampionSpellOnClickListener(ChampionSpell spell, String champ, int i)
			{
				this.spell = spell;
				this.champ = champ;
				this.i = i;
			}

			@Override
			public void onClick(View v)
			{
				Activity activity = (Activity) context;
				View layout = Popup.popupChampionSpell(activity, spell, champ, i);

				PopupWindow popup = new PopupWindow(activity);
				popup.setContentView(layout);
				popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
				popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
				popup.setOutsideTouchable(true);
				popup.setFocusable(true);
				popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
			}
		}
	}

	private class grabChampion extends AsyncTask<String, Void, Champion>
	{
		private final String name;

		public grabChampion(String name)
		{
			this.name = name;
		}

		@Override
		protected Champion doInBackground(String... args)
		{
			Champion c = APIData.getChampionByName(name);
			// Note: This return value is passed as a parameter to onPostExecute
			return c;
		}

		@Override
		protected void onPostExecute(Champion champ)
		{
			TextView nameText = (TextView) getView().findViewById(R.id.name);
			nameText.setText(name + "\n" + champ.getTitle());
		}

	}
}
