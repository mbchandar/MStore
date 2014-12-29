package org.zapota.mstore;


import org.zapota.mstore.util.SuperAwesomeCardFragment;

import com.astuetz.PagerSlidingTabStrip;
import com.cardsui.example.MyCard;
import com.cardsui.example.MyImageCard;
import com.cardsui.example.MyPlayCard;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends BaseActivity {

	private final Handler handler = new Handler();

	private PagerSlidingTabStrip tabs;
	private Drawable oldBackground = null;
	private int currentColor = 0xFF666666;
	
	private CardUI mCardView;

	private Fragment mContent;
	
	public MainActivity() {
		super(R.string.app_name);
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
	    setContentView(R.layout.activity_main);
	    
	    if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");

		if (mContent == null)
			mContent = new Home();

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
			mCardView.addCard(new MyImageCard("மகாபாரதம்","ராஜாஜி எழுதிய மகாபாரதம்" , "http://cdn.chennaishopping.com/images/175x175/mahabaratham-rajaji.jpg"));			
			mCardView.addCardToLastStack(new MyImageCard("Time","Stephen Hawkings Time" , "http://cdn.chennaishopping.com/images/175x175/kaalam-stephen-hawkings.jpg"));
			
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
			androidViewsCard.setOnLongClickListener(new OnLongClickListener() {    		
	    		
				public boolean onLongClick(View v) {
					Toast.makeText(v.getContext(), "This is a long click", Toast.LENGTH_SHORT).show();
					return true;
				}
			
			});
			
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://www.androidviews.net/"));

			mCardView.addCardToLastStack(androidViewsCard);
*/
			
			
			CardStack stackPlay = new CardStack();
			stackPlay.setTitle("GOOGLE PLAY CARDS");
			mCardView.addStack(stackPlay);

			// add one card, and then add another one to the last stack.
			mCardView.addCard(new MyCard("Google Play Cards"));
			mCardView.addCardToLastStack(new MyCard("By Androguide & GadgetCheck"));

			mCardView.addCardToLastStack(new MyPlayCard("Google Play",
					"This card mimics the new Google play cards look", "#33b6ea",
					"#33b6ea", true, false));

			mCardView
					.addCardToLastStack(new MyPlayCard(
							"Menu Overflow",
							"The PlayCards allow you to easily set a menu overflow on your card.\nYou can also declare the left stripe's color in a String, like \"#33B5E5\" for the holo blue color, same for the title color.",
							"#e00707", "#e00707", false, true));

			// add one card
			mCardView
					.addCard(new MyPlayCard(
							"Different Colors for Title & Stripe",
							"You can set any color for the title and any other color for the left stripe",
							"#f2a400", "#9d36d0", false, false));

			 

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
	
	
	private void changeColor(int newColor) {

		tabs.setIndicatorColor(newColor);

		// change ActionBar color just if an ActionBar is available
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

			Drawable colorDrawable = new ColorDrawable(newColor);
			Drawable bottomDrawable = getResources().getDrawable(R.drawable.actionbar_bottom);
			LayerDrawable ld = new LayerDrawable(new Drawable[] { colorDrawable, bottomDrawable });

			if (oldBackground == null) {

				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
					ld.setCallback(drawableCallback);
				} else {
					getActionBar().setBackgroundDrawable(ld);
				}

			} else {

				TransitionDrawable td = new TransitionDrawable(new Drawable[] { oldBackground, ld });

				// workaround for broken ActionBarContainer drawable handling on
				// pre-API 17 builds
				// https://github.com/android/platform_frameworks_base/commit/a7cc06d82e45918c37429a59b14545c6a57db4e4
				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
					td.setCallback(drawableCallback);
				} else {
					getActionBar().setBackgroundDrawable(td);
				}

				td.startTransition(200);

			}

			oldBackground = ld;

			// http://stackoverflow.com/questions/11002691/actionbar-setbackgrounddrawable-nulling-background-from-thread-handler
			getActionBar().setDisplayShowTitleEnabled(false);
			getActionBar().setDisplayShowTitleEnabled(true);

		}

		currentColor = newColor;

	}

	public void onColorClicked(View v) {

		int color = Color.parseColor(v.getTag().toString());
		changeColor(color);

	}
	

	public void switchContent(Fragment fragment) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.llMain, fragment).commit();
		getSlidingMenu().showContent();
	}
	
	private Drawable.Callback drawableCallback = new Drawable.Callback() {
		@Override
		public void invalidateDrawable(Drawable who) {
			getActionBar().setBackgroundDrawable(who);
		}

		@Override
		public void scheduleDrawable(Drawable who, Runnable what, long when) {
			handler.postAtTime(what, when);
		}

		@Override
		public void unscheduleDrawable(Drawable who, Runnable what) {
			handler.removeCallbacks(what);
		}
	};

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "Categories", "Home", "Top Paid", "Top Free", "Top Grossing", "Top New Paid",
				"Top New Free", "Trending" };

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			return SuperAwesomeCardFragment.newInstance(position);
		}

	}
}
