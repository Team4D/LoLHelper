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

/**
 * TODO: Implement sorting and shop style browsing
 * 
 * @author KaosuRyoko
 */
public class ItemListFragment extends Fragment
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
		return inflater.inflate(R.layout.fragment_itemlist, container, false);
	}

	@Override
	public void onStart()
	{
		super.onStart();
		new ChampionListAsyncTask(this.getActivity(), this.getView()).execute();
	}

	private class ChampionListAsyncTask extends AsyncTask<Void, String, String[]>
	{

		private final Context mContext;
		private final View mView;

		public ChampionListAsyncTask(Context c, View v)
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
			String[] items = APIData.getItemList();
			return items;
		}

		@Override
		protected void onProgressUpdate(String... status)
		{
			// Probably not relevant for this, DB query should be quick
		}

		@Override
		protected void onPostExecute(String[] result)
		{
			GridLayout mGridView = (GridLayout) mView.findViewById(R.id.ItemListGrid);

			DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
			float dpWidth = dm.widthPixels / dm.density;

			Drawable imgsize = getResources().getDrawable(R.drawable.defaultitemsize);
			float dpImgWidth = imgsize.getIntrinsicWidth() / dm.density;

			int columns = (int) (dpWidth / (dpImgWidth + 10));
			mGridView.setColumnCount(columns);

			boolean bonetoothonce = false;
			boolean headkhaonce = false;

			for (int i = 0; i < result.length; i++)
			{
				LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				ImageButton button = (ImageButton) inflater.inflate(R.layout.free_champion_image_button, null);
				String n = result[i].replaceAll("[^a-zA-Z0-9]+", "").toLowerCase().replaceAll("showdown", "");
				// Workaround for now,all different shoes with the same enchantment share the same name. Will need
				// careful consideration later.
				if (n.contains("enchantment"))
				{
					continue;
				}
				if (n.contains("bonetooth"))
				{
					if (bonetoothonce)
					{
						continue;
					}
					else
					{
						bonetoothonce = true;
					}
				}
				if (n.contains("headofkhazix"))
				{
					if (headkhaonce)
					{
						continue;
					}
					else
					{
						headkhaonce = true;
					}
				}
				// Should update this to grab the image out of the dto object.
				// Along the same lines, should just add the dragontail directories as resources to our project.
				Drawable btnImg = getResources().getDrawable(getResources().getIdentifier(
						n, "drawable", mContext.getPackageName()));
				button.setImageDrawable(btnImg);
				LayoutParams params = new LayoutParams(btnImg.getIntrinsicWidth() * 2, btnImg.getIntrinsicHeight() * 2);
				button.setLayoutParams(params);
				mGridView.addView(button);
			}
		}
	}
}
