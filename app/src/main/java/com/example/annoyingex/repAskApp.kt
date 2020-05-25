package com.example.annoyingex


import android.app.Application
import com.example.annoyingex.model.TxtMess
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class repAskApp: Application(){
    private lateinit var textService: TextService

    lateinit var repExManager: RepetiveExManager
        private set

    lateinit var askNotificationManager: RepAskNotificManager
        private set
    lateinit var askHttpManager: ApiManager
        private set

    override fun onCreate() {
        super.onCreate()
        repExManager = RepetiveExManager(this)
        askNotificationManager = RepAskNotificManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create()) // this will automatically apply Gson conversion :)
            .build()
        textService = retrofit.create(TextService::class.java)

        // Load managers
        askHttpManager = ApiManager(this, textService)

    }


}
interface TextService {

    @GET("echeeUW/codesnippets/master/ex_messages.json")
    fun allTexts(): Call<TxtMess>

}