package com.example.demoproject.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demoproject.fragments.HomeFragment
import com.example.demoproject.fragments.NotificationFragment
import com.example.demoproject.fragments.SettingsFragment

private const val NUM_TABS = 3

class PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
         return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return HomeFragment()
            1->return NotificationFragment()
        }
       return SettingsFragment()
    }

}