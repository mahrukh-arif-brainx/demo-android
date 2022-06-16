package com.example.demoproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentNotificationBinding


class NotificationFragment : Fragment() {

 lateinit var dBinding:FragmentNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_notification, container, false
        )
        val view=dBinding.root
        return view
    }


}