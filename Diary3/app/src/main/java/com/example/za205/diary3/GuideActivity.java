package com.example.za205.diary3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class GuideActivity extends Activity {
	
	private Button guideButton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);   
		setContentView(R.layout.guideactivity);
		
		guideButton = (Button)findViewById(R.id.guide_btn);
		ButtonListener buttonListener =new ButtonListener();
		guideButton.setOnClickListener(buttonListener);
	}
	
	class ButtonListener implements OnClickListener{
		
		@Override
		public void onClick(View arg0) {

			SharedPreferences preferences = getSharedPreferences(
				      "first_pref", MODE_PRIVATE);
				    Editor editor = preferences.edit();
				    editor.putBoolean("isFirstIn", false);
				    editor.commit();
			
			Intent intent = new Intent(GuideActivity.this ,LifeDiary.class);
			startActivity(intent);

			GuideActivity.this.finish();
		}
	}

		
}
