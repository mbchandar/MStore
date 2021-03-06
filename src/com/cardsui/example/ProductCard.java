package com.cardsui.example;

import java.io.IOException;

import org.zapota.mstore.CartActivity;
import org.zapota.mstore.R;
import org.zapota.mstore.helper.CSHTTPClient;
import org.zapota.mstore.util.API;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class ProductCard extends Card {

	private int productId;
	
	public ProductCard(int productId, String title, String description, String image){
		super(title, description, image);
		this.productId = productId;
	}	 
	
	@Override
	public View getCardContent(Context context) {
		final View view = LayoutInflater.from(context).inflate(R.layout.card_product, null);

		
		final String strProductid = String.valueOf(productId);
		((TextView) view.findViewById(R.id.title)).setText(title);
		((TextView) view.findViewById(R.id.description)).setText(description);
		((TextView) view.findViewById(R.id.product_id)).setText(strProductid );
		
		
		
		ImageLoader imageLoader = ImageLoader.getInstance();
		DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
				.showImageForEmptyUri(R.drawable.ic_loading)
				.showImageOnLoading(R.drawable.ic_loading)
				.showImageOnFail(R.drawable.ic_noimage)
						//.displayer(new RoundedBitmapDisplayer(5))
						.resetViewBeforeLoading(true)
						.build();
				
		//initialize image view
		ImageView imageView = ((ImageView) view.findViewById(R.id.product_image));
		Log.d("[IMAGE]", "i "+ image);				
		imageLoader.displayImage(image, imageView, options);
					 
		ImageButton buyNow = ((ImageButton) view.findViewById(R.id.buy_now_button_rose));
		
		buyNow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Context apc = view.getContext().getApplicationContext();
				Intent viewShoppingCartIntent = new Intent(apc, CartActivity.class);					
				
				
				Response response = null;
				OkHttpClient client = CSHTTPClient.getClient();
				Request request = new Request.Builder().url(API.URL + "method=kancart.shoppingcart.add&item_id="+ strProductid+"&qty=1").build();

				try {
					response = client.newCall(request).execute();
				 
					String responses =response.body().string();
					Log.d("[ADDCART]", responses);
				} catch (IOException e) {			
					e.printStackTrace();
				}
				viewShoppingCartIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				apc.startActivity(viewShoppingCartIntent);
				
			}
		});
		
		
		return view;
	}

	@Override
	public boolean convert(View convertCardView) {
		// TODO Auto-generated method stub
		return false;
	}
 
 

}
