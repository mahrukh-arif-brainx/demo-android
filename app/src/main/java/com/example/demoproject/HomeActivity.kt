package com.example.demoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoproject.models.AppSharedPreference
import kotlinx.android.synthetic.main.activity_home.*
import android.content.Context
import android.view.MenuItem
import android.view.View.GONE
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoproject.fragments.HomeFragment
import com.example.demoproject.fragments.NotificationFragment
import com.example.demoproject.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        setCurrentFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_item->setCurrentFragment(HomeFragment())
                R.id.notification_item->setCurrentFragment(NotificationFragment())
                R.id.settings_item->setCurrentFragment(SettingsFragment())

            }
            true
        }


    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }

}