package com.example.annoyingex


import android.content.Context
import com.example.annoyingex.model.TxtMess
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiManager(private val context: Context, private val textService: TextService) {


    fun getListOfTexts(onSongReady: (TxtMess) -> Unit, onError: (() -> Unit)? = null) {

        textService.allTexts().enqueue(object : Callback<TxtMess> {
            override fun onResponse(call: Call<TxtMess>, response: Response<TxtMess>) {
                val allTexts = response.body()
                if (allTexts != null) {
                    onSongReady(allTexts)
                } else {
                    onError?.invoke()
                }
            }

            override fun onFailure(call: Call<TxtMess>, t: Throwable) {
                onError?.invoke()
            }
        })
    }

}