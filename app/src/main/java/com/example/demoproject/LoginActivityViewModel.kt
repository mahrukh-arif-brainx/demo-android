package com.example.demoproject

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.models.AppSharedPreference
import com.example.demoproject.models.LoginApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.AccessController.getContext


class LoginActivityViewModel : ViewModel() {
    val authenticatedUser = MutableLiveData<LoginApiResponse>()
    var msg = MutableLiveData<String>()
    var password=MutableLiveData<String>()
    var email=MutableLiveData<String>()

    fun getResponse(context:Context) {
        val retrofitBuilder = RetrofitInstance.buildService(ApiInterface::class.java)
            val retrofitData = retrofitBuilder?.getAuthenticatedUser(email.value.toString(), password.value.toString())
            retrofitData?.enqueue(object : Callback<LoginApiResponse?> {
                override fun onResponse(
                    call: Call<LoginApiResponse?>,
                    response: Response<LoginApiResponse?>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            authenticatedUser.setValue(response.body())
                            AppSharedPreference.getAppSharedPreferences(context)
                                ?.apply {
                                    setValue("is_login", true)
                                    setStringValue(AppConstants.NAME, it.name.toString())
                                    setStringValue(AppConstants.UID, response?.headers()?.get("uid").toString())
                                    setStringValue(AppConstants.ACCESS_TOKEN,response?.headers()?.get("access-token").toString())
                                    setStringValue(AppConstants.CLIENT,response?.headers()?.get("client").toString())
                                }
                        }
                    }
                    else {
                        val jsonObject = JSONObject(response.errorBody()?.string())
                        msg.setValue(jsonObject.getString("error"))

                    }

                }
                override fun onFailure(call: Call<LoginApiResponse?>, t: Throwable) {
                    Log.d("response failure", t.message.toString())

                }
            })
        }

    }

