package com.egco428.a13283_a13265.mumap.Building;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class    MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_BUILDING = "building";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";


    private static final String DATABASE_NAME = "building.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = " create table " //create table comments (_id interger primary key autoincrement, comment text not null);
            + TABLE_BUILDING + " (" +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_NUMBER + " text not null, " +
            COLUMN_NAME + " text not null, " +
            COLUMN_LATITUDE + " text not null, " +
            COLUMN_LONGITUDE + " text not null, " +
            COLUMN_TYPE + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(
                "CREATE TABLE `building` (\n" +
                        "\t`_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "\t`number`\tTEXT NOT NULL,\n" +
                        "\t`name`\tTEXT NOT NULL,\n" +
                        "\t`latitude`\tTEXT NOT NULL,\n" +
                        "\t`longitude`\tTEXT NOT NULL,\n" +
                        "\t`type`\tTEXT NOT NULL\n" +
                        ");\n");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUILDING);
        onCreate(db);
    }

}
