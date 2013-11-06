package com.wade12.listview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
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
		context = this;													// used in nested Class below
		inflater = (LayoutInflater) this.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		listView = (ListView) findViewById(R.id.listView);
		
		locations = this.getResources().getStringArray(R.array.locationArray);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, locations);
		// ArrayAdapter takes 4 arguments - context, layout of row, to, from.
		
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
		
	} // end Class ListClickHandler

} // end Class MainActivity