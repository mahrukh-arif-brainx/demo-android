package com.example.demoproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.databinding.TrainingCardBinding
import com.example.demoproject.models.TrainingApiResponseItem

class TrainingAdapter(private val allTrainings:List<TrainingApiResponseItem>):RecyclerView.Adapter<TrainingViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val itemBinding=TrainingCardBinding.inflate(inflater,parent,false)
        return TrainingViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.bind(allTrainings[position])
    }

    override fun getItemCount(): Int {
        return allTrainings.size
    }

}
class TrainingViewHolder(private val binding:TrainingCardBinding) :RecyclerView.ViewHolder(binding.root){
   fun bind(item: TrainingApiResponseItem)
   {
      binding.trainingCard=item
   }
}