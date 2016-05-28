package com.example.za205.notificationmanger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by za205 on 5/28/2016.
 */
public class ToastActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		/* 发出Toast */
        Toast.makeText(ToastActivity.this, "这是模拟MSN切换登录状态的程序",
                Toast.LENGTH_SHORT).show();
        finish();
    }
}
