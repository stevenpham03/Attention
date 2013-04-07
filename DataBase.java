package com.thenewboston.kevin;

import java.io.IOException;
import java.sql.SQLException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DataBase extends Activity {
	
	TextView display;
	DataBaseHelper myDbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.database);
		
		display = (TextView) findViewById(R.id.tvDBTest);
		myDbHelper = new DataBaseHelper(this);
	
	
	
	 //DataBaseHelper myDbHelper = new DataBaseHelper();
	 //myDbHelper = new DataBaseHelper(this);
	 try {
	  
	 myDbHelper.createDataBase();
	 
	  
	 } catch (IOException ioe) {
	  
	 throw new Error("Unable to create database");
	  
	 }
	  
	 try {
	  
	 myDbHelper.openDataBase();
	 
	 String data = myDbHelper.getData();
	 display.setText(data);
	 
	 }catch(SQLException sqle){
	  
	 try {
		throw sqle;
	 }catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	  
	 }

} // end onCreate
}
