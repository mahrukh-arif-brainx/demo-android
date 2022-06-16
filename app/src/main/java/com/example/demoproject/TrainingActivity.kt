package com.example.demoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.ActivityTrainingBinding
import com.example.demoproject.models.TrainingApiResponse

class TrainingActivity : AppCompatActivity() {
    lateinit var dBinding:ActivityTrainingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_training)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val viewModel = ViewModelProvider(this).get(TrainingActivityViewModel::class.java)
        viewModel.getAllTrainings(applicationContext)
        viewModel.trainings.observe(this, Observer{
              generateTrainingCard(it)
        })
        viewModel.msg.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    private fun generateTrainingCard(trainingApiResponse: TrainingApiResponse)
    {
        val recyclerView = findViewById<RecyclerView>(R.id.training_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = TrainingAdapter(trainingApiResponse)

    }
}