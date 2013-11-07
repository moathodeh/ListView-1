package com.wade12.listview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView listView;
	String[] locations;
	Context context;
	LayoutInflater inflater;
	
	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;		// used in nested Class below
		inflater = (LayoutInflater) this.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		listView = (ListView) findViewById(R.id.listView);
		
		locations = this.getResources().getStringArray(R.array.locationArray);
		
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, locations);
		// ArrayAdapter takes 4 arguments - context, layout of row, to, from.
		LocationsAdapter adapter = new LocationsAdapter(this, R.layout.list_view_row, R.id.listText, locations);
		
		View header = inflater.inflate(R.layout.locations_header_view, null);
		
		listView.addHeaderView(header);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ListClickHandler());
		
	} // end method onCreate
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} // end method onCreateOptionsMenu
	
	
	private class ListClickHandler implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
			
			TextView listText = (TextView) view.findViewById(R.id.listText);
			String text = listText.getText().toString();
			Toast.makeText(context, text + " clicked at position: " + position, Toast.LENGTH_SHORT).show();
			
		} // end method onItemClick
		
	} // end private inner Class ListClickHandler
	
	
	private class LocationsAdapter extends ArrayAdapter<String> {
		
		String[] locations;
		
		public LocationsAdapter(Context context, int resource, int textViewResourceId, String[] locations) {
			
			super(context, resource, textViewResourceId, locations);
			this.locations = locations;
		} // end constructor		

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			
			View viewLeft = inflater.inflate(R.layout.list_view_row, parent, false);
			View viewRight = inflater.inflate(R.layout.list_view_row_right, parent, false);
			
			String locationName = locations[position];
			
			if ( position % 2 == 0 ) {
				((TextView) viewLeft.findViewById(R.id.listText)).setText(locationName);
				view = viewLeft;
			} // end if
			else {
				((TextView) viewRight.findViewById(R.id.listText)).setText(locationName);
				view = viewRight;
			} // end else
			
			return view;
		} // end method getView
		
	} // end private inner Class LocationsAdapter

} // end Class MainActivity