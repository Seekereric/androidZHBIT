package com.example.za205.autocompletetextviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] autoStr = new String[] {"Italy", "IT","item","its","itself"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, autoStr);

        AutoCompleteTextView myAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.myAutoCompleteTextView);
        myAutoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView myMultiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.myMultiAutoCompleteTextView);
        myMultiAutoCompleteTextView.setAdapter(adapter);
        myMultiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
