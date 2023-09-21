package com.android.searchpage

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.searchpage.databinding.ItemBinding
import com.bumptech.glide.Glide
import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder

class BookmarkAdapter(var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = mutableListOf<SearchItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(mContext)
            .load(items[position].url)
            .into((holder as ItemViewHolder).img)
        holder.
    }

    override fun getItemCount(): Int {
       return items.size
    }

    inner class ItemViewHolder(binding: SearchItemBinding):RecyclerView.ViewHolder(binding.root){
        var img:ImageView = binding.imageView
        var like : ImageView = binding.check
        var title: TextView = binding.itemTitle
        var time: TextView = binding.itemTime
        var item: ConstraintLayout = binding.item

        init {
            like.visibility = View.GONE
        }
    }


}