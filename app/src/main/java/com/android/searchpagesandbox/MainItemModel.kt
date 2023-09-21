package com.android.searchpage

data class MainItemModel(
    var title: String, //제목
    val time: String, //시간
    var url: String, //주소
    val check: Boolean=false //클릭여부
) {
}