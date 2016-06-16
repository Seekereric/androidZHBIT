package com.example.za205.dairy1;

import android.app.ListActivity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.za205.dairy1.Fields.DiaryColumns;

public class LifeDiary extends ListActivity {

    public static final int MENU_ITEM_INSERT = Menu.FIRST;
    public static final int MENU_ITEM_EDIT = Menu.FIRST + 1;
    public static final int MENU_ITEM_DELETE = Menu.FIRST + 2;
    private static final String[] PROJECTION = new String[]{
            DiaryColumns._ID, DiaryColumns.TITLE, DiaryColumns.CREATED};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_list);

        Intent intent = getIntent();
        if(intent.getData() == null){
            intent.setData(DiaryColumns.CONTENT_URI);
        }
        Cursor cursor = managedQuery(getIntent().getData(), PROJECTION, null, null, DiaryColumns.DEFAULT_SORT_ORDER);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.diary_row, cursor,
                new String[]{DiaryColumns.TITLE, DiaryColumns.CREATED},
                new int[] {R.id.text1, R.id.created});
        setListAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, MENU_ITEM_INSERT, 0, R.string.menu_insert);
        menu.add(Menu.NONE, MENU_ITEM_DELETE, 0, R.string.menu_delete);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case MENU_ITEM_INSERT:
                Intent intent0 = new Intent(this, DiaryEditor.class);
                intent0.setAction(DiaryEditor.INSERT_DIARY_ACTION);
                intent0.setData(getIntent().getData());
                startActivity(intent0);
                return true;
            case MENU_ITEM_DELETE:
                Uri uri = ContentUris.withAppendedId(getIntent().getData(),
                        getListView().getSelectedItemId());
                getContentResolver().delete(uri, null, null);
                renderListView();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        Uri uri = ContentUris.withAppendedId(getIntent().getData(), id);
        startActivity(new Intent(DiaryEditor.EDI_DIARY_ACTION, uri));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
    }

    private void renderListView(){
        Cursor cursor = managedQuery(getIntent().getData(), PROJECTION,null,null, DiaryColumns.DEFAULT_SORT_ORDER);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.diary_row, cursor,
                new String[] {DiaryColumns.TITLE, DiaryColumns.CREATED},
                new int[] {R.id.text1, R.id.created});
        setListAdapter(adapter);
    }
}
