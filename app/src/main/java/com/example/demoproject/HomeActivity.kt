package com.example.demoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoproject.models.AppSharedPreference
import kotlinx.android.synthetic.main.activity_home.*
import android.content.Context
import android.view.View.GONE
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        name.text=AppSharedPreference.getAppSharedPreferences(applicationContext)?.getStringValue("name")


        val viewModel = ViewModelProvider(this).get(HomeActivityViewModel::class.java)
        viewModel.getAuthorAndQuote(applicationContext)
        viewModel.authorAndQuote.observe(this, Observer {
            Quotation_text.text=it.text
            Quotation_author.text=it.author
        })
        viewModel.msg.observe(this, Observer {
            Quotation.visibility=GONE

        })

        training_card_view.setOnClickListener{
            val intent=Intent(this,TrainingActivity::class.java)
            startActivity(intent)
        }
    }

}