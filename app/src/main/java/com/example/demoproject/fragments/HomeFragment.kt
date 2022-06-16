package com.example.demoproject.fragments

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoproject.HomeActivityViewModel
import com.example.demoproject.R
import com.example.demoproject.TrainingActivity
import com.example.demoproject.databinding.FragmentHomeBinding
import com.example.demoproject.models.AppSharedPreference
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    lateinit var dBinding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        val view = dBinding.root
        return view


        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dBinding.homeFragment = this
        dBinding.nameUser =
            AppSharedPreference.getAppSharedPreferences(requireContext())?.getStringValue("name")


        val viewModel = ViewModelProvider(requireActivity()).get(HomeActivityViewModel::class.java)
        viewModel.getAuthorAndQuote(requireContext())
        viewModel.authorAndQuote.observe(viewLifecycleOwner, Observer {
            // Quotation_text.text=it.text
            // Quotation_author.text=it.author

            dBinding.randomApi = it

        })
        viewModel.msg.observe(viewLifecycleOwner, Observer {
            Quotation.visibility = View.GONE


        })

    }

    fun getHome(view: View) {

        val intent = Intent(activity, TrainingActivity::class.java)
        startActivity(intent)

    }


}