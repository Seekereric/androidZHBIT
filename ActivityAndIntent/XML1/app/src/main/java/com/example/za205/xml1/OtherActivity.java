package com.example.za205.xml1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

/**
 * Created by za205 on 5/27/2016.
 */
public class OtherActivity extends AppCompatActivity{
    private Intent intent;
    private Bundle bundle;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Bundle bundle = this.getIntent().getExtras();
        String ans = bundle.getString("ans");

        String setText = "";
        if(ans.equals("in")){
            setText = "right!";
        } else {
            setText = "wrong!";
        }

        TextView tv1 = (TextView) findViewById(R.id.text1);
        tv1.setText("Your answer is " + setText);

        Button b1 = (Button) findViewById(R.id.button_back);
        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                OtherActivity.this.setResult(RESULT_OK, intent);
                OtherActivity.this.finish();
            }
        });
    }
}
