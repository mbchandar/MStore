package org.zapota.mstore;

import java.io.IOException;

import org.zapota.api.products.Items;
import org.zapota.mstore.helper.BusProvider;
import org.zapota.mstore.helper.CSHTTPClient;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

 
public class LoadShoppingCart extends AsyncTask<String, Void, String> {
	private static final String TAG = "LoadCategoryProducts";
	private final Gson gson = new Gson();
	
	@Override
	protected String doInBackground(String... ulr) {
		Response response = null;
		OkHttpClient client = CSHTTPClient.getClient();
		Request request = new Request.Builder().url(ulr[0]).build();

		try {
			response = client.newCall(request).execute();
			
			return response.body().string();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return null;

	}

	@Override
	protected void onPostExecute(String result) {
		//BusProvider.getInstance().register(this);
		Log.d("[API]", result);
		Items items = gson.fromJson(result,
				Items.class);	
		BusProvider.getInstance().post(items);
		//BusProvider.getInstance().unregister(this);
	}
}
