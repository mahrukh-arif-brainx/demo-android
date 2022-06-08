package com.example.demoproject

import com.example.demoproject.models.LoginApiResponse
import com.example.demoproject.models.RandomApiResponse
import com.example.demoproject.models.TrainingApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @POST("/api/v1/users/sign_in.json")
    fun getAuthenticatedUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<LoginApiResponse>

    @GET("api/v1/quotes/random.json")
    fun getQuote(
        @Header("Content-Type") contentType: String,
        @Header("access-token") access_token: String,
        @Header("uid") uid: String,
        @Header("client") client: String
    ): Call<RandomApiResponse>

    @GET("api/v1/trainings.json")
    fun getTrainings(
        @Header("Content-Type") contentType: String,
        @Header("access-token") access_token: String,
        @Header("uid") client: String,
        @Header("client") uid: String
    ):Call<TrainingApiResponse>


}