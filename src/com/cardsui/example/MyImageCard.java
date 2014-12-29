package com.cardsui.example;

import org.zapota.mstore.R;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fima.cardsui.objects.RecyclableCard;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MyImageCard extends RecyclableCard {

	public MyImageCard(String title, String description, String image){
		super(title, description, image);
	}

	@Override
	protected int getCardLayoutId() {
		return R.layout.card_picture;
	}

	@Override
	protected void applyTo(View convertView) {
		Log.d("[IMAGE]", "i "+ title);	
		((TextView) convertView.findViewById(R.id.title)).setText(title);
		((TextView) convertView.findViewById(R.id.description)).setText(description);
		//((ImageView) convertView.findViewById(R.id.imageView1)).setImageResource(image);		
		
		ImageLoader imageLoader = ImageLoader.getInstance();
		DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
						.resetViewBeforeLoading(true)
						.build();
				
		//initialize image view
		ImageView imageView = ((ImageView) convertView.findViewById(R.id.imageView1));
		Log.d("[IMAGE]", "i "+ image);				
		//download and display image from url
		imageLoader.displayImage(image, imageView, options);
		
	}
	
 
}
