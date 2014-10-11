package com.team4d.lolhelper.fragments;

import java.util.Map;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.staticdata.champion.Champion;
import com.team4d.lolhelper.api.dto.staticdata.item.Item;

public class ChampionViewFragment extends Fragment
{
	String name;
	static final int NUM_ITEMS = 5;
	MyAdapter mAdapter;
	ViewPager mPager;
	PagerAdapter mPagerAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		name = getArguments().getString("name");
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
		mPagerAdapter = new MyAdapter(getActivity().getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);
		PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) getActivity().findViewById(R.id.titlestrip);
		
		ImageView icon = (ImageView) getView().findViewById(R.id.icon);
		int resID = getResources().getIdentifier(name.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
				"drawable", getActivity().getPackageName());
		icon.setImageResource(resID);
		new grabChampion(name).execute();

	}
	
	public static class MyAdapter extends FragmentPagerAdapter {
        String[] title = {
        	"Overview",
        	"Stats",
        	"Lore",
        	"Builds",
        	"Counters"
        };
		
		public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            return SlideScreenFragment.newInstance(position);
        }
        
        @Override
        public CharSequence getPageTitle(int position) {
         return title[position];
        }
    }

    public static class SlideScreenFragment extends Fragment {
        int mNum;

        /**
         * Create a new instance of CountingFragment, providing "num"
         * as an argument.
         */
        static SlideScreenFragment newInstance(int num) {
            SlideScreenFragment f = new SlideScreenFragment();

            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt("num", num);
            f.setArguments(args);

            return f;
        }

        /**
         * When creating, retrieve this instance's number from its arguments.
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        /**
         * The Fragment's UI
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_pager_list, container, false);

            
            LinearLayout layout = (LinearLayout) v.findViewById(R.id.container);
            switch(mNum){
            case 0: //Overview
            	TextView t = new TextView(v.getContext());
            	t.setText("test");
            	layout.addView(t);
            	break;
            case 1: //Stats
            	break;
            case 2: //Lore
            	break;
            case 3: //Builds
            	break;
            case 4: //Counters
            	break;
            default:
            	TextView t2 = new TextView(v.getContext());
            	t2.setText("test2");
            	layout.addView(t2);
            	break;
            }
            return v;
        }

    }
    
    
    
    
	private class grabChampion extends AsyncTask<String, Void, Champion>
	{
		private final String name;
		
		public grabChampion(String name){
			this.name=name;
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
