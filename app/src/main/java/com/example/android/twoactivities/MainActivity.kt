package com.example.android.twoactivities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName

companion object {

    val EXTRA_MESSAGE:String = "com.example.android.twoactivities.extra.MESSAGE"

}
    val TEXT_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun lanchSecondActiviy(view: View){
            Log.d( LOG_TAG , "Button Clicked!!")
            var message:String = editText_main.text.toString()
            val intent = Intent ( this, SecondActivity::class.java)
            intent.putExtra(EXTRA_MESSAGE,message)
            startActivityForResult(intent, TEXT_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == TEXT_REQUEST && resultCode == Activity.RESULT_OK)
        {
            val reply : String = data?.getStringExtra(SecondActivity.EXTRA_REPLY) ?: ""
            text_header_reply.visibility = View.VISIBLE

            text_message_reply.apply {
                text = reply
                visibility = View.VISIBLE
//
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w( LOG_TAG , "Evento onStart!!")
    }

    override fun onResume() {
        super.onResume()
        Log.w( LOG_TAG , "Evento onResume!!")
    }

    override fun onPause() {
        super.onPause()
        Log.w( LOG_TAG , "Evento onPause!!")
    }

    override fun onStop() {
        super.onStop()
        Log.w( LOG_TAG , "Evento onStop!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w( LOG_TAG , "Evento onDestroy!!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w( LOG_TAG , "Evento onReStart!!")
    }
}
