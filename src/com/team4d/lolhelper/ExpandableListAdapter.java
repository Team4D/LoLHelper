package com.team4d.lolhelper;

// Code from http://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/

import java.util.HashMap;
import java.util.List;

import com.fourfoureight.lolhelper.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter
{

	private final int _skin;
	private final Context _context;
	private final List<String> _listDataHeader; // header titles
	// child data in format of header title, child title
	private final HashMap<String, List<String>> _listDataChild;

	public ExpandableListAdapter(Context context, List<String> listDataHeader,
			HashMap<String, List<String>> listChildData, int skin)
	{
		this._context = context;
		this._listDataHeader = listDataHeader;
		this._listDataChild = listChildData;
		this._skin = skin;
	}

	@Override
	public Object getChild(int groupPosition, int childPosititon)
	{
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.get(childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition)
	{
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent)
	{

		final String childText = (String) getChild(groupPosition, childPosition);

		if (convertView == null)
		{
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.main_list_item, null);
		}

		TextView txtListChild = (TextView) convertView
				.findViewById(R.id.lblListItem);

		txtListChild.setText(childText);

		// Set skin of app
		if (_skin == 1)
		{
			txtListChild.setBackgroundResource(R.drawable.button3);
		}
		if (_skin == 2)
		{
			txtListChild.setBackgroundResource(R.drawable.button2);
			txtListChild.setTextColor(Color.parseColor("#000000"));
		}

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition)
	{
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.size();
	}

	@Override
	public Object getGroup(int groupPosition)
	{
		return this._listDataHeader.get(groupPosition);
	}

	@Override
	public int getGroupCount()
	{
		return this._listDataHeader.size();
	}

	@Override
	public long getGroupId(int groupPosition)
	{
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent)
	{
		String headerTitle = (String) getGroup(groupPosition);
		if (convertView == null)
		{
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.main_drop, null);
		}

		TextView lblListHeader = (TextView) convertView
				.findViewById(R.id.lblListHeader);

		if (_skin == 1)
		{
			lblListHeader.setBackgroundResource(R.drawable.button);
		}
		if (_skin == 2)
		{
			lblListHeader.setBackgroundResource(R.drawable.button7);
		}

		lblListHeader.setTypeface(null, Typeface.BOLD);
		lblListHeader.setText(headerTitle);

		return convertView;
	}

	@Override
	public boolean hasStableIds()
	{
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition)
	{
		return true;
	}
}