package com.example.demoproject

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.models.AppSharedPreference
import com.example.demoproject.models.TrainingApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrainingActivityViewModel:ViewModel() {

   val trainings= MutableLiveData<TrainingApiResponse>()
    val msg=MutableLiveData<String>()
    fun getAllTrainings(context:Context)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val sharedPreference = AppSharedPreference.getAppSharedPreferences(context)
            val retrofitBuilder = RetrofitInstance.buildService(ApiInterface::class.java)
            val retrofitData = retrofitBuilder?.getTrainings(
                AppConstants.CONTENT_TYPE,
                sharedPreference?.getStringValue(AppConstants.ACCESS_TOKEN)!!,
                sharedPreference?.getStringValue(AppConstants.UID)!!,
                sharedPreference?.getStringValue(AppConstants.CLIENT)!!
            )
            retrofitData?.enqueue(object : Callback<TrainingApiResponse?> {
                override fun onResponse(
                    call: Call<TrainingApiResponse?>,
                    response: Response<TrainingApiResponse?>
                )
                {
                    if(response.isSuccessful)
                    {
                        trainings.postValue(response.body())
                    }
                    else
                    {
                        val jsonObject=JSONObject(response.errorBody()?.string())
                        msg.postValue(jsonObject.getString("errors"))

                    }
                }

                override fun onFailure(call: Call<TrainingApiResponse?>, t: Throwable) {
                    Toast.makeText(context,"internet disconnected",Toast.LENGTH_SHORT).show()

                }
            })
        }

    }
}


