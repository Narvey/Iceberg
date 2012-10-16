package com.example.iceberg;

import android.os.Bundle;
import android.view.MotionEvent;
import android.app.Activity;
import android.content.res.Resources;

public class Settings extends Activity {
	private static boolean icebergs=true;
	
	public boolean switcheroo(MotionEvent e){
		icebergs = !icebergs;
		return true;
	}
	
	public static boolean getIcebergs(){
		return icebergs;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

}
