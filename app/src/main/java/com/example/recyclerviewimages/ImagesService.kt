package com.example.recyclerviewimages

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://hub.dummyapis.com/"

interface ImagesInterface {

    @GET("ImagesList?")
    fun getImages(
        @Query("text") text: String,
        @Query("noofimages") noofimages: Int,
        @Query("height") height: Int,
        @Query("width")width: Int
    ): Call<List<String> >
}

object ImagesService {
    val imagesInstace: ImagesInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        imagesInstace = retrofit.create(ImagesInterface::class.java)
    }
}