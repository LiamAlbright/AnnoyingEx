package com.example.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val askApp = (application as repAskApp)
        val repExManager = askApp.repExManager

        btStart.setOnClickListener {
            repExManager.startTextingAperson()
        }
        btPost.setOnClickListener {
            askApp.askNotificationManager.postItNote()
        }
    }
}
