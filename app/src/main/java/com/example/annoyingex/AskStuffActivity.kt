package com.example.annoyingex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_stuff.*

class AskStuffActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stuff)

        val someDataFromNotification = intent.getStringExtra("value1")

        tvInfo.text = someDataFromNotification
    }
}
