package com.example.sql_example.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDbHelper.writableDatabase
    }
    fun insertToDb(title: String, content: String) {
        val values = ContentValues().apply {
            put(MyDataBaseNameClass.COLUMN_NAME_TITLE, title)
            put(MyDataBaseNameClass.COLUMN_NAME_CONTENT, content)
        }
        db?.insert(MyDataBaseNameClass.TABLE_NAME, null, values)
    }
    @SuppressLint("Range")
    fun readDbData() : ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = db?.query(MyDataBaseNameClass.TABLE_NAME, null, null, null, null, null, null)

        with(cursor) {
            while (this?.moveToNext()!!) {
                val dataText = cursor?.getString(cursor.getColumnIndex(MyDataBaseNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText.toString())
            }
        }
        cursor?.close()
        return dataList
    }
    fun closeDb() {
        myDbHelper.close()
    }
}