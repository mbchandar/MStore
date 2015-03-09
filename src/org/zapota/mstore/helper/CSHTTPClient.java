package org.zapota.mstore.helper;

import java.net.CookieManager;
import java.net.CookiePolicy;




import com.squareup.okhttp.OkHttpClient;

public class CSHTTPClient {
	static private OkHttpClient httpclient = null;

	public static OkHttpClient getClient() {
		
	    if( httpclient == null){
	    	
	    	OkHttpClient client = new OkHttpClient();
	    	CookieManager cookieManager = new CookieManager();
	    	cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
	    	client.setCookieHandler(cookieManager);	    		    		    	 	    		    		    	
	    	CSHTTPClient.setHttpclient(client);
	    	
	    }
	    return httpclient;
	}

	public static void setHttpclient(OkHttpClient httpclient) {
	    CSHTTPClient.httpclient = httpclient;
	}
}
