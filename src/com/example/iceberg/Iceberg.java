package com.example.iceberg;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Iceberg extends Activity {
	private int icebergSize;
	private ArrayList<Integer> images;
	private ArrayList<Integer> gray;//the grey version of the images.
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
		gray=new ArrayList<Integer>();
		gray.add(R.drawable.ic_android_orange_gray);
		gray.add(R.drawable.ic_catt_gray);
		gray.add(R.drawable.ic_cato_gray);
		gray.add(R.drawable.ic_catp_gray);
		gray.add(R.drawable.ic_android_gray);
		gray.add(R.drawable.ic_plus_signs_sophie_gray);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		if(e.getActionMasked()==MotionEvent.ACTION_UP){
			if(Settings.getIcebergs()) icebergSize=Settings.getSize();
			else icebergSize=0;

			String x = String.valueOf(e.getX());
			for(int i : images){
				ImageView img = (ImageView) findViewById(i);
				float top = 76.0f+img.getTop()-icebergSize;//If Android wasn't RETARDED, I wouldn't have to do the extra 76.
				float bottom = img.getTop()+img.getHeight()+icebergSize;
				float left = img.getLeft()-icebergSize;
				float right = img.getLeft()+img.getWidth()+icebergSize;
				Log.v(TAG,top+" "+bottom+" "+left+" "+right);
				Log.v(TAG, "x="+e.getX()+",y="+e.getY()+";i="+i+",i.x="+img.getLeft()+",i.y="+(img.getTop()+76f));
				if(e.getX()>=left && e.getX()<=right &&e.getY()>=top&&e.getY()<=bottom){
					Log.d(TAG, "Hit target "+img.getId());
					img.setImageResource(gray.get(images.indexOf(i)));
				}
			}
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_iceberg, menu);
		Intent intent = new Intent(this, Settings.class);
		startActivity(intent);
		return true;
	}

	public void pullUpSettings(View view){
		Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_LONG).show();
	}
}
