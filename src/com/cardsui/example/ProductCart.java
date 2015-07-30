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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.fima.cardsui.views.CardUI;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class ProductCart extends Card {

	private int productId;
	
	public ProductCart(int productId, String title, String description, String image){
		super(title, description, image);
		this.productId = productId;
	}	 
	
	@Override
	public View getCardContent(Context context) {
		final View view = LayoutInflater.from(context).inflate(R.layout.cart_product, null);

		
		final String strProductid = String.valueOf(productId);
		((TextView) view.findViewById(R.id.title)).setText(title);		
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
					 
		Button btnCartRemove = ((Button) view.findViewById(R.id.btn_cart_remove));
		
		btnCartRemove.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
								
			
				
				Response response = null;
				OkHttpClient client = CSHTTPClient.getClient();
				Request request = new Request.Builder().url(API.URL + "method=kancart.shoppingcart.remove&cart_item_id="+ strProductid).build();

				try {
					response = client.newCall(request).execute();				 
					String responses = response.body().string();
					Log.d("[REMOVECART]", responses);
																			 
				} catch (IOException e) {			
					e.printStackTrace();
				}
				
				//viewShoppingCartIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				//apc.startActivity(viewShoppingCartIntent);
				
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
