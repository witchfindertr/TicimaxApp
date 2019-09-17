package com.example.ticimaxapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ticimaxapp.R
import com.example.ticimaxapp.models.Result
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotoListAdapter : PagedListAdapter<Result,PhotoListAdapter.PhotoHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item,parent,false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        getItem(position).let {
            holder.bindView(it!!)
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Result>(){

        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }

    class PhotoHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(photo : Result){
            Glide.with(itemView.context)
                .load(photo.thumbnail)
                .into(itemView.photo_imageView)

            itemView.title_textView.text = photo.id+"  "+photo.title
        }

    }
}