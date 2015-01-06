package org.zapota.mstore;

import org.zapota.api.products.Item;
import org.zapota.api.products.Items;
import org.zapota.mstore.helper.BusProvider;
import org.zapota.mstore.helper.LoadCategoryProducts;

import com.cardsui.example.ProductCard;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.otto.Subscribe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class NewArrivalsFragment extends Fragment {
	  private String category_name;
	    
	    private CardUI mCardView;
	    
		private final OkHttpClient client = new OkHttpClient();
		
		public View view;
	
		public View productview;
		// Album id
	    private String category_id; 
	    
	    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_newarrivals,container, false);		 
		return view;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Get album id
        Intent i = getActivity().getIntent();
        category_id = i.getStringExtra("category_id");
        category_name = i.getStringExtra("category_name");
        
		BusProvider.getInstance().register(this);				
		new LoadCategoryProducts().execute("http://192.168.1.10/cs/kancart/index.php?method=kancart.items.get&cid="+category_id);
		
	}
	
	public void onDestroy() {
		super.onDestroy();
		BusProvider.getInstance().unregister(this);	
	};

 
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	@Subscribe
	public void dataCategoryProducts(Items items) {	
			
		// init CardView
 		mCardView = (CardUI) view.findViewById(R.id.cardsview); 		 
 		mCardView.setSwipeable(false);
    
 		CardStack stack2 = new CardStack();
		stack2.setTitle(getResources().getString(R.string.latest));
		mCardView.addStack(stack2);

		Response response;
	//	Items items = gson.fromJson(output,				Items.class);					
		
		for (Item item : items.getInfo().getItems()) {
			ProductCard pc = new ProductCard(Integer.parseInt(item.getItemId()),item.getItemTitle(), item.getPrices().getBasePrice().toString() , item.getThumbnailPicUrl());			
			
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
}
