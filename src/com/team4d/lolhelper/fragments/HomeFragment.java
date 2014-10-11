package com.team4d.lolhelper.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;

public class HomeFragment extends Fragment
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
		return inflater.inflate(R.layout.fragment_home, container, false);
	}

	@Override
	public void onStart()
	{
		super.onStart();
		new FreeChampionAsyncTask(this.getActivity(), this.getView(), this).execute();
	}

	// Note: Need a general solution to deal with cases where the user opens a new fragment before the doInBackground
	// completes. For now just be patient.
	private class FreeChampionAsyncTask extends AsyncTask<Void, String, String[]>
	{
		private final Context mContext;
		private final View mView;
		private final Fragment fragment;

		public FreeChampionAsyncTask(Context c, View v, Fragment f)
		{
			mContext = c;
			mView = v;
			fragment = f;
		}

		@Override
		protected void onPreExecute()
		{
			// Display loading indicator?
		}

		@Override
		protected String[] doInBackground(Void... params)
		{
			String[] freeChamps = APIData.getFreeChampionList();
			return freeChamps;
		}

		@Override
		protected void onProgressUpdate(String... status)
		{
			// Probably not relevant for this, DB query should be quick
		}

		@Override
		protected void onPostExecute(String[] result)
		{
			if (mView == null || mView.isShown() == false)
			{
				return;
			}
			LinearLayout freeChampLayout = (LinearLayout) mView.findViewById(R.id.FreeChampionsLayout);
			for (int i = 0; i < result.length; i++)
			{
				LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				ImageButton button = (ImageButton) inflater.inflate(R.layout.free_champion_image_button, null);
				Drawable btnImg = getResources().getDrawable(getResources().getIdentifier(
						result[i].replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable", mContext.getPackageName()));
				button.setImageDrawable(btnImg);
				button.setTag(result[i]);
				button.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v){
						Bundle bundle = new Bundle();
						bundle.putString("name", (String) v.getTag());
						ChampionViewFragment f = new ChampionViewFragment();
						f.setArguments(bundle);
						FragmentManager manager = fragment.getFragmentManager();
						FragmentTransaction transaction = manager.beginTransaction().replace(R.id.content_frame, f);
						transaction.addToBackStack(null);
						transaction.commit();
					}
				});
				freeChampLayout.addView(button);
			}
		}
	}
}
