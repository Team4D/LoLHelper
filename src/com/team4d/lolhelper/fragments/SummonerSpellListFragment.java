package com.team4d.lolhelper.fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageButton;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;

public class SummonerSpellListFragment extends Fragment
{
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
				mGridView.addView(button);
			}
		}
	}
}
