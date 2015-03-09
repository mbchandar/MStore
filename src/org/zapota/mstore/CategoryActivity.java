package org.zapota.mstore;

import org.zapota.mstore.util.SuperAwesomeCardFragment;

import com.astuetz.PagerSlidingTabStrip;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public class CategoryActivity extends BaseActivity {

	
	private final Handler handler = new Handler();

	private final OkHttpClient client = new OkHttpClient();

	private final Gson gson = new Gson();
	
	private ViewPager pager;
	 
	private PagerSlidingTabStrip tabs;
	public CategoryActivity() {
		super(R.string.app_name);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		
		 
		// Initialize the ViewPager and set an adapter
	    pager = (ViewPager) findViewById(R.id.mypager);
	    pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

	    // Bind the tabs to the ViewPager
	    tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
	    tabs.setViewPager(pager);	    				
	}		
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.category, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);	    		
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

		private final String[] TITLES = { "New Arrivals", "Best Sellers", "Trending" };

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
			 switch (position) {
             case 0:
                 return new NewArrivalsFragment();
             case 1:
                 return SuperAwesomeCardFragment.newInstance(position);
             case 2:
             	return SuperAwesomeCardFragment.newInstance(position);
			 }
			 return null;
			//return SuperAwesomeCardFragment.newInstance(position);
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
		    super.destroyItem(container, position, object);
		}

	}
}
