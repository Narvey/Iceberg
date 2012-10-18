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
		if(e.getActionMasked()==MotionEvent.ACTION_UP){
			if(Settings.getIcebergs()) icebergSize=Settings.getSize();
			else icebergSize=0;

			String x = String.valueOf(e.getX());
			for(int i : images){
				ImageView img = (ImageView) findViewById(i);
				float c = 76.0f;//If Android wasn't RETARDED, I wouldn't have to do this.
				Log.v(TAG, "x="+e.getX()+",y="+e.getY()+";i="+i+",i.x="+img.getLeft()+",i.y="+img.getTop()+c);
				if(Math.abs(img.getLeft()-e.getX())<30&&Math.abs(img.getTop()+c-e.getY())<30){
					Log.d(TAG, "Hit target "+img.getId());
					img.setImageResource(WHATEVER THE DRAWABLE ID IS+1);
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
