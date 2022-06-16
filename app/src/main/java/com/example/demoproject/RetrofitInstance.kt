package com.example.demoproject

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {
    companion object {
        private var retrofit: Retrofit? = null
        private val BASE_URL = "https://staging.cblevelup.com"
        fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {

                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val httpClient = OkHttpClient.Builder()
                httpClient.addInterceptor(logging)


                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
            }
            return retrofit

        }

        fun <T> buildService(service: Class<T>): T? {
            return getRetrofitInstance()?.create(service)
        }

    }
}