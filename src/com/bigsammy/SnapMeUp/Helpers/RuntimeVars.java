/**
 * 
 */
package com.bigsammy.SnapMeUp.Helpers;

import com.bigsammy.SnapMeUp.User.User;

import android.app.Application;

/**
 * @author anton_abramkin
 *
 */
public class RuntimeVars extends Application {
private String sUserData; 
private String sUserName;
private String sAuthToken;
private User uCurrentUser;

	/**
	 * 
	 */
	public String getUserData() {
		return sUserData;
	}
	
	public String getUserName()
	{
		return sUserName;
	}
	
	public String getAuthToken()
	{
		return sAuthToken;
	}
	
	public User getUser()
	{
		return uCurrentUser;
	}
	
	public void setUserData(String UserData)
	{
		sUserData = UserData;
	}
	
	public void setUserName(String UserName)
	{
		sUserName = UserName;
	}
	
	
	
	public void setAuthToken(String AuthToken)
	{
		sAuthToken = AuthToken;
	}

	public void setUser(User userparam)
	{
		uCurrentUser = userparam;
	}
	
}
