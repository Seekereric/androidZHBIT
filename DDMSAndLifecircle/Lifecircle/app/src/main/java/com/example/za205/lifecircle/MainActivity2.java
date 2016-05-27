package com.example.za205.lifecircle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by za205 on 5/27/2016.
 */
public class MainActivity2 extends AppCompatActivity {
    private static final String LIFT_TAG="LogActivity";

    protected void onCreate(Bundle savedInstanceState) {
        Log.v(MainActivity2.LIFT_TAG, "SecondActivity--->onCreate");
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        Log.v(MainActivity2.LIFT_TAG,"SecondActivity --->onDestory");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Log.v(MainActivity2.LIFT_TAG, "SecondActivity --->onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        Log.v(MainActivity2.LIFT_TAG, "SecondActivity --->onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Log.v(MainActivity2.LIFT_TAG, "SecondActivity --->onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        Log.v(MainActivity2.LIFT_TAG, "SecondActivity --->onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Log.v(MainActivity2.LIFT_TAG, "SecondActivity --->onStop");
        super.onStop();
    }
}
