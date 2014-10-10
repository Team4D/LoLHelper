package com.team4d.lolhelper.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.staticdata.summonerspell.SummonerSpell;

public class SummonerSpellListFragment extends Fragment
{
	View layout;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_summonerspelllist, container, false);
	}

	@Override
	public void onStart()
	{
		super.onStart();
		new SummonerSpellListAsyncTask(this.getActivity(), this.getView()).execute();
	}

	private class SummonerSpellListAsyncTask extends AsyncTask<Void, String, String[]>
	{

		private final Context mContext;
		private final View mView;

		public SummonerSpellListAsyncTask(Context c, View v)
		{
			mContext = c;
			mView = v;
		}

		@Override
		protected void onPreExecute()
		{
			// Display loading indicator?
		}

		@Override
		protected String[] doInBackground(Void... params)
		{
			String[] sspells = APIData.getSummonerSpellList();
			return sspells;
		}

		@Override
		protected void onProgressUpdate(String... status)
		{
			// Probably not relevant for this, DB query should be quick
		}

		@Override
		protected void onPostExecute(String[] result)
		{
			GridLayout mGridView = (GridLayout) mView.findViewById(R.id.SummonerSpellListGrid);

			DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
			float dpWidth = dm.widthPixels / dm.density;

			Drawable imgsize = getResources().getDrawable(R.drawable.defaultchampsize);
			float dpImgWidth = imgsize.getIntrinsicWidth() / dm.density;

			int columns = (int) (dpWidth / (dpImgWidth + 10));
			mGridView.setColumnCount(columns);

			for (int i = 0; i < result.length; i++)
			{
				LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				ImageButton button = (ImageButton) inflater.inflate(R.layout.free_champion_image_button, null);
				Drawable btnImg = getResources().getDrawable(getResources().getIdentifier(
						result[i].replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable", mContext.getPackageName()));
				button.setImageDrawable(btnImg);
				LayoutParams params = new LayoutParams(btnImg.getIntrinsicWidth() * 2, btnImg.getIntrinsicHeight() * 2);
				button.setLayoutParams(params);
				button.setTag(result[i]);
				button.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						showPopup((String) v.getTag());
					}
				});
				mGridView.addView(button);
			}
		}
	}
	
	public void showPopup(String name){
		LinearLayout view = (LinearLayout) this.getActivity().findViewById(R.id.summonerspellpopup);
		LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layout = inflater.inflate(R.layout.fragment_summoner_spell_popup, view);
		
		PopupWindow popup = new PopupWindow(this.getActivity());
		popup.setContentView(layout);
		popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
		popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
		ImageView icon = (ImageView) layout.findViewById(R.id.icon);
		int resID = getResources().getIdentifier(name.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
				"drawable", "com.team4d.lolhelper");
		icon.setImageResource(resID);	
		
		new grabSpell().execute(name);
		
		popup.setOutsideTouchable(true);
		popup.setFocusable(true);
		popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
		
	}
	
	private class grabSpell extends AsyncTask<String, Void, SummonerSpell>
	{
		@Override
		protected SummonerSpell doInBackground(String... spell_name)
		{
			SummonerSpell c = APIData.getSummonerSpellByName(spell_name[0]);
			// Note: This return value is passed as a parameter to onPostExecute
			return c;
		}

		@Override
		protected void onPostExecute(SummonerSpell spell)
		{
			TextView nameText = (TextView) layout.findViewById(R.id.nameDis);
			TextView effectText = (TextView) layout.findViewById(R.id.effectDis);
			TextView cooldownText = (TextView) layout.findViewById(R.id.cooldownDis);
			TextView rangeText = (TextView) layout.findViewById(R.id.rangeDis);
			TextView levelText = (TextView) layout.findViewById(R.id.levelDis); 
			
			// Setting Text for TextViews
			nameText.setText(spell.getName());
			effectText.setText("Effect: \n" + spell.getDescription());
			cooldownText.setText("Cooldown: \n" + spell.getCooldownBurn());
			rangeText.setText("Range: \n" + spell.getRangeBurn());
			levelText.setText("Level: \n" + spell.getSummonerLevel());
		}
	}
}
