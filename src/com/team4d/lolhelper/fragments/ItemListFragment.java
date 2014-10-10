package com.team4d.lolhelper.fragments;

import java.util.Map;

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
import com.team4d.lolhelper.api.dto.staticdata.item.Item;
import com.team4d.lolhelper.api.dto.staticdata.summonerspell.SummonerSpell;

/**
 * TODO: Implement sorting and shop style browsing
 * 
 * @author KaosuRyoko
 */
public class ItemListFragment extends Fragment
{
	View layout; //used for popup
	
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
		LinearLayout view = (LinearLayout) this.getActivity().findViewById(R.id.itempopup);
		LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layout = inflater.inflate(R.layout.fragment_item_popup, view);
		
		PopupWindow popup = new PopupWindow(this.getActivity());
		popup.setContentView(layout);
		popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
		popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
		ImageView icon = (ImageView) layout.findViewById(R.id.icon);
		int resID = getResources().getIdentifier(name.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
				"drawable", "com.team4d.lolhelper");
		icon.setImageResource(resID);	
		
		new grabItem().execute(name);
		
		popup.setOutsideTouchable(true);
		popup.setFocusable(true);
		popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
	}
	
	private class grabItem extends AsyncTask<String, Void, Item>
	{
		@Override
		protected Item doInBackground(String... name)
		{
			Item c = APIData.getItemByName(name[0]);
			// Note: This return value is passed as a parameter to onPostExecute
			return c;
		}

		@Override
		protected void onPostExecute(Item item)
		{
			TextView nameText = (TextView) layout.findViewById(R.id.name);
			TextView mapsText = (TextView) layout.findViewById(R.id.maps);
			TextView descriptionText = (TextView) layout.findViewById(R.id.description);
			TextView totalgoldText = (TextView) layout.findViewById(R.id.totalgold); 
			TextView sellgoldText = (TextView) layout.findViewById(R.id.sellgold); 
			
			// Setting Text for TextViews
			String str = "";
			if(item.getMaps()!=null){
				Map<String, Boolean> maps = item.getMaps();
				//Maps: 1 (SR), 10 (TT), 8 (CS), 12 (HA)
				if(!maps.containsKey("1")){
					str = str + "Summoner's Rift, ";
				}
				if(!maps.containsKey("10")){
					str = str + "Twisted Treeline, ";
				}
				if(!maps.containsKey("8")){
					str = str + "Crystal Scar, ";
				}
				if(!maps.containsKey("12")){
					str = str + "Howling Abyss, ";
				}
				str = str.substring(0, str.length()-2);
			} else {
				str = "All";
			}
			//Get rid of last ", "
			nameText.setText(item.getName());
			mapsText.setText("Maps: \n" + str);
			descriptionText.setText("Description: \n" + APIData.parseOutHtml(item.getDescription()));
			totalgoldText.setText("Total Gold: " + item.getGold().getTotal());
			sellgoldText.setText("Sells For: " + item.getGold().getSell());
		}
	}
}
