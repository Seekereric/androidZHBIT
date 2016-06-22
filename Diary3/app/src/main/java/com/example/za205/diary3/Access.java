package com.example.za205.diary3;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;

public class Access extends Activity {
	
	private Button access;
	private SharedPreferences sp = null;
	boolean isFirstIn = false;

	private SharedPreferences textpassword = null;
	private String password = null;
	private boolean isSet = false;
	private EditText checkpass = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.access);

		checkisFirsttime();
		access = (Button)findViewById(R.id.access);
		access.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = null;
				intent = new Intent(Access.this, LifeDiary.class);
			    startActivity(intent);
			    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			    Access.this.finish();
			}
		});
	}

	private void checkisFirsttime() {
		SharedPreferences preferences = getSharedPreferences("first_pref",
				MODE_PRIVATE);
		isFirstIn = preferences.getBoolean("isFirstIn", true);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent();
				if (!isFirstIn) {
					checkPass();
				}
			}
		}, 0);
	}

	private void checkPass() {
		textpassword = getSharedPreferences("pass", Context.MODE_PRIVATE);
		password = textpassword.getString("password", null);
		isSet = textpassword.getBoolean("isSet", false);
		if (isSet) {
			LayoutInflater factory = LayoutInflater.from(Access.this);
			final View textEntry = factory.inflate(R.layout.confirm_pass, null);
			AlertDialog.Builder bulider = new AlertDialog.Builder(this)
					.setTitle(getString(R.string.pass_con_title))
					.setIcon(
							getResources().getDrawable(
									android.R.drawable.ic_lock_lock))
					.setView(textEntry)
					.setCancelable(false)
					.setPositiveButton(getString(R.string.ok),
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
													int which) {
									checkpass = (EditText) textEntry
											.findViewById(R.id.check_pass);
									if (checkpass.getText().toString().trim()
											.equals(password)) {

										try {
											Field field = dialog
													.getClass()
													.getSuperclass()
													.getDeclaredField(
															"mShowing");
											field.setAccessible(true);
											field.set(dialog, true);
										} catch (Exception e) {
											e.printStackTrace();
										}
										dialog.dismiss();
									} else {
										try {
											Field field = dialog
													.getClass()
													.getSuperclass()
													.getDeclaredField(
															"mShowing");
											field.setAccessible(true);
											field.set(dialog, false);
										} catch (Exception e) {
											e.printStackTrace();
										}
										Toast.makeText(Access.this,
												R.string.password_wrong,
												Toast.LENGTH_LONG).show();

										checkpass.setText("");
									}
								}
							});
			bulider.create().show();
		}
	}
}
