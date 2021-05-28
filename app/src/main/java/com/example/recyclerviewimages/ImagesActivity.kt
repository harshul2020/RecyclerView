package com.example.recyclerviewimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)
        getImagesList()
    }


    private fun getImagesList() {
        val imagesList = ImagesService.imagesInstace.getImages("Test", 20, 400, 400)
        imagesList.enqueue(object: Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                val imageUrlList = response.body()
                showImages(imageUrlList)
            }
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.d("Harshul","Error")
                val imageRecyclerView = findViewById<RecyclerView>(R.id.image_recycler_view)
                val errorTextView = findViewById<TextView>(R.id.error_text_view)
                imageRecyclerView.visibility = View.GONE
                errorTextView.visibility = View.VISIBLE

            }

        })
    }

    private fun showImages(imageUrlList: List<String>?) {
        val imageList = findViewById<RecyclerView>(R.id.image_recycler_view)
        imageList.adapter = MyAdapter(imageUrlList)
        imageList.layoutManager = LinearLayoutManager(this)
    }
}