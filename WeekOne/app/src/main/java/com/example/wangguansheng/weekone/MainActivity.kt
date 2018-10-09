package com.example.wangguansheng.weekone

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val number = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        processControllers()
    }


    private fun processControllers() {
        // 建立監聽物件
        val btn = findViewById(R.id.btn) as Button
        val image = findViewById(R.id.img) as ImageView
        val info = findViewById(R.id.info) as TextView

        // 註冊監聽物件
        btn.setOnClickListener() {
                // TODO Auto-generated method stub
            Toast.makeText(this@MainActivity, "Its toast!", Toast.LENGTH_SHORT).show()
            val imagepath = getResources().getDrawable(R.drawable.test)
            image.setImageDrawable(imagepath)
            val string = getResources().getString(R.string.info)
            info.setText(string)
        }
    }
}
