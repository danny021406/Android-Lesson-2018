package com.example.wangguansheng.weekonechfour

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val random = Random()
    var number : IntArray = IntArray(4)
    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleNumber()
        processControllers()
    }


    private fun processControllers() {
        // 建立監聽物件
        val btn = findViewById(R.id.btn) as Button
        val result = findViewById(R.id.result) as TextView
        val input = findViewById(R.id.input) as EditText

        // 註冊監聽物件
        btn.setOnClickListener() {
            // TODO Auto-generated method stub
            val string = number[0].toString() + number[1].toString() + number[2].toString() + number[3].toString()
            Toast.makeText(this@MainActivity, string, Toast.LENGTH_SHORT).show()
            var str = input.text.toString()
            if(str.length != 4) {
                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show()
                val display: String = str.length.toString()
                result.setText(input.text.toString())
            }
            else{
                var inputnumber : IntArray = IntArray(4)
                var A = 0
                var B = 0
                var tmp = 0
                inputnumber[0]=str.toInt() / 1000
                tmp += (inputnumber[0] * 1000)
                inputnumber[1]=(str.toInt() - tmp) / 100
                tmp += (inputnumber[1] * 100)
                inputnumber[2]=(str.toInt() - tmp) / 10
                tmp += (inputnumber[2] * 10)
                inputnumber[3]=(str.toInt() - tmp)
                val string = inputnumber[0].toString() + inputnumber[1].toString() + inputnumber[2].toString() + inputnumber[3].toString()

                for(i in number.indices){
                    if(number[i] == inputnumber[i]){
                        A += 1
                        continue
                    }
                    for(j in inputnumber.indices){
                        if(number[i] == inputnumber[j] && i != j) {
                            B += 1
                        }
                    }
                }
                val display: String = A.toString() + "A" + B.toString()+"B"
                result.setText(display)
            }
            input?.setText("")
        }
    }

    private fun handleNumber() {
        var flag = 1
        while(flag == 1){
            flag = 0
            number[0]=rand(0,9)
            number[1]=rand(0,9)
            number[2]=rand(0,9)
            number[3]=rand(0,9)
            for(i in number.indices){
                for(j in number.indices){
                    if(j<=i)continue
                    if(number[i] == number[j])
                        flag = 1
                }
            }
        }
    }
}
