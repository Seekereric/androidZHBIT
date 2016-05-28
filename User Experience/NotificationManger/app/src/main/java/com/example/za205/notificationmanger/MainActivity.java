package com.example.za205.notificationmanger;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private NotificationManager myNotiManager;
    private Spinner mySpinner;
    private ArrayAdapter<String> myAdapter;
    private static final String[] status = {"在线", "离开", "忙碌中", "马上回来", "脱机"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myNotiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);
        myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        myAdapter.setDropDownViewResource(R.layout.myspinner_dropdown);

        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                if(status[arg2].equals("在线")){
                    setNotiType(R.drawable.msn, "在线");
                } else if (status[arg2].equals("离开"))
                {
                    setNotiType(R.drawable.away, "离开");
                } else if (status[arg2].equals("忙碌中"))
                {
                    setNotiType(R.drawable.busy, "忙碌中");
                } else if (status[arg2].equals("马上回来"))
                {
                    setNotiType(R.drawable.min, "马上回来");
                } else
                {
                    setNotiType(R.drawable.offine, "脱机");
                }
            }

            public void onNothingSelected(AdapterView<?> arg0){}
        });
    }

    @SuppressWarnings("deprecation")
    private void setNotiType(int iconId, String text){
        Intent notifyIntent = new Intent(this, ToastActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		/* 建立PendingIntent作为设定递延执行的Activity */
        PendingIntent appIntent = PendingIntent.getActivity(
                MainActivity.this, 0, notifyIntent, 0);

		/* 建立Notication，并设定相关参数 */
        Notification myNoti = new Notification();
		/* 设定statusbar显示的icon */
        myNoti.icon = iconId;
		/* 设定statusbar显示的文字讯息 */
        myNoti.tickerText = text;
		/* 设定notification发生时同时发出预设声音 */
        myNoti.defaults = Notification.DEFAULT_SOUND;
		/* 设定Notification留言条的参数 */
        myNoti.setLatestEventInfo(MainActivity.this, "MSN登入状态", text, appIntent);
		/* 送出Notification */
        myNotiManager.notify(0, myNoti);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
