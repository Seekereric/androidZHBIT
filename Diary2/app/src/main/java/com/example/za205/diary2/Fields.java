package com.example.za205.diary2;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by za205 on 6/11/2016.
 */
public final class Fields {
    public static final String AUTHORITY = "com.example.za205.dairy1.diarycontentprovider";

    private Fields(){}

    public static final class DiaryColumns implements BaseColumns{
        private DiaryColumns(){}

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/diaries");

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.diary";

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.diary";

        public static final String DEFAULT_SORT_ORDER = "created DESC";

        public static final String TITLE = "title";

        public static final String BODY = "body";

        public static final String CREATED = "created";
    }
}
