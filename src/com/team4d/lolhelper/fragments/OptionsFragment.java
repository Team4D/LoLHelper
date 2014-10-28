package com.team4d.lolhelper.fragments;

import com.team4d.lolhelper.R;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The fragment to show the Options page.
 * 
 * @author Alexa
 */
public class OptionsFragment extends Fragment
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
		return inflater.inflate(R.layout.fragment_options, container, false);
	}
	@Override
	public void onStart()
	{
		super.onStart();
		
		listen();

		//Summoner name
		EditText edit1 = (EditText) getActivity().findViewById(R.id.editText1);
		
		SharedPreferences sharedpreferences = getActivity().getSharedPreferences("Prefs", Context.MODE_PRIVATE);
		if(sharedpreferences.contains("summonerName")){
			edit1.setText(sharedpreferences.getString("summonerName", ""));
		}
		
		//Region spinner
        final Spinner spinner1 = (Spinner)this.getView().findViewById(R.id.spinner1);
        final String[] regions = {"NA", "BR", "EUNE", "EUW", "KR", "LAN", "LAS", "OCE", "RU", "TR"};
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, regions);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener(){
        	@Override
        	public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        		SharedPreferences sharedpreferences = view.getContext().getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        		String summonerName = "";
        		if(sharedpreferences.contains("summonerName")){
        			summonerName = sharedpreferences.getString("summonerName", "");
        		}
        		Editor editor = sharedpreferences.edit();
        		editor.putString("summonerName", summonerName);
        		editor.putString("region", regions[position]);
        		editor.commit();
        	}
        	
        	@Override
        	public void onNothingSelected(AdapterView<?> parent){
        		
        	}
        });
        
        if(sharedpreferences.contains("region")){
        	int i = adapter1.getPosition(sharedpreferences.getString("region", ""));
        	spinner1.setSelection(i);
        }
	}	
	
	public void listen()
	{
		EditText edit1;
		final Button enter = (Button) getActivity().findViewById(R.id.enter);
		enter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                summonerName(v);
            }
        });
		edit1 = (EditText) getActivity().findViewById(R.id.editText1);
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
		EditText edit1 = (EditText) getActivity().findViewById(R.id.editText1);
		String summonerName = edit1.getText().toString();
		//Save preference
		SharedPreferences sharedpreferences = getActivity().getSharedPreferences("Prefs", Context.MODE_PRIVATE);
		Editor editor = sharedpreferences.edit();
		editor.putString("summonerName", summonerName);
		editor.commit();
		
		Toast.makeText(view.getContext(), "Saved", Toast.LENGTH_SHORT).show();
		
		InputMethodManager inputManager = (InputMethodManager) this
				.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

		// check if no view has focus:
		View v = this.getActivity().getCurrentFocus();
		if (v == null)
			return;

		inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	}
}
