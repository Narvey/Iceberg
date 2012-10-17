package com.example.iceberg;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Action;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Iceberg extends Activity {
	private int icebergSize;
	private ArrayList<Integer> images;
	public static String TAG = "Iceberg";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_iceberg);
		images=new ArrayList<Integer>();
		images.add(R.id.img1);
		images.add(R.id.img2);
		images.add(R.id.img3);
		images.add(R.id.img4);
		images.add(R.id.img5);
		images.add(R.id.img6);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		if(e.getActionMasked()==MotionEvent.ACTION_DOWN){
			if(Settings.getIcebergs()) icebergSize=Settings.getSize();
			else icebergSize=0;

			String x = String.valueOf(e.getX());

			for(int i : images){
				ImageView img = (ImageView) findViewById(i);
				if(Math.abs(img.getLeft()-e.getX())<30&&Math.abs(img.getTop()-e.getY())<30){
					Log.d(TAG, "Hit target "+img.getId());
					Toast.makeText(this, "On a target!", Toast.LENGTH_SHORT).show();
				}
			}
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_iceberg, menu);
		return true;
	}

	public void pullUpSettings(View view){
		Intent intent = new Intent(this, Settings.class);
		startActivity(intent);
	}
}
