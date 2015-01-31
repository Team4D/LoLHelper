package com.team4d.lolhelper.fragments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.res.Resources;
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
import android.widget.Button;
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
 * TODO: Implement sorting
 * 
 * @author KaosuRyoko, Su
 */
public class ItemListFragment extends Fragment
{
	View layout; // used for popup

	// For item filter use.
	private CheckBox SummonersRift, TwistedTreeline, HowlingAbyss, CrystalScar;
	private CheckBox armor, health, healthRegen, magicResist, tenacity;
	private CheckBox attackSpeed, armorPenetration, criticalStrike, damage, lifeSteal;
	private CheckBox abilityPower, cooldownReduction, magicPenetration, mana, manaRegen, spellVamp;
	private CheckBox boots, otherMovement;
	private CheckBox consumable, goldIncome, visionAndTrinkets;
	private CheckBox active, onHitEffects;
	
	private Button clear;
	
	protected boolean SummonersRiftChecked = false;
	protected boolean TwistedTreelineChecked = false;
	protected boolean HowlingAbyssChecked = false;
	protected boolean CrystalScarChecked = false;
	
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
	protected boolean onHitEffectsChecked = false;
	
	protected String[] itemList;
	protected int[] itemIDList;
	protected List<List<String>> allItemTags;
	protected List<Map<String, Boolean>> allItemMaps;
	
	
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
		
		new ItemListAsyncTask().execute();
		
		// Checkboxes for Maps
		SummonersRift = (CheckBox) this.getView().findViewById(R.id.SummonersRift);
		TwistedTreeline = (CheckBox) this.getView().findViewById(R.id.TwistedTreeline);
		HowlingAbyss = (CheckBox) this.getView().findViewById(R.id.HowlingAbyss);
		CrystalScar = (CheckBox) this.getView().findViewById(R.id.CrystalScar);
		
		SummonersRift.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SummonersRift.isChecked()){
                    SummonersRiftChecked = true;
                }else{
                	SummonersRiftChecked = false;
                }
                updateItems();
            }
        });
		
		TwistedTreeline.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TwistedTreeline.isChecked()){
                    TwistedTreelineChecked = true;
                }else{
                	TwistedTreelineChecked = false;
                }
                updateItems();
            }
        });
		
		HowlingAbyss.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(HowlingAbyss.isChecked()){
                    HowlingAbyssChecked = true;
                }else{
                	HowlingAbyssChecked = false;
                }
                updateItems();
            }
        });
		
		CrystalScar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CrystalScar.isChecked()){
                    CrystalScarChecked = true;
                }else{
                	CrystalScarChecked = false;
                }
                updateItems();
            }
        });
		
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
		onHitEffects = (CheckBox) this.getView().findViewById(R.id.OnHitEffects);
		
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
		
		onHitEffects.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onHitEffects.isChecked()){
                    onHitEffectsChecked = true;
                }else{
                	onHitEffectsChecked = false;
                }
                updateItems();
            }
        });
		
		// Button Clear
		clear = (Button) this.getView().findViewById(R.id.btnClear);
		clear.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				// Set all checkboxes to uncheck
				SummonersRift.setChecked(false);
				TwistedTreeline.setChecked(false);
				HowlingAbyss.setChecked(false); 
				CrystalScar.setChecked(false);
				
				armor.setChecked(false);
				health.setChecked(false); 
				healthRegen.setChecked(false);
				magicResist.setChecked(false);
				tenacity.setChecked(false);
				
				attackSpeed.setChecked(false);
				armorPenetration.setChecked(false);
				criticalStrike.setChecked(false);
				damage.setChecked(false); 
				lifeSteal.setChecked(false);
				
				abilityPower.setChecked(false);
				cooldownReduction.setChecked(false);
				magicPenetration.setChecked(false);
				mana.setChecked(false);
				manaRegen.setChecked(false);
				spellVamp.setChecked(false);
				
				boots.setChecked(false);
				otherMovement.setChecked(false);
				
				consumable.setChecked(false);
				goldIncome.setChecked(false); 
				visionAndTrinkets.setChecked(false);
				active.setChecked(false);
				onHitEffects.setChecked(false);
				
				// Set all flags to false.
				SummonersRiftChecked = false;
				TwistedTreelineChecked = false;
				HowlingAbyssChecked = false;
				CrystalScarChecked = false;
				
				armorChecked = false;
				healthChecked = false;
				healthRegenChecked = false;
				magicResistChecked = false;
				tenacityChecked = false;
				
				attackSpeedChecked = false;
				armorPenetrationChecked = false;
				criticalStrikeChecked = false;
				damageChecked = false;
				lifeStealChecked = false;
				
				abilityPowerChecked = false;
				cooldownReductionChecked = false;
				magicPenetrationChecked = false;
				manaChecked = false;
				manaRegenChecked = false;
				spellVampChecked = false;
				
				bootsChecked = false;
				otherMovementChecked = false;
				
				consumableChecked = false;
				goldIncomeChecked = false;
				visionAndTrinketsChecked = false;
				
				activeChecked = false;
				onHitEffectsChecked = false;
				
				// Update the display field.
				updateItems();
			}
		});	

	}

	private class ItemListAsyncTask extends AsyncTask<Void, String, int[]>
	{
		@Override
		protected void onPreExecute()
		{
			// Display loading indicator?
		}

		@Override
		protected int[] doInBackground(Void... params)
		{			
			itemList = APIData.getItemList();
			itemIDList = APIData.getItemIDList();		
			sortItemList();
			
			allItemTags = new ArrayList<List<String>>();
			allItemMaps = new ArrayList<Map<String, Boolean>>();
			
			for (int i = 0; i < itemIDList.length; i++){
				try{
					allItemTags.add(i, APIData.getItemByID(itemIDList[i]).getTags());
				}
				catch (NullPointerException e){
					allItemTags.add(i, null);
				}
				
				try{
					allItemMaps.add(i, APIData.getItemByID(itemIDList[i]).getMaps());
				}
				catch (NullPointerException e){
					allItemMaps.add(i, null);
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
		protected void onPostExecute(int[] result)
		{
			updateItems();
		}	

	}
	
	// Update the displayed item field
	public void updateItems(){
		int itemCount = 0;
		int[] tempResult = new int[itemIDList.length];
		int[] result;
		
		// If one or more checkbox has been selected, apply the filter, or all items are displayed.
		if (armorChecked || healthChecked || healthRegenChecked || magicResistChecked || tenacityChecked
				|| attackSpeedChecked || armorPenetrationChecked || criticalStrikeChecked || damageChecked
				|| lifeStealChecked || abilityPowerChecked || cooldownReductionChecked || magicPenetrationChecked
				|| manaChecked || manaRegenChecked || spellVampChecked || bootsChecked || otherMovementChecked
				|| consumableChecked || goldIncomeChecked || visionAndTrinketsChecked || activeChecked
				|| onHitEffectsChecked || SummonersRiftChecked || TwistedTreelineChecked || HowlingAbyssChecked
				|| CrystalScarChecked){
			for (int i = 0; i < itemIDList.length; i++){
				List<String> itemTags = allItemTags.get(i);
				Map<String, Boolean> itemMaps = allItemMaps.get(i);
				
				boolean qualified = false;
				if (itemTags != null){
					qualified = true;
					
					if ((itemMaps != null) && (SummonersRiftChecked) && 
							((itemMaps.containsKey("1")) || (itemMaps.containsKey("2")))){
						qualified = false;
					}
					else if ((itemMaps != null) && (TwistedTreelineChecked) &&
							((itemMaps.containsKey("4")) || (itemMaps.containsKey("10")))){
						qualified = false;
					}
					else if ((itemMaps != null) && (HowlingAbyssChecked) && (itemMaps.containsKey("12"))){
						qualified = false;
					}
					else if ((itemMaps != null) && (CrystalScarChecked) && (itemMaps.containsKey("8"))){
						qualified = false;
					}
					else if ((armorChecked) && !(itemTags.contains("Armor"))){
						qualified = false;
					}
					else if ((healthChecked) && !(itemTags.contains("Health"))){
						qualified = false;
					}
					else if ((healthRegenChecked) && !(itemTags.contains("HealthRegen"))){
						qualified = false;
					}
					else if ((magicResistChecked) && !(itemTags.contains("SpellBlock"))){
						qualified = false;
					}
					else if ((tenacityChecked) && !(itemTags.contains("Tenacity"))){
						qualified = false;
					}
					else if ((attackSpeedChecked) && !(itemTags.contains("AttackSpeed"))){
						qualified = false;
					}
					else if ((armorPenetrationChecked) && !(itemTags.contains("ArmorPenetration"))){
						qualified = false;
					}
					else if ((criticalStrikeChecked) && !(itemTags.contains("CriticalStrike"))){
						qualified = false;
					}
					else if ((damageChecked) && !(itemTags.contains("Damage"))){
						qualified = false;
					}
					else if ((lifeStealChecked) && !(itemTags.contains("LifeSteal"))){
						qualified = false;
					}
					else if ((abilityPowerChecked) && !(itemTags.contains("SpellDamage"))){
						qualified = false;
					}
					else if ((cooldownReductionChecked) && !(itemTags.contains("CooldownReduction"))){
						qualified = false;
					}
					else if ((magicPenetrationChecked) && !(itemTags.contains("MagicPenetration"))){
						qualified = false;
					}
					else if ((manaChecked) && !(itemTags.contains("Mana"))){
						qualified = false;
					}
					else if ((manaRegenChecked) && !(itemTags.contains("ManaRegen"))){
						qualified = false;
					}
					else if ((spellVampChecked) && !(itemTags.contains("SpellVamp"))){
						qualified = false;
					}
					else if ((bootsChecked) && !(itemTags.contains("Boots"))){
						qualified = false;
					}
					else if ((otherMovementChecked) && !(itemTags.contains("NonbootsMovement"))){
						qualified = false;
					}
					else if ((consumableChecked) && !(itemTags.contains("Consumable"))){
						qualified = false;
					}
					else if ((goldIncomeChecked) && !(itemTags.contains("GoldPer"))){
						qualified = false;
					}
					else if ((visionAndTrinketsChecked) && 
							!(itemTags.contains("Vision")) && !(itemTags.contains("Trinket"))){
						qualified = false;
					}
					else if ((activeChecked) && (!(itemTags.contains("Active"))
							|| (itemTags.contains("Vision")) || (itemTags.contains("Trinket")))){
						qualified = false;
					}
					else if ((onHitEffectsChecked) && !(itemTags.contains("OnHit"))){
						qualified = false;
					}
				}
				if (qualified){
					tempResult[itemCount] = i;
					itemCount += 1;					
				}
			}
			
			result = new int[itemCount];
			for (int i = 0; i < itemCount; i++){
				result[i] = tempResult[i];
			}
		}
		else{
			result = new int[itemList.length];
			for (int i = 0; i < result.length; i++){
				result[i] = i;
			}
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
			String n = itemList[result[i]].replaceAll("[^a-zA-Z0-9]+", "").toLowerCase().replaceAll("showdown", "");
			// Workaround for now, all different shoes with the same enchantment share the same name. Will need
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
			try{
				Drawable btnImg = getResources().getDrawable(getResources().getIdentifier(
					n, "drawable", this.getActivity().getPackageName()));
				button.setImageDrawable(btnImg);
			}
			catch(Resources.NotFoundException e){
				button.setImageResource(R.drawable.questionmark);
			}
			LayoutParams params = new LayoutParams((int) (120 * 1.2), (int) (120 * 1.2));
			button.setLayoutParams(params);
			button.setTag(result[i]);
			button.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					showPopup((Integer)v.getTag());
				}
			});
			mGridView.addView(button);
		}
	}
	
	public void sortItemList(){
		for (int i = 0; i < itemList.length; i++){
			itemList[i] += new Integer(itemIDList[i]).toString();
		}
		Arrays.sort(itemList);
		for (int i = 0; i < itemIDList.length; i++){	// All IDs are 4-digit number.
			itemIDList[i] = Integer.parseInt(itemList[i].substring(itemList[i].length() - 4));
			itemList[i] = itemList[i].substring(0, itemList[i].length() - 4);
		}
	}

	// Popup
	public void showPopup(int index)
	{
		LinearLayout view = (LinearLayout) this.getActivity().findViewById(R.id.itempopup);
		LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layout = inflater.inflate(R.layout.popup_item, view);

		final PopupWindow popup = new PopupWindow(this.getActivity());
		popup.setContentView(layout);
		popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
		popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
		ImageView icon = (ImageView) layout.findViewById(R.id.icon);
		String itemName = itemList[index].replaceAll("showdown", "").replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
		if (itemName.endsWith("showdown")){	// get rid of "showdown"
			itemName = itemName.substring(0, itemName.length() - 8);
		}
		int resID = getResources().getIdentifier(itemName, "drawable", "com.team4d.lolhelper");
		icon.setImageResource(resID);

		new grabItem(this.getView()).execute(itemIDList[index]);

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

	private class grabItem extends AsyncTask<Integer, Void, Item>
	{
		private final View mView;

		public grabItem(View v)
		{
			mView = v;
		}
		@Override
		protected Item doInBackground(Integer... id)
		{
			Item c = APIData.getItemByID(id[0]);
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
