/**
 * 
 */
package com.bigsammy.SnapMeUp.User;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.util.Log;

/**
 * @author anton_abramkin
 *
 */
public class User {
public Profile[] Profiles;
public Favorite[] Favorites;
public boolean bProfilesEmpty, bFavoritesEmpty;
public String sProfileUri;

	/**
	 * 
	 */
	public User(String xmlUserData) {
	
		try
		{
			//Parse data
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder	db = dbf.newDocumentBuilder();
			
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlUserData));
			
			Document dUserData = db.parse(is);
			
			Log.v("User", xmlUserData);
			
			NodeList nlProfiles = ((dUserData.getElementsByTagName("Profiles")).item(0)).getChildNodes();
			NodeList nlFavorites = ((dUserData.getElementsByTagName("Favorites")).item(0)).getChildNodes();
			
			sProfileUri = (dUserData.getDocumentElement()).getAttribute("profileUri");
			
			if(nlProfiles.getLength()>0)
			{
				bProfilesEmpty = false;
				for(int i=0; i<nlProfiles.getLength(); i++)
				{}
			}
			else
			{
				bProfilesEmpty = true;
			}
			
			if(nlFavorites.getLength()>0)
			{
				bFavoritesEmpty = false;
				for(int i=0; i<nlFavorites.getLength(); i++)
				{}
			}
			else
			{
				bFavoritesEmpty = true;
			}
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isNewUser()
	{
	boolean bResult;
		
		bResult = (bProfilesEmpty && bFavoritesEmpty);
	
		return bResult;
	}
	
	public void addUser()
	{
		
	}
	
	public void addProfile()
	{
		
	}

}
