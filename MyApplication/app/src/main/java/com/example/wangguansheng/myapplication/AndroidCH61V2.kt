package com.example.wangguansheng.myapplication

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_android_ch61_v2.*
import kotlinx.android.synthetic.main.activity_another.*


class AndroidCH61V2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_ch61_v2)

        btn.setOnClickListener {
            startAc()
        }
    }
    private fun openBrowser() {
        val uri: Uri = Uri.parse("http://www.google.com.tw")
        val intent: Intent = Intent()
        intent.setAction(Intent.ACTION_VIEW)
        intent.setData(uri)
        startActivity(intent)
    }
    private fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "danny021406@gmail.com", null))
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("jon@example.com")) // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text")
        startActivityForResult(emailIntent, 1)
    }
    private fun startAc() {
        var intMonth = 0
        var intDay = 0
        try {
            intMonth = Integer.parseInt(etMonth?.text.toString())
            intDay = Integer.parseInt(etDay?.text.toString())
        } catch (e: Exception) {
        }
        if (intMonth < 1 || intMonth > 12 || intDay < 1 || intDay > 31) {
            Toast.makeText(this@AndroidCH61V2, R.string.input_error,Toast.LENGTH_SHORT).show()
        }
        else{
            val intent = Intent()
            intent.setClass(this@AndroidCH61V2, AnotherAc::class.java)
            intent.putExtra("KEY_MONTH", intMonth)
            intent.putExtra("KEY_DAY", intDay)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data==null){
            return
        }
        if(resultCode==2){
            if(requestCode==1){
                val three = data.getStringExtra("three")
                yyooo.setText(three)
            }
        }
    }

}
