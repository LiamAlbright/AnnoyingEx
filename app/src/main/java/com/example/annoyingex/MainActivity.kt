package com.example.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var apiManager: ApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val askApp = (application as repAskApp)
        val repExManager = askApp.repExManager
        val apiManagerHttp = askApp.askHttpManager

        btStart.setOnClickListener {
            //repExManager.startTextingAperson()
        }
        btPost.setOnClickListener {
          //  askApp.askNotificationManager.postItNote()
            apiManagerHttp.getListOfTexts({ allTexts ->
                Log.i("liam", "Test Texts received from "+ allTexts.messages[1])
              //  val pairs = makeIntoPairs(allTexts.messages)
                //Log.i("liam", "Test Texts received from "+ pairs)
                repExManager.startTextingAperson(allTexts.messages)

            })

        }
    }

//    private fun makeIntoPairs(mesText: List<String>): List<Pair<String, Int>> {
//        println(mesText.size)
//        val other: List<Int> = emptyList()
//        val otherMut  =   other.toMutableList()
//        for (x in 0..mesText.size){
//            print(x)
//            otherMut.add(x)
//        }
//        println("Test ZIP")
//
//        return(mesText zip otherMut)
//    }

}
