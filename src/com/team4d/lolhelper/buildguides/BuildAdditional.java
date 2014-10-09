package com.team4d.lolhelper.buildguides;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.GlobalVariables;

public class BuildAdditional extends ActionBarActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_buildadditional);

		// Get passed information
		Intent intent = getIntent();
		String champ = intent.getStringExtra("CHAMP");
		String type = intent.getStringExtra("TYPE");
		int mNum = intent.getIntExtra("MNUM", 0);
		int i = ((GlobalVariables) this.getApplication()).getChampionInt(champ.replaceAll("[^a-zA-Z]+", "")
				.toLowerCase());
		String packageName = getPackageName();

		// Find views
		ImageView pic = (ImageView) findViewById(R.id.championpic);
		TextView role = (TextView) findViewById(R.id.championrole);
		ImageView[] skills = { (ImageView) findViewById(R.id.skill1),
				(ImageView) findViewById(R.id.skill2),
				(ImageView) findViewById(R.id.skill3),
				(ImageView) findViewById(R.id.skill4) };

		// Set picture and text displayed
		role.setText(champ + " " + type + " Additional Info:");
		int champID = getResources().getIdentifier(champ.replaceAll("[^a-zA-Z]+", "").toLowerCase(), "drawable",
				getPackageName());
		pic.setImageResource(champID);

		// Build proper database
		BuildDatabase database = new BuildDatabase(type);

		// Set skill order pictures
		int resID;
		for (int j = 0; j < 4; j++)
		{
			resID = getResources().getIdentifier(
					champ.replaceAll("[^a-zA-Z]+", "").toLowerCase()
							+ Integer.toString(database.getDatabase()[i][mNum].getSkillOrder()[j]), "drawable",
					packageName);
			skills[j].setImageResource(resID);
		}
	}
}