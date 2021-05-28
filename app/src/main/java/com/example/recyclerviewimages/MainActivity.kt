package com.example.recyclerviewimages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val showOptionsButton = findViewById<Button>(R.id.show_options_button)
        showOptionsButton.setOnClickListener { showImages() }
//        getImages()
    }

    private fun showImages() {
        val imagesActivity = Intent(this, ImagesActivity::class.java)
//        intent.putExtra("url", getString(R.string.url))
        startActivity(imagesActivity)
    }

/*    private fun getImages() {
        val imagesList = ImagesService.imagesInstace.getImages("test", 5,
            120, 120)

        imagesList.enqueue(object: Callback<List<String> > {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                val images: String = response.body().toString()
                val textView: TextView = findViewById(R.id.textView)
                textView.text = images
                Log.d("Harshul", images)
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.d("Harshul", "Error")
            }
        })
    }*/

}