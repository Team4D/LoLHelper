package com.team4d.lolhelper.fragments;

import com.team4d.lolhelper.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * The fragment to show the About page.
 * 
 * @author Alexa
 */
public class AboutFragment extends Fragment
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
		return inflater.inflate(R.layout.fragment_about, container, false);
	}
	@Override
	public void onStart()
	{
		super.onStart();
		String greg = "Greg Ervin";
		String alexa = "Alexa Varady";
		String thomas = "Thomas Ford";
		String su = "Su Yan";
		String austin = "Austin Hofmann";
		String murl = "Murl Westheffer";
		
		
		TextView titles = (TextView) getActivity().findViewById(R.id.titles);
		TextView names = (TextView) getActivity().findViewById(R.id.names);
		
		String[] credits = {"", ""};
		addCredits(credits, "Executive Producer:", new String[] {"Paul Steffens"});
		addCredits(credits, "Project Managers:", new String[] {greg, alexa});
		addCredits(credits, "Team Builder:", new String[] {thomas, "Josh Werner", su});
		addCredits(credits, "Build Roulette:", new String[] {austin, su});
		addCredits(credits, "Ranked Stats:", new String[] {greg, "Brice Thrower", "Patrick Walter", "David Young"});
		addCredits(credits, "General Info:", new String[] {greg, "Sean Hannah", "Megan Teahan", alexa, murl, su});
		addCredits(credits, "Jungle Timers:", new String[] {"Evan Bissell", "Qin Chen", alexa});
		addCredits(credits, "Build Guides:", new String[] {"Eric Chanthorabout", alexa});
		addCredits(credits, "Layout:", new String[] {greg, "Sean Stout", su});
		
		titles.setText(credits[0]);
		names.setText(credits[1]);
	}

	public void addCredits(String[] credits, String title, String[] people){
		int n = people.length;
		credits[0] += title;
		for(int i=0; i<n; i++){
			credits[1] += people[i] + "\n";
			credits[0] += "\n";
		}
		credits[0] += "\n";
		credits[1] += "\n";
	}
	
}
