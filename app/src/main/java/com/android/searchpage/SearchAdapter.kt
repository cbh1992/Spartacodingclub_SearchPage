package com.android.searchpage

import android.content.Context
import android.renderscript.ScriptGroup.Binding
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
import org.w3c.dom.Text

class SearchAdapter(private val mContext: Context): RecyclerView.Adapter<SearchAdapter.ItemViewHolder>() {
    var items = ArrayList<SearchItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val curruntItem = items[position]

        Glide.with(mContext)
            .load(curruntItem.url)
            .into(holder.img)

        holder.like.visibility =
            if  (curruntItem.islike) View.VISIBLE
            else View.INVISIBLE
        holder.title.text=curruntItem.title
//        holder.time.text=getDateFromTimestampWithFormat(
//            curruntItem.dateTime,
//            "yyyy-mm-dd'T'HH:mm:ss.SSS+09:00",
//            "yy-mm-dd HH:mm:ss"
//        )
    }

    override fun getItemCount()=items.size

    inner class ItemViewHolder(binding: ItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        var img : ImageView = binding.imageView
        var like : ImageView = binding.check
        var title: TextView = binding.itemTitle
        var time: TextView = binding.itemTime
        var item: ConstraintLayout = binding.item

        init {
            like.visibility = View.GONE
            img.setOnClickListener(this)
            item.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            val item = items[position]

            item.islike = !item.islike
//            if(item.islike){
//                (mContext as MainActivity).addLikedItem(item)}
//            else{
//                (mContext as MainActivity).removeLikedItem(item)}
            notifyItemChanged(position)
        }
    }
}