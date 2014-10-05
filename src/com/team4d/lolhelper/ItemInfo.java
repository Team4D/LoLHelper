package com.team4d.lolhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.fourfoureight.lolhelper.R;
import com.team4d.lolhelper.api.APIData;
import com.team4d.lolhelper.api.dto.staticdata.item.Item;
import com.team4d.lolhelper.generalinfo.items;

public class ItemInfo extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_info);

		FrameLayout layout = (FrameLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		Intent intent = getIntent();
		String message = intent.getStringExtra("EXTRA_MESSAGE");
		
		Item item = APIData.getItemByName(message);

		//Set picture
		ImageView icon = (ImageView) findViewById(R.id.icon);
		int resID = getResources().getIdentifier(message.replaceAll("[^a-zA-Z]+", "").toLowerCase(),
				"drawable", getPackageName());
		icon.setImageResource(resID);

/*		String name = items.getName(items.itemsArray[i]);
		String availability = items.getAvailability(items.itemsArray[i]);
		String tier = items.getTier(items.itemsArray[i]);
		String stats = items.getStats(items.itemsArray[i]);
		String passive1 = items.getPassive1(items.itemsArray[i]);
		String passive2 = items.getPassive2(items.itemsArray[i]);
		String passive3 = items.getPassive3(items.itemsArray[i]);
		String passive4 = items.getPassive4(items.itemsArray[i]);
		String passive5 = items.getPassive5(items.itemsArray[i]);
		String menu = items.getMenu(items.itemsArray[i]);
		String itemCost = items.getItemCost(items.itemsArray[i]);
		String sellValue = items.getSellValue(items.itemsArray[i]);
*/
		TextView nameText = (TextView) findViewById(R.id.nameDis);
		TextView availabilityText = (TextView) findViewById(R.id.availabilityDis);
		TextView tierText = (TextView) findViewById(R.id.tierDis);
		TextView statsText = (TextView) findViewById(R.id.statsDis);
		TextView passive1Text = (TextView) findViewById(R.id.passive1Dis);
		TextView passive2Text = (TextView) findViewById(R.id.passive2Dis);
		TextView passive3Text = (TextView) findViewById(R.id.passive3Dis);
		TextView passive4Text = (TextView) findViewById(R.id.passive4Dis);
		TextView passive5Text = (TextView) findViewById(R.id.passive5Dis);
		TextView menuText = (TextView) findViewById(R.id.menuDis);
		TextView itemCostText = (TextView) findViewById(R.id.costDis);
		TextView sellValueText = (TextView) findViewById(R.id.sellDis);

		// Setting Text for TextViews
		//TODO: Figure out other fields
		nameText.setText(item.getName());
		availabilityText.setText("Builds From: \n" + item.getFrom());
		tierText.setText("Consumable: \n" + item.getConsumed());
		statsText.setText("Builds Into: \n" + item.getInto());
		passive1Text.setText(item.getDescription());
//		passive2Text.setText(passive2);
//		passive3Text.setText(passive3);
//		passive4Text.setText(passive4);
//		passive5Text.setText(passive5);
//		menuText.setText("Menu: \n" + menu);
		itemCostText.setText("Cost: \n" + item.getGold().getTotal());
		sellValueText.setText("Sell Value: \n" + item.getGold().getSell());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_info, menu);
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
}
