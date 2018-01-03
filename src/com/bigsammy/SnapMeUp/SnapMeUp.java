package com.bigsammy.SnapMeUp;




import com.bigsammy.SnapMeUp.Helpers.RuntimeVars;

import android.app.ProgressDialog;
import android.app.TabActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import android.content.res.Resources;

//Authentication



public class SnapMeUp extends TabActivity {
public static String sLogTag="ONSTART";
ProgressDialog pdAuthenticating;
TabHost tabHost;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    
		    
		    Resources res = getResources(); // Resource object to get Drawables
		    tabHost = getTabHost();  // The activity TabHost
		    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
		    Intent intent;  // Reusable Intent for each tab
		    // Do the same for the other tabs
		    
		    intent = new Intent().setClass(this, SnapMeUpMyInfo.class);
		    spec = tabHost.newTabSpec("myinfo").setIndicator("My Info",
		                      res.getDrawable(R.drawable.ic_myinfo))
		                  .setContent(intent);
		    tabHost.addTab(spec);
		    
		    // Create an Intent to launch an Activity for the tab (to be reused)
		    intent = new Intent().setClass(this, SnapMeUpContacts.class);
		    spec = tabHost.newTabSpec("contacts").setIndicator("My Contacts",
		                      res.getDrawable(R.drawable.ic_contacts))
		                  .setContent(intent);
		    tabHost.addTab(spec);
	
		    
	
		    intent = new Intent().setClass(this, SnapMeUpQRActivity.class);
		    spec = tabHost.newTabSpec("qr").setIndicator("My QR",
		                      res.getDrawable(R.drawable.ic_qr))
		                  .setContent(intent);
		    tabHost.addTab(spec);
	
		    pdAuthenticating = ProgressDialog.show(getCurrentActivity(), "Snap Me Up", "Authenticating");
		    new Authenticate().execute("");
		    
		    
		    
	}
	
	private void showRelevantTab()
	{
		
		//TODO: detect what was the last tab user had open when closing the app as well as some initial logic
	  
	   if((((RuntimeVars)this.getApplication()).getUser()).isNewUser())
	   {
		   tabHost.setCurrentTab(0);
	   }
	   else
	   {
		   tabHost.setCurrentTab(2);
	   }
	}
	
	private void endApp()
	{
		this.finish();
	}
	
	private class Authenticate extends AsyncTask<String, Void, Boolean>
	{

		@Override
		protected Boolean doInBackground(String... params) {
		boolean bResult = true;
			Interactor oi = new Interactor(getCurrentActivity());
			
			
			bResult = oi.Authenticate();
			
			return bResult;
			
		}
		
		protected void onPostExecute(Boolean bResult)
		{
			
			pdAuthenticating.dismiss();
			
			if(bResult)
			{
				showRelevantTab();
			}
			else
			{
				endApp();
			}
			
		}
	}
	
}
