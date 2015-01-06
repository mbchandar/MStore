package org.zapota.mstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.zapota.mstore.helper.BackgroundWebRunner;
import org.zapota.mstore.helper.BusProvider;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.larswerkman.quickreturnlistview.QuickReturnListView;
import com.squareup.otto.Subscribe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CategoryListActivity extends BaseActivity {

	public QuickReturnListView listview;

	public ListView lv;

	private final Gson gson = new Gson();

	public CategoryListActivity() {
		super(R.string.app_name);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_category_list);
				
	
		BusProvider.getInstance().register(this);
		
		new BackgroundWebRunner().execute("http://192.168.1.10/cs/kancart/index.php?method=kancart.category.get&parent_cid=2");
				 
	}
		
	
	@Subscribe
	public void dataReceived(String output) {
		Log.d("ANSWER", output);
		ArrayList<HashMap<String, String>> categories = new ArrayList<HashMap<String, String>>();
		
		ArrayList<Integer> categories_id = new ArrayList<Integer>();
		ArrayList<String> categories_name = new ArrayList<String>();						 
        
		CategoryAPI category = gson.fromJson(output,
				CategoryAPI.class);		
		
		if(category == null){
			Log.d("[CATEGORY]", "category is null");
		}else{
			Log.d("[CATEGORY]", category.getInfo().toString());
			Log.d("[CATEGORY]", category.getInfo().getItemCats().toString());
			Log.d("[CATEGORY]", " Size " + category.getInfo().getItemCats().size());
			
			for (ItemCat item : category.getInfo().getItemCats()) {	
				if(item.getName() != null){
					// creating new HashMap
					/*
					Log.d("[hashmap]", item.getName());
			        HashMap <String, String> categoryitem = new HashMap<String, String>();

			        categoryitem.put("categories_id", item.getCid() );
			        categoryitem.put("categories_name", item.getName() );
			        categoryitem.put("isparent", item.getIsParent().toString() );
			        categories.add(categoryitem);
					*/
					categories_name.add(item.getName());
					categories_id.add(item.getCid());
					
				}
			}
		}
		
		/*
		
		ListAdapter listadapter = new SimpleAdapter(
                this, categories,
                R.layout.list_item_categories, new String[] { "categories_id", "category_name", "isparent"
                          }, new int[] {
                		 R.id.categories_id, R.id.textView1, R.id.isparent });
        */

		 
		MyAdapter listadapter2 = new MyAdapter(CategoryListActivity.this,
				R.layout.list_item_categories,  R.id.categories_id, R.id.category_name, categories_name, categories_id);

		
		 // get listview
		listview = (QuickReturnListView) findViewById(R.id.list);
       
		 
		
		// Assign adapter to ListView
		
		listview.setAdapter(listadapter2);
		
       /**
        * Listview item click listener
        * TrackListActivity will be lauched by passing album id
        * */
		listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> arg0, View view, int arg2,
                   long arg3) {
           	
           	 // Show Alert 
        	   /*
               Toast.makeText(getApplicationContext(),
                 "ListItem : " + ((TextView) view.findViewById(R.id.category_name)).getText().toString() , Toast.LENGTH_LONG)
                 .show();
               */
               
               // on selecting a single album
               // TrackListActivity will be launched to show tracks inside the album
               Intent i = new Intent(getApplicationContext(), CategoryActivity.class);
                
               // send album id to tracklist activity to get list of songs under that album
               String category_id = ((TextView) view.findViewById(R.id.categories_id)).getText().toString();
               i.putExtra("category_id", category_id);               
                
               startActivity(i);
               
           }
       }); 
		
	}

	@SuppressWarnings("rawtypes")
	class MyAdapter extends ArrayAdapter {
		Activity context;
		ArrayList<String> category_names;
		ArrayList<Integer> category_ids;
		int layoutId;
		int category_id;
		int category_name;

		@SuppressWarnings("unchecked")
		MyAdapter(Activity context, int layoutId, int category_id, int category_name,
				ArrayList<String> category_names, ArrayList<Integer> category_ids) {
			super(context, layoutId, category_names);

			this.context = context;
			this.category_id = category_id;
			this.category_name = category_name ;
			this.layoutId = layoutId;
			this.category_names = category_names;
			this.category_ids = category_ids;
		}

		@SuppressLint("ViewHolder")
		public View getView(int pos, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View row = inflater.inflate(layoutId, null);

			TextView category_id_txt = (TextView) row.findViewById(category_id);			
			category_id_txt.setText(category_ids.get(pos).toString());
 
			TextView category_name_txt = (TextView) row.findViewById(category_name);			
			category_name_txt.setText(category_names.get(pos));
						
			ImageView arrow_image = (ImageView) row.findViewById(R.id.arrow_right);
			arrow_image.setImageResource(R.id.arrow_right);

			return (row);
		}
		
		
		
		 
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
		private int cid;
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
		public int getCid() {
			return cid;
		}

		/**
		 * 
		 * @param cid
		 *            The cid
		 */
		public void setCid(int cid) {
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
