package com.example.demoproject

import android.os.Bundle
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.demoproject.adapters.PagerAdapter

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val viewPager=findViewById<ViewPager>(R.id.view_pager)
        val tabLayout=findViewById<TableLayout>(R.id.tab_layout)
        val pagerAdapter=PagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter= pagerAdapter

    }

}