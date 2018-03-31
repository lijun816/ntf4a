package com.ntf4a.dream.ntf4a.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ntf4a.dream.ntf4a.ApplicationNTF4A;

/**
 * sqlite
 * Created by dream on 2018/2/25.
 */

public class SqlHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "ntf4a";


    private SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public static SQLiteDatabase getWriteDb(){
        Context context  = ApplicationNTF4A.getApplication();
        SqlHelper sqlHelper = new SqlHelper(context, NAME, null, VERSION);
        return  sqlHelper.getWritableDatabase();
    }

    public static SQLiteDatabase getReadDb(){
        Context context  = ApplicationNTF4A.getApplication();
        SqlHelper sqlHelper = new SqlHelper(context, NAME, null, VERSION);
        return  sqlHelper.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createSqlUserInfo = "create talbe t_user_info ( "+
                "user_id integer PRIMARY KEY autoincrement," +
                "username text," +
                "password text  )";
        String createSqlPassword = "create talbe t_password_info ( "+
                "pwd_id integer PRIMARY KEY autoincrement," +
                "pwd_description text," +
                "pwd_name text," +
                "pwd_info text," +
                "pwd_memo text," +
                "pwd_create_date text," +
                "pwd_update_date text )";
        sqLiteDatabase.execSQL(createSqlUserInfo);
        sqLiteDatabase.execSQL(createSqlPassword);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



}
