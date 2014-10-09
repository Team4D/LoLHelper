package com.team4d.lolhelper;

import com.team4d.lolhelper.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class Options extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_options);
		listen();
		ScrollView layout = (ScrollView) findViewById(R.id.scrollView1);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		String summonerNameString = ((GlobalVariables) this.getApplication()).getSummonerNameString();
		String languageString = ((GlobalVariables) this.getApplication()).getLanguageString();
		String skinString = ((GlobalVariables) this.getApplication()).getSkinString();
		String enterString = ((GlobalVariables) this.getApplication()).getEnterString();
		String betaString = ((GlobalVariables) this.getApplication()).getBetaString();
		String releaseString = ((GlobalVariables) this.getApplication()).getReleaseString();

		TextView summonerName = (TextView) findViewById(R.id.textView1);
		TextView language = (TextView) findViewById(R.id.textView2);
		TextView skin = (TextView) findViewById(R.id.textView3);
		Button enter = (Button) findViewById(R.id.enter);
		Button beta = (Button) findViewById(R.id.button6);
		Button release = (Button) findViewById(R.id.button7);

		summonerName.setText(summonerNameString);
		language.setText(languageString);
		skin.setText(skinString);
		enter.setText(enterString);
		beta.setText(betaString);
		release.setText(releaseString);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
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

	public void listen()
	{
		EditText edit1;
		final Button enter = (Button) findViewById(R.id.enter);
		edit1 = (EditText) findViewById(R.id.editText1);
		View.OnKeyListener myOnKeyListener = new View.OnKeyListener()
		{
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event)
			{
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
				{
					enter.performClick();
				}
				return false;
			}
		};

		edit1.setOnKeyListener(myOnKeyListener);
	}

	public void summonerName(View view)
	{
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		String summonerName = edit1.getText().toString();
		((GlobalVariables) this.getApplication()).setUserSummonerName(summonerName);
		InputMethodManager inputManager = (InputMethodManager) this
				.getSystemService(Context.INPUT_METHOD_SERVICE);

		// check if no view has focus:
		View v = this.getCurrentFocus();
		if (v == null)
			return;

		inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	}

	public void english(View view)
	{
		((GlobalVariables) this.getApplication()).setLanguage(1);
		((GlobalVariables) this.getApplication()).setStrings();
		finish();
		startActivity(getIntent());
	}

	public void german(View view)
	{
		((GlobalVariables) this.getApplication()).setLanguage(2);
		((GlobalVariables) this.getApplication()).setStrings();
		finish();
		startActivity(getIntent());
	}

	public void spanish(View view)
	{
		((GlobalVariables) this.getApplication()).setLanguage(3);
		((GlobalVariables) this.getApplication()).setStrings();
		finish();
		startActivity(getIntent());
	}

	public void french(View view)
	{
		((GlobalVariables) this.getApplication()).setLanguage(4);
		((GlobalVariables) this.getApplication()).setStrings();
		finish();
		startActivity(getIntent());
	}

	public void italian(View view)
	{
		((GlobalVariables) this.getApplication()).setLanguage(5);
		((GlobalVariables) this.getApplication()).setStrings();
		finish();
		startActivity(getIntent());
	}

	public void beta(View view)
	{
		((GlobalVariables) this.getApplication()).setskin(1);
		finish();
		startActivity(getIntent());
	}

	public void release1(View view)
	{
		((GlobalVariables) this.getApplication()).setskin(2);
		finish();
		startActivity(getIntent());
	}

	@Override
	public void onBackPressed()
	{
		Intent intent = new Intent(this, BaseActivity.class);
		startActivity(intent);
	}

}
