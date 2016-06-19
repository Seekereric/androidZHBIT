package com.example.za205.diary2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.za205.diary2.Fields.DiaryColumns;
import com.xxx.bean.Note;
import com.xxx.dao.*;

import java.sql.Date;
import java.text.DateFormat;

/**
 * Created by za205 on 6/13/2016.
 */
public class DiaryEditor extends Activity {

    private static final String TAG = "Diary";
    public static final String EDI_DIARY_ACTION = "com.example.za205.diary2.DiaryEditor.EDIT_DIARY";
    public static final String INSERT_DIARY_ACTION = "com.example.za205.diary2.DiaryEditor.INSERT_DIARY";
    public static final int MENU_ITEM_DELETE = Menu.FIRST + 1;

    private SQLiteDatabase db;

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private NoteDao noteDao;
    private Note note;
    private Cursor cursor;

    private static final int STATE_EDIT = 0;
    private static final int STATE_INSERT = 1;
    private String dUriString;
    private int mState;
    private Uri mUri;
    private Cursor mCursor;
    private EditText mTitleText;
    private EditText mBodyText;
    private Button confirmButton;
    private long mid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Black);
        final Intent intent = getIntent();
        final String action = intent.getAction();
        setContentView(R.layout.diary_edit);
        mTitleText = (EditText) findViewById(R.id.title);
        mBodyText = (EditText) findViewById(R.id.body);
        confirmButton = (Button) findViewById(R.id.confirm);

        initDAO();

        if (EDI_DIARY_ACTION.equals(action)) {
            /*
            mState = STATE_EDIT;
            mUri = intent.getData();
            mCursor = managedQuery(mUri, PROJECTION, null, null, null);
            mCursor.moveToFirst();
            String title = mCursor.getString(1);
            mTitleText.setTextKeepState(title);
            String body = mCursor.getString(2);
            mBodyText.setTextKeepState(body);
            */
            Bundle bundle = new Bundle();
            bundle = this.getIntent().getExtras();
            mid = bundle.getLong("id");
            note = noteDao.loadByRowId(mid);

            mTitleText.setTextKeepState(note.getTitle());
            mBodyText.setTextKeepState(note.getBody());

            setTitle("编辑日记");
        } else if (INSERT_DIARY_ACTION.equals(action)) {
            mState = STATE_INSERT;
            setTitle("新建日记");
        } else {
            Log.e(TAG, "no such action error");
            finish();
            return;
        }

        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mState == STATE_INSERT) {
                    insertDiary();
                } else {
                    updateDiary();
                }
                Intent intent = new Intent(DiaryEditor.this, LifeDiary.class);
                startActivity(intent);
                DiaryEditor.this.finish();
            }
        });
    }

    private void initDAO(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        noteDao = daoSession.getNoteDao();
    }

    private void insertDiary(){
        String title = mTitleText.getText().toString();
        String body = mBodyText.getText().toString();
       final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String date = df.format(new java.util.Date());

        Note note = new Note(null, title, body, date);
        noteDao.insert(note);

        Log.d("DaoExample", "Inserted new note, ID: " + note.getId());
    }

    private void updateDiary(){
        String title = mTitleText.getText().toString();
        String body = mBodyText.getText().toString();
        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String date = df.format(new java.util.Date());

        Note note = new Note(null, title, body, date);
        noteDao.insert(note);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, MENU_ITEM_DELETE, 0, R.string.menu_delete);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case MENU_ITEM_DELETE:
                noteDao.deleteByKey(mid);

                Toast.makeText(DiaryEditor.this, "Success", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(DiaryEditor.this, LifeDiary.class);
                startActivity(intent);
                DiaryEditor.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


