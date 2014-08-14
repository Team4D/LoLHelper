package com.fourfoureight.lolhelper.Build_Guides;

import com.fourfoureight.lolhelper.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildAdditional extends ActionBarActivity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buildadditional);
		
		//Get passed information
		Intent intent = getIntent();
		String champ = intent.getStringExtra("CHAMP");
		String type = intent.getStringExtra("TYPE");
		int mNum = intent.getIntExtra("MNUM", 0);
		
		//Find views
		ImageView pic = (ImageView) findViewById(R.id.championpic);
		TextView role = (TextView) findViewById(R.id.championrole);
		
		//Set picture and text displayed
		role.setText(champ + " " + type + " Additional Info:");
		int champID = getResources().getIdentifier(champ.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", getPackageName());
        pic.setImageResource(champID);
        
		//Build proper database
		BuildDatabase database = new BuildDatabase(type);
	}
}
