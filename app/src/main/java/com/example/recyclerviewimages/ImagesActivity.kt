package com.example.recyclerviewimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewimages.models.Image
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)
        val viewModel = ImagesActivityViewModel()
        viewModel.getImagesList().subscribe(object : Observer<List<String>> {
            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(url_list : List<String>) {
//                Log.d("Harshul", url_list.toString())
                showImages(url_list)
            }

            override fun onError(e: Throwable?) {
                Log.d("Harshul", "Error")
            }

            override fun onComplete() {
            }
        })
    }
    
    private fun showImages(url_list : List<String>) {
        val imageList = findViewById<RecyclerView>(R.id.image_recycler_view)
        imageList.adapter = MyAdapter(url_list.map { it-> Image(it) })
        imageList.layoutManager = LinearLayoutManager(this)
    }

}