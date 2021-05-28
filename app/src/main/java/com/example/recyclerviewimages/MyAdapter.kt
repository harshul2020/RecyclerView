package com.example.recyclerviewimages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val imageUrlList: List<String>?): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.image_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(imageUrlList != null) {
            Glide.with(holder.itemView).load(imageUrlList[position])
                .into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        if(imageUrlList != null) {
            return imageUrlList.size
        }
        return 0
    }
}

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val image = itemView.findViewById<ImageView>(R.id.imageView)
}