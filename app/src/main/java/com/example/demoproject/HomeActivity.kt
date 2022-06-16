package com.example.demoproject

import android.os.Bundle
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.demoproject.adapters.PagerAdapter
import com.example.demoproject.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    lateinit var dBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dBinding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(dBinding.root)
        val viewPager=findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        val pagerAdapter=PagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter= pagerAdapter


        TabLayoutMediator(tabLayout,viewPager){tab,position->
             when(position){
                 0->{
                     tab.text="Home"
                     tab.setIcon(R.drawable.home)
                 }
                 1->{
                     tab.text="Notification"
                     tab.setIcon(R.drawable.notification)
                 }
                 2->{
                     tab.text="Setting"
                     tab.setIcon(R.drawable.settings)
                 }
             }
        }.attach()

    }

}