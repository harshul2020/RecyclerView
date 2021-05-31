package com.example.recyclerviewimages

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewimages.models.Image
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImagesActivityViewModel(val activity: Activity) {
    fun getImagesList() {
        val imagesList = ImagesService.imagesInstace.getImages("Test", 20, 400, 400)
        imagesList.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                val imageUrlList: List<Image>? = response.body()?.map { Image(it) }
                showImages(imageUrlList)
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.d("Harshul", "Error")
                val imageRecyclerView = activity.findViewById<RecyclerView>(R.id.image_recycler_view)
                val errorTextView = activity.findViewById<TextView>(R.id.error_text_view)
                imageRecyclerView.visibility = View.GONE
                errorTextView.visibility = View.VISIBLE

            }

        })
    }

    private fun showImages(imageUrlList: List<Image>?) {
        val imageList = activity.findViewById<RecyclerView>(R.id.image_recycler_view)
        imageList.adapter = MyAdapter(imageUrlList)
        imageList.layoutManager = LinearLayoutManager(activity)
    }
}