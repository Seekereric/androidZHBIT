package com.example.za205.ddms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String ACTIVITY_TAG="DDMS";
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View V){
                Log.v(MainActivity.ACTIVITY_TAG, "Verbose");
                Log.d(MainActivity.ACTIVITY_TAG, "Debug");
                Log.i(MainActivity.ACTIVITY_TAG, "Information");
                Log.w(MainActivity.ACTIVITY_TAG, "Warming");
                Log.e(MainActivity.ACTIVITY_TAG, "Error");
            }
        });
    }
}
