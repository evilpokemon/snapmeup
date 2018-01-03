package com.bigsammy.SnapMeUp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;

 
public class SnapMeUpQRActivity extends Activity {
    /** Called when the activity is first created. */
 
	
  	@Override
    
    public void onCreate(Bundle savedInstanceState) {
  	String sResult = new String("error");
    
    	super.onCreate(savedInstanceState);
	 
    	
    	Interactor oi = new Interactor(this);
    	
    	//Commented until server is avail
    	Log.v("QRACTIVITY", "trying to authenticate");


    	//sResult = oi.getData("bigsammy@mail.ru", "sammybig", this.getResources());
    	sResult="mailto:anton_abramkin@hotmail.com";
    	Log.v("QRACTIVITY", "got the result:"+sResult);

    	int h = 300;
    	int w = 300;

    	ImageView imageview = new ImageView(this);
		imageview.setImageBitmap(GenerateCode.encodeQR(w, h, sResult));
		setContentView(imageview);
		Log.v("QRACTIVITY", "displayed the result");
    	
    	
    	
    	
    }
    
  	private void showCode()
  	{
  	
  		
  	}
  	
  	
}

