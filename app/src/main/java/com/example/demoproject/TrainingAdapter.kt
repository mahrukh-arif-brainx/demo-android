package com.example.demoproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.models.TrainingApiResponseItem

class TrainingAdapter(val trainingApiResponse:List<TrainingApiResponseItem>):RecyclerView.Adapter<TrainingViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.training_card,parent,false)
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
           holder.training_text.text=trainingApiResponse[position].title
    }

    override fun getItemCount(): Int {
        return trainingApiResponse.size

    }

}
class TrainingViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    val training_text=itemView.findViewById<TextView>(R.id.training_card_view_text)
    //val training_image=itemView.findViewById<ImageView>(R.id.card_video_icon)

}