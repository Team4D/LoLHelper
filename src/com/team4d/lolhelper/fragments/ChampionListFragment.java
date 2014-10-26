package com.team4d.lolhelper.fragments;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.ImageButton;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;

public class ChampionListFragment extends Fragment
{
	private CheckBox assassin, fighter, mage, marksman, support, tank;
	private Button clear;
	
	protected boolean assassinChecked = false;
	protected boolean fighterChecked = false;
	protected boolean mageChecked = false;
	protected boolean marksmanChecked = false;
	protected boolean supportChecked = false;
	protected boolean tankChecked = false;
	
	protected String[] championList;
	protected List<List<String>> allChampionTags;
	
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
		return inflater.inflate(R.layout.fragment_championlist, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		if (this.getActivity() == null || this.getView().isShown() == false)
		{
			return;
		}
		
		final Fragment fragment = this;
		// Checkboxes
		assassin = (CheckBox) this.getView().findViewById(R.id.Assassin);
		fighter = (CheckBox) this.getView().findViewById(R.id.Fighter);
		mage = (CheckBox) this.getView().findViewById(R.id.Mage);
		marksman = (CheckBox) this.getView().findViewById(R.id.Marksman);
		support = (CheckBox) this.getView().findViewById(R.id.Support);
		tank = (CheckBox) this.getView().findViewById(R.id.Tank);
		
		assassin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(assassin.isChecked()){
                    assassinChecked = true;
                }else{
                	assassinChecked = false;
                }
                updateChampions(fragment);
            }
        });
		
		fighter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fighter.isChecked()){
                    fighterChecked = true;
                }else{
                	fighterChecked = false;
                }
                updateChampions(fragment);
            }
        });
		
		mage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mage.isChecked()){
                    mageChecked = true;
                }else{
                	mageChecked = false;
                }
                updateChampions(fragment);
            }
        });
		
		marksman.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(marksman.isChecked()){
                    marksmanChecked = true;
                }else{
                	marksmanChecked = false;
                }
                updateChampions(fragment);
            }
        });
		
		support.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(support.isChecked()){
                    supportChecked = true;
                }else{
                	supportChecked = false;
                }
                updateChampions(fragment);
            }
        });
		
		tank.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tank.isChecked()){
                    tankChecked = true;
                }else{
                	tankChecked = false;
                }
                updateChampions(fragment);
            }
        });
		
		// Button Clear
		clear = (Button) this.getView().findViewById(R.id.btnClear);
		clear.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				// Set all checkboxes to uncheck
				assassin.setChecked(false);
				fighter.setChecked(false);
				mage.setChecked(false); 
				marksman.setChecked(false);			
				support.setChecked(false);
				tank.setChecked(false); 
				
				// Set all flags to false.
				assassinChecked = false;
				fighterChecked = false;
				mageChecked = false;
				marksmanChecked = false;
				supportChecked = false;
				tankChecked = false;

				// Update the display field.
				updateChampions(fragment);
			}
		});	
		
		new ChampionListAsyncTask(this).execute();
	}

	private class ChampionListAsyncTask extends AsyncTask<Void, String, String[]>
	{
		private final Fragment fragment;

		public ChampionListAsyncTask(Fragment f)
		{
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
			championList = APIData.getChampionList();
			allChampionTags = new ArrayList<List<String>>();
			for (int i = 0; i < championList.length; i++){
				try{
					allChampionTags.add(i, APIData.getChampionByName(championList[i]).getTags());
				}
				catch (NullPointerException e){
					allChampionTags.add(i, null);
				}
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(String... status)
		{
			// Probably not relevant for this, DB query should be quick
		}

		@Override
		protected void onPostExecute(String[] result)
		{
			updateChampions(fragment);
		}
	}
	
	public void updateChampions(final Fragment fragment){
		int itemCount = 0;
		String[] tempResult = new String[championList.length];
		String[] result;
		
		// If one or more checkbox has been selected, apply the filter, or all champions are displayed.
		if (assassinChecked || fighterChecked || mageChecked || marksmanChecked 
				|| supportChecked || tankChecked){
			for (int i = 0; i < championList.length; i++){
				List<String> championTags = allChampionTags.get(i);
				
				boolean qualified = false;
				if (championTags != null){
					qualified = true;
					
					if ((assassinChecked) && !(championTags.contains("Assassin"))){
						qualified = false;
					}
					else if ((fighterChecked) && !(championTags.contains("Fighter"))){
						qualified = false;
					}
					else if ((mageChecked) && !(championTags.contains("Mage"))){
						qualified = false;
					}
					else if ((marksmanChecked) && !(championTags.contains("Marksman"))){
						qualified = false;
					}
					else if ((supportChecked) && !(championTags.contains("Support"))){
						qualified = false;
					}
					else if ((tankChecked) && !(championTags.contains("Tank"))){
						qualified = false;
					}
				}
				if (qualified){
					tempResult[itemCount] = championList[i];
					itemCount += 1;					
				}
			}
			
			result = new String[itemCount];
			for (int i = 0; i < itemCount; i++){
				result[i] = tempResult[i];
			}
		}
		else{
			result = championList;
		}
		
		// Display field
		GridLayout mGridView = (GridLayout) this.getView().findViewById(R.id.ChampionListGrid);
		mGridView.removeAllViews();
		DisplayMetrics dm = this.getActivity().getResources().getDisplayMetrics();
		float dpWidth = dm.widthPixels / dm.density;

		Drawable imgsize = getResources().getDrawable(R.drawable.defaultchampsize);
		float dpImgWidth = imgsize.getIntrinsicWidth() / dm.density;

		int columns = (int) ((dpWidth - 90) / (dpImgWidth + 10));
		mGridView.setColumnCount(columns);

		for (int i = 0; i < result.length; i++)
		{
			LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			ImageButton button = (ImageButton) inflater.inflate(R.layout.free_champion_image_button, null);
			Drawable btnImg = getResources().getDrawable(getResources().getIdentifier(
					result[i].replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable", this.getActivity().getPackageName()));
			button.setImageDrawable(btnImg);
			button.setTag(result[i]);
			button.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
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
			mGridView.addView(button);
		}
	}
}
