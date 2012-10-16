package com.example.iceberg;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ToggleButton;
import android.app.Activity;
import android.content.res.Resources;

public class Settings extends Activity {
	private static boolean icebergs=true;
	private static int size;
	
	public void switcheroo(View view){
		icebergs = !icebergs;
		ToggleButton onoff = (ToggleButton) view;
		onoff.setChecked(icebergs);
		onoff.setText(icebergs?"On":"Off");
	}
	
	public static boolean getIcebergs(){
		return icebergs;
	}
	
	public static int getSize(){
		return size;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        size=25;
    }

}
