package com.example.demoproject.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoproject.HomeActivityViewModel
import com.example.demoproject.R
import com.example.demoproject.TrainingActivity
import com.example.demoproject.models.AppSharedPreference
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name.text= AppSharedPreference.getAppSharedPreferences(requireContext())?.getStringValue("name")


        val viewModel = ViewModelProvider(requireActivity()).get(HomeActivityViewModel::class.java)
        viewModel.getAuthorAndQuote(requireContext())
        viewModel.authorAndQuote.observe(viewLifecycleOwner, Observer {
            Quotation_text.text=it.text
            Quotation_author.text=it.author
        })
        viewModel.msg.observe(viewLifecycleOwner, Observer {
            Quotation.visibility= View.GONE

        })
        val intent= Intent(activity, TrainingActivity::class.java)

        training_card_view.setOnClickListener{
            startActivity(intent)
        }
    }


}