package com.team4d.lolhelper.fragments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.team4d.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.staticdata.item.Item;

/**
 * TODO: Implement sorting and shop style browsing
 * 
 * @author KaosuRyoko
 */
public class ItemListFragment extends Fragment
{
	View layout; // used for popup

	// For item filter use.
	private CheckBox armor, health, healthRegen, magicResist, tenacity;
	private CheckBox attackSpeed, armorPenetration, criticalStrike, damage, lifeSteal;
	private CheckBox abilityPower, cooldownReduction, magicPenetration, mana, manaRegen, spellVamp;
	private CheckBox boots, otherMovement;
	private CheckBox consumable, goldIncome, visionAndTrinkets;
	private CheckBox active, jungleHelper;
	
	protected boolean armorChecked = false;
	protected boolean healthChecked = false;
	protected boolean healthRegenChecked = false;
	protected boolean magicResistChecked = false;
	protected boolean tenacityChecked = false;
	
	protected boolean attackSpeedChecked = false;
	protected boolean armorPenetrationChecked = false;
	protected boolean criticalStrikeChecked = false;
	protected boolean damageChecked = false;
	protected boolean lifeStealChecked = false;
	
	protected boolean abilityPowerChecked = false;
	protected boolean cooldownReductionChecked = false;
	protected boolean magicPenetrationChecked = false;
	protected boolean manaChecked = false;
	protected boolean manaRegenChecked = false;
	protected boolean spellVampChecked = false;
	
	protected boolean bootsChecked = false;
	protected boolean otherMovementChecked = false;
	
	protected boolean consumableChecked = false;
	protected boolean goldIncomeChecked = false;
	protected boolean visionAndTrinketsChecked = false;
	
	protected boolean activeChecked = false;
	protected boolean jungleHelperChecked = false;
	
	protected String[] itemList;
	protected List<List<String>> allItemTags;
	
	
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
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		if (this.getActivity() == null || this.getView().isShown() == false){
			return;
		}
		
		// Checkboxes for Defense category
		armor = (CheckBox) this.getView().findViewById(R.id.Armor);
		health = (CheckBox) this.getView().findViewById(R.id.Health);
		healthRegen = (CheckBox) this.getView().findViewById(R.id.HealthRegen);
		magicResist = (CheckBox) this.getView().findViewById(R.id.MagicResist);
		tenacity = (CheckBox) this.getView().findViewById(R.id.Tenacity);
		
		armor.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(armor.isChecked()){
                    armorChecked = true;
                }else{
                	armorChecked = false;
                }
                updateItems();
            }
        });
		
		health.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(health.isChecked()){
                    healthChecked = true;
                }else{
                	healthChecked = false;
                }
                updateItems();
            }
        });
		
		healthRegen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(healthRegen.isChecked()){
                    healthRegenChecked = true;
                }else{
                	healthRegenChecked = false;
                }
                updateItems();
            }
        });
		
		magicResist.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(magicResist.isChecked()){
                    magicResistChecked = true;
                }else{
                	magicResistChecked = false;
                }
                updateItems();
            }
        });
		
		tenacity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tenacity.isChecked()){
                    tenacityChecked = true;
                }else{
                	tenacityChecked = false;
                }
                updateItems();
            }
        });
					
		// Checkboxes for Attack category
		attackSpeed = (CheckBox) this.getView().findViewById(R.id.AttackSpeed);
		armorPenetration = (CheckBox) this.getView().findViewById(R.id.ArmorPenetration);
		criticalStrike = (CheckBox) this.getView().findViewById(R.id.CriticalStrike);
		damage = (CheckBox) this.getView().findViewById(R.id.Damage);
		lifeSteal = (CheckBox) this.getView().findViewById(R.id.LifeSteal);
		
		attackSpeed.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(attackSpeed.isChecked()){
                    attackSpeedChecked = true;
                }else{
                	attackSpeedChecked = false;
                }
                updateItems();
            }
        });

		armorPenetration.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(armorPenetration.isChecked()){
                    armorPenetrationChecked = true;
                }else{
                	armorPenetrationChecked = false;
                }
                updateItems();
            }
        });
		
		criticalStrike.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(criticalStrike.isChecked()){
                    criticalStrikeChecked = true;
                }else{
                	criticalStrikeChecked = false;
                }
                updateItems();
            }
        });
		
		damage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(damage.isChecked()){
                    damageChecked = true;
                }else{
                	damageChecked = false;
                }
                updateItems();
            }
        });
		
		lifeSteal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lifeSteal.isChecked()){
                    lifeStealChecked = true;
                }else{
                	lifeStealChecked = false;
                }
                updateItems();
            }
        });
		
		// Chenckboxes for Magic category
		abilityPower = (CheckBox) this.getView().findViewById(R.id.AbilityPower);
		cooldownReduction = (CheckBox) this.getView().findViewById(R.id.CooldownReduction);
		magicPenetration = (CheckBox) this.getView().findViewById(R.id.MagicPenetration);
		mana = (CheckBox) this.getView().findViewById(R.id.Mana);
		manaRegen = (CheckBox) this.getView().findViewById(R.id.ManaRegen);
		spellVamp = (CheckBox) this.getView().findViewById(R.id.SpellVamp);
		
		abilityPower.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(abilityPower.isChecked()){
                    abilityPowerChecked = true;
                }else{
                	abilityPowerChecked = false;
                }
                updateItems();
            }
        });
		
		cooldownReduction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cooldownReduction.isChecked()){
                    cooldownReductionChecked = true;
                }else{
                	cooldownReductionChecked = false;
                }
                updateItems();
            }
        });
		
		magicPenetration.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(magicPenetration.isChecked()){
                    magicPenetrationChecked = true;
                }else{
                	magicPenetrationChecked = false;
                }
                updateItems();
            }
        });
		
		mana.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mana.isChecked()){
                    manaChecked = true;
                }else{
                	manaChecked = false;
                }
                updateItems();
            }
        });
		
		manaRegen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(manaRegen.isChecked()){
                    manaRegenChecked = true;
                }else{
                	manaRegenChecked = false;
                }
                updateItems();
            }
        });
		
		spellVamp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spellVamp.isChecked()){
                    spellVampChecked = true;
                }else{
                	spellVampChecked = false;
                }
                updateItems();
            }
        });
		
		// Checkboxes for Movement category
		boots = (CheckBox) this.getView().findViewById(R.id.Boots);
		otherMovement = (CheckBox) this.getView().findViewById(R.id.OtherMovement);
		
		boots.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boots.isChecked()){
                    bootsChecked = true;
                }else{
                	bootsChecked = false;
                }
                updateItems();
            }
        });
		
		otherMovement.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otherMovement.isChecked()){
                    otherMovementChecked = true;
                }else{
                	otherMovementChecked = false;
                }
                updateItems();
            }
        });
		
		// Checkboxes for Misc category
		consumable = (CheckBox) this.getView().findViewById(R.id.Consumable);
		goldIncome = (CheckBox) this.getView().findViewById(R.id.GoldIncome);
		visionAndTrinkets = (CheckBox) this.getView().findViewById(R.id.VisionAndTrinkets);
		
		consumable.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(consumable.isChecked()){
                    consumableChecked = true;
                }else{
                	consumableChecked = false;
                }
                updateItems();
            }
        });
		
		goldIncome.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(goldIncome.isChecked()){
                    goldIncomeChecked = true;
                }else{
                	goldIncomeChecked = false;
                }
                updateItems();
            }
        });
		
		visionAndTrinkets.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visionAndTrinkets.isChecked()){
                    visionAndTrinketsChecked = true;
                }else{
                	visionAndTrinketsChecked = false;
                }
                updateItems();
            }
        });
		// Checkboxes for Special category
		active = (CheckBox) this.getView().findViewById(R.id.Active);
		jungleHelper = (CheckBox) this.getView().findViewById(R.id.JungleHelper);
		
		active.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(active.isChecked()){
                    activeChecked = true;
                }else{
                	activeChecked = false;
                }
                updateItems();
            }
        });
		
		jungleHelper.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jungleHelper.isChecked()){
                    jungleHelperChecked = true;
                }else{
                	jungleHelperChecked = false;
                }
                updateItems();
            }
        });
		
		new ItemListAsyncTask().execute();
	}

	private class ItemListAsyncTask extends AsyncTask<Void, String, String[]>
	{
		@Override
		protected void onPreExecute()
		{
			// Display loading indicator?
		}

		@Override
		protected String[] doInBackground(Void... params)
		{			
			itemList = APIData.getItemList();
			allItemTags = new ArrayList<List<String>>();
			for (int i = 0; i< itemList.length; i++){
				try{
					allItemTags.add(i, APIData.getItemByName(itemList[i]).getTags());
				}
				catch (NullPointerException e){
					allItemTags.add(i, null);
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
			updateItems();
		}	

	}
	
	// Update the displayed item field
	public void updateItems(){
		int itemCount = 0;
		String[] tempResult = new String[itemList.length];
		String[] result;
		
		// If one or more checkbox has been selected, apply the filter, or all items are displayed.
		if (armorChecked || healthChecked || healthRegenChecked || magicResistChecked || tenacityChecked
				|| attackSpeedChecked || armorPenetrationChecked || criticalStrikeChecked || damageChecked
				|| lifeStealChecked || abilityPowerChecked || cooldownReductionChecked || magicPenetrationChecked
				|| manaChecked || manaRegenChecked || spellVampChecked || bootsChecked || otherMovementChecked
				|| consumableChecked || goldIncomeChecked || visionAndTrinketsChecked || activeChecked
				|| jungleHelperChecked){
			for (int i = 0; i < itemList.length; i++){
				List<String> itemTags = allItemTags.get(i);
				boolean inserted = false;
				for (int j = 0; (itemTags != null) && (j < itemTags.size()) && (!inserted); j++){
					if ((armorChecked) && (itemTags.get(j) == "Armor")){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((healthChecked) && (itemTags.get(j).equals("Health"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((healthRegenChecked) && (itemTags.get(j).equals("HealthRegen"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((magicResistChecked) && (itemTags.get(j).equals("SpellBlock"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((tenacityChecked) && (itemTags.get(j).equals("Tenacity"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((attackSpeedChecked) && (itemTags.get(j).equals("AttackSpeed"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((armorPenetrationChecked) && (itemTags.get(j).equals("ArmorPenetration"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((criticalStrikeChecked) && (itemTags.get(j).equals("CriticalStrike"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((damageChecked) && (itemTags.get(j).equals("Damage"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((lifeStealChecked) && (itemTags.get(j).equals("LifeSteal"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((abilityPowerChecked) && (itemTags.get(j).equals("AbilityPower"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((cooldownReductionChecked) && (itemTags.get(j).equals("CooldownReduction"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((magicPenetrationChecked) && (itemTags.get(j).equals("MagicPenetration"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((manaChecked) && (itemTags.get(j).equals("Mana"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((manaRegenChecked) && (itemTags.get(j).equals("ManaRegen"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((spellVampChecked) && (itemTags.get(j).equals("SpellVamp"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((bootsChecked) && (itemTags.get(j).equals("Boots"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((otherMovementChecked) && (itemTags.get(j).equals("NonbootsMovement"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((consumableChecked) && (itemTags.get(j).equals("Consumable"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((goldIncomeChecked) && (itemTags.get(j).equals("GoldPer"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((visionAndTrinketsChecked) && 
							((itemTags.get(j).equals("Vision")) || (itemTags.get(j).equals("Trinket")))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((activeChecked) && (itemTags.get(j).equals("Active"))
							&& !((itemTags.get(j).equals("Vision")) || (itemTags.get(j).equals("Trinket")))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
					else if ((jungleHelperChecked) && (itemTags.get(j).equals("OnHit"))){
						tempResult[itemCount] = itemTags.get(j);
						itemCount += 1;
						inserted = true;
					}
				}
			}
			
			result = new String[itemCount];
			for (int i = 0; i < itemCount; i++){
				result[i] = tempResult[i];
			}
		}
		else{
			result = itemList;
		}

		GridLayout mGridView = (GridLayout) this.getView().findViewById(R.id.ItemListGrid);
		mGridView.removeAllViews();
		
		DisplayMetrics dm = getResources().getDisplayMetrics();
		float dpWidth = dm.widthPixels / dm.density;

		Drawable imgsize = getResources().getDrawable(R.drawable.defaultitemsize);
		float dpImgWidth = imgsize.getIntrinsicWidth() / dm.density;

		int columns = (int) ((dpWidth - 130) / (dpImgWidth + 10));
		mGridView.setColumnCount(columns);

		boolean bonetoothonce = false;
		boolean headkhaonce = false;

		for (int i = 0; i < result.length; i++)
		{
			LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
					n, "drawable", this.getActivity().getPackageName()));
			button.setImageDrawable(btnImg);
			LayoutParams params = new LayoutParams((int) (btnImg.getIntrinsicWidth() * 1.2),
					(int) (btnImg.getIntrinsicHeight() * 1.2));
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

	// Popup
	public void showPopup(String name)
	{
		LinearLayout view = (LinearLayout) this.getActivity().findViewById(R.id.itempopup);
		LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layout = inflater.inflate(R.layout.popup_item, view);

		final PopupWindow popup = new PopupWindow(this.getActivity());
		popup.setContentView(layout);
		popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
		popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
		ImageView icon = (ImageView) layout.findViewById(R.id.icon);
		int resID = getResources().getIdentifier(name.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
				"drawable", "com.team4d.lolhelper");
		icon.setImageResource(resID);

		new grabItem(this.getView()).execute(name);

		popup.setOutsideTouchable(true);
		popup.setTouchable(true);
		popup.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
            	popup.dismiss();
                return true;
            }
        });
		popup.setFocusable(true);
		popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
	}

	private class grabItem extends AsyncTask<String, Void, Item>
	{
		private final View mView;

		public grabItem(View v)
		{
			mView = v;
		}
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
			if (mView == null || mView.isShown() == false)
			{
				return;
			}
			TextView nameText = (TextView) layout.findViewById(R.id.name);
			TextView mapsText = (TextView) layout.findViewById(R.id.maps);
			TextView descriptionText = (TextView) layout.findViewById(R.id.description);
			TextView totalgoldText = (TextView) layout.findViewById(R.id.totalgold);
			TextView sellgoldText = (TextView) layout.findViewById(R.id.sellgold);

			// Setting Text for TextViews
			String str = "";
			if (item.getMaps() != null)
			{
				Map<String, Boolean> maps = item.getMaps();
				// Maps: 1 (SR), 10 (TT), 8 (CS), 12 (HA)
				if (!maps.containsKey("1"))
				{
					str = str + "Summoner's Rift, ";
				}
				if (!maps.containsKey("10"))
				{
					str = str + "Twisted Treeline, ";
				}
				if (!maps.containsKey("8"))
				{
					str = str + "Crystal Scar, ";
				}
				if (!maps.containsKey("12"))
				{
					str = str + "Howling Abyss, ";
				}
				str = str.substring(0, str.length() - 2);
			} else
			{
				str = "All";
			}
			// Get rid of last ", "
			nameText.setText(item.getName());
			mapsText.setText("Maps: \n" + str);
			descriptionText.setText("Description: \n" + APIData.parseOutHtml(item.getDescription()));
			totalgoldText.setText("Total Gold: " + item.getGold().getTotal());
			sellgoldText.setText("Sells For: " + item.getGold().getSell());
		}
	}
}
