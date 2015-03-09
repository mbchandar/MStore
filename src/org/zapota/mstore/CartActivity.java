package org.zapota.mstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.zapota.api.products.Item;
import org.zapota.api.products.Items;
import org.zapota.api.shoppingcart.CartItem;
import org.zapota.api.shoppingcart.ShoppingCart;
import org.zapota.mstore.helper.BusProvider;
import org.zapota.mstore.helper.CSHTTPClient;

import com.cardsui.example.ProductCard;
import com.cardsui.example.ProductCart;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.otto.Subscribe;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CartActivity extends BaseActivity {

	private ListView cartProductList;
	private ArrayAdapter<CartItem> adapter;
	private ArrayList<String> arrayList;	
	private CardUI mCardView;
 
	ViewGroup container;
	
	public CartActivity() {
		super(R.string.app_name);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		setContentView(R.layout.activity_cart);	
		BusProvider.getInstance().register(this);				 
		new LoadCartItemsTask().execute("http://192.168.1.4/cs/kancart/index.php?method=kancart.shoppingcart.get");		
				
	}
	
	 private class LoadCartItemsTask extends AsyncTask<String, Void, String> {
		 private final Gson gson = new Gson(); 
		 
	    @Override
	    protected String doInBackground(String... urls) {
			Response response = null;
			OkHttpClient client = CSHTTPClient.getClient();
			Request request = new Request.Builder().url(urls[0]).build();
			try {
				response = client.newCall(request).execute();
				//Log.d("[SHOPPINGCART]", response.body().string());
				return response.body().string();
			} catch (IOException e) {			
				e.printStackTrace();
			}
			return null;
	      
	    }

	    @Override
	    protected void onPostExecute(String result) {		    	
			Log.d("[CARTAPI]", result);			
			ShoppingCart shoppingCart = gson.fromJson(result,ShoppingCart.class);		
			BusProvider.getInstance().post(shoppingCart);			 
	    }
	  }

	 
	@Subscribe
	public void dataShoppingCart(ShoppingCart shoppingCart) {	
	 			
		// init CardView
 		mCardView = (CardUI) findViewById(R.id.cartProductListView); 		
 		mCardView.setSwipeable(false);
 		

 		CardStack stack2 = new CardStack();
		stack2.setTitle(getResources().getString(R.string.latest));
		mCardView.addStack(stack2);

		for (CartItem item : shoppingCart.getInfo().getCartItems()) {
									
			ProductCart pc = new ProductCart(item.getItemId(),item.getItemTitle(), item.getItemPrice().toString() , item.getThumbnailPicUrl());			
						
			final String item_url = item.getItemUrl();
			pc.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(item_url));
					startActivity(intent);
				}
			});			 			 
			
			mCardView.addCard(pc);
		}
		
		mCardView.refresh();				
			
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
