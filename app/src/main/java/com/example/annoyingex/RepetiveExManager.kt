package com.example.annoyingex
import android.app.Application
import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

class RepetiveExManager(private val context: Context)  {

    private var workManager = WorkManager.getInstance(context)

    fun startTextingAperson(messages: List<String>) {

        if (isRepAskRunning()) {
            stopWork()
        }

        val data = Data.Builder()
        for (x in 0 until (messages.size)){
            data.putInt(messages[x], x)
        }
        //val myData: Data = workDataOf(messages)
       // makeIntoPairs(messages)
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .build()

        val workRequest = PeriodicWorkRequestBuilder<TextAlotWorker>(15, TimeUnit.MINUTES)
            .setInputData(data.build())
            .setInitialDelay(5000, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .addTag(ASK_WORK_REQUEST_TAG)
            .build()

        workManager.enqueue(workRequest)
    }

    private fun makeIntoPairs(mesText: List<String>): List<Pair<String, Int>> {
        println(mesText.size)
        val other: List<Int> = emptyList()
        val otherMut  =   other.toMutableList()
        for (x in 0..mesText.size){
            print(x)
            otherMut.add(x)
        }
        val pairs = mesText zip otherMut
        println("Test ZIP"+pairs)
        return(pairs)
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