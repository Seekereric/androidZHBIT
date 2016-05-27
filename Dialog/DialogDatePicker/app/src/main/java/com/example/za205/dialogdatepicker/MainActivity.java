package com.example.za205.dialogdatepicker;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView showdate;
    private Button setdate;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        showdate = (TextView) findViewById(R.id.showtime);
        setdate = (Button) findViewById(R.id.setdate);

        Calendar c = Calendar.getInstance(Locale.CHINA);
        Date mydate = new Date();
        c.setTime(mydate);

        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        showdate.setText(year + " " + (month + 1) + " " + day);

        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog my_datePickerDialog = new DatePickerDialog(MainActivity.this, Datelistener, year, month, day);
                my_datePickerDialog.show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener Datelistener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker v, int y, int m, int d) {
            year = y;
            month = m;
            day = d;

            updateDate();
        }

        private void updateDate() {
            showdate.setText(year + " " + (month + 1) + " " + day);
        }
    };
}

