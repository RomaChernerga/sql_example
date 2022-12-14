package com.example.sql_example.data

import android.provider.BaseColumns

object MyDataBaseNameClass : BaseColumns {
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_CONTENT = "content"


    const val DATABASE_NAME = "SQL_ExampleDb.db"
    const val DATABASE_VERSION = 1

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_CONTENT TEXT)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXIST ${TABLE_NAME}"
}