package com.android.searchpage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.android.searchpage.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

//https://teamsparta.notion.site/Android-9a6969a80a1b472da00f98064e0df4b2
class MainActivity : AppCompatActivity(){
    private lateinit var context: Context
    private val binding = ActivityMainBinding.inflate(layoutInflater)
    //private val dummylist = mutableListOf<ContactListData>()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContentView(binding.root)
        dummyData()

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(MainFragment(), "메인")
        adapter.addFragment(SearchFragment(), "검색")
        val main = findViewById<ViewPager>(R.id.main_viewpager)
        val tablayout = findViewById<TabLayout>(R.id.main_tablayout)
        main.adapter = adapter
        tablayout.setupWithViewPager(main)

    }

    private fun dummyData(){
    dummy(R.drawable.sample1,"Test No.1","0000-00-00")
    dummy(R.drawable.sample2,"Test No.2","1111-11-11")
    dummy(R.drawable.sample3,"Test No.3","2222-22-22")
    }
    private fun dummy(
        image:Int,
        date:String,
        time:String)
    {
//    val dummydata =ArrayList<dummyarea>()
//    dummydata.add(dummyarea())
    }
}