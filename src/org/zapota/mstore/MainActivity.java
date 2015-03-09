package org.zapota.mstore;


import java.io.IOException;

import org.zapota.api.products.Item;
import org.zapota.api.products.Items;
import com.cardsui.example.ProductCard;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends BaseActivity {

	private final Handler handler = new Handler();

	private CardUI mCardView;

	private final OkHttpClient client = new OkHttpClient();

	private final Gson gson = new Gson();
	
	public MainActivity() {
		super(R.string.app_name);
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
	    setContentView(R.layout.activity_main);
	    
	   
		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new SampleListFragment()).commit();
	    
	 // init CardView
	 		mCardView = (CardUI) findViewById(R.id.cardsview);
	 		mCardView.setSwipeable(false);
	    
	 		CardStack stack2 = new CardStack();
			stack2.setTitle(getResources().getString(R.string.latest));
			mCardView.addStack(stack2);

			// add AndroidViews Cards
			//getResources().getString(R.string.latest)
			
			
			 	
			Request request = new Request.Builder()
			.url("http://192.168.1.10/cs/kancart/index.php?method=kancart.items.get&cid=15")
			.build();
				
			Response response;
			try {
				response = client.newCall(request).execute();
				
				Items items = gson.fromJson(response.body().string(),
						Items.class);		
				
				
				for (Item item : items.getInfo().getItems()) {
					ProductCard pc = new ProductCard(Integer.parseInt(item.getItemId()), item.getItemTitle(), item.getPrices().getBasePrice().toString() , item.getThumbnailPicUrl());
					
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
							
				//mCardView.addCard(new ProductCard("Time","Stephen Hawkings Time" , "http://cdn.chennaishopping.com/images/175x175/kaalam-stephen-hawkings.jpg"));
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//Log.d("ANSWER", response.body().string());

			
			//mCardView.addCard(new MyCard("Get the CardsUI view"));
			//mCardView.addCardToLastStack(new MyCard("for Android at"));
			//MyCard androidViewsCard = new MyCard("www.androidviews.net");
			
			/*
			androidViewsCard.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("http://www.androidviews.net/"));
					startActivity(intent);

				}
			});
						
			*/

			// draw cards
			mCardView.refresh();	    		
	}

   

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);	    		
	}
	
	 

	public void switchContent(Fragment fragment) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.llMain, fragment).commit();
		getSlidingMenu().showContent();
	}
	
	
	 
}
