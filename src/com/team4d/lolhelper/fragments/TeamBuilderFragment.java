package com.team4d.lolhelper.fragments;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.gson.JsonElement;
import com.team4d.lolhelper.Popup;
import com.team4d.lolhelper.R;
import com.team4d.lolhelper.TeamBuilderData;
import com.team4d.lolhelper.R.drawable;
import com.team4d.lolhelper.R.id;
import com.team4d.lolhelper.R.layout;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.RiotAPI;
import com.team4d.lolhelper.api.database.LOLSQLiteHelper;
import com.team4d.lolhelper.generalinfo.ChampionAttributes;

// Description:
// This is the main Team Builder class.
// It deals with the user interface for the team builder page.getActivity

public class TeamBuilderFragment extends Fragment {
    
	// Create an instance for the data storage class.
    TeamBuilderData teambuilder = new TeamBuilderData();
	// button pressed = 1, button not pressed = 0
    int[] buttonPressFlags = {-1, -1, -1, -1, -1};
	// button is displaying a champion = 1, button is not displaying a champion = 0
    int[] buttonChangedFlags = {0, 0, 0, 0, 0};
    
    Context baseContext;
    
	public TeamBuilderFragment(Context c) {
		baseContext = c;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_builder, container, false);
    }
        
	// Run when the team builder page created.
    @Override
	public void onStart(){
    	super.onStart();

        FrameLayout layout = (FrameLayout)this.getView().findViewById(R.id.container);
   		layout.setBackgroundResource(R.drawable.bg);
        
    	// five buttons on the left
        final ImageButton top = (ImageButton)this.getView().findViewById(R.id.imageButton00);
        final ImageButton jungle = (ImageButton)this.getView().findViewById(R.id.imageButton01);
        final ImageButton middle = (ImageButton)this.getView().findViewById(R.id.imageButton02);
        final ImageButton adc = (ImageButton)this.getView().findViewById(R.id.imageButton03);
        final ImageButton support = (ImageButton)this.getView().findViewById(R.id.imageButton04);
        // button "Suggest Champion" is invisible
        final Button suggestChampion = (Button)this.getView().findViewById(R.id.Button06);
        // button "Suggest Style"
        final Button suggestStyle = (Button)this.getView().findViewById(R.id.Button05);
        // spinner to selecting team styles
        final Spinner spinner1 = (Spinner)this.getView().findViewById(R.id.spinner1);
        // a table layout to display "All Available Champions"	
        final TableLayout table = (TableLayout)this.getView().findViewById(R.id.Table);
		
		// horizontal scroll bars after five buttons to display suggested champions.
		final LinearLayout scroll1 = (LinearLayout) this.getView().findViewById(R.id.Linear1);
		final LinearLayout scroll2 = (LinearLayout) this.getView().findViewById(R.id.Linear2);
		final LinearLayout scroll3 = (LinearLayout) this.getView().findViewById(R.id.Linear3);
		final LinearLayout scroll4 = (LinearLayout) this.getView().findViewById(R.id.Linear4);
		final LinearLayout scroll5 = (LinearLayout) this.getView().findViewById(R.id.Linear5);
        
        // set the display content for spinner
        String[] allStrategies = teambuilder.getAvailableStrategy();
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, allStrategies);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        
        // selector control for spinner
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                	teambuilder.setOurStrategy(-1);
                }
                else {
                	teambuilder.setOurStrategy(teambuilder.getAvailableStrategyArray(position));
                }
            	
			suggestChampion.performClick();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                teambuilder.setOurStrategy(-1);
            }
        });
                        
        // button Suggest Style
        suggestStyle.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				teambuilder.suggestStrategyForTeam();
				// update the contents in spinner
                String[] allStrategies = teambuilder.getAvailableStrategy();
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(TeamBuilderFragment.this.getActivity(), android.R.layout.simple_spinner_item, allStrategies);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
//				suggestChampion.performClick();
			}
		});
        
        // button Suggest Champion
        suggestChampion.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				
				scroll1.removeAllViews();
				scroll2.removeAllViews();
				scroll3.removeAllViews();
				scroll4.removeAllViews();
				scroll5.removeAllViews();
				
				// suggested top champions
				ChampionAttributes[] suggestedTop = teambuilder.suggestChampionsByStrategy(0);
				if ((suggestedTop != null) && (buttonChangedFlags[0] == 0)){
					for (int i = 0; i < suggestedTop.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilderFragment.this.getActivity()), suggestedTop[i]);
						if (suggestedTop[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						
						TableRow.LayoutParams tableLayoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
						tableLayoutParams.setMargins(0, 0, 20, 0);	// 20 px right-margin

						// New Cell
						LinearLayout cell = new LinearLayout(v.getContext());
						cell.setBackgroundColor(Color.TRANSPARENT);
						cell.setLayoutParams(tableLayoutParams);	// 20 px border on the right for the cell
						cell.addView(newButton);
						
						scroll1.addView(cell);
						final ChampionAttributes currentChampion = suggestedTop[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[0] == 1){
									teambuilder.setOurTeam(0, currentChampion);
							    	String message = currentChampion.getName();
							    	top.setImageResource(getResources().getIdentifier(
							    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[0] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}
				
				// suggested jungle champions
				ChampionAttributes[] suggestedJungle = teambuilder.suggestChampionsByStrategy(1);
				if ((suggestedJungle != null) && (buttonChangedFlags[1] == 0)){
					for (int i = 0; i < suggestedJungle.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilderFragment.this.getActivity()), suggestedJungle[i]);
						if (suggestedJungle[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						
						TableRow.LayoutParams tableLayoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
						tableLayoutParams.setMargins(0, 0, 20, 0);	// 20 px right-margin

						// New Cell
						LinearLayout cell = new LinearLayout(v.getContext());
						cell.setBackgroundColor(Color.TRANSPARENT);
						cell.setLayoutParams(tableLayoutParams);	// 20 px border on the right for the cell
						cell.addView(newButton);
						
						scroll2.addView(cell);
						final ChampionAttributes currentChampion = suggestedJungle[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[1] == 1){
									teambuilder.setOurTeam(1, currentChampion);
							    	String message = currentChampion.getName();
							    	jungle.setImageResource(getResources().getIdentifier(
							    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[1] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}

				// Suggested middle champions				
				ChampionAttributes[] suggestedMid = teambuilder.suggestChampionsByStrategy(2);
				if ((suggestedMid != null) && (buttonChangedFlags[2] == 0)){
					for (int i = 0; i < suggestedMid.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilderFragment.this.getActivity()), suggestedMid[i]);
						if (suggestedMid[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						
						TableRow.LayoutParams tableLayoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
						tableLayoutParams.setMargins(0, 0, 20, 0);	// 20 px right-margin

						// New Cell
						LinearLayout cell = new LinearLayout(v.getContext());
						cell.setBackgroundColor(Color.TRANSPARENT);
						cell.setLayoutParams(tableLayoutParams);	// 20 px border on the right for the cell
						cell.addView(newButton);
						
						scroll3.addView(cell);
						final ChampionAttributes currentChampion = suggestedMid[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[2] == 1){
									teambuilder.setOurTeam(2, currentChampion);
							    	String message = currentChampion.getName();
							    	middle.setImageResource(getResources().getIdentifier(
							    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[2] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}
				
				// suggested ADCs
				ChampionAttributes[] suggestedADC = teambuilder.suggestChampionsByStrategy(3);
				if ((suggestedADC != null) && (buttonChangedFlags[3] == 0)){
					for (int i = 0; i < suggestedADC.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilderFragment.this.getActivity()), suggestedADC[i]);
						if (suggestedADC[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						
						TableRow.LayoutParams tableLayoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
						tableLayoutParams.setMargins(0, 0, 20, 0);	// 20 px right-margin

						// New Cell
						LinearLayout cell = new LinearLayout(v.getContext());
						cell.setBackgroundColor(Color.TRANSPARENT);
						cell.setLayoutParams(tableLayoutParams);	// 20 px border on the right for the cell
						cell.addView(newButton);
						
						scroll4.addView(cell);
						final ChampionAttributes currentChampion = suggestedADC[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[3] == 1){
									teambuilder.setOurTeam(3, currentChampion);
							    	String message = currentChampion.getName();
							    	adc.setImageResource(getResources().getIdentifier(
							    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));
							    	
									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[3] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}
				
				// suggested support champions
				ChampionAttributes[] suggestedSupport = teambuilder.suggestChampionsByStrategy(4);
				if ((suggestedSupport != null) && (buttonChangedFlags[4] == 0)){
					for (int i = 0; i < suggestedSupport.length; i++){
						final ImageButton newButton = initializeButton(new ImageButton(TeamBuilderFragment.this.getActivity()), suggestedSupport[i]);
						if (suggestedSupport[i].getName().equals("NONAME")){
							newButton.setVisibility(View.GONE);
						}
						
						TableRow.LayoutParams tableLayoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
						tableLayoutParams.setMargins(0, 0, 20, 0);	// 20 px right-margin

						// New Cell
						LinearLayout cell = new LinearLayout(v.getContext());
						cell.setBackgroundColor(Color.TRANSPARENT);
						cell.setLayoutParams(tableLayoutParams);	// 20 px border on the right for the cell
						cell.addView(newButton);
						
						scroll5.addView(cell);
						final ChampionAttributes currentChampion = suggestedSupport[i];
						newButton.setOnClickListener(new View.OnClickListener(){
							@Override
					        public void onClick(View v){
								if (buttonPressFlags[4] == 1){
									teambuilder.setOurTeam(4, currentChampion);
							    	String message = currentChampion.getName();
							    	support.setImageResource(getResources().getIdentifier(
							    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));

									buttonPressFlags[0] = -1;
									buttonPressFlags[1] = -1;
									buttonPressFlags[2] = -1;
									buttonPressFlags[3] = -1;
									buttonPressFlags[4] = -1;
									buttonChangedFlags[4] = 1;
									newButton.setVisibility(View.GONE);
									suggestChampion.performClick();
								}
					        }
						});
					}
				}
				
				// Table to display all available champions
				table.removeAllViews();
				TableLayout.LayoutParams tableRowParams = new TableLayout.LayoutParams(
						TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
				tableRowParams.setMargins(3, 3, 2, 10);
				
				// Set the max num of buttons in a row according to the device size.
				DisplayMetrics dm = v.getContext().getResources().getDisplayMetrics();
				float dpScreenWidth = dm.widthPixels / dm.density;
				float dpBorderWidth = 20 / (dm.densityDpi / 160);	// dp = px / (dpi / 160)
				int maxButtonInRow = (int) (dpScreenWidth / (60 + dpBorderWidth));	// 60 dp is button width, 20 px is border width.
		
				// Fill the rows with buttons
				int buttonInRow = maxButtonInRow;
				TableRow currentRow = null;
				ChampionAttributes[] allAvailableChampions = teambuilder.getAllAvailableChampions();
				for (int i = 0; i < allAvailableChampions.length; i++){
					if (buttonInRow == maxButtonInRow){
						buttonInRow = 0;
						TableRow newRow = new TableRow(TeamBuilderFragment.this.getActivity());
						newRow.setBackgroundColor(Color.TRANSPARENT);
						newRow.setPadding(0, 0, 0, 20);	// Border between rows
						newRow.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 60));	// 60dp high
						
						table.addView(newRow);
						currentRow = newRow;
					}
					
					// Create the button
					final ImageButton newButton = initializeButton(new ImageButton(TeamBuilderFragment.this.getActivity()), allAvailableChampions[i]);
					if (allAvailableChampions[i].getName().equals("NONAME")){
						newButton.setVisibility(View.GONE);
					}
					else{
						buttonInRow += 1;
					}
					newButton.setPadding(0, 0, 20, 20);
					
					TableRow.LayoutParams tableLayoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
					tableLayoutParams.setMargins(0, 0, 20, 0);	// 20 px right-margin

					// New Cell
					LinearLayout cell = new LinearLayout(v.getContext());
					cell.setBackgroundColor(Color.TRANSPARENT);
					cell.setLayoutParams(tableLayoutParams);	// 20 px border on the right for the cell
					cell.addView(newButton);
					currentRow.addView(cell);
					
					// Following code works for selecting champion from "All available champion" field
					final ChampionAttributes currentChampion = allAvailableChampions[i];
					newButton.setOnClickListener(new View.OnClickListener(){
						@Override
				        public void onClick(View v){
							if (buttonPressFlags[0] == 1){
								teambuilder.setOurTeam(0, currentChampion);
								buttonChangedFlags[0] = 1;
						    	String message = currentChampion.getName();
						    	top.setImageResource(getResources().getIdentifier(
						    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));

							}
							else if (buttonPressFlags[1] == 1){
								teambuilder.setOurTeam(1, currentChampion);
								buttonChangedFlags[1] = 1;
						    	String message = currentChampion.getName();
						    	jungle.setImageResource(getResources().getIdentifier(
						    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));

							}
							else if (buttonPressFlags[2] == 1){
								teambuilder.setOurTeam(2, currentChampion);
								buttonChangedFlags[2] = 1;
						    	String message = currentChampion.getName();
						    	middle.setImageResource(getResources().getIdentifier(
						    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));

							}
							else if (buttonPressFlags[3] == 1){
								teambuilder.setOurTeam(3, currentChampion);
								buttonChangedFlags[3] = 1;
						    	String message = currentChampion.getName();
						    	adc.setImageResource(getResources().getIdentifier(
						    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));

							}
							else if (buttonPressFlags[4] == 1){
								teambuilder.setOurTeam(4, currentChampion);
								buttonChangedFlags[4] = 1;
						    	String message = currentChampion.getName();
						    	support.setImageResource(getResources().getIdentifier(
						    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", v.getContext().getPackageName()));
							}
							buttonPressFlags[0] = -1;
							buttonPressFlags[1] = -1;
							buttonPressFlags[2] = -1;
							buttonPressFlags[3] = -1;
							buttonPressFlags[4] = -1;
							newButton.setVisibility(View.GONE);
							suggestChampion.performClick();
				        }
					});
				}
			}
		});
        
        // button Top
        top.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[0] = 1;
				buttonChangedFlags[0] = 0;
				
				buttonPressFlags[1] = -1;
				buttonPressFlags[2] = -1;
				buttonPressFlags[3] = -1;
				buttonPressFlags[4] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(0, emptyChampion);
				top.setImageResource(R.drawable.top);
				suggestChampion.performClick();
			}
		});
        
        // button Jungle
        jungle.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[1] = 1;
				buttonChangedFlags[1] = 0;
				
				buttonPressFlags[0] = -1;
				buttonPressFlags[2] = -1;
				buttonPressFlags[3] = -1;
				buttonPressFlags[4] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(1, emptyChampion);
				jungle.setImageResource(R.drawable.jungle);
				suggestChampion.performClick();
			}
		});
        
        // button Middle
        middle.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[2] = 1;
				buttonChangedFlags[2] = 0;
				
				buttonPressFlags[0] = -1;
				buttonPressFlags[1] = -1;
				buttonPressFlags[3] = -1;
				buttonPressFlags[4] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(2, emptyChampion);
				middle.setImageResource(R.drawable.middle);
				suggestChampion.performClick();
			}
		});
        
        // button ADC
        adc.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[3] = 1;
				buttonChangedFlags[3] = 0;
				
				buttonPressFlags[0] = -1;
				buttonPressFlags[1] = -1;
				buttonPressFlags[2] = -1;
				buttonPressFlags[4] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(3, emptyChampion);
				adc.setImageResource(R.drawable.adc);
				suggestChampion.performClick();
			}
		});
        
        // button Support
        support.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				buttonPressFlags[4] = 1;
				buttonChangedFlags[4] = 0;
				
				buttonPressFlags[0] = -1;
				buttonPressFlags[1] = -1;
				buttonPressFlags[2] = -1;
				buttonPressFlags[3] = -1;
				ChampionAttributes emptyChampion = new ChampionAttributes(); 
				teambuilder.setOurTeam(4, emptyChampion);
				support.setImageResource(R.drawable.support);
				suggestChampion.performClick();
			}	
		});
        
        // button Help
        Button help = (Button) this.getActivity().findViewById(R.id.ButtonHelp);
        help.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		popup();
        	}
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
	// Initialization method for automatically generated imagebuttons.
    private ImageButton initializeButton(ImageButton icon, ChampionAttributes champion){
/*        
    	String message = champion.getName();
    	icon.setImageResource(getResources().getIdentifier(
    			message.replaceAll("[^a-zA-Z]+","").toLowerCase(), "drawable", this.getActivity().getPackageName()));
*/		
    	if (champion.getName() != "NONAME")
    		new LoadChampionImage(baseContext, this.getActivity(), icon, champion.getName()).execute();

    	return icon;
    }
    
    // Help Popup
    public void popup(){
		Activity activity = this.getActivity();		
		View layout = Popup.popupTeamBuilder(activity);
		
		PopupWindow popup = new PopupWindow(this.getActivity());
		popup.setContentView(layout);
		popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
		popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);		
		popup.setOutsideTouchable(true);
		popup.setFocusable(true);
		popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
    }
    
	private class LoadChampionImage extends AsyncTask<Void, String, Void>
	{
		RiotAPI api = new RiotAPI("na");
		private JsonElement v = api.GetVersions();
		private String VERSION = v.getAsJsonArray().get(0).toString().replaceAll("'", "''");
		private final Context mContext;
		private final Activity mActivity;
		private ImageButton button;
		private String name;

		public LoadChampionImage(Context c, Activity a, ImageButton b, String s)
		{
			mContext = c;
			mActivity = a;
			button = b;
			name = s;
		}

		@Override
		protected void onPreExecute()
		{
		}

		@Override
		protected Void doInBackground(Void... params)
		{
			System.out.println("Loading " + name);
			String fileName = APIData.getChampionByName(name).getImage().getFull();
			
			File png = new File(mContext.getFilesDir() + "/" + fileName);
			if (png.exists()){
				final Drawable d = Drawable.createFromPath(mContext.getFilesDir() + "/" + fileName);
				mActivity.runOnUiThread(new Runnable() {
		            @Override
		            public void run() {
		                DisplayMetrics dm = getResources().getDisplayMetrics();
		                float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, dm);
		                Bitmap bm = ((BitmapDrawable) d).getBitmap();
		                Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bm, (int)dpInPx, (int)dpInPx, true));
		            	button.setImageDrawable(d);
		                button.setAdjustViewBounds(true);
		            	button.setMaxHeight((int)dpInPx);
		            	button.setMaxWidth((int)dpInPx);
		            	button.setMinimumHeight((int)dpInPx);
		            	button.setMinimumWidth((int)dpInPx);
		            	button.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
		            	button.setScaleType(ScaleType.FIT_CENTER);
		            	button.setPadding(0, 0, 0, 0);
		            	button.setBackgroundColor(Color.TRANSPARENT);
		            }
		        });
			}
			else{	// load image from ddragon and download it
				try {
					// Download the image
					URL url = new URL("http://ddragon.leagueoflegends.com/cdn/" + VERSION + "/img/champion/" + fileName.replaceAll(" ", "%20"));
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			        connection.setDoInput(true);
			        connection.connect();
			        InputStream in = connection.getInputStream();
			        Bitmap bmp = BitmapFactory.decodeStream(in);
			        button.setImageBitmap(bmp);
			        
					// Save image to phone
			        File file = new File(mContext.getFilesDir(), fileName);
			        FileOutputStream output = new FileOutputStream(file);
			        byte[] buffer = new byte[51200];
		            int length = 0;
		            while ((length = in.read(buffer)) > 0) {
		                output.write(buffer,0, length);
		            }
		            output.close();
		            System.out.println(fileName + " successfully downloaded");
				}
				catch (Exception e) {
					Log.e("DownloadingError", "Failed to download " + fileName);
	            }
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(String... status)
		{
		}

		@Override
		protected void onPostExecute(Void empty)
		{
		}
	}
}
