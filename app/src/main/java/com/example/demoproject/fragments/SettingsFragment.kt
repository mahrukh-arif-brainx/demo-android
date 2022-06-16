package com.example.demoproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.demoproject.R
import com.example.demoproject.databinding.FragmentSettingsBinding
import kotlinx.android.synthetic.main.fragment_settings.*



class SettingsFragment : Fragment() {
    lateinit var dBinding:FragmentSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_settings, container, false
        )
        val view = dBinding.root
        return view
    }


}