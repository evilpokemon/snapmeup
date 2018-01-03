package com.bigsammy.SnapMeUp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SnapMeUpContacts extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){	
		
		super.onCreate(savedInstanceState);
		TextView textview = new TextView(this);
		textview.setText("My Contacts");
		setContentView(textview);
	}

}
