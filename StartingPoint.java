package com.thenewboston.kevin;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoint extends Activity {
	
	static int counter = 0;
	Button add, subtract;
	TextView display;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_point);
        
        add = (Button) findViewById(R.id.Button1);
        subtract = (Button) findViewById(R.id.Button2);
        display = (TextView) findViewById(R.id.text1);
        display.setText("Your total is " + counter);
        
        add.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				++counter; 
				display.setText("Your total is " + counter);
			}	
			});
        
        subtract.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				--counter;
				display.setText("Your total is " + counter);
			}	
			});
        
        }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_starting_point, menu);
        return true;
    }
}
