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
// set your desired log level
// set your desired log level
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val httpClient = OkHttpClient.Builder()
// add your other interceptors …
// add logging as last interceptor
// add your other interceptors …
// add logging as last interceptor
                httpClient.addInterceptor(logging) // <-- this is the important line!


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