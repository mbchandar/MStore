package org.zapota.mstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class BaseActivity extends SlidingFragmentActivity {

	private int mTitleRes;
	protected ListFragment mFrag;

	
	public BaseActivity(int titleRes) {
		mTitleRes = titleRes;
	}
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getActionBar().setDisplayHomeAsUpEnabled(true);				
	    getActionBar().setHomeButtonEnabled(true);
	    
		setTitle(mTitleRes);

		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager()
					.beginTransaction();
			mFrag = new SampleListFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (ListFragment) this.getSupportFragmentManager()
					.findFragmentById(R.id.menu_frame);
		}

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);

		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		item.getItemId();
		
		 switch (item.getItemId()) {
		 	case android.R.id.home:
				toggle();
				return true;			
	        case R.id.action_login:	       
	        	return loadActivity(LoginActivity.class);
	            
	        case R.id.action_account:
	        	return loadActivity(AccountActivity.class);
	        	
	        case R.id.action_category:
	        	return loadActivity(CategoryActivity.class);
	        		        
	        case R.id.action_category_list:
	        	return loadActivity(CategoryListActivity.class);
	        	
	        case R.id.action_settings:
	        	return loadActivity(SettingsActivity.class);
	        	
	        case R.id.action_shopping_cart:
	        	return loadActivity(CartActivity.class);
	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	private boolean loadActivity(Class<?> cls){
		Intent intent = new Intent(getBaseContext(), cls);         
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent); 
        return true;
	}
	

}
