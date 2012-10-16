package com.example.iceberg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Toast;

public class Iceberg extends Activity {
	private int icebergSize;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iceberg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_iceberg, menu);
        return true;
    }
    
    public boolean onClick(MotionEvent e) {
    	if(Settings.getIcebergs()) icebergSize=20;
    	Toast.makeText(this, "you clicked", Toast.LENGTH_SHORT).show();
    	//for()
    	return true;
    }
}
