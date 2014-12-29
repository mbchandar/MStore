package org.zapota.mstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.zapota.mstore.CategoryListActivity.ItemCat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryListActivity extends BaseActivity {

	private final String[] TITLES = { "Categories", "Home", "Top Paid",
			"Top Free", "Top Grossing", "Top New Paid", "Top New Free",
			"Trending" };
	private final boolean[] listImages = { true, false, true, true, false,
			false, true, true };
	public ListView listview;

	private final OkHttpClient client = new OkHttpClient();

	private final Gson gson = new Gson();

	public CategoryListActivity() {
		super(R.string.app_name);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 // Just for testing, allow network access in the main thread
		    // NEVER use this is productive code
		    StrictMode.ThreadPolicy policy = new StrictMode.
		    ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy); 
		    
		setContentView(R.layout.activity_category_list);
		
		listview = (ListView) findViewById(R.id.list_view);

		Request request = new Request.Builder()
				.url("http://192.168.1.10/cs/kancart/index.php?method=kancart.category.get&parent_cid=1")
				.build();
		ArrayList<String> categories = new ArrayList<String>();
		ArrayList<Boolean> categoriesp = new ArrayList<Boolean>();				 
		
		try {
			Response response = client.newCall(request).execute();

			//Log.d("ANSWER", response.body().string());

			CategoryAPI category = gson.fromJson(response.body().string(),
					org.zapota.mstore.CategoryListActivity.CategoryAPI.class);		
			
			if(category == null){
				Log.d("[CATEGORY]", "category is null");
			}else{
				Log.d("[CATEGORY]", category.getInfo().toString());
				Log.d("[CATEGORY]", category.getInfo().getItemCats().toString());
				Log.d("[CATEGORY]", " Size " + category.getInfo().getItemCats().size());
				
				for (ItemCat item : category.getInfo().getItemCats()) {				
					categories.add(item.getName());
					if(item.getIsParent()){
						categoriesp.add(true);
					}else{
						categoriesp.add(false);
					}
				}
			}
			 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d("[EXCEPTION]", "unexpected code");

		}

		ImageAdapter listadapter = new ImageAdapter(this,
				R.layout.activity_category_list, R.id.text1, R.id.image1,
				categories, categoriesp);
		
		// Assign adapter to ListView
		listview.setAdapter(listadapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

          @Override
          public void onItemClick(AdapterView<?> arg0, View arg1,
                  int position, long arg3) {
              // TODO Auto-generated method stub
               int itemPosition     = position;

                 // ListView Clicked item value
                 String  itemValue    = (String) listview.getItemAtPosition(position);

                  // Show Alert 
                  Toast.makeText(getApplicationContext(),
                    "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                    .show();
          }
      });
		
		  
	}

	public class CategoryAPI {

		@Expose
		private String result;
		@Expose
		private String code;
		@Expose
		private Info info;

		/**
		 * 
		 * @return The result
		 */
		public String getResult() {
			return result;
		}

		/**
		 * 
		 * @param result
		 *            The result
		 */
		public void setResult(String result) {
			this.result = result;
		}

		/**
		 * 
		 * @return The code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * 
		 * @param code
		 *            The code
		 */
		public void setCode(String code) {
			this.code = code;
		}

		/**
		 * 
		 * @return The info
		 */
		public Info getInfo() {
			return info;
		}

		/**
		 * 
		 * @param info
		 *            The info
		 */
		public void setInfo(Info info) {
			this.info = info;
		}

	}

	public class Info {

		@SerializedName("item_cats")
		@Expose
		private List<ItemCat> itemCats = new ArrayList<ItemCat>();

		/**
		 * 
		 * @return The itemCats
		 */
		public List<ItemCat> getItemCats() {
			return itemCats;
		}

		/**
		 * 
		 * @param itemCats
		 *            The item_cats
		 */
		public void setItemCats(List<ItemCat> itemCats) {
			this.itemCats = itemCats;
		}

	}

	
	public class ItemCat {

		@Expose
		private String cid;
		@SerializedName("parent_cid")
		@Expose
		private String parentCid;
		@Expose
		private String name;
		@SerializedName("is_parent")
		@Expose
		private Boolean isParent;
		@Expose
		private String count;
		@Expose
		private Integer position;

		/**
		 * 
		 * @return The cid
		 */
		public String getCid() {
			return cid;
		}

		/**
		 * 
		 * @param cid
		 *            The cid
		 */
		public void setCid(String cid) {
			this.cid = cid;
		}

		/**
		 * 
		 * @return The parentCid
		 */
		public String getParentCid() {
			return parentCid;
		}

		/**
		 * 
		 * @param parentCid
		 *            The parent_cid
		 */
		public void setParentCid(String parentCid) {
			this.parentCid = parentCid;
		}

		/**
		 * 
		 * @return The name
		 */
		public String getName() {
			return name;
		}

		/**
		 * 
		 * @param name
		 *            The name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * 
		 * @return The isParent
		 */
		public Boolean getIsParent() {
			return isParent;
		}

		/**
		 * 
		 * @param isParent
		 *            The is_parent
		 */
		public void setIsParent(Boolean isParent) {
			this.isParent = isParent;
		}

		/**
		 * 
		 * @return The count
		 */
		public String getCount() {
			return count;
		}

		/**
		 * 
		 * @param count
		 *            The count
		 */
		public void setCount(String count) {
			this.count = count;
		}

		/**
		 * 
		 * @return The position
		 */
		public Integer getPosition() {
			return position;
		}

		/**
		 * 
		 * @param position
		 *            The position
		 */
		public void setPosition(Integer position) {
			this.position = position;
		}

	}

}

@SuppressWarnings("rawtypes")
class ImageAdapter extends ArrayAdapter {
	Activity context;
	ArrayList<String> items;
	ArrayList<Boolean> arrows;
	int layoutId;
	int textId;
	int imageId;

	@SuppressWarnings("unchecked")
	ImageAdapter(Activity context, int layoutId, int textId, int imageId,
			ArrayList<String> categories, ArrayList<Boolean> categoriesp) {
		super(context, layoutId, categories);

		this.context = context;
		this.items = categories;
		this.arrows = categoriesp;
		this.layoutId = layoutId;
		this.textId = textId;
		this.imageId = imageId;
	}

	public View getView(int pos, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View row = inflater.inflate(layoutId, null);
		TextView label = (TextView) row.findViewById(textId);
		
		label.setText(items.get(pos));

		if (arrows.get(pos)) {
			ImageView icon = (ImageView) row.findViewById(imageId);
			icon.setImageResource(R.drawable.next_48);
		}

		return (row);
	}
	
	
	
	 
}
//
//
//
// Feeling comfortable with basic library usage ?? Wait !! There are more demos
// in this Sample Project like,
// 1.Usage of EasyCursorAdapter for handling DB data.
// 2.Using Auto load more feature of library
// 3 Usage of Tap to Load More
// 4 Limiting Auto Load More on max items reached
// 5 Handling click events of child views in a row in very easy way.
// 6 Binding data through ContentProvider/CursorLoader mechanism
// 7 Supporting fixed number of data items
// 8 supporting multiple/single type of rows depending upon number of
// RowViewSetters you pass to adapter.
// 9 Best approach to handle data & AysncTasks through rotation of screen.
//
// So goto AndroidManifest & start tracking different feature's demos (All the
// demos are presented considering the OOPs concept so that it becomes very
// clear what line of code needs to be added for using various features of
// library.)
//
//
//
