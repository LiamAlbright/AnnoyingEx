package com.example.annoyingex

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class RepAskNotificManager(
    private val context: Context
)  {


    private val notificationManagerCompat = NotificationManagerCompat.from(context)


    init {
        createFunChannel()
    }

    fun postItNote(textMess: List<String>) {
        val dealsIntent = Intent(context, AskStuffActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("hello", "word")
        }

        val pendingDealsIntent = PendingIntent.getActivity(context, 0, dealsIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(context, FUN_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Jane Smith")
            .setContentText(textMess[Random.nextInt(0, (textMess.size)-1)])
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingDealsIntent)
            .setAutoCancel(true)
            .build()

        notificationManagerCompat.notify(Random.nextInt(), notification)
    }

    private fun createFunChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Fun Notifications"
            val descriptionText = "All Msgs from a....old Friend"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(FUN_CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            notificationManagerCompat.createNotificationChannel(channel)
        }
    }

    companion object {
        const val FUN_CHANNEL_ID = "FUNCHANNELID"
    }

}