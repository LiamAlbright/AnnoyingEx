package com.example.annoyingex


import android.app.Application

class repAskApp: Application(){

    lateinit var repExManager: RepetiveExManager
        private set

    lateinit var askNotificationManager: RepAskNotificManager
        private set

    override fun onCreate() {
        super.onCreate()

        repExManager = RepetiveExManager(this)
        askNotificationManager = RepAskNotificManager(this)

    }
}