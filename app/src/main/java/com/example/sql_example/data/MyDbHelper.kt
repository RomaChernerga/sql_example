package com.example.sql_example.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context)
    : SQLiteOpenHelper(context, MyDataBaseNameClass.DATABASE_NAME, null, MyDataBaseNameClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDataBaseNameClass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(MyDataBaseNameClass.SQL_DELETE_TABLE)
        onCreate(db)
    }

}