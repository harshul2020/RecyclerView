package com.example.recyclerviewimages

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
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
    ): Observable<List<String>>
}

object ImagesService {
    val imagesInstance: ImagesInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        imagesInstance = retrofit.create(ImagesInterface::class.java)
    }
}