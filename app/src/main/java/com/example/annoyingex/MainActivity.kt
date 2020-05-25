package com.example.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val askApp = (application as repAskApp)
        val repExManager = askApp.repExManager
        val apiManagerHttp = askApp.askHttpManager

        btPost.setOnClickListener {
            apiManagerHttp.getListOfTexts({ allTexts ->
                repExManager.startTextingAperson(allTexts.messages)

            })

        }

        btStop.setOnClickListener {
                repExManager.stopWork()

        }
        val someDataFromNotification = intent.getStringExtra("value1")
        tvInfo.text=someDataFromNotification
    }

}
