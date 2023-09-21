package com.android.searchpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.android.searchpage.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

//https://teamsparta.notion.site/Android-9a6969a80a1b472da00f98064e0df4b2
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //var itemcheck:ArrayList<SearchItemModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(SearchFragment(), "검색")
        adapter.addFragment(BookmarkFragment(), "저장")
        val main = findViewById<ViewPager>(R.id.main_viewpager)
        val tablayout = findViewById<TabLayout>(R.id.main_tablayout)
        main.adapter = adapter
        tablayout.setupWithViewPager(main)

    }



}