package com.example.iceberg;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Iceberg extends Activity {
	private int icebergSize;
	private ArrayList<Integer> images;

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
		if(Settings.getIcebergs()) icebergSize=Settings.getSize();
		String x = String.valueOf(e.getX());
		Toast.makeText(this, "you clicked at "+x, Toast.LENGTH_SHORT).show();
		for(int i : images){
			ImageView img = (ImageView) findViewById(i);
			if(img.getLeft()==e.getX()){
				
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
