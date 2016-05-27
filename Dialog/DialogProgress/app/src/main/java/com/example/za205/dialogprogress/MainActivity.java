package com.example.za205.dialogprogress;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar firstBar = null;
    private ProgressBar secondBar = null;
    private Button myButton = null;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        firstBar = (ProgressBar) findViewById(R.id.firstBar);
        secondBar = (ProgressBar) findViewById(R.id.secondBar);
        myButton = (Button) findViewById(R.id.myButton);
        myButton.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener{
        public void onClick(View v){
            if(i == 0){
                firstBar.setVisibility(View.VISIBLE);
                secondBar.setVisibility(View.VISIBLE);
                firstBar.setMax(150);
            } else if(i < firstBar.getMax()){
                firstBar.setProgress(i);
                firstBar.setSecondaryProgress(i + 10);
            } else {
                firstBar.setVisibility(View.GONE);
                secondBar.setVisibility(View.GONE);
            }
            i += 10;
        }
    }
}


