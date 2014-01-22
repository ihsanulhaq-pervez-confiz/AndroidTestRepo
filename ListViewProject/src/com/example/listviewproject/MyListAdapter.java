package com.example.listviewproject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<ListItem>{

	private ArrayList<ListItem> data;
	private Activity context;
	
	
	public MyListAdapter(Activity context, int resId, ArrayList<ListItem> data)
	{
		super(context, resId, data);
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView; // re-use an existing view, if one is supplied
		if (view == null) // otherwise create a new one
		{
			view = context.getLayoutInflater().inflate(R.layout.row, null);
		}
		
		
		ListViewRowHolder viewHolder = (ListViewRowHolder) (view.getTag() == null ? getViewHolder(view) : view.getTag());
		ListItem item = data.get(position);
		viewHolder.getDescription().setText(item.getDescription());
		viewHolder.getIcon().setBackgroundResource(item.getImageId());
		viewHolder.setData(item);
		return view;
	}

	private ListViewRowHolder getViewHolder(View view)
	{
		ListViewRowHolder viewHolder = new ListViewRowHolder();
		viewHolder.setDescription((TextView) view.findViewById(R.id.text));
		viewHolder.setIcon((ImageView) view.findViewById(R.id.icon));
		viewHolder.setToastButton((Button) view.findViewById(R.id.toast));
		view.setTag(viewHolder);
		
		return viewHolder;
	}
}
