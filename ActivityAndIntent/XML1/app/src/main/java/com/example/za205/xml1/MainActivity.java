package com.example.za205.xml1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup = null;
    RadioButton currentRadioButton = null;
    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        r1 = (RadioButton) findViewById(R.id.a);
        r2 = (RadioButton) findViewById(R.id.b);
        r3 = (RadioButton) findViewById(R.id.c);
        r4 = (RadioButton) findViewById(R.id.d);
        r1.setClickable(true);
        radioGroup.setOnCheckedChangeListener(mchangeRadio);

        Button button1 = (Button) findViewById(R.id.sure);
        Button button2 = (Button) findViewById(R.id.cancel);
        button1.setOnClickListener(new button1());
        button2.setOnClickListener(new button2());
    }

        class button1 implements OnClickListener{
            public void onClick(View v){
                String ans = "";
                if(r1.isChecked()){
                    ans = "on";
                }
                else if(r2.isChecked()){
                    ans = "at";
                }
                else if(r3.isChecked()){
                    ans = "of";
                }
                else if(r4.isChecked()){
                    ans = "in";
                }

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, OtherActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("ans", ans);

                intent.putExtras(bundle);

                startActivityForResult(intent, 0);
            }
        }

        class button2 implements OnClickListener{
            public void onClick(View v){
                radioGroup.clearCheck();
                setTitle("");
            }
        }

        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 0 && resultCode == 0){
                Bundle bundle = data.getExtras();
                String ans = bundle.getString("ans");
            }
        }


        private RadioGroup.OnCheckedChangeListener mchangeRadio = new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if(checkedId == r1.getId()){
                    currentRadioButton = r1;
                } else if (checkedId == r2.getId()){
                    currentRadioButton = r2;
                } else if (checkedId == r3.getId()){
                    currentRadioButton = r3;
                } else if (checkedId == r4.getId()){
                    currentRadioButton = r4;
                }
            }
        };

}
