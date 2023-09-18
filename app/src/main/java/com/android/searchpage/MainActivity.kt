package com.android.searchpage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.android.searchpage.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
//https://teamsparta.notion.site/Android-9a6969a80a1b472da00f98064e0df4b2
class MainActivity : AppCompatActivity()
{
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(MainFragment(), "메인")
        adapter.addFragment(SearchFragment(), "검색")
        val main = findViewById<ViewPager>(R.id.main_viewpager)
        val tablayout = findViewById<TabLayout>(R.id.main_tablayout)
        main.adapter = adapter
        tablayout.setupWithViewPager(main)

    }
}