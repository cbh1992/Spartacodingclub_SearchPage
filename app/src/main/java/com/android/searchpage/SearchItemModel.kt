package com.android.searchpage

data class SearchItemModel(
    var title:String, //제목
    var dateTime:String,//시간
    val url:String, //주소
    var islike: Boolean = false //체크
) {
}