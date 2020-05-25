package com.example.annoyingex

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class TextAlotWorker(private val context: Context, workParams: WorkerParameters): Worker(context , workParams) {

    override fun doWork(): Result {

        Log.i("liam", "Are we there yet!!!!?????!!!")

        return Result.success()
    }
}