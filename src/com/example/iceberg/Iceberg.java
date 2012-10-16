package com.example.iceberg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Iceberg extends Activity {

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
}
