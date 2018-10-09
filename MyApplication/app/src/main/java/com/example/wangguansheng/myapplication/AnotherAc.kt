package com.example.wangguansheng.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_another.*
import java.util.*

class AnotherAc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        val btn_back: Button = findViewById(R.id.btn_back)
        btn_back.setOnClickListener({ hadleBack() })
        val month_key: Int = intent.getIntExtra( "KEY_MONTH", 1)
        val day_key: Int = intent.getIntExtra( "KEY_DAY", 1)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)                      //取出年
        val month = c.get(Calendar.MONTH) + 1           //取出月，月份的編號是由0~11 故+1
        val day = c.get(Calendar.DAY_OF_MONTH)

        result_day.setText("差   " + (day - day_key).toString() + " 日")
        result_month.setText("差   " + (month - month_key).toString() + " 月")


    }

    private fun hadleBack () {
        val intent: Intent = Intent()
        intent.putExtra("three","so u kidding me")
        setResult(2,intent)
        finish()
    }
}
