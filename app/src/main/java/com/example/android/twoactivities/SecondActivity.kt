package com.example.android.twoactivities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {

        val EXTRA_REPLY:String = "com.example.android.twoactivities.extra.REPLY"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       text_message.text =  intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

    }


    fun returnReply (view: View){

        val replyIntent = Intent()
        val replyMessage = editText_second.text.toString()
        replyIntent.putExtra( EXTRA_REPLY, replyMessage)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()

    }


}
