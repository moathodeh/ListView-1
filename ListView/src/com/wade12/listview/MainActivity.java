package com.wade12.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView) findViewById(R.id.listView);
		
		String[] planets = this.getResources().getStringArray(R.array.locationsArray);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, planets);
		// ArrayAdapter takes 4 arguments - context, layout of row, to, from.
		listView.setAdapter(adapter);
		
	} // end method onCreate
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} // end method onCreateOptionsMenu

} // end Class MainActivity