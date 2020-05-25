package com.example.annoyingex

import android.content.Context
import android.util.Log
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class TextAlotWorker(private val context: Context, workParams: WorkerParameters): Worker(context , workParams) {
    lateinit var askNotificationManager: RepAskNotificManager
        private set

    override fun doWork(): Result {
       // askApp.askNotificationManager.postItNote()
        askNotificationManager = RepAskNotificManager(context)
        val textInput = getInputData().keyValueMap.keys.toList()
    //    Log.i("liam", "Test there yet!!!!?????!!!")

        //Log.i("liam", "Test we there yet!!!!?????!!!")
        askNotificationManager.postItNote(textInput)
        return Result.success()
    }
}