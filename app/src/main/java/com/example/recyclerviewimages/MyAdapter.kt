package com.example.recyclerviewimages

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(private val imageUrlList: List<String>?): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.image_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(imageUrlList != null) {
            var color = Color.rgb(220, 220, 220)
            if(position % 2 == 0) color = Color.rgb(240, 240, 240)
            holder.container.setBackgroundColor(color)
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
    val image: ImageView= itemView.findViewById(R.id.imageView)
    val container: ConstraintLayout = itemView.findViewById(R.id.container)
}