package com.example.sql_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sql_example.data.MyDbManager

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun onClick(view: View) {
        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val edTextContent = findViewById<EditText>(R.id.edTextContent)
        val tViewTest = findViewById<TextView>(R.id.tViewTest)
        tViewTest.text = ""

        findViewById<Button>(R.id.onClickSave).setOnClickListener {
            myDbManager.openDb()
            myDbManager.insertToDb(editTextTitle.text.toString(), edTextContent.text.toString())
            val dataList = myDbManager.readDbData()
            for (item in dataList) {
                tViewTest.append(item)
                tViewTest.append("\n")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}