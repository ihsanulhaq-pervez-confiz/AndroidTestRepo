package com.example.listviewproject;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listview;
	private MyListAdapter adapter;
	private static MainActivity activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		activity = this;
		
		ArrayList<ListItem> data = new ArrayList<ListItem>(5);
		data.add(new ListItem("Google chrome", R.drawable.chromeicon));
		data.add(new ListItem("Facebook", R.drawable.fbicon));
		data.add(new ListItem("Mozilla firefox", R.drawable.firefoxicon));
		data.add(new ListItem("Gmail", R.drawable.gmailicon));
		data.add(new ListItem("Internet Explorer", R.drawable.ieicon));
		data.add(new ListItem("uTorrent", R.drawable.utorrenticon));
		data.add(new ListItem("VLC media player", R.drawable.vlcicon));
		data.add(new ListItem("Adobe acrobat", R.drawable.adobe));
		data.add(new ListItem("Skype", R.drawable.skype));
		data.add(new ListItem("Opera", R.drawable.opera));
		
		adapter = new MyListAdapter(this, R.layout.row, data);
		listview = (ListView)findViewById(R.id.listview);		
		listview.setAdapter(adapter);
	}
	
	public static Activity getActivity()
	{
		return activity;
	}
}
