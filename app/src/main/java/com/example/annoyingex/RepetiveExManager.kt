package com.example.annoyingex
import android.app.Application
import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

class RepetiveExManager(private val context: Context)  {

    private var workManager = WorkManager.getInstance(context)

    fun startTextingAperson() {

        if (isRepAskRunning()) {
            stopWork()
        }

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val workRequest = PeriodicWorkRequestBuilder<TextAlotWorker>(15, TimeUnit.MINUTES)
            .setInitialDelay(5000, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .addTag(ASK_WORK_REQUEST_TAG)
            .build()

        workManager.enqueue(workRequest)
    }

    private fun isRepAskRunning(): Boolean {
        return when (workManager.getWorkInfosByTag(ASK_WORK_REQUEST_TAG).get().firstOrNull()?.state) {
            WorkInfo.State.RUNNING,
            WorkInfo.State.ENQUEUED -> true
            else -> false
        }
    }
    fun stopWork() {
        workManager.cancelAllWorkByTag(ASK_WORK_REQUEST_TAG)
    }

    companion object {
        const val ASK_WORK_REQUEST_TAG = "ASK_WORK_REQUEST_TAG"
    }
}