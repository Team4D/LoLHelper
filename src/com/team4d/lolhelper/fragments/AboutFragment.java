package com.team4d.lolhelper.fragments;

import com.team4d.lolhelper.GlobalVariables;
import com.team4d.lolhelper.R;
import com.team4d.lolhelper.R.drawable;
import com.team4d.lolhelper.R.id;
import com.team4d.lolhelper.R.layout;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.team4d.lolhelper.GlobalVariables;

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

	public void onStart()
	{
		super.onStart();
		
		RelativeLayout layout = (RelativeLayout) this.getView().findViewById(R.id.container);
		layout.setBackgroundResource(R.drawable.bg);

		String createdString = GlobalVariables.getCreatedByString();
//		String rightString = GlobalVariables.getAboutRolesRightString();
		String versionString = GlobalVariables.getVersionString();

		TextView created = (TextView) this.getView().findViewById(R.id.textView1);
//		TextView right = (TextView) this.getView().findViewById(R.id.textView3);
		TextView version = (TextView) this.getView().findViewById(R.id.textView4);

		created.setText(createdString);
//		right.setText(rightString);
		version.setText(versionString);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
