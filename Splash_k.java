package com.thenewboston.kevin;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash_k extends Activity{

	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		ourSong = MediaPlayer.create(Splash_k.this, R.raw.patrick);
		ourSong.start();
		
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{
					sleep(2000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					Intent openStartingPoint = new Intent("com.thenewboston.kevin.MENU");
					startActivity(openStartingPoint);
				}
			};
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		ourSong.release(); // stops playing when another activity starts
		finish(); // finishes splash cover page when another activity starts a.k.a. destroys itself
	}
	
	
	
}
