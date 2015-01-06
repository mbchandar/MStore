package org.zapota.mstore;

import java.io.IOException;

import org.zapota.mstore.helper.BusProvider;
import org.zapota.mstore.helper.CSHTTPClient;
import org.zapota.mstore.helper.LoadCategoryProducts;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class CartActivity extends BaseActivity {

	public CartActivity() {
		super(R.string.app_name);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);	
		BusProvider.getInstance().register(this);
		
		 
		OkHttpClient client = CSHTTPClient.getClient();
		Request request = new Request.Builder().url("http://192.168.1.10/cs/kancart/index.php?method=kancart.shoppingcart.get").build();

		
		try {
			Response response = client.newCall(request).execute();
		
			
			String responses =response.body().string();
			
			Log.d("[SHOPPINGCART]", response.header("token"));
			Log.d("[SHOPPINGCART]", responses);
		} catch (IOException e) {			
			e.printStackTrace();
		}
				
	}
	 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cart, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);	    		
	}
	

	 
}
