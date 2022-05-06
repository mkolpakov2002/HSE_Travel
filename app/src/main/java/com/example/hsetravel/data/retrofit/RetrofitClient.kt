package com.example.hsetravel.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Request


class RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String, token: String): Retrofit {
        if (retrofit == null) {
            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder.addInterceptor { chain ->
                val request: Request = chain.request()
                val newRequest: Request.Builder = request.newBuilder().header(
                    "Authorization",
                    "Bearer $token"
                )
                chain.proceed(newRequest.build())
            }
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
        }
        return retrofit!!
    }
}