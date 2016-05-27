package com.example.za205.lifecircle;

import android.content.Intent;
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

    private Button bt;
    static final String LIFT_TAG="LoGActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.v(MainActivity.LIFT_TAG, "FirstAcvity ---> onCreate");

        bt = (Button)findViewById(R.id.bt);
        bt.setText("启动第二个Activity");
        bt.setOnClickListener(new ButtonOnClickListener());
    }

    class ButtonOnClickListener implements View.OnClickListener{
        public void onClick(View V){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MainActivity2.class);
            MainActivity.this.startActivity(intent);
        }
    }

    protected void onDestroy(){
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onDestory");
        super.onDestroy();
    }

    protected  void onPause(){
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onPause");
        super.onPause();
    }

    protected void onRestart(){
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onRestart");
        super.onRestart();
    }

    protected void onResume(){
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onResume");
        super.onResume();
    }

    protected void onStart() {
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onStart");
        super.onStart();
    }

    protected void onStop() {
        Log.v(MainActivity.LIFT_TAG, "FirstAcvity --->onStop");
        super.onStop();
    }

}
