package com.bigsammy.SnapMeUp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SnapMeUpMyInfo extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textview = new TextView(this);
		textview.setText("My Info");
		setContentView(textview);
	}
	
}
