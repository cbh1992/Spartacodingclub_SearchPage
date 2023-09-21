package com.android.searchpage

import com.google.gson.annotations.SerializedName
import org.w3c.dom.Document

data class ImageModel(
    @SerializedName("docu")
    val docu:ArrayList<Docu>,

    @SerializedName("metadata")
    val metadata: Meta

) {
    data class Docu (
        @SerializedName("collection")
        val collection: String,
        @SerializedName("thumbnail_url")
        val url:String,
        @SerializedName("image_url")
        val img:String,
        @SerializedName("width")
        val width:Int,
        @SerializedName("height")
        val height:Int,
        @SerializedName("display_sitename")
        val name:String,
        @SerializedName("doc_url")
        val doc:String,
        @SerializedName("datetime")
        val time:String
    )
    data class Meta(
        @SerializedName("is_end")
        val end:Boolean,
        @SerializedName("pageable_count")
        val cont:Int,
        @SerializedName("total_count")
        val total:Int
    )
    {

    }
}