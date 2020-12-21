package net.android.projectapp.network

import net.android.projectapp.model.JsonData
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("data.json")
    fun getJson(): Call<JsonData>
}