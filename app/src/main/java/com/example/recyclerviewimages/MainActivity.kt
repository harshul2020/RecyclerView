package com.example.recyclerviewimages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showOptionsButton = findViewById<Button>(R.id.show_options_button)
        showOptionsButton.setOnClickListener{showImages()}
    }

    private fun showImages() {
        val imagesActivity = Intent(this, ImagesActivity::class.java)
        intent.putExtra("url", getString(R.string.url))
        startActivity(imagesActivity)
    }

}