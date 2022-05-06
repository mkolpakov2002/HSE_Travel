package com.example.hsetravel.data.retrofit

import com.example.hsetravel.data.ExcursionObject
import com.example.hsetravel.data.TravelObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("")
    suspend fun getExcursions() : Response<List<ExcursionObject>>

    @GET("")
    suspend fun getTravels(@Path("") id: Int) : Response<List<TravelObject>>

}