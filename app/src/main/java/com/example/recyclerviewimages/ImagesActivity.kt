package com.example.recyclerviewimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)
        var viewModel = ImagesActivityViewModel(this)
        viewModel.getImagesList()
    }

}