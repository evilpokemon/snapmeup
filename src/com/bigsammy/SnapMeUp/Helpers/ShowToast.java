package com.bigsammy.SnapMeUp.Helpers;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ShowToast extends Activity {

	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	    Toast.makeText(this, "Only One account allowed per device", Toast.LENGTH_LONG).show();
	    finish();
	    
	}
}
