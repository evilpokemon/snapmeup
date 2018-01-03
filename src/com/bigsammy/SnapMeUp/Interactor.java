package com.bigsammy.SnapMeUp;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;


import org.ksoap2.transport.*;
import org.ksoap2.*;
import org.ksoap2.serialization.*;
import org.xmlpull.v1.XmlPullParserException;

import com.bigsammy.SnapMeUp.R;
import com.bigsammy.SnapMeUp.Helpers.RuntimeVars;
import com.bigsammy.SnapMeUp.User.User;
//import com.example.android.samplesync.client.NetworkUtilities;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.res.Resources;

//for this class
import android.content.Context;

public class Interactor    { 
private static final String LOGTAG = "Interactor";
private Activity cActivity; 
public boolean isAuthenticationDone = false;
public static String KEY_USERNAME = "username";
public static String KEY_PASSWORD = "password";
public static String KEY_RESULT = "result";


	public Interactor(Activity activitycontext)
	{
		cActivity = activitycontext;
	}

	private static SoapObject Init(String sMethodName)
	{
        
		SoapObject soRequest = new SoapObject(Constants.DOMAIN_HTTP, sMethodName);
        return soRequest;
		
	}
	
	public static String validateCredentials(String sUserName, String sPassword, Resources cResources)
	{
	String sResult="";
	
		//All possible values for testing 
		//sResult = cResources.getString(R.string.server_validation_no_such_account);
		sResult = cResources.getString(R.string.server_validation_valid);
		//sResult = cResources.getString(R.string.server_validation_wrong_password);
		
		//Used until we have connection to server
		return sResult;
	
		/*SoapObject soRequest = Init("validateUser");
		soRequest.addProperty("sUserName", sUserName);
		soRequest.addProperty("sPwd", sPassword);
		
		SoapSerializationEnvelope soeEnv = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soeEnv.dotNet=true;
		soeEnv.implicitTypes=true;
		soeEnv.setAddAdornments(false);
		soeEnv.setOutputSoapObject(soRequest);
		
		
		HttpTransportSE androidHttpTransport = new HttpTransportSE(Address);
		HttpTransportSE.call(params.GetSoapAction(), envelope);
		
		try
		{
			ahtTransp.call(Constants.DOMAIN_HTTP + "validateUser", soeEnv);
		}
		catch(XmlPullParserException xe)
		{
			if(Log.isLoggable(LOGTAG, Log.VERBOSE))
			{
				Log.v(LOGTAG, "XMLPullParser: "+ xe.getMessage());	
			}
		}
		catch(IOException ioe)
		{
			if(Log.isLoggable(LOGTAG, Log.VERBOSE))
			{
				Log.v(LOGTAG, "IOExc: "+ ioe.getMessage());
			}
		}
		
		String sResult="aa"; 
		
		try
		{
			 sResult=(soeEnv.getResponse()).toString();
			 if(sResult.equalsIgnoreCase("true"))
			 {
				 bResult=true;
			 }
			 else
			 {
				 if(Log.isLoggable(LOGTAG, Log.VERBOSE))
				 {
					Log.v(LOGTAG, "Validate User "+ sResult);
				 }
				 bResult=false;
			 }
					 
		}
		catch(SoapFault sfe)
		{
			if(Log.isLoggable(LOGTAG, Log.VERBOSE))
			{
				Log.v(LOGTAG, "SOAPFAULT: "+ sfe.getMessage());
			}
		}
		
		//Log.v(LOGTAG, "A"+sResult+"A"+bResult);
		return bResult;
		*/
	}
	
	public static Bundle createUser(String sEmail, Resources cResources)
	{
	Bundle bResult = new Bundle();
	String sResult="";
	String sUserName = sEmail;
	String sPassword="";
	
		//All possible values for testing 
		//sResult = cResources.getString(R.string.server_create_user_email_exists);
		sResult = cResources.getString(R.string.server_create_user_success);
		
		bResult.putString(KEY_USERNAME, sUserName);
		bResult.putString(KEY_RESULT, sResult);
		bResult.putString(KEY_PASSWORD, sPassword);
		return bResult;
	}
	
	
	public String getData(String sUserName, String sPWD, Resources cResources)
	{
	String sResult = new String("");
		
		
		//Code for while sever is unavail
		sResult = "<user name='bigsammy@mail.ru'>"+
									"<Profiles><Profile profileUri='http://abramkin.com/bigsammy'/></Profiles>" +
									"<Favorites></Favorites>"+
								"</user>";
		//sResult = "http://youtube.com/";
		RuntimeVars oSession = (RuntimeVars) cActivity.getApplication();
		oSession.setUserData(sResult);
		return sResult;
		
		/*SoapObject soRequest = Init("getData");
		soRequest.addProperty("sUserName", sUserName);
		soRequest.addProperty("sPwd", sPWD);
		
		SoapSerializationEnvelope soeEnv = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soeEnv.dotNet=true;
		soeEnv.implicitTypes=true;
		soeEnv.setAddAdornments(false);
		soeEnv.setOutputSoapObject(soRequest);
		
		
		@SuppressWarnings("deprecation")
		AndroidHttpTransport ahtTransp = new AndroidHttpTransport(cResources.getString(R.string.handler_url)); 
		ahtTransp.debug = true;
		
		try
		{
			ahtTransp.call(Constants.DOMAIN_HTTP + "getData", soeEnv);
		}
		catch(XmlPullParserException xe)
		{
			Log.v(LOGTAG, "XMLPullParser: "+ xe.getMessage());
			
			
		}
		catch(IOException ioe)
		{
			Log.v(LOGTAG, "IOExc: "+ ioe.getMessage());
			
			
		}
		
		 
		
		try
		{
			sResult = (soeEnv.getResponse()).toString();
		}
		catch(SoapFault sfe)
		{
			Log.v(LOGTAG, "SOAPFAULT: "+ sfe.getMessage());
		}
		
		if(sResult.equals(""))
		{
			sResult = "something failed in initiator";
			
		}
		Log.v(LOGTAG, "REQUEST:"+ahtTransp.requestDump);
		Log.v(LOGTAG, "RESULT:" +sResult );
		return sResult;*/
	}
	
	public Boolean Authenticate()
	{
		boolean bReturn = true;
		Log.v(LOGTAG, "Authenticate: Entered thread");
		AccountManager amAccounts = AccountManager.get(cActivity);
		
		
		
		Account[] aAccounts = amAccounts.getAccountsByType(Constants.ACCOUNT_TYPE);
		
		AccountManagerFuture<Bundle> amfBundle;
		
		if(aAccounts.length>0)
		{
			amfBundle = amAccounts.getAuthToken(aAccounts[0], Constants.AUTHTOKEN_TYPE, null, cActivity, null, null);
		}
		else
		{
			
			try {
				(amAccounts.addAccount(Constants.ACCOUNT_TYPE, Constants.AUTHTOKEN_TYPE, null, null, cActivity, null, null)).getResult();
			} catch (OperationCanceledException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AuthenticatorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			amfBundle = amAccounts.getAuthToken((amAccounts.getAccountsByType(Constants.ACCOUNT_TYPE))[0], Constants.AUTHTOKEN_TYPE, null, cActivity, null, null);
			
		}
		
		Log.v(LOGTAG, "Authenticate: Started and ended the process it seems, going to get bundle");
		
		Bundle b = null;
		
		try {
			Log.v(LOGTAG, "Authenticate: trying to get bundle");
			b = amfBundle.getResult();
			Log.v(LOGTAG, "Authenticate: got the bundle");
		} catch (OperationCanceledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AuthenticatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(b!=null)
		{
			Log.v(LOGTAG, "Authenticate: b not null");
			Log.v(LOGTAG, "Authenticate: Key authtoken is null " + ((b.getString(AccountManager.KEY_AUTHTOKEN))==null));
			Log.v(LOGTAG, "Authenticate: key intent is null  " + ((b.get(AccountManager.KEY_INTENT))==null));
			
			Iterator<String> bKeys = b.keySet().iterator();
			
			while(bKeys.hasNext())
			{
				Log.v(LOGTAG, "Keys in bundle  " + bKeys.next());
			}
			
			if( b.getString(AccountManager.KEY_AUTHTOKEN)!=null)
			{
				bReturn = true;
			}
			else
			{
				bReturn = false;
			}
		}
		else
		{
			bReturn = false;
			
		}
		
		Log.v(LOGTAG, "Authenticate: result is "+bReturn);
		
		if(bReturn)
		{
			RuntimeVars oSession = (RuntimeVars) cActivity.getApplication();
			oSession.setUserName(b.getString(AccountManager.KEY_ACCOUNT_NAME));
			oSession.setAuthToken(b.getString(AccountManager.KEY_AUTHTOKEN));
			oSession.setUser(
					new User(
							getData(
									b.getString(AccountManager.KEY_ACCOUNT_NAME), 
									b.getString(AccountManager.KEY_AUTHTOKEN), 
									cActivity.getResources())));
		}
		
		
		return new Boolean(bReturn);
	}
	
	
	
	
}
