package com.example.iceberg;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Iceberg extends Activity {
	private int icebergSize;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_iceberg);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		if(Settings.getIcebergs()) icebergSize=Settings.getSize();
		String x = String.valueOf(e.getX());
		Toast.makeText(this, "you clicked at "+x, Toast.LENGTH_SHORT).show();
		//for()
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
