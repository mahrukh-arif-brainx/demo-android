package com.example.demoproject

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.models.AppSharedPreference
import com.example.demoproject.models.RandomApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivityViewModel : ViewModel() {
    val authorAndQuote = MutableLiveData<RandomApiResponse>()
    var msg = MutableLiveData<String>()

    fun getAuthorAndQuote(context: Context) {

        viewModelScope.launch(Dispatchers.IO) {
            val retrofitBuilder = RetrofitInstance.buildService(ApiInterface::class.java)
            val sharedPreference = AppSharedPreference.getAppSharedPreferences(context)

            val retrofitData = retrofitBuilder?.getQuote(
                "application/json",
                sharedPreference?.getStringValue(AppConstants.ACCESS_TOKEN)!!,
                sharedPreference.getStringValue(AppConstants.UID)!!,
                sharedPreference.getStringValue(AppConstants.CLIENT)!!

                )


            retrofitData?.enqueue(object : Callback<RandomApiResponse?> {
                override fun onResponse(
                    call: Call<RandomApiResponse?>,
                    response: Response<RandomApiResponse?>
                ) {
                    if (response.isSuccessful) {
                        authorAndQuote.postValue(response.body())

                    }
                    else {
                        val jsonObject = JSONObject(response.errorBody()?.string())
                        msg.postValue(jsonObject.getString("errors"))
                    }
                }

                override fun onFailure(call: Call<RandomApiResponse?>, t: Throwable) {
                    msg.postValue(t.message)
                }
            })
        }
    }
}