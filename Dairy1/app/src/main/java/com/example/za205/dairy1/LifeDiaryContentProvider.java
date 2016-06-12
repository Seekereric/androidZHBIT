package com.example.za205.dairy1;

import android.content.ContentProvider;
import android.content.UriMatcher;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Field;

/**
 * Created by za205 on 6/6/2016.
 */
public class LifeDiaryContentProvider extends ContentProvider {
    private static final String DATABASE_NAME = "database";
    private static final String DATABASE_TABLE_NAME = "diary";
    private static final int DATABASE_VERSION = 3;
    private static final int DIARIES = 1;
    private static final int DIARY_ID = 2;

    private static final UriMatcher sUriMatcher;
    static{
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(Fields.AUTHORITY, "diaries", DIARIES);
        sUriMatcher.addURI(Fields.AUTHORITY, "diaries/#", DIARY_ID);
    }
}
