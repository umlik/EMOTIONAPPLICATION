package com.example.emotionapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emotionapp.data.Emotion


class DataListAdapter(private val dataList: List<Emotion>) : RecyclerView.Adapter<DataListAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val dataEntity = dataList[position]
        holder.bind(dataEntity)
    }

    override fun getItemCount(): Int = dataList.size

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val emotionTypeTextView: TextView = itemView.findViewById(R.id.emotion_options)
        private val emotionDescriptionTextView: TextView = itemView.findViewById(R.id.textInput)

        fun bind(dataEntity: Emotion) {
            emotionTypeTextView.text = "Emotion Type: ${dataEntity.EmotionType}" // Customize the text as needed
            emotionDescriptionTextView.text = "Emotion Description: ${dataEntity.EmotionDisc}" // Customize the text as needed
        }
    }
}