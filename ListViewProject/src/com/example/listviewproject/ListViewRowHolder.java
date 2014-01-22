package com.example.listviewproject;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewRowHolder implements OnClickListener{

	ImageView icon;
	TextView description;
	Button toastButton;
	ListItem data;
	
	public ListItem getData() {
		return data;
	}

	public void setData(ListItem data) {
		this.data = data;
	}

	public ImageView getIcon() {
		return icon;
	}

	public void setIcon(ImageView icon) {
		this.icon = icon;
		this.icon.setOnClickListener(this);
	}

	public TextView getDescription() {
		return description;
	}

	public void setDescription(TextView description) {
		this.description = description;
	}

	public Button getToastButton() {
		return toastButton;
	}

	public void setToastButton(Button toastButton) {
		this.toastButton = toastButton;
		this.toastButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.icon:
			showDialog();
			break;

		case R.id.toast:
			Toast t = Toast.makeText(MainActivity.getActivity(), data.getDescription(), 1000);
			t.show();
			break;
		default:
			break;
		}
		
	}

	private void showDialog() {
		final Dialog dialog = new Dialog(MainActivity.getActivity());
		dialog.setContentView(R.layout.customdialog);
		dialog.setTitle(data.getDescription());


		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(data.getImageId());

		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		dialog.show();
	}
	
}
