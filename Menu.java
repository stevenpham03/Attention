package com.thenewboston.kevin;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "DataBase" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		//full-screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		String cheese = classes[position];

		try {
			Class ourClass = Class.forName("com.thenewboston.kevin." + cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) { // this is the
																	// SDK menu
																	// class,
																	// not my
																	// menu
																	// class,
																	// creates a
																	// menu on
																	// the
																	// bottom of
																	// the phone
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { // when menu button is
															// clicked on bottom
															// of the phone
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.thenewboston.kevin.ABOUT");
			startActivity(i);
			break;

		case R.id.preferences: // never gets here because prefs is for api 11 (this is meant to work for api 8)
			Intent p = new Intent("com.thenewboston.kevin.PREFS");
			startActivity(p);
			break;
			
		case R.id.exit:
			finish();
			break;
		}
		return false;

	}

}
